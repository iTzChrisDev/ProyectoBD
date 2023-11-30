package Funciones.Relaciones;
import ConexionBD.Conexion;
import TDA.Relaciones.Provee;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CRUDProveen {

    private Conexion obC;
    private PreparedStatement pstm;
    private ResultSet output;
    private String query;
    private ArrayList<Provee> data;

    public CRUDProveen() {
        obC = new Conexion();
        pstm = null;
        output = null;
        data = new ArrayList<>();
    }

    public void selectProveen() {
        try {
            query = "SELECT * FROM proveen;";
            pstm = obC.setConnection().prepareStatement(query);
            output = pstm.executeQuery();

            while (output.next()) {
                int idVideojuego = output.getInt("id_videojuego");
                int idProveedor = output.getInt("id_proveedores");
                int idTienda = output.getInt("id_tiendas");
                int cantidad = output.getInt("Cantidad");
                Date fecha = output.getDate("Fecha");

                data.add(new Provee(idVideojuego, idProveedor, idTienda, cantidad, fecha));
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

    public void insertProveen(Provee proveen) {
        try {
            query = "INSERT INTO proveen (id_videojuego, id_proveedores, id_tiendas, Cantidad, Fecha) VALUES (?, ?, ?, ?, ?);";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setInt(1, proveen.getId_videojuego());
            pstm.setInt(2, proveen.getId_proveedor());
            pstm.setInt(3, proveen.getId_tienda());
            pstm.setInt(4, proveen.getCantidad());
            pstm.setDate(5, proveen.getFechaSurtido());
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

    public void updateProveen(int idVideojuego, int idProveedor, int idTienda, Provee proveen) {
        try {
            query = "UPDATE proveen SET Cantidad = ?, Fecha = ? WHERE id_videojuego = ? AND id_proveedores = ? AND id_tiendas = ?";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setInt(1, proveen.getCantidad());
            pstm.setDate(2, proveen.getFechaSurtido());
            pstm.setInt(3, idVideojuego);
            pstm.setInt(4, idProveedor);
            pstm.setInt(5, idTienda);
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

    public void deleteProveen(int idVideojuego, int idProveedor, int idTienda) {
        try {
            query = "DELETE FROM proveen WHERE id_videojuego = ? AND id_proveedores = ? AND id_tiendas = ?";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setInt(1, idVideojuego);
            pstm.setInt(2, idProveedor);
            pstm.setInt(3, idTienda);
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
