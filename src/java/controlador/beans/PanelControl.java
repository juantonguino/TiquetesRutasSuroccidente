/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author MiPc
 */
@ManagedBean
@RequestScoped
public class PanelControl extends Controller{

    /**
     * Creates a new instance of PanelControl
     */
    public PanelControl() {
    }
    public void redireccionarGestionarMarca(){
        super.redireccionarVista("gestionarMarca.xhtml");
    }
    public void redireccionarGestionarLinea(){
        super.redireccionarVista("gestionarLinea.xhtml");
    }
    public void redireccionarGestionarVehiculo(){
        super.redireccionarVista("gestionarVehiculo.xhtml");
    }
    public void redireccionarGestionarCliente(){
        super.redireccionarVista("gestionarCliente.xhtml");
    }
    public void redireccionarGestionarPropietario(){
        super.redireccionarVista("gestionarPropietario.xhtml");
    }
}