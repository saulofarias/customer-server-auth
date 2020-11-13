# Customer Server API + JWT

## Api Rest para cadastro e consulta de clientes.

### Requitos

- Java 8
- Spring Boot
- PostgresSQL
- Docker

### Funcionamento

A API deve cadastrar clientes e realizar operações básicas de um CRUD.

### Operações suportadas

- Cadastrar Usuário
- Realizar Login
- Cadastrar cliente
- Consultar cliente pelo Id
- Remover cliente
- Editar cliente

### Endpoints

#### Auth

- POST /register

    - Realizamos um cadastro de usuário para podermos acessar o sistema, devemos informa o nome, email e senha conforme exemplo.
    - A resposta deve conter os seguintes códigos:

      - 200: em caso de sucesso
      - 500: em caso de falha

_Exemplo: uri/register

_request:_

```json
{
	"name": "Teste",
	"email" : "teste@gmail.com.br",
	"password" : "1234"	
}
```

_response:_

```json
{
	"name": "Teste",
	"email" : "teste@gmail.com.br",
	"password" : "1234"	
}
```

- POST /authenticate

    - Informamos um email e senha previamente cadastrados para recebermos um token.
    - Retorna um jwt-token para ser usado nas demais requisições realizadas.
    - A resposta deve conter os seguintes códigos:

      - 200: em caso de sucesso
      - 401: em caso de falha

_Exemplo: uri/authenticate_

_request:_

```json
{
	"username" : "teste@gmail.com",
	"password" : "1234"
}
```

_response:_

```json
{
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYXVsb2Zhcmlhc2xpdmVAZ21haWwuY29tIiwiZXhwIjoxNjA1MzE1MDY1LCJpYXQiOjE2MDUyOTcwNjV9.h7NWHegURC0zIfIp9cZIMeSTtSQSQk0RWu0_AmnK1f7TEzSqdtrc5uGxsoGGxBcbBNig81F08VZ6_KkMgoFXUQ"
}
```



#### Customers

- GET / customers

  - Retorna todos os clientes cadastrados na base de dados.
  - A resposta deve conter os seguintes códigos:

    - 200: em caso de sucesso
    - 404: se o registro não for localizado

_Exemplo: uri/customers_

_response:_

```json
[
  {
    "cpf": "1111111111",
    "rg": "22222",
    "name": "Severino Saulo",
    "customerAddress": {
      "id": 3,
      "street": "Rua Sete de Setembro",
      "number": "1",
      "city": "Janaúba",
      "district": "Boa Vista",
      "complement": null,
      "state": "MG",
      "zipCode": "39444074",
      "country": "Brasil"
    },
    "contacts": [
      {
        "id": 5,
        "type": "telefone",
        "number": "8122222"
      },
      {
        "id": 6,
        "type": "celular",
        "number": "233123123"
      }
    ]
  },
  {
    "cpf": "1113232321",
    "rg": "222",
    "name": "teste",
    "customerAddress": {
      "id": 4,
      "street": "Rua Sete de Setembro",
      "number": "111",
      "city": "teste",
      "district": "Boa Vista",
      "complement": null,
      "state": "MG",
      "zipCode": "1111111",
      "country": "Janaúba"
    },
    "contacts": []
  }
]
```

- GET / customers/{id}

  - Retorna um cliente pelo ID informado
  - A resposta deve conter os seguintes códigos:

    - 200: em caso de sucesso
    - 404: se o registro não for localizado

_Exemplo: uri/cutomers/1111111111_

_response:_

```json
{
  "cpf": "1111111111",
  "rg": "22222",
  "name": "Severino Saulo",
  "customerAddress": {
    "id": 3,
    "street": "Rua Sete de Setembro",
    "number": "1",
    "city": "Janaúba",
    "district": "Boa Vista",
    "complement": null,
    "state": "MG",
    "zipCode": "39444074",
    "country": "Brasil"
  },
  "contacts": [
    {
      "id": 5,
      "type": "telefone",
      "number": "8122222"
    },
    {
      "id": 6,
      "type": "celular",
      "number": "233123123"
    }
  ]
}
```

- POST / customers

  - Cria um novo cliente
  - A resposta deve conter os seguintes códigos:

    - 201: em caso de sucesso

_Exemplo: uri/cutomers_


request:_

```json
{
  "cpf": "1111111111",
  "rg": "22222",
  "name": "Severino Saulo",
  "customerAddress": {
    "street": "Rua Sete de Setembro",
    "number": "1",
    "city": "Janaúba",
    "district": "Boa Vista",
    "complement": null,
    "state": "MG",
    "zipCode": "39444074",
    "country": "Brasil"
  },
  "contacts": [
    {
      "type": "telefone",
      "number": "8122222"
    },
    {
      "type": "celular",
      "number": "233123123"
    }
  ]
}
```

_response:_

```json
{
  "cpf": "1111111111",
  "rg": "22222",
  "name": "Severino Saulo",
  "customerAddress": {
    "id": 3,
    "street": "Rua Sete de Setembro",
    "number": "1",
    "city": "Janaúba",
    "district": "Boa Vista",
    "complement": null,
    "state": "MG",
    "zipCode": "39444074",
    "country": "Brasil"
  },
  "contacts": [
    {
      "id": 5,
      "type": "telefone",
      "number": "8122222"
    },
    {
      "id": 6,
      "type": "celular",
      "number": "233123123"
    }
  ]
}
```

- PUT / customers/{id}

  - Atualiza um cliente
  - A resposta deve conter os seguintes códigos:

    - 201: em caso de sucesso
    - 404: se o registro não for localizado

_Exemplo: uri/cutomers/1111111111_


* DELETE / customers/{id}
  * Remove um cliente
  * A resposta deve conter os seguintes códigos:

    * 204: em caso de sucesso
    * 404: se o registro não for localizado

_Exemplo: uri/cutomers/1111111111_


## Testes

## Execução

Por padrão, a API está disponível em [http: // localhost: 8080 /] (http: // localhost: 8080 /)

Para executar a API, podemos usar os seguintes métodos:

_cd target && java -jar customer-server-0.0.1-SNAPSHOT.jar_

ou com o seguinte comando

_mvn spring-boot: run_

## Docker

A API está configurada para ser usada com o Docker, para tal devemos seguir os seguintes passos:

* Primeiro devemos construir o executável de nossa aplicação com o seguinte comando: _mvn clean package_

* Devemos rodar o seguinte comando: _docker-compose up --build_

Se tudo ocorrer bem podemos acessar os recursos da API normalmente como mostrado no tópico Endpoints.
```
