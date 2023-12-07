package Funciones.Relaciones;
import ConexionBD.Conexion;
import TDA.Relaciones.Atencion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CRUDAtiende {

    private Conexion obC;
    private PreparedStatement pstm;
    private ResultSet output;
    private String query;
    private ArrayList<Atencion> data;

    public CRUDAtiende() {
        obC = new Conexion();
        pstm = null;
        output = null;
        data = new ArrayList<>();
    }

    public void selectAtiende() {
        try {
            query = "SELECT * FROM atiende;";
            pstm = obC.setConnection().prepareStatement(query);
            output = pstm.executeQuery();

            while (output.next()) {
                int idTienda = output.getInt("id_tienda");
                int idCliente = output.getInt("id_cliente");
                int idEmpleado = output.getInt("id_empleado");
                Date fechaAtencion = output.getDate("Fecha_Atencion");

                data.add(new Atencion(idTienda, idCliente, idEmpleado, fechaAtencion));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException ex) {
                }
            }
            obC.closeConnection();
        }
    }

    public void insertAtiende(Atencion atiende) {
        try {
            query = "INSERT INTO atiende (id_tienda, id_cliente, id_empleado, Fecha_Atencion) VALUES (?, ?, ?, ?);";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setInt(1, atiende.getIdTienda());
            pstm.setInt(2, atiende.getIdCliente());
            pstm.setInt(3, atiende.getIdEmpleado());
            pstm.setDate(4, atiende.getFechaAtencion());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException ex) {
                }
            }
            obC.closeConnection();
        }
    }

    public void updateAtiende(int idTienda, int idCliente, int idEmpleado, Atencion atiende) {
        try {
            query = "UPDATE atiende SET Fecha_Atencion = ? WHERE id_tienda = ? AND id_cliente = ? AND id_empleado = ?";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setDate(1, atiende.getFechaAtencion());
            pstm.setInt(2, idTienda);
            pstm.setInt(3, idCliente);
            pstm.setInt(4, idEmpleado);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException ex) {
                }
            }
            obC.closeConnection();
        }
    }

    public void deleteAtiende(int idTienda, int idCliente, int idEmpleado) {
        try {
            query = "DELETE FROM atiende WHERE id_tienda = ? AND id_cliente = ? AND id_empleado = ?";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setInt(1, idTienda);
            pstm.setInt(2, idCliente);
            pstm.setInt(3, idEmpleado);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException ex) {
                }
            }
            obC.closeConnection();
        }
    }
}
