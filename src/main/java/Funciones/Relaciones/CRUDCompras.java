package Funciones.Relaciones;

import ConexionBD.Conexion;
import TDA.Relaciones.Compra;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CRUDCompras {

    private Conexion obC;
    private PreparedStatement pstm;
    private ResultSet output;
    private String query;
    private ArrayList<Compra> data;

    public CRUDCompras() {
        obC = new Conexion();
        pstm = null;
        output = null;
        data = new ArrayList<>();
    }

    public void selectCompra() {
        try {
            query = "SELECT * FROM compra;";
            pstm = obC.setConnection().prepareStatement(query);
            output = pstm.executeQuery();

            while (output.next()) {
                int idVideojuego = output.getInt("id_videojuego");
                int idTienda = output.getInt("id_tienda");
                int idCliente = output.getInt("id_cliente");
                int cantidad = output.getInt("Cantidad");
                double total = output.getDouble("Total");
                Date fecha = output.getDate("Fecha");

                data.add(new Compra(idVideojuego, idTienda, idCliente, cantidad, total, fecha));
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

    public void insertCompra(Compra compra) {
        try {
            query = "INSERT INTO compra (id_videojuego, id_tienda, id_cliente, Cantidad, Total, Fecha) VALUES (?, ?, ?, ?, ?, ?);";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setInt(1, compra.getIdVideojuego());
            pstm.setInt(2, compra.getIdTienda());
            pstm.setInt(3, compra.getIdCliente());
            pstm.setInt(4, compra.getCantidad());
            pstm.setDouble(5, compra.getTotal());
            pstm.setDate(6, compra.getFechaCompra());
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

    public void updateCompra(int idVideojuego, int idTienda, int idCliente, Compra compra) {
        try {
            query = "UPDATE compra SET Cantidad = ?, Total = ?, Fecha = ? WHERE id_videojuego = ? AND id_tienda = ? AND id_cliente = ?";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setInt(1, compra.getCantidad());
            pstm.setDouble(2, compra.getTotal());
            pstm.setDate(3, compra.getFechaCompra());
            pstm.setInt(4, idVideojuego);
            pstm.setInt(5, idTienda);
            pstm.setInt(6, idCliente);
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

    public void deleteCompra(int idVideojuego, int idTienda, int idCliente) {
        try {
            query = "DELETE FROM compra WHERE id_videojuego = ? AND id_tienda = ? AND id_cliente = ?";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setInt(1, idVideojuego);
            pstm.setInt(2, idTienda);
            pstm.setInt(3, idCliente);
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
