package Funciones.Entidades;

import ConexionBD.Conexion;
import TDA.Entidades.Proveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CRUDProveedores {

    private Conexion obC;
    private PreparedStatement pstm;
    private ResultSet output;
    private String query;
    private ArrayList<Proveedor> data;

    public CRUDProveedores() {
        obC = new Conexion();
        pstm = null;
        output = null;
        data = new ArrayList<>();
    }

    public ArrayList<Proveedor> getData() {
        return data;
    }

    public void selectProveedor() {
        try {
            query = "SELECT * FROM proveedores;";
            pstm = obC.setConnection().prepareStatement(query);
            output = pstm.executeQuery();

            while (output.next()) {
                int id = output.getInt("id_proveedor");
                String nombre = output.getString("Nombre");
                long telefono = output.getLong("Telefono");
                String domicilio = output.getString("Domicilio");
                String correo = output.getString("Correo");

                data.add(new Proveedor(id, nombre, telefono, domicilio, correo));
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

    public void insertProveedor(Proveedor obP) {
        try {
            query = "INSERT INTO proveedores (Nombre, Telefono, Domicilio, Correo) VALUES (?, ?, ?, ?);";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setString(1, obP.getNombre());
            pstm.setLong(2, obP.getTelefono());
            pstm.setString(3, obP.getDomicilio());
            pstm.setString(4, obP.getCorreo());
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

    public void updateProveedor(int id, Proveedor obP) {
        try {
            query = "UPDATE proveedores SET Nombre = ?, Telefono = ?, Domicilio = ?, Correo = ? WHERE id_proveedor = ?";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setString(1, obP.getNombre());
            pstm.setLong(2, obP.getTelefono());
            pstm.setString(3, obP.getDomicilio());
            pstm.setString(4, obP.getCorreo());
            pstm.setInt(5, id);
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

    public void deleteProveedor(int id) {
        try {
            query = "DELETE FROM proveedores WHERE id_proveedor = ?";
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

    public void selectProveedorCampo(String campo) {
        try {
            query = "SELECT * FROM proveedoresall ORDER BY " + campo + " ASC;";
            pstm = obC.setConnection().prepareStatement(query);
            output = pstm.executeQuery();

            while (output.next()) {
                int id = output.getInt("id_proveedor");
                String nombre = output.getString("Nombre");
                long telefono = output.getInt("Telefono");
                String domicilio = output.getString("Domicilio");
                String correo = output.getString("Correo");

                data.add(new Proveedor(id, nombre, telefono, domicilio, correo));
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
    
    public void selectProveedorCantSurtida() {
        try {
            query = "SELECT * FROM provsurtido;";
            pstm = obC.setConnection().prepareStatement(query);
            output = pstm.executeQuery();

            while (output.next()) {
                String nombre = output.getString("Proveedor");
                int cant = output.getInt("Cantidad_Surtida");

                data.add(new Proveedor(nombre, cant));
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
}
