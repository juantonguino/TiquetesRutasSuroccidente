/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import modelo.mundo.Tiquete;

/**
 *
 * @author MiPc
 */
@ManagedBean
@RequestScoped
@SessionScoped
@ApplicationScoped
public class GestionarTiquetes {

    private Tiquete tiqueteAgregar;
    private String horaVenta;
    private int identificacion;
    private String placa;
    /**
     * Creates a new instance of GestionarTiquetes
     */
    public GestionarTiquetes() {
    }
}
