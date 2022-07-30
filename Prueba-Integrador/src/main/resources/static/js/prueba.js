window.addEventListener('load', function(){
document.querySelector('#b1').addEventListener('click', function(){
fetch('http://localhost:8080/odontologos', {method: 'GET'})
.then(response => response.json)
.then(data => {
                if (data) {
                    console.log(data)
                    }
})
})
})