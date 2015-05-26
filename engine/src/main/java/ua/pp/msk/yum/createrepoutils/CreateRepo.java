/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.createrepoutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Set;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.pp.msk.yum.DirectoryScanner;
import ua.pp.msk.yum.YumPackage;
import ua.pp.msk.yum.internal.createrepo.YumStore;
import ua.pp.msk.yum.internal.RpmScanner;
import ua.pp.msk.yum.internal.createrepo.YumStoreFactory;
import ua.pp.msk.yum.internal.createrepo.YumStoreFactoryImpl;
import ua.pp.msk.yum.helper.DirSupport;
import ua.pp.msk.yum.persist.AbstractPersister;
import ua.pp.msk.yum.sqlite.SqlitePersister;
import ua.pp.msk.yum.sqlite.common.exceptions.PersistException;

/**
 *
 * @author maskimko
 */
public class CreateRepo {

    private static final String PATH_OF_REPODATA = "repodata";
    private File rpmDir;
    private File repoBaseDir;
    private RpmScanner scanner;
    private static final String REPO_TMP_FOLDER = "tmpRepodata";
    private Logger logger;
    private AbstractPersister p;

//    private static final Logger LOG = LoggerFactory.getLogger(CreateRepo.class);
    public CreateRepo(File rpmDir, File repoBaseDir) {
        this(rpmDir, repoBaseDir, new RpmScanner(new DirectoryScanner()));
    }

    public CreateRepo(File rpmDir, File repoBaseDir, RpmScanner scanner) {
        this.rpmDir = rpmDir;
        this.repoBaseDir = repoBaseDir;
        this.scanner = scanner;
        this.logger = LoggerFactory.getLogger(this.getClass());
        // p = SqlitePersister.getPersister(repoBaseDir.getAbsolutePath() + File.separator + PATH_OF_REPODATA);
    }

    public void setRpmDir(File rpmDir) {
        this.rpmDir = rpmDir;
    }

    public void setRepoBaseDir(File repoBaseDir) {
        this.repoBaseDir = repoBaseDir;
    }

    private String getRpmDir() {
        return rpmDir.getAbsolutePath();
    }

    private void syncYumPackages(final YumStore yumStore) {

        Set<File> files;

        if (true) {
            files = scanner.scan(rpmDir);
        }

        //TODO improve speed
//        else if (getAddedFiles() != null) {
//            String[] addedFiles = getAddedFiles().split(File.pathSeparator);
//            files = Sets.newHashSet();
//            for (String addedFile : addedFiles) {
//                files.add(new File(rpmDir, addedFile));
//            }
//        }
        if (files != null) {
            for (File file : files) {
                String location = RpmScanner.getRelativePath(rpmDir, file.getAbsoluteFile());
//                logger.debug("Got relative path for rpm file " + file.getAbsolutePath() + ": " + location);
                try {
                    YumPackage yumPackage = new YumPackageParser().parse(
                            new FileInputStream(file), location, file.lastModified()
                    );

                    logger.debug(new Formatter().format("Parsed RPM package: %10s %7s  %10s", yumPackage.getName(), yumPackage.getVersion(), yumPackage.getSummary()).toString());

                    yumStore.put(yumPackage);
                } catch (FileNotFoundException e) {
                    logger.warn("Could not parse yum metadata for {}", location, e);
                }
            }
        }
    }

    public void execute()
            throws Exception {

//        LOG.debug("Generating Yum-Repository for '{}' ...", getRpmDir());
        final File repoRepodataDir = new File(repoBaseDir, PATH_OF_REPODATA);
        final File repoTmpDir = new File(repoBaseDir, REPO_TMP_FOLDER + File.separator + UUID.randomUUID().toString());
        DirSupport.mkdir(repoTmpDir);
        final File repoTmpRepodataDir = new File(repoTmpDir, PATH_OF_REPODATA);
        p = SqlitePersister.getPersister(repoTmpRepodataDir);
        DirSupport.mkdir(repoTmpRepodataDir);
        YumStoreFactory ysf = new YumStoreFactoryImpl();
        YumStore yumStore = ysf.create("test");
        syncYumPackages(yumStore);
        logger.debug("Sync of yum packages has been finished");
        CreateYumRepository createRepo = null;

        createRepo = new CreateYumRepository(repoTmpRepodataDir, (int) (Calendar.getInstance().getTime().getTime() / 1000), null);
        for (YumPackage yumPackage : yumStore.get()) {
            try {
                createRepo.write(yumPackage);
                //TODO Move into yum store
                p.persist(yumPackage);
            } catch (PersistException ex) {
                logger.warn("Cannot persist metadata of rpm package ", ex);
            }
        }

        createRepo.close();
        DirSupport.deleteIfExists(repoRepodataDir);
        DirSupport.moveIfExists(repoTmpRepodataDir, repoRepodataDir);

    }

}
