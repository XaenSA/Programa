package com.reservas;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reservas.dao.UsuarioDAO;
import com.reservas.modelo.Usuario;

// Esta es la "Ruta" a la que tu página web va a enviar los datos
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO;

    @Override
    public void init() {
        // Conectamos el Servlet con tu DAO
        usuarioDAO = new UsuarioDAO(); 
    }

    // --- MÉTODO GET: Sirve para cargar la página ---
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("registro.jsp").forward(request, response);
    }

    // --- MÉTODO POST: Sirve para guardar los datos del formulario ---
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Capturamos lo que el usuario escribió en la página web
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String rol = request.getParameter("rol");

        // 2. Armamos el objeto Usuario
        Usuario nuevoUsuario = new Usuario(0, nombre, correo, rol);

        // 3. Le decimos a tu DAO que lo guarde en MySQL
        boolean exito = usuarioDAO.registrarUsuario(nuevoUsuario);

        // 4. Preparamos un mensaje para mostrar en la pantalla
        if (exito) {
            request.setAttribute("mensaje", "¡Registro exitoso! Bienvenido, " + nombre);
        } else {
            request.setAttribute("mensaje", "Hubo un error al guardar en la base de datos.");
        }

        // 5. Recargamos la página web para ver el mensaje
        request.getRequestDispatcher("registro.jsp").forward(request, response);
    }
}