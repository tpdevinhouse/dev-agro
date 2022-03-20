
# Dev Agro - API Restful

Seja muito bem-vindo(a) ao projeto prático de desenvolvimento de API Restful com Spring Boot e JPA.

Projeto avaliativo do Módulo 1 - Projeto 2, do DevInHouse (Senai), tumar Senior.

## Objetivo do Projeto

O projeto tem como objetivo, criar uma API Restful usando Spring Boot, para o desenvolvimento de uma API de gerenciamento de agricultura, onde é possivel, administrar a colheita de uma fazenda, cadastrar fazendas, cadastrar empresas e os funcionários pertencente a empresa.

## Stack utilizada


**Back-end:** Spring Boot 2.6.4 , JPA, Validation, Starter WEB e Postgres


## Instalação

Faça o clone deste repositório e instale no seu ambiente de desenvolvimento usando o seguinte comando no seu terminal (escolha um diretório apropriado):

```bash
  git clone https://github.com/tpdevinhouse/dev-agro.git
```

### Após clonar o repositório, abre a pasto projeto em sua IDE favorita e exetute o arquivo DevAgroApplication.
## Documentação da API

```http
  URL Default: http://localhost:8080/dev-agro
```

### Empresa

#### Cadastrar Empresa

```http
  POST /empresa
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nomeEmpresa` | `String` | **Obrigatório**. Nome da Empresa |
| `cnpjEmpresa` | `String` | **Obrigatório**. CNPJ da Empresa |
| `enderecoEmpresa` | `String` | **Obrigatório**. Endereço da Empresa |

#### Listar Todas as Empresas

```http
  GET /empresa
```

#### Listar Empresa por ID 

```http
  GET /empresa/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id` | `Long` | **Obrigatório**. O ID da Empresa que deseja pesquisar |


#### Deletar Empresa 

```http
  DELETE /empresa/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id` | `Long` | **Obrigatório**. O ID da Empresa que deseja deletar |


#### Atualizar Empresa

```http
  PATCH /empresa
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nomeEmpresa` | `String` | **Obrigatório**. Nome da Empresa |
| `cnpjEmpresa` | `String` | **Obrigatório**. CNPJ da Empresa |
| `enderecoEmpresa` | `String` | **Obrigatório**. Endereço da Empresa |


### Fazenda

#### Cadastrar Fazenda

```http
  POST /fazenda
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nomeFazenda` | `String` | **Obrigatório**. Nome da Fazenda |
| `enderecoFazenda` | `String` | **Obrigatório**. Endereço da Fazenda |
| `tipoGrao` | `idGrao` | **Opcional**. Informar o ID do Grão |
| `estoqueFazenda` | `Integer` | **Obrigatório**. Informar a qtde de Grão |
| `empresaProprietariaFazenda` | `idEmpresa` | **Opcional**. Informar o ID da Empresa |


#### Listar Todas as Fazendas

```http
  GET /fazenda
```

#### Listar Fazenda por ID 

```http
  GET /fazenda/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id` | `Long` | **Obrigatório**. O ID da Fazenda que deseja pesquisar |


#### Adicionar Estoque da Fazenda

```http
  GET /fazenda/estoque/adicionar/{id}?adicionarEstoque={valor}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id` | `Long` | **Obrigatório**. O ID da Fazenda que deseja pesquisar |
| `valor` | `Integer` | **Obrigatório**. Valor a ser adicionado ao estoque de Grãos |


#### Retirar Estoque da Fazenda

```http
  GET /fazenda/estoque/retirar/{id}?retirarEstoque={valor}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id` | `Long` | **Obrigatório**. O ID da Fazenda que deseja pesquisar |
| `valor` | `Integer` | **Obrigatório**. Valor a ser retirado do estoque de Grãos |


#### Deletar Fazenda 

```http
  DELETE /fazenda/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id` | `Long` | **Obrigatório**. O ID da Fazenda que deseja deletar |


#### Atualizar Fazenda

```http
  PATCH /fazenda
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nomeFazenda` | `String` | **Obrigatório**. Nome da Fazenda |
| `enderecoFazenda` | `String` | **Obrigatório**. Endereço da Fazenda |
| `tipoGrao` | `idGrao` | **Opcional**. Informar o ID do Grão |
| `estoqueFazenda` | `Integer` | **Obrigatório**. Informar a qtde de Grão |
| `empresaProprietariaFazenda` | `idEmpresa` | **Opcional**. Informar o ID da Empresa |


### Funcionários(as)

#### Cadastrar Funcionário(a)

```http
  POST /funcionario
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nomeFuncinario` | `String` | **Obrigatório**. Nome do Funcionário(a) |
| `cpfFuncionario` | `String` | **Obrigatório**. CPF do Funcionário(a) |
| `enderecoFuncionario` | `String` | **Obrigatório**. Endereço do Funcionário(a) |
| `telefoneFuncionario` | `String` | **Obrigatório**. Telefone do Funcionário(a) |
| `sexoFuncionario` | `String` | **Obrigatório**. Sexo do Funcionário(a), M -> Masc, F -> Fem, O -> Outros |
| `dataNascFuncionario` | `String` | **Obrigatório**. Data de Nasc. do Funcionário(a), Ex: dd/MM/yyyy |
| `dataContratacaoFuncionario` | `String` | **Obrigatório**. Data de Contr. do Funcionário(a), Ex: dd/MM/yyyy |
| `empresaFuncionario` | `idEmpresa` | **Opcional**. Informar o ID da Empresa que o funcionario(a) trabalha |


#### Listar Todas os(as) Funcionários(as)

```http
  GET /funcionario
```

#### Listar Funcionário(a) por ID 

```http
  GET /funcionario/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id` | `Long` | **Obrigatório**. O ID do Funcionário(a) que deseja pesquisar |


#### Deletar Funcionário(a) 

```http
  DELETE /funcionario/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id` | `Long` | **Obrigatório**. O ID do Funcionário(a) que deseja deletar |


#### Atualizar Funcionário(a)

```http
  PATCH /funcionario
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nomeFuncinario` | `String` | **Obrigatório**. Nome do Funcionário(a) |
| `cpfFuncionario` | `String` | **Obrigatório**. CPF do Funcionário(a) |
| `enderecoFuncionario` | `String` | **Obrigatório**. Endereço do Funcionário(a) |
| `telefoneFuncionario` | `String` | **Obrigatório**. Telefone do Funcionário(a) |
| `sexoFuncionario` | `String` | **Obrigatório**. Sexo do Funcionário(a), M -> Masc, F -> Fem, O -> Outros |
| `dataNascFuncionario` | `String` | **Obrigatório**. Data de Nasc. do Funcionário(a), Ex: dd/MM/yyyy |
| `dataContratacaoFuncionario` | `String` | **Obrigatório**. Data de Contr. do Funcionário(a), Ex: dd/MM/yyyy |
| `empresaFuncionario` | `idEmpresa` | **Opcional**. Informar o ID da Empresa que o funcionario(a) trabalha |


### Grãos

#### Cadastrar Grão

```http
  POST /grao
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nomeGrao` | `String` | **Obrigatório**. Nome do Grão |
| `empresaGrao` | `idEmpresa` | **Opcional**. Informar o ID da Empresa que o Grão pertence |
| `tempoMedioColheita` | `Integer` | **Obrigatório**. Tempo médio da colheita em dias |


#### Listar Todos os Grãos

```http
  GET /grao
```


#### Listar Grão por ID 

```http
  GET /grao/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id` | `Long` | **Obrigatório**. O ID da Grão que deseja pesquisar |



#### Deletar Grão 

```http
  DELETE /grao/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id` | `Long` | **Obrigatório**. O ID da Grão que deseja deletar |


#### Atualizar Grão

```http
  PATCH /grao
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nomeGrao` | `String` | **Obrigatório**. Nome do Grão |
| `empresaGrao` | `idEmpresa` | **Opcional**. Informar o ID da Empresa que o Grão pertence |
| `tempoMedioColheita` | `Integer` | **Obrigatório**. Tempo médio da colheita em dias |

## Requisições Preenchidas

 - [Todas as Requisições Postman](https://drive.google.com/drive/folders/1gyylVefcTIjULou89L4fLNaWAj2awt01?usp=sharing)

