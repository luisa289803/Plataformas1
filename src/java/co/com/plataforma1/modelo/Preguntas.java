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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luisa
 */
@Entity
@Table(name = "preguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preguntas.findAll", query = "SELECT p FROM Preguntas p"),
    @NamedQuery(name = "Preguntas.findByIdpreguntas", query = "SELECT p FROM Preguntas p WHERE p.idpreguntas = :idpreguntas"),
    @NamedQuery(name = "Preguntas.findByPregunta", query = "SELECT p FROM Preguntas p WHERE p.pregunta = :pregunta"),
    @NamedQuery(name = "Preguntas.findByOpcion1", query = "SELECT p FROM Preguntas p WHERE p.opcion1 = :opcion1"),
    @NamedQuery(name = "Preguntas.findByOpcion2", query = "SELECT p FROM Preguntas p WHERE p.opcion2 = :opcion2"),
    @NamedQuery(name = "Preguntas.findByOpcion3", query = "SELECT p FROM Preguntas p WHERE p.opcion3 = :opcion3"),
    @NamedQuery(name = "Preguntas.findByOpcion4", query = "SELECT p FROM Preguntas p WHERE p.opcion4 = :opcion4")})
public class Preguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpreguntas")
    private Integer idpreguntas;
    @Size(max = 500)
    @Column(name = "pregunta")
    private String pregunta;
    @Size(max = 200)
    @Column(name = "opcion1")
    private String opcion1;
    @Size(max = 200)
    @Column(name = "opcion2")
    private String opcion2;
    @Size(max = 200)
    @Column(name = "opcion3")
    private String opcion3;
    @Size(max = 200)
    @Column(name = "opcion4")
    private String opcion4;
    @JoinColumn(name = "idevaluacion", referencedColumnName = "idevaluacion")
    @ManyToOne(optional = false)
    private Evaluacion idevaluacion;

    public Preguntas() {
    }

    public Preguntas(Integer idpreguntas) {
        this.idpreguntas = idpreguntas;
    }

    public Integer getIdpreguntas() {
        return idpreguntas;
    }

    public void setIdpreguntas(Integer idpreguntas) {
        this.idpreguntas = idpreguntas;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(String opcion4) {
        this.opcion4 = opcion4;
    }

    public Evaluacion getIdevaluacion() {
        return idevaluacion;
    }

    public void setIdevaluacion(Evaluacion idevaluacion) {
        this.idevaluacion = idevaluacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpreguntas != null ? idpreguntas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preguntas)) {
            return false;
        }
        Preguntas other = (Preguntas) object;
        if ((this.idpreguntas == null && other.idpreguntas != null) || (this.idpreguntas != null && !this.idpreguntas.equals(other.idpreguntas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.plataforma1.modelo.Preguntas[ idpreguntas=" + idpreguntas + " ]";
    }
    
}
