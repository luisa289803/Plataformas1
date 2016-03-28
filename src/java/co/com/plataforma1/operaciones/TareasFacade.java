/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.plataforma1.operaciones;

import co.com.plataforma1.modelo.Tareas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author luisa
 */
@Stateless
public class TareasFacade extends AbstractFacade<Tareas> {

    @PersistenceContext(unitName = "plataforma1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TareasFacade() {
        super(Tareas.class);
    }
    
}
