/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2008-2015 Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package ua.pp.msk.yum.createrepoutils;

import groovy.transform.ToString
import ua.pp.msk.yum.sqlite.other.Changelog
import ua.pp.msk.yum.sqlite.primary.Conflicts
import ua.pp.msk.yum.sqlite.primary.Files
import ua.pp.msk.yum.sqlite.primary.Obsoletes

/**
 * Yum package metadata.
 *
 * @since 3.0
 */
@ToString(includePackage = false, includeNames = true)
public class YumPackage
{

  String pkgId
  String location
  String checksum
  String checksumType
  String name
  String arch
  String epoch
  String version
  String release
  String summary
  String description
  String url
  Integer timeFile
  Integer timeBuild
  String rpmLicense
  String rpmVendor
  String rpmGroup
  String rpmBuildHost
  String rpmSourceRpm
  Integer rpmHeaderStart
  Integer rpmHeaderEnd
  String packager
  Integer sizePackage
  Integer sizeInstalled
  Integer sizeArchive

  List<Entry> provides
  List<Entry> requires
  List<Entry> conflicts
  List<Entry> obsoletes

  List<File> files
  List<ChangeLog> changes

  String getUniqueId() {
    return "${name}:${epoch}:${version}:${release}"
  }

  @ToString(includePackage = false, includeNames = true)
  static class Entry
  {
    String name
    String flags
    String epoch
    String version
    String release
    boolean pre
  }

  @ToString(includePackage = false, includeNames = true)
  static class File
  {
    String name
    FileType type
    boolean primary
  }

  static enum FileType {
    file, dir, ghost
  }

  @ToString(includePackage = false, includeNames = true)
  static class ChangeLog
  {
    String author
    Integer date
    String text
  }

  public RpmPackage getRpmPackage(){
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
      Iterator<File> fileIterator = files.iterator();
      ArrayList<Files> rpmFiles = new ArrayList<Files>();
      while(fileIterator.hasNext()){
          File fl = fileIterator.next();
          Files fls = new Files(fl.name)
          fls.setType(fl.type.toString());
          rpmFiles.add(fls);
      }
      rp.setFilesCollection(rpmFiles);
      //location_base is usually null value
      rp.setLocationBase(null);
      rp.setLocationHref(location);
      Iterator<ChangeLog> clIterator = changes.iterator();
      ArrayList<ua.pp.msk.yum.sqlite.other.Changelog> rpmChangeLog = new ArrayList<>();
      while(clIterator.hasNext()){
          ua.pp.msk.yum.sqlite.other.Changelog chlg = new ua.pp.msk.yum.sqlite.other.Changelog();
          ChangeLog cl = clIterator.next();
          chlg.setChangelogPK(new ua.pp.msk.yum.sqlite.other.ChangelogPK(cl.author, cl.date));
          chlg.setChangelog(cl.text);
          rpmChangeLog.add(chlg);
      }
      rp.setChangelogCollection(rpmChangeLog);
      
      Iterator<Entry> cnfIterator = conflicts.iterator();
      ArrayList<ua.pp.msk.yum.sqlite.primary.Conflicts> rpmConflicts = new ArrayList<>();
      while(cnfIterator.hasNext()){
          Entry cnfl = cnfIterator.next();
          ua.pp.msk.yum.sqlite.primary.Conflicts rpmConflict = new ua.pp.msk.yum.sqlite.primary.Conflicts();
          rpmConflict.setEpoch(cnfl.epoch);
          rpmConflict.setFlags(cnfl.flags);
          rpmConflict.setName(cnfl.name);
          rpmConflict.setRelease(cnfl.release);
          rpmConflict.setVersion(cnfl.version);
          rpmConflicts.add(rpmConflict);
      }
      rp.setConflictsCollection(rpmConflicts);
      
      Iterator<Entry> obsIterator = obsoletes.iterator();
      ArrayList<ua.pp.msk.yum.sqlite.primary.Obsoletes> rpmObsoletes = new ArrayList<>();
      while(obsIterator.hasNext()){
          Entry obsl = obsIterator.next();
          ua.pp.msk.yum.sqlite.primary.Obsoletes rpmObsolete = new ua.pp.msk.yum.sqlite.primary.Obsoletes();
          rpmObsolete.setEpoch(obsl.epoch);
          rpmObsolete.setFlags(obsl.flags);
          rpmObsolete.setName(obsl.name);
          rpmObsolete.setRelease(obsl.release);
          rpmObsolete.setVersion(obsl.version);
          rpmObsoletes.add(rpmObsolete);
      }
      rp.setConflictsCollection(rpmObsoletes);
      
       
      Iterator<Entry> provIterator = provides.iterator();
       ArrayList<ua.pp.msk.yum.sqlite.primary.Provides> rpmProvides = new ArrayList<>();
      while(provIterator.hasNext()){
          Entry provl = provIterator.next();
          ua.pp.msk.yum.sqlite.primary.Provides rpmProvide = new ua.pp.msk.yum.sqlite.primary.Provides();
          rpmProvide.setEpoch(provl.epoch);
          rpmProvide.setFlags(provl.flags);
          rpmProvide.setName(provl.name);
          rpmProvide.setRelease(provl.release);
          rpmProvide.setVersion(provl.version);
          rpmProvides.add(rpmProvide);
      }
      rp.setProvidesCollection(rpmProvides);
      
       
      Iterator<Entry> reqIterator = requires.iterator();
       ArrayList<ua.pp.msk.yum.sqlite.primary.Requires> rpmRequires = new ArrayList<>();
      while(reqIterator.hasNext()){
          Entry cnfl = cnfIterator.next();
          ua.pp.msk.yum.sqlite.primary.Requires rpmRequire = new ua.pp.msk.yum.sqlite.primary.Requires();
          rpmRequire.setEpoch(cnfl.epoch);
          rpmRequire.setFlags(cnfl.flags);
          rpmRequire.setName(cnfl.name);
          rpmRequire.setRelease(cnfl.release);
          rpmRequire.setVersion(cnfl.version);
          rpmRequires.add(rpmRequire);
      }
      rp.setRequiresCollection(rpmRequires);
      
      
//        this.suggestsCollection = null;
//        this.enhancesCollection = null;
//        this.supplementsCollection = null;
//        this.recommendsCollection = null;
//        this.filelistCollection = null;
    }
  
  
}
