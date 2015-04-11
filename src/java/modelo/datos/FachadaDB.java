package modelo.datos;
import java.sql.*;


/**
 * Clase encargada del manejo de la base de datos
 * @author juandiego
 *
 */
public class FachadaDB {

	/**
	 * Constante para el controlador de mysql
	 * @uml.property  name="Driver"
	 */
	public final static  String DRIVER = "com.mysql.jdbc.Driver";


	/**
	 * Constante encargada de contener la url de la base de datos a la cual se va a conectar
	 * @uml.property  name="URL" readOnly="true"
	 */
	public static final String URL = "jdbc:mysql://localhost/rutassuroccidente";


	/**
	 * Contrase�a para el usuario con el que se va a conectar a la base de datos
	 * @uml.property  name="USUARIO" readOnly="true"
	 */
	public static final String USUARIO = "root";


	/**
	 * Contrase�a del usurario con el que se conecta a la base de datos
	 * @uml.property  name="PASSWORD" readOnly="true"
	 */
	public static final String PASSWORD = "admin";


	/**
	 * La contrse�a del usuario con la que se conecta a la base de datos
	 * @uml.property  name="password"
	 */
	private String password;


	/**
	 * La url de la base la base de datos
	 * @uml.property  name="url"
	 */
	private String url;


	/**
	 * El usuario con el cual se conecta a la base de datos
	 * @uml.property  name="usuario"
	 */
	private String usuario;


	/**
	 * Metodo construccutor de la clse FachadaBD<br>
	 * <b>post:</b> Se ha inicializado los atributos con los valores conenidos en las constantes
	 */
	public FachadaDB(){
		password= PASSWORD;
		url= URL;
		usuario=USUARIO;
	}
	
	
	/**
	 * Metodo que retorna un objeto de tipo conecction para realizar las operaciones en la base de datos<br>
	 * <b>post:</b> Se ha creado y retornado la coneccion a la base de datos
     * @return 
	 * @throws ClassNotFoundException En caso de que no exista la clase llamda
	 * @throws SQLException En caso de presentarse problemas al conectar a la base de datos
	 */
	public Connection conectarDB() throws ClassNotFoundException, SQLException{
		Class.forName(DRIVER);
		Connection retorno= (Connection)DriverManager.getConnection(url, usuario, password);
		return retorno;
	}
	
	
	/**
	 * Meotodo que permite cerrar la coneccion a la base de datos<br>
	 *<b>pre:</b> La Conexi�n a sido inicializada<br>
	 *<b>post:</b> Se ha cerrado la coneccion a la basede datos
	 *@param Conexi�n la coneccion a la base de datos conecction!=null
	 * @throws SQLException en caso de presentarse problemas al desconectar la base de datos
	 */
	public void desconectarDB(Connection conexion) throws SQLException
	{
		conexion.close();
	}

}