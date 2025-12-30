package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

// Librerías para Excel (POI)
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UsuarioDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean registrar(Usuario u) {

        // Llamada correcta a tu conexión
        Connection con = Conexion.conectar();

        // COINCIDE EXACTAMENTE CON TU BASE DE DATOS
        String sql = "INSERT INTO usuario (id_usuario, nombre_usuario, apellido, contrasena, rol) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, u.getid_usuario()); // Si es autoincrement, NO lo pongas
            ps.setString(2, u.getnombre_usuario());
            ps.setString(3, u.getApellido());
            String hash = Encriptacion.encriptar(u.getContrasena());
            ps.setString(4, hash);
            ps.setString(5, u.getRol());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar: " + e.getMessage());
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setid_usuario(rs.getInt("id_usuario"));
                u.setnombre_usuario(rs.getString("nombre_usuario"));
                u.setApellido(rs.getString("apellido"));
                u.setContrasena(rs.getString("contrasena"));
                u.setRol(rs.getString("rol"));
                lista.add(u);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar usuarios: " + e.getMessage());
        }
        return lista;
    }

    public boolean insertarUsuario(Usuario u) {
        String sql = "INSERT INTO usuario (id_usuario, nombre_usuario, apellido, contrasena, rol) VALUES (?,?,?,?,?)";

        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, u.getid_usuario());
            ps.setString(2, u.getnombre_usuario());
            ps.setString(3, u.getApellido());
            String contraseñaEncriptada = Encriptacion.encriptar(u.getContrasena());
            ps.setString(3, contraseñaEncriptada);
            ps.setString(5, u.getRol());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Usuario u) {
        String sql = "UPDATE usuario SET nombre_usuario=?, apellido=?, contrasena=?, rol=? WHERE id_usuario=?";

        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            // IMPORTANTE: orden exacto de los parámetros
            ps.setString(1, u.getnombre_usuario()); // nombre_usuario = ?
            ps.setString(2, u.getApellido());       // apellido = ?
            ps.setString(3, u.getContrasena());     // contrasena = ?
            ps.setString(4, u.getRol());            // rol = ?
            ps.setInt(5, u.getid_usuario());        // WHERE id_usuario = ?

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error actualizar: " + e.getMessage());
            return false;
        }
    }

    // 🔥🔥🔥 MÉTODO PARA EXPORTAR EL JTable A EXCEL
    public boolean exportarExcel(JTable tabla) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar archivo");
            fileChooser.setSelectedFile(new File("usuarios.xlsx"));

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {

                File archivoExcel = fileChooser.getSelectedFile();

                Workbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("Usuarios");

                TableModel modelo = tabla.getModel();

                // Encabezados
                Row headerRow = sheet.createRow(0);
                for (int col = 0; col < modelo.getColumnCount(); col++) {
                    Cell cell = headerRow.createCell(col);
                    cell.setCellValue(modelo.getColumnName(col));
                }

                // Contenido
                for (int row = 0; row < modelo.getRowCount(); row++) {
                    Row excelRow = sheet.createRow(row + 1);
                    for (int col = 0; col < modelo.getColumnCount(); col++) {
                        excelRow.createCell(col).setCellValue(
                                modelo.getValueAt(row, col).toString()
                        );
                    }
                }

                FileOutputStream fileOut = new FileOutputStream(archivoExcel);
                workbook.write(fileOut);
                fileOut.close();
                workbook.close();

                return true;
            }

            return false; // Si cancelan guardar

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al exportar: " + e.getMessage());
            return false;
        }
    }

}
