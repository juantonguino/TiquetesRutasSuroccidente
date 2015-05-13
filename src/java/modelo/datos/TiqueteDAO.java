package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.mundo.*;


/**
 * Clase encargada de almacenar informacion de los tiquetes en la base de datos
 */
public class TiqueteDAO {
	
    /**
     * Metodo encargado de instanciar un objeto de la clase Tiquete
     * @param nVehiculo
     * @return Debe ser un objeto de tipo Tiquete
     */
    public ArrayList<Tiquete> seleccionar(Vehiculo nVehiculo){
        ArrayList<Tiquete> retorno= new ArrayList<>();
        PreparedStatement ps;
        FachadaDB bd = new FachadaDB();
        Connection con = bd.crearConexion();
        Statement st = null;
        ResultSet res = null;
        Tiquete t = null;
        try {
            String query = "SELECT * FROM tiquete WHERE vehiculo = '" + nVehiculo.getPlaca() + "'";
            st = con.createStatement();
            res = st.executeQuery(query);
            while(res.next()){
                t = new Tiquete(res.getTime("hora_venta"), res.getDouble("valor_tiquete"), res.getInt("numero"));
                retorno.add(t);
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
        return retorno;
    }
    
    
    /**
     * Metodo encargado de agregar un tiquete en la base de datos
     * @param nVehiculo
     * @param nTiquete
     * @param nCliente
     */
    public void agregar(Vehiculo nVehiculo, Tiquete nTiquete, Cliente nCliente){
        Connection con = null;
        Statement st = null;
        String hora = new SimpleDateFormat(RutasSuroccidente.FORMATO_HORAS).format(nTiquete.getHoraVenta());
        String query = "INSERT INTO tiquete (numero, hora_venta, valor_tiquete, vehiculo, cliente)"
                + " VALUES (" + nTiquete.getNumero() + ", "
                + "'" + hora + "', "
                + nTiquete.getValorTiquete() + ", "
                + "'" + nVehiculo.getPlaca() + "', "
                + nCliente.getIdentificacion() + ")";
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
            System.out.println("Se ha agregado un nuevo tiquete de número: " + nTiquete.getNumero());
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
     * @param nTiquete
     */
    public void actualizar(Tiquete nTiquete){
        Connection con = null;
        Statement st = null;
        String hora = new SimpleDateFormat(RutasSuroccidente.FORMATO_HORAS).format(nTiquete.getHoraVenta());
        String query = "UPDATE tiquete SET hora_venta = '" + hora + "', "
                + "valor_tiquete = " + nTiquete.getValorTiquete()
                + " WHERE numero = " + nTiquete.getNumero();
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
             System.out.println("Se ha modificado el tiquetede número: " + nTiquete.getNumero());
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
     * @param nTiquete
     */
    public void eliminar(Tiquete nTiquete){
        Connection con = null;
        Statement st = null;
        String query = "DELETE FROM tiquete  WHERE numero = " + nTiquete.getNumero();
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
             System.out.println("Se ha eliminado el tiquete de número: " + nTiquete.getNumero());
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
    public ArrayList<Tiquete> seleccionar(Cliente nCliente){
        ArrayList<Tiquete> retorno= new ArrayList<>();
        PreparedStatement ps;
        FachadaDB bd = new FachadaDB();
        Connection con = bd.crearConexion();
        Statement st = null;
        ResultSet res = null;
        Tiquete t = null;
        try {
            String query = "SELECT * FROM tiquete WHERE cliente = '" + nCliente.getIdentificacion() + "'";
            st = con.createStatement();
            res = st.executeQuery(query);
            while(res.next()){
                t = new Tiquete(res.getTime("hora_venta"), res.getDouble("valor_tiquete"), res.getInt("numero"));
                retorno.add(t);
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
        return retorno;
    }
}