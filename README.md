# api-rest-directorio-contactos
API REST Directorio de contactos

API REST para procesar datos de contactos usando Spring Boot, con persistencia en memoria con JPA y Hibernate usando base de datos H2

Especificaciones tecnicas
Java 8
Spring boot 
Maven 
H2 database 
JPA y Hibernate

La aplicacion cuenta con 5 cuentas precargadas, y tiene disponibles los siguientes endpoint:

- **GET: /contactos/**, retorna listado de contactos en formato json 
- **GET: /contactos/{id}**, retorna el detalle de un contacto en formato json
- **POST: /contactos/**, recibe un json de contacto sin **'id'** (id autogenerado)
- **PUT: /contactos/{id}**, recibe un json de contacto a editar y el **id** y retorna el contacto modificado en formato json
- **DELETE: /contactos/{id}**, recibe un mensaje "Contacto eliminado existosamente" y el id del contacto

ejemplo de un contacto en formato json:

``` json
  {
    "nombre": "Carlos Hernandez",
    "edad": "29",
    "email": "carlos@gmail.com",
    "celular": "5557237482",
    "fechaRegistro": "2022/03/21"
  }
