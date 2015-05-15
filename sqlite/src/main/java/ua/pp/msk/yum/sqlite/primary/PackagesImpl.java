/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.primary;

import java.io.Serializable;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */

@XmlRootElement
public class PackagesImpl implements Packages {

   
    
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
    private Collection<ConflictsImpl> conflictsCollection;
    private Collection<ObsoletesImpl> obsoletesCollection;
    private Collection<FilesImpl> filesCollection;
    private Collection<ProvidesImpl> providesCollection;
    private Collection<SuggestsImpl> suggestsCollection;
    private Collection<EnhancesImpl> enhancesCollection;
    private Collection<RequiresImpl> requiresCollection;
    private Collection<SupplementsImpl> supplementsCollection;
    private Collection<RecommendsImpl> recommendsCollection;
    private static final long serialVersionUID = 1L;
    private Integer pkgKey;
    private String pkgId;
   

    public PackagesImpl() {
    }

    @Override
    public Integer getPkgKey() {
        return pkgKey;
    }

    @Override
    public void setPkgKey(Integer pkgKey) {
        this.pkgKey = pkgKey;
    }

    @Override
    public String getPkgId() {
        return pkgId;
    }

    @Override
    public void setPkgId(String pkgId) {
        this.pkgId = pkgId;
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
    public String getVersion() {
        return version;
    }

    @Override
    public void setVersion(String version) {
        this.version = version;
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

    @Override
    public String getRpmBuildhost() {
        return rpmBuildhost;
    }

    @Override
    public void setRpmBuildhost(String rpmBuildhost) {
        this.rpmBuildhost = rpmBuildhost;
    }

    @Override
    public String getRpmSourcerpm() {
        return rpmSourcerpm;
    }

    @Override
    public void setRpmSourcerpm(String rpmSourcerpm) {
        this.rpmSourcerpm = rpmSourcerpm;
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

    @Override
    public String getRpmPackager() {
        return rpmPackager;
    }

    @Override
    public void setRpmPackager(String rpmPackager) {
        this.rpmPackager = rpmPackager;
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

    @Override
    public String getLocationHref() {
        return locationHref;
    }

    @Override
    public void setLocationHref(String locationHref) {
        this.locationHref = locationHref;
    }

    @Override
    public String getLocationBase() {
        return locationBase;
    }

    @Override
    public void setLocationBase(String locationBase) {
        this.locationBase = locationBase;
    }

    @Override
    public String getChecksumType() {
        return checksumType;
    }

    @Override
    public void setChecksumType(String checksumType) {
        this.checksumType = checksumType;
    }

    @XmlTransient
    @Override
    public Collection<ConflictsImpl> getConflicts1Collection() {
        return conflictsCollection;
    }

    @Override
    public void setConflicts1Collection(Collection<ConflictsImpl> conflicts1Collection) {
        this.conflictsCollection = conflicts1Collection;
    }

    @XmlTransient
    @Override
    public Collection<ObsoletesImpl> getObsoletes1Collection() {
        return obsoletesCollection;
    }

    @Override
    public void setObsoletes1Collection(Collection<ObsoletesImpl> obsoletes1Collection) {
        this.obsoletesCollection = obsoletes1Collection;
    }

    @XmlTransient
    @Override
    public Collection<FilesImpl> getFiles1Collection() {
        return filesCollection;
    }

    @Override
    public void setFiles1Collection(Collection<FilesImpl> files1Collection) {
        this.filesCollection = files1Collection;
    }

    @XmlTransient
    @Override
    public Collection<ProvidesImpl> getProvides1Collection() {
        return providesCollection;
    }

    @Override
    public void setProvides1Collection(Collection<ProvidesImpl> provides1Collection) {
        this.providesCollection = provides1Collection;
    }

    @XmlTransient
    @Override
    public Collection<SuggestsImpl> getSuggests1Collection() {
        return suggestsCollection;
    }

    @Override
    public void setSuggests1Collection(Collection<SuggestsImpl> suggests1Collection) {
        this.suggestsCollection = suggests1Collection;
    }

    @XmlTransient
    @Override
    public Collection<EnhancesImpl> getEnhances1Collection() {
        return enhancesCollection;
    }

    @Override
    public void setEnhances1Collection(Collection<EnhancesImpl> enhances1Collection) {
        this.enhancesCollection = enhances1Collection;
    }

    @XmlTransient
    @Override
    public Collection<RequiresImpl> getRequires1Collection() {
        return requiresCollection;
    }

    @Override
    public void setRequires1Collection(Collection<RequiresImpl> requires1Collection) {
        this.requiresCollection = requires1Collection;
    }

    @XmlTransient
    @Override
    public Collection<SupplementsImpl> getSupplements1Collection() {
        return supplementsCollection;
    }

    @Override
    public void setSupplements1Collection(Collection<SupplementsImpl> supplements1Collection) {
        this.supplementsCollection = supplements1Collection;
    }

    @XmlTransient
    @Override
    public Collection<RecommendsImpl> getRecommends1Collection() {
        return recommendsCollection;
    }

    @Override
    public void setRecommends1Collection(Collection<RecommendsImpl> recommends1Collection) {
        this.recommendsCollection = recommends1Collection;
    }


}
