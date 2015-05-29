/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.LoggerFactory;
import ua.pp.msk.yum.persist.GeneralEntry;
import ua.pp.msk.yum.sqlite.common.Changelog;
import ua.pp.msk.yum.sqlite.common.Conflicts;
import ua.pp.msk.yum.sqlite.common.Enhances;
import ua.pp.msk.yum.sqlite.common.Entry;
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
    private int timeFile;
    private int timeBuild;
    private String rpmLicense;
    private String rpmVendor;
    private String rpmGroup;
    private String rpmBuildHost;
    private String rpmSourceRpm;
    private int rpmHeaderStart;
    private int rpmHeaderEnd;
    private String packager;
    private int sizePackage;
    private int sizeInstalled;
    private int sizeArchive;
    private int pkgKey = -1;
   

    private List<PackageEntry> provides;
    private List<RequiresPackageEntry> requires;
    private List<PackageEntry> conflicts;
    private List<PackageEntry> obsoletes;

    private List<File> files;
    private List<ChangeLog> changes;

    private final static String DATE_FORMAT = "EEE MMM dd yyyy";

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

    public List<PackageEntry> getProvides() {
        return provides;
    }

    public void setProvides(List<PackageEntry> provides) {
        this.provides = provides;
    }

    public List<RequiresPackageEntry> getRequires() {
        return requires;
    }

    public void setRequires(List<RequiresPackageEntry> requires) {
        this.requires = requires;
    }

    public List<PackageEntry> getConflicts() {
        return conflicts;
    }

    public void setConflicts(List<PackageEntry> conflicts) {
        this.conflicts = conflicts;
    }

    public List<PackageEntry> getObsoletes() {
        return obsoletes;
    }

    public void setObsoletes(List<PackageEntry> obsoletes) {
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
    

    private <T extends Entry> T transform(Class<T> c, final Entry e) {
        T t = null;
        try {
            t = c.newInstance();
            t.setEpoch(((e.getEpoch() == null) ? "0" : e.getEpoch()));
            t.setFlags(e.getFlags());
            t.setName(e.getName());
            t.setRelease(e.getRelease());
            t.setVersion(e.getVersion());

        } catch (InstantiationException ex) {
            LoggerFactory.getLogger(this.getClass()).warn("Cannot instantiate class " + c.getCanonicalName(), ex);
        } catch (IllegalAccessException ex) {
            LoggerFactory.getLogger(this.getClass()).warn("Have no access to instantiate class " + c.getCanonicalName(), ex);
        }
        return t;
    }

    @Override
    public Collection<Changelog> getChangelogCollection() {
        ArrayList<Changelog> changes = new ArrayList<>();
        //TODO Check Null value
        if (getChanges() != null && !getChanges().isEmpty()) {
            for (ChangeLog cl : getChanges()) {
                changes.add(cl);
            }
        }
        return changes;
    }

    @Override
    public Collection<Conflicts> getConflictsCollection() {

        ArrayList<Conflicts> conflicts = new ArrayList<>();
        if (getConflicts() == null) {
            return conflicts;
        }
        for (PackageEntry pe : getConflicts()) {
            conflicts.add(transform(GeneralEntry.class, pe));
        }
        return conflicts;
    }

    @Override
    public Collection<Enhances> getEnhancesCollection() {
        return new ArrayList<>();
    }

    @Override
    public Collection<Filelist> getFilelistCollection() {
        Collection<Filelist> filesCollection = new LinkedList<>();
        List<File> files1 = getFiles();
        filesCollection.addAll(files1);
        return filesCollection;
    }

    @Override
    public Collection<Files> getFilesCollection() {
        Collection<Files> result = new LinkedList<>();
        List<File> fls = getFiles();
        result.addAll(fls);
        return result;

    }

    @Override
    public String getLocationBase() {
        LoggerFactory.getLogger(this.getClass()).warn("Trying to get value from dummy filed locationBase in " + this.getClass().getCanonicalName());
        return "";
    }

    @Override
    public String getLocationHref() {
        return location;
    }

    @Override
    public Collection<Obsoletes> getObsoletesCollection() {
        ArrayList<Obsoletes> obsoletes = new ArrayList<>();
        if (getObsoletes() == null) {
            return obsoletes;
        }
        for (PackageEntry pe : getObsoletes()) {
            obsoletes.add(transform(GeneralEntry.class, pe));
        }
        return obsoletes;
    }

    @Override
    public Integer getPkgKey() {
        return pkgKey;
    }

    @Override
    public Collection<Provides> getProvidesCollection() {

        ArrayList<Provides> provides = new ArrayList<>();
        if (getProvides() == null) {
            return provides;
        }
        for (PackageEntry pe : getProvides()) {
            provides.add(transform(GeneralEntry.class, pe));
        }
        return provides;
    }

    @Override
    public Collection<Recommends> getRecommendsCollection() {

        return new ArrayList<>();
    }

    @Override
    public Collection<Requires> getRequiresCollection() {
        ArrayList<Requires> requires = new ArrayList<>();
        for (RequiresPackageEntry rpe : getRequires()) {
            Requires r = transform(GeneralEntry.class, rpe);
            r.setPre(rpe.getPre());
            requires.add(r);
        }
        return requires;
    }

    @Override
    public String getRpmBuildhost() {
        LoggerFactory.getLogger(this.getClass()).warn("Trying to get value from dummy filed rpmBuildHost in " + this.getClass().getCanonicalName());
        return "";
    }

    @Override
    public String getRpmPackager() {
        LoggerFactory.getLogger(this.getClass()).warn("Trying to get value from dummy filed rpmPackager in " + this.getClass().getCanonicalName());
        return "";
    }

    @Override
    public String getRpmSourcerpm() {
        LoggerFactory.getLogger(this.getClass()).warn("Trying to get value from dummy filed sourceRpm in " + this.getClass().getCanonicalName());
        return "";
    }

    @Override
    public Collection<Suggests> getSuggestsCollection() {
        LoggerFactory.getLogger(this.getClass()).warn("Trying to get value from dummy filed suggestsCollection in " + this.getClass().getCanonicalName() + " Will return -1");
        return new ArrayList<>();
    }

    @Override
    public Collection<Supplements> getSupplementsCollection() {
        LoggerFactory.getLogger(this.getClass()).warn("Trying to get value from dummy filed supplements in " + this.getClass().getCanonicalName() + " Will return -1");
        return new ArrayList<>();
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
        if (pkgKey > 0) {
            this.pkgKey = pkgKey;
        }
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


    public static class PackageEntry implements Entry {

        String name;
        String flags;
        String epoch;
        String version;
        String release;

        @Override
        public String toString() {
            return "Entry{" + "name=" + name + ", flags=" + flags + ", epoch=" + epoch + ", version=" + version + ", release=" + release + '}';
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
        public String getFlags() {
            return flags;
        }

        @Override
        public void setFlags(String flags) {
            this.flags = flags;
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

    }

    public static class RequiresPackageEntry extends PackageEntry implements Entry {

        boolean pre;

        @Override
        public String toString() {
            return "RequiresPackageEntry{" + "name=" + name + ", flags=" + flags + ", epoch=" + epoch + ", version=" + version + ", release=" + release + ", pre=" + pre + '}';
        }

        public boolean getPre() {
            return pre;
        }

        public void setPre(boolean pre) {
            this.pre = pre;
        }

    }

    public static class File implements Files, Filelist {

        String name;
        FileType type;
        boolean primary;

        @Override
        public String toString() {
            return "File{" + "name=" + name + ", type=" + type + ", primary=" + primary + '}';
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public int getPkgKey() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getType() {
            return type.toString();
        }

        @Override
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public void setPkgKey(int pkgKey) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setType(String type) {
            if (type.equals(FileType.dir.toString())) {
                this.type = FileType.dir;
            } else if (type.equals(FileType.file.toString())) {
                this.type = FileType.file;
            } else if (type.equals(FileType.ghost.toString())) {
                this.type = FileType.ghost;
            } else {
                LoggerFactory.getLogger(this.getClass()).warn("Cannot assign such file type " + type + " will use default " + FileType.file.toString());
            }

        }

        @Override
        public String getDirname() {
            LoggerFactory.getLogger(this.getClass()).warn("Trying to get value from dummy filed dirname in " + this.getClass().getCanonicalName());
            //TODO must be implemented later
            return "Fake dirname";
        }

        @Override
        public String getFilenames() {
            LoggerFactory.getLogger(this.getClass()).warn("Trying to get value from dummy filed filenames in " + this.getClass().getCanonicalName());
            //TODO must be implemented later
            return "Fake filenames";
        }

        @Override
        public String getFiletypes() {
            LoggerFactory.getLogger(this.getClass()).warn("Trying to get value from dummy filed filetypes in " + this.getClass().getCanonicalName());
            //TODO must be implemented later
            return "Fake Filetype";
        }

        @Override
        public void setDirname(String dirname) {
            LoggerFactory.getLogger(this.getClass()).warn("Trying to assign value " + dirname + " to  dummy filed dirname in " + this.getClass().getCanonicalName());

        }

        @Override
        public void setFilenames(String filenames) {
            LoggerFactory.getLogger(this.getClass()).warn("Trying to assign value " + filenames + " to  dummy filed dirname in " + this.getClass().getCanonicalName());
        }

        @Override
        public void setFiletypes(String filetypes) {
            LoggerFactory.getLogger(this.getClass()).warn("Trying to assign value " + filetypes + " to  dummy filed dirname in " + this.getClass().getCanonicalName());
        }

    }

    public static enum FileType {

        file, dir, ghost
    }

    public static class ChangeLog implements Changelog {

        String author;
        Integer date;
        String text;

        @Override
        public String toString() {
            return "ChangeLog{" + "author=" + author + ", date=" + date + ", text=" + text + '}';
        }

        @Override
        public String getChangelog() {
            StringBuilder sb = new StringBuilder();
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            sb.append(df.format(new Date(((long) date) * 1000))).append(" ").append(author).append(" -").append(text);
            return sb.toString();

        }

        @Override
        public int getPkgKey() {
            LoggerFactory.getLogger(this.getClass()).warn("Trying to get value from dummy filed pkgKey in " + this.getClass().getCanonicalName() + " Will return -1");
            return -1;
        }

        @Override
        public void setChangelog(String changelog) {
            if (changelog != null && !changelog.isEmpty()) {
                String[] firstLineElements = changelog.split("- ")[0].replaceAll("\\n", "").replaceAll("\\r", "").split(" ");
                if (firstLineElements.length < 5) {
                    LoggerFactory.getLogger(this.getClass()).warn("Cannot parse first line of change log: " + Arrays.toString(firstLineElements));
                    date = 0;
                    author = "";
                    text = changelog;

                } else {
                    DateFormat df = new SimpleDateFormat(DATE_FORMAT);
                    String composedDate = firstLineElements[0] + " " + firstLineElements[1] + " " + firstLineElements[2] + " " + firstLineElements[3];
                    Date parsedDate = null;
                    try {
                        parsedDate = df.parse(composedDate);
                    } catch (ParseException ex) {
                        LoggerFactory.getLogger(this.getClass()).warn("Cannot parse composed date. Using current date ");
                        parsedDate = Calendar.getInstance().getTime();
                    }
                    date = (int) parsedDate.getTime() / 1000;

                    StringBuilder sb = new StringBuilder(firstLineElements[4]);
                    for (int i = 5; i < firstLineElements.length; i++) {
                        sb.append(" ").append(firstLineElements[i]);
                    }
                    author = sb.toString();
                    //TODO fix it in future
                    text = changelog;

                }
            }

        }

        @Override
        public void setPkgKey(int pkgKey) {
            LoggerFactory.getLogger(this.getClass()).warn("Trying to assign value " + pkgKey + " to dummy filed pkgKey in " + this.getClass().getCanonicalName());
        }

        @Override
        public String getAuthor() {
            return author;
        }

        @Override
        public void setAuthor(String author) {
            this.author = author;
        }

        @Override
        public Date getDateAsDate() {
            Date d = new Date(date * 1000);
            return d;
        }

        @Override
        public void setDate(Integer date) {
            this.date = date;
        }

        @Override
        public String getText() {
            return text;
        }

        @Override
        public void setText(String text) {
            this.text = text;
        }

        @Override
        public void setDate(Date date) {
            this.date = (int) date.getTime() / 1000;
        }

        @Override
        public Integer getDate() {
            return date;
        }

    }

}
