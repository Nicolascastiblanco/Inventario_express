package Modelo;

public class Usuario {

    private int id_usuario;
    private String nombre_usuario;
    private String apellido;
    private String contrasena;
    private String rol;

    // Constructor vacío (REQUERIDO)
    public Usuario() {
    }

    // Constructor para login (usuario + contraseña)
    public Usuario(String nombre_usuario, String contrasena) {
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
    }

    // GETTERS
    public int getid_usuario() {
        return id_usuario;
    }

    public String getnombre_usuario() {
        return nombre_usuario;
    }

    public String getApellido() {
        return apellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getRol() {
        return rol;
    }

    // SETTERS
    public void setid_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setnombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // Método opcional para mostrar información del usuario
    @Override
    public String toString() {
        return "Usuario{"
                + "nombre='" + nombre_usuario + '\''
                + ", contraseña='" + contrasena + '\''
                + '}';
    }
}
