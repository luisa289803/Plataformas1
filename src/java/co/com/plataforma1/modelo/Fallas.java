/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.plataforma1.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luisa
 */
@Entity
@Table(name = "fallas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fallas.findAll", query = "SELECT f FROM Fallas f"),
    @NamedQuery(name = "Fallas.findByIdfallas", query = "SELECT f FROM Fallas f WHERE f.idfallas = :idfallas"),
    @NamedQuery(name = "Fallas.findByPeriodo", query = "SELECT f FROM Fallas f WHERE f.periodo = :periodo"),
    @NamedQuery(name = "Fallas.findByFecha", query = "SELECT f FROM Fallas f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "Fallas.findByEstado", query = "SELECT f FROM Fallas f WHERE f.estado = :estado")})
public class Fallas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfallas")
    private Integer idfallas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "periodo")
    private String periodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @JoinColumn(name = "idestudiante", referencedColumnName = "idestudiante")
    @ManyToOne(optional = false)
    private Estudiante idestudiante;
    @JoinColumn(name = "idhorario", referencedColumnName = "idhorario")
    @ManyToOne(optional = false)
    private Horario idhorario;

    public Fallas() {
    }

    public Fallas(Integer idfallas) {
        this.idfallas = idfallas;
    }

    public Fallas(Integer idfallas, String periodo, Date fecha, boolean estado) {
        this.idfallas = idfallas;
        this.periodo = periodo;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getIdfallas() {
        return idfallas;
    }

    public void setIdfallas(Integer idfallas) {
        this.idfallas = idfallas;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Estudiante getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Estudiante idestudiante) {
        this.idestudiante = idestudiante;
    }

    public Horario getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Horario idhorario) {
        this.idhorario = idhorario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfallas != null ? idfallas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fallas)) {
            return false;
        }
        Fallas other = (Fallas) object;
        if ((this.idfallas == null && other.idfallas != null) || (this.idfallas != null && !this.idfallas.equals(other.idfallas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.plataforma1.modelo.Fallas[ idfallas=" + idfallas + " ]";
    }
    
}
