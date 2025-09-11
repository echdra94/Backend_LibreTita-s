document.addEventListener("DOMContentLoaded", () => {
  fetch("navbar.html")
    .then(response => response.text())
    .then(data => {
      document.getElementById("navBar").innerHTML = data;

      // Espera a que el HTML del navbar esté insertado
      const perfil = document.getElementById("perfil");
	  const token = sessionStorage.getItem("authToken");
      

      if (perfil) {
        if (token) {
          perfil.style.display = "inline"; // o "block"
        } else {
          perfil.style.display = "none";
        }
      }
    })
    .catch(error => console.error("Error cargando navbar:", error));
});
