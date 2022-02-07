// Call the dataTables jQuery plugin
$(document).ready(function() {
  // on ready
});

async function registrarUsuario() {

    let datos = {};
    datos.nombre = document.querySelector('#txtNombre').value
    datos.apellido =document.querySelector('#txtApellido').value
    datos.email =document.querySelector('#txtEmail').value
    datos.password =document.querySelector('#txtPassword').value

    let repetirPassword = document.querySelector('#txtRepetirPassword').value

    if (repetirPassword != datos.password) {
        alert("Las contraseñas que escribiste son diferentes, has que coincidan para continuar");
        return;
    }

      const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
      });

      alert("La cuenta fue creada exitosamente");
      window.location.href = 'login.html';
}

