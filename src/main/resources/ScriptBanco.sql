-- Apagar o banco de dados
drop database banco;
-- Criar o banco de dados
create database banco;
-- Atribuir os privilégios de acesso aos objetos do banco
-- para o usuário root
GRANT ALL PRIVILEGES ON banco.* TO 'root' @'localhost';
-- Acesar o banco de dados: banco
USE banco;
-- Criar a tabela: client
CREATE TABLE client(
    id int AUTO_INCREMENT,
    nome varchar(50) NOT NULL,
    cpf varchar(14) NOT NULL,
    sexo varchar(1) NOT NULL,
    data_nascimento date,
    endereco_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (endereco_id) REFERENCES addresss (id)
);

USE banco;

CREATE TABLE addresss(
    id int AUTO_INCREMENT,
    cep varchar(9) NOT NULL,
    rua varchar(50) NOT NULL,
    bairro varchar(50) NOT NULL,
    numero int NOT NULL,
    cidade varchar(50) NOT NULL,
    uf varchar(4) NOT NULL,
    PRIMARY KEY (id)
)
