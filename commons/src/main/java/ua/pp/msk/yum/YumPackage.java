/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ua.pp.msk.yum.sqlite.common.Changelog;
import ua.pp.msk.yum.sqlite.common.Conflicts;
import ua.pp.msk.yum.sqlite.common.Enhances;
import ua.pp.msk.yum.sqlite.common.Filelist;
import ua.pp.msk.yum.sqlite.common.Files;
import ua.pp.msk.yum.sqlite.common.Obsoletes;
import ua.pp.msk.yum.sqlite.common.Provides;
import ua.pp.msk.yum.sqlite.common.RPM;
import ua.pp.msk.yum.sqlite.common.Recommends;
import ua.pp.msk.yum.sqlite.common.Requires;
import ua.pp.msk.yum.sqlite.common.Suggests;
import ua.pp.msk.yum.sqlite.common.Supplements;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class YumPackage implements RPM {

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

    @Override
    public String getPkgId() {
        return pkgId;
    }

    @Override
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

    @Override
    public String getChecksumType() {
        return checksumType;
    }

    @Override
    public void setChecksumType(String checksumType) {
        this.checksumType = checksumType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getArch() {
        return arch;
    }

    @Override
    public void setArch(String arch) {
        this.arch = arch;
    }

    @Override
    public String getEpoch() {
        return epoch;
    }

    @Override
    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String getRelease() {
        return release;
    }

    @Override
    public void setRelease(String release) {
        this.release = release;
    }

    @Override
    public String getSummary() {
        return summary;
    }

    @Override
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Integer getTimeFile() {
        return timeFile;
    }

    @Override
    public void setTimeFile(Integer timeFile) {
        this.timeFile = timeFile;
    }

    @Override
    public Integer getTimeBuild() {
        return timeBuild;
    }

    @Override
    public void setTimeBuild(Integer timeBuild) {
        this.timeBuild = timeBuild;
    }

    @Override
    public String getRpmLicense() {
        return rpmLicense;
    }

    @Override
    public void setRpmLicense(String rpmLicense) {
        this.rpmLicense = rpmLicense;
    }

    @Override
    public String getRpmVendor() {
        return rpmVendor;
    }

    @Override
    public void setRpmVendor(String rpmVendor) {
        this.rpmVendor = rpmVendor;
    }

    @Override
    public String getRpmGroup() {
        return rpmGroup;
    }

    @Override
    public void setRpmGroup(String rpmGroup) {
        this.rpmGroup = rpmGroup;
    }

    public String getRpmBuildHost() {
        return rpmBuildHost;
    }

    @Override
    public void setRpmBuildHost(String rpmBuildHost) {
        this.rpmBuildHost = rpmBuildHost;
    }

    public String getRpmSourceRpm() {
        return rpmSourceRpm;
    }

    public void setRpmSourceRpm(String rpmSourceRpm) {
        this.rpmSourceRpm = rpmSourceRpm;
    }

    @Override
    public Integer getRpmHeaderStart() {
        return rpmHeaderStart;
    }

    @Override
    public void setRpmHeaderStart(Integer rpmHeaderStart) {
        this.rpmHeaderStart = rpmHeaderStart;
    }

    @Override
    public Integer getRpmHeaderEnd() {
        return rpmHeaderEnd;
    }

    @Override
    public void setRpmHeaderEnd(Integer rpmHeaderEnd) {
        this.rpmHeaderEnd = rpmHeaderEnd;
    }

    public String getPackager() {
        return packager;
    }

    public void setPackager(String packager) {
        this.packager = packager;
    }

    @Override
    public Integer getSizePackage() {
        return sizePackage;
    }

    @Override
    public void setSizePackage(Integer sizePackage) {
        this.sizePackage = sizePackage;
    }

    @Override
    public Integer getSizeInstalled() {
        return sizeInstalled;
    }

    @Override
    public void setSizeInstalled(Integer sizeInstalled) {
        this.sizeInstalled = sizeInstalled;
    }

    @Override
    public Integer getSizeArchive() {
        return sizeArchive;
    }

    @Override
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

    @Override
    public Collection<Changelog> getChangelogCollection() {
       ArrayList<Changelog> changes = new ArrayList<>();
        
       for (ChangeLog cl: getChanges()){
           changes.add(new Changelog() {
               
               ChangeLog()
               private final String author = cl.author;
               private final String text = cl.text;
               private int date = cl.date;
               
               @Override
               public String getChangelog() {
                   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               }

               @Override
               public int getPkgKey() {
                   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               }

               @Override
               public void setChangelog(String changelog) {
                   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               }

               @Override
               public void setPkgKey(int pkgKey) {
                   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               }
           });
       }
       
    }

    @Override
    public Collection<Conflicts> getConflictsCollection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Enhances> getEnhancesCollection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Filelist> getFilelistCollection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Files> getFilesCollection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLocationBase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLocationHref() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Obsoletes> getObsoletesCollection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getPkgKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Provides> getProvidesCollection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Recommends> getRecommendsCollection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Requires> getRequiresCollection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getRpmBuildhost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getRpmPackager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getRpmSourcerpm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Suggests> getSuggestsCollection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Supplements> getSupplementsCollection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setChangelogCollection(Collection<Changelog> changelogCollection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setConflictsCollection(Collection<Conflicts> conflictsCollection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEnhancesCollection(Collection<Enhances> enhancesCollection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFilelistCollection(Collection<Filelist> filelistCollection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFilesCollection(Collection<Files> filesCollection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLocationBase(String locationBase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLocationHref(String locationHref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setObsoletesCollection(Collection<Obsoletes> obsoletesCollection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPkgKey(Integer pkgKey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setProvidesCollection(Collection<Provides> providesCollection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRecommendsCollection(Collection<Recommends> recommendsCollection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRequiresCollection(Collection<Requires> requiresCollection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public void setRpmPackager(String rpmPackager) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRpmSourcerpm(String rpmSourcerpm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSuggestsCollection(Collection<Suggests> suggestsCollection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSupplementsCollection(Collection<Supplements> supplementsCollection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    
}
