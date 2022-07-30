window.addEventListener('load', function(){

    actualizarListado();

    const botonAdmT = document.querySelector('#boton1');
    const botonAdmP = document.querySelector('#boton2');
    const botonNew = document.querySelector('#boton3');

    botonAdmT.addEventListener('click', function(){
        window.location.replace("./vista-turno.html");
    })
    botonAdmP.addEventListener('click', function(){
        window.location.replace("./vista-pac.html");
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
            apellido: document.querySelector('#input3').value,
            nombre: document.querySelector('#input2').value,
            matricula: document.querySelector('#input4').value
        };
        //configuro API
        const url = 'http://localhost:8080/odontologos/new';
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
                    alert('Odontólogo registrado');
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
        const url = 'http://localhost:8080/odontologos';
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
        for(odontologo of data){
            tabla.innerHTML+= `<td class="icono lapiz" data-id="${odontologo.id}">✎</td>
            <td>${odontologo.id}</td>
            <td>${odontologo.nombre}</td>
            <td>${odontologo.apellido}</td>
            <td>${odontologo.matricula}</td>
            <td class="icono tacho" data-eid="${odontologo.id}">☒</td>
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
        // obtengo el id del elemento clickeado con target
            const id = boton.dataset.id;
            console.log(id);
            const url = 'http://localhost:8080/odontologos/'+id;
            const settings = {
                method: 'GET'
            }
            fetch(url,settings)
                .then(response => response.json())
                .then(data => {
                    document.querySelector('#input5').value = id;
                    document.querySelector('#input6').value = data.nombre;
                    document.querySelector('#input7').value = data.apellido;
                    document.querySelector('#input8').value = data.matricula;
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
            id: document.querySelector('#input5').value,
            apellido: document.querySelector('#input7').value,
            nombre: document.querySelector('#input6').value,
            matricula: document.querySelector('#input8').value
        };
        //configuro API
        const url = 'http://localhost:8080/odontologos/';
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
                    alert('Odontólogo modificado');
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
            let decision = confirm('¿Seguro que desea eliminar el odontólogo de ID '+id+'?');
            if (decision){
                document.querySelector('#nuevo').setAttribute('style', 'display: inline');
                document.querySelector('#modificar').setAttribute('style', 'display: none');
                const url = 'http://localhost:8080/odontologos/'+ id;
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