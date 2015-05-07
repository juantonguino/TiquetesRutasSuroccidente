package modelo.datos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.mundo.Cliente;
import modelo.mundo.Linea;
import modelo.mundo.Marca;
import modelo.mundo.RutaTurno;
import modelo.mundo.Tiquete;
import modelo.mundo.Vehiculo;


/**
 * Clase encargada de almacenar informacion de las rutas de turno de los vehículos en la base de datos
 */
public class RutaTurnoDAO {
	

    /**
     * Metodo encargado de instanciar un objeto de la clase RutaTurno
     * @param nMarca
     * @param nLinea
     * @param nVehiculo
     * @return Debe ser un objeto de tipo RutaTurno
     */
    public RutaTurno seleccionar(Marca nMarca, Linea nLinea,Vehiculo nVehiculo){
        RutaTurno r = null;
        
        return r;
    }


    /**
     * Metodo encargado de agregar una ruta de turno a la base de datos
     * @param nMarca
     * @param nLinea
     * @param nVehiculo
     * @param nRutaurno
     */
    public void agregar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, RutaTurno nRutaurno){
        Connection con = null;
        Statement st = null;
        String query = "INSERT INTO rutaturno (ciudad_destino, ciudad_origen, hora_salida)"
                + " VALUES ('" + nRutaurno.getCiudadDestino() + "', "
                + "'" + nRutaurno.getCiudadOrigen() + "', "
                + nRutaurno.getHoraSalida().getTime() + ")";
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
            System.out.println("Se ha agregado una ruta y turno");
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
     * Metodo encargado de actualizar la información de una ruta de turno en la base de datos
     * @param nMarca
     * @param nLinea
     * @param nVehiculo
     * @param nRutaurno
     */
    public void actualizar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, RutaTurno nRutaurno){
        Connection con = null;
        Statement st = null;
        String query = "UPDATE rutaturno SET ciudad_destino = '" + nRutaurno.getCiudadDestino() + "'"
                + ", ciudad_origen = " + nRutaurno.getCiudadOrigen() + "'"
                + ", hora_salida = " + nRutaurno.getHoraSalida().getTime()
                + " WHERE id_rutaturno = " + nRutaurno.hashCode(); // falta el id
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
             System.out.println("Se ha modificado la ruta turno");
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
     * Metodo encargado de eliminar una ruta de turno a la base de datos
     * @param nMarca
     * @param nLinea
     * @param nVehiculo
     * @param nRutaurno
     */
    public void eliminar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, RutaTurno nRutaurno){
        Connection con = null;
        Statement st = null;
        String query = "DELETE FROM rutaturno  WHERE id_rutaturno = " + nRutaurno.hashCode();
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.prepareStatement(query);
            st.executeQuery(query);
             System.out.println("Se ha eliminado la ruta y turno");
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