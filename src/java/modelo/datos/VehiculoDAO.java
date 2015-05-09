package modelo.datos;

import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.mundo.*;


/**
 * Clase encargada de almacenar informacion de los vehiculos en la base de datos
 */
public class VehiculoDAO {


    /**
     * Lista almacenadora de objetos de tipo Vehiculo
     * @param nMarca != null Objeto de la clase Marca
     * @param nLinea != null Objeto de la clase Linea
     * @return  Lista de vehículos.
     * <pre:> Tener inicializado el enlace a la clase FachadaDB <br>
     * <post:> Realizar seleccion de los vehículos de una marca y una linea dada de la base de datos <br>
     */
    public ArrayList<Vehiculo> seleccionar(Marca nMarca, Linea nLinea)  {
        FachadaDB bd = new FachadaDB();
        Connection con = bd.crearConexion();
        Statement st = null;
        ResultSet res = null;
        ArrayList<Vehiculo> vehiculos = new ArrayList();
        try {
            String query = "SELECT * FROM vehiculo";
            st = con.createStatement();
            res = st.executeQuery(query);
            while(res.next()){ 
                vehiculos.add(new Vehiculo(res.getInt("modelo"), res.getString("placa"), res.getInt("numero_pasajeros"), res.getString("fotografia")));
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
        return vehiculos;
    }
    
    
    /**
     * Metodo encargado de agregar un vehículo en la base de datos
     * @param nLinea != null Objeto de la clase Linea
     * @param nVehiculo != null Objeto de la clase Vehiculo
     */
    public void agregar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, Propietario nPropietario) {
        Connection con = null;
        Statement st = null;
        String query = "INSERT INTO vehiculo (placa, modelo, numero_pasajeros, fotografia)"
                + " VALUES ('" + nVehiculo.getPlaca() + "',"
                + " '" + nVehiculo.getModelo() + "',"
                + " '" + nVehiculo.getNumeroPasajeros() + "',"
                + " '" + nVehiculo.getFotografia() + "')";
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
            System.out.println("Se ha agregado un vehiculo con la placa: " + nVehiculo.getPlaca());
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
     * Metodo encargado de actualizar la información de un vehículo en la base de datos
     * @param nMarca != null Objeto de la clase Marca
     * @param nLinea != null Objeto de la clase Linea
     * @param nVehiculo != null Objeto de la clase Vehiculo
     */
    public void actualizar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo)  {
        Connection con = null;
        Statement st = null;
        String query = "UPDATE vehiculo SET modelo = '" + nVehiculo.getModelo() + "'"
                + ", numero_pasajeros = '" + nVehiculo.getNumeroPasajeros() + "'"
                + ", fotografia = '" + nVehiculo.getFotografia() + "'"
                + " WHERE placa = '" + nVehiculo.getPlaca() + "'";
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
             System.out.println("Se ha modificado el vehículo con la placa: " + nVehiculo.getPlaca());
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
     * Metodo encargado de eliminar un vehículo en la base de datos
     * @param nMarca != null Objeto de la clase Marca
     * @param nLinea != null Objeto de la clase Linea
     * @param nVehiculo != null Objeto de la clase Vehiculo
     */
    public void eliminar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo) {
        Connection con = null;
        Statement st = null;
        String query = "DELETE FROM vehiculo  WHERE placa = '" + nVehiculo.getPlaca() + "'";
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
             System.out.println("Se ha eliminado el vehiculo con la placa: " + nVehiculo.getPlaca() );
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
