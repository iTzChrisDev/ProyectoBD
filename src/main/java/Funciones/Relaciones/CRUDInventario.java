package Funciones.Relaciones;

import ConexionBD.Conexion;
import TDA.Relaciones.Inventario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CRUDInventario {

    private Conexion obC;
    private PreparedStatement pstm;
    private ResultSet output;
    private String query;
    private ArrayList<Inventario> data;
    private ArrayList<String[]> dataTable;

    public CRUDInventario() {
        obC = new Conexion();
        pstm = null;
        output = null;
        data = new ArrayList<>();
        dataTable = new ArrayList<>();
    }

    public ArrayList<String[]> getDataTable() {
        return dataTable;
    }

    public ArrayList<Inventario> getData() {
        return data;
    }

    public void selectInventario() {
        try {
            query = "SELECT * FROM inventario;";
            pstm = obC.setConnection().prepareStatement(query);
            output = pstm.executeQuery();

            while (output.next()) {
                int idVideojuego = output.getInt("id_videojuego");
                int idTienda = output.getInt("id_tiendas");
                int stock = output.getInt("Stock");

                data.add(new Inventario(idVideojuego, idTienda, stock));
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

    public String[] selectInventarioTable() {
        String aux[] = null;
        try {
            query = "SELECT v.Nombre AS NombreVideojuego, t.Nombre AS NombreTienda, i.Stock\n"
                    + "FROM inventario i\n"
                    + "INNER JOIN videojuegos v ON i.id_videojuego = v.id_videojuego\n"
                    + "INNER JOIN tiendas t ON i.id_tiendas = t.id_tiendas;";
            pstm = obC.setConnection().prepareStatement(query);
            output = pstm.executeQuery();

            while (output.next()) {
                aux = new String[3];
                aux[0] = output.getString("NombreVideojuego");
                aux[1] = output.getString("NombreTienda");
                aux[2] = output.getString("Stock");

                dataTable.add(aux);
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
        return aux;
    }

    public void insertInventario(Inventario inventario) {
        try {
            query = "INSERT INTO inventario (id_videojuego, id_tiendas, Stock) \n"
                    + "VALUES (?, ?, ?)\n"
                    + "ON DUPLICATE KEY UPDATE Stock = VALUES(Stock);";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setInt(1, inventario.getId_videojuego());
            pstm.setInt(2, inventario.getId_tienda());
            pstm.setInt(3, inventario.getStock());
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

    public void updateInventario(int idVideojuego, int idTienda, Inventario inventario) {
        try {
            query = "UPDATE inventario SET Stock = ? WHERE id_videojuego = ? AND id_tiendas = ?";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setInt(1, inventario.getStock());
            pstm.setInt(2, idVideojuego);
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

    public void deleteInventario(int idVideojuego, int idTienda) {
        try {
            query = "DELETE FROM inventario WHERE id_videojuego = ? AND id_tiendas = ?";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setInt(1, idVideojuego);
            pstm.setInt(2, idTienda);
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
