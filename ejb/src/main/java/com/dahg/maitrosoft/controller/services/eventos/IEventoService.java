/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahg.maitrosoft.controller.services.eventos;

import com.dahg.maitrosoft.controller.services.IService;
import com.dahg.maitrosoft.model.Evento;
import com.dahg.maitrosoft.model.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dahg
 */
@Local
public interface IEventoService extends IService<Evento>{
    List<Evento> getEventosActivos(Usuario usuario);
}
