# Documentação Swagger da API

- http://127.0.0.1:8080/swagger-ui/index.html

# Banco de Dados

- As tabelas são criadas automaticamente(e inserido os clientes 1 até 10) pelo Flyway, ao iniciar a aplicação. Os
  scripts estão na pasta *src/main/resources/db/migration/*
- A configuração do banco de dados está no arquivo *src/main/resources/application.properties*

## API Reference

#### Cadastro Pedidos JSON

```http
  POST /api/pedidos
  Content-Type: application/json
```

```json
[
  {
    "dataCadastro": "2024-01-01",
    "nome": "nome",
    "valorUnitario": 10.0,
    "quantidade": 10,
    "codigoCliente": 1,
    "numeroControle": 10
  }
]
```

| Parameter        | Type      | Description                                        |
|:-----------------|:----------|:---------------------------------------------------|
| `nome`           | `string`  | **Required**. Nome do produto                      |
| `valorUnitario`  | `decimal` | **Required**. Valor monetário unitário do produto  |
| `codigoCliente`  | `integer` | **Required**. Código do cliente                    |
| `numeroControle` | `integer` | **Required**. Número de Controle                   |
| `quantidade`     | `integer` | Quantidade de produtos. Default: 1                 |
| `dataCadastro`   | `date`    | Data de Cadastro (yyyy-mm-dd). Default: data atual |

#### Cadastro Pedidos XML

```http
  POST /api/pedidos
  Content-Type: application/xml
```

```xml

<pedidos>
    <pedido>
        <dataCadastro>2024-01-01</dataCadastro>
        <nome>nome</nome>
        <valorUnitario>10.0</valorUnitario>
        <quantidade>10</quantidade>
        <codigoCliente>1</codigoCliente>
        <numeroControle>10</numeroControle>
    </pedido>
</pedidos>
```

| Parameter        | Type      | Description                                        |
|:-----------------|:----------|:---------------------------------------------------|
| `nome`           | `string`  | **Required**. Nome do produto                      |
| `valorUnitario`  | `decimal` | **Required**. Valor monetário unitário do produto  |
| `codigoCliente`  | `integer` | **Required**. Código do cliente                    |
| `numeroControle` | `integer` | **Required**. Número de Controle                   |
| `quantidade`     | `integer` | Quantidade de produtos. Default: 1                 |
| `dataCadastro`   | `date`    | Data de Cadastro (yyyy-mm-dd). Default: data atual |

#### Obtenção dos Pedidos

Request:

```http
  GET /api/pedidos
```

| Parameter      | Type      | Description                    |
|:---------------|:----------|:-------------------------------|
| `numeroPedido` | `integer` | Id do Pedido                   |
| `dataCadastro` | `date`    | Data de Cadastro (yyyy-mm-dd). |

Reponse:

```json
[
  {
    "id": 123,
    "dataCadastro": "2024-01-01",
    "nome": "nome",
    "valorUnitario": 10.0,
    "quantidade": 10,
    "codigoCliente": 1,
    "numeroControle": 10
  }
]
```

| Parameter        | Type      | Description                         |
|:-----------------|:----------|:------------------------------------|
| `id`             | `integer` | Id do Pedido                        |
| `nome`           | `string`  | Nome do produto                     |
| `valorUnitario`  | `decimal` | Valor monetário unitário do produto |
| `codigoCliente`  | `integer` | Código do cliente                   |
| `numeroControle` | `integer` | Número de Controle                  |
| `quantidade`     | `integer` | Quantidade de produtos.             |
| `dataCadastro`   | `date`    | Data de Cadastro (yyyy-mm-dd).      |

