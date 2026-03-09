# 🚀 Smart Price Monitor - Java & Spring Boot

Sistema automatizado de monitoramento de preços via **Web Scraping**, com persistência de dados em tempo real e notificações via **Telegram Bot**.

Este projeto demonstra competências avançadas em **Backend Development** e **Data Analysis**, coletando e processando séries temporais de preços para análise de tendências de mercado.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 25 (LTS)
* **Framework:** Spring Boot 3
* **Banco de Dados:** MySQL
* **Persistência:** Spring Data JPA / Hibernate
* **Notificações:** Telegram Bot API
* **Coleta de Dados:** Jsoup (Web Scraping)

---

## 🌟 Funcionalidades Principais

* **Monitoramento Autônomo:** Execução de tarefas agendadas (`@Scheduled`) para verificação periódica sem intervenção humana.
* **Séries Temporais (Data Analysis):** Armazenamento de histórico de preços para cada produto, permitindo a futura geração de gráficos de volatilidade.
* **Alertas Inteligentes:** O sistema identifica quedas de preço e envia o link direto do produto para o Telegram do usuário quando o "Preço Alvo" é atingido.
* **Arquitetura Escalável:** Relacionamento **One-to-Many** entre produtos e seus respectivos históricos de preços.

---

## 📈 Estrutura do Projeto

    src/main/java/com/example/demo/
    ├── controller/    # Endpoints da API REST
    ├── model/         # Entidades do Banco de Dados
    ├── repository/    # Interfaces de comunicação com o MySQL
    ├── service/       # Lógica de negócio (Scraper, Agendador, Notificações)
    └── DemoApplication.java

---

## 🚀 Como Executar

1. **Clone o repositório:**
    ```bash
    git clone [https://github.com/samuelsavioo/Schedulling-Price.git](https://github.com/samuelsavioo/Schedulling-Price.git)
    ```

2. **Configure o banco de dados:**
   No arquivo `src/main/resources/application.properties`, ajuste as credenciais do seu **MySQL**.

3. **Configure o Bot do Telegram:**
   Obtenha seu `token` e `chatId` com o @BotFather e insira no `application.properties`:
    ```properties
    telegram.bot.token=SEU_TOKEN
    telegram.chat.id=SEU_ID
    ```

4. **Inicie a aplicação:**
   Execute o projeto via IntelliJ ou Maven e utilize o Postman para cadastrar seu primeiro produto via `POST http://localhost:8080/produtos`.

---

## 👨‍💻 Autor

**Samuel** - Estudante de Análise e Desenvolvimento de Sistemas e Estagiário de Desenvolvimento Web.