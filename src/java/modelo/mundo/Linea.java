package modelo.mundo;

import java.util.ArrayList;

import modelo.datos.VehiculoDAO;


/**
 * calse encargada del manejo de la inforamcaion de lineas
 * @author megasoft
 * Universidad Mariana (Pasto - Colombia) 
 * Departamento de Ingeniería de Sistemas. 
 */
public class Linea {
	
	
	/**
	 * el nombre de una linea
	 */
	private String nombre;
	
	
	/**
	 * el atributo encargado de los vehiculos en la base de datos
	 */
	private VehiculoDAO vehiculoDAO;
	
	
	/**
	 * la lista de vehiculos incluidos dentro de linea
	 */
	private ArrayList<Vehiculo> vehiculos;
	
	
	/**
	 * metodo constructor de la clase Linea DAO
	 * <b>pot:</b> se ha creado una linea con el nombre pasado como parametro, 
	 * ademas se inicializado la lista de vehiculos y el atributo 
	 * encargado del manejo de la base de datos
	 * @param nNombre el nombre de la linea nNombre !=""
	 */
	public Linea(String nNombre){
		nombre=nNombre;
		vehiculoDAO= new VehiculoDAO();
		vehiculos= new ArrayList<Vehiculo>();
	}


	/**
	 * metodo que retorna el nombre de una linea
	 * @return el nombre de una linea
	 */
	public String getNombre() {
		return nombre;
	}
	
	
	/**
	 * metodo que permite cambiar el nombre de la linea<br>
	 * <b>post:</b> se ha cambiado el nombre de la linea por el ingresado como parametro
	 * @param nombre el nombre de la linea linea !=""
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * metodo que retorna la lista de vehiculos
	 * @return la lista de vehiculos
	 */
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}


	/**
	 * metodo que permite cambiar el la lista de vhiculos
	 * <b>post:</b> se ha cambiado la lista de vehiculos por la lista ingresada como parametro
	 * @param vehiculos la lista de vehiculos vehiculos!=null
	 */
	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}


	/**
	 * metodo que retorna el atributo vehiculoDAO
	 * @return el atributo vehiculoDAO
	 */
	public VehiculoDAO getVehiculoDAO() {
		return vehiculoDAO;
	}


	/**
	 * metodo que permite cambiar el atributo vehiculoDAO
	 * <b>post:</b> se ha cambiado el atributo vehiculoDAO por el ingresado como parametro
	 * @param vehiculoDAO el atributo DAO a cambiar vehiculoDAO!=null
	 */
	public void setVehiculoDAO(VehiculoDAO vehiculoDAO) {
		this.vehiculoDAO = vehiculoDAO;
	}
}