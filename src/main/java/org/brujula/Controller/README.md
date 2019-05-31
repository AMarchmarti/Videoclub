##Controlador

Aquí está la parte del controlador que conecta la bbdd con la vista. Es el sistema que recolecta la información que ha 
recibido del usuario, conecta con la bbdd y luego devuelva la información solicitada.

- ***UsuarioNoDisponible*** es una excepción, creada para que salte si el usuario ha puesto un nombre que ya esta registrado
en la bbdd

- ***LoginController*** controlador del login, dóndo su función es la de recibir un nombre de usuario y una clave y ver 
si están registrado en la bbdd, este nos dará permiso para poder acceder a la parte de protegido y nos indica que usuario
está conectado.

- ***SessionCotroller*** controlador que nos indica si hay un usuario conectado, que permisos tiene el usuario y nos permite 
cerrar la sesión actual.

- ***UsuariosController*** controlador que nos permite hacer un ```CRUD``` con los usuarios

- ***AlquilerController*** controlador que permite el ```CRUD``` con el alquiler, además se encarga de cambiar el estado de película.

- ***GeneroControler*** nos permite visualizar los géneros que están registrados en la bbdd, además siendo *administradores*
nos permite añadir nuevos géneros.

- ***MenuController*** controlador que hacer que nuestro menú (navbar) sea dinámico y podamos visualizar ciertas paáginas y otras no.

- ***PeliculaController*** controlador para efectuar el ```CRUD``` sobre películas.