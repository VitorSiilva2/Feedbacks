Projeto CRUD utilizando a linguagem Java, API JDBC e o banco de dados Mysql.

Este é projeto Java que utiliza o JDBC (Java Database Connectivity) para implementar operações de CRUD (Create, Read, Update, Delete) em um banco de dados (Mysql)

Estrutura do projeto

controller: Pacote que contém os controladores responsáveis por lidar com as requisições e respostas relacionadas às entidades.

db: Pasta que contém os scripts SQL ou outros arquivos relacionados ao banco de dados.

exceptions: Pacote que contém as classes de exceção personalizadas para erros relacionados ao banco de dados.

model: Pacote que contém as classes que representam as entidades do sistema.

repositories: Pacote que contém as classes responsáveis por interagir com o banco de dados, executando consultas e atualizações.

service: Pacote que contém as classes de serviço que encapsulam a lógica de negócio e utilizam os repositórios para manipular as entidades.

util: Pacote que contém classes utilitárias para validação, criptografia de senhas, entre outras funcionalidades auxiliares.

Main: Classe principal do projeto, responsável por iniciar a aplicação.

