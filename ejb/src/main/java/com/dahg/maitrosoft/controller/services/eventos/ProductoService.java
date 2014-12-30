/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahg.maitrosoft.controller.services.eventos;

import com.dahg.maitrosoft.controller.bean.AbstractSingleEntityBean;
import com.dahg.maitrosoft.model.Producto;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author dahg
 */
@Stateless
public class ProductoService extends AbstractSingleEntityBean<Producto> implements IProductoService {

    @Override
    protected Class<Producto> getClazz() {
        return Producto.class;
    }

    @Override
    public List<Producto> getAll() {
        return getTypedQuery(getSelectCriteriaQuery()).getResultList();
    }
    
}
