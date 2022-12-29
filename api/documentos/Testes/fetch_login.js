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

console.log(auth);