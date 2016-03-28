/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.plataforma1.operaciones;

import co.com.plataforma1.modelo.Acudiente;
import co.com.plataforma1.modelo.Estudiante;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author luisa
 */
@Stateless
public class AcudienteFacade extends AbstractFacade<Acudiente> {
    
    @PersistenceContext(unitName = "plataforma1PU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public AcudienteFacade() {
        super(Acudiente.class);
    }
    
    public int ultimoReg() {
        try {
            int acudiente = (int) em.createQuery("SELECT MAX (a.idacudiente) FROM Acudiente a").getSingleResult();
            return acudiente;
        } catch (Exception e) {
            System.out.println("Error consulta Acudiente");
            e.printStackTrace();
        }
        return 0;
    }
    
    public void registrar(Acudiente acudiente, Estudiante estudiante, int IdAcudiente) {
        try {
            
            Acudiente acu = acudiente;
            Estudiante est = estudiante;
            List<Acudiente> acud = (List<Acudiente>) em.createQuery("SELECT a FROM Acudiente a WHERE a.documentoAcudiente= :documento").setParameter("documento", acu.getDocumentoAcudiente()).getResultList();
            if (acud != null) {
                
                Query sql = null;
                sql = em.createNativeQuery("{call registrar(:apellidoAcudiente, :direccionAcudiente, :documentoAcudiente, :IdTipoDocumentoAcu, :nombreAcudiente, :profesionAcudiente, :telefonoAcudiente, "
                        + ":apellidoEst, :colegiosAnteriores, :correoEst, :direccionEst, :documentoEst, :fechaNacimientoEst, :grado, :nombreEst, :sexoEst, :telefonoEst)}");
                sql.setParameter("apellidoAcudiente", acu.getApellidoAcudiente());
                sql.setParameter("direccionAcudiente", acu.getDireccionAcudiente());
                sql.setParameter("documentoAcudiente", acu.getDocumentoAcudiente());
                sql.setParameter("IdTipoDocumentoAcu", acu.getIdtipoDocumento());
                sql.setParameter("nombreAcudiente", acu.getNombreAcudiente());
                sql.setParameter("profesionAcudiente", acu.getProfesionAcudiente());
                sql.setParameter("telefonoAcudiente", acu.getTelefonoAcudiente());
                
                sql.setParameter("apellidoEst", est.getApellidoEstudiante());
                sql.setParameter("colegiosAnteriores", est.getColegiosAnteriores());
                sql.setParameter("correoEst", est.getCorreo());
                sql.setParameter("direccionEst", est.getDireccion());
                sql.setParameter("fechaNacimientoEst", est.getFechaNacimiento());
                sql.setParameter("grado", est.getIdgrado());
                sql.setParameter("nombreEst", est.getNombreEstudiante());
                sql.setParameter("sexoEst", est.getSexo());
                sql.setParameter("telefonoEst", est.getTelefono());
                int ultimoRegistro = (int) em.createQuery("SELECT MAX (a.idacudiente) FROM Acudiente a").getSingleResult();
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Agregado", "Correctamente"));
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            }else{
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Error", "al registrar"));
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            }
            
        } catch (Exception e) {
            System.out.println("Error en el query registrar");
            e.printStackTrace();
        }
        
    }
    
}
