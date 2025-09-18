const btnEnviar = document.getElementById("btnEnviar");
const alertValidaciones = document.getElementById("alertValidaciones");
const alertValidacionesTexto = document.getElementById("alertValidacionesTexto");
const txtNombre = document.getElementById("txtNombre");
const txtApellido = document.getElementById("txtApellido");
const iptCorreo1 = document.getElementById("iptCorreo1"); // iptCorreo1 Correo electrónico
const selectDominio = document.getElementById("selectDominio"); // Select para elegir el dominio
const iptCorreoDominio = document.getElementById("iptCorreoDominio"); // Input para la parte del dominio
const txtPassword = document.getElementById("txtPassword"); // Input contraseña
const txtConfirmPassword = document.getElementById("txtConfirmPassword"); // Input confirmar contraseña
const contadorCaracteres = document.getElementById("contadorCaracteres"); // Texto que muestra el conteo de caracteres
const txtTelefonoUsuario = document.getElementById("txtTelefonoUsuario");

btnEnviar.addEventListener("click", function(event) {
    event.preventDefault();

    // Limpiar alertas y estilos
    alertValidacionesTexto.innerHTML = "";
    alertValidaciones.style.display = "none";
    alertValidaciones.classList.remove("alert-success");
    alertValidaciones.classList.add("alert-danger");

    const campos = [txtNombre, txtApellido, iptCorreo1, txtTelefonoUsuario, txtPassword, txtConfirmPassword];
    campos.forEach(campo => {
        campo.style.boxShadow = "none";
        campo.style.border = "";
    });

    let isValid = true;

    /** -------------------------- NOMBRE -------------------------- */
    const regexNombre = /^(?!.*([a-zA-ZÁÉÍÓÚáéíóúÑñ])\1{2})([A-Za-zÁÉÍÓÚáéíóúÑñ]{3,})+$/;
    if (!regexNombre.test(txtNombre.value.trim())) {
        txtNombre.style.border = "thin solid #DD0069";
        txtNombre.style.boxShadow = "0 0 6px 3px rgba(221,0,107,0.6)";
        alertValidacionesTexto.innerHTML += "<strong>Ingresa un nombre válido</strong><br>";
        isValid = false;
    }

    /** -------------------------- APELLIDO -------------------------- */
    const regexApellido = /^(?!.*([a-zA-ZÁÉÍÓÚáéíóúÑñ])\1{2})([A-Za-zÁÉÍÓÚáéíóúÑñ]{3,})+$/;
    if (!regexApellido.test(txtApellido.value.trim())) {
        txtApellido.style.border = "thin solid #DD0069";
        txtApellido.style.boxShadow = "0 0 6px 3px rgba(221,0,107,0.6)";
        alertValidacionesTexto.innerHTML += "<strong>Ingresa un apellido válido</strong><br>";
        isValid = false;
    }

    /** -------------------------- CORREO -------------------------- */
    iptCorreo1.value = iptCorreo1.value.toLowerCase().trim();
    let correoCompleto = iptCorreo1.value;
    if (iptCorreoDominio.value.trim()) {
        correoCompleto += "@" + iptCorreoDominio.value.toLowerCase().trim();
    } else if (selectDominio.value) {
        correoCompleto += "@" + selectDominio.value;
    }

    const regexCorreo = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$/;
    if (!regexCorreo.test(correoCompleto)) {
        iptCorreo1.style.border = "1px solid #DD0069";
        iptCorreo1.style.boxShadow = "0 0 6px 3px rgba(221,0,107,0.6)";
        alertValidacionesTexto.innerHTML += "<strong>Ingresa un correo electrónico válido</strong><br>";
        isValid = false;
    }

    const partesCorreo = correoCompleto.split("@");
    if (partesCorreo[0].includes("..") || partesCorreo[1].includes("..") || !/^[a-z0-9._%+-]+$/.test(partesCorreo[0])) {
        alertValidacionesTexto.innerHTML += "<strong>El correo no puede tener puntos consecutivos ni caracteres inválidos.</strong><br>";
        isValid = false;
    }

    /** -------------------------- CONTRASEÑAS -------------------------- */
    const password = txtPassword.value.trim();
    if (!password || password !== txtConfirmPassword.value.trim()) {
        alertValidacionesTexto.innerHTML += "<strong>Las contraseñas deben coincidir y no estar vacías.</strong><br>";
        txtPassword.style.boxShadow = txtConfirmPassword.style.boxShadow = "0 0 6px 3px rgba(221,0,107,0.6)";
        isValid = false;
    } else {
        const erroresPwd = [];
        if (password.length < 8) erroresPwd.push("Debe tener al menos 8 caracteres.");
        if (!/[A-Z]/.test(password)) erroresPwd.push("Debe contener al menos una letra mayúscula.");
        if (!/[a-z]/.test(password)) erroresPwd.push("Debe contener al menos una letra minúscula.");
        if (!/[0-9]/.test(password)) erroresPwd.push("Debe contener al menos un número.");
        if (!/[!@#$%^&*(),.?":{}|<>]/.test(password)) erroresPwd.push("Debe contener al menos un símbolo.");

        if (erroresPwd.length > 0) {
            erroresPwd.forEach(e => alertValidacionesTexto.innerHTML += `<strong>${e}</strong><br>`);
            txtPassword.style.border = "2px solid #DD0069";
            txtPassword.style.boxShadow = txtConfirmPassword.style.boxShadow = "0 0 6px 3px rgba(221,0,107,0.6)";
            isValid = false;
        }
    }

    /** -------------------------- TELÉFONO -------------------------- */
    const regexTelefono = /^[2-9][0-9]{9}$/;
    const telefono = txtTelefonoUsuario.value.trim();

    function esSecuenciaAscDesc(numero) {
        let asc = true, desc = true;
        for (let i = 1; i < numero.length; i++) {
            if (parseInt(numero[i]) !== (parseInt(numero[i-1]) + 1) % 10) asc = false;
            if (parseInt(numero[i]) !== (parseInt(numero[i-1]) - 1 + 10) % 10) desc = false;
        }
        return asc || desc;
    }

    function esPatronRepetitivo(numero) {
        for (let len = 1; len <= 3; len++) {
            let bloque = numero.slice(0,len);
            let repetido = true;
            for (let i = 0; i < numero.length; i += len) {
                if (numero.slice(i,i+len) !== bloque) {
                    repetido = false;
                    break;
                }
            }
            if (repetido) return true;
        }
        return false;
    }

    if (!regexTelefono.test(telefono) || /^(\d)\1{9}$/.test(telefono) || esSecuenciaAscDesc(telefono) || esPatronRepetitivo(telefono)) {
        txtTelefonoUsuario.style.border = "1px solid #DD0069";
        txtTelefonoUsuario.style.boxShadow = "0 0 6px 3px rgba(221,0,107,0.6)";
        alertValidacionesTexto.innerHTML += "<strong>Ingresa un teléfono válido de 10 dígitos, no repetido ni secuencial.</strong><br>";
        isValid = false;
    }

    /** -------------------------- ENVÍO DE DATOS -------------------------- */
    if (!isValid) {
        alertValidaciones.style.display = "block";
        return;
    }

    const datosFormulario = {
        nombre: txtNombre.value.trim(),
        apellido: txtApellido.value.trim(),
        correo: correoCompleto,
        contraseña: password,
        telefono: telefono
    };

    fetch("/api/usuarios/", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(datosFormulario)
    })
    .then(async response => {
		
        if (!response.ok) throw new Error("Error al registrar usuario");
        return response.status !==204 ? await response.json() : {};
    })
    .then(data => {
        alertValidacionesTexto.innerHTML = "<strong class='text-success'>Registro satisfactorio</strong>";
        alertValidaciones.classList.remove("alert-danger");
        alertValidaciones.classList.add("alert-success");
        alertValidaciones.style.display = "block";

		txtNombre.value = "";
				txtApellido.value = "";
				iptCorreo1.value = "";
				iptCorreoDominio.value = "";
				txtPassword.value = "";
				txtConfirmPassword.value = "";
				txtTelefonoUsuario.value = "";
				checkbox.value = "No";
				txtNombre.focus();

        setTimeout(() => window.location.reload(), 2000);
    })
    .catch(error => {
        console.error(error);
        alertValidacionesTexto.innerHTML = "<strong>Hubo un error al registrar el usuario</strong>";
        alertValidaciones.classList.remove("alert-success");
        alertValidaciones.classList.add("alert-danger");
        alertValidaciones.style.display = "block";
		// Limpiar campos
		
    });
});
