package Funciones.Relaciones;
import ConexionBD.Conexion;
import TDA.Relaciones.Trabajo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class CRUDTrabaja {

    private Conexion obC;
    private PreparedStatement pstm;
    private ResultSet output;
    private String query;
    private ArrayList<Trabajo> data;

    public CRUDTrabaja() {
        obC = new Conexion();
        pstm = null;
        output = null;
        data = new ArrayList<>();
    }

    public void selectTrabaja() {
        try {
            query = "SELECT * FROM trabaja;";
            pstm = obC.setConnection().prepareStatement(query);
            output = pstm.executeQuery();

            while (output.next()) {
                int idTienda = output.getInt("id_tiendas");
                int idEmpleado = output.getInt("id_empleado");
                Time horaEntrada = output.getTime("Hora_Entrada");
                Time horaSalida = output.getTime("Hora_Salida");
                String turno = output.getString("Turno");

                data.add(new Trabajo(idTienda, idEmpleado, horaEntrada, horaSalida, turno));
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

    public void insertTrabaja(Trabajo trabaja) {
        try {
            query = "INSERT INTO trabaja (id_tiendas, id_empleado, Hora_Entrada, Hora_Salida, Turno) VALUES (?, ?, ?, ?, ?);";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setInt(1, trabaja.getId_tienda());
            pstm.setInt(2, trabaja.getId_empleado());
            pstm.setTime(3, trabaja.getHrEntrada());
            pstm.setTime(4, trabaja.getHrSalida());
            pstm.setString(5, trabaja.getTurno());
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

    public void updateTrabaja(int idTienda, int idEmpleado, Trabajo trabaja) {
        try {
            query = "UPDATE trabaja SET Hora_Entrada = ?, Hora_Salida = ?, Turno = ? WHERE id_tiendas = ? AND id_empleado = ?";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setTime(1, trabaja.getHrEntrada());
            pstm.setTime(2, trabaja.getHrSalida());
            pstm.setString(3, trabaja.getTurno());
            pstm.setInt(4, idTienda);
            pstm.setInt(5, idEmpleado);
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

    public void deleteTrabaja(int idTienda, int idEmpleado) {
        try {
            query = "DELETE FROM trabaja WHERE id_tiendas = ? AND id_empleado = ?";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setInt(1, idTienda);
            pstm.setInt(2, idEmpleado);
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

