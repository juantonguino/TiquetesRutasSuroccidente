package modelo.datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.mundo.Linea;
import modelo.mundo.Marca;


/**
 * Clase encargada de almacenar informacion de las lineas de las marcas en la base de datos
 */
public class LineaDAO {
		
		
    /**
     * Lista almacenadora de objetos de tipo Marca
     * @param nMarca != null Objeto de la clase Marca
     * @return
     */
    public ArrayList<Linea> seleccionar(Marca nMarca){
        FachadaDB bd = new FachadaDB();
        Connection con = bd.crearConexion();
        Statement st = null;
        ResultSet res = null;
        ArrayList<Linea> lineas = new ArrayList<>();
        try {
            String query = "SELECT * FROM linea WHERE nombre_marca = '" + nMarca.getNombre() + "'";
            st = con.createStatement();
            res = st.executeQuery(query);
            while(res.next()){
                lineas.add(new Linea(res.getString("nombre")));
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
        return lineas;	
    }


    /**
     * Metodo encargado de agregar una línea en la base de datos
     * @param nMarca != null Objeto de la clase Marca
     * @param nLinea != null Objeto de la clase Linea
     */
    public void agregar(Marca nMarca, Linea nLinea){
        Connection con = null;
        Statement st = null;
        String query = "INSERT INTO linea (nombre, nombre_marca)"
                + " VALUES ('" + nLinea.getNombre() + "', '" + nMarca.getNombre() + "')";
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.createStatement();
            st.execute(query);
            System.out.println("Se ha registrado una nueva linea en la marca: "
                    + nMarca.getNombre() + ", con el nombre: " + nLinea.getNombre());
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
     * Metodo encargado de actualizar la información de una línea en la base de datos
     * @param nMarca != null Objeto de la clase Marca
     * @param nLinea != null Objeto de la clase Linea
     * @param vNombre != null && != "" Nombre de la linea a cambiar
     */
    public void actualizar(Marca nMarca, Linea nLinea, String vNombre){
        Connection con = null;
        Statement st = null;
        String query = "UPDATE linea SET nombre = '" + nLinea.getNombre() + "'"
                + "WHERE linea.nombre = '" + vNombre + "'";
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.createStatement();
            st.execute(query);
             System.out.println("Se ha modificado la línea de nombre: " + vNombre
             + " por: " + nLinea.getNombre());
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
     * Metodo encargado de eliminar una línea en la base de datos
     * @param nMarca != null Objeto de la clase Marca
     * @param nLinea != null Objeto de la clase Linea
     */
    public void eliminar(Marca nMarca, Linea nLinea){
        Connection con = null;
        Statement st = null;
        String query = "DELETE FROM linea  WHERE nombre = '" + nLinea.getNombre() + "'";
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.createStatement();
            st.execute(query);
             System.out.println("Se ha eliminado la marca con el nombre: " + nLinea.getNombre() );
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