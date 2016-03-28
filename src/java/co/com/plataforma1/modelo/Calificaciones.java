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
@Table(name = "calificaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificaciones.findAll", query = "SELECT c FROM Calificaciones c"),
    @NamedQuery(name = "Calificaciones.findByIdCalificaciones", query = "SELECT c FROM Calificaciones c WHERE c.idCalificaciones = :idCalificaciones"),
    @NamedQuery(name = "Calificaciones.findByNota", query = "SELECT c FROM Calificaciones c WHERE c.nota = :nota"),
    @NamedQuery(name = "Calificaciones.findByPeriodo", query = "SELECT c FROM Calificaciones c WHERE c.periodo = :periodo")})
public class Calificaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_calificaciones")
    private Integer idCalificaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nota")
    private int nota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "periodo")
    private String periodo;
    @JoinColumn(name = "iddocenteMateria", referencedColumnName = "iddocenteMateria")
    @ManyToOne(optional = false)
    private Docentemateria iddocenteMateria;
    @JoinColumn(name = "idestudiante", referencedColumnName = "idestudiante")
    @ManyToOne(optional = false)
    private Estudiante idestudiante;
    @JoinColumn(name = "idlogro", referencedColumnName = "idlogro")
    @ManyToOne(optional = false)
    private Logro idlogro;

    public Calificaciones() {
    }

    public Calificaciones(Integer idCalificaciones) {
        this.idCalificaciones = idCalificaciones;
    }

    public Calificaciones(Integer idCalificaciones, int nota, String periodo) {
        this.idCalificaciones = idCalificaciones;
        this.nota = nota;
        this.periodo = periodo;
    }

    public Integer getIdCalificaciones() {
        return idCalificaciones;
    }

    public void setIdCalificaciones(Integer idCalificaciones) {
        this.idCalificaciones = idCalificaciones;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Docentemateria getIddocenteMateria() {
        return iddocenteMateria;
    }

    public void setIddocenteMateria(Docentemateria iddocenteMateria) {
        this.iddocenteMateria = iddocenteMateria;
    }

    public Estudiante getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Estudiante idestudiante) {
        this.idestudiante = idestudiante;
    }

    public Logro getIdlogro() {
        return idlogro;
    }

    public void setIdlogro(Logro idlogro) {
        this.idlogro = idlogro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalificaciones != null ? idCalificaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificaciones)) {
            return false;
        }
        Calificaciones other = (Calificaciones) object;
        if ((this.idCalificaciones == null && other.idCalificaciones != null) || (this.idCalificaciones != null && !this.idCalificaciones.equals(other.idCalificaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.plataforma1.modelo.Calificaciones[ idCalificaciones=" + idCalificaciones + " ]";
    }
    
}
