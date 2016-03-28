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
@Table(name = "competencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competencia.findAll", query = "SELECT c FROM Competencia c"),
    @NamedQuery(name = "Competencia.findByIdcompetencia", query = "SELECT c FROM Competencia c WHERE c.idcompetencia = :idcompetencia"),
    @NamedQuery(name = "Competencia.findByDescripcionCom", query = "SELECT c FROM Competencia c WHERE c.descripcionCom = :descripcionCom"),
    @NamedQuery(name = "Competencia.findByPeriodo", query = "SELECT c FROM Competencia c WHERE c.periodo = :periodo")})
public class Competencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcompetencia")
    private Integer idcompetencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcionCom")
    private String descripcionCom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "periodo")
    private String periodo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcompetencia")
    private Collection<Logro> logroCollection;
    @JoinColumn(name = "idmateria", referencedColumnName = "idmateria")
    @ManyToOne(optional = false)
    private Materia idmateria;

    public Competencia() {
    }

    public Competencia(Integer idcompetencia) {
        this.idcompetencia = idcompetencia;
    }

    public Competencia(Integer idcompetencia, String descripcionCom, String periodo) {
        this.idcompetencia = idcompetencia;
        this.descripcionCom = descripcionCom;
        this.periodo = periodo;
    }

    public Integer getIdcompetencia() {
        return idcompetencia;
    }

    public void setIdcompetencia(Integer idcompetencia) {
        this.idcompetencia = idcompetencia;
    }

    public String getDescripcionCom() {
        return descripcionCom;
    }

    public void setDescripcionCom(String descripcionCom) {
        this.descripcionCom = descripcionCom;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @XmlTransient
    public Collection<Logro> getLogroCollection() {
        return logroCollection;
    }

    public void setLogroCollection(Collection<Logro> logroCollection) {
        this.logroCollection = logroCollection;
    }

    public Materia getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(Materia idmateria) {
        this.idmateria = idmateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompetencia != null ? idcompetencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competencia)) {
            return false;
        }
        Competencia other = (Competencia) object;
        if ((this.idcompetencia == null && other.idcompetencia != null) || (this.idcompetencia != null && !this.idcompetencia.equals(other.idcompetencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.plataforma1.modelo.Competencia[ idcompetencia=" + idcompetencia + " ]";
    }
    
}
