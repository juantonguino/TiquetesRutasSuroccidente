/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import modelo.mundo.RutasSuroccidente;

/**
 *
 * @author MiPc
 */
@ManagedBean
@RequestScoped
@ApplicationScoped
public class Controller {

    protected RutasSuroccidente mundo;
    /**
     * Creates a new instance of Controller
     */
    public Controller() {
    }
    
    
    public RutasSuroccidente darInstanciaMundo(){
        mundo= RutasSuroccidente.darInstancia();
        return mundo;
    }
    /**
     * metodo que oermite redireccionar las vistas
     * @param nombreVista el nombre del archivo con la vista
     */
    public void redireccionarVista(String nombreVista){
        try{
        FacesContext contex= FacesContext.getCurrentInstance();
        contex.getExternalContext().redirect(nombreVista);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}