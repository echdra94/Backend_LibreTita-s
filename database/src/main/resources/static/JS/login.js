const btnEnviar = document.getElementById("btnEnviar");
const formLogin = document.getElementById('formularioLogin');
const alertValidaciones = document.getElementById("alertValidaciones");
const alertValidacionesTexto = document.getElementById("alertValidacionesTexto");

btnEnviar.addEventListener("click", function (event) {
    event.preventDefault();

    // Limpiar alertas y bordes
    alertValidacionesTexto.innerHTML = "";
    alertValidaciones.style.display = "none";
    alertValidaciones.classList.remove("alert-success", "alert-danger");
    alertValidaciones.classList.add("alert-danger");

    const correo = document.getElementById("txtCorreo").value.trim().toLowerCase();
    const contraseña = document.getElementById("txtContraseña").value.trim();

    let isValid = true;

    // --- VALIDACIÓN CORREO Y CONTRASEÑA -----

    // Caso 1: campos vacíos
    if (!correo || !contraseña) {
        isValid = false;
        alertValidacionesTexto.innerHTML = "<strong>Completa correo y contraseña.</strong>";
    }

    // Caso 2: formato de correo
    const regexCorreo = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$/;
    if (isValid && !regexCorreo.test(correo)) {
        isValid = false;
        alertValidacionesTexto.innerHTML = "<strong>Formato de correo inválido. Usa ejemplo@dominio.com</strong>";
    }

    if (!isValid) {
        alertValidaciones.style.display = "block";
        return;
    }

    // --- FETCH al backend para login ---
    fetch("/api/login/", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ correo, contraseña })
    })
    .then(response => {
        if (!response.ok) throw new Error("Correo o contraseña incorrectos");
        return response.json();
    })
    .then(data => {
        // Guardar token JWT en sessionStorage
		console.log("Respuesta login:", data);
        sessionStorage.setItem("authToken", data.accesToken);

        // --- ALERTA LOGIN EXITOSO ---
        alertValidacionesTexto.innerHTML = "<strong class='text-success'>¡Inicio de sesión exitoso!</strong>";
        alertValidaciones.classList.remove("alert-danger");
        alertValidaciones.classList.add("alert-success");
        alertValidaciones.style.display = "block";

        // Limpiar campos
        formLogin.reset();

        // Redirigir a la página principal
        setTimeout(() => window.location.href = 'index.html', 1500);
    })
    .catch(error => {
        alertValidacionesTexto.innerHTML = `<strong>${error.message}</strong>`;
        alertValidaciones.classList.remove("alert-success");
        alertValidaciones.classList.add("alert-danger");
        alertValidaciones.style.display = "block";
    });
});
