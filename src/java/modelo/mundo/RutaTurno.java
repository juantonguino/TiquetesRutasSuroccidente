package modelo.mundo;

import java.util.Date;


/**
 * Clase encargada del manejo de informacion de RutaTurno
 * @author megasoft
 * Universidad Mariana (Pasto - Colombia) 
 * Departamento de Ingeniería de Sistemas. 
 */
public class RutaTurno {
	
	
	/**
	 * ciudad de destino de la ruta
	 */
	private String ciudadDestino;


	/**
	 * ciudad de origen de la ruta
	 */
	private String ciudadOrigen;
	
	
	/**
	 * la hora de salidad de la ruta
	 */
	private Date horaSalida;
	
	
	/**
	 * constructor de la clase RutaTurno<br>
	 * @param nCiudadOrigen es la ciudad de origen de la ruta nCiudadOrigen !=""
	 * @param nCiudadDestino la ciudad de destino de la ruta nCiudadDestino !=""
	 * @param nHoraSalida la hora de salida de la ruta nHoraSalida !=""
	 */
	public RutaTurno(String nCiudadOrigen, String nCiudadDestino, Date nHoraSalida) {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * retorna la ciudad de origen de la ruta
	 * @return ciudadOrigen ciudad de origen de la ruta
	 */
	public String getCiudadOrigen() {
		return this.ciudadOrigen;
	}
	
	
	/**
	 * establece la ciudad origen de la ruta
	 * @param ciudadOrigen la ciudad origen de la ruta !=""
	 */
	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}
	
	
	/**
	 * retorna la ciudad de destino de la ruta
	 * @return ciudadDestino la ciudad de destino de la ruta
	 */
	public String getCiudadDestino() {
		return ciudadDestino;
	}
	
	
	/**
	 * establece la ciudad de destino de la ruta
	 * @param ciudadDestino la ciudad de destino de la ruta !=""
	 */
	public void setCiudadDestino(String ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}
	
	
	/**
	 * retorna la hora de salida de la ruta
	 * @return horaSalida la hora de salida de la ruta
	 */
	public Date getHoraSalida() {
		return horaSalida;
	}
	
	
	/**
	 * establece la hora de salida de la ruta
	 * @param horaSalida la hora de salida de la ruta !=""
	 */
	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}
}