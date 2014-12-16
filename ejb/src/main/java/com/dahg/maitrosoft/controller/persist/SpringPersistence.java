/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahg.maitrosoft.controller.persist;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dahg
 */
@Repository
@Transactional
public class SpringPersistence  implements ISpringPersistence {
    
    private EntityManager em;
    
    @PersistenceContext(unitName = "maitrosoftPU",type = PersistenceContextType.EXTENDED)
    public void setEntityManager(EntityManager em) {        
        this.em = em;
    }
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
        
}
