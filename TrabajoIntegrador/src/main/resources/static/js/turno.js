window.addEventListener('load', function(){

// crear nuevo
    const guardar = document.querySelector('form');
    guardar.addEventListener('submit', function(e){
        e.preventDefault();
        // tomo los datos
        const id_odon=document.querySelector('#input2').value;
        const id_pac=document.querySelector('#input1').value;
        const reserva=document.querySelector('#input3').value;
        const turno=reserva.replaceAll("T"," ");
        const turno2=turno+":00";
        const formData = {
            "diaHora": turno2
        };
        console.log(formData)
        //configuro API
        const url = 'http://localhost:8080/turnos/'+id_pac+'/'+id_odon;
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
                    alert('Turno registrado');
                    return response.json();
                } else {
                    alert('Error al generar el registro');
                }
            })
            .then(data => {
                if (data) {
                    console.log(data);
                    let texto = document.querySelector('#datos');
                    texto.innerHTML=`Se reservó el turno con ID ${data.id}, con el odontologo ${data.odontologo.nombre} ${data.odontologo.apellido}, para el paciente ${data.paciente.nombre} ${data.paciente.nombre}. Fecha y hora: ${data.diaHora}`;
                    guardar.reset();
                }
            })
            .catch (error => {
                alert('Error: ', error);
                guardar.reset();
            })
    })
})