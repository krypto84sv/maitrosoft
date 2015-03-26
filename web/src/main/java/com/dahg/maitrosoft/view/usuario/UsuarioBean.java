/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahg.maitrosoft.view.usuario;

import com.dahg.maitrosoft.controller.services.commons.IUsuarioMantenimientoService;
import com.dahg.maitrosoft.model.Usuario;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author dahg
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {
    
    private Usuario current;
    @EJB
    private IUsuarioMantenimientoService servicio;

    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
    }
    
    public void guardar() {
    	servicio.merge(getCurrent());
    	//servicio.refreschar(getCurrent());
    }
    
    
    
}
