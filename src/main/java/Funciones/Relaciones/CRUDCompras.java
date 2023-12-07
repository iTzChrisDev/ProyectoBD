package Funciones.Relaciones;

import ConexionBD.Conexion;
import TDA.Relaciones.Compra;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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

    public void selectCompraTb() {
        try {
            query = "SELECT p.*, v.Nombre AS Videojuego, t.Nombre AS Tienda, c.Nombre AS Cliente FROM compra AS p\n"
                    + "INNER JOIN videojuegos AS v ON p.id_videojuego = v.id_videojuego\n"
                    + "INNER JOIN clientes AS C ON C.id_cliente = p.id_cliente\n"
                    + "INNER JOIN tiendas AS t ON p.id_tienda = t.id_tienda \n"
                    + "ORDER BY p.id_videojuego ASC;";
            pstm = obC.setConnection().prepareStatement(query);
            output = pstm.executeQuery();

            while (output.next()) {
                int idVideojuego = output.getInt("id_videojuego");
                int idTienda = output.getInt("id_tienda");
                int idCliente = output.getInt("id_cliente");
                int cantidad = output.getInt("Cantidad");
                double total = output.getDouble("Total");
                Date fecha = output.getDate("Fecha");
                String videojuego = output.getString("Videojuego");
                String tienda = output.getString("Tienda");
                String cliente = output.getString("Cliente");

                data.add(new Compra(idTienda, idCliente, idVideojuego, cantidad, total, fecha, videojuego, tienda, cliente));
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
            query = "CALL insertar_compra(?, ?, ?, ?, ?, ?, ?);";
            CallableStatement cstm = obC.setConnection().prepareCall(query);
            cstm.setInt(1, compra.getIdVideojuego());
            cstm.setInt(2, compra.getIdTienda());
            cstm.setInt(3, compra.getIdCliente());
            cstm.setInt(4, compra.getCantidad());
            cstm.setDouble(5, compra.getTotal());
            cstm.setDate(6, compra.getFechaCompra());
            cstm.registerOutParameter(7, Types.VARCHAR);
            cstm.executeUpdate();

            String mensaje = cstm.getString(7);
            if (!mensaje.equals("Venta realizada correctamente")) {
                JOptionPane.showMessageDialog(null, mensaje + "\nVideojuego no vendido:\nID_Videojuego = " + compra.getIdVideojuego() + "\nStock = " + compra.getCantidad(), "ERROR!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, mensaje + "\nID_Videojuego = " + compra.getIdVideojuego() + "\nStock = " + compra.getCantidad(), "COMPLETADO!", JOptionPane.INFORMATION_MESSAGE);
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

    public ArrayList<Compra> getData() {
        return data;
    }
}
