/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum;

import java.io.File;
import java.io.FileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonatype.sisu.resource.scanner.Listener;
import org.sonatype.sisu.resource.scanner.Scanner;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class DirectoryScanner implements Scanner {

    private final Logger logger =  LoggerFactory.getLogger(this.getClass());
    
    @Override
    public void scan(File file, Listener listener) {
        scan(file, listener, null);
    }

    @Override
    public void scan(File dir, Listener listener, FileFilter filter) {
        logger.debug("Scanner: " + dir.getAbsolutePath());
        if (!dir.isDirectory()) {
            logger.error("File " + dir.getAbsolutePath() + " is not a directory");
            return;
        }
        if (!dir.canRead()) {
          logger.error("There is no read permission on " + dir.getAbsolutePath());
            return;
        }
        if (!dir.canExecute()) {
           logger.error("There is no execute permission on " + dir.getAbsolutePath());
            return;
        }
        
        String[] fileList = dir.list();
        for (String fileName : fileList) {
            File currentFile = new File(dir.getAbsolutePath() + File.separator + fileName);
            if (currentFile.exists()) {
                if (filter == null || filter.accept(currentFile)) {
                    listener.onFile(currentFile);
                }
            }
        }

    }
}
