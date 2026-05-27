package sistema_reservas_spring.controlador;

import sistema_reservas_spring.modelo.Usuario;
import sistema_reservas_spring.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    
    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("listaUsuarios", usuarioRepository.findAll());
        return "usuarios"; // Esto buscará un archivo llamado usuarios.html
    }

   
    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "formulario_usuario"; // Esto buscará un archivo formulario_usuario.html
    }

    
    @PostMapping
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioRepository.save(usuario); // ¡Guarda o actualiza automáticamente!
        return "redirect:/usuarios";
    }

   
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Integer id) {
        usuarioRepository.deleteById(id);
        return "redirect:/usuarios";
    }
}