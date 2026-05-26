package sistema_reservas_spring.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100, unique = true) // Le agregué 'unique' para que no repitan correos
    private String correo;

    @Column(nullable = false, length = 50)
    private String rol;

    // =========================================================================
    // NUEVO CAMBIO PARA GA7: Atributo para almacenar la clave del usuario
    // =========================================================================
    @Column(nullable = false, length = 255) 
    private String contrasena;

    // Constructor vacío obligatorio para JPA
    public Usuario() {
    }

    // Getters y Setters habituales
    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    // =========================================================================
    // NUEVO CAMBIO PARA GA7: Getter y Setter de la contraseña
    // =========================================================================
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
}