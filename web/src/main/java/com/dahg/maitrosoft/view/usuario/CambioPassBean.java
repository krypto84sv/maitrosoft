/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahg.maitrosoft.view.usuario;

import com.dahg.maitrosoft.controller.exceptions.ControllerException;
import com.dahg.maitrosoft.controller.services.commons.IUsuarioMantenimientoService;
import com.dahg.maitrosoft.model.Usuario;
import com.dahg.maitrosoft.view.AbstractManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author dahg
 */
@ManagedBean
@ViewScoped
public class CambioPassBean extends AbstractManagedBean {
    
    @EJB
    private IUsuarioMantenimientoService servicio;
    @ManagedProperty("#{usuarioBean}")
    private UsuarioBean usuarioBean;
    private String pass;

    public void cambio() {
        Usuario usr = usuarioBean.getCurrent();
        usr.setPassword(pass);
        try {
            servicio.cambioPass(usr);
            pass="";
            info("Cambio de password exitoso");
        }
        catch(ControllerException ex) {
            error(ex.getMessage());
        }
    }
    
    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
