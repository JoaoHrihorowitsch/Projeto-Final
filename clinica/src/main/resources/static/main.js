function buscarCep(){
    var cep = document.getElementById("inputCep").value;
    const url = "https://viacep.com.br/ws/" + cep + "/json/";

    fetch(url)
    .then(response => response.json())
    .then(dados => {

        if(dados.erro){
            alert("Cep inválido")
        } else{
            document.getElementById("inputAddress").value = dados.logradouro;
            document.getElementById("inputBairro").value = dados.bairro;
            document.getElementById("inputCity").value = dados.localidade;
            document.getElementById("inputState").value = dados.uf;
        }
    })
}



