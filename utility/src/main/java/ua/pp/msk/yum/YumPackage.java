/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.slf4j.LoggerFactory;
import ua.pp.msk.yum.sqlite.common.AbstractEntry;
import ua.pp.msk.yum.sqlite.other.Changelog;
import ua.pp.msk.yum.sqlite.other.ChangelogPK;
import ua.pp.msk.yum.sqlite.primary.Conflicts;
import ua.pp.msk.yum.sqlite.primary.Files;
import ua.pp.msk.yum.sqlite.primary.Obsoletes;
import ua.pp.msk.yum.sqlite.primary.Provides;
import ua.pp.msk.yum.sqlite.primary.Requires;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class YumPackage {

    private String pkgId;
    private String location;
    private String checksum;
    private String checksumType;
    private String name;
    private String arch;
    private String epoch;
    private String version;
    private String release;
    private String summary;
    private String description;
    private String url;
    private Integer timeFile;
    private Integer timeBuild;
    private String rpmLicense;
    private String rpmVendor;
    private String rpmGroup;
    private String rpmBuildHost;
    private String rpmSourceRpm;
    private Integer rpmHeaderStart;
    private Integer rpmHeaderEnd;
    private String packager;
    private Integer sizePackage;
    private Integer sizeInstalled;
    private Integer sizeArchive;

    private List<Entry> provides;
    private List<Entry> requires;
    private List<Entry> conflicts;
    private List<Entry> obsoletes;

    private List<File> files;
    private List<ChangeLog> changes;

    public String getUniqueId() {
        return name + ":" + epoch + ":" + version + ":" + release;
    }

    public String getPkgId() {
        return pkgId;
    }

    public void setPkgId(String pkgId) {
        this.pkgId = pkgId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public String getChecksumType() {
        return checksumType;
    }

    public void setChecksumType(String checksumType) {
        this.checksumType = checksumType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArch() {
        return arch;
    }

    public void setArch(String arch) {
        this.arch = arch;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getTimeFile() {
        return timeFile;
    }

    public void setTimeFile(Integer timeFile) {
        this.timeFile = timeFile;
    }

    public Integer getTimeBuild() {
        return timeBuild;
    }

    public void setTimeBuild(Integer timeBuild) {
        this.timeBuild = timeBuild;
    }

    public String getRpmLicense() {
        return rpmLicense;
    }

    public void setRpmLicense(String rpmLicense) {
        this.rpmLicense = rpmLicense;
    }

    public String getRpmVendor() {
        return rpmVendor;
    }

    public void setRpmVendor(String rpmVendor) {
        this.rpmVendor = rpmVendor;
    }

    public String getRpmGroup() {
        return rpmGroup;
    }

    public void setRpmGroup(String rpmGroup) {
        this.rpmGroup = rpmGroup;
    }

    public String getRpmBuildHost() {
        return rpmBuildHost;
    }

    public void setRpmBuildHost(String rpmBuildHost) {
        this.rpmBuildHost = rpmBuildHost;
    }

    public String getRpmSourceRpm() {
        return rpmSourceRpm;
    }

    public void setRpmSourceRpm(String rpmSourceRpm) {
        this.rpmSourceRpm = rpmSourceRpm;
    }

    public Integer getRpmHeaderStart() {
        return rpmHeaderStart;
    }

    public void setRpmHeaderStart(Integer rpmHeaderStart) {
        this.rpmHeaderStart = rpmHeaderStart;
    }

    public Integer getRpmHeaderEnd() {
        return rpmHeaderEnd;
    }

    public void setRpmHeaderEnd(Integer rpmHeaderEnd) {
        this.rpmHeaderEnd = rpmHeaderEnd;
    }

    public String getPackager() {
        return packager;
    }

    public void setPackager(String packager) {
        this.packager = packager;
    }

    public Integer getSizePackage() {
        return sizePackage;
    }

    public void setSizePackage(Integer sizePackage) {
        this.sizePackage = sizePackage;
    }

    public Integer getSizeInstalled() {
        return sizeInstalled;
    }

    public void setSizeInstalled(Integer sizeInstalled) {
        this.sizeInstalled = sizeInstalled;
    }

    public Integer getSizeArchive() {
        return sizeArchive;
    }

    public void setSizeArchive(Integer sizeArchive) {
        this.sizeArchive = sizeArchive;
    }

    public List<Entry> getProvides() {
        return provides;
    }

    public void setProvides(List<Entry> provides) {
        this.provides = provides;
    }

    public List<Entry> getRequires() {
        return requires;
    }

    public void setRequires(List<Entry> requires) {
        this.requires = requires;
    }

    public List<Entry> getConflicts() {
        return conflicts;
    }

    public void setConflicts(List<Entry> conflicts) {
        this.conflicts = conflicts;
    }

    public List<Entry> getObsoletes() {
        return obsoletes;
    }

    public void setObsoletes(List<Entry> obsoletes) {
        this.obsoletes = obsoletes;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public List<ChangeLog> getChanges() {
        return changes;
    }

    public void setChanges(List<ChangeLog> changes) {
        this.changes = changes;
    }

    public static class Entry {

        String name;
        String flags;
        String epoch;
        String version;
        String release;
        boolean pre;

        @Override
        public String toString() {
            return "Entry{" + "name=" + name + ", flags=" + flags + ", epoch=" + epoch + ", version=" + version + ", release=" + release + ", pre=" + pre + '}';
        }

    }

    public static class File {

        String name;
        FileType type;
        boolean primary;

        @Override
        public String toString() {
            return "File{" + "name=" + name + ", type=" + type + ", primary=" + primary + '}';
        }

    }

    public static enum FileType {

        file, dir, ghost
    }

    public static class ChangeLog {

        String author;
        Integer date;
        String text;

        @Override
        public String toString() {
            return "ChangeLog{" + "author=" + author + ", date=" + date + ", text=" + text + '}';
        }

    }

    public RpmPackage getRpmPackage() {

        RpmPackage rp = new RpmPackage();

        rp.setName(name);

        rp.setArch(arch);

        rp.setVersion(version);

        rp.setEpoch(epoch);

        rp.setRelease(release);

        rp.setSummary(summary);

        rp.setDescription(description);

        rp.setUrl(url);

        rp.setTimeFile(timeFile);

        rp.setTimeBuild(timeBuild);

        rp.setRpmLicense(rpmLicense);

        rp.setRpmVendor(rpmVendor);

        rp.setRpmGroup(rpmGroup);

        rp.setRpmBuildhost(rpmBuildHost);

        rp.setRpmSourcerpm(null);

        rp.setRpmHeaderStart(rpmHeaderStart);

        rp.setRpmHeaderEnd(rpmHeaderEnd);

        rp.setRpmPackager(packager);

        rp.setSizePackage(sizePackage);

        rp.setSizeArchive(sizeArchive);

        rp.setSizeInstalled(sizeInstalled);

        rp.setChecksumType(checksumType);

        rp.setPkgId(pkgId);

        if (files != null) {
        Iterator<File> fileIterator = files.iterator();

        ArrayList<Files> rpmFiles = new ArrayList<>();

        while (fileIterator.hasNext()) {

            File fl = fileIterator.next();

            Files fls = new Files(fl.name);

            fls.setType(fl.type.toString());

            rpmFiles.add(fls);

        }
        
        rp.setFilesCollection(rpmFiles);
        } else {
            LoggerFactory.getLogger(this.getClass()).warn("RPM package " + this.getName() + " contains no files!");
            rp.setFilesCollection(null);
            //TODO make filelists initialization
        }

        //location_base is usually null value
        rp.setLocationBase(null);

        rp.setLocationHref(location);

        if (changes != null){
        Iterator<ChangeLog> clIterator = changes.iterator();

        ArrayList<Changelog> rpmChangeLog = new ArrayList<>();

        while (clIterator.hasNext()) {

            Changelog chlg = new Changelog();

            ChangeLog cl = clIterator.next();

            chlg.setChangelogPK(new ChangelogPK(cl.author, cl.date));

            chlg.setChangelog(cl.text);

            rpmChangeLog.add(chlg);

        }

        rp.setChangelogCollection(rpmChangeLog);
        } else {
            rp.setChangelogCollection(null);
        }

        rp.setConflictsCollection(convert(conflicts, Conflicts.class));

        rp.setObsoletesCollection(convert(obsoletes, Obsoletes.class));

        rp.setProvidesCollection(convert(provides, Provides.class));

        rp.setRequiresCollection(convert(requires, Requires.class));

        return rp;
    }

//        this.suggestsCollection = null;
//        this.enhancesCollection = null;
//        this.supplementsCollection = null;
//        this.recommendsCollection = null;
//        this.filelistCollection = null;
    private <T extends AbstractEntry> Collection<T> convert(List<Entry> entries, Class<T> c) {
        if (entries == null){
             LoggerFactory.getLogger(this.getClass()).warn("Null value "+c.getCanonicalName()+" collection " );
            return null;
        }
        Collection<T> rpmEntries = null;
        try {
            rpmEntries = new ArrayList<>();
            for (Entry cnfl : entries) {
               if (cnfl == null) {
                   LoggerFactory.getLogger(this.getClass()).warn("Null value "+c.getCanonicalName()+" entry in " + this.getName());
               }
                T e = c.newInstance();

                e.setEpoch(cnfl.epoch);

                e.setFlags(cnfl.flags);

                e.setName(cnfl.name);

                e.setRelease(cnfl.release);

                e.setVersion(cnfl.version);

                rpmEntries.add(e);
            }
        } catch (InstantiationException ex) {
            LoggerFactory.getLogger(this.getClass()).error("Cannot instantiate class ", ex);
        } catch (IllegalAccessException ex) {
            LoggerFactory.getLogger(this.getClass()).error("Cannot access class ", ex);
        }
        return rpmEntries;
    }
}
