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
import modelo.mundo.Propietario;
import modelo.mundo.Vehiculo;

/**
 *
 * @author MiPc
 */
@ManagedBean
@RequestScoped
@ApplicationScoped
@SessionScoped
public class GestionarPropietario extends Controller{

    
    private Propietario propietarioAgregar;
    private Propietario propietarioBuscar;
    private Propietario propietarioModificar;
    private String placaVehiculo;
    private static List<Vehiculo> listaVehiculos;
    private static List<Propietario> listaPropietarios;
    /**
     * Creates a new instance of GestionarPropietario
     */
    public GestionarPropietario() {
        propietarioAgregar= new Propietario(0, "", "", "", 0);
        propietarioBuscar= new Propietario(0, "", "", "", 0);
        propietarioModificar= new Propietario(0, "", "", "", 0);
        placaVehiculo="";
        listaVehiculos= new ArrayList<>();
        listaPropietarios= new ArrayList<>();
        super.darInstanciaMundo();
        restablecerListaVehiculos();
        restablecerListaPropietarios();
    }
    //--------------------------------------------------------------------------
    //REQUERIMIENTOS
    //--------------------------------------------------------------------------
    public void restablecerListaVehiculos(){
        listaVehiculos.clear();
        ArrayList<Marca> marcas= mundo.getMarcas();
        for(int i=0;i<marcas.size();i++){
            Marca miMarca = marcas.get(i);
            ArrayList<Linea> misLineas = miMarca.getLineas();
            for(int j=0;j<misLineas.size();j++){
                Linea miLinea = misLineas.get(j);
                ArrayList<Vehiculo> misVehiculos = miLinea.getVehiculos();
                for(int k=0;k<misVehiculos.size();k++){
                    Vehiculo miVehiculo = misVehiculos.get(k);
                    Propietario miPropietario = miVehiculo.getPropietario();
                    if(miPropietario==null){
                        listaVehiculos.add(miVehiculo);
                    }
                }
            }
        }
    }
    public void restablecerListaPropietarios(){
        listaPropietarios.clear();
        ArrayList<Marca> marcas= mundo.getMarcas();
        for(int i=0;i<marcas.size();i++){
            Marca miMarca = marcas.get(i);
            ArrayList<Linea> misLineas = miMarca.getLineas();
            for(int j=0;j<misLineas.size();j++){
                Linea miLinea = misLineas.get(j);
                ArrayList<Vehiculo> misVehiculos = miLinea.getVehiculos();
                for(int k=0;k<misVehiculos.size();k++){
                    Vehiculo miVehiculo = misVehiculos.get(k);
                    Propietario miPropietario = miVehiculo.getPropietario();
                    if(miPropietario!=null){
                        listaPropietarios.add(miPropietario);
                    }
                }
            }
        }
    }
    public void agregar(){
        mundo.agregarPropietario(propietarioAgregar.getApellidos(), propietarioAgregar.getDireccion(), propietarioAgregar.getIdentificacion(), propietarioAgregar.getNombres(), propietarioAgregar.getTelefono(), placaVehiculo);
        restablecerListaPropietarios();
        restablecerListaVehiculos();
    }
    public void buscar(){
        Propietario propietario = mundo.buscarPropietario(propietarioBuscar.getIdentificacion());
        if(propietario!=null){
            listaPropietarios.clear();
            listaPropietarios.add(propietario);
        }
        else{
            listaPropietarios.clear();
        }
    }
    public void eliminar(Propietario propietario){
        mundo.eliminarPorpietarioVehiculo(propietario.getIdentificacion());
        restablecerListaPropietarios();
        restablecerListaVehiculos();
    }
    public String redireccionarModificar(Propietario propietario){
        propietarioModificar= propietario;
        return "modificarPropietario.xhtml";
    }
    public void modificarPropietario(){
        mundo.modificarPropietario(propietarioModificar.getApellidos(), propietarioModificar.getDireccion(), propietarioModificar.getIdentificacion(), propietarioModificar.getNombres(), propietarioModificar.getTelefono());
        super.redireccionarVista("gestionarPropietario.xhtml");
    }
    public void irPanelControl(){
        super.redireccionarVista("index.xhtml");
    }
    //--------------------------------------------------------------------------
    //GETTERS AND SETTERS
    //--------------------------------------------------------------------------

    public Propietario getPropietarioAgregar() {
        return propietarioAgregar;
    }

    public void setPropietarioAgregar(Propietario propietarioAgregar) {
        this.propietarioAgregar = propietarioAgregar;
    }

    public Propietario getPropietarioBuscar() {
        return propietarioBuscar;
    }

    public void setPropietarioBuscar(Propietario propietarioBuscar) {
        this.propietarioBuscar = propietarioBuscar;
    }

    public Propietario getPropietarioModificar() {
        return propietarioModificar;
    }

    public void setPropietarioModificar(Propietario propietarioModificar) {
        this.propietarioModificar = propietarioModificar;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        GestionarPropietario.listaVehiculos = listaVehiculos;
    }

    public List<Propietario> getListaPropietarios() {
        return listaPropietarios;
    }

    public void setListaPropietarios(List<Propietario> listaPropietarios) {
        GestionarPropietario.listaPropietarios = listaPropietarios;
    }
}