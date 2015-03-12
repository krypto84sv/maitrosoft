/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahg.maitrosoft.view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author dahg
 */
public abstract class AbstractManagedBean {
    
    public AbstractManagedBean() {
        //Se usa log4j integrado en JBOSS
    }
    
    protected FacesContext getCurrentFacesContext() {
        return FacesContext.getCurrentInstance();
    }
    
    public void info(String msg) {
        addMessage(msg, FacesMessage.SEVERITY_INFO);
    }
    
    public void warn(String msg) {
        addMessage(msg, FacesMessage.SEVERITY_WARN);
    }
    
    public void error(String msg) {
        addMessage(msg, FacesMessage.SEVERITY_ERROR);
    }
    
    
    private void addMessage(String msg, FacesMessage.Severity severity) {
        FacesMessage message = new FacesMessage(severity, msg, msg);
        getCurrentFacesContext().addMessage(null, message);
    }
}
