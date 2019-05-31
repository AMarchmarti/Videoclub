## Back-end

Aquí encontramos la lógica de nuestro proyecto, los controladores los explicaremos en su respectiva carpeta, pero la carpeta 
**Model** y **DAO** las expondremos aquí ya que son la conexión y comunicación de la bbdd.

#### Model
La carpeta que se encuentran las entidades, la conexión directa con las tablas de la bbdd, además de las referencias que 
tienen entre ellas y como se nombran. Hay un caso en particual que se encuentra en ``Usuarios`` que vemos que hay un ``cascade``
eso nos indica que a la vez que se cree el usuario se va a crear la Persona al igual que si se modifica o se elimina.

Aquí encontramos los getters y setters de las diferentes columnas que hacen que podamos acceder a ellas y poder incorporar,
modificar o eliminar los datos que haya.

Cada entidad tiene el nombre en singular de la tabla de bbdd.

#### DAO
Esta carpeta es el corazón del proyecto ya que és la comunicación con la bbdd, eso quiere decir que aquí está la lógica 
para poder efectuar las funciones de los controladores. 

En **Util** podemos fer una serie de interfaces que esta´n implementadas en las clases acabadas en Impl, esto es así para
que el controlador no dependa directamente de las clases del DAO sino que llame a las interfaces, aquí vemos claramente una 
**Inversión de dependencias**.

La clase ``JPAUtil`` es la clase que crea el EntityManager y nos permita con eso la comunicación con la base de datos, 
en esta clase encontramos el nombre de ``PERSISTENCE`` que es el nombre de la persistencia, la conexión con la bbdd.

Las clases del DAO efectuán las funciones que el controlador le indica, por tanto el controlador permite hacer el ```CRUD```
pero en realidad, este, se efectua aquí. 