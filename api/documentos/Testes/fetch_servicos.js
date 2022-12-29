 const user = {
     "username" : "root@hatecnica.com.br",
     "password" : "root"
};

const autenticacao = await fetch("http://localhost:8080/login", {
            method: "POST",
             headers: {
                "Content-Type": "application/json"
            },
			body: JSON.stringify(user)
        });

const auth = await autenticacao.json();

 

const res = await fetch("http://localhost:8080/servico", {
            method: "GET",
             headers: {
                "Content-Type": "application/json",
				"Authorization" : "Bearer " + auth.token
            }
        });

const servicos = await res.json();

console.log(auth);
console.log(servicos);

if(servicos.content.length>0){
	console.table(servicos.content)
}




