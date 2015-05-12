/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.primary;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
@Entity
@Table(name = "packages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Packages.findAll", query = "SELECT p FROM Packages p"),
    @NamedQuery(name = "Packages.findByPkgKey", query = "SELECT p FROM Packages p WHERE p.pkgKey = :pkgKey"),
    @NamedQuery(name = "Packages.findByPkgId", query = "SELECT p FROM Packages p WHERE p.pkgId = :pkgId")})
public class Packages implements Serializable {

   
    @Column(name = "name")
    private String name;
    @Column(name = "arch")
    private String arch;
    @Column(name = "version")
    private String version;
    @Column(name = "epoch")
    private String epoch;
    @Column(name = "release")
    private String release;
    @Column(name = "summary")
    private String summary;
    @Column(name = "description")
    private String description;
    @Column(name = "url")
    private String url;
    @Column(name = "time_file")
    private Integer timeFile;
    @Column(name = "time_build")
    private Integer timeBuild;
    @Column(name = "rpm_license")
    private String rpmLicense;
    @Column(name = "rpm_vendor")
    private String rpmVendor;
    @Column(name = "rpm_group")
    private String rpmGroup;
    @Column(name = "rpm_buildhost")
    private String rpmBuildhost;
    @Column(name = "rpm_sourcerpm")
    private String rpmSourcerpm;
    @Column(name = "rpm_header_start")
    private Integer rpmHeaderStart;
    @Column(name = "rpm_header_end")
    private Integer rpmHeaderEnd;
    @Column(name = "rpm_packager")
    private String rpmPackager;
    @Column(name = "size_package")
    private Integer sizePackage;
    @Column(name = "size_installed")
    private Integer sizeInstalled;
    @Column(name = "size_archive")
    private Integer sizeArchive;
    @Column(name = "location_href")
    private String locationHref;
    @Column(name = "location_base")
    private String locationBase;
    @Column(name = "checksum_type")
    private String checksumType;
    @OneToMany(mappedBy = "pkgKey", cascade = CascadeType.PERSIST)
    private Collection<Conflicts> conflictsCollection;
    @OneToMany(mappedBy = "pkgKey", cascade = CascadeType.PERSIST)
    private Collection<Obsoletes> obsoletesCollection;
    @OneToMany(mappedBy = "pkgKey", cascade = CascadeType.PERSIST)
    private Collection<Files> filesCollection;
    @OneToMany(mappedBy = "pkgKey", cascade = CascadeType.PERSIST)
    private Collection<Provides> providesCollection;
    @OneToMany(mappedBy = "pkgKey", cascade = CascadeType.PERSIST)
    private Collection<Suggests> suggestsCollection;
    @OneToMany(mappedBy = "pkgKey", cascade = CascadeType.PERSIST)
    private Collection<Enhances> enhancesCollection;
    @OneToMany(mappedBy = "pkgKey", cascade = CascadeType.PERSIST)
    private Collection<Requires> requiresCollection;
    @OneToMany(mappedBy = "pkgKey", cascade = CascadeType.PERSIST)
    private Collection<Supplements> supplementsCollection;
    @OneToMany(mappedBy = "pkgKey", cascade = CascadeType.PERSIST)
    private Collection<Recommends> recommendsCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "pkgKey")
    private Integer pkgKey;
    @Column(name = "pkgId")
    private String pkgId;
   

    public Packages() {
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

    @XmlTransient
    public Collection<Conflicts> getConflicts1Collection() {
        return conflictsCollection;
    }

    public void setConflicts1Collection(Collection<Conflicts> conflicts1Collection) {
        this.conflictsCollection = conflicts1Collection;
    }

    @XmlTransient
    public Collection<Obsoletes> getObsoletes1Collection() {
        return obsoletesCollection;
    }

    public void setObsoletes1Collection(Collection<Obsoletes> obsoletes1Collection) {
        this.obsoletesCollection = obsoletes1Collection;
    }

    @XmlTransient
    public Collection<Files> getFiles1Collection() {
        return filesCollection;
    }

    public void setFiles1Collection(Collection<Files> files1Collection) {
        this.filesCollection = files1Collection;
    }

    @XmlTransient
    public Collection<Provides> getProvides1Collection() {
        return providesCollection;
    }

    public void setProvides1Collection(Collection<Provides> provides1Collection) {
        this.providesCollection = provides1Collection;
    }

    @XmlTransient
    public Collection<Suggests> getSuggests1Collection() {
        return suggestsCollection;
    }

    public void setSuggests1Collection(Collection<Suggests> suggests1Collection) {
        this.suggestsCollection = suggests1Collection;
    }

    @XmlTransient
    public Collection<Enhances> getEnhances1Collection() {
        return enhancesCollection;
    }

    public void setEnhances1Collection(Collection<Enhances> enhances1Collection) {
        this.enhancesCollection = enhances1Collection;
    }

    @XmlTransient
    public Collection<Requires> getRequires1Collection() {
        return requiresCollection;
    }

    public void setRequires1Collection(Collection<Requires> requires1Collection) {
        this.requiresCollection = requires1Collection;
    }

    @XmlTransient
    public Collection<Supplements> getSupplements1Collection() {
        return supplementsCollection;
    }

    public void setSupplements1Collection(Collection<Supplements> supplements1Collection) {
        this.supplementsCollection = supplements1Collection;
    }

    @XmlTransient
    public Collection<Recommends> getRecommends1Collection() {
        return recommendsCollection;
    }

    public void setRecommends1Collection(Collection<Recommends> recommends1Collection) {
        this.recommendsCollection = recommends1Collection;
    }


}
