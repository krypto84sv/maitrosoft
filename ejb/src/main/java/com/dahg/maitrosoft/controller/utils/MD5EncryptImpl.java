/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahg.maitrosoft.controller.utils;

import java.security.MessageDigest;

/**
 *
 * @author dahg
 */
public class MD5EncryptImpl implements Encrypt {
    
    private static final String DECRYPT_TYPE="MD5";
        private static final char[] HEXADECIMAL = { '0', '1', '2', '3',
        '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        
    @Override
    public String hash(String stringToHash) throws Exception  {
        MessageDigest md = MessageDigest.getInstance(DECRYPT_TYPE);
        byte[] bytes = md.digest(stringToHash.getBytes());
        StringBuilder sb = new StringBuilder(2 * bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            int low = (int)(bytes[i] & 0x0f);
            int high = (int)((bytes[i] & 0xf0) >> 4);
            sb.append(HEXADECIMAL[high]);
            sb.append(HEXADECIMAL[low]);
        }
        return sb.toString();    
    }
}
