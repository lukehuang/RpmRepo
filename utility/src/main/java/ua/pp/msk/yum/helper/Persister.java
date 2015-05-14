/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.slf4j.LoggerFactory;
import ua.pp.msk.yum.RpmPackage;
import ua.pp.msk.yum.sqlite.primary.PrimarySqlite;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class Persister implements AutoCloseable {

    private final EntityManager primary;
    private EntityManager others, filelist;
    private static Persister pr = null;

    public static Persister getPersister(String path) {
        synchronized (Persister.class) {
            if (pr == null) {
                synchronized (Persister.class) {
                    pr = new Persister(path);
                }
            }
        }
        return pr;
    }

    private Persister(String path) {

        primary = PrimarySqlite.getEntityManger(path);
    }

    public void persist(RpmPackage rpm) {
        EntityTransaction transaction = primary.getTransaction();
        transaction.begin();
        LoggerFactory.getLogger(this.getClass()).debug("Persisting primary part of " + rpm.getName());
        ua.pp.msk.yum.sqlite.primary.Packages primaryPkgs = new ua.pp.msk.yum.sqlite.primary.Packages();
        primaryPkgs.setArch(rpm.getArch());
        primaryPkgs.setChecksumType(rpm.getChecksumType());
        primaryPkgs.setConflicts1Collection(rpm.getConflictsCollection());
        primaryPkgs.setDescription(rpm.getDescription());
        primaryPkgs.setEnhances1Collection(rpm.getEnhancesCollection());
        primaryPkgs.setEpoch(rpm.getEpoch());
        primaryPkgs.setLocationBase(rpm.getLocationBase());
        primaryPkgs.setLocationHref(rpm.getLocationHref());
        primaryPkgs.setName(rpm.getName());
        primaryPkgs.setObsoletes1Collection(rpm.getObsoletesCollection());
        primaryPkgs.setPkgId(rpm.getPkgId());
        primaryPkgs.setPkgKey(rpm.getPkgKey());
        primaryPkgs.setProvides1Collection(rpm.getProvidesCollection());
        primaryPkgs.setRecommends1Collection(rpm.getRecommendsCollection());
        primaryPkgs.setRelease(rpm.getRelease());
        primaryPkgs.setRequires1Collection(rpm.getRequiresCollection());
        primaryPkgs.setRpmBuildhost(rpm.getRpmBuildhost());
        primaryPkgs.setRpmGroup(rpm.getRpmGroup());
        primaryPkgs.setRpmHeaderEnd(rpm.getRpmHeaderEnd());
        primaryPkgs.setRpmHeaderStart(rpm.getRpmHeaderStart());
        primaryPkgs.setRpmLicense(rpm.getRpmLicense());
        primaryPkgs.setRpmPackager(rpm.getRpmPackager());
        primaryPkgs.setRpmSourcerpm(rpm.getRpmSourcerpm());
        primaryPkgs.setRpmVendor(rpm.getRpmVendor());
        primaryPkgs.setSizeArchive(rpm.getSizeArchive());
        primaryPkgs.setSizeInstalled(rpm.getSizeInstalled());
        primaryPkgs.setSizePackage(rpm.getSizePackage());
        primaryPkgs.setSuggests1Collection(rpm.getSuggestsCollection());
        primaryPkgs.setSummary(rpm.getSummary());
        primaryPkgs.setSupplements1Collection(rpm.getSupplementsCollection());
        primaryPkgs.setTimeBuild(rpm.getTimeBuild());
        primaryPkgs.setTimeFile(rpm.getTimeFile());
        primaryPkgs.setUrl(rpm.getUrl());
        primaryPkgs.setVersion(rpm.getVersion());
        primary.persist(primaryPkgs);
        transaction.commit();

    }

    @Override
    public void close() throws Exception {
        LoggerFactory.getLogger(this.getClass()).info("Closing primary db");
        if (primary != null) {
            primary.close();
        }
        LoggerFactory.getLogger(this.getClass()).info("Closing filelists db");
        if (filelist != null) {
            filelist.close();
        }
        LoggerFactory.getLogger(this.getClass()).info("Closing others db");
        if (others != null) {
            others.close();
        }
    }

   

    public void ensurePath() {
        Map<String, Object> primaryProperties = primary.getProperties();
        for (Map.Entry<String, Object> p : primaryProperties.entrySet()) {
            LoggerFactory.getLogger(this.getClass()).debug("Primary property key: " + p.getKey() + " value: " + p.getValue());
        }
        String[] primaryUrlSplit;
        String[] filelistUrlSplit;
        String[] othersUrlSplit;

        try {
            if (primary != null) {
                primaryUrlSplit = primary.getProperties().get("javax.persistence.jdbc.url").toString().split(":");
                LoggerFactory.getLogger(this.getClass()).debug("Primary db path: " + primaryUrlSplit[primaryUrlSplit.length - 1]);
                PrimarySqlite.ensurePath(primaryUrlSplit[primaryUrlSplit.length - 1]);

            }
            //TODO use it later
//            if (filelist != null) {
//                filelistUrlSplit = filelist.getProperties().get("javax.persistence.jdbc.url").toString().split(":");
//                LoggerFactory.getLogger(this.getClass()).debug("FileList db path: " + filelistUrlSplit[filelistUrlSplit.length - 1]);
//                ensurePath(filelistUrlSplit[filelistUrlSplit.length - 1]);
//            }
//
//            if (others != null) {
//                othersUrlSplit = others.getProperties().get("javax.persistence.jdbc.url").toString().split(":");
//                LoggerFactory.getLogger(this.getClass()).debug("Others db path: " + othersUrlSplit[othersUrlSplit.length - 1]);
//                ensurePath(othersUrlSplit[othersUrlSplit.length - 1]);
//            }
        } catch (IOException ex) {
            LoggerFactory.getLogger(this.getClass()).error("Cannot create db directory", ex);
        }

//         Map<String, Object> primaryProperties = primary.getProperties();
//        for (Map.Entry<String,Object> p: primaryProperties.entrySet()){
//            LoggerFactory.getLogger(this.getClass()).debug("Primary property key: " + p.getKey() + " value: " + p.getValue());
//        }
    }

}
