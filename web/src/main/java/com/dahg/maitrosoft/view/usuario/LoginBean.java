/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahg.maitrosoft.view.usuario;

import com.dahg.maitrosoft.controller.exceptions.ControllerException;
import com.dahg.maitrosoft.controller.services.commons.IAuthenticateService;
import com.dahg.maitrosoft.model.Usuario;
import com.dahg.maitrosoft.view.AbstractManagedBean;
import javax.annotation.PostConstruct;
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
public class LoginBean extends AbstractManagedBean {
    
    @EJB
    private IAuthenticateService authService;    
    
    private String login;
    private String pass;
    
    @ManagedProperty("#{usuarioBean}")
    private UsuarioBean usuarioBean;
    
    @PostConstruct
    public void init() {
        usuarioBean.setCurrent(null);
    }
    
    public String authenticate() {        
        try {        	
            if(login==null || login.isEmpty()) throw new ControllerException("Debe ingresar el login");
            if(pass==null || pass.isEmpty()) throw new ControllerException("Debe ingresar el password");
            Usuario usuario = authService.auth(login, pass);            
            usuarioBean.setCurrent(usuario);
        } catch (ControllerException ex) {
            error(ex.getMessage());
            return null;
        }
        return "main_template";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }
    
    
}
