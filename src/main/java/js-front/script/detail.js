const URLParams=new URLSearchParams(window.location.search);
const pizzaid=URLParams.get('id');

axios.get(`http://localhost:8080/api/${pizzaid}`).then((res) => {
    console.log('richiesta ok', res);
    //res.data è un Book 
    document.querySelector('#nome').innerHTML= res.data.name;
    document.querySelector('#prezzo').innerHTML= res.data.price;
    document.querySelector('#img').innerHTML= '<img src="' + res.data.photo + '" width=300px />';

    document.getElementById("home_page").innerHTML += `<a class="btn btn-danger" href="index.html">Torna in Homepage</a>`;
    
}).catch((res) => {
    console.error('errore nella richiesta', res);
    alert('Errore durante la richiesta!');
});

