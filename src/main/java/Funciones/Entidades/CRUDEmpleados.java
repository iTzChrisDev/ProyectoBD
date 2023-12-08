package Funciones.Entidades;

import ConexionBD.Conexion;
import TDA.Entidades.Empleado;
import TDA.Relaciones.Trabajo;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class CRUDEmpleados {

    private Conexion obC;
    private PreparedStatement pstm;
    private ResultSet output;
    private String query;
    private ArrayList<Empleado> dataEmpleado;

    public CRUDEmpleados() {
        obC = new Conexion();
        pstm = null;
        output = null;
        dataEmpleado = new ArrayList<>();
    }

    public ArrayList<Empleado> getDataEmpleado() {
        return dataEmpleado;
    }
    
    public void selectEmpleado() {
        try {
            query = "SELECT e.id_empleado, ti.id_tienda, e.Nombre, e.ApellidoP, e.ApellidoM, e.NSS, e.Fecha_Nacimiento, e.CURP, e.Telefono, e.Domicilio, e.Sueldo, ti.Nombre AS Tienda, t.Hora_Entrada, t.Hora_Salida, t.Turno FROM empleados AS e \n"
                    + "INNER JOIN trabaja AS t ON e.id_empleado = t.id_empleado\n"
                    + "INNER JOIN tiendas AS ti ON ti.id_tienda = t.id_tienda\n"
                    + "ORDER BY e.id_empleado ASC;";
            pstm = obC.setConnection().prepareStatement(query);
            output = pstm.executeQuery();

            while (output.next()) {
                int id = output.getInt("id_empleado");
                String nombre = output.getString("Nombre");
                String apellidoP = output.getString("ApellidoP");
                String apellidoM = output.getString("ApellidoM");
                String nss = output.getString("NSS");
                Date fechaNacimiento = output.getDate("Fecha_Nacimiento");
                String curp = output.getString("CURP");
                long telefono = output.getLong("Telefono");
                String domicilio = output.getString("Domicilio");
                int sueldo = output.getInt("Sueldo");
                String nombreTienda = output.getString("Tienda");
                Time horaEntrada = output.getTime("Hora_Entrada");
                Time horaSalida = output.getTime("Hora_Salida");
                String turno = output.getString("Turno");

                dataEmpleado.add(new Empleado(id, nombre, apellidoP, apellidoM, nss, curp, fechaNacimiento, telefono, domicilio, sueldo, nombreTienda, horaEntrada, horaSalida, turno));
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

    public void insertEmpleado(Empleado obE, Trabajo obT) {
        try {
            query = "CALL insertar_empleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            CallableStatement stat = (CallableStatement) obC.setConnection().prepareCall(query);           
            stat.setString(1, obE.getNombre());
            stat.setString(2, obE.getApellidoP());
            stat.setString(3, obE.getApellidoM());
            stat.setString(4, obE.getNSS());
            stat.setDate(5, obE.getFechaNacimiento());
            stat.setString(6, obE.getCURP());
            stat.setLong(7, obE.getTelefono());
            stat.setString(8, obE.getDomicilio());
            stat.setDouble(9, obE.getSueldo());
            stat.setInt(10, obT.getId_tienda());
            stat.setTime(11, obT.getHrEntrada());
            stat.setTime(12, obT.getHrSalida());
            stat.setString(13, obT.getTurno());
            
            stat.executeUpdate();
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

    public void updateEmpleado(int id, Empleado obE, Trabajo obT) {
        try {
            query = "CALL actualizar_empleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            CallableStatement stat = (CallableStatement) obC.setConnection().prepareCall(query);   
            stat.setInt(1, id);
            stat.setString(2, obE.getNombre());
            stat.setString(3, obE.getApellidoP());
            stat.setString(4, obE.getApellidoM());
            stat.setString(5, obE.getNSS());
            stat.setDate(6, obE.getFechaNacimiento());
            stat.setString(7, obE.getCURP());
            stat.setLong(8, obE.getTelefono());
            stat.setString(9, obE.getDomicilio());
            stat.setDouble(10, obE.getSueldo());
            stat.setInt(11, obT.getId_tienda());
            stat.setTime(12, obT.getHrEntrada());
            stat.setTime(13, obT.getHrSalida());
            stat.setString(14, obT.getTurno());
            
            stat.executeUpdate();
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
            query = "CALL eliminar_empleado(?);";
            CallableStatement stat = (CallableStatement) obC.setConnection().prepareCall(query);  
            stat.setInt(1, id);
            
            stat.executeUpdate();
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
    
    public void selectEmpleadoClientes() {
        try {
            query = "SELECT * FROM eatenciones;";
            pstm = obC.setConnection().prepareStatement(query);
            output = pstm.executeQuery();

            while (output.next()) {
                int id = output.getInt("id");
                String nombre = output.getString("Empleado");
                String apPaterno = output.getString("Apellido_Paterno");
                int clientes = output.getInt("Atendidos");
                
                dataEmpleado.add(new Empleado(id, nombre, apPaterno, clientes));
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
