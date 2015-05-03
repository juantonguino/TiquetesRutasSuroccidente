/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import modelo.mundo.Cliente;
import modelo.mundo.Linea;
import modelo.mundo.Propietario;
import modelo.mundo.RutasSuroccidente;
import modelo.mundo.Tiquete;
import modelo.mundo.Vehiculo;

/**
 *
 * @author MiPc
 */
@ManagedBean
@RequestScoped
@SessionScoped
@ApplicationScoped
public class GestionarTiquetes extends Controller{

    private Tiquete tiqueteAgregar;
    private String horaVenta;
    private int identificacion;
    private String placa;
    private ArrayList<Vehiculo> vehiculosConRuta;
    private ArrayList<Cliente> clientes;
    /**
     * Creates a new instance of GestionarTiquetes
     */
    public GestionarTiquetes() {
        super.darInstanciaMundo();
        tiqueteAgregar= new Tiquete(null, 0, 0);
        vehiculosConRuta= new ArrayList<>();
        clientes= new ArrayList<>();
        restablecerListas();
    }
    public void restablecerListas(){
        clientes.clear();
        clientes= mundo.getClientes();
        vehiculosConRuta.clear();
        for(int i=0; i<mundo.getMarcas().size();i++){
            ArrayList<Linea> misLineas = mundo.getMarcas().get(i).getLineas();
            for(int j=0; j< misLineas.size();j++){
                ArrayList<Vehiculo> misVehiculos = misLineas.get(j).getVehiculos();
                for(int k=0; k<misVehiculos.size();k++){
                    Vehiculo miVehiculo=misVehiculos.get(k);
                    if(miVehiculo.getRutaTurno()!=null){
                        vehiculosConRuta.add(miVehiculo);
                    }
                }
            }
        }
    }
    public void venderTiquete(){
        DateFormat formato= new SimpleDateFormat(RutasSuroccidente.FORMATO_HORAS);
        Date fecha;
        try {
            fecha = formato.parse(horaVenta);
            tiqueteAgregar.setHoraVenta(fecha);
            mundo.venderTiqueteACliente(tiqueteAgregar, placa, identificacion);
            restablecerListas();
        } catch (ParseException ex) {
            Logger.getLogger(GestionarTiquetes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void canelarVentaTiquete(Tiquete tiqueteCancelar){
        mundo.cancelarVentaDeTiqueteACliente(tiqueteCancelar);
    }
}