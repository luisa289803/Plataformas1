/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.plataforma1.operaciones;

import co.com.plataforma1.modelo.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author luisa
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "plataforma1PU")
    private EntityManager em;
     private List<Usuario> Lista;
    private Usuario usuario = null;
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
     public List<Usuario> ListaUsuario(){
  Lista = em.createNamedQuery("Usuario.findAll").getResultList();
   return Lista;
    }
    
    public void eliminar(Usuario usuarioborrado) {

      try{
      int query = em.createQuery("UPDATE Usuario u SET u.eliminar = 1 WHERE u.idusuario =:id").setParameter("id",usuarioborrado.getIdusuario()).executeUpdate();
      }catch(Exception e){
      
          System.out.println("Error al eliminar usuario");
          e.printStackTrace();
      
      }

    }

    public List<Usuario> getLista() {
        return Lista;
    }

    public void setLista(List<Usuario> Lista) {
        this.Lista = Lista;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Usuario listaDeUsuario(String usuario, String clave) {
        try {
            Usuario u = (Usuario) em.createQuery("SELECT U FROM Usuario U WHERE U.usuario = :Usuario and U.clave = :clave").setParameter("Usuario", usuario).setParameter("clave", clave).getSingleResult();
            if (u != null) {
                return u;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}


