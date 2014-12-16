/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahg.maitrosoft.controller.exceptions;

import java.io.Serializable;

/**
 *
 * @author dahg
 */
public class ControllerException extends Exception implements Serializable {

    public ControllerException(String msg) {
        super(msg);
    }
    
    public ControllerException(Throwable ex, String msg) {
        super(msg, ex);
    }

    public ControllerException(Throwable ex) {
        super(ex);
    }
        
}
