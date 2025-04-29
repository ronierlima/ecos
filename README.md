# ECOS Modeling 3.0

## 📋 Sobre o Projeto

O ECOS Modeling 3.0 é uma plataforma avançada para modelagem e compartilhamento de modelos desenvolvidos pela comunidade de ECOS. Esta ferramenta visa facilitar a colaboração entre pesquisadores, promovendo a disseminação e o crescimento da área através do compartilhamento de conhecimento e modelos.

## ✨ Principais Funcionalidades

- **Modelagem de ECOS**: Criação e desenvolvimento de modelos (herdado da versão 1.0)
- **Repositório de Modelos**: Plataforma centralizada para armazenamento e compartilhamento de modelos
- **Colaboração**: Sistema que permite a comunidade contribuir e expandir a base de conhecimento
- **Consultas**: Interface para pesquisa e análise de modelos existentes
- **Educação**: Recursos para compreensão da importância da modelagem adequada

## 🚀 Tecnologias Utilizadas

- **Backend**:
  - Java 17
  - Spring Boot 2.4.0
  - Spring Security
  - Spring Data JPA
  - PostgreSQL 15
  - MinIO (armazenamento de objetos)
  - JasperReports 6.19.1
  - ModelMapper 2.3.0

- **Ferramentas de Desenvolvimento**:
  - Maven
  - Docker
  - Docker Compose 3.7

## 🛠️ Configuração do Ambiente

### Pré-requisitos

- Java 17
- Maven 3.8+
- Docker e Docker Compose
- PostgreSQL 15 (opcional, já incluído no Docker Compose)

### Instalação

1. Clone o repositório:
```bash
git clone [URL_DO_REPOSITÓRIO]
```

2. Construa o projeto:
```bash
mvn clean install
```

3. Inicie os serviços com Docker Compose:
```bash
docker-compose up -d
```

A aplicação estará disponível em:
- API: http://localhost:8080
- MinIO Console: http://localhost:9001
- PostgreSQL: localhost:5432

## 📚 Estrutura do Projeto

```
src/
├── main/
│   ├── java/          # Código fonte Java
│   └── resources/     # Recursos da aplicação
```

## 🔐 Segurança

- Autenticação OAuth2
- Spring Security
- JWT (JSON Web Tokens)

## 📊 Armazenamento

- MinIO para armazenamento de objetos (http://localhost:9000)
- PostgreSQL 15 para dados estruturados

## 🔧 Variáveis de Ambiente

As principais variáveis de ambiente configuradas no Docker Compose:

- **PostgreSQL**:
  - Database: ecos_db
  - Username: ecos_user
  - Password: ecos_password

- **MinIO**:
  - Access Key: ecos_user
  - Secret Key: ecos_password
  - Console: http://localhost:9001
  - API: http://localhost:9000
