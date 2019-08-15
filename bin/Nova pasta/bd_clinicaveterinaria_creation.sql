drop database if exists db_clinicaveterinaria;

create database db_clinicaveterinaria;
use db_clinicaveterinaria;
/*Criando Tabelas*/
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
	