package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.mundo.*;

/**
 * Clase encargada de almacenar la información de los clientes en la la base de datos
 * @author juandiego
 */
public class ClienteDAO {
	
	
	/**
	 * Atributo encargado de enlazar con la clase FachadaDB
	 */
	private FachadaDB fachada;
	
	
	/**
	 * Metodo constructor de la clase ClienteDAO
         * <post:> Inicializar los atributos
	 */
	public ClienteDAO() {
		// TODO Auto-generated constructor stub
            fachada = new FachadaDB();
	}

	
	/**
	 * Metodo encargado de seleccionar un cliente de la base de datos dado su identificación
	 * @return  Debe ser de tipo Cliente
         * <pre:> Tener inicializado el enlace a la clase Fachada DB <br>
         * <post:> Realizar seleccion de un cliente de la base de datos <br>
	 */
	public ArrayList<Cliente> seleccionar(){
            ArrayList<Cliente> clientes = new ArrayList<>();
            String seleccionar = "select cliente.identificacion, cliente.nombre, cliente.apellidos from cliente order by cliente.nombre asc;";
            Connection con;
            PreparedStatement ps;
            ResultSet res;
            
            try {
                con = fachada.conectarDB();
                ps = con.prepareStatement(seleccionar);
                res = ps.executeQuery();
                
                while(res.next()){
                    clientes.add(new Cliente(res.getInt(1), res.getString(2), res.getString(3)));
                }
                fachada.desconectarDB(con);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } 
            return clientes;
	}
	
	
	/**
	 * Metodo encargado de actualizar la información del cliente en la base de datos
         * @param nCliente != null Objeto de la clase Cliente
         * <pre:> Tener inicializado el enlace a la clase FachadaDB. <br>
         * <post:> Se ha actualizado el cliente en la base de datos. <br>
         * @throws java.lang.ClassNotFoundException Excepción causada porque no se ha realizado una correcta conexión a la base de datos.
	 */
	public void actualizar(Cliente nCliente) throws ClassNotFoundException {
            String actualizar= "update cliente "
                                + "set cliente.nombre = " + nCliente.getNombres() + ", cliente.apellidos = " + nCliente.getApellidos()
                                + " where cliente.identificacion = " + nCliente.getIdentificacion() + ";";
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
	 * Metodo encargado de agregar un cliente a la base de datos
         * @param nCliente != null Objeto de la clase Cliente
         * <pre:> Tener inicializado el enlace a la clase FachadaDB. <br>
         * <post:> Se ha agregado un nuevo cliente en la base de datos. <br>
	 */
	public void agregar(Cliente nCliente) {
            String agregar= "insert into cliente (cliente.identificacion, cliente.nombre, cliente.apellidos) "
                            + "values ( " + nCliente.getIdentificacion() + ", " + nCliente.getNombres() + ", " + nCliente.getApellidos() + " );" ;
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
	 * Metodo encargado de eliminar un cliente de la base de datos
         * @param nCliente
         * <pre:> Tener inicializado el enlace a la clase FachadaDB. <br>
         * <post:> Se ha eliminado el cliente de la base de datos. <br>   
	 */
	public void eliminar(Cliente nCliente) {
            String eliminar= "delete from cliente "
                            + "where cliente.identifiacacion = " + nCliente.getIdentificacion() + ";";
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