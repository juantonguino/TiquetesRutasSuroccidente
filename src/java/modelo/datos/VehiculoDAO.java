package modelo.datos;

import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.mundo.*;


/**
 * Clase encargada de almacenar informacion de los vehiculos en la base de datos
 */
public class VehiculoDAO {
	
	
	/**
	 * Atributo encargado de enlazar la clase FachadaDB
	 */
	private FachadaDB fachada;
	
	
	/**
	 * Metodo constructor de la clase VehiculoDAO
         * <post:> Inicializar los atributos
	 */
	public VehiculoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Lista almacenadora de objetos de tipo Vehiculo
	 * @param nMarca != null Objeto de la clase Marca
	 * @param nLinea != null Objeto de la clase Linea
	 * @return  Lista de vehículos.
         * <pre:> Tener inicializado el enlace a la clase FachadaDB <br>
         * <post:> Realizar seleccion de los vehículos de una marca y una linea dada de la base de datos <br>
         */
	public ArrayList<Vehiculo> seleccionar(Marca nMarca, Linea nLinea)  {
            ArrayList<Vehiculo> vehiculos;
            vehiculos = new ArrayList();
            String seleccionar="select vehiculo.modelo, vehiculo.placa, vehiculo.numero_pasajeros, vehiculo.fotografia from vehiculo, linea "
                            + " where vehiculo.linea_nombre = " + nLinea.getNombre()
                            + " and linea.nombre_marca = " + nMarca.getNombre() + ";";
            Connection con;
            PreparedStatement ps;
            ResultSet res;
            try {
                con = fachada.conectarDB();
                ps = con.prepareStatement(seleccionar);
                res = ps.executeQuery();
                
                while(res.next()){
                    vehiculos.add(new Vehiculo(res.getInt(1), res.getString(2), res.getInt(3), (BufferedImage) res.getBlob(4)));
                }
                fachada.desconectarDB(con);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return vehiculos;
	}
	
	
	/**
	 * Metodo encargado de actualizar la información de un vehículo en la base de datos
	 * @param nMarca != null Objeto de la clase Marca
	 * @param nLinea != null Objeto de la clase Linea
	 * @param nVehiculo != null Objeto de la clase Vehiculo
         */
	public void actualizar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo)  {
            String actualizar= "update vehiculo "
                                + "set vehiculo.modelo = " + nVehiculo.getModelo() + ", vehiculo.numero_pasajeros = " + nVehiculo.getNumeroPasajeros() + ", vehiculo.fotografia = " + nVehiculo.getFotografia()
                                + " where vehiculo.linea_nombre = " + nLinea.getNombre() 
                                + " and vehiculo.placa = " + nVehiculo.getPlaca();
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
	 * Metodo encargado de agregar un vehículo en la base de datos
	 * @param nLinea != null Objeto de la clase Linea
	 * @param nVehiculo != null Objeto de la clase Vehiculo
         */
	public void agregar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo) {
            String agregar= "insert into vehiculo (vehiculo.placa, vehiculo.modelo, vehiculo.numero_pasajeros, vehiculo.fotografia, vehiculo.linea_nombre) "
                        + "values ( " + nVehiculo.getPlaca() + ", " + nVehiculo.getModelo() + ", " + nVehiculo.getNumeroPasajeros() + ", " + nVehiculo.getFotografia() + ", " + nLinea.getNombre() + ");";
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
	 * Metodo encargado de eliminar un vehículo en la base de datos
	 * @param nMarca != null Objeto de la clase Marca
	 * @param nLinea != null Objeto de la clase Linea
	 * @param nVehiculo != null Objeto de la clase Vehiculo
         */
	public void eliminar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo) {
            String eliminar= "delete from vehiculo "
                            + "where vehiculo.placa = " + nVehiculo.getPlaca()
                            + " and vehiculo.linea_nombre = " + nLinea.getNombre();
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
