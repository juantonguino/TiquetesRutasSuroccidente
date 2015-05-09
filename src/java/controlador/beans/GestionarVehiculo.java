/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import modelo.mundo.Linea;
import modelo.mundo.Marca;
import modelo.mundo.Vehiculo;
import org.apache.tomcat.util.http.fileupload.UploadContext;
import org.primefaces.model.UploadedFile;

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
    private UploadedFile imagenArchivo;
    private UploadedFile imagenArchivoModificar;
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
        cargarArchivoAgregar();
        mundo.agregarVehiculo(nombreLinea, vehiculoAgregar.getModelo(), vehiculoAgregar.getPlaca(), vehiculoAgregar.getNumeroPasajeros(), vehiculoAgregar.getFotografia());
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
        cargarArchivoMofificar();
        mundo.modificarVehiculo(vehiculoModificar.getModelo(), vehiculoModificar.getNumeroPasajeros(), vehiculoModificar.getFotografia(), vehiculoModificar.getPlaca());
        super.redireccionarVista("gestionarVehiculo.xhtml");
    }
    public void irPanelControl(){
        super.redireccionarVista("index.xhtml");
    }
    public void cargarArchivoAgregar(){
        InputStream inputStream= null;
        OutputStream outputStream=null;
        try{
            ServletContext servletContext= (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String carpetaImgenes= (String)servletContext.getRealPath("/imagenes");
            outputStream =new FileOutputStream(new File(carpetaImgenes+"/"+this.vehiculoAgregar.getPlaca()+".png"));
            inputStream= imagenArchivo.getInputstream();
            vehiculoAgregar.setFotografia(this.vehiculoAgregar.getPlaca()+".png");
            
            int read=0;
            byte[] bytes= new byte[1024];
            while((read=inputStream.read(bytes))!=-1){
                outputStream.write(bytes, 0, read);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(GestionarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(GestionarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void cargarArchivoMofificar(){
        InputStream inputStream= null;
        OutputStream outputStream=null;
        try{
            ServletContext servletContext= (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String carpetaImgenes= (String)servletContext.getRealPath("/imagenes");
            outputStream =new FileOutputStream(new File(carpetaImgenes+"/"+this.vehiculoModificar.getPlaca()+".png"));
            inputStream= imagenArchivoModificar.getInputstream();
            vehiculoAgregar.setFotografia(this.vehiculoModificar.getPlaca()+".png");
            
            int read=0;
            byte[] bytes= new byte[1024];
            while((read=inputStream.read(bytes))!=-1){
                outputStream.write(bytes, 0, read);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(GestionarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(GestionarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
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

    public UploadedFile getImagenArchivo() {
        return imagenArchivo;
    }

    public void setImagenArchivo(UploadedFile imagenArchivo) {
        this.imagenArchivo = imagenArchivo;
    }

    public UploadedFile getImagenArchivoModificar() {
        return imagenArchivoModificar;
    }

    public void setImagenArchivoModificar(UploadedFile imagenArchivoModificar) {
        this.imagenArchivoModificar = imagenArchivoModificar;
    }
}