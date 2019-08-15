/*CRIAÇÃO DO BANCO DE DADOS*/

DROP DATABASE IF EXISTS db_clinicaVeterinaria;

CREATE DATABASE db_clinicaVeterinaria;

USE db_clinicaVeterinaria;

/*CRIAÇÃO DAS TABELAS*/

CREATE TABLE funcionario (
    id_func int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nome varchar(50) NOT NULL,
    cpf char(11) NOT NULL,
    ctps char(8) NOT NULL,
    rg char(9),
    dtNasc date,
    genero char(1),
    cargo varchar(20) NOT NULL,
    salario double NOT NULL,
    dtContratacao date
);

CREATE TABLE cliente (
    id_cliente int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nome varchar(50) NOT NULL,
    cpf char(11),
    telefone varchar(15) NOT NULL,
    email varchar(50)
);

CREATE TABLE animal (
    id_animal int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nome varchar(20),
    raca varchar(20),
    especie varchar(20),
    sexo char(1),
    id_cliente int NOT NULL
);

CREATE TABLE consulta (
    id_consulta int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    data date NOT NULL,
    hora time NOT NULL,
    sintomas varchar(100),
    diagnostico varchar(100),
    id_funcionario int,
    id_animal int NOT NULL
);

CREATE TABLE cirurgia (
    id_cirurgia int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    data date NOT NULL,
    hora time NOT NULL,
    grau_urgencia int,
    duracao time,
    situacao varchar(100),
    id_funcionario int,
    id_animal int NOT NULL
);

/*DEFINIÇÃO DE CHAVES ESTRANGEIRAS*/
 
ALTER TABLE animal ADD CONSTRAINT FK_animal_1
FOREIGN KEY (id_cliente)
REFERENCES cliente (id_cliente);
 
ALTER TABLE consulta ADD CONSTRAINT FK_consulta_1
FOREIGN KEY (id_funcionario)
REFERENCES funcionario (id_func);
 
ALTER TABLE consulta ADD CONSTRAINT FK_consulta_2
FOREIGN KEY (id_animal)
REFERENCES animal (id_animal);
 
ALTER TABLE cirurgia ADD CONSTRAINT FK_cirurgia_1
FOREIGN KEY (id_funcionario)
REFERENCES funcionario (id_func);
 
ALTER TABLE cirurgia ADD CONSTRAINT FK_cirurgia_2
FOREIGN KEY (id_animal)
REFERENCES animal (id_animal);