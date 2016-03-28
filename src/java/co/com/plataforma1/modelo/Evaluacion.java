/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.plataforma1.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luisa
 */
@Entity
@Table(name = "evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e"),
    @NamedQuery(name = "Evaluacion.findByIdevaluacion", query = "SELECT e FROM Evaluacion e WHERE e.idevaluacion = :idevaluacion"),
    @NamedQuery(name = "Evaluacion.findByFechaEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.fechaEvaluacion = :fechaEvaluacion")})
public class Evaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idevaluacion")
    private Integer idevaluacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEvaluacion")
    @Temporal(TemporalType.DATE)
    private Date fechaEvaluacion;
    @JoinColumn(name = "idgrado", referencedColumnName = "idgrado")
    @ManyToOne(optional = false)
    private Grado idgrado;
    @JoinColumn(name = "iddocenteMateria", referencedColumnName = "iddocenteMateria")
    @ManyToOne(optional = false)
    private Docentemateria iddocenteMateria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idevaluacion")
    private Collection<Preguntas> preguntasCollection;

    public Evaluacion() {
    }

    public Evaluacion(Integer idevaluacion) {
        this.idevaluacion = idevaluacion;
    }

    public Evaluacion(Integer idevaluacion, Date fechaEvaluacion) {
        this.idevaluacion = idevaluacion;
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Integer getIdevaluacion() {
        return idevaluacion;
    }

    public void setIdevaluacion(Integer idevaluacion) {
        this.idevaluacion = idevaluacion;
    }

    public Date getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(Date fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Grado getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(Grado idgrado) {
        this.idgrado = idgrado;
    }

    public Docentemateria getIddocenteMateria() {
        return iddocenteMateria;
    }

    public void setIddocenteMateria(Docentemateria iddocenteMateria) {
        this.iddocenteMateria = iddocenteMateria;
    }

    @XmlTransient
    public Collection<Preguntas> getPreguntasCollection() {
        return preguntasCollection;
    }

    public void setPreguntasCollection(Collection<Preguntas> preguntasCollection) {
        this.preguntasCollection = preguntasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idevaluacion != null ? idevaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluacion)) {
            return false;
        }
        Evaluacion other = (Evaluacion) object;
        if ((this.idevaluacion == null && other.idevaluacion != null) || (this.idevaluacion != null && !this.idevaluacion.equals(other.idevaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.plataforma1.modelo.Evaluacion[ idevaluacion=" + idevaluacion + " ]";
    }
    
}
