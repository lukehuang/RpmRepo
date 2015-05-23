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
public class DbPathException extends Exception {

    public DbPathException() {
    }

    public DbPathException(String message) {
        super(message);
    }

    public DbPathException(String message, Throwable cause) {
        super(message, cause);
    }

    public DbPathException(Throwable cause) {
        super(cause);
    }

}
