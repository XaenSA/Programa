package com.reservas.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/sistema_reservas";
    private static final String USUARIO = "root";
    private static final String CLAVE = "contraseña123456";

    
    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return conexion;
    }
}