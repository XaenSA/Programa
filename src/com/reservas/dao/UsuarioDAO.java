package com.reservas.dao;

import com.reservas.conexion.ConexionBD;
import com.reservas.modelo.Usuario;
import java.sql.*;

public class UsuarioDAO {

    
    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, correo, rol) VALUES (?, ?, ?)";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getRol());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al registrar: " + e.getMessage());
            return false;
        }
    }

    
    public void listarUsuarios() {
        String sql = "SELECT * FROM usuarios";
        try (Connection con = ConexionBD.obtenerConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            
            System.out.println("--- LISTA DE USUARIOS ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_usuario") + 
                                   " | Nombre: " + rs.getString("nombre") + 
                                   " | Correo: " + rs.getString("correo"));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar: " + e.getMessage());
        }
    }

    
    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, correo = ?, rol = ? WHERE id_usuario = ?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getRol());
            ps.setInt(4, usuario.getIdUsuario());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    
    public boolean eliminarUsuario(int idUsuario) {
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idUsuario);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }
}