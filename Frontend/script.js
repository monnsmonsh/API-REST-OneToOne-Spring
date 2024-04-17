const API_URL_EMPLEADOS = "http://localhost:8080/api/v1/employee";
const API_URL_CARGOS = "http://localhost:8080/api/v1/management";

// Función para cargar management de carros en el formulario de employee
function cargarOpcionesCargos() {
    fetch(API_URL_CARGOS)
        .then((response) => response.json())
        .then((data) => {
            const selectCargo = document.getElementById("empleadoCargo");
            selectCargo.innerHTML = "";
            data.forEach((cargo) => {
                const option = document.createElement("option");
                option.value = cargo.idManagement;
                option.textContent = `${cargo.name} - ${cargo.phone}`;
                selectCargo.appendChild(option);
            });
        })
        .catch((error) => {
            console.error("Error al obtener la lista de cargos:", error);
        });
}


// Función para obtener la lista de empleados desde la API
function obtenerEmpleados() {
    fetch(API_URL_EMPLEADOS)
      .then((response) => response.json())
      .then((data) => {
        const listaEmpleados = document.getElementById("listaEmpleados");
        listaEmpleados.innerHTML = "";
        data.forEach((empleado) => {
          const cardEmpleado = `
                    <div class="card mb-2">
                        <header class="card-header">${empleado.name}</header>
                        <div class="card-content">
                            <div class="content">
                                <p>Apellido: ${empleado.lastName}</p>
                                <p>Fecha de Nacimiento: ${empleado.birthDate}</p>
                                <p>Teléfono: ${empleado.phone}</p>
                                <p>Cargo: ${
                                    empleado.management
                                        ? empleado.management.name
                                        : "Sin asignar"
                                }</p>
                            </div>
                        </div>
                    </div>
      
                  `;
          listaEmpleados.innerHTML += cardEmpleado;
        });
    })
    .catch((error) => {
    console.error("Error al obtener la lista de empleados:", error);
    });
}



// Función para obtener la lista de cargos disponibles desde la API
function obtenerCargos() {
    fetch(API_URL_CARGOS)
        .then((response) => response.json())
        .then((data) => {
            cargosDisponibles = data; // Almacenar los cargos disponibles
            const listaCargos = document.getElementById("listaCargos");
            listaCargos.innerHTML = "";
            data.forEach((cargo) => {
            const cardCargo = `
                        <div class="card mb-2" id="cargo-${cargo.idManagement}">
                            <header class="card-header">${cargo.name}</header>
                            <div class="card-content">
                                <div class="content">
                                    <p>Telefono: ${cargo.phone}</p>
                                </div>
                            </div>
                        </div>
                    `;
                    listaCargos.innerHTML += cardCargo;
            });
            cargarOpcionesCargos(); // Actualizar opciones de cargos en el formulario de clientes
        })
        .catch((error) => {
            console.error("Error al obtener la lista de cargos:", error);
        });
}



//CREAR
//-----------

// Función para crear un nuevo empleado
function crearEmpleado(event) {
    event.preventDefault();
    const empleadoData = {
      name: document.getElementById("empleadoNombre").value,
      lastName: document.getElementById("empleadoApellidos").value,
      birthDate: document.getElementById("empleadoNacimiento").value,
      phone: document.getElementById("empleadoTelefono").value,
      management: {
        idManagement: document.getElementById("empleadoCargo").value
      },
    };
  
    fetch(API_URL_EMPLEADOS, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(empleadoData),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("Empleado creado:", data);
        document.getElementById("formEmpleado").reset();
        obtenerEmpleados();
      })
      .catch((error) => {
        console.error("Error al crear el empleado:", error);
      });
  }

// Función para crear un nuevo cargo
function crearCargo(event) {
    event.preventDefault();
    const cargoData = {
      name: document.getElementById("cargoNombre").value,
      phone: document.getElementById("cargoTelefono").value,
    };
  
    fetch(API_URL_CARGOS, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(cargoData),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("Cargo creado:", data);
        document.getElementById("formCargo").reset();
        obtenerCargos(); // Actualizar la lista de cargos disponibles
      })
      .catch((error) => {
        console.error("Error al crear el cargo:", error);
      });
  }
  


  // Cargar opciones de cargos al cargar la página
cargarOpcionesCargos();

// Obtener la lista inicial de empleado y cargos al cargar la página
obtenerEmpleados();
obtenerCargos();


// Asignar manejadores de eventos a los formularios
document.getElementById("formEmpleado").addEventListener("submit", crearEmpleado);
document.getElementById("formCargo").addEventListener("submit", crearCargo);
