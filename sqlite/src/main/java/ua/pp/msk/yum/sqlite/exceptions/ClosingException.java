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
public class ClosingException extends Exception {

    public ClosingException() {
    }

    public ClosingException(String message) {
        super(message);
    }

    public ClosingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClosingException(Throwable cause) {
        super(cause);
    }
    

}
