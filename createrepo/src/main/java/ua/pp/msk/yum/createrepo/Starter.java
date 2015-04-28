/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.createrepo;

import java.io.File;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.pp.msk.yum.CreateRepo;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class Starter {
    
    private static final Logger LOG = LoggerFactory.getLogger(Starter.class);
    private static Options opts;
    
    private static Options configureOptions() {
        opts = new Options();
        opts.addOption("d", "dir", true, "Repository directory");
        opts.addOption("p", "rpmdir", true, "RPM packages directory to scan");
        opts.addOption("h", "help", false, "Print usage info");
        return opts;
    }
    
    private static void printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("createrepo <opts>", opts);
    }
    
    public static void main(String[] args) throws Exception {
        CommandLineParser parser = new GnuParser();
        CommandLine cmd = parser.parse(configureOptions(), args);
        File repoDir;
        File rpmDir;
        if (!cmd.hasOption("d")) {
            LOG.error("dir option is mandatory");
            printHelp();
            System.exit(1);
        }
        repoDir = new File(cmd.getOptionValue("d"));
        if (!repoDir.exists()) {
            LOG.warn("Specified repository directory " + cmd.getOptionValue("d") + " does not exist");
        }
        if (cmd.hasOption("p")) {
            rpmDir = new File(cmd.getOptionValue("p"));
        } else {
            rpmDir = repoDir;
        }
        CreateRepo cr = new CreateRepo(rpmDir, repoDir);
        LOG.debug("Executing repo creation");
        cr.execute();
        LOG.info("Repository has been successfuly created");
    }
}
