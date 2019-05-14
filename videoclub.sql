SET GLOBAL time_zone = '-3:00';

DROP SCHEMA IF EXISTS videoclub;
CREATE SCHEMA videoclub;

USE videoclub;

drop table if exists personas;
create table personas(
    dni varchar(20) not null,
    nombre varchar(100) not null,
    apellidos varchar(100) not null,
    sexo enum('M','F') not null,
    fechaNacimiento datetime not null,
    telefono varchar(10) not null,
    email varchar(255) not null,
    primary key(dni));
    

DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario(
	id int not null auto_increment,
	dni_persona varchar(20) NOT NULL,
    usuario varchar(50) NOT NULL,
    clave varchar(80) not null,
    tipo enum('A','O'),
    estado tinyint default 1,
    primary key(id),
    foreign key(dni_persona) references personas(dni));
    
drop table if exists generos;
create table generos(
	id_genero int not null auto_increment,
    nombre varchar(50)  not null,
    primary key(id_genero));
    
drop table if exists peliculas;
create table peliculas(
	id_pelicula int not null auto_increment,
    titulo varchar(100) not null,
    resumen varchar(255),
    estado tinyint default 1,
    genero int not null,
    primary key(id_pelicula),
    foreign key(genero) references generos(id_genero));
    
drop table if exists alquileres;
create table alquileres(
	id_alquiler int not null auto_increment,
    id_usuario int not null,
    id_pelicula int not null,
    fechaAlquiler datetime not null,
    primary key(id_alquiler),
    foreign key(id_usuario) references usuario(id),
    foreign key(id_pelicula) references peliculas(id_pelicula));
    
    