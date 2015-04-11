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
import modelo.mundo.Marca;

/**
 *
 * @author MiPc
 */
@ManagedBean
@RequestScoped
@ApplicationScoped
@SessionScoped
public class GestionarMarca extends Controller{

    
    /**
     * el nombre de la marca a gregar
     */
    private String nombreMarcaAgregar;
    
    
    /**
     * el nombre de la marca por la cual se agrega
     */
    private String nombreMarcaBuscar;
    
    
    /**
     * el nombre de la marca por el cual modifica
     */
    private String nombreMarcaModificar;
    
    
    /**
     * el nombre viejo de la marca 
     */
    private String viejoNombreMarcaModificar;
    
    
    /**
     * lista por la cual se muesta las marcas
     */
    private static List<Marca> listaMarca;
    
    
    /**
     * crea una nueva instacia de GestionarMarca
     */
    public GestionarMarca() {
        nombreMarcaAgregar="";
        nombreMarcaBuscar="";
        nombreMarcaModificar="";
        viejoNombreMarcaModificar="";
        listaMarca= new ArrayList<>();
        darInstanciaMundo();
        restablecerlista();
    }
    //--------------------------------------------------------------------------
    //REQUERIMIENTOS
    //--------------------------------------------------------------------------
    public void restablecerlista(){
        listaMarca.clear();
        listaMarca.addAll(mundo.getMarcas());
    }
    public void agregar(){
        mundo.agregarMarca(nombreMarcaAgregar);
        restablecerlista();
    }
    public void buscar(){
        Marca marca = mundo.buscarMarca(nombreMarcaBuscar);
        if(marca!=null){
            listaMarca.clear();
            listaMarca.add(marca);
        }
        else{
            listaMarca.clear();
        }
    }
    public void eliminar(Marca marca){
        mundo.eliminarMarca(marca.getNombre());
        restablecerlista();
    }
    public String redireccionarModificar(Marca marca){
        viejoNombreMarcaModificar= marca.getNombre();
        return "modificarMarca.xhtml";
    }
    public void modificarMarca(){
        mundo.modificarMarca(nombreMarcaModificar, viejoNombreMarcaModificar);
        super.redireccionarVista("gestionarMarca.xhtml");
    }
    public void irPanelControl(){
        super.redireccionarVista("index.xhtml");
    }
    //--------------------------------------------------------------------------
    //GETTERS AND SETTERS
    //--------------------------------------------------------------------------

    public String getNombreMarcaAgregar() {
        return nombreMarcaAgregar;
    }

    public void setNombreMarcaAgregar(String nombreMarcaAgregar) {
        this.nombreMarcaAgregar = nombreMarcaAgregar;
    }

    public String getNombreMarcaBuscar() {
        return nombreMarcaBuscar;
    }

    public void setNombreMarcaBuscar(String nombreMarcaBuscar) {
        this.nombreMarcaBuscar = nombreMarcaBuscar;
    }

    public String getNombreMarcaModificar() {
        return nombreMarcaModificar;
    }

    public void setNombreMarcaModificar(String nombreMarcaModificar) {
        this.nombreMarcaModificar = nombreMarcaModificar;
    }

    public String getViejoNombreMarcaModificar() {
        return viejoNombreMarcaModificar;
    }

    public void setViejoNombreMarcaModificar(String viejoNombreMarcaModificar) {
        this.viejoNombreMarcaModificar = viejoNombreMarcaModificar;
    }

    public List<Marca> getListaMarca() {
        return listaMarca;
    }

    public void setListaMarca(List<Marca> listaMarca) {
        GestionarMarca.listaMarca = listaMarca;
    }
}