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



const servico =         {
            "descricao": "Instalação de pente de memória",
            "valor": 50.0,
            "tipo": {"id": 4 },
            "dataAutorizacao": "2022-12-27 21:36:06",
            "dataInicio": "2022-12-28 19:36:29",
            "dataConclusao": "2022-12-28 21:36:13",
            "equipamento": { "id": 1}
        }


const res = await fetch("http://localhost:8080/servico", {
            method: "POST",
             headers: {
                "Content-Type": "application/json",
				"Authorization" : "Bearer " + auth.token
            },
			body: JSON.stringify(servico)
        });

const servicoSalvo = await res.json();

console.log(auth);
console.log(servicoSalvo);