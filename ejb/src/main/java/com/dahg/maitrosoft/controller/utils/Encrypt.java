/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahg.maitrosoft.controller.utils;

/**
 *
 * @author dahg
 */
public interface Encrypt {

    String hash(String stringToHash) throws Exception;
        
}
