/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.yum.sqlite.exceptions;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class DatabaseInitializationException extends Exception {

    public DatabaseInitializationException() {
    }

    public DatabaseInitializationException(String message) {
        super(message);
    }

    public DatabaseInitializationException(String message, Throwable cause) {
        super(message, cause);
    }

}
