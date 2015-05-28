/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.yum.createrepoutils;

import com.google.common.io.BaseEncoding;
import com.google.common.io.CountingOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class OutputXmlStream   {
        private final CountingOutputStream openSizeStream;
        private final CountingOutputStream compressedSizeStream;
        private final DigestOutputStream openDigestStream;
        private final DigestOutputStream compressedDigestStream;
        private String openChecksum;
        private String compressedChecksum;

        OutputXmlStream(final OutputStream stream) throws NoSuchAlgorithmException, IOException {
            compressedDigestStream = new DigestOutputStream(stream, MessageDigest.getInstance("SHA-256"));
            compressedSizeStream = new CountingOutputStream(compressedDigestStream);
            openDigestStream = new DigestOutputStream(new GZIPOutputStream(compressedSizeStream), MessageDigest.getInstance("SHA-256"));
            openSizeStream = new CountingOutputStream(openDigestStream);
        }

        OutputStream getStream() {
            return openSizeStream;
        }

        long getOpenSize() {
            return openSizeStream.getCount();
        }

        long getCompressedSize() {
            return compressedSizeStream.getCount();
        }

        String getOpenChecksum() {
            if (openChecksum == null || openChecksum.isEmpty()) {
                openChecksum = BaseEncoding.base16().lowerCase().encode(openDigestStream.getMessageDigest().digest());
            }
            return openChecksum;
        }

        String getCompressedChecksum() {
            if (compressedChecksum == null ||  compressedChecksum.isEmpty()) {
                compressedChecksum = BaseEncoding.base16().lowerCase().encode(compressedDigestStream.getMessageDigest().digest());
            }
            return compressedChecksum;
        }
}
