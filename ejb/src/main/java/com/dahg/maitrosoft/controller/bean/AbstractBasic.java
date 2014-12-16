/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahg.maitrosoft.controller.bean;

import com.dahg.maitrosoft.controller.persist.ISpringPersistence;
import com.dahg.maitrosoft.controller.utils.Encrypt;
import com.dahg.maitrosoft.controller.utils.MD5EncryptImpl;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
/**
 *
 * @author dahg
 * */
@Interceptors(SpringBeanAutowiringInterceptor.class)
public abstract class AbstractBasic {
    
    @Autowired    
    @Qualifier("persistence")
    private ISpringPersistence persistence;

    public EntityManager getEntityManager() {        
        return persistence.getEntityManager();
    }    
    
    public Encrypt getEncrypt() {        
        return new MD5EncryptImpl();
    }
}
