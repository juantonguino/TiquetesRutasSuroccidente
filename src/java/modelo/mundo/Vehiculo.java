package modelo.mundo;

import java.awt.image.BufferedImage;

import modelo.datos.PropietarioDAO;
import modelo.datos.RutaTurnoDAO;
import modelo.datos.TiqueteDAO;


/**
 * clase encargada del manejo de informacion del vehiculo
 * @author megasoft
 * Universidad Mariana (Pasto - Colombia) 
 * Departamento de Ingenier�a de Sistemas. 
 */
public class Vehiculo {
	
	
	/**
	 * es el atributo imagen de un vehiculo
	 */	
	private BufferedImage fotografia;
	
	
	/**
	 * es el modelo de un vehiculo
	 */
	private int modelo;
	
	
	/**
	 * es el numero de pasajeros que tiene un vehiculo
	 */
	private int numeroPasajeros;
	
	
	/**
	 * es la placa que tiene un vehiculo
	 */
	private String placa;
	
	
	/**
	 * es el propietario de un vehiculo
	 */
	private Propietario propietario;
	
	
	/**
	 * atributo encargado de propietario en la base de datos
	 */
	private PropietarioDAO propietarioDAO;
	
	
	/**
	 * es la ruta que tiene un vehiculo
	 */
	private RutaTurno rutaTurno;
	
	
	/**
	 * es el atributo encargado de las rutas en la base de datos
	 */
	private RutaTurnoDAO rutaTurnoDAO;
	
	
	/**
	 * es el atributo encargado de los tiquetes en la base de datos
	 */
	private TiqueteDAO tiqueteDAO;
	
	
	/**
	 * es la contenedora de los tiquetes
	 */
	private Tiquete[] tiquetes;
	
	
	/**
	 * metodo constructor de la clase vehiculo
	 * @param nModelo el modelo de un vehiculo nModelo !=""
	 * @param nPlaca la placa de un vehiculo nPlaca !=""
	 * @param nNumeroPasajeros los pasajeros de un vehiculo nNumeroPasajeros !=""
	 * @param nFotografia la fotografia de un vehiculo nFotografia !=""
	 */
	public Vehiculo(int nModelo, String nPlaca, int nNumeroPasajeros, BufferedImage nFotografia) {
		this.fotografia=nFotografia;
		this.modelo=nModelo;
		this.numeroPasajeros=nNumeroPasajeros;
		this.placa=nPlaca;
		this.tiquetes= new Tiquete[this.numeroPasajeros];
                this.propietarioDAO=new PropietarioDAO();
                this.rutaTurnoDAO= new RutaTurnoDAO();
                this.tiqueteDAO= new TiqueteDAO();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * retorna el modelo de un vehiculo
	 * @return modelo de un vehiculo
	 */
	public int getModelo() {
		return modelo;
	}

	
	/**
	 * establece el modelo de un vehiculo
	 * @param modelo el modelo de un vehiculo !=""
	 */
	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	
	/**
	 * retorna la placa de un vehiculo
	 * @return placa de un vehiculo
	 */
	public String getPlaca() {
		return placa;
	}
	
	
	/**
	 * establece la placa de un vehiculo
	 * @param placa la placa de un vehiculo !=""
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
	/**
	 * restorna el numero de pasajeros de un vehiculo
	 * @return numeroPasajeros el numero de pasajeros de un vehiculo.
	 */
	public int getNumeroPasajeros() {
		return numeroPasajeros;
	}
	
	
	/**
	 * establece el numero de pasajeros de un vehiculo
	 * @param numeroPasajeros el numero de pasajeros de un vehiculo !=""
	 */
	public void setNumeroPasajeros(int numeroPasajeros) {
		this.numeroPasajeros = numeroPasajeros;
	}
	
	
	/**
	 * restorna la fotografia de un vehiculo
	 * @return fotografia la fotografia de un vehiculo
	 */
	public BufferedImage getFotografia() {
		return fotografia;
	}
	
	
	/**
	 * establece la ffotografia para un vehiculo
	 * @param fotografia la fotografia de un vehiculo !=""
	 */
	public void setFotografia(BufferedImage fotografia) {
		this.fotografia = fotografia;
	}
	
	
	/**
	 * restorna el propietario de un vehiculo
	 * @return propietario el propietario de un vehiculo
	 */
	public Propietario getPropietario() {
		return propietario;
	}
	
	
	/**
	 * establece el propietario para un vehiculo
	 * @param propietario el propietario de un vehiculo !=""
	 */
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
	
	/**
	 * restorna la ruta de un vehiculo
	 * @return rutaTurno la ruta de un vehiculo
	 */
	public RutaTurno getRutaTurno() {
		return rutaTurno;
	}
	
	
	/**
	 * establece la ruta de un vehiculo
	 * @param rutaTurno la ruta de un vehiculo !=""
	 */
	public void setRutaTurno(RutaTurno rutaTurno) {
		this.rutaTurno = rutaTurno;
	}
	
	
	/**
	 * retorna los tiquetes 
	 * @return tiquetes 
	 */
	public Tiquete[] getTiquetes() {
		return tiquetes;
	}
	
	
	/**
	 * establece los tiquetes 
	 * @param tiquetes !=""
	 */
	public void setTiquetes(Tiquete[] tiquetes) {
		this.tiquetes = tiquetes;
	}


	/**
	 * metodo que permite que retorne el atributo propietarioDAO
	 * @return el atributo propietarioDAO
	 */
	public PropietarioDAO getPropietarioDAO() {
		return propietarioDAO;
	}


	/**
	 * metodo que permite cambiar el atributo propietarioDAO
	 *<b>post:</b> se ha cambiado el atributo DAO por el pasado como parametro 
	 * @param propietarioDAO el atributo DAO propietarioDAO!=""
	 */
	public void setPropietarioDAO(PropietarioDAO propietarioDAO) {
		this.propietarioDAO = propietarioDAO;
	}


	/**
	 * metodo que permite retornar el atributo rutaTurnoDAO
	 * @return el atributo rutaTurnoDAO
	 */
	public RutaTurnoDAO getRutaTurnoDAO() {
		return rutaTurnoDAO;
	}


	/**
	 * metodo que permite cambiar el atributo rutaTrunoDAO
	 *<b>post:</b> se ha cambiado el atributo DAO por el pasado como parametro 
	 * @param rutaTurnoDAO el atributo DAO rutaTurnoDAO!=""
	 */
	public void setRutaTurnoDAO(RutaTurnoDAO rutaTurnoDAO) {
		this.rutaTurnoDAO = rutaTurnoDAO;
	}


	/**
	 * metodo que permite retornar el atributo tiqueteDAO
	 * @return el atributo tiqueteDAO
	 */
	public TiqueteDAO getTiqueteDAO() {
		return tiqueteDAO;
	}


	/**
	 * metodo que ermite cambiar el atributo tiqueteDAO
	 *<b>post:</b> se ha cambiado el atributo DAO por el pasado como parametro 
	 * @param tiqueteDAO el atributo DAO tiqueteDAO!=""
	 */
	public void setTiqueteDAO(TiqueteDAO tiqueteDAO) {
		this.tiqueteDAO = tiqueteDAO;
	}
}