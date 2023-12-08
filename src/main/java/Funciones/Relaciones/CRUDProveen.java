package Funciones.Relaciones;

import ConexionBD.Conexion;
import TDA.Relaciones.Provee;
import java.sql.CallableStatement;
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
    private ArrayList<Provee> data, dataV;

    public CRUDProveen() {
        obC = new Conexion();
        pstm = null;
        output = null;
        data = new ArrayList<>();
        dataV = new ArrayList<>();
    }

    public ArrayList<Provee> getData() {
        return data;
    }

    public ArrayList<Provee> getDataV() {
        return dataV;
    }

    public void selectProveenTb(int id) {
        try {
            query = "SELECT p.*, v.Nombre AS Videojuego, t.Nombre AS Tienda, pr.Nombre AS Proveedor FROM proveen AS p\n"
                    + "INNER JOIN videojuegos AS v ON p.id_videojuego = v.id_videojuego\n"
                    + "INNER JOIN proveedores AS pr ON p.id_proveedor = pr.id_proveedor\n"
                    + "INNER JOIN tiendas AS t ON p.id_tienda = t.id_tienda AND p.id_tienda = ? ORDER BY p.id_videojuego ASC;";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setInt(1, id);
            output = pstm.executeQuery();

            while (output.next()) {
                int idVideojuego = output.getInt("id_videojuego");
                int idProveedor = output.getInt("id_proveedor");
                int idTienda = output.getInt("id_tienda");
                int cantidad = output.getInt("Cantidad");
                Date fecha = output.getDate("Fecha");
                String videojuego = output.getString("Videojuego");
                String tienda = output.getString("Tienda");
                String proveedor = output.getString("Proveedor");

                data.add(new Provee(idVideojuego, idTienda, idProveedor, cantidad, fecha, videojuego, tienda, proveedor));
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

    public void selectProveen() {
        try {
            query = "SELECT p.*, v.Nombre AS Videojuego, t.Nombre AS Tienda, pr.Nombre AS Proveedor FROM proveen AS p\n"
                    + "INNER JOIN videojuegos AS v ON p.id_videojuego = v.id_videojuego\n"
                    + "INNER JOIN proveedores AS pr ON p.id_proveedor = pr.id_proveedor\n"
                    + "INNER JOIN tiendas AS t ON p.id_tienda = t.id_tienda;";
            pstm = obC.setConnection().prepareStatement(query);
            output = pstm.executeQuery();

            while (output.next()) {
                int idVideojuego = output.getInt("id_videojuego");
                int idProveedor = output.getInt("id_proveedor");
                int idTienda = output.getInt("id_tienda");
                int cantidad = output.getInt("Cantidad");
                Date fecha = output.getDate("Fecha");
                String videojuego = output.getString("Videojuego");
                String tienda = output.getString("Tienda");
                String proveedor = output.getString("Proveedor");

                data.add(new Provee(idVideojuego, idTienda, idProveedor, cantidad, fecha, videojuego, tienda, proveedor));
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
            query = "CALL insertar_proveen(?, ?, ?, ?, ?);";
            CallableStatement cstm = obC.setConnection().prepareCall(query);
            cstm.setInt(1, proveen.getId_videojuego());
            cstm.setInt(2, proveen.getId_tienda());
            cstm.setInt(3, proveen.getId_proveedor());
            cstm.setInt(4, proveen.getCantidad());
            cstm.setDate(5, proveen.getFechaSurtido());
            cstm.executeUpdate();
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

    public void updateProveen(int idVideojuego, int idProveedor, int idTienda, int cantidad) {
        try {
            query = "CALL actualizar_proveen(?, ?, ?, ?)";
            CallableStatement cstm = obC.setConnection().prepareCall(query);
            cstm.setInt(1, idVideojuego);
            cstm.setInt(2, idTienda);
            cstm.setInt(3, idProveedor);
            cstm.setInt(4, cantidad);
            cstm.executeUpdate();
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
            query = "DELETE FROM proveen WHERE id_videojuego = ? AND id_proveedor = ? AND id_tienda = ?;";
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
