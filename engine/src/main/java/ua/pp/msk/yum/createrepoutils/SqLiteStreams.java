/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.createrepoutils;

/**
 *
 * @author edem
 */
public interface SqLiteStreams {
    OutputXmlStream getPrimaryOutputStream();
    OutputXmlStream getFilelistOutputStream();
    OutputXmlStream getOthersOutputStream();
}
