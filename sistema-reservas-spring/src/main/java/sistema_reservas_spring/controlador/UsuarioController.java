package sistema_reservas_spring.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import sistema_reservas_spring.modelo.Usuario;
import sistema_reservas_spring.repositorio.UsuarioRepository;

@RestController // <-- CAMBIO 1: Esto le dice a Spring que devuelva datos (JSON), no pantallas HTML.
@RequestMapping("/api/usuarios") // <-- CAMBIO 2: Es buena práctica ponerle /api a las rutas.
@CrossOrigin(origins = "http://localhost:5173") // <-- CAMBIO 3: Vital para que React no sea bloqueado por seguridad (CORS).
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // 1. Listar todos los usuarios (GET)
    @GetMapping
    public List<Usuario> listarUsuarios() {
        // Ya no usamos "Model". Solo retornamos la lista directamente.
        return usuarioRepository.findAll(); 
    }

    // 2. Guardar un usuario nuevo (POST)
    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        // @RequestBody indica que los datos del usuario llegarán en formato JSON desde React
        return usuarioRepository.save(usuario); 
    }

    // 3. Eliminar un usuario (DELETE)
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Integer id) {
        usuarioRepository.deleteById(id);
    }
}