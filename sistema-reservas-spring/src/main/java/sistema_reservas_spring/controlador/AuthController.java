package sistema_reservas_spring.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Controlador REST para gestionar el inicio de sesión y registro de usuarios.
 * Evidencia: GA7-220501096-AA5-EV01
 */
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // Permite la comunicación con el frontend en React
public class AuthController {

    // Simulación de almacenamiento credenciales en memoria para la validación del caso
    private Map<String, String> baseDeDatosUsuarios = new HashMap<>();

    /**
     * Endpoint para registrar un usuario
     */
    @PostMapping("/registro")
    public ResponseEntity<String> registrarUsuario(@RequestBody Map<String, String> credenciales) {
        String usuario = credenciales.get("usuario");
        String contrasena = credenciales.get("contrasena");

        if (usuario == null || contrasena == null || usuario.isEmpty() || contrasena.isEmpty()) {
            return ResponseEntity.badRequest().body("Faltan datos requeridos");
        }

        baseDeDatosUsuarios.put(usuario, contrasena);
        return ResponseEntity.ok("Registro exitoso");
    }

    /**
     * Endpoint para iniciar sesión que valida las credenciales y responde
     * con los mensajes de éxito o error solicitados en la actividad.
     */
    @PostMapping("/login")
    public ResponseEntity<String> iniciarSesion(@RequestBody Map<String, String> credenciales) {
        String usuario = credenciales.get("usuario");
        String contrasena = credenciales.get("contrasena");

        if (baseDeDatosUsuarios.containsKey(usuario) && baseDeDatosUsuarios.get(usuario).equals(contrasena)) {
            return ResponseEntity.ok("Autenticación satisfactoria");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error en la autenticación");
        }
    }
}