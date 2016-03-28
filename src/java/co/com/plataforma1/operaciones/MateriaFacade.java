/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.plataforma1.operaciones;

import co.com.plataforma1.modelo.Materia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author luisa
 */
@Stateless
public class MateriaFacade extends AbstractFacade<Materia> {

    @PersistenceContext(unitName = "plataforma1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MateriaFacade() {
        super(Materia.class);
    }

    public List<Materia> listaMateriasXDocente(Integer idDocente) {
        try {
            return (List<Materia>) em.createQuery("SELECT m FROM Materia m, Docentemateria t WHERE m.idmateria = t.idmateria.idmateria AND t.iddocente.iddocente = :idDocente").setParameter("idDocente", idDocente).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
