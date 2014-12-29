package com.dahg.maitrosoft.view.usuario;

import com.dahg.maitrosoft.controller.exceptions.ControllerException;
import com.dahg.maitrosoft.controller.services.commons.IUsuarioMantenimientoService;
import com.dahg.maitrosoft.model.Usuario;
import com.dahg.maitrosoft.view.AbstractManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author dahg
 */
@ManagedBean
@ViewScoped
public class RegistroUsuarioBean extends AbstractManagedBean {
    
    @EJB
    private IUsuarioMantenimientoService servicio;
    private Usuario usuario;
    private String passTemp;
    
    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }
    
    public void registrar() {
        try {
            if(usuario.getLogin()==null || usuario.getLogin().isEmpty()) throw new ControllerException("Debe ingresar un login");
            if(usuario.getNombre()==null || usuario.getNombre().isEmpty()) throw new ControllerException("Debe ingresar un Nombre");
            if(usuario.getEmail()==null || usuario.getEmail().isEmpty()) throw new ControllerException("Debe ingresar un Nombre");
            
            if(usuario.getPassword()==null || usuario.getPassword().isEmpty()) throw new ControllerException("Debe ingresar un password");
            if(passTemp==null || passTemp.isEmpty()) throw new ControllerException("Debe ingresar de nuevo un password");
            
            if(!usuario.getPassword().equals(passTemp)) throw new ControllerException("Los password no coinciden");
            
            servicio.registrarUsuario(usuario);
            
            info("Usuario creado exitosamente");
            usuario = new Usuario();
            RequestContext ctx = RequestContext.getCurrentInstance();
            ctx.execute("PF('creaUsuario').hide()");
        }
        catch(ControllerException ex) {
            error(ex.getMessage());
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getPassTemp() {
        return passTemp;
    }

    public void setPassTemp(String passTemp) {
        this.passTemp = passTemp;
    }
    
    
}
