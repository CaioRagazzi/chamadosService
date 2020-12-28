# chamados Service
### **Banco de Dados da API**<br/>
Para criar o banco de dados, executar o comando no MySQL:<br/>
`CREATE SCHEMA "chamados_db";` 

As tabelas serão criadas automaticamente ao executar a aplicação, porém é necessário popular as tabelas status_chamado e tipo_chamado:

`INSERT INTO "chamados_db"."status_chamado" ("descricao") 
VALUES ("aberto"),
("em atendimento"),
("encerrado"),
("cancelado");`

`INSERT INTO `chamados_db`.`tipo_chamado` (`descricao`) 
VALUES ('incidente'),
('requisição');`


As configurações do BD ficam no arquivo application.properties (https://github.com/erickfaraujo/chamadosService/blob/main/src/main/resources/application.properties). Caso seja necessário alterar as configurações de SCHEMA, usuário ou senha, alterar nesse arquivo.<br/>

### **SWAGGER**<br/>
Ao rodar a aplicação o Swagger estará disponível em http://localhost:8080/swagger-ui.html <br/>

### **POSTMAN**<br/>
Collection do Postman com as requisições preenchidas: <br/>
https://www.getpostman.com/collections/243fe104efe7741b0b87
