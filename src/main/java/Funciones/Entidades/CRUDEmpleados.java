package Funciones.Entidades;

import ConexionBD.Conexion;
import TDA.Entidades.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CRUDEmpleados {

    private Conexion obC;
    private PreparedStatement pstm;
    private ResultSet output;
    private String query;
    private ArrayList<Empleado> data;

    public CRUDEmpleados() {
        obC = new Conexion();
        pstm = null;
        output = null;
        data = new ArrayList<>();
    }

    public ArrayList<Empleado> getData() {
        return data;
    }

    
    
    public void selectEmpleado() {
        try {
            query = "SELECT * FROM empleados;";
            pstm = obC.setConnection().prepareStatement(query);
            output = pstm.executeQuery();

            while (output.next()) {
                int id = output.getInt("id_empleado");
                String nombre = output.getString("Nombre");
                String apellidoP = output.getString("ApellidoP");
                String apellidoM = output.getString("ApellidoM");
                String nss = output.getString("NSS");
                String fechaNacimiento = output.getString("Fecha_Nacimiento");
                String curp = output.getString("CURP");
                int telefono = output.getInt("Telefono");
                String domicilio = output.getString("Domicilio");
                int sueldo = output.getInt("Sueldo");

                data.add(new Empleado(id, nombre, apellidoP, apellidoM, nss, fechaNacimiento, curp, telefono, domicilio, sueldo));
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

    public void insertEmpleado(Empleado obE) {
        try {
            query = "INSERT INTO empleados (Nombre, ApellidoP, ApellidoM, NSS, Fecha_Nacimiento, CURP, Telefono, Domicilio, Sueldo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setString(1, obE.getNombre());
            pstm.setString(2, obE.getApellidoP());
            pstm.setString(3, obE.getApellidoM());
            pstm.setString(4, obE.getNSS());
            pstm.setString(5, obE.getFechaNacimiento());
            pstm.setString(6, obE.getCURP());
            pstm.setInt(7, obE.getTelefono());
            pstm.setString(8, obE.getDomicilio());
            pstm.setInt(9, obE.getSueldo());
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

    public void updateEmpleado(int id, Empleado obE) {
        try {
            query = "UPDATE empleados SET Nombre = ?, ApellidoP = ?, ApellidoM = ?, NSS = ?, Fecha_Nacimiento = ?, CURP = ?, Telefono = ?, Domicilio = ?, Sueldo = ? WHERE id_empleado = ?";
            pstm = obC.setConnection().prepareStatement(query);
            pstm.setString(1, obE.getNombre());
            pstm.setString(2, obE.getApellidoP());
            pstm.setString(3, obE.getApellidoM());
            pstm.setString(4, obE.getNSS());
            pstm.setString(5, obE.getFechaNacimiento());
            pstm.setString(6, obE.getCURP());
            pstm.setInt(7, obE.getTelefono());
            pstm.setString(8, obE.getDomicilio());
            pstm.setInt(9, obE.getSueldo());
            pstm.setInt(10, id);
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

    public void deleteEmpleado(int id) {
        try {
            query = "DELETE FROM empleados WHERE id_empleado = ?";
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
