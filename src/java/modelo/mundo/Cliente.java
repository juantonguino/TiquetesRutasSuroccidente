package modelo.mundo;

import java.util.ArrayList;


/**
 * 
 * @author megasoft.
 * Universidad Mariana (Pasto - Colombia) 
 * Departamento de Ingenier�a de Sistemas. 
 */
public class Cliente {
    
    
	/**
	 * Apellido del cliente
	 */
	private String apellidos;


	/**
	 *Identificacion del cliente 
	 */
	private int identificacion;
	
	
	/**
	 * Nombre del cliente
	 */
	private String nombres;
        
        
        /**
         * lista de tiquetes
         */
        private ArrayList<Tiquete> tiquetes;
	
	
	/**
	 * Crea un cliente con la informacion basica
	 * @param nIdentificacion es la identificacion del cliente nIdentificacion !=""
	 * @param nNombres Es el nombre del cliente nNombres !=""
	 * @param nApellidos Es el apellido del cliente nApellidos !=""
	 */
	public Cliente(int nIdentificacion, String nNombres, String nApellidos) {
		identificacion=nIdentificacion;
		nombres=nNombres;
		apellidos=nApellidos;
                tiquetes= new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Retorna la identificacion del cliente.
	 * @return identificacion.
	 */
	public int getIdentificacion() {
		return identificacion;
	}
	
	
	/**
	 * @param identificacion La identificacion del cliente !=""
	 */
	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}
	
	
	/**
	 * Retorna el nombre del cliente.
	 * @return nombres nombre del cliente.
	 */
	public String getNombres() {
		return nombres;
	}
	
	
	/**
	 *Establece el nombre del cliente
	 * @param nombres el nombre del cliente !=""
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	
	/**
	 * Retorna el pellido del cliente.
	 * @return apellidos del cliente.
	 */
	public String getApellidos() {
		return apellidos;
	}
	
	
	/**
	 *Establece los apellidos del cliente
	 * @param apellidos apellidos del cliente !=""
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

        
        /**
         * metodo que permite retornar la lista de tiquetes
         * @return la lista de tiquetes
         */
        public ArrayList<Tiquete> getTiquetes() {
            return tiquetes;
        }

        
        /**
         * metodo que permite cambiar la lista de Tiquetes
         * @param tiquetes la lista por la cual se cambian
         */
        public void setTiquetes(ArrayList<Tiquete> tiquetes) {
            this.tiquetes = tiquetes;
        }
}