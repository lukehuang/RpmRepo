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
import ua.pp.msk.yum.sqlite.primary.Files

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
      rp.setPkgId(checksum);
      Iterator<File> fileIterator = files.iterator();
      
      while(fileIterator.hasNext()){
          File fl = fileIterator.next();
          fl.name;
          fl.primary;
          fl.type;
          Files fls = null;
          fls.setName(fl.name);
          //fls.setType(fl.type.)
          //TODO implement transformation
      }
      
//        this.changelogCollection = null;
//        this.locationHref = null;
//        this.locationBase = null;
//        this.conflictsCollection = null;
//        this.obsoletesCollection = null;
//        this.filesCollection = null;
//        this.providesCollection = null;
//        this.suggestsCollection = null;
//        this.enhancesCollection = null;
//        this.requiresCollection = null;
//        this.supplementsCollection = null;
//        this.recommendsCollection = null;
//        this.pkgKey = null;
//        this.filelistCollection = null;
    }
  
  
}
