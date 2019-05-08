SET GLOBAL time_zone = '-3:00';

DROP SCHEMA IF EXISTS videoclub;
CREATE SCHEMA videoclub;

USE videoclub;

drop table if exists personas;
create table personas(
	id int not null auto_increment,
    nombre varchar(100) not null,
    apellidos varchar(100) not null,
    sexo enum('M','F') not null,
    fechaNacimiento datetime not null,
    primary key(id));
    
drop table if exists telefonos;
create table telefonos(
	id int not null auto_increment,
    id_persona int not null,
    numero varchar(9) not null,
    primary key(id),
    foreign key(id_persona) references personas(id));

DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario(
	id_persona INT NOT NULL,
    usuario varchar(50) NOT NULL,
    clave varchar(80) not null,
    tipo enum('A','O'),
    estado tinyint default 1,
    primary key(id_persona),
    foreign key(id_persona) references personas(id));
    
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
    id_persona int not null,
    id_pelicula int not null,
    fechaAlquiler datetime not null,
    primary key(id_alquiler),
    foreign key(id_persona) references personas(id),
    foreign key(id_pelicula) references peliculas(id_pelicula));
    
    