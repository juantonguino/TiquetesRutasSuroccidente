package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.mundo.Marca;


/**
 * Clase encargada del manejo de las marcas en la base de datos
 * @author MiPc
 *
 */
public class MarcaDAO {

	
	/**
	 * Atributo para la administración de la base de datos
	 */
	private FachadaDB fachada;
	
	
	/**
	 * Metodo constructor de la calse MarcaDAO
	 * <b>post:</b> Se ha inicializada el atributo de la clase fachada, se ha creado una nueva instancia de la clase 
	 */
	public MarcaDAO(){
		fachada= new FachadaDB();
	}
	
	
	/**
	 * Metodo que permite seleccionar las marcas almacenadas en la base de datos<br>
	 * <b>pre:</b> Ha inicializado el atributo fachada
	 * <b>post:</b> Se ha seleccionado y retornado las marcas almacenadas en la base de datos
	 * @return La lista con las marcas seleccionadas
	 */
	public ArrayList<Marca> seleccionar() {
            ArrayList<Marca> marcas = new ArrayList<>();
            String seleccionar="select marca.nombre from marca";
            PreparedStatement ps;
            ResultSet res;
            Connection con;
            try {
                con = fachada.conectarDB();
                ps = con.prepareStatement(seleccionar);
                res = ps.executeQuery();

                while(res.next()){
                    marcas.add(new Marca(res.getString(1)));
                }
                fachada.desconectarDB(con);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }             
            return marcas;
	}
	
	
	/**
	 * Metodo que actualizar una marca almacenada en la base de datos<br>
	 * <b>pre:</b> El atributo fachadaDB ha sido inicializado<br>
	 * <b>post:</b> Se ha modificado la marca ingresada como parametro
	 * @param nMarca La marca actualizar en la base de datos nMarca!=null
         * @param vNombre != null && != "" Nombre de la marca a modificar
	 */
	public void actualizar(Marca nMarca, String vNombre){
            String actualizar= "update marca "
                                    + "set marca.nombre = " + nMarca.getNombre()   
                                    + " where marca.nombre = " + vNombre ;
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
	 * Metodo que permite agregar una marca a la base de datos<br>
	 * <b>pre:</b> El atributo fachadaDB ha sido inicializado<br>
	 * <b>post:</b> Agregado una marca a la base de datos 
	 * @param nMarca La marca a agregar a la base de datos
	 */
	public void agregar(Marca nMarca) {
            
            String agregar= "insert into marca (marca.nombre) "
                                + "values ( " + nMarca.getNombre() + ");";
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
	 * Metodo que permite eliminar una marca de la base de datos<br>
	 * <b>pre:</b> El atributo fachadaDB ha sido inicializado<br>
	 * <b>post:</b> Se ha eliminado la marca pasada como parametro de la base de datos
	 * @param nMarca La marca a eliminar de la base de datos nMarca !=null
	 */
	public void eliminar(Marca nMarca) {
           String eliminar= "delete from marca "
                                + "where marca.nombre = " + nMarca.getNombre() + ";";
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