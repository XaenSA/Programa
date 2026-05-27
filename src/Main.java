import com.reservas.dao.UsuarioDAO;
import com.reservas.modelo.Usuario;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();

        
        Usuario nuevo = new Usuario(0, "Prueba SENA", "prueba@sena.edu.co", "Cliente");
        if(dao.registrarUsuario(nuevo)) {
            System.out.println("¡Usuario insertado con éxito!");
        }

        
        dao.listarUsuarios();

        
        Usuario editado = new Usuario(1, "Nombre Editado", "prueba@sena.edu.co", "Cliente");
        dao.actualizarUsuario(editado);

        
    }
}