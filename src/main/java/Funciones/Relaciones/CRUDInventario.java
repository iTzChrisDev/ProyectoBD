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
        dataTable.clear();
        try {
            query = "SELECT v.Nombre AS NombreVideojuego, t.Nombre AS NombreTienda, i.Stock, v.id_videojuego, t.id_tienda\n"
                    + "FROM inventario AS i\n"
                    + "INNER JOIN videojuegos v ON i.id_videojuego = v.id_videojuego\n"
                    + "INNER JOIN tiendas t ON i.id_tienda = t.id_tienda;";
            pstm = obC.setConnection().prepareStatement(query);
            output = pstm.executeQuery();

            while (output.next()) {
                aux = new String[5];
                aux[0] = output.getString("NombreVideojuego");
                aux[1] = output.getString("NombreTienda");
                aux[2] = output.getString("Stock");
                aux[3] = output.getString("id_videojuego");
                aux[4] = output.getString("id_tienda");
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
    
    public void selectInventarioTableBus() {
        String aux[] = null;
        dataTable.clear();
        try {
            query = "SELECT v.Nombre AS NombreVideojuego, t.Nombre AS NombreTienda, i.Stock, v.id_videojuego, t.id_tienda\n"
                    + "FROM inventario AS i\n"
                    + "INNER JOIN videojuegos v ON i.id_videojuego = v.id_videojuego\n"
                    + "INNER JOIN tiendas t ON i.id_tienda = t.id_tienda;";
            pstm = obC.setConnection().prepareStatement(query);
            output = pstm.executeQuery();

            while (output.next()) {
                aux = new String[5];
                aux[0] = output.getString("NombreVideojuego");
                aux[1] = output.getString("NombreTienda");
                aux[2] = output.getString("Stock");
                aux[3] = output.getString("id_videojuego");
                aux[4] = output.getString("id_tienda");
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
    }

    public void insertInventario(Inventario inventario) {
        try {
            query = "INSERT INTO inventario (id_videojuego, id_tienda, Stock) \n"
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

    public void updateInventario(int idVideojuego, int idTienda, int stock) {
        try {
            query = "UPDATE inventario SET Stock = ? WHERE id_videojuego = ? AND id_tienda = ?;";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setInt(1, stock);
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
            query = "DELETE FROM inventario WHERE id_videojuego = ? AND id_tienda = ?;";
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
