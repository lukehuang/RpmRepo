/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.yum.sqlite.common;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class ResourceReader {

     public static String readFile(String fileName, ClassLoader cl) {
 
	StringBuilder result = new StringBuilder();
 
	//Get file from resources folder
	
	File file = new File(cl.getResource(fileName).getFile());
 
	try (Scanner scanner = new Scanner(file)) {
 
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			result.append(line).append("\n");
		}
 
		scanner.close();
 
	} catch (IOException e) {
		LoggerFactory.getLogger(ResourceReader.class).error("Cannot read file " + fileName, e);
	}
 
	return result.toString();
 
  }
}
