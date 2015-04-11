package modelo.mundo;


/**
 * clase encargada del manejo de la informacion del propietario
 * @author MiPc
 * Universidad Mariana (Pasto - Colombia) 
 * Departamento de Ingenier�a de Sistemas. 
 */
public class Propietario 
{
	
	
	/**
	 * el apellido del propietario
	 */
	private String apellidos;


	/**
	 * La direccion del propietario
	 */
	private String direccion;


	/**
	 * La identificacion del propietario.
	 */
	private int identificacion;
	
	
	/**
	 * Los nombres del propietario.
	 */
	private String nombres;
	
	
	/**
	 * El telefono de los propietarios.
	 */
	private int telefono;
	
	
	/**
	 * Constructor de la clase propietario<br>
	 * @param nIdentifacion La identificacion del propietario nIdentificacion !=""
	 * @param nNombres El nombre del propietario nNombres !=""
	 * @param nApellidos El apellido del propietario nApellidos !=""
	 * @param nDireccion La direccion del propietario nDireccion !=""
	 * @param nTelefono El telefono del propietario nTelefono !=""
	 */
	public Propietario(int nIdentifacion, String nNombres, String nApellidos, String nDireccion, int nTelefono)
	{
            identificacion= nIdentifacion;
            nombres=nNombres;
            apellidos=nApellidos;
            direccion=nDireccion;
            telefono=nTelefono;
	}
	
	
	/**
	 * Retorna la identificacion del propietario
	 * @return la identificacion del propietario.
	 */
	public int getIdentificacion() {
		return identificacion;
	}
	
	
	/**
	 * establece la identificacion de un propiatario
	 * @param identificacion La identificacion de un propietario !=""
	 */
	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}
	
	
	/**
	 * retorna el nombre del propietario
	 * @return nombre del propietario
	 */
	public String getNombres() {
		return nombres;
	}
	
	
	/**
	 * establece el nombre del propietario
	 * @param nombres del propietario !=""
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	
	/**
	 * retorna los apellidoss del propietario
	 * @return apellidos del propietario
	 */
	public String getApellidos() {
		return apellidos;
	}
	
	
	/**
	 * establece los apellidos del propietario
	 * @param apellidos del propietario !=""
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	
	/**
	 * retorna la direccion del propietario
	 * @return direccion del propietario
	 */
	public String getDireccion() {
		return direccion;
	}
	
	
	/**
	 * establece la direccion del propietario
	 * @param direccion del propietario !=""
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	/**
	 * Retorna el telefono del propietario
	 * @return telefono del propietario
	 */
	public int getTelefono() {
		return telefono;
	}
	
	
	/**
	 * establece el telefono de un propietario !=""
	 * @param telefono del propietario
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}	
}