package sistema_reservas_spring.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sistema_reservas_spring.modelo.Usuario;
import sistema_reservas_spring.repositorio.UsuarioRepository;

import java.util.Optional;

/**
 * Servicio Web para la Autenticación de Usuarios.
 * Evidencia GA7-220501096-AA5-EV01
 */
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173") 
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Servicio para registrar un nuevo usuario en el sistema.
     * @param usuario Objeto con los datos del usuario (correo, contrasena, etc.)
     * @return Mensaje confirmando el registro.
     */
    @PostMapping("/registro")
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario) {
        // Guardamos el usuario recibido en la base de datos
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }

    /**
     * Servicio para el inicio de sesión (Login).
     * @param credenciales Objeto con el correo y la contraseña ingresados.
     * @return Mensaje de éxito o error según la validación.
     */
    @PostMapping("/login")
    public ResponseEntity<String> iniciarSesion(@RequestBody Usuario credenciales) {
        
        // 1. Buscamos al usuario en la base de datos usando su correo
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByCorreo(credenciales.getCorreo());

        // 2. Validamos si el usuario existe
        if (usuarioEncontrado.isPresent()) {
            Usuario usuario = usuarioEncontrado.get();
            
            // Validamos primero que la contraseña de la BD no sea nula antes de comparar
            if (usuario.getContrasena() != null && usuario.getContrasena().equals(credenciales.getContrasena())) {
                // Autenticación correcta según el caso de estudio
                return ResponseEntity.ok("Autenticación satisfactoria");
            }
        }
        
        // Si no existe, es nula o no coincide, devolvemos el error de autenticación exigido
        return ResponseEntity.status(401).body("Error en la autenticación");
    }
}