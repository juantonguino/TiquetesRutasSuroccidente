package modelo.datos;

import modelo.mundo.*;


/**
 * Clase encargada de almacenar informacion de los tiquetes en la base de datos
 */
public class TiqueteDAO {
	
	
	/**
	 * Atributo encargado de enlazar la clase FachadaDB
	 */
	private FachadaDB fachada;
	
	
	/**
	 * Metodo constructor de la clase TiqueteDAO
	 */
	public TiqueteDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Metodo encargado de instanciar un objeto de la clase Tiquete
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @return Debe ser un objeto de tipo Tiquete
	 */
	public Tiquete seleccionar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo){
		return null;
	}
	
	
	/**
	 * Metodo encargado de actualizar la información de un tiquete en la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @param nTiquete
	 */
	public void actualizar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, Tiquete nTiquete){
		
	}
	
	
	/**
	 * Metodo encargado de agregar un tiquete en la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @param nTiquete
	 */
	public void agregar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, Tiquete nTiquete){
		
	}
	
	
	/**
	 * Metodo encargado de eliminar un tiquete en la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @param nTiquete
	 */
	public void eliminar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, Tiquete nTiquete){
		
	}
}