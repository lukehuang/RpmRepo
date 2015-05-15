/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.common;

import java.io.Serializable;
import java.util.Collection;


/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public interface RPM extends Serializable {

    String getArch();

    Collection<Changelog> getChangelogCollection();

    String getChecksumType();

    Collection<Conflicts> getConflictsCollection();

    String getDescription();

    Collection<Enhances> getEnhancesCollection();

    String getEpoch();

    Collection<Filelist> getFilelistCollection();

    Collection<Files> getFilesCollection();

    String getLocationBase();

    String getLocationHref();

    String getName();

    Collection<Obsoletes> getObsoletesCollection();

    String getPkgId();

    Integer getPkgKey();

    Collection<Provides> getProvidesCollection();

    Collection<Recommends> getRecommendsCollection();

    String getRelease();

    Collection<Requires> getRequiresCollection();

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

    Collection<Suggests> getSuggestsCollection();

    String getSummary();

    Collection<Supplements> getSupplementsCollection();

    Integer getTimeBuild();

    Integer getTimeFile();

    String getUrl();

    String getVersion();

    void setArch(String arch);

    void setChangelogCollection(Collection<Changelog> changelogCollection);

    void setChecksumType(String checksumType);

    void setConflictsCollection(Collection<Conflicts> conflictsCollection);

    void setDescription(String description);

    void setEnhancesCollection(Collection<Enhances> enhancesCollection);

    void setEpoch(String epoch);

    void setFilelistCollection(Collection<Filelist> filelistCollection);

    void setFilesCollection(Collection<Files> filesCollection);

    void setLocationBase(String locationBase);

    void setLocationHref(String locationHref);

    void setName(String name);

    void setObsoletesCollection(Collection<Obsoletes> obsoletesCollection);

    void setPkgId(String pkgId);

    void setPkgKey(Integer pkgKey);

    void setProvidesCollection(Collection<Provides> providesCollection);

    void setRecommendsCollection(Collection<Recommends> recommendsCollection);

    void setRelease(String release);

    void setRequiresCollection(Collection<Requires> requiresCollection);

    void setRpmBuildHost(String rpmBuildhost);

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

    void setSuggestsCollection(Collection<Suggests> suggestsCollection);

    void setSummary(String summary);

    void setSupplementsCollection(Collection<Supplements> supplementsCollection);

    void setTimeBuild(Integer timeBuild);

    void setTimeFile(Integer timeFile);

    void setUrl(String url);

    void setVersion(String version);
    
}
