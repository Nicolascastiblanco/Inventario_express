package Modelo;

import org.mindrot.jbcrypt.BCrypt;

public class Encriptacion {

    public static String encriptar(String contraseña) {
        return BCrypt.hashpw(contraseña, BCrypt.gensalt());
    }

    public static boolean verificar(String contraseña, String hash) {
        return BCrypt.checkpw(contraseña, hash);
    }
}
