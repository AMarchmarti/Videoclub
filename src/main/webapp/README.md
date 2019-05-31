## Wepapp

Aquí encontramos la vista de nuestro proyecto, esta compuesto por una serie de páginas web que nos visualizan las diferentes acciones que podemos hacer

**Protegido**
Esta carpeta se encuentran las página web que necesitan usuario para poder acceder, si no fuera el caso de estar conectado, saltaría
un error de sesión que le llevaría directamente a la página de permisos insuficientes.

**Resources**
Aquí están los diferentes recursos de la web, ya sean imágenes, css y javascript que van a utilizar la web.

**WEB-INF**
Aqui está la configuración de la web en general, que se requiere para que pueda funcionar la vista del proyecto.

**Index**
En está página web está el Login del proyecto y el link que nos lleva al registro, no hace falta mencionar que sin estar 
registro no se puede acceder a la parte de protegido.

**Registro**
Aquí se encuentra el formulario para poder registrarse al proyecto, que se guarda automáticamente en la bbdd.
Se requiere una parte de información personal y otra parte de Usuario de la web. Hay que destacar que para poder registrarse
como administrador se necesita un código promocional que se encuentre en la bbdd.