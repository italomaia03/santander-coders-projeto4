# Aplicação de Leitura e Armazenamento de Produtos

Este projeto consiste em uma aplicação Java utilizando Spring Boot 3.2.4 e Maven 3.6.3, desenvolvida para realizar a leitura de um arquivo CSV contendo registros de produtos e armazená-los em um banco de dados MySQL. Além disso, a aplicação gera um relatório contendo informações como categorias distintas de produtos, quantidade de produtos por categoria, preço médio dos produtos e lista dos produtos com menos de 20 unidades.

## Requisitos

- Java 21
- Spring Boot 3.2.4
- Maven 3.6.3
- Docker Compose 2.25.0
- Docker 26.0.0
- Imagem docker MySQL:latest

## Como Rodar

1. Clone o repositório para sua máquina local ou baixe-o como arquivo ZIP.
2. Certifique-se de ter o Docker e Docker Compose instalados.
3. Caso não possua o Maven instalado, dê permissão de execução aos arquivos mvnw e mvnw.cmd.
4. Execute o arquivo `docker-compose.yml` para iniciar o container do banco de dados MySQL.
5. Após o banco de dados estar em execução, faça o build da aplicação.
6. Rode a aplicação a partir do arquivo .jar gerado na pasta target.

   ```bash
   docker compose up -d
   ./mvnw clean install -Dmaven.skip.tests=true
   java -jar target/meu-arquivo-jar.jar
   ```
7. Será impresso no console o relatório mencionado anteriormente.
## Aprendizados

Durante o desenvolvimento deste projeto, foi possível aprofundar os conhecimentos em Java, especialmente em relação ao uso de streams de dados e o paradigma funcional. As interfaces funcionais fornecidas pelo pacote `java.util.function`, como `Function`, `BiFunction`, `Consumer`, `Predicate` e `Supplier`, foram fundamentais para manipular dados de forma mais concisa e expressiva. O uso de streams permitiu operações de transformação, filtragem e redução de dados de maneira eficiente, contribuindo para um código mais limpo e legível. Esses conceitos são essenciais para escrever aplicativos Java mais modernos e robustos, especialmente em projetos que lidam com processamento de dados e manipulação de coleções.