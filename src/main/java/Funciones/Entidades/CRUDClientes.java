package Funciones.Entidades;
import ConexionBD.Conexion;
import TDA.Entidades.Cliente;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CRUDClientes {

    private Conexion obC;
    private PreparedStatement pstm;
    private ResultSet output;
    private String query;
    private ArrayList<Cliente> data;

    public CRUDClientes() {
        obC = new Conexion();
        pstm = null;
        output = null;
        data = new ArrayList<>();
    }

    public ArrayList<Cliente> getData() {
        return data;
    }

    public void selectCliente() {
        try {
            query = "SELECT * FROM clientes;";
            pstm = obC.setConnection().prepareStatement(query);
            output = pstm.executeQuery();

            while (output.next()) {
                int id = output.getInt("id_clientes");
                String nombre = output.getString("Nombre");
                String apellidoP = output.getString("ApellidoP");
                String apellidoM = output.getString("ApellidoM");
                Date fechaNacimiento = output.getDate("Fecha_Nacimiento");
                int telefono = output.getInt("Telefono");
                String domicilio = output.getString("Domicilio");
                String correo = output.getString("Correo");

                data.add(new Cliente(id, nombre, apellidoP, apellidoM, fechaNacimiento, telefono, domicilio, correo));
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

    public void insertCliente(Cliente obCli) {
        try {
            query = "INSERT INTO clientes (Nombre, ApellidoP, ApellidoM, Fecha_Nacimiento, Telefono, Domicilio, Correo) VALUES (?, ?, ?, ?, ?, ?, ?);";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setString(1, obCli.getNombre());
            pstm.setString(2, obCli.getApellidoP());
            pstm.setString(3, obCli.getApellidoM());
            pstm.setDate(4, obCli.getFechaNacimiento());
            pstm.setString(5, obCli.getTelefono());
            pstm.setString(6, obCli.getDomicilio());
            pstm.setString(7, obCli.getCorreo());
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

    public void updateCliente(int id, Cliente obCli) {
        try {
            query = "UPDATE clientes SET Nombre = ?, ApellidoP = ?, ApellidoM = ?, Fecha_Nacimiento = ?, Telefono = ?, Domicilio = ?, Correo = ? WHERE id_clientes = ?";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setString(1, obCli.getNombre());
            pstm.setString(2, obCli.getApellidoP());
            pstm.setString(3, obCli.getApellidoM());
            pstm.setDate(4, obCli.getFechaNacimiento());
            pstm.setString(5, obCli.getTelefono());
            pstm.setString(6, obCli.getDomicilio());
            pstm.setString(7, obCli.getCorreo());
            pstm.setInt(8, id);
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

    public void deleteCliente(int id) {
        try {
            query = "DELETE FROM clientes WHERE id_clientes = ?";
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
}

