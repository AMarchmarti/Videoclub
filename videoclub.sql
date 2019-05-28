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
    estado tinyint,
    primary key(id),
    foreign key(dni_persona) references personas(dni));
    
drop table if exists generos;
create table generos(
    nombre varchar(50)  not null,
    primary key(nombre));
    
insert into generos values ('Terror');
insert into generos values ('Fantasía');
insert into generos values ('Ciencia-Ficción');
insert into generos values ('Acción');
insert into generos values ('Comedia');
insert into generos values ('Romance');


drop table if exists peliculas;
create table peliculas(
	id_pelicula int not null auto_increment,
    titulo varchar(100) not null,
    resumen varchar(255),
    estado tinyint default 1,
    genero varchar(50) not null,
    imagen varchar(255) not null,
    primary key(id_pelicula),
    foreign key(genero) references generos(nombre));
    
drop table if exists alquileres;
create table alquileres(
	id_alquiler int not null auto_increment,
    id_usuario int not null,
    id_pelicula int not null,
    fechaAlquiler datetime not null,
    primary key(id_alquiler),
    foreign key(id_usuario) references usuario(id),
    foreign key(id_pelicula) references peliculas(id_pelicula));
    
drop table if exists menu;
create table menu (
	codigo tinyint not null auto_increment,
    nombre varchar(50) not null,
    url varchar(50),
    tipo enum('S','I') not null,
    codigo_submenu tinyint,
    tipo_usuario enum('A', 'O') not null,
    estado bit(1) not null,
    primary key(codigo),
    foreign key (codigo_submenu) references menu(codigo));
    
insert into menu (nombre,url, tipo,tipo_usuario,estado) values ('Peliculas','principal.xhtml', 'I','O', 1);
insert into menu (nombre,url, tipo,tipo_usuario,estado) values ('Añadir','añadir.xhtml', 'I','O', 1);
insert into menu (nombre,url, tipo,tipo_usuario,estado) values ('Mis peliculas','mispeliculas.xhtml', 'I','O', 1);
insert into menu (nombre,url,tipo,tipo_usuario,estado) values ('Usuarios','usuarios.xhtml', 'I','A', 1);

drop table if exists codigoPromocional;
create table codigoPromocional(
	codigo varchar(20) not null,
    primary key(codigo));
    
insert into codigoPromocional value ('A32BX@520TXZ');

    

    