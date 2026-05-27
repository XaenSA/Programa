function mostrarSeccion(id) {
    const secciones = document.querySelectorAll('.seccion');
    secciones.forEach(seccion => {
        seccion.classList.remove('activa');
    });

    document.getElementById(id).classList.add('activa');
}

function validarLogin() {
    alert("Inicio de sesión simulado correctamente");
    return false;
}

function realizarReserva() {
    alert("Reserva realizada con éxito");
    return false;
}
