
# 🧪 Projeto de Testes de API com RestAssured, Cucumber e Allure

Este projeto realiza testes automatizados em uma API REST utilizando **Java**, **RestAssured**, **Cucumber**, **JUnit** e **Allure Reports**. Os testes são feitos contra a [Swagger Petstore API](https://petstore.swagger.io).

---

## ✅ Tecnologias Utilizadas

- Java 17  
- Maven  
- RestAssured  
- Cucumber v7.14.0  
- JUnit 4  
- Allure Reports  
- IntelliJ IDEA

---

## 📁 Estrutura do Projeto

```
├── src
│   ├── main
│   └── test
│       ├── java
│       │   ├── com.example.api.steps       # Implementação dos passos (Steps)
│       │   └── com.example.api.runners     # Runner do Cucumber
│       └── resources
│           └── features                    # Arquivos .feature com os cenários
├── pom.xml
└── README.md
```

---

## ▶️ Como Executar os Testes

```bash
mvn clean test
```

---

## 📊 Como Gerar o Relatório Allure

Após executar os testes, rode:

```bash
mvn allure:serve
```

Esse comando gera e abre automaticamente o relatório Allure no navegador.

> A pasta `target/allure-results` é criada automaticamente com os resultados dos testes.

---

## 🧪 Cenários de Teste

- Consulta de pet por ID (`GET /pet/{id}`)
- Cadastro de pet (`POST /pet`)
- Alteração de pet (`PUT /pet`)
- Validação de erro para ID inválido

---

## 💡 Melhorias Futuras

- Testes para DELETE
- Testes com autenticação
- Integração com CI/CD (GitHub Actions, Jenkins, etc.)

---

## ✍️ Autor(a)

**Claudiane Oliveira**  
🔗 [LinkedIn](https://www.linkedin.com/in/claudianeoliveiraqa/)

---

## 📃 Licença

MIT License
