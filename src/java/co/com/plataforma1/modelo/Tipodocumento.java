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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luisa
 */
@Entity
@Table(name = "tipodocumento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodocumento.findAll", query = "SELECT t FROM Tipodocumento t"),
    @NamedQuery(name = "Tipodocumento.findByIdtipoDocumento", query = "SELECT t FROM Tipodocumento t WHERE t.idtipoDocumento = :idtipoDocumento"),
    @NamedQuery(name = "Tipodocumento.findByTipoDocumento", query = "SELECT t FROM Tipodocumento t WHERE t.tipoDocumento = :tipoDocumento")})
public class Tipodocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoDocumento")
    private Integer idtipoDocumento;
    @Size(max = 30)
    @Column(name = "tipoDocumento")
    private String tipoDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoDocumento")
    private Collection<Estudiante> estudianteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoDocumento")
    private Collection<Acudiente> acudienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoDocumento")
    private Collection<Docente> docenteCollection;

    public Tipodocumento() {
    }

    public Tipodocumento(Integer idtipoDocumento) {
        this.idtipoDocumento = idtipoDocumento;
    }

    public Integer getIdtipoDocumento() {
        return idtipoDocumento;
    }

    public void setIdtipoDocumento(Integer idtipoDocumento) {
        this.idtipoDocumento = idtipoDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @XmlTransient
    public Collection<Estudiante> getEstudianteCollection() {
        return estudianteCollection;
    }

    public void setEstudianteCollection(Collection<Estudiante> estudianteCollection) {
        this.estudianteCollection = estudianteCollection;
    }

    @XmlTransient
    public Collection<Acudiente> getAcudienteCollection() {
        return acudienteCollection;
    }

    public void setAcudienteCollection(Collection<Acudiente> acudienteCollection) {
        this.acudienteCollection = acudienteCollection;
    }

    @XmlTransient
    public Collection<Docente> getDocenteCollection() {
        return docenteCollection;
    }

    public void setDocenteCollection(Collection<Docente> docenteCollection) {
        this.docenteCollection = docenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoDocumento != null ? idtipoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodocumento)) {
            return false;
        }
        Tipodocumento other = (Tipodocumento) object;
        if ((this.idtipoDocumento == null && other.idtipoDocumento != null) || (this.idtipoDocumento != null && !this.idtipoDocumento.equals(other.idtipoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.plataforma1.modelo.Tipodocumento[ idtipoDocumento=" + idtipoDocumento + " ]";
    }
    
}
