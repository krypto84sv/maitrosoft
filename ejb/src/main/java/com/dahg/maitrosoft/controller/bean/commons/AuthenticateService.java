/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahg.maitrosoft.controller.bean.commons;

import com.dahg.maitrosoft.controller.bean.AbstractBasic;
import com.dahg.maitrosoft.controller.exceptions.ControllerException;
import com.dahg.maitrosoft.controller.services.commons.IAuthenticateService;
import com.dahg.maitrosoft.controller.services.commons.IUsuarioMantenimientoService;
import com.dahg.maitrosoft.model.Usuario;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author dahg
 */
@Stateless
public class AuthenticateService extends AbstractBasic implements IAuthenticateService {

    @EJB
    private IUsuarioMantenimientoService usuarioService;
    
    @Override
    public Usuario auth(String login, String pass) throws ControllerException {
        getEntityManager().clear();
        Usuario usuario = usuarioService.checkIfExist(login);
        String passEncrypt="";
        
        try {
            passEncrypt = getEncrypt().hash(pass);
        } catch (Exception ex) {
            throw new ControllerException(ex);
        }        
        
        if(!usuario.getPassword().equals(passEncrypt)) throw new ControllerException("Password no valido");
        
        return usuario;
        
    }
    
}
