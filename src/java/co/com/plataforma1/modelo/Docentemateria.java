/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.plataforma1.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luisa
 */
@Entity
@Table(name = "docentemateria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docentemateria.findAll", query = "SELECT d FROM Docentemateria d"),
    @NamedQuery(name = "Docentemateria.findByIddocenteMateria", query = "SELECT d FROM Docentemateria d WHERE d.iddocenteMateria = :iddocenteMateria")})
public class Docentemateria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddocenteMateria")
    private Integer iddocenteMateria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddocenteMateria")
    private Collection<Horario> horarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddocenteMateria")
    private Collection<Evaluacion> evaluacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddocenteMateria")
    private Collection<Tareas> tareasCollection;
    @JoinColumn(name = "idmateria", referencedColumnName = "idmateria")
    @ManyToOne(optional = false)
    private Materia idmateria;
    @JoinColumn(name = "iddocente", referencedColumnName = "iddocente")
    @ManyToOne(optional = false)
    private Docente iddocente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddocenteMateria")
    private Collection<Calificaciones> calificacionesCollection;

    public Docentemateria() {
    }

    public Docentemateria(Integer iddocenteMateria) {
        this.iddocenteMateria = iddocenteMateria;
    }

    public Integer getIddocenteMateria() {
        return iddocenteMateria;
    }

    public void setIddocenteMateria(Integer iddocenteMateria) {
        this.iddocenteMateria = iddocenteMateria;
    }

    @XmlTransient
    public Collection<Horario> getHorarioCollection() {
        return horarioCollection;
    }

    public void setHorarioCollection(Collection<Horario> horarioCollection) {
        this.horarioCollection = horarioCollection;
    }

    @XmlTransient
    public Collection<Evaluacion> getEvaluacionCollection() {
        return evaluacionCollection;
    }

    public void setEvaluacionCollection(Collection<Evaluacion> evaluacionCollection) {
        this.evaluacionCollection = evaluacionCollection;
    }

    @XmlTransient
    public Collection<Tareas> getTareasCollection() {
        return tareasCollection;
    }

    public void setTareasCollection(Collection<Tareas> tareasCollection) {
        this.tareasCollection = tareasCollection;
    }

    public Materia getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(Materia idmateria) {
        this.idmateria = idmateria;
    }

    public Docente getIddocente() {
        return iddocente;
    }

    public void setIddocente(Docente iddocente) {
        this.iddocente = iddocente;
    }

    @XmlTransient
    public Collection<Calificaciones> getCalificacionesCollection() {
        return calificacionesCollection;
    }

    public void setCalificacionesCollection(Collection<Calificaciones> calificacionesCollection) {
        this.calificacionesCollection = calificacionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddocenteMateria != null ? iddocenteMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docentemateria)) {
            return false;
        }
        Docentemateria other = (Docentemateria) object;
        if ((this.iddocenteMateria == null && other.iddocenteMateria != null) || (this.iddocenteMateria != null && !this.iddocenteMateria.equals(other.iddocenteMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.plataforma1.modelo.Docentemateria[ iddocenteMateria=" + iddocenteMateria + " ]";
    }
    
}
