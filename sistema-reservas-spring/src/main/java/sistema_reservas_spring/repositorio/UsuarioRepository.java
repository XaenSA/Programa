package sistema_reservas_spring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema_reservas_spring.modelo.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Método personalizado para buscar por correo durante el Login
    Optional<Usuario> findByCorreo(String correo);
}