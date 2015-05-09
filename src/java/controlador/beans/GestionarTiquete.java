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
public class GestionarTiquete extends Controller{

    private Tiquete tiqueteAgregar;
    private String horaVenta;
    private int identificacion;
    private String placa;
    private Cliente clienteTiquete;
    private ArrayList<Vehiculo> vehiculosConRuta;
    private ArrayList<Cliente> clientes;
    private ArrayList<Tiquete> tiquetes;
    /**
     * Creates a new instance of GestionarTiquetes
     */
    public GestionarTiquete() {
        super.darInstanciaMundo();
        tiqueteAgregar= new Tiquete(null, 0, 0);
        vehiculosConRuta= new ArrayList<>();
        clientes= new ArrayList<>();
        restablecerListas();
    }
    public void restablecerListas(){
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
            Logger.getLogger(GestionarTiquete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void restablecerListaTiquetes(Cliente cliente){
        ArrayList<Cliente> clientesMundo= mundo.getClientes();
        for(int i=0;i<clientesMundo.size();i++){
            Cliente miCliente =clientesMundo.get(i);
            if(cliente.getIdentificacion()== miCliente.getIdentificacion()){
                tiquetes= miCliente.getTiquetes();
            }
        }
    }
    public void verTiquetes(Cliente cliente){
        clienteTiquete= cliente;
        restablecerListaTiquetes(cliente);
        super.redireccionarVista("verTiquetes.xhtml");
    }
    public String canelarVentaTiquete(Tiquete tiqueteCancelar){
        mundo.cancelarVentaDeTiqueteACliente(tiqueteCancelar);
        restablecerListaTiquetes(clienteTiquete);
        return "verTiquetes.xhtml";
    }

    public String mostrarNombre(){
        return "TIQUETES DE "+clienteTiquete.getNombres();
    }
    
    public Tiquete getTiqueteAgregar() {
        return tiqueteAgregar;
    }

    public void setTiqueteAgregar(Tiquete tiqueteAgregar) {
        this.tiqueteAgregar = tiqueteAgregar;
    }

    public String getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(String horaVenta) {
        this.horaVenta = horaVenta;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public ArrayList<Vehiculo> getVehiculosConRuta() {
        return vehiculosConRuta;
    }

    public void setVehiculosConRuta(ArrayList<Vehiculo> vehiculosConRuta) {
        this.vehiculosConRuta = vehiculosConRuta;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Tiquete> getTiquetes() {
        return tiquetes;
    }

    public void setTiquetes(ArrayList<Tiquete> tiquetes) {
        this.tiquetes = tiquetes;
    }

    public Cliente getClienteTiquete() {
        return clienteTiquete;
    }

    public void setClienteTiquete(Cliente clienteTiquete) {
        this.clienteTiquete = clienteTiquete;
    }
    
}