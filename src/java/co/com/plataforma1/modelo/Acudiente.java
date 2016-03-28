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
@Table(name = "acudiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acudiente.findAll", query = "SELECT a FROM Acudiente a"),
    @NamedQuery(name = "Acudiente.findByIdacudiente", query = "SELECT a FROM Acudiente a WHERE a.idacudiente = :idacudiente"),
    @NamedQuery(name = "Acudiente.findByDocumentoAcudiente", query = "SELECT a FROM Acudiente a WHERE a.documentoAcudiente = :documentoAcudiente"),
    @NamedQuery(name = "Acudiente.findByNombreAcudiente", query = "SELECT a FROM Acudiente a WHERE a.nombreAcudiente = :nombreAcudiente"),
    @NamedQuery(name = "Acudiente.findByApellidoAcudiente", query = "SELECT a FROM Acudiente a WHERE a.apellidoAcudiente = :apellidoAcudiente"),
    @NamedQuery(name = "Acudiente.findByTelefonoAcudiente", query = "SELECT a FROM Acudiente a WHERE a.telefonoAcudiente = :telefonoAcudiente"),
    @NamedQuery(name = "Acudiente.findByDireccionAcudiente", query = "SELECT a FROM Acudiente a WHERE a.direccionAcudiente = :direccionAcudiente"),
    @NamedQuery(name = "Acudiente.findByProfesionAcudiente", query = "SELECT a FROM Acudiente a WHERE a.profesionAcudiente = :profesionAcudiente"),
    @NamedQuery(name = "Acudiente.findByEliminar", query = "SELECT a FROM Acudiente a WHERE a.eliminar = :eliminar")})
public class Acudiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idacudiente")
    private Integer idacudiente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "documentoAcudiente")
    private String documentoAcudiente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombreAcudiente")
    private String nombreAcudiente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "apellidoAcudiente")
    private String apellidoAcudiente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telefonoAcudiente")
    private String telefonoAcudiente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "direccionAcudiente")
    private String direccionAcudiente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "profesionAcudiente")
    private String profesionAcudiente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eliminar")
    private boolean eliminar;
    @JoinColumn(name = "idestudiante", referencedColumnName = "idestudiante")
    @ManyToOne(optional = false)
    private Estudiante idestudiante;
    @JoinColumn(name = "idtipoDocumento", referencedColumnName = "idtipoDocumento")
    @ManyToOne(optional = false)
    private Tipodocumento idtipoDocumento;

    public Acudiente() {
    }

    public Acudiente(Integer idacudiente) {
        this.idacudiente = idacudiente;
    }

    public Acudiente(Integer idacudiente, String documentoAcudiente, String nombreAcudiente, String apellidoAcudiente, String telefonoAcudiente, String direccionAcudiente, String profesionAcudiente, boolean eliminar) {
        this.idacudiente = idacudiente;
        this.documentoAcudiente = documentoAcudiente;
        this.nombreAcudiente = nombreAcudiente;
        this.apellidoAcudiente = apellidoAcudiente;
        this.telefonoAcudiente = telefonoAcudiente;
        this.direccionAcudiente = direccionAcudiente;
        this.profesionAcudiente = profesionAcudiente;
        this.eliminar = eliminar;
    }

    public Integer getIdacudiente() {
        return idacudiente;
    }

    public void setIdacudiente(Integer idacudiente) {
        this.idacudiente = idacudiente;
    }

    public String getDocumentoAcudiente() {
        return documentoAcudiente;
    }

    public void setDocumentoAcudiente(String documentoAcudiente) {
        this.documentoAcudiente = documentoAcudiente;
    }

    public String getNombreAcudiente() {
        return nombreAcudiente;
    }

    public void setNombreAcudiente(String nombreAcudiente) {
        this.nombreAcudiente = nombreAcudiente;
    }

    public String getApellidoAcudiente() {
        return apellidoAcudiente;
    }

    public void setApellidoAcudiente(String apellidoAcudiente) {
        this.apellidoAcudiente = apellidoAcudiente;
    }

    public String getTelefonoAcudiente() {
        return telefonoAcudiente;
    }

    public void setTelefonoAcudiente(String telefonoAcudiente) {
        this.telefonoAcudiente = telefonoAcudiente;
    }

    public String getDireccionAcudiente() {
        return direccionAcudiente;
    }

    public void setDireccionAcudiente(String direccionAcudiente) {
        this.direccionAcudiente = direccionAcudiente;
    }

    public String getProfesionAcudiente() {
        return profesionAcudiente;
    }

    public void setProfesionAcudiente(String profesionAcudiente) {
        this.profesionAcudiente = profesionAcudiente;
    }

    public boolean getEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    public Estudiante getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Estudiante idestudiante) {
        this.idestudiante = idestudiante;
    }

    public Tipodocumento getIdtipoDocumento() {
        return idtipoDocumento;
    }

    public void setIdtipoDocumento(Tipodocumento idtipoDocumento) {
        this.idtipoDocumento = idtipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idacudiente != null ? idacudiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acudiente)) {
            return false;
        }
        Acudiente other = (Acudiente) object;
        if ((this.idacudiente == null && other.idacudiente != null) || (this.idacudiente != null && !this.idacudiente.equals(other.idacudiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.plataforma1.modelo.Acudiente[ idacudiente=" + idacudiente + " ]";
    }
    
}
