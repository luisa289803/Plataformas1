package co.com.plataforma1.controladores;

import co.com.plataforma1.modelo.Usuario;
import co.com.plataforma1.controladores.util.JsfUtil;
import co.com.plataforma1.controladores.util.JsfUtil.PersistAction;
import co.com.plataforma1.operaciones.UsuarioFacade;
import java.io.IOException;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;

@Named("usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    @EJB
    private co.com.plataforma1.operaciones.UsuarioFacade ejbFacade;
    private List<Usuario> items = null;
    private Usuario selected = new Usuario();
    private List<Usuario> listaUsuario = null;
    private Usuario u = new Usuario();
    private String claveOculta = null;

    public UsuarioController() {
    }

    public String validado() {
        selected.setClave(DigestUtils.sha256Hex(selected.getClave()));
        try {

            u = ejbFacade.listaDeUsuario(selected.getUsuario(), selected.getClave());
            if (u != null) {

                if (u.getIdRol().getTipoRol().equals("Estudiante")) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Exelente!", "Entro"));
                    return "index?faces-redirect=true";
                }
                if (u.getIdRol().getTipoRol().equals("Docente")) {
                    return "index?faces-redirect=true";
                }
                if (u.getIdRol().getTipoRol().equals("Administrador")) {
                    return "index?faces-redirect=true";
                }

            }
        } catch (Exception e) {
            throw e;
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡ERROR!", "El usuario o la contraseña no coinciden con ninguna cuenta"));
        return null;

    }

    public void cerrarSesion() {

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        Object session = externalContext.getSession(false);
        HttpSession httpSession = (HttpSession) session;
        httpSession.invalidate();
    }

    public void validarSesion() {
        if (u.getUsuario() == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/plataforma1/faces/login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Usuario getSelected() {
        return selected;
    }

    public List<Usuario> listar() {
        listaUsuario = ejbFacade.ListaUsuario();
        return listaUsuario;
    }

    public void borradoLogico() {
        ejbFacade.eliminar(selected);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Usuario eliminado"));

    }

    public void setSelected(Usuario selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private UsuarioFacade getFacade() {
        return ejbFacade;
    }

    public Usuario prepareCreate() {
        selected = new Usuario();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        this.selected.setClave(DigestUtils.sha256Hex(claveOculta));
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UsuarioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        claveOculta = null;
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }

    public void update() {
        this.selected.setClave(DigestUtils.sha256Hex(claveOculta));
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UsuarioUpdated"));
    }

    public void destroy() {
        ejbFacade.eliminar(selected);
    }

    public List<Usuario> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Usuario getUsuario(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Usuario> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Usuario> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public co.com.plataforma1.operaciones.UsuarioFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(co.com.plataforma1.operaciones.UsuarioFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }

    public String getClaveOculta() {
        return claveOculta;
    }

    public void setClaveOculta(String claveOculta) {
        this.claveOculta = claveOculta;
    }

  

    @FacesConverter(forClass = Usuario.class)
    public static class UsuarioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuarioController controller = (UsuarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuarioController");
            return controller.getUsuario(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Usuario) {
                Usuario o = (Usuario) object;
                return getStringKey(o.getIdusuario());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Usuario.class.getName()});
                return null;
            }
        }

    }

}
