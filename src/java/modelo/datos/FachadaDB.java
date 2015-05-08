package modelo.datos;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Clase encargada del manejo de la base de datos
 * @author juandiego
 *
 */
public class FachadaDB {

    /**
     * Atributo que almacena el nombre de la base de datos
     */
    private String baseDeDatos;
    
    
    /**
     * Atributo que almacena la contraseña de la conexión
     */
    private String clave;
    
    
    /**
     * Atributo que almacena la conexión con la base de datos.
     */
    private Connection conexion;
    
    
    /**
     * Atributo que almacena la dirección de conexión con la base de datos.
     */
    private String url;    
    
    
    /**
     * Atributo que almacena el nombre de ususario para el acceso a la conexión.
     */
    private String usuario;
    
    
    
    /**
     * Constructor de la clase FachadaDB
     */
    public FachadaDB(){
        baseDeDatos = "tiquetes";
        clave = "admin";
        usuario = "root";
        url = "jdbc:mysql://localhost/"+baseDeDatos;
    }
    
  
    
    /**
     * Metodo que crea la conexión con la base de datos.
     * @return Retorna un objeto de tipo Connection
     */
    public Connection crearConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexión realizada correctamente");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FachadaDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FachadaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
    
    

}