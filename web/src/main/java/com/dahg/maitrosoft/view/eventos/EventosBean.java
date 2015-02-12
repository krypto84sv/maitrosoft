/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahg.maitrosoft.view.eventos;

import com.dahg.maitrosoft.controller.services.eventos.IEventoService;
import com.dahg.maitrosoft.model.Evento;
import com.dahg.maitrosoft.view.AbstractManagedBean;
import com.dahg.maitrosoft.view.usuario.UsuarioBean;
import java.util.List;
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
public class EventosBean extends AbstractManagedBean {
    
    @EJB
    private IEventoService service;
    @ManagedProperty("#{usuarioBean}")
    private UsuarioBean usuarioBean;
    
    private List<Evento> eventos;
    
    
    @PostConstruct
    public void init() {
        refreshList();
    }
    
    public void actualizaEvento(Evento evt) {
        evt.setEstado(!evt.getEstado());
        service.merge(evt);
    }
    
    private void refreshList() {
        if(eventos!=null) {
            eventos.clear();
            eventos.addAll(service.getEventosActivos(usuarioBean.getCurrent()));
        }
        else
            eventos = service.getEventosActivos(usuarioBean.getCurrent());
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
    
}
