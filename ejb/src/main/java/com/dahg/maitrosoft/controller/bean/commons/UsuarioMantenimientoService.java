/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahg.maitrosoft.controller.bean.commons;

import com.dahg.maitrosoft.controller.bean.AbstractSingleEntityBean;
import com.dahg.maitrosoft.controller.exceptions.ControllerException;
import com.dahg.maitrosoft.controller.services.commons.IUsuarioMantenimientoService;
import com.dahg.maitrosoft.model.Usuario;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author dahg
 */
@Stateless
public class UsuarioMantenimientoService extends AbstractSingleEntityBean<Usuario> implements IUsuarioMantenimientoService{

    @Override
    protected Class<Usuario> getClazz() {
        return Usuario.class;
    }

    @Override
    public Usuario checkIfExist(String login) throws ControllerException {        
        /*
        Equivalente a: select u from Usuario u where u.login = :loginParameter
        */
        
        CriteriaBuilder builder = getCriteriaBuilder();
        CriteriaQuery<Usuario> criteriaQuery = getCriteriaQuery();        
        Root<Usuario> from = criteriaQuery.from(getClazz());        
        CriteriaQuery<Usuario> select = criteriaQuery.select(from);
        
        Predicate predicate = builder.equal(from.get("login"), login);        
        CriteriaQuery<Usuario> selectEquals = select.where(predicate);
        
        Usuario usuario = null;
        try {
            Query query = getTypedQuery(selectEquals);
            usuario = (Usuario ) query.getSingleResult();
        }
        catch (NoResultException ex) {
            throw new ControllerException(ex,"Usuario no existe");
        }
        
        return usuario;
    }
    
}
