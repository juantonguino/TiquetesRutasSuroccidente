package modelo.datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.mundo.*;

/**
 * Clase encargada de almacenar la información de los clientes en la la base de datos
 * @author juandiego
 */
public class ClienteDAO {
	

    /**
     * Metodo encargado de seleccionar un cliente de la base de datos dado su identificación
     * @return  Debe ser de tipo Cliente
     * <pre:> Tener inicializado el enlace a la clase Fachada DB <br>
     * <post:> Realizar seleccion de un cliente de la base de datos <br>
     */
    public ArrayList<Cliente> seleccionar(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        FachadaDB bd = new FachadaDB();
        Connection con = bd.crearConexion();
        Statement st = null;
        ResultSet res = null;
        try {
            String query = "SELECT * FROM cliente";
            st = con.createStatement();
            res = st.executeQuery(query);
            while(res.next()){
                clientes.add(new Cliente(res.getInt("identificacion"), res.getString("nombres"), res.getString("apellidos")));
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
        return clientes;
    }
    
    
    /**
     * Metodo encargado de agregar un cliente a la base de datos
     * @param nCliente != null Objeto de la clase Cliente
     * <pre:> Tener inicializado el enlace a la clase FachadaDB. <br>
     * <post:> Se ha agregado un nuevo cliente en la base de datos. <br>
     */
    public void agregar(Cliente nCliente) {
        Connection con = null;
        Statement st = null;
        String query = "INSERT INTO cliente (identificacion, nombres, apellidos)"
                + " VALUES (" + nCliente.getIdentificacion() + ","
                + " '" + nCliente.getNombres() + "',"
                + " '" + nCliente.getApellidos() + "')";
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
            System.out.println("Se ha agregado un cliente nuevo con la identificación: " + nCliente.getIdentificacion());
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
     * Metodo encargado de actualizar la información del cliente en la base de datos
     * @param nCliente != null Objeto de la clase Cliente
     * <pre:> Tener inicializado el enlace a la clase FachadaDB. <br>
     * <post:> Se ha actualizado el cliente en la base de datos. <br>
     * @throws java.lang.ClassNotFoundException Excepción causada porque no se ha realizado una correcta conexión a la base de datos.
     */
    public void actualizar(Cliente nCliente) throws ClassNotFoundException {
        Connection con = null;
        Statement st = null;
        String query = "UPDATE cliente SET nombres = '" + nCliente.getNombres() + "'"
                + ", apellidos = '" + nCliente.getApellidos() + "'"
                + " WHERE identificacion = " + nCliente.getIdentificacion();
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
             System.out.println("Se ha modificado el cliente con la identificación: " + nCliente.getIdentificacion());
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
     * Metodo encargado de eliminar un cliente de la base de datos
     * @param nCliente
     * <pre:> Tener inicializado el enlace a la clase FachadaDB. <br>
     * <post:> Se ha eliminado el cliente de la base de datos. <br>   
     */
    public void eliminar(Cliente nCliente) {
        Connection con = null;
        Statement st = null;
        String query = "DELETE FROM cliente  WHERE identificación = " + nCliente.getIdentificacion();
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
             System.out.println("Se ha eliminado el cliente con la identificación: " + nCliente.getIdentificacion() );
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