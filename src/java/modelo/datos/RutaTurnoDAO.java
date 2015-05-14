package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import modelo.mundo.Linea;
import modelo.mundo.Marca;
import modelo.mundo.RutaTurno;
import modelo.mundo.RutasSuroccidente;
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
        PreparedStatement ps;
        FachadaDB bd = new FachadaDB();
        Connection con = bd.crearConexion();
        Statement st = null;
        ResultSet res = null;
        RutaTurno rt = null;
        try {
            String query = "SELECT * FROM rutaturno WHERE vehiculo = " + nVehiculo.getPlaca();
            st = con.createStatement();
            res = st.executeQuery(query);
            while(res.next()){
                rt = new RutaTurno(res.getString("ciudad_origen"), res.getString("cidudad_destino"), res.getTime("hora_salida"));
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
        return rt;
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
        String hora = new SimpleDateFormat(RutasSuroccidente.FORMATO_HORAS).format(nRutaurno.getHoraSalida());
        String query = "INSERT INTO rutaturno (ciudad_destino, ciudad_origen, hora_salida, vehiculo)"
                + " VALUES ('" + nRutaurno.getCiudadDestino() + "', "
                + "'" + nRutaurno.getCiudadOrigen() + "', "
                + "'" + hora + "', "
                + "'" + nVehiculo.getPlaca() + "')";
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.createStatement();
            st.execute(query);
            System.out.println("Se ha agregado una ruta y turno al vehiculo con la placa: " + nVehiculo.getPlaca());
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
        String hora = new SimpleDateFormat(RutasSuroccidente.FORMATO_HORAS).format(nRutaurno.getHoraSalida());
        String query = "UPDATE rutaturno "
                + "SET ciudad_destino = '" + nRutaurno.getCiudadDestino() + "', "
                + "ciudad_origen = '" + nRutaurno.getCiudadOrigen() + "', "
                + "hora_salida = '" + hora + "' "
                + "WHERE vehiculo = '" + nVehiculo.getPlaca() + "'";
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.createStatement();
            st.execute(query);
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
        String query = "DELETE FROM rutaturno  WHERE vehiculo = '" + nVehiculo.getPlaca() + "'";
        try {
            FachadaDB bd = new FachadaDB();
            con = bd.crearConexion();
            st = con.createStatement();
            st.execute(query);
             System.out.println("Se ha eliminado la ruta y turno del vehiculo con la placa: " + nVehiculo.getPlaca());
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