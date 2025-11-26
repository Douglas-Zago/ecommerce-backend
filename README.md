🛒 E-Commerce — Backend (Spring Boot)

Este é o backend da aplicação de e-commerce, desenvolvido em Java 17 com Spring Boot e Maven.

A API fornece endpoints para:

Listagem de produtos

CRUD de produtos (área administrativa)

Criação de pedidos

🚀 Tecnologias Utilizadas

Java 17

Spring Boot 3

Spring Web

Spring Validation

Lombok

Maven

➡️ ✔ Spring Security + JWT (implementado)

➡️ ✔ Banco H2 em memória (ativo)

📁 Estrutura do Projeto
src/
 └── main/
     ├── java/com/example/ecommerce/
     │    ├── controller/    → Endpoints REST
     │    ├── dto/           → Objetos de transferência
     │    ├── model/         → Entidades e classes de domínio
     │    ├── service/       → Regras de negócio
     │    └── EcommerceApplication.java
     └── resources/
          ├── application.properties
          └── static / templates (se necessário)

``▶️ Como rodar o projeto``
Requisitos:

Java 17+

Maven

Executar

Na raiz do projeto:

mvn spring-boot:run


O servidor iniciará em:

👉 http://localhost:8080

``📌 Endpoints (versão inicial planejada)``
Produtos
GET    /products
GET    /products/{id}
POST   /products         (protegido)
PUT    /products/{id}    (protegido)
DELETE /products/{id}    (protegido)


Login
POST /auth/login   (público)



``🔗 Integração com o Frontend``

O frontend React acessará esta API utilizando:

VITE_API_URL=http://localhost:8080

``📦 Banco de Dados (H2)``

Este projeto utiliza H2 Database em memória para facilitar o desenvolvimento sem necessidade de instalar MySQL ou Postgres.

Console do H2:
👉 http://localhost:8080/h2

Credenciais:

JDBC URL: jdbc:h2:mem:ecommerce
User: sa
Password: (em branco)


A tabela product é criada automaticamente pelo Hibernate com base na entidade Product.

``🗄️ Persistência com Spring Data JPA``

O CRUD de produtos agora utiliza persistência real via:

Product mapeado como @Entity

ProductRepository estendendo JpaRepository

ProductService conectado ao banco H2

Nenhum dado é mockado.
Todos os produtos criados, atualizados ou removidos são manipulados diretamente no banco em memória.

``🔐 Segurança (JWT + Spring Security)``

O backend possui autenticação JWT, com rotas públicas e privadas.

Rota de login (pública):

POST /auth/login


Body:

{
  "username": "admin",
  "password": "admin"
}


Resposta contém o token JWT:

{
  "success": true,
  "token": "..."
}


``Como enviar o token:``

No header da requisição:

Authorization: Bearer <seu_token_aqui>

``🔒 Rotas Protegidas vs Públicas``
Públicas:
GET /products
GET /products/{id}
POST /auth/login

``Protegidas (necessitam JWT):``
POST /products
PUT /products/{id}
DELETE /products/{id}


``Requisições sem token ou com token inválido retornam:``

403 Forbidden (não autorizado)

401 Unauthorized caso implemente um AuthenticationEntryPoint mais tarde

``🧪 Exemplos de Teste (Thunder Client / Postman)``
Criar produto (precisa token)
POST /products


``Header:``

Authorization: Bearer <token>


``Body:``

{
  "name": "Produto Teste",
  "description": "Exemplo",
  "price": 99.9,
  "image": "imagem.jpg",
  "category": "geral",
  "stock": 5
}

Listar produtos
GET /products


Sem autenticação.

``🔗 Integração com o Frontend React``

A aplicação frontend deve usar:

VITE_API_URL=http://localhost:8080


Todas as requisições que modificam dados precisam enviar o token JWT no header.

``📄 Licença``

Projeto acadêmico / demonstrativo.

``Criado por Douglas Zago``
``https://github.com/Douglas-Zago``