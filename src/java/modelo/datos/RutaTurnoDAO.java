package modelo.datos;

import modelo.mundo.Cliente;
import modelo.mundo.Linea;
import modelo.mundo.Marca;
import modelo.mundo.RutaTurno;
import modelo.mundo.Tiquete;
import modelo.mundo.Vehiculo;


/**
 * Clase encargada de almacenar informacion de las rutas de turno de los vehículos en la base de datos
 */
public class RutaTurnoDAO {
	
	
	/**
	 * Atributo encargado de enlazar la clase FachadaDB
	 */
	private FachadaDB fachada;
	
	
	/**
	 * Metodo constructor de la clase RutaTurnoDAO
	 */
	public RutaTurnoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Metodo encargado de instanciar un objeto de la clase RutaTurno
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @return Debe ser un objeto de tipo RutaTurno
	 */
	public RutaTurno seleccionar(Marca nMarca, Linea nLinea,Vehiculo nVehiculo){
		RutaTurno r = null;
                
                return r;
	}
	
	
	/**
	 * Metodo encargado de actualizar la información de una ruta de turno en la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @param nRutaurno
	 */
	public void actualizar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, RutaTurno nRutaurno){
		
	}
	
	
	/**
	 * Metodo encargado de agregar una ruta de turno a la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @param nRutaurno
	 */
	public void agregar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, RutaTurno nRutaurno){
		
	}
	
	
	/**
	 * Metodo encargado de eliminar una ruta de turno a la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @param nRutaurno
	 */
	public void eliminar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, RutaTurno nRutaurno){
		
	}
}