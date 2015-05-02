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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import modelo.mundo.Linea;
import modelo.mundo.RutaTurno;
import modelo.mundo.RutasSuroccidente;
import modelo.mundo.Vehiculo;

/**
 *
 * @author MiPc
 */
@ManagedBean
@RequestScoped
@ApplicationScoped
@SessionScoped
public class AsignarRutaTurno extends Controller{

    private RutaTurno rutaTurnoAgregar;
    private String placa;
    private String hora;
    private ArrayList<Vehiculo> listaVehiculosSinRuta;
    private ArrayList<Vehiculo> listaVehiculosConRuta;
    /**
     * Creates a new instance of AsignarRutaTurno
     */
    public AsignarRutaTurno() {
        rutaTurnoAgregar= new RutaTurno("", "", null);
        listaVehiculosConRuta= new ArrayList<>();
        listaVehiculosSinRuta= new ArrayList<>();
        super.darInstanciaMundo();
        restablecerListas();
    }

    public void restablecerListas(){
        listaVehiculosConRuta.clear();
        listaVehiculosSinRuta.clear();
        for(int i=0; i<mundo.getMarcas().size();i++){
            ArrayList<Linea> misLineas = mundo.getMarcas().get(i).getLineas();
            for(int j=0; j< misLineas.size();j++){
                ArrayList<Vehiculo> misVehiculos = misLineas.get(j).getVehiculos();
                for(int k=0; k<misVehiculos.size();k++){
                    Vehiculo miVehiculo=misVehiculos.get(k);
                    if(miVehiculo.getRutaTurno()==null){
                        listaVehiculosSinRuta.add(miVehiculo);
                    }
                    else{
                        listaVehiculosConRuta.add(miVehiculo);
                    }
                }
            }
        }
    }
    public void asignarRutaTurno(){
        try {
            DateFormat formato= new SimpleDateFormat(RutasSuroccidente.FORMATO_HORAS);
            Date fecha=formato.parse(hora);
            rutaTurnoAgregar.setHoraSalida(fecha);
            mundo.asignarRutaTurnoVehiculo(rutaTurnoAgregar, placa);
            restablecerListas();
        } catch (ParseException ex) {
            Logger.getLogger(AsignarRutaTurno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public RutaTurno getRutaTurnoAgregar() {
        return rutaTurnoAgregar;
    }

    public void setRutaTurnoAgregar(RutaTurno rutaTurnoAgregar) {
        this.rutaTurnoAgregar = rutaTurnoAgregar;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public ArrayList<Vehiculo> getListaVehiculosSinRuta() {
        return listaVehiculosSinRuta;
    }

    public void setListaVehiculosSinRuta(ArrayList<Vehiculo> listaVehiculosSinRuta) {
        this.listaVehiculosSinRuta = listaVehiculosSinRuta;
    }

    public ArrayList<Vehiculo> getListaVehiculosConRuta() {
        return listaVehiculosConRuta;
    }

    public void setListaVehiculosConRuta(ArrayList<Vehiculo> listaVehiculosConRuta) {
        this.listaVehiculosConRuta = listaVehiculosConRuta;
    }
    
}
