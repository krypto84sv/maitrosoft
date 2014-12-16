/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahg.maitrosoft.controller.services.commons;

import com.dahg.maitrosoft.controller.exceptions.ControllerException;
import com.dahg.maitrosoft.model.Usuario;
import javax.ejb.Local;

/**
 *
 * @author dahg
 */
@Local
public interface IAuthenticateService {    
    
    Usuario auth(String login, String pass) throws ControllerException;
    
}
