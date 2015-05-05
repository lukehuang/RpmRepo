/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.yum.helper;

import javax.persistence.EntityManager;
import org.slf4j.LoggerFactory;
import ua.pp.msk.yum.RpmPackage;
import ua.pp.msk.yum.sqlite.primary.PrimarySqlite;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class Persister {

    private EntityManager primary, others, filelist;
    
    
    public Persister() {
    
        primary = PrimarySqlite.getEntityManger();
    }
    
    
public void persist(RpmPackage rpm){
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
            
}
    
    
    
}
