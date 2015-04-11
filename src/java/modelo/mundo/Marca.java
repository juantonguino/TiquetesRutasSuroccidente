package modelo.mundo;

import java.util.ArrayList;

import modelo.datos.LineaDAO;


/**
 * clase encargada del manejo de la inforamcion de las marcas
 * @author megasoft
 * Universidad Mariana (Pasto - Colombia) 
 * Departamento de Ingeniería de Sistemas. 
 */
public class Marca{
	
	
	/**
	 * el nombre de la marca
	 */
	private String nombre;
	
	
	/**
	 * atributo encargado de lineas en la base de datos
	 */
	private LineaDAO lineaDAO;
	
	
	/**
	 * lista de lineas que existen dentro de una marca
	 */
	private ArrayList<Linea> lineas;
	
	
	/**
	 * metodo constructo de la clase Marca<br>
	 * <b>post: </b> se ha creado una marca con el nombre pasado como parametro, 
	 * ademas se inicializado la lista de linas que correnpondes a las marcas y el atributo 
	 * encargado del manejo de la base de datos 
	 * @param nNombre el nombre de la marca nNombre !=""
	 */
	public Marca(String nNombre){
		nombre=nNombre;
		lineaDAO= new LineaDAO();
		lineas= new ArrayList<Linea>();
	}


	/**
	 * metodo que retorna la lista de lineas
	 * @return la lista de lineas
	 */
	public ArrayList<Linea> getLineas() {
		return lineas;
	}


	/**
	 * metod que establece la lista de lineas<br>
	 * <b>post:</b> cambiado la lista de lineas por la pasada como parametro
	 * @param lineas la lista de lineas de una marca lineas!=null
	 */
	public void setLineas(ArrayList<Linea> lineas) {
		this.lineas = lineas;
	}


	/**
	 * metodo que retona el nombre una marca
	 * @return el nombre de la marca
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * metodo que establece el nombre una marca<br>
	 * <b>post:</b> se ha cambiado el nombre de la marca por el pasado como parametro
	 * @param nombre el nombre de la marca nombre!=""
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * metodo que permite que retorna el atributo lineaDAO
	 * @return el atributo lineaDAO
	 */
	public LineaDAO getLineaDAO() {
		return lineaDAO;
	}


	/**
	 * metodo que permite cambiar el atributo lineaDAO<br>
	 * <b>post:</b> se ha cambiado el atributo DAO por el pasado como parametro 
	 * @param lineaDAO el atributo DAO lineaDAO!=null
	 */
	public void setLineaDAO(LineaDAO lineaDAO) {
		this.lineaDAO = lineaDAO;
	}
}