🛒 E-Commerce — Backend (Spring Boot)

Este é o backend da aplicação de e-commerce, desenvolvido em Java 17 com Spring Boot e Maven.

A API fornece endpoints para:

Listagem de produtos

Login/autenticação (simulação ou JWT, dependendo do escopo)

CRUD de produtos (área administrativa)

Criação de pedidos

Integração futura com o front-end React

🚀 Tecnologias Utilizadas

Java 17

Spring Boot 3

Spring Web

Spring Validation

Lombok

Maven

(Opcional) Spring Security + JWT

(Opcional) Banco relacional ou armazenamento em memória

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

▶️ Como rodar o projeto
Requisitos

Java 17+

Maven

Executar

Na raiz do projeto:

mvn spring-boot:run


O servidor iniciará em:

👉 http://localhost:8080

📌 Endpoints (versão inicial planejada)
Produtos
GET    /products
GET    /products/{id}
POST   /admin/products
PUT    /admin/products/{id}
DELETE /admin/products/{id}

Login
POST /login

Pedidos
POST /orders

🔗 Integração com o Frontend

O frontend React acessará esta API utilizando:

VITE_API_URL=http://localhost:8080

📄 Licença

Projeto acadêmico / demonstrativo.

Criado por Douglas Zago
https://github.com/Douglas-Zago