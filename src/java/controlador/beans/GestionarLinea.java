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

/**
 *
 * @author MiPc
 */
@ManagedBean
@RequestScoped
@ApplicationScoped
@SessionScoped
public class GestionarLinea extends Controller{
    
    
    private String nombreLineaAgregar;
    private String nombreLineaBuscar;
    private String nombreLineaModificar;
    private String viejoNombreLineaModificar;
    private String nombreMarca;
    private static List<Linea> listaLineas;
    private static List<Marca> listaMarcas;
    /**
     * Creates a new instance of GestionarLinea
     */
    public GestionarLinea() {
        nombreLineaAgregar="";
        nombreLineaBuscar="";
        nombreLineaModificar="";
        viejoNombreLineaModificar="";
        nombreMarca="";
        listaMarcas=new ArrayList<>();
        listaLineas= new ArrayList<>();
        super.darInstanciaMundo();
        listaMarcas.clear();
        listaMarcas.addAll(super.mundo.getMarcas());
        restablecerLista();
    }
    //--------------------------------------------------------------------------
    //REQUERIMIENTOS
    //--------------------------------------------------------------------------
    public void restablecerLista(){
        listaLineas.clear();
        ArrayList<Marca> misMarcas = mundo.getMarcas();
        for(int i=0;i<misMarcas.size();i++){
            Marca miMarca = misMarcas.get(i);
            ArrayList<Linea> misLineas = miMarca.getLineas();
            for(int j=0;j<misLineas.size();j++){
                Linea miLinea = misLineas.get(j);
                listaLineas.add(miLinea);
            }
        }
    }
    public void agregar(){
        mundo.agregarLinea(nombreMarca, nombreLineaAgregar);
        restablecerLista();
    }
    public void buscar(){
        Linea linea = mundo.buscarLinea(nombreLineaBuscar);
        if(linea!=null){
            listaLineas.clear();
            listaLineas.add(linea);
        }
        else{
            listaLineas.clear();
        }
    }
    public void eliminar(Linea linea){
        mundo.eliminarLinea(linea.getNombre());
        restablecerLista();
    }
    public String redireccionarModificar(Linea linea){
        viejoNombreLineaModificar= linea.getNombre();
        return "modificarLinea.xhtml";
    }
    public void modificarLinea(){
        mundo.modificarLinea(nombreLineaModificar, viejoNombreLineaModificar);
        super.redireccionarVista("gestionarLinea.xhtml");
    }
    public void irPanelControl(){
        super.redireccionarVista("index.xhtml");
    }
    //--------------------------------------------------------------------------
    //GETTERS AND SETTERS
    //--------------------------------------------------------------------------

    public String getNombreLineaAgregar() {
        return nombreLineaAgregar;
    }

    public void setNombreLineaAgregar(String nombreLineaAgregar) {
        this.nombreLineaAgregar = nombreLineaAgregar;
    }

    public String getNombreLineaBuscar() {
        return nombreLineaBuscar;
    }

    public void setNombreLineaBuscar(String nombreLineaBuscar) {
        this.nombreLineaBuscar = nombreLineaBuscar;
    }

    public String getNombreLineaModificar() {
        return nombreLineaModificar;
    }

    public void setNombreLineaModificar(String nombreLineaModificar) {
        this.nombreLineaModificar = nombreLineaModificar;
    }

    public String getViejoNombreLineaModificar() {
        return viejoNombreLineaModificar;
    }

    public void setViejoNombreLineaModificar(String viejoNombreLineaModificar) {
        this.viejoNombreLineaModificar = viejoNombreLineaModificar;
    }

    public List<Linea> getListaLineas() {
        return listaLineas;
    }

    public static void setListaLineas(List<Linea> listaLineas) {
        GestionarLinea.listaLineas = listaLineas;
    }

    public List<Marca> getListaMarcas() {
        return listaMarcas;
    }

    public void setListaMarcas(List<Marca> listaMarcas) {
        GestionarLinea.listaMarcas = listaMarcas;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }    
}