package modelo.datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.mundo.Marca;


/**
 * Clase encargada del manejo de las marcas en la base de datos
 * @author MiPc
 *
 */
public class MarcaDAO {

     
    /**
     * Metodo que permite seleccionar las marcas almacenadas en la base de datos<br>
     * <b>pre:</b> Ha inicializado el atributo fachada
     * <b>post:</b> Se ha seleccionado y retornado las marcas almacenadas en la base de datos
     * @return La lista con las marcas seleccionadas
     */
    public ArrayList<Marca> seleccionar() {
        FachadaDB bd = new FachadaDB();
        Connection con = bd.crearConexion();
        Statement st = null;
        ResultSet res = null;
        ArrayList<Marca> marcas = new ArrayList<Marca>();
        try {
            String query = "SELECT * FROM marca";
            st = con.createStatement();
            res = st.executeQuery(query);            
            while(res.next()){
                marcas.add(new Marca(res.getString("nombre")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (st != null) {
                    st.close();
                }
                if (res != null) {
                    res.close();
                }
            } catch (Exception exe) {
                exe.printStackTrace();
            }
        }
        return marcas;
    }
    
    
    /**
     * Metodo que permite agregar una marca a la base de datos<br>
     * <b>pre:</b> Se ha establecido una conexion con la base de datos. <br>
     * <b>post:</b> Se ha agregado una nueva marca a la base de datos <br>
     * @param nMarca La marca a agregar a la base de datos
     */
    public void agregar(Marca nMarca) {
        Connection con = null;
        Statement st = null;
        String query = "INSERT INTO marca (nombre) VALUES ('" + nMarca.getNombre() + "')";
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
            System.out.println("Se ha registrado una nueva marca, nombre: " + nMarca.getNombre());
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
     * Metodo que actualizar una marca almacenada en la base de datos 
     * <b>pre:</b> El atributo fachadaDB ha sido inicializado. <br>
     * <b>post:</b> Se ha modificado la marca ingresada como parametro
     * @param nMarca Objeto de la clase Marca
     */
    public void actualizar(Marca nMarca, String vNombre) {
        Connection con = null;
        Statement st = null;
        String query = "UPDATE marca SET nombre = '" + nMarca.getNombre() + "'"
                + "WHERE marca.nombre = '" + vNombre + "'";
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
             System.out.println("Se ha modificado el nombre de la marca: " + vNombre
             + " por: " + nMarca.getNombre());
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
     * Metodo que permite eliminar una marca de la base de datos<br>
     * <b>pre:</b> El atributo fachadaDB ha sido inicializado. <br>
     * <b>post:</b> Se ha eliminado la marca pasada como parametro de la base de datos. <br>
     * @param nMarca Un objeto cualquiera que representa el identificador de la marca
     */
    public void eliminar(Marca nMarca) {
        Connection con = null;
        Statement st = null;
        String query = "DELETE FROM marca  WHERE nombre = '" + nMarca.getNombre() + "'";
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
             System.out.println("Se ha eliminado la marca con el nombre: " + nMarca.getNombre() );
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
    
       
}