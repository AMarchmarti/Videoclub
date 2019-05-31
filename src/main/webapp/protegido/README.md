## Protegido

Esta Carpeta es la gran parte del proyecto, aqui encontraremos las páginas para poder efectuar las transacciones sobre 
las películas dentro de la bbdd.

**Añadir**
Está página trata de añadir peliculas a la bbdd, cualquiera puede hacerlo, pero el *administrador* puede además añadir 
nuevos géneros para las películas. 

**Mis Películas** 
Página dónde se encuentra una tabla que extrae la información de la bbdd y te muestra que películas tienes alquiladas, 
te expone la imagen de la película, su nombre, cuando la alquilaste y un botón de devolver la película, que como su nombre 
indica, su función es midificar el estado de la palícula para que no este alquilada.

**Perfil**
Es una página simple que te muestra tú información personal y te da la opción de editar esta información.

**Usuarios**
Está página sólo esta habilitada para los administradores y te muestra información de los usuarios, incluso las películas
alquiladas, y además la posibilidad, si este no es administrador, de eliminar usuarios.

**Principal**
La página de inico una vez estemos loggeados.
Aquí hay una bienvenidad que muestra el nombre de usuario que esta conectado y las películas que tiene el videoclub. Como 
*usuario* sólo verá un botón que es el alquiler, este además dependiendo del estado de la película estará habilitado (película
disponible) o deshabilitado. Como *administrador* además del alquiler tiene un botón para poder editar la película, dónde 
aparecerá un diálogo con la información que quiera cambiar.