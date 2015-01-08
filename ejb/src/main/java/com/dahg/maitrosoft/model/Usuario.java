package com.dahg.maitrosoft.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author dahg
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    
    @Id
    private String login;
    private String nombre;
    private String password;
    private String email;
    
    @ManyToMany
    @JoinTable(name="evento_producto",
         joinColumns={@JoinColumn(name="fk_usuario")},
         inverseJoinColumns={@JoinColumn(name="fk_evento")})
    @LazyCollection(LazyCollectionOption.TRUE)
    private List<Evento> eventos;
    
    @OneToMany(mappedBy = "responsable")
    @OrderBy("dia desc")
    private List<Evento> misEventos;
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<Evento> getMisEventos() {
        return misEventos;
    }

    public void setMisEventos(List<Evento> misEventos) {
        this.misEventos = misEventos;
    }
    
    
    
}
