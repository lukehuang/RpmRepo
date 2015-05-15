/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.common;

import java.io.Serializable;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edem
 */
public interface Packages extends Serializable {

    String getArch();

    String getChecksumType();

    @XmlTransient
    Collection<ConflictsImpl> getConflicts1Collection();

    String getDescription();

    @XmlTransient
    Collection<EnhancesImpl> getEnhances1Collection();

    String getEpoch();

    @XmlTransient
    Collection<FilesImpl> getFiles1Collection();

    String getLocationBase();

    String getLocationHref();

    String getName();

    @XmlTransient
    Collection<ObsoletesImpl> getObsoletes1Collection();

    String getPkgId();

    Integer getPkgKey();

    @XmlTransient
    Collection<ProvidesImpl> getProvides1Collection();

    @XmlTransient
    Collection<RecommendsImpl> getRecommends1Collection();

    String getRelease();

    @XmlTransient
    Collection<RequiresImpl> getRequires1Collection();

    String getRpmBuildhost();

    String getRpmGroup();

    Integer getRpmHeaderEnd();

    Integer getRpmHeaderStart();

    String getRpmLicense();

    String getRpmPackager();

    String getRpmSourcerpm();

    String getRpmVendor();

    Integer getSizeArchive();

    Integer getSizeInstalled();

    Integer getSizePackage();

    @XmlTransient
    Collection<SuggestsImpl> getSuggests1Collection();

    String getSummary();

    @XmlTransient
    Collection<SupplementsImpl> getSupplements1Collection();

    Integer getTimeBuild();

    Integer getTimeFile();

    String getUrl();

    String getVersion();

    void setArch(String arch);

    void setChecksumType(String checksumType);

    void setConflicts1Collection(Collection<ConflictsImpl> conflicts1Collection);

    void setDescription(String description);

    void setEnhances1Collection(Collection<EnhancesImpl> enhances1Collection);

    void setEpoch(String epoch);

    void setFiles1Collection(Collection<FilesImpl> files1Collection);

    void setLocationBase(String locationBase);

    void setLocationHref(String locationHref);

    void setName(String name);

    void setObsoletes1Collection(Collection<ObsoletesImpl> obsoletes1Collection);

    void setPkgId(String pkgId);

    void setPkgKey(Integer pkgKey);

    void setProvides1Collection(Collection<ProvidesImpl> provides1Collection);

    void setRecommends1Collection(Collection<RecommendsImpl> recommends1Collection);

    void setRelease(String release);

    void setRequires1Collection(Collection<RequiresImpl> requires1Collection);

    void setRpmBuildhost(String rpmBuildhost);

    void setRpmGroup(String rpmGroup);

    void setRpmHeaderEnd(Integer rpmHeaderEnd);

    void setRpmHeaderStart(Integer rpmHeaderStart);

    void setRpmLicense(String rpmLicense);

    void setRpmPackager(String rpmPackager);

    void setRpmSourcerpm(String rpmSourcerpm);

    void setRpmVendor(String rpmVendor);

    void setSizeArchive(Integer sizeArchive);

    void setSizeInstalled(Integer sizeInstalled);

    void setSizePackage(Integer sizePackage);

    void setSuggests1Collection(Collection<SuggestsImpl> suggests1Collection);

    void setSummary(String summary);

    void setSupplements1Collection(Collection<SupplementsImpl> supplements1Collection);

    void setTimeBuild(Integer timeBuild);

    void setTimeFile(Integer timeFile);

    void setUrl(String url);

    void setVersion(String version);
    
}
