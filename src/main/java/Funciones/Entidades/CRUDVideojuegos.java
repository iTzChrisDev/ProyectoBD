package Funciones.Entidades;

import ConexionBD.Conexion;
import TDA.Entidades.Videojuego;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CRUDVideojuegos {

    private Conexion obC;
    private PreparedStatement pstm;
    private ResultSet output;
    private String query;
    private ArrayList<Videojuego> data;

    public CRUDVideojuegos() {
        obC = new Conexion();
        pstm = null;
        output = null;
        data = new ArrayList<>();
    }

    public void selectVideojuego() {
        try {
            query = "SELECT * FROM videojuegos;";
            pstm = obC.setConnection().prepareStatement(query);
            output = pstm.executeQuery();

            while (output.next()) {
                int id = output.getInt("id_videojuego");
                String nombre = output.getString("Nombre");
                String categoria = output.getString("Categoria");
                double precio = output.getDouble("Precio");

                data.add(new Videojuego(id, nombre, categoria, precio));
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

    public void insertVideojuego(Videojuego obV) {
        try {
            query = "INSERT INTO videojuegos (Nombre, Precio, Categoria) VALUES (?, ?, ?);";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setString(1, obV.getNombre());
            pstm.setDouble(2, obV.getPrecio());
            pstm.setString(3, obV.getCategoria());
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

    public void updateVideojuego(int id, Videojuego obV) {
        try {
            query = "UPDATE videojuegos SET Nombre = ?, Precio = ?, Categoria = ? WHERE id_videojuego = ?";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setString(1, obV.getNombre());
            pstm.setDouble(2, obV.getPrecio());
            pstm.setString(3, obV.getCategoria());
            pstm.setInt(4, id);
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

    public void deleteVideojuego(int id) {
        try {
            query = "DELETE FROM videojuegos WHERE id_videojuego = ?";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setInt(1, id);
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

    public ArrayList<Videojuego> getData() {
        return data;
    }
}
