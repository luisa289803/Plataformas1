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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luisa
 */
@Entity
@Table(name = "logro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logro.findAll", query = "SELECT l FROM Logro l"),
    @NamedQuery(name = "Logro.findByIdlogro", query = "SELECT l FROM Logro l WHERE l.idlogro = :idlogro"),
    @NamedQuery(name = "Logro.findByDescripcion", query = "SELECT l FROM Logro l WHERE l.descripcion = :descripcion"),
    @NamedQuery(name = "Logro.findByPuntos", query = "SELECT l FROM Logro l WHERE l.puntos = :puntos")})
public class Logro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlogro")
    private Integer idlogro;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntos")
    private int puntos;
    @JoinColumn(name = "idcompetencia", referencedColumnName = "idcompetencia")
    @ManyToOne(optional = false)
    private Competencia idcompetencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlogro")
    private Collection<Calificaciones> calificacionesCollection;

    public Logro() {
    }

    public Logro(Integer idlogro) {
        this.idlogro = idlogro;
    }

    public Logro(Integer idlogro, int puntos) {
        this.idlogro = idlogro;
        this.puntos = puntos;
    }

    public Integer getIdlogro() {
        return idlogro;
    }

    public void setIdlogro(Integer idlogro) {
        this.idlogro = idlogro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Competencia getIdcompetencia() {
        return idcompetencia;
    }

    public void setIdcompetencia(Competencia idcompetencia) {
        this.idcompetencia = idcompetencia;
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
        hash += (idlogro != null ? idlogro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logro)) {
            return false;
        }
        Logro other = (Logro) object;
        if ((this.idlogro == null && other.idlogro != null) || (this.idlogro != null && !this.idlogro.equals(other.idlogro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.plataforma1.modelo.Logro[ idlogro=" + idlogro + " ]";
    }
    
}
