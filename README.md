# Serviço de Envio de Email - Exemplo para Iniciantes

![Java](https://img.shields.io/badge/Java-17-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen.svg)
![Maven](https://img.shields.io/badge/Maven-3.x-blue.svg)

Um projeto simples para demonstrar o desenvolvimento de um serviço back-end com Java Spring Boot. Este exemplo é ideal para quem está começando com o ecossistema Spring e deseja entender como criar uma API básica para envio de emails.

## 📋 Sobre o Projeto

Este é um exemplo educacional de uma API REST para envio de emails usando Spring Boot. O projeto foi criado para demonstrar:

- Estrutura básica de um projeto Spring Boot
- Criação de API REST com controladores (controllers)
- Validação de dados de entrada
- Serviço de envio de email com JavaMailSender
- Configuração via application.properties

Este é apenas um back-end (sem interface gráfica), projetado para ser consumido por outras aplicações via chamadas HTTP.

## 🛠️ Tecnologias Utilizadas

- **Java 17**: Linguagem de programação
- **Spring Boot**: Framework para criação de aplicações Java
- **Spring Web**: Para criar a API REST
- **Spring Mail**: Para funcionalidade de envio de emails
- **Maven**: Gerenciamento de dependências e construção do projeto
- **Jakarta Validation**: Para validação de dados

## 🚀 Primeiros Passos

### Pré-requisitos

- JDK 17+
- Maven 3.6+
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code, etc.)
- Conta de email para teste (ou servidor SMTP)

### Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/isaacnngt/exemplo-servico-email.git
   cd exemplo-servico-email
2. Configure o arquivo `application.properties` com suas credenciais de email:
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=seu-email@gmail.com
spring.mail.password=sua-senha-ou-app-password

3. Execute o projeto:
mvn spring-boot

4. A API estará disponível em `http://localhost:8080`

## 📝 API Endpoints

O serviço disponibiliza um único endpoint para envio de emails:

### Enviar Email
POST /api/email/send

**Exemplo de Requisição:**
{
"description": "Este é um email de teste",
"recipient": "destinatario@exemplo.com",
"subject": "Assunto do Email"
}

**Exemplo de Resposta:**
E-mail enviado com sucesso!

## ℹ️ Conceitos Demonstrados

- **REST API**: Demonstração de uma API RESTful com Spring MVC
- **DTO (Data Transfer Object)**: Objetos para transferência de dados entre camadas
- **Dependency Injection**: Uso de injeção de dependências do Spring
- **Service Layer**: Separação da lógica de negócio em serviços
- **Application Properties**: Configuração via arquivos de propriedades

## 🔍 Para Quem é Este Projeto?

Este exemplo é ideal para:

- Estudantes de Java iniciando com Spring Boot
- Desenvolvedores buscando entender o básico de APIs REST
- Quem deseja aprender sobre envio de emails com Java
- Iniciantes em desenvolvimento back-end

## 🤔 O Que Aprender a Seguir?

Depois de entender este projeto básico, você pode avançar para:

- Adicionar segurança com Spring Security
- Conectar a um banco de dados com Spring Data
- Implementar documentação de API com Swagger/OpenAPI
- Adicionar testes automatizados
- Desenvolver um front-end para consumir esta API

## 📚 Recursos de Aprendizado

- [Documentação oficial do Spring](https://spring.io/guides)
- [Baeldung - Tutoriais de Spring](https://www.baeldung.com/spring-tutorial)
- [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)

## 🤝 Contribuições

Este é um projeto educacional simples. Contribuições para melhorar o exemplo e adicionar mais comentários explicativos são bem-vindas!

## ⚠️ Aviso

Este é um projeto de exemplo para fins educacionais. Não é recomendado para uso em produção sem revisões de segurança e melhorias adicionais.

---

<p align="center">
  Desenvolvido por Isaac Nunes como um exemplo didático para iniciantes em Spring Boot
</p>
