
elencoPizze();

function elencoPizze(){
    axios.get('http://localhost:8080/api').then((res) =>{
        // codice da eseguire
        console.log("richiesta ok", res);
        document.querySelector('#pizzeria').innerHTML= '';
        res.data.forEach(element => {
            console.log(element);
            document.querySelector('#pizzeria').innerHTML+= `
            <tr class="table-dark">
                
                <td>

                    <a href="./detail.html?id=${element.id}">${element.id}</a>
                
                </td>

                <td> ${element.name} </td>
                <td> ${element.price} </td>

                <td> 
                    <a class="btn btn-primary" onclick="deletePizza(${element.id})">Elimina</a>
                </td>

                <td> 
                <a class="btn btn-primary" href="./edit.html?id=${element.id}">Modfica</a>
                </td>

                <td>                                            
                    <a class="btn btn-primary" href="./detail.html?id=${element.id}">Visualizza</a>
                </td>     

            </tr>
            
            `
        });
    }) .catch((res) => {
        // codice da eseguire in caso di errori
        console.log("errore", res);
        alert('ERRORE');
    })
}

function deletePizza(id){
    const risposta=confirm('sei sicuro di voler eliminare?');

    if(risposta){
        axios.delete('http://localhost:8080/api/delete/'+ id).then((res) =>{
            elencoPizze();
        }).catch((res) => {
            console.log("ELEMENTO IMPOSSIBILE DA ELIMINARE!");
        })
    }
}