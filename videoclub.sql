SET GLOBAL time_zone = '-3:00';

DROP SCHEMA IF EXISTS videoclub;
CREATE SCHEMA videoclub;

USE videoclub;
DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario(
	id INT NOT NULL auto_incremenT,
    nombre varchar(255) NOT NULL,
    apellidos varchar(255) not null,
    fechaNacimiento date not null,
    administrador enum('S', 'N') default 'N',
    primary key(id));
    
drop table if exists peliculas;
create table peliculas(
	id int not null auto_increment,
    nombre varchar(255) not null,
    fechaEstreno int not null,
    genero varchar(255) not null, 
    alquilada tinyint not null default '1',
    director varchar(255),
    primary key(id));
    
drop table if exists seleccion;
create table seleccion(
	id_usuario int not null,
    id_pelicula int not null,
    primary key(id_usuario, id_pelicula),
    foreign key(id_usuario) references usuario(id),
    foreign key(id_pelicula) references peliculas(id));
    
    