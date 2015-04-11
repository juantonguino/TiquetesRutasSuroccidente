package modelo.mundo;


import java.util.Date;

import modelo.datos.ClienteDAO;


/**
 * clase que maneja la informacion de los tiquetes
 * @author megasoft
 * Universidad Mariana (Pasto - Colombia) 
 * Departamento de Ingenier�a de Sistemas. 
 */
public class Tiquete {


	/**
	 * La hora de la venta del tiquete
	 */
	private Date horaVenta;
	
	
	/**
	 * valor del tiquete
	 */
	private double valorTiquete;
	
	
	/**
	 * constructor de la clase tiquete<br>
	 * @param nHoraVenta la hora de la venta del tiquete nHoraVenta !=""
	 * @param nValorTiquete el valor del tiquete nValorTiquete !=""
	 * @param nCliente el cliente que compro un tiquete nCliente !=""
	 */
	public Tiquete(Date nHoraVenta, double nValorTiquete, Cliente nCliente) {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * retorna la hora de la venta del tiquete
	 * @return horaVenta la hora de la venta del tiquete
	 */
	public Date getHoraVenta() {
		return horaVenta;
	}
	
	
	/**
	 * establece la hora de la venta de un tiquete
	 * @param horaVenta la hora de la venta del tiquete !=""
	 */
	public void setHoraVenta(Date horaVenta) {
		this.horaVenta = horaVenta;
	}
	
	
	/**
	 * retorna el valor del tiquete
	 * @return valorTiquete el valor de un tiquete
	 */
	public double getValorTiquete() {
		return valorTiquete;
	}
	
	
	/**
	 * establece el calor de un tiquete
	 * @param valorTiquete el valor de un tiquete !=""
	 */
	public void setValorTiquete(double valorTiquete) {
		this.valorTiquete = valorTiquete;
	}
}
