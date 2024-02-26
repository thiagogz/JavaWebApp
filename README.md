# Review Raid

API do projeto Review Raid - Rede social de Review de Jogos

## Requisitos

- [ ] CRUD de Categorias
- [ ] CRUD de Movimentações
- [ ] CRUD de Usuários
- [ ] Autenticação
- [ ] Dashboard

## Documentação

### Endpoints

- [Listar Categorias](#listar-categorias)
- [Cadastrar Categorias](#cadastrar-categoria)
- [Detalhes da Categoria](#detalhes-da-categoria)
- [Apagar Categoria](#apagar-categoria)
- [Atualizar Categoria](#atualizar-categoria)

### Listar Categorias

`GET` /categoria

Retorna um array com todas as categorias cadastradas.

#### Exemplo de Resposta
```js
[
    {
        "id": 1,
        "nome": "Aventura",
        "icone": "adventure"
    },
    {
        "id": 2,
        "nome": "Ação",
        "icone": "action"
    }
]
```

#### Código de Status
| código | descrição
|--------|----------
| 200 | Categorias retornadas com sucesso.
| 401 | Usuário não autenticado. Realizar autenticação em /login.


### Cadastrar Categoria

`POST` /categoria

Cadastrar uma nova categoria para o usuário logado com os dados enviados no corpo da requisição.

#### Corpo da Requisição

| campo | tipo | obrigatório | descrição
|-------|------|-------------|----------
| nome | string | ✅ | Nome curto para a categoria.
| icone | string | ❌ | O nome do ícone conforme Material Icons.

```js
{
    "nome": "Aventura",
    "icone": "adventure"
}
```

#### Exemplo de Resposta
```js
[
    {
        "id": 1,
        "nome": "Aventura",
        "icone": "adventure"
    },
    {
        "id": 2,
        "nome": "Ação",
        "icone": "action"
    }
]
```

#### Código de Status
| código | descrição
|--------|----------
| 201 | Categoria cadastrada com sucesso.
| 400 | Validação falhou. Verifique as regras para o corpo da requisição.
| 401 | Usuário não autenticado. Realizar autenticação em /login.

### Detalhes da Categoria

`GET` /categoria/{id}

Retorna os dados detalhados da categoria com o `id` informado no parâmetro de path.

#### Exemplo de Resposta
```js
// requisição para /categoria/1
{
    "id": 1,
    "nome": "Aventura",
    "icone": "adventure"
}
```

#### Código de Status
| código | descrição
|--------|----------
| 200 | Dados da categoria retornados com sucesso.
| 401 | Usuário não autenticado. Realizar autenticação em /login.
| 404 | Não existe categoria com o `id` informado. Consulte lista em /categoria.

### Apagar Categoria

`DELETE` /categoria/{id}

Apaga categoria indicada pelo `id` informado no parâmetro de path.

#### Código de Status
| código | descrição
|--------|----------
| 204 | Categoria apagada com sucesso.
| 401 | Usuário não autenticado. Realizar autenticação em /login.
| 404 | Não existe categoria com o `id` informado. Consulte lista em /categoria.

### Atualizar Categoria

`PUT` /categoria/{id}

Atualizar os dados da categoria com o `id` informado no parâmetro de path, utilizando os novos dados enviados no corpo da requisição.

#### Corpo da Requisição

| campo | tipo | obrigatório | descrição
|-------|------|-------------|----------
| nome | string | ✅ | Nome curto para a categoria.
| icone | string | ✅ | O nome do ícone conforme Material Icons.

```js
{
    "id": 1,
    "nome": "Aventura",
    "icone": "adventure"
}
```
#### Exemplo de Resposta

```js
{
    "id": 1,
    "nome": "Aventura",
    "icone": "adventure"
}
```

#### Código de Status
| código | descrição
|--------|----------
| 200 | Dados da categoria retornados com sucesso.
| 400 | Validação falhou. Verifique as regras para o corpo da requisição.
| 401 | Usuário não autenticado. Realizar autenticação em /login.
| 404 | Não existe categoria com o `id` informado. Consulte lista em /categoria.