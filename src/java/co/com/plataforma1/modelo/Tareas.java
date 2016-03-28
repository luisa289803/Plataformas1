/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.plataforma1.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luisa
 */
@Entity
@Table(name = "tareas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tareas.findAll", query = "SELECT t FROM Tareas t"),
    @NamedQuery(name = "Tareas.findByIdtareas", query = "SELECT t FROM Tareas t WHERE t.idtareas = :idtareas"),
    @NamedQuery(name = "Tareas.findByTarea", query = "SELECT t FROM Tareas t WHERE t.tarea = :tarea")})
public class Tareas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtareas")
    private Integer idtareas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "tarea")
    private String tarea;
    @JoinColumn(name = "iddocenteMateria", referencedColumnName = "iddocenteMateria")
    @ManyToOne(optional = false)
    private Docentemateria iddocenteMateria;

    public Tareas() {
    }

    public Tareas(Integer idtareas) {
        this.idtareas = idtareas;
    }

    public Tareas(Integer idtareas, String tarea) {
        this.idtareas = idtareas;
        this.tarea = tarea;
    }

    public Integer getIdtareas() {
        return idtareas;
    }

    public void setIdtareas(Integer idtareas) {
        this.idtareas = idtareas;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public Docentemateria getIddocenteMateria() {
        return iddocenteMateria;
    }

    public void setIddocenteMateria(Docentemateria iddocenteMateria) {
        this.iddocenteMateria = iddocenteMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtareas != null ? idtareas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tareas)) {
            return false;
        }
        Tareas other = (Tareas) object;
        if ((this.idtareas == null && other.idtareas != null) || (this.idtareas != null && !this.idtareas.equals(other.idtareas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.plataforma1.modelo.Tareas[ idtareas=" + idtareas + " ]";
    }
    
}
