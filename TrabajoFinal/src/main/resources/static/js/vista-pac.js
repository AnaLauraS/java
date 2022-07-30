window.addEventListener('load', function(){

    actualizarListado();

    const botonAdmT = document.querySelector('#boton1');
    const botonAdmO = document.querySelector('#boton2');
    const botonNew = document.querySelector('#boton3');

    botonAdmT.addEventListener('click', function(){
        window.location.replace("./vista-turno.html");
    })
    botonAdmO.addEventListener('click', function(){
        window.location.replace("./vista-odon.html");
    })
    botonNew.addEventListener('click', function(){
        document.querySelector('#nuevo').setAttribute('style', 'display: inline');
        document.querySelector('#modificar').setAttribute('style', 'display: none');
    })

    // crear nuevo
    const guardar = document.querySelector('#formNew');
    guardar.addEventListener('submit', function(e){
        e.preventDefault();
        // tomo los datos
        const formData = {
            nombre: document.querySelector('#input3').value,
            apellido: document.querySelector('#input2').value,
            domicilio: document.querySelector('#input4').value,
            dni: document.querySelector('#input5').value,
            fechaAlta: document.querySelector('#input12').value
        };
        //configuro API
        const url = 'http://localhost:8080/pacientes/new';
        const settings = {
           method: 'POST',
           headers: {
               'Accept': 'application/json, text/plain',
               'Content-Type': 'application/json;charset=UTF-8'
                },
           body: JSON.stringify(formData)
        }
        console.log(settings)
        //llamo a la API
        fetch(url, settings)
            .then(response => {
                if (response.status == 200) {
                    alert('Paciente registrado');
                    return response.json();
                } else {
                    alert('Error al generar el registro');
                }
            })
            .then(data => {
                if (data) {
                    actualizarListado();
                    guardar.reset();
                }
            })
            .catch (error => {
                alert('Error: ', error);
                guardar.reset();
            })
    })

    // genero o actualizo los listados: 1.llamo API - 2.renderizo
    function actualizarListado(){
        const url = 'http://localhost:8080/pacientes';
        const conf = {
            method: 'GET',
        }
        const requerimiento = new Request(url, conf);
        fetch(requerimiento)
            .then(response => response.json())
            .then(data => {
                if (data) {
                    console.log(data)
                    renderizarListado(data);
                }
            });

    }


    function renderizarListado(data){
        let tabla = document.querySelector('#odonTableBody');
        tabla.innerHTML="";
        for(paciente of data){
            tabla.innerHTML+= `<td class="icono lapiz" data-id="${paciente.id}">✎</td>
            <td>${paciente.id}</td>
            <td>${paciente.nombre}</td>
            <td>${paciente.apellido}</td>
            <td>${paciente.domicilio}</td>
            <td>${paciente.dni}</td>
            <td>${paciente.fechaAlta}</td>
            <td class="icono tacho" data-eid="${paciente.id}">☒</td>
            <tr></tr>`
        }
    }


    document.querySelector("#odonTableBody").addEventListener('click',function(){
    habilitaModificar();
    habilitaEliminar();
    })

    function habilitaModificar(){
    // boton de modificar un registro
    var botonesCambio = document.querySelectorAll(".lapiz");
    botonesCambio.forEach(boton => {
        boton.addEventListener('click', function(event) {
        //for (var j in botonesCambio){
        //botonesCambio[j].addEventListener("click", function(event) {
        // obtengo el id del elemento clickeado con target
            const id = boton.dataset.id;
            console.log(id);
            const url = 'http://localhost:8080/pacientes/'+id;
            const settings = {
                method: 'GET'
            }
            fetch(url,settings)
                .then(response => response.json())
                .then(data => {
                    document.querySelector('#input6').value = id;
                    document.querySelector('#input7').value = data.nombre;
                    document.querySelector('#input8').value = data.apellido;
                    document.querySelector('#input9').value = data.domicilio;
                    document.querySelector('#input10').value = data.dni;
                    document.querySelector('#input11').value = data.fechaAlta;
                    //el formulario por default está oculto y al editar se habilita
                    document.querySelector('#nuevo').setAttribute('style', 'display: none');
                    document.querySelector('#modificar').setAttribute('style', 'display: inline');
                })
                .catch(error => {
                    alert("Error: " + error);
                })
            })
    })
    }

    // llamar a la api para guardar la modificacion del registro
    const guardar2 = document.querySelector('#formMod');
    guardar2.addEventListener('submit', function(e){
        e.preventDefault();
        // tomo los datos
        const formData = {
            id: document.querySelector('#input6').value,
            nombre: document.querySelector('#input7').value,
            apellido: document.querySelector('#input8').value,
            domicilio: document.querySelector('#input9').value,
            dni: document.querySelector('#input10').value,
            fechaAlta: document.querySelector('#input11').value
        };
        //configuro API
        const url = 'http://localhost:8080/pacientes/';
        const settings = {
           method: 'PUT',
           headers: {
               'Content-Type': 'application/json',
                },
           body: JSON.stringify(formData)
        }
        //llamo a la API
        fetch(url, settings)
            .then(response => {
                if (response.status == 200) {
                    alert('Paciente modificado');
                    return response.json();
                } else {
                    alert('Error al generar el registro');
                }
            })
            .then(data => {
                if (data) {
                    actualizarListado();
                    guardar2.reset();
                    document.querySelector('#nuevo').setAttribute('style', 'display: inline');
                    document.querySelector('#modificar').setAttribute('style', 'display: none');
                }
            })
            .catch (error => {
                alert('Error: ', error);
                guardar2.reset();
            })
    })

    function habilitaEliminar (){
    // boton de eliminar
    const botonesEliminar = document.querySelectorAll('.tacho');
    botonesEliminar.forEach(boton => {
        boton.addEventListener('click', function(event) {
        // obtengo el id del elemento clickeado con target
            const id = boton.dataset.eid;
            let decision = confirm('¿Seguro que desea eliminar el paciente de ID '+id+'?');
            if (decision){
                document.querySelector('#nuevo').setAttribute('style', 'display: inline');
                document.querySelector('#modificar').setAttribute('style', 'display: none');
                const url = 'http://localhost:8080/pacientes/'+ id;
                const settings = {
                    method: 'DELETE'
                }
                fetch(url,settings)
                    .then(response => {
                        if (response.status == 204) {
                            alert ("Eliminado con éxito");
                            actualizarListado();
                        }
                    })
                    .catch(error => {
                        alert('Error: ', error);
                    })
            }
        })
    })
    }
})