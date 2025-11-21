# Plataforma de Preparação de Entrevistas para Recrutadores

Projeto em Java + Spring Boot que fornece uma API RESTful para apoiar recrutadores na preparação de entrevistas. Implementa CRUDs para **Usuários** e **Trilhas** (mínimo solicitado).

## Tecnologias
- Java 21
- Spring Boot 3.2.x
- Spring Data JPA
- H2 (in-memory) para facilitar testes locais
- Bean Validation 

## Como executar
1. Tenha Java 21 instalado.
2. Na raiz do projeto, rode:
```bash
mvn clean package
mvn spring-boot:run
```
ou
```bash
./mvnw spring-boot:run
```
3. A API ficará disponível em `http://localhost:8080`.

### H2 Console
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:plataforma`
- User: `sa`
- Password: (vazio)

## Endpoints principais (exemplos)

### Usuários
- `GET /usuarios` — listar todos
- `GET /usuarios/{id}` — buscar por id
- `POST /usuarios` — criar
  ```json
  {
    "nome": "Joao Recrutador",
    "email": "joao@exemplo.com",
    "areaAtuacao": "RH",
    "nivelCarreira": "Pleno"
  }
  ```
- `PUT /usuarios/{id}` — atualizar (mesmo payload do POST)
- `DELETE /usuarios/{id}` — remover

### Trilhas
- `GET /trilhas`
- `GET /trilhas/{id}`
- `POST /trilhas`
  ```json
  {
    "nome": "Entrevistas Técnicas",
    "descricao": "Treinamento focado em avaliação técnica",
    "nivel": "INTERMEDIARIO",
    "cargaHoraria": 12,
    "focoPrincipal": "IA/Tech"
  }
  ```

## Validações e códigos HTTP
- Campos obrigatórios validados com Bean Validation.
- Erros de validação retornam `400 Bad Request` com detalhes por campo.
- Recurso não encontrado retorna `404 Not Found`.

## Seeds
O projeto insere automaticamente alguns registros iniciais via `CommandLineRunner` (usuários e trilhas).

## Observações
- O código está organizado em camadas: controller → service → repository.
- Para usar MySQL, altere `application.properties` com o `spring.datasource.url`, `username` e `password`, e mude a dependência do driver se necessário.
