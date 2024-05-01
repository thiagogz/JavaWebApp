# Review Raid

API do projeto Review Raid - Rede social de Review de Jogos

## Requisitos

- [x] CRUD de Jogos
- [ ] CRUD de Categorias
- [ ] CRUD de Usuários
- [ ] Autenticação
- [ ] Dashboard

## Documentação

### Endpoints

- [Listar Jogos](#listar-jogos)
- [Cadastrar Jogos](#cadastrar-jogo)
- [Detalhes do Jogo](#detalhes-do-jogo)
- [Apagar Jogo](#apagar-jogo)
- [Atualizar Jogo](#atualizar-jogo)

### Listar Jogos

`GET` /jogos

Retorna um array com todos os jogos cadastradas.

#### Exemplo de Resposta
```js
[
    {
        "id": 1,
        "name": "It Takes Two",
        "image": "ittakestwo.jpg",
        "description": "Jogue no papel do conflituoso casal Cody e May, dois humanos transformados em bonecos por um feitiço. Juntos, presos em um mundo fantástico onde o imprevisível está sempre à espreita, são obrigados a trabalhar para salvar seu relacionamento conturbado. Domine habilidades de personagem únicas e interligadas em cada nível. Ajude e receba ajuda em obstáculos inesperados e momentos divertidos.",
        "launch_date": "26/03/2021",
        "tags":["Aventura", "Co-Op", "Multijogador", "Plataforma"]
    },
    {
        "id": 2,
        "name": "God Of War",
        "image": "godofwar18.jpg",
        "description": "Muitos anos se passaram desde que Kratos teve sua vingança contra os deuses do Olimpo, e agora ele vive com seu filho Atreus em Midgard. O jogo começa após a morte da segunda esposa de Kratos e mãe de Atreus, Faye. Seu último desejo era que suas cinzas fossem espalhadas no pico mais alto dos nove reinos nórdicos. Antes de iniciar sua jornada, Kratos é confrontado por um homem misterioso com poderes divinos. Depois de aparentemente matá-lo, Kratos e Atreus partem em sua jornada.",
        "launch_date": "20/04/2018",
        "tags":["Ação", "Aventura", "Um Jogador", "RPG"]
    }
]
```

#### Código de Status
| código | descrição
|--------|----------
| 200 | Jogos retornadas com sucesso.
| 401 | Usuário não autenticado. Realizar autenticação em /login.


### Cadastrar Jogo

`POST` /jogos

Cadastrar um novo jogo para o usuário logado com os dados enviados no corpo da requisição.

#### Corpo da Requisição

| campo | tipo | obrigatório | descrição
|-------|------|:-----------:|----------
| name | string | ✅ | Nome do jogo.
| image | string | ✅ | Imagem do jogo.
| description | string | ✅ | Descrição do jogo.
| launch_date | string | ✅ | Data de lançamento do jogo.
| tags | list | ✅ | Tags para identificação das categorias do jogo.

```js
{
    "name": "It Takes Two",
    "image": "ittakestwo.jpg",
    "description": "Jogue no papel do conflituoso casal Cody e May, dois humanos transformados em bonecos por um feitiço. Juntos, presos em um mundo fantástico onde o imprevisível está sempre à espreita, são obrigados a trabalhar para salvar seu relacionamento conturbado. Domine habilidades de personagem únicas e interligadas em cada nível. Ajude e receba ajuda em obstáculos inesperados e momentos divertidos.",
    "launch_date": "26/03/2021",
    "tags":["Aventura", "Co-Op", "Multijogador", "Plataforma"]
}
```

#### Exemplo de Resposta
```js
[
    {
        "id": 1,
        "name": "It Takes Two",
        "image": "ittakestwo.jpg",
        "description": "Jogue no papel do conflituoso casal Cody e May, dois humanos transformados em bonecos por um feitiço. Juntos, presos em um mundo fantástico onde o imprevisível está sempre à espreita, são obrigados a trabalhar para salvar seu relacionamento conturbado. Domine habilidades de personagem únicas e interligadas em cada nível. Ajude e receba ajuda em obstáculos inesperados e momentos divertidos.",
        "launch_date": "26/03/2021",
        "tags":["Aventura", "Co-Op", "Multijogador", "Plataforma"]
    }
]
```

#### Código de Status
| código | descrição
|--------|----------
| 201 | Jogo cadastrado com sucesso.
| 400 | Validação falhou. Verifique as regras para o corpo da requisição.
| 401 | Usuário não autenticado. Realizar autenticação em /login.

### Detalhes do Jogo

`GET` /categoria/{id}

Retorna os dados detalhados do jogo com o `id` informado no parâmetro de path.

#### Exemplo de Resposta
```js
// requisição para /jogos/1
{
    "id": 1,
    "name": "It Takes Two",
    "image": "ittakestwo.jpg",
    "description": "Jogue no papel do conflituoso casal Cody e May, dois humanos transformados em bonecos por um feitiço. Juntos, presos em um mundo fantástico onde o imprevisível está sempre à espreita, são obrigados a trabalhar para salvar seu relacionamento conturbado. Domine habilidades de personagem únicas e interligadas em cada nível. Ajude e receba ajuda em obstáculos inesperados e momentos divertidos.",
    "launch_date": "26/03/2021",
    "tags":["Aventura", "Co-Op", "Multijogador", "Plataforma"]
}
```

#### Código de Status
| código | descrição
|--------|----------
| 200 | Dados do jogo retornados com sucesso.
| 401 | Usuário não autenticado. Realizar autenticação em /login.
| 404 | Não existe jogo com o `id` informado. Consulte lista em /jogos.

### Apagar Jogo

`DELETE` /jogos/{id}

Apaga jogo indicada pelo `id` informado no parâmetro de path.

#### Código de Status
| código | descrição
|--------|----------
| 204 | Jogo apagado com sucesso.
| 401 | Usuário não autenticado. Realizar autenticação em /login.
| 404 | Não existe jogo com o `id` informado. Consulte lista em /jogos.

### Atualizar Jogo

`PUT` /jogos/{id}

Atualizar os dados do jogo com o `id` informado no parâmetro de path, utilizando os novos dados enviados no corpo da requisição.

#### Corpo da Requisição

| campo | tipo | obrigatório | descrição
|-------|------|:-----------:|----------
| name | string | ❌ | Nome do jogo.
| image | string | ❌ | Imagem do jogo.
| description | string | ❌ | Descrição do jogo.
| launch_date | string | ❌ | Data de lançamento do jogo.
| tags | list | ❌ | Tags para identificação das categorias do jogo.

```js
{
    "name": "It Takes Two",
    "image": "ittakestwo.jpg",
    "description": "Jogue no papel do conflituoso casal Cody e May, dois humanos transformados em bonecos por um feitiço. Juntos, presos em um mundo fantástico onde o imprevisível está sempre à espreita, são obrigados a trabalhar para salvar seu relacionamento conturbado. Domine habilidades de personagem únicas e interligadas em cada nível. Ajude e receba ajuda em obstáculos inesperados e momentos divertidos.",
    "launch_date": "26/03/2021",
    "tags":["Aventura", "Co-Op", "Multijogador", "Plataforma"]
}
```
#### Exemplo de Resposta

```js
{
    "id": 1,
    "name": "It Takes Two",
    "image": "ittakestwo.jpg",
    "description": "Jogue no papel do conflituoso casal Cody e May, dois humanos transformados em bonecos por um feitiço. Juntos, presos em um mundo fantástico onde o imprevisível está sempre à espreita, são obrigados a trabalhar para salvar seu relacionamento conturbado. Domine habilidades de personagem únicas e interligadas em cada nível. Ajude e receba ajuda em obstáculos inesperados e momentos divertidos.",
    "launch_date": "26/03/2021",
    "tags":["Aventura", "Co-Op", "Multijogador", "Plataforma"]
}
```

#### Código de Status
| código | descrição
|--------|----------
| 200 | Dados do jogo retornados com sucesso.
| 400 | Validação falhou. Verifique as regras para o corpo da requisição.
| 401 | Usuário não autenticado. Realizar autenticação em /login.
| 404 | Não existe jogo com o `id` informado. Consulte lista em /jogos.

Link Swagger: http://localhost:8080/swagger-ui/index.html#/
Ligar a API antes.