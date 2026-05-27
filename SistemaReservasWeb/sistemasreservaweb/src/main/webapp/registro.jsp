<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro de Usuario - Sistema de Reservas</title>
</head>
<body>
    <h2>Registro de Nuevo Cliente</h2>
    
    <%-- Esto es un elemento JSP (Scriptlet). Sirve para imprimir mensajes que envía el Servlet --%>
    <%
        String mensaje = (String) request.getAttribute("mensaje");
        if(mensaje != null) {
            out.println("<p style='color: blue; font-weight: bold;'>" + mensaje + "</p>");
        }
    %>

    <%-- El formulario usa el método POST y envía los datos al 'UsuarioServlet' --%>
    <form action="UsuarioServlet" method="POST">
        <label>Nombre Completo:</label>
        <input type="text" name="nombre" required><br><br>
        
        <label>Correo Electrónico:</label>
        <input type="email" name="correo" required><br><br>
        
        <label>Rol en el sistema:</label>
        <select name="rol">
            <option value="Cliente">Cliente</option>
            <option value="Proveedor">Proveedor</option>
        </select><br><br>
        
        <button type="submit">Guardar Registro</button>
    </form>
    
    <br>
    <%-- Este enlace usa el método GET por defecto --%>
    <a href="UsuarioServlet">Recargar formulario (Prueba de método GET)</a>

</body>
</html>