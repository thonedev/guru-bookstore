# Guru Bookstore

Este projeto faz parte do **Bootcamp Bradesco - Java Cloud Native** da [DIO (Digital Innovation One)](https://www.dio.me). O objetivo é criar uma aplicação MVC e fazer o deploy.

Este projeto é uma aplicação web desenvolvida como parte de um estudo prático de tecnologias modernas de desenvolvimento backend com Java e Spring Boot. O objetivo é criar uma livraria online simples, permitindo listar e adicionar livros ao banco de dados a partir de consultas à API do Google Books, utilizando boas práticas de arquitetura e integração com banco de dados relacional.

## 📁 Descrição do Projeto

O "Guru Bookstore" é uma aplicação web que gerencia uma lista de livros. Os usuários podem visualizar uma tabela com os livros cadastrados (ID, título e editora) e adicionar novos livros informando o ISBN, que é usado para buscar informações na API do Google Books. Os dados são persistidos em um banco PostgreSQL em produção ou H2 em ambiente de desenvolvimento.

Funcionalidades:
- Cadastro de livros com dados provenientes da API do Google Books, utilizando ISBN.
- Listagem dos livros cadastrados.
- Gerenciamento de autores e editoras.
- Persistência de dados com PostgreSQL.

## 🚀 Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3.4.3**
- **Spring Data JPA com Hibernate**
- **PostgreSQL 16 (produção) e H2 (desenvolvimento/testes)**
- **Docker e Docker Compose para conteinerização**
- **Thymeleaf para renderização de templates HTML**
- **Gradle como gerenciador de dependências**
- **GitHub Actions** para CI/CD
- **OkHttp** e **Gson** para consumo de API

## 🔬 Requisitos
- Java 21 ou superior
- Docker e Docker Compose (para execução em contêineres)
- Gradle instalado (ou utilizar o wrapper)
- Conta no DockerHub (opcional, para deploy)
- IDE recomendadea: IntelliJ IDEA, VS Code ou Eclipse

## 📅 Configuração e Execução

### 1. Clonar o Repositório
```bash
git clone https://github.com/thonedev/guru-bookstore.git
cd guru-bookstore
```

### 2. Configuração e Execução
Os perfis `dev` (H2 em memória) e `prod` (PostgreSQL) estão configurados. Para o ambiente de produção:
```bash
docker-compose up -d
```

### 3. Para rodar sem Docker (necessário PostgreSQL local):

* Configure um banco PostgreSQL com as credenciais do *application-prod.yml*:
  * Nome do banco: guru_bookstore_db
  * Usuário: postgres
  * Senha: My1SecretPass

* Execute o build e inicie a aplicação:

```bash
./gradlew clean build
./gradlew bootRun --args='--spring.profiles.active=prod'
```
Ou para o ambiente de desenvolvimento (H2):
```bash
./gradlew bootRun --args='--spring.profiles.active=dev'
```

### 4. Acessar a Aplicação
- **Frontend:** [http://localhost:8080/books](http://localhost:8080/books)
- **H2 Console (dev):** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

## 🔧 Endpoints Principais
- `GET /books`: Lista todos os livros.
- `POST /books`: Cadastra um novo livro pelo ISBN.

## 📚 Exemplo de Uso
1. Acesse `/books`.
2. Informe o ISBN no formulário e clique em "Salvar" (ex.: *"9781457501197", "9780201633610", "9780132350884", "9780321834577"*)
3. O livro será adicionado à lista.

## 💡 CI/CD com GitHub Actions e [Railway](https://railway.com/)
O pipeline está configurado para:
- Build da aplicação.
- Criação e push da imagem Docker para o DockerHub.
- Tag automática baseada na versão do commit.


- A aplicação foi implantada no [Railway](https://railway.com/), uma plataforma de hospedagem que simplifica o deploy de aplicações conteinerizadas. A URL pública da aplicação é https://guru-bookstore-production.up.railway.app. A rota principal /books está disponível em https://guru-bookstore-production.up.railway.app/books, onde você pode visualizar a lista de livros e adicionar novos títulos via ISBN. O deploy no Railway utiliza uma instância PostgreSQL gerenciada, configurada automaticamente com as variáveis de ambiente definidas no perfil prod (application-prod.yml).



## 🎯 Objetivos de Aprendizado

* Configurar e utilizar Spring Boot com JPA e Hibernate
* Integrar APIs externas (Google Books) com Java
* Implementar um CRUD básico com Spring MVC e Thymeleaf
* Configurar ambientes distintos (dev/prod) com profiles do Spring
* Automatizar builds e deploy com Gradle e GitHub Actions
* Conteinerizar aplicações com Docker



## 🏆 Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.

---

Feito com ❤️ por [Thone Cardoso](https://github.com/thonecardoso) para fins educacionais.

