## VideoClub
Este proyecto que junta diversas tecnologias:
   - Para empezar es un proyecto ```Maven```.
   - Contiene el freamwork ```Hibernate```, que es la tecnología que usamos para acceder y modificar la bbdd. Esta contiene ```JPA```.
   - Contiene el freamwork ```JSF``` junto con ```Primefaces```, para hacer las dependencia entre las clases y la unión del back-end con el front-end.

Es un proyecto que intenta simular un videoclub, contiene las funciones básicas en la Base de datos, es decir hacemos 
```CRUD```.

El proyecto tiene las siguiente funcionalidades: 
   - Como **Usuario:** puedes alquilar una pelicula, crear una pelicula, modificar tu perfil, registrarte y devolver la película
    
   - Como **Administrador:** Además de todo lo que puede hacer el usuario, puedes editar la pelicula, crear nuevos generos,
    puedes ver los usuarios registrados y si estan conectados o no, además de saber que peliculas tienen alquiladas.
    A parte puedes decidir si eliminar un usuario que no és administrador.
    
El proyecto esta construido con el patrón de arquitectura ```MVC```. La vista la encontraremos en webapp, mientras que el controlador y el modelo lo encontramos en la carpeta java.

Cada carpeta contiene más información sobre ella misma.

**Webapp**
    Esta carpta contiene la parte visual del proyecto (vista). 
    
**Model**
    Son las entidades que tienen en común con la bbdd están anotadas con el freamwork ```JPA```.
    
**DAO**
    Carpeta que se encuentra la conexión a la base de datos, haciendo uso de las entidades, mencionadas anteriormente.
    
**Controller**
    Carpeta que se encuentra el controlador, y comunica el modelo con la vista.

