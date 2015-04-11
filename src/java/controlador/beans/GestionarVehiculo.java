/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import modelo.mundo.Linea;
import modelo.mundo.Marca;
import modelo.mundo.Vehiculo;

/**
 *
 * @author MiPc
 */
@ManagedBean
@RequestScoped
@ApplicationScoped
@SessionScoped
public class GestionarVehiculo extends Controller{

    private Vehiculo vehiculoAgregar;
    private Vehiculo vehiculoBuscar;
    private Vehiculo vehiculoModificar;
    private String nombreLinea;
    private static List<Linea> listaLineas;
    private static List<Vehiculo> listaVehiculos;
    /**
     * Creates a new instance of GestionarVehiculo
     */
    public GestionarVehiculo() {
        vehiculoAgregar= new Vehiculo(0, "", 0, null);
        vehiculoBuscar= new Vehiculo(0, "", 0, null);
        vehiculoModificar= new Vehiculo(0, "", 0, null);
        nombreLinea="";
        listaLineas=new ArrayList<>();
        listaVehiculos= new ArrayList<>();
        super.darInstanciaMundo();
        restablecerListaLineas();
        restablecerListaVehiculos();
    }
    //--------------------------------------------------------------------------
    //REQUERIMIENTOS
    //--------------------------------------------------------------------------
    public void restablecerListaLineas(){
        listaLineas.clear();
        ArrayList<Marca> misMarcas = mundo.getMarcas();
        for(int i=0;i<misMarcas.size();i++){
            Marca miMarca = misMarcas.get(i);
            ArrayList<Linea> misLineas = miMarca.getLineas();
            for(int j=0; j<misLineas.size();j++){
                Linea miLinea = misLineas.get(j);
                listaLineas.add(miLinea);
            }
        }
    }
    public void restablecerListaVehiculos(){
        listaVehiculos.clear();
        ArrayList<Marca> misMarcas = mundo.getMarcas();
        for(int i=0;i<misMarcas.size();i++){
            Marca miMarca = misMarcas.get(i);
            ArrayList<Linea> misLineas = miMarca.getLineas();
            for(int j=0; j<misLineas.size();j++){
                Linea miLinea = misLineas.get(j);
                ArrayList<Vehiculo> misVehiculos = miLinea.getVehiculos();
                for(int k=0;k<misVehiculos.size();k++){
                    Vehiculo miVehiculo = misVehiculos.get(k);
                    listaVehiculos.add(miVehiculo);
                }
            }
        }
    }
    public void agregar(){
        mundo.agregarVehiculo(nombreLinea, vehiculoAgregar.getModelo(), vehiculoAgregar.getPlaca(), vehiculoAgregar.getNumeroPasajeros(), null);
        restablecerListaVehiculos();
    }
    public void buscar(){
        Vehiculo vehiculo = mundo.buscarVehiculo(vehiculoBuscar.getPlaca());
        if(vehiculo!=null){
            listaVehiculos.clear();
            listaVehiculos.add(vehiculo);
        }
        else{
            listaVehiculos.clear();
        }
    }
    public void eliminar(Vehiculo vehiculo){
        mundo.eliminarVehiculo(vehiculo.getPlaca());
        restablecerListaVehiculos();
    }
    public String redireccionarModificar(Vehiculo vehiculo){
        vehiculoModificar= vehiculo;
        return "modificarVehiculo.xhtml";
    }
    public void modificarVehiculo(){
        mundo.modificarVehiculo(vehiculoModificar.getModelo(), vehiculoModificar.getNumeroPasajeros(), null, vehiculoModificar.getPlaca());
        super.redireccionarVista("gestionarVehiculo.xhtml");
    }
    public void irPanelControl(){
        super.redireccionarVista("index.xhtml");
    }
    //--------------------------------------------------------------------------
    //GETTERS AND SETTERS
    //--------------------------------------------------------------------------

    public Vehiculo getVehiculoAgregar() {
        return vehiculoAgregar;
    }

    public void setVehiculoAgregar(Vehiculo vehiculoAgregar) {
        this.vehiculoAgregar = vehiculoAgregar;
    }

    public Vehiculo getVehiculoBuscar() {
        return vehiculoBuscar;
    }

    public void setVehiculoBuscar(Vehiculo vehiculoBuscar) {
        this.vehiculoBuscar = vehiculoBuscar;
    }

    public Vehiculo getVehiculoModificar() {
        return vehiculoModificar;
    }

    public void setVehiculoModificar(Vehiculo vehiculoModificar) {
        this.vehiculoModificar = vehiculoModificar;
    }

    public String getNombreLinea() {
        return nombreLinea;
    }

    public void setNombreLinea(String nombreLinea) {
        this.nombreLinea = nombreLinea;
    }

    public List<Linea> getListaLineas() {
        return listaLineas;
    }

    public void setListaLineas(List<Linea> listaLineas) {
        GestionarVehiculo.listaLineas = listaLineas;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        GestionarVehiculo.listaVehiculos = listaVehiculos;
    }
}