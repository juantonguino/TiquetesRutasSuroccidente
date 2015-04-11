package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.mundo.Linea;
import modelo.mundo.Marca;
import modelo.mundo.Propietario;
import modelo.mundo.Vehiculo;

/**
 * Clase encargada de almacenar información de los propietarios de las vehículos en la base de datos
 */
public class PropietarioDAO {
	
	/**
	 * Atributo encargado de enlazar la clase FachadaDB
	 */
	private FachadaDB fachada;
	
	/**
	 * Metodo constructor de la clase PropietarioDAO
         * <post:> Inicializar los atributos
	 */
	public PropietarioDAO() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Metodo encargado de instanciar un objeto de la clase Propietario
     * @param nMarca
     * @param nLinea
	 * @param nVehiculo != null Objeto de la clase Vehiculo
	 * @return  Debe ser un objeto de tipo Propietario
         * <pre:> Tener inicializado el enlace a la clase FachadaDB <br>
         * <post:> Realizar seleccion de un propietario de la base de datos <br>
	 */
	public Propietario seleccionar(Vehiculo nVehiculo) {
		Propietario p = null;
                String seleccionar = "select propietario.identificacion, propetario.nombres, propetario.apellidos, propetario.direccion, propetario.telefono"
                                    + " from propietario "
                                    + " where propietario.vehiculo_placa = " + nVehiculo.getPlaca()
                                    + " order by propietario.nombres asc;";
                PreparedStatement ps;
                Connection con;
                ResultSet res;
            try {
                con = fachada.conectarDB();
                ps = con.prepareStatement(seleccionar);
                res = ps.executeQuery();
                
                while(res.next()){
                    p= new Propietario(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5));
                }
                fachada.desconectarDB(con);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PropietarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PropietarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
		
                return p;  
	}
	
	/**
	 * Metodo encargado de actualizar la información de un propietario en la base de datos
	 * @param nVehiculo != null Objeto de la clase Vehiculo
	 * @param nPropietario != null Objeto de la clase Propietario
	 */
	public void actualizar(Vehiculo nVehiculo, Propietario nPropietario) {
            String actualizar = "update propietario "
                                + "set propietario.nombre = " + nPropietario.getNombres() + ", propietario.apellidos = " + nPropietario.getApellidos()
                                + ", propietario.direccion = " + nPropietario.getDireccion()
                                + ", propietario.telefono = " + nPropietario.getTelefono() 
                                + " where propietario.identificacion = " + nPropietario.getIdentificacion() 
                                + " and propietario.vehiculo_placa = " + nVehiculo.getPlaca() + ";";
            Connection con; 
            PreparedStatement ps;
            try {
                con = fachada.conectarDB();
                ps = con.prepareStatement(actualizar);
                fachada.desconectarDB(con);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	
	/**
	 * Metodo encargado de agregar un propietario a la base de datos
	 * @param nVehiculo != null Objeto de la clase Vehiculo
	 * @param nPropietario != null Objeto de la clase Propietario
	 */
	public void agregar(Vehiculo nVehiculo, Propietario nPropietario) {
            String agregar = "insert into propietario (propietario.vehiculo_placa, propietario.nombres, propietario.apellidos, propietario.identificacion, propietario.direccion, propietario.telefono) "
                            + "values (" + nVehiculo.getPlaca() + ", " + nPropietario.getNombres() + ", " + nPropietario.getApellidos() + ", " + nPropietario.getIdentificacion() + ", " + nPropietario.getDireccion() + ", " + nPropietario.getTelefono() + ");";
            Connection con; 
            PreparedStatement ps;
            try {
                con = fachada.conectarDB();
                ps = con.prepareStatement(agregar);
                fachada.desconectarDB(con);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	
	/**
	 * Metodo encargado de eliminar un propietario a la base de datos
	 * @param nVehiculo != null Objeto de la clase Vehiculo
	 * @param nPropietario != null Objeto de la clase Propietario
	 */
	public void eliminar(Vehiculo nVehiculo, Propietario nPropietario) {
            String eliminar= "delete from propietario "
                            + "where propietario.identificacion = " + nPropietario.getIdentificacion()
                            + " and propietario.vehiculo_placa = " + nVehiculo.getPlaca();
            Connection con; 
            PreparedStatement ps;
            try {
                con = fachada.conectarDB();
                ps = con.prepareStatement(eliminar);
                fachada.desconectarDB(con);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
}
