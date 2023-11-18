show databases
use zdb;
show tables;
drop table deposito;
select *from contas;
drop table if exists administradores;
create table if not exists administradores(
id int not null auto_increment primary key,
nome varchar(40) not null,
cpf varchar(14) not null,
senha varchar(8) not null,
endereco varchar(40)
);

drop table if exists clientes;
create table if not exists clientes(
id int not null auto_increment primary key,
nome varchar(40) not null,
cpf varchar(14) not null,
senha varchar(8) not null,
endereco varchar(40)
);
drop table if exists depositos;
create table if not exists depositos(
id int not null auto_increment primary key,
data_deposito datetime not null,
conta_origem varchar (20) not null,
conta_destino varchar (20) not null,
valor_deposito double(10, 2) not null
);