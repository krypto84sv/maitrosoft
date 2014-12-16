/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahg.maitrosoft.controller.persist;

import javax.persistence.EntityManager;

/**
 *
 * @author dahg
 */
public interface ISpringPersistence {
    EntityManager getEntityManager();
}
