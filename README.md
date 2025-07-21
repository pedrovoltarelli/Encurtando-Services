# Encurtando-Services
Encurtador de URL - Spring Boot + Java 21 + H2
Um encurtador de URL que transforma links longos em URLs curtas usando:

Java 21

Spring Boot 3

Banco H2 (em memória)

API REST (sem frontend)

🔧 Funcionalidades
✔ Encurta URLs → POST /api/shorten
✔ Redireciona → GET /{codigo}
✔ Estatísticas → GET /api/stats/{codigo}

⚙️ Tecnologias
Backend: Spring Boot 3, Spring Data JPA, Hibernate

Banco: H2 (acessível em http://localhost:8080/h2-console)

Geração de código: Base62 (ex: abc123)
