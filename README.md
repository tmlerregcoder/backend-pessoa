
<div align="center">
  <img src="https://spring.io/img/spring.svg" alt="Spring Boot" width="100" heigth="103">
  <img src="https://www.postgresql.org/media/img/about/press/elephant.png" alt="PostgreSQL" width="100">
  <h1>🚀 Backend Spring Boot & PostgreSQL 🐘</h1>
  <p>Um backend robusto e eficiente construído com Spring Boot, projetado para interagir perfeitamente com o banco de dados PostgreSQL.</p>
</div>
<div align="center">
Feito com ❤️ por Thiago Marques Simões no Rio de Janeiro 🇧🇷
</div>

---

## ✨ Destaques do Projeto

* **Desenvolvido com Spring Boot:** Aproveitando a potência e a convenção do framework Spring para um desenvolvimento rápido e escalável.
* **Focado em PostgreSQL:** Otimizado para trabalhar de forma eficiente com o banco de dados PostgreSQL.
* **Estrutura Clara:** Organização do código para facilitar a manutenção e a extensão de funcionalidades.
* **API RESTful:** Exposição de endpoints bem definidos para comunicação com o frontend.
* **Configuração Simplificada:** Utilização do Spring Boot para uma configuração rápida e fácil.

---

## 🛠️ Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

* **Java Development Kit (JDK):** Versão 17 ou superior recomendada.
    * [Download JDK](https://openjdk.java.net/install/)
* **Maven:** Gerenciador de dependências e ferramenta de build do projeto.
    * [Download Maven](https://maven.apache.org/download.cgi)
* **PostgreSQL:** Servidor de banco de dados PostgreSQL instalado e em execução.
    * [Download PostgreSQL](https://www.postgresql.org/download/)
* **IDE (Opcional, mas recomendado):** IntelliJ IDEA, Eclipse, VS Code com extensões Java.

---

## ⚙️ Configuração do Banco de Dados

Este backend foi desenvolvido para funcionar com o PostgreSQL, utilizando um banco de dados específico chamado `desafio` e uma tabela principal chamada `pessoas`.

### Criação do Banco de Dados

Se o banco de dados `desafio` ainda não existir, você pode criá-lo utilizando um cliente PostgreSQL (como `psql` ou pgAdmin):

```sql
CREATE DATABASE desafio;
CREATE TABLE pessoas (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    sexo VARCHAR(1) CHECK (sexo IN ('M', 'F')),
    cpf VARCHAR(14) UNIQUE,
    altura DECIMAL(3, 2),
    peso DECIMAL(5, 2),
    data_nasc DATE
);

```
▶️ Como Rodar o Projeto
Siga estas etapas para executar o backend Spring Boot:

Clone o Repositório (se ainda não o fez):

Bash

git clone <URL_DO_SEU_REPOSITORIO>
cd nome-do-projeto-backend
Certifique-se de que o PostgreSQL esteja em execução e que o banco de dados desafio e a tabela pessoas estejam criados e configurados conforme descrito na seção anterior.

Execute o Backend com Maven:
Abra um terminal na raiz do diretório do projeto e execute o seguinte comando:

Bash

mvn spring-boot:run
O Spring Boot iniciará o servidor backend. Você poderá ver logs no console indicando o processo de inicialização e a porta em que a aplicação está rodando (geralmente 8080).

Acesse a API:
Após a inicialização bem-sucedida, você poderá acessar os endpoints da API RESTful do seu backend utilizando um cliente HTTP (como curl, Postman, Insomnia). Por exemplo, se você tiver um endpoint para listar todas as pessoas em /api/pessoas, você poderia acessá-lo via GET:

Bash

curl http://localhost:8080/api/pessoas
Ou utilizando um cliente gráfico como o Postman.

