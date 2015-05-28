/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.web;

import org.slf4j.LoggerFactory;

/**
 *
 * @author maskimko
 */
public class RedirectBean {

    /**
     * Creates a new instance of RedirectBean
     */
    public RedirectBean() {
    }
    
    public String doRedirect(){
        LoggerFactory.getLogger(this.getClass()).info("Redirectirng to the welcome page");
        return "welcome";
    }
}
