/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite;

import java.io.Serializable;
import java.util.Collection;
import ua.pp.msk.yum.sqlite.filelist.Filelist;
import ua.pp.msk.yum.sqlite.other.Changelog;
import ua.pp.msk.yum.sqlite.primary.Conflicts;
import ua.pp.msk.yum.sqlite.primary.Enhances;
import ua.pp.msk.yum.sqlite.primary.Files;
import ua.pp.msk.yum.sqlite.primary.Obsoletes;
import ua.pp.msk.yum.sqlite.primary.Provides;
import ua.pp.msk.yum.sqlite.primary.Recommends;
import ua.pp.msk.yum.sqlite.primary.Requires;
import ua.pp.msk.yum.sqlite.primary.Suggests;
import ua.pp.msk.yum.sqlite.primary.Supplements;
/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */

public class RpmPackage implements Serializable {

    private Collection<Changelog> changelogCollection;
    private String name;
    private String arch;
    private String version;
    private String epoch;
    private String release;
    private String summary;
    private String description;
    private String url;
    private Integer timeFile;
    private Integer timeBuild;
    private String rpmLicense;
    private String rpmVendor;
    private String rpmGroup;
    private String rpmBuildhost;
    private String rpmSourcerpm;
    private Integer rpmHeaderStart;
    private Integer rpmHeaderEnd;
    private String rpmPackager;
    private Integer sizePackage;
    private Integer sizeInstalled;
    private Integer sizeArchive;
    private String locationHref;
    private String locationBase;
    private String checksumType;
    private Collection<Conflicts> conflictsCollection;
    private Collection<Obsoletes> obsoletesCollection;
    private Collection<Files> filesCollection;
    private Collection<Provides> providesCollection;
    private Collection<Suggests> suggestsCollection;
    private Collection<Enhances> enhancesCollection;
    private Collection<Requires> requiresCollection;
    private Collection<Supplements> supplementsCollection;
    private Collection<Recommends> recommendsCollection;
    private static final long serialVersionUID = 1L;
    private Integer pkgKey;
    private String pkgId;
    private Collection<Filelist> filelistCollection;

    public RpmPackage() {
    }

  
    
    
    
    public Integer getPkgKey() {
        return pkgKey;
    }

    public void setPkgKey(Integer pkgKey) {
        this.pkgKey = pkgKey;
    }

    public String getPkgId() {
        return pkgId;
    }

    public void setPkgId(String pkgId) {
        this.pkgId = pkgId;
    }

    public Collection<Filelist> getFilelistCollection() {
        return filelistCollection;
    }

    public void setFilelistCollection(Collection<Filelist> filelistCollection) {
        this.filelistCollection = filelistCollection;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
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

    public String getRpmBuildhost() {
        return rpmBuildhost;
    }

    public void setRpmBuildhost(String rpmBuildhost) {
        this.rpmBuildhost = rpmBuildhost;
    }

    public String getRpmSourcerpm() {
        return rpmSourcerpm;
    }

    public void setRpmSourcerpm(String rpmSourcerpm) {
        this.rpmSourcerpm = rpmSourcerpm;
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

    public String getRpmPackager() {
        return rpmPackager;
    }

    public void setRpmPackager(String rpmPackager) {
        this.rpmPackager = rpmPackager;
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

    public String getLocationHref() {
        return locationHref;
    }

    public void setLocationHref(String locationHref) {
        this.locationHref = locationHref;
    }

    public String getLocationBase() {
        return locationBase;
    }

    public void setLocationBase(String locationBase) {
        this.locationBase = locationBase;
    }

    public String getChecksumType() {
        return checksumType;
    }

    public void setChecksumType(String checksumType) {
        this.checksumType = checksumType;
    }

    public Collection<Conflicts> getConflictsCollection() {
        return conflictsCollection;
    }

    public void setConflictsCollection(Collection<Conflicts> conflictsCollection) {
        this.conflictsCollection = conflictsCollection;
    }

    public Collection<Obsoletes> getObsoletesCollection() {
        return obsoletesCollection;
    }

    public void setObsoletesCollection(Collection<Obsoletes> obsoletesCollection) {
        this.obsoletesCollection = obsoletesCollection;
    }

    public Collection<Files> getFilesCollection() {
        return filesCollection;
    }

    public void setFilesCollection(Collection<Files> filesCollection) {
        this.filesCollection = filesCollection;
    }

    public Collection<Provides> getProvidesCollection() {
        return providesCollection;
    }

    public void setProvidesCollection(Collection<Provides> providesCollection) {
        this.providesCollection = providesCollection;
    }

    public Collection<Suggests> getSuggestsCollection() {
        return suggestsCollection;
    }

    public void setSuggestsCollection(Collection<Suggests> suggestsCollection) {
        this.suggestsCollection = suggestsCollection;
    }

    public Collection<Enhances> getEnhancesCollection() {
        return enhancesCollection;
    }

    public void setEnhancesCollection(Collection<Enhances> enhancesCollection) {
        this.enhancesCollection = enhancesCollection;
    }

    public Collection<Requires> getRequiresCollection() {
        return requiresCollection;
    }

    public void setRequiresCollection(Collection<Requires> requiresCollection) {
        this.requiresCollection = requiresCollection;
    }

    public Collection<Supplements> getSupplementsCollection() {
        return supplementsCollection;
    }

    public void setSupplementsCollection(Collection<Supplements> supplementsCollection) {
        this.supplementsCollection = supplementsCollection;
    }

    public Collection<Recommends> getRecommendsCollection() {
        return recommendsCollection;
    }

    public void setRecommendsCollection(Collection<Recommends> recommendsCollection) {
        this.recommendsCollection = recommendsCollection;
    }

    public Collection<Changelog> getChangelogCollection() {
        return changelogCollection;
    }

    public void setChangelogCollection(Collection<Changelog> changelogCollection) {
        this.changelogCollection = changelogCollection;
    }

}
