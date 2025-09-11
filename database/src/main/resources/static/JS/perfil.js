async function verificarSesion() {
    const token = sessionStorage.getItem("authToken");
	const idUsuario = sessionStorage.getItem("idUsuario");

    if (!token) {
        window.location.href = "login.html";
        return null;
    }

    try {
        const response = await fetch(`http://localhost:8080/api/usuarios/${idUsuario}`, {
            headers: { "Authorization": `Bearer: ${token}` }
        });

        if (!response.ok) throw new Error("Token inválido");

        const usuario = await response.json();
        return usuario;

    } catch (error) {
        console.warn("Sesión no válida, redirigiendo...");
        window.location.href = "login.html";
        return null;
    }
}

async function updatePerfil() {
    const user = await verificarSesion(); // obtenemos usuario desde API
    if (!user) return;

    const cardUsuario = document.getElementById("CardUsuario");
    const nombreGrande = document.getElementById("nombreGrande");
    const nombre = document.getElementById("nombre");
    const correo = document.getElementById("correo");
    const telefono = document.getElementById("telefono");

    if (user && cardUsuario) {
        nombreGrande.innerText = ` ${user.nombre}`;
        nombre.innerText = ` ${user.nombre} ${user.apellido}`;
        correo.innerText = `${user.correo}`;
        telefono.innerText = `${user.telefono}`;
    }
}


// Escuchar la función cuando ya está cargada la página
document.addEventListener("DOMContentLoaded", updatePerfil);
const btnCerrarSesion = document.getElementById("btnCerrarSesion");

btnCerrarSesion.addEventListener("click", function () {
  // Elimina el usuario activo del localStorage
  sessionStorage.removeItem("authToken");

  // Redirige al login
  window.location.href = "login.html";
});


