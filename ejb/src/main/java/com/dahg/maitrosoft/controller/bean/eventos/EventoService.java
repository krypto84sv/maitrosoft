/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahg.maitrosoft.controller.bean.eventos;

import com.dahg.maitrosoft.controller.bean.AbstractSingleEntityBean;
import com.dahg.maitrosoft.controller.services.eventos.IEventoService;
import com.dahg.maitrosoft.model.Evento;
import com.dahg.maitrosoft.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author6 dahg
 */
@Stateless
public class EventoService extends AbstractSingleEntityBean<Evento> implements IEventoService {

    @Override
    protected Class<Evento> getClazz() {
        return Evento.class;
    }

    @Override
    public List<Evento> getEventosActivos(Usuario usuario) {
        String consulta ="select e from Evento e where e.responsable=:responsable and e.estado=true";
        Query query = getEntityManager().createQuery(consulta)
                .setParameter("responsable", usuario);
        List<Evento> lista = new ArrayList<Evento>();
        lista.addAll(query.getResultList());
        return lista;
    }
    
}
