package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.mundo.*;


/**
 * Clase encargada de almacenar informacion de los tiquetes en la base de datos
 */
public class TiqueteDAO {
	
	
<<<<<<< HEAD
    /**
     * Metodo encargado de instanciar un objeto de la clase Tiquete
     * @param nMarca
     * @param nLinea
     * @param nVehiculo
     * @return Debe ser un objeto de tipo Tiquete
     */
    public Tiquete seleccionar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo){
        PreparedStatement ps;
        FachadaDB bd = new FachadaDB();
        Connection con = bd.crearConexion();
        Statement st = null;
        ResultSet res = null;
        Tiquete t;
        return null;
    }
    
    
    /**
     * Metodo encargado de agregar un tiquete en la base de datos
     * @param nTiquete
     */
    public void agregar(Tiquete nTiquete){
        Connection con = null;
        Statement st = null;
        String query = "INSERT INTO tiquete (numero, hora_venta, valor_tiquete)"
                + " VALUES (" + nTiquete.getNumero() + ", "
                + nTiquete.getHoraVenta().getTime() + ", "
                + nTiquete.getValorTiquete() + ")";
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
            System.out.println("Se ha agregado un cliente nuevo tiquete");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * Metodo encargado de actualizar la información de un tiquete en la base de datos
     * @param nMarca
     * @param nLinea
     * @param nVehiculo
     * @param nTiquete
     */
    public void actualizar(Tiquete nTiquete){
        Connection con = null;
        Statement st = null;
        String query = "UPDATE tiquete SET hora_venta = " + nTiquete.getHoraVenta().getTime()
                + ", valor_tiquete = " + nTiquete.getValorTiquete()
                + " WHERE numero = " + nTiquete.getNumero();
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
             System.out.println("Se ha modificado el tiquete");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * Metodo encargado de eliminar un tiquete en la base de datos
     * @param nMarca
     * @param nLinea
     * @param nVehiculo
     * @param nTiquete
     */
    public void eliminar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, Tiquete nTiquete){
        Connection con = null;
        Statement st = null;
        String query = "DELETE FROM tiquete  WHERE numero = " + nTiquete.getNumero();
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
             System.out.println("Se ha eliminado el tiquete");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
=======
	/**
	 * Atributo encargado de enlazar la clase FachadaDB
	 */
	private FachadaDB fachada;
	
	
	/**
	 * Metodo constructor de la clase TiqueteDAO
	 */
	public TiqueteDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Metodo encargado de instanciar un objeto de la clase Tiquete
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @return Debe ser un objeto de tipo Tiquete
	 */
	public Tiquete seleccionar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo){
		return null;
	}
	
	
	/**
	 * Metodo encargado de actualizar la información de un tiquete en la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @param nTiquete
	 */
	public void actualizar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, Tiquete nTiquete){
		
	}
	
	
	/**
	 * Metodo encargado de agregar un tiquete en la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @param nTiquete
	 */
	public void agregar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, Tiquete nTiquete){
		
	}
	
	
	/**
	 * Metodo encargado de eliminar un tiquete en la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @param nTiquete
	 */
	public void eliminar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, Tiquete nTiquete){
		
	}
        
        
        /**
	 * Metodo encargado de instanciar un objeto de la clase Tiquete
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @return Debe ser un objeto de tipo Tiquete
	 */
	public Tiquete seleccionar(Marca nMarca, Linea nLinea, Cliente nCliente){
		return null;
	}
	
	
	/**
	 * Metodo encargado de actualizar la información de un tiquete en la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @param nTiquete
	 */
	public void actualizar(Marca nMarca, Linea nLinea, Cliente nCliente, Tiquete nTiquete){
		
	}
	
	
	/**
	 * Metodo encargado de agregar un tiquete en la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @param nTiquete
	 */
	public void agregar(Marca nMarca, Linea nLinea, Cliente nCliente, Tiquete nTiquete){
		
	}
	
	
	/**
	 * Metodo encargado de eliminar un tiquete en la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @param nTiquete
	 */
	public void eliminar(Marca nMarca, Linea nLinea, Cliente nCliente, Tiquete nTiquete){
		
	}
>>>>>>> origin/master
}