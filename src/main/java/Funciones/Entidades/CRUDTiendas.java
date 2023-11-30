package Funciones.Entidades;
import ConexionBD.Conexion;
import TDA.Entidades.Tienda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CRUDTiendas {

    private Conexion obC;
    private PreparedStatement pstm;
    private ResultSet output;
    private String query;
    private ArrayList<Tienda> data;

    public CRUDTiendas() {
        obC = new Conexion();
        pstm = null;
        output = null;
        data = new ArrayList<>();
    }

    public void selectTienda() {
        try {
            query = "SELECT * FROM tiendas;";
            pstm = obC.setConnection().prepareStatement(query);
            output = pstm.executeQuery();

            while (output.next()) {
                int id = output.getInt("id_tiendas");
                String nombre = output.getString("Nombre");
                String domicilio = output.getString("Domicilio");

                data.add(new Tienda(id, nombre, domicilio));
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

    public void insertTienda(Tienda obT) {
        try {
            query = "INSERT INTO tiendas (Nombre, Domicilio) VALUES (?, ?);";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setString(1, obT.getNombre());
            pstm.setString(2, obT.getDomicilio());
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

    public void updateTienda(int id, Tienda obT) {
        try {
            query = "UPDATE tiendas SET Nombre = ?, Domicilio = ? WHERE id_tiendas = ?";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setString(1, obT.getNombre());
            pstm.setString(2, obT.getDomicilio());
            pstm.setInt(3, id);
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

    public void deleteTienda(int id) {
        try {
            query = "DELETE FROM tiendas WHERE id_tiendas = ?";
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

    public ArrayList<Tienda> getData() {
        return data;
    }
}

