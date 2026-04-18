let filaSeleccionada = null;

// ================= CARGAR SECCIÓN =================
function cargarSeccion(url, elemento) {
    document.querySelectorAll('.menu-item').forEach(i => i.classList.remove('active'));
    elemento.classList.add('active');

    fetch(url)
        .then(res => res.text())
        .then(html => {
            document.getElementById('area-contenido').innerHTML = html;
            filaSeleccionada = null;
        });
}

// ================= SELECCIONAR FILA =================
function seleccionarFila(fila) {
    document.querySelectorAll("#area-contenido tbody tr")
        .forEach(f => f.classList.remove("seleccionado"));

    fila.classList.add("seleccionado");
    filaSeleccionada = fila;
}

// ================= CLIENTES =================
function guardarCliente() {

    const modal = document.getElementById("modalCliente");

    const nombre = modal?.querySelector("#nombre");
    const apellido = modal?.querySelector("#apellido");
    const direccion = modal?.querySelector("#direccion");

    if (!nombre || !apellido || !direccion) {
        alert("Error: inputs no encontrados");
        return;
    }

    const data = {
        nombreCliente: nombre.value,
        apellidoCliente: apellido.value,
        direccion: direccion.value,
        estado: 1
    };

    fetch("/api/Clientes", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
    .then(() => {
        cerrarModal("modalCliente");
        cargarSeccion('/home/seccion/clientes', document.querySelector('.menu-item.active'));
    });
}

function eliminarCliente() {

    if (!filaSeleccionada) return alert("Selecciona una fila");

    let id = filaSeleccionada.cells[0].innerText;

    fetch("/api/Clientes/" + id, {
        method: "DELETE"
    })
        .then(() => cargarSeccion('/home/seccion/clientes', document.querySelector('.menu-item.active')));
}

function actualizarCliente() {

    if (!filaSeleccionada) return alert("Selecciona una fila");

    let id = filaSeleccionada.cells[0].innerText;

    let data = {
        nombreCliente: prompt("Nombre:", filaSeleccionada.cells[1].innerText),
        apellidoCliente: prompt("Apellido:", filaSeleccionada.cells[2].innerText),
        direccion: prompt("Dirección:", filaSeleccionada.cells[3].innerText),
        estado: 1
    };

    fetch("/api/Clientes/" + id, {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
        .then(() => cargarSeccion('/home/seccion/clientes', document.querySelector('.menu-item.active')));
}

// ================= MODAL CLIENTES =================
function abrirModal(id) {
    document.getElementById(id).style.display = "flex";
}

function cerrarModal(id) {
    document.getElementById(id).style.display = "none";
}

// ===================== PRODUCTOS ======================

function guardarProducto() {

    let nombre = document.getElementById("nombreProducto");
    let precio = document.getElementById("precio");
    let stock = document.getElementById("stock");

    if (!nombre || !precio || !stock) {
        alert("Error: inputs no encontrados");
        return;
    }

    let data = {
        nombreProducto: nombre.value,
        precio: parseFloat(precio.value),
        stock: parseInt(stock.value),
        estado: 1
    };

    fetch("/api/Productos", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
        .then(() => {
            cerrarModal("modalProducto");
            cargarSeccion('/home/seccion/productos', document.querySelector('.menu-item.active'));
        });
}

function eliminarProducto() {

    if (!filaSeleccionada) return alert("Selecciona una fila");

    let id = filaSeleccionada.cells[0].innerText;

    fetch("/api/Productos/" + id, {
        method: "DELETE"
    })
        .then(() => cargarSeccion('/home/seccion/productos', document.querySelector('.menu-item.active')));
}

function actualizarProducto() {

    if (!filaSeleccionada) return alert("Selecciona una fila");

    let id = filaSeleccionada.cells[0].innerText;

    let data = {
        nombreProducto: prompt("Nombre:", filaSeleccionada.cells[1].innerText),
        precio: parseFloat(prompt("Precio:", filaSeleccionada.cells[2].innerText)),
        stock: parseInt(prompt("Stock:", filaSeleccionada.cells[3].innerText)),
        estado: 1
    };

    fetch("/api/Productos/" + id, {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
        .then(() => cargarSeccion('/home/seccion/productos', document.querySelector('.menu-item.active')));
}

// ===================== USUARIOS =======================

function guardarUsuario() {

    let username = document.getElementById("username");
    let contrasena = document.getElementById("contrasena");
    let email = document.getElementById("email");
    let rol = document.getElementById("rol");

    console.log(username, contrasena, email, rol);

    if (!username || !contrasena || !email || !rol) {
        alert("ERROR: inputs no encontrados");
        return;
    }

    let data = {
        username: username.value,
        contrasena: contrasena.value,
        email: email.value,
        rol: rol.value,
        estado: 1
    };

    fetch("/api/Usuarios", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
        .then(res => {
            console.log("RESPUESTA:", res);
            cerrarModal("modalUsuario");
            cargarSeccion('/home/seccion/usuarios', document.querySelector('.menu-item.active'));
        })
        .catch(err => console.error("ERROR:", err));
}

function eliminarUsuario() {

    if (!filaSeleccionada) return alert("Selecciona una fila");

    let id = filaSeleccionada.cells[0].innerText;

    fetch("/api/Usuarios/" + id, {
        method: "DELETE"
    })
        .then(() => cargarSeccion('/home/seccion/usuarios', document.querySelector('.menu-item.active')));
}

function actualizarUsuario() {

    if (!filaSeleccionada) return alert("Selecciona una fila");

    let id = filaSeleccionada.cells[0].innerText;

    let data = {
        username: prompt("Usuario:", filaSeleccionada.cells[1].innerText),
        contrasena: prompt("Contraseña:", filaSeleccionada.cells[2].innerText),
        email: prompt("Email:", filaSeleccionada.cells[3].innerText),
        rol: prompt("Rol:", filaSeleccionada.cells[4].innerText),
        estado: 1
    };

    fetch("/api/Usuarios/" + id, {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
        .then(() => cargarSeccion('/home/seccion/usuarios', document.querySelector('.menu-item.active')));
}

// ===================== VENTAS =========================

function guardarVenta() {

    let data = {
        fechaVenta: document.getElementById("fechaVenta").value,
        total: parseFloat(document.getElementById("total").value),
        estado: 1,
        clientesDpiCliente: parseInt(document.getElementById("cliente").value),
        usuariosCodigoUsuario: parseInt(document.getElementById("usuario").value)
    };

    fetch("/api/Ventas", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
        .then(() => {
            cerrarModal("modalVenta");
            cargarSeccion('/home/seccion/ventas', document.querySelector('.menu-item.active'));
        });
}

function eliminarVenta() {

    if (!filaSeleccionada) return alert("Selecciona una fila");

    let id = filaSeleccionada.cells[0].innerText;

    fetch("/api/Ventas/" + id, {
        method: "DELETE"
    })
        .then(() => cargarSeccion('/home/seccion/ventas', document.querySelector('.menu-item.active')));
}

function actualizarVenta() {

    if (!filaSeleccionada) return alert("Selecciona una fila");

    let id = filaSeleccionada.cells[0].innerText;

    let data = {
        fechaVenta: filaSeleccionada.cells[1].innerText,
        total: parseFloat(prompt("Total:", filaSeleccionada.cells[2].innerText)),
        estado: parseInt(filaSeleccionada.cells[3].innerText),
        clientesDpiCliente: parseInt(filaSeleccionada.cells[4].innerText),
        usuariosCodigoUsuario: parseInt(filaSeleccionada.cells[5].innerText)
    };

    fetch("/api/Ventas/" + id, {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
    .then(() => cargarSeccion('/home/seccion/ventas', document.querySelector('.menu-item.active')));
}

// ================= DETALLE VENTA ======================

function guardarDetalle() {

    let data = {
        cantidad: parseInt(document.getElementById("cantidad").value),
        precioUnitario: parseFloat(document.getElementById("precioUnitario").value),
        subtotal: parseFloat(document.getElementById("subtotal").value),
        productosCodigoProducto: parseInt(document.getElementById("producto").value),
        ventasCodigoVenta: parseInt(document.getElementById("venta").value)
    };

    fetch("/api/DetalleVenta", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
        .then(() => {
            cerrarModal("modalDetalle");
            cargarSeccion('/home/seccion/detalleVenta', document.querySelector('.menu-item.active'));
        });
}

function eliminarDetalle() {

    if (!filaSeleccionada) return alert("Selecciona una fila");

    let id = filaSeleccionada.cells[0].innerText;

    fetch("/api/DetalleVenta/" + id, {
        method: "DELETE"
    })
        .then(() => cargarSeccion('/home/seccion/detalleVenta', document.querySelector('.menu-item.active')));
}

function actualizarDetalle() {

    if (!filaSeleccionada) return alert("Selecciona una fila");

    let id = filaSeleccionada.cells[0].innerText;

    let data = {
        cantidad: parseInt(prompt("Cantidad:", filaSeleccionada.cells[1].innerText)),
        precioUnitario: parseFloat(prompt("Precio Unitario:", filaSeleccionada.cells[2].innerText)),
        subtotal: parseFloat(prompt("Subtotal:", filaSeleccionada.cells[3].innerText)),
        productosCodigoProducto: parseInt(filaSeleccionada.cells[4].innerText),
        ventasCodigoVenta: parseInt(filaSeleccionada.cells[5].innerText)
    };

    fetch("/api/DetalleVenta/" + id, {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
    .then(() => cargarSeccion('/home/seccion/detalleVenta', document.querySelector('.menu-item.active')));
}

function filtrarTabla() {

    const contenedor = document.getElementById("area-contenido");

    const input = contenedor.querySelector(".buscar");
    const filas = contenedor.querySelectorAll("tbody tr");

    if (!input) return;

    const texto = input.value.toLowerCase();

    filas.forEach(fila => {
        fila.style.display =
            fila.innerText.toLowerCase().includes(texto)
                ? ""
                : "none";
    });
}