/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.mundo.RutaTurno;

/**
 *
 * @author MiPc
 */
@ManagedBean
@RequestScoped
public class ReporteTotalValor extends Controller{
    private ArrayList<RutaTurno> rutasTurnos;
    /**
     * Creates a new instance of ReporteTotalValor
     */
    public ReporteTotalValor() {
        rutasTurnos= new ArrayList<>();
        super.darInstanciaMundo();
        rutasTurnos= mundo.seleccionarRutasDistintas();
    }
    public double darReporteValorRutaTurno(RutaTurno ruta){
        return mundo.reportarValorTotalVentaTiquetesParaRutaTurno(ruta);
    }

    public ArrayList<RutaTurno> getRutasTurnos() {
        return rutasTurnos;
    }

    public void setRutasTurnos(ArrayList<RutaTurno> rutasTurnos) {
        this.rutasTurnos = rutasTurnos;
    }
}
