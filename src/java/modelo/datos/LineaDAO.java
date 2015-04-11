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


/**
 * Clase encargada de almacenar informacion de las lineas de las marcas en la base de datos
 */
public class LineaDAO {
	
	
	/**
	 * Atributo encargado de enlazar la clase FachadaDB
	 */
	private FachadaDB fachada;
	
	
	/**
	 * Metodo constructor de la clase LineaDAO
	 */
	public LineaDAO(){
		
	}
	
	
	/**
	 * Lista almacenadora de objetos de tipo Marca
	 * @param nMarca != null Objeto de la clase Marca
	 * @return
	 */
	public ArrayList<Linea> seleccionar(Marca nMarca){
            ArrayList<Linea> lineas = new ArrayList<>();
            String seleccionar="select linea.nombre from linea where linea.marca_nombre = " + nMarca.getNombre();
            Connection con;
            ResultSet res;
            PreparedStatement ps;
            try {
                con = fachada.conectarDB();
                ps = con.prepareStatement(seleccionar);
                res = ps.executeQuery();
                
                while(res.next()){
                    lineas.add(new Linea(res.getString(1)));
                }
                fachada.desconectarDB(con);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LineaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(LineaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lineas;
	
	}
	
	
	/**
	 * Metodo encargado de actualizar la información de una línea en la base de datos
	 * @param nMarca != null Objeto de la clase Marca
	 * @param nLinea != null Objeto de la clase Linea
         * @param vNombre != null && != "" Nombre de la linea a cambiar
	 */
	public void actualizar(Marca nMarca, Linea nLinea, String vNombre){
            String actualizar= "update linea set linea.nombre = " + nLinea.getNombre()
                                + " where linea.nombre = " + vNombre  
                                + " and linea.marca_nombre = " + nMarca.getNombre();
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
	 * Metodo encargado de agregar una línea en la base de datos
	 * @param nMarca != null Objeto de la clase Marca
	 * @param nLinea != null Objeto de la clase Linea
	 */
	public void agregar(Marca nMarca, Linea nLinea){
            String agregar= "insert into linea (nombre, marca_nombre) "
                                + "values ( " + nLinea.getNombre() + " ,"+ nMarca.getNombre();
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
	 * Metodo encargado de eliminar una línea en la base de datos
	 * @param nMarca != null Objeto de la clase Marca
	 * @param nLinea != null Objeto de la clase Linea
	 */
	public void eliminar(Marca nMarca, Linea nLinea){
            String eliminar= "delete from linea "
                            + "where linea.mara_nombre = " + nMarca.getNombre()
                            + " and linea.nombre = " + nLinea.getNombre();
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