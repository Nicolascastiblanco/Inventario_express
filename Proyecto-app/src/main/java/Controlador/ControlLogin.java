package controlador;

import Modelo.Conexion;
import Modelo.Encriptacion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControlLogin {

    public boolean validarUsuario(Usuario usuario) {
        String sql = "SELECT id_usuario, contrasena FROM usuario WHERE nombre_usuario = ?";

        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getnombre_usuario());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String contrasenaBD = rs.getString("contrasena");
                int id = rs.getInt("id_usuario");

                // Si la contraseña NO es un hash válido (usuarios antiguos)
                if (!contrasenaBD.startsWith("$2a$")) {

                    // ✔ Si coincide con la contraseña en texto plano
                    if (usuario.getContrasena().equals(contrasenaBD)) {

                        // 🔥 La encriptamos y actualizamos en BD
                        String nuevoHash = Encriptacion.encriptar(usuario.getContrasena());
                        actualizarContrasena(id, nuevoHash);

                        return true;
                    }

                } else {
                    // ✔ Si el usuario ya tiene hash, validar normal
                    if (Encriptacion.verificar(usuario.getContrasena(), contrasenaBD)) {
                        return true;
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Error en validación: " + e.getMessage());
        }

        return false;
    }

    private void actualizarContrasena(int id, String nuevaContrasenaHash) {
        String sql = "UPDATE usuario SET contrasena = ? WHERE id_usuario = ?";

        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nuevaContrasenaHash);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error actualizando contraseña: " + e.getMessage());
        }
    }

    public Usuario iniciarSesion(String nombre, String contraseña) {
        String sql = "SELECT nombre_usuario, contrasena, rol FROM usuario WHERE nombre_usuario = ?";

        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String hashAlmacenado = rs.getString("contrasena");

                if (Encriptacion.verificar(contraseña, hashAlmacenado)) {

                    Usuario u = new Usuario();
                    u.setnombre_usuario(rs.getString("nombre_usuario"));
                    u.setRol(rs.getString("rol"));  // <---- IMPORTANTE

                    return u;
                }
            }

        } catch (Exception e) {
            System.out.println("Error en login: " + e.getMessage());
        }

        return null;
    }

}
