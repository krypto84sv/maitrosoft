/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahg.maitrosoft.controller.bean;


import com.dahg.maitrosoft.controller.services.IService;

import java.util.List;
import java.util.UUID;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dahg
 * @param <T>
 */

public abstract class AbstractSingleEntityBean<T> extends AbstractBasic implements IService<T> {
     

    protected abstract Class<T> getClazz();    
      
    @Override
    public T getById(Object id) {
        return getEntityManager().find(getClazz(), id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void persist(T obj) {
        getEntityManager().persist(obj);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void merge(T obj) {
        getEntityManager().merge(obj);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void remove(T obj) {
        getEntityManager().remove(obj);
    }
    
    protected TypedQuery<T> getTypedQuery(CriteriaQuery<T> select) {
        return getEntityManager().createQuery(select);
    }
    
    protected CriteriaQuery<T> getSelectCriteriaQuery() {        
        CriteriaQuery<T> criteriaQuery = getCriteriaQuery();
        Root<T> from = criteriaQuery.from(getClazz());
        CriteriaQuery<T> selectFrom = criteriaQuery.select(from);
        return selectFrom;
    }
    
    protected CriteriaQuery<T> getCriteriaQuery() {
        return getCriteriaBuilder().createQuery(getClazz());
    }
    
    protected CriteriaBuilder getCriteriaBuilder() {
        return getEntityManager().getCriteriaBuilder();
    }
    
    protected List<T> searchFor(String query, String field) {
        /*
        Equivalente a:
        select obj from MiObj obj where upper(obj.field) like upper(:parameter)
        */        
        
        CriteriaBuilder criteriaBuilder = getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = getCriteriaQuery();
        Root<T> from = criteriaQuery.from(getClazz());
        CriteriaQuery<T> select = criteriaQuery.select(from);
        
        
        Expression<String> literal = criteriaBuilder.upper(criteriaBuilder.literal((String) query));
        Predicate predicate = criteriaBuilder.like(criteriaBuilder.upper(from.<String>get(field)), literal);
        
        CriteriaQuery<T> selectLike=select.where(predicate);
        
        return getTypedQuery(selectLike).getResultList();
    }
    
}
