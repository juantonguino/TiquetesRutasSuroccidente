/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.mundo.Linea;
import modelo.mundo.Vehiculo;

/**
 *
 * @author MiPc
 */
@ManagedBean
@RequestScoped
public class ReporteNumeroTiequetesVendidos extends Controller{
    private ArrayList<Vehiculo> listaVehiculosConRuta;
    /**
     * Creates a new instance of ReporteNumeroTiequetesVendidos
     */
    public ReporteNumeroTiequetesVendidos() {
        listaVehiculosConRuta= new ArrayList<>();
        super.darInstanciaMundo();
        restablecerListas();
    }
    public void restablecerListas(){
        listaVehiculosConRuta.clear();
        for(int i=0; i<mundo.getMarcas().size();i++){
            ArrayList<Linea> misLineas = mundo.getMarcas().get(i).getLineas();
            for(int j=0; j< misLineas.size();j++){
                ArrayList<Vehiculo> misVehiculos = misLineas.get(j).getVehiculos();
                for(int k=0; k<misVehiculos.size();k++){
                    Vehiculo miVehiculo=misVehiculos.get(k);
                    if(miVehiculo.getRutaTurno()!=null){
                        listaVehiculosConRuta.add(miVehiculo);
                    }
                }
            }
        }
    }
    public int darReporteNumeroTiquetes(String placa){
        return mundo.reportarNumeroTiquetesVendidosDeVehiculoPorRutaTurno(placa);
    }

    public ArrayList<Vehiculo> getListaVehiculosConRuta() {
        return listaVehiculosConRuta;
    }

    public void setListaVehiculosConRuta(ArrayList<Vehiculo> listaVehiculosConRuta) {
        this.listaVehiculosConRuta = listaVehiculosConRuta;
    }
    
}
