package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.mundo.Propietario;
import modelo.mundo.Vehiculo;

/**
 * Clase encargada de almacenar información de los propietarios de las vehículos en la base de datos
 */
public class PropietarioDAO {

		
    /**
     * Metodo encargado de instanciar un objeto de la clase Propietario
     * @param nVehiculo != null Objeto de la clase Vehiculo
     * @return  Debe ser un objeto de tipo Propietario
     * <pre:> Tener inicializado el enlace a la clase FachadaDB <br>
     * <post:> Realizar seleccion de un propietario de la base de datos <br>
     */
    public Propietario seleccionar(Vehiculo nVehiculo) {
        Propietario p = null;
        PreparedStatement ps;
        FachadaDB bd = new FachadaDB();
        Connection con = bd.crearConexion();
        Statement st = null;
        ResultSet res = null;
        try {
            String query = "SELECT * FROM propietario WHERE vehiculo = '" + nVehiculo.getPlaca() + "'";
            st = con.createStatement();
            res = st.executeQuery(query);
            while(res.next()){
                p = new Propietario(res.getInt("identificacion"), res.getString("nombres"), res.getString("apellidos"), res.getString("direccion"), res.getInt("telefono"));
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
        return p;  
    }
    
    
    /**
     * Metodo encargado de agregar un propietario a la base de datos
     * @param nVehiculo != null Objeto de la clase Vehiculo
     * @param nPropietario != null Objeto de la clase Propietario
     */
    public void agregar(Vehiculo nVehiculo, Propietario nPropietario) {
        Connection con = null;
        Statement st = null;
        String query = "INSERT INTO propietario (identificacion, nombres, apellidos, direccion, telefono, vehiculo)"
                + " VALUES (" + nPropietario.getIdentificacion() + ","
                + " '" + nPropietario.getNombres() + "',"
                + " '" + nPropietario.getApellidos() + "',"
                + " '" + nPropietario.getDireccion() + "',"
                + nPropietario.getTelefono() + ","
                + " '" + nVehiculo.getPlaca() + "')";
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
            System.out.println("Se ha agregado un propietario identificado con el numero: " + nPropietario.getIdentificacion() 
                    + " al vehículo con la placa: " + nVehiculo.getPlaca());
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
     * Metodo encargado de actualizar la información de un propietario en la base de datos
     * @param nVehiculo != null Objeto de la clase Vehiculo
     * @param nPropietario != null Objeto de la clase Propietario
     */
    public void actualizar(Vehiculo nVehiculo, Propietario nPropietario) {
        Connection con = null;
        Statement st = null;
        String query = "UPDATE propietario SET nombres = '" + nPropietario.getNombres() + "'"
                + ", apellidos = '" + nPropietario.getApellidos() + "'"
                + ", direccion = '" + nPropietario.getDireccion() + "'"
                + ", telefono = " + nPropietario.getTelefono() 
                + " WHERE identificacion = " + nPropietario.getIdentificacion();
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
             System.out.println("Se ha modificado el propietario con la identificación: " + nPropietario.getIdentificacion());
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
     * Metodo encargado de eliminar un propietario a la base de datos
     * @param nVehiculo != null Objeto de la clase Vehiculo
     * @param nPropietario != null Objeto de la clase Propietario
     */
    public void eliminar(Vehiculo nVehiculo, Propietario nPropietario) {
        Connection con = null;
        Statement st = null;
        String query = "DELETE FROM propietario WHERE identificacion = " + nPropietario.getIdentificacion();
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
             System.out.println("Se ha eliminado el propietario con la identificación: " + nPropietario.getIdentificacion());
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
