# Como crear una API REST con Relación Uno a Uno usando Spring Boot con frontend

Este repositorio contiene una guía detallada sobre cómo crear una API REST en Spring Boot junto con su implementación CRUD para crear, leer, actualizar y eliminar entidades, además de mostrar cómo implementar una relación uno a uno entre dos entidades. Utiliza una base de datos H2 en memoria para almacenar los datos.


![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)

## 🛠 Tecnologías Utilizadas
- Java
- Spring Boot
- MySQL
- IntelliJ IDEA
- Postman
- Bulma 1.0.0
- javascript

## Creacion de la API
Para poder crear una api en java con sprint, lo primero que necesitamos es configurar nuestro proyecto de `spring` con dependencias de maven, como en la siguiente imagen se muestra.
Las dependecias seran:
  - **Spring Web:** nos ayuda ejecutar y a utlizar todas las tecnologias de springweb (API Rest) y crea nuestro servidor en Tomcat
  - **Spring Data JPA:** nos permite manejar la bd mediante `hibernate` y `Spring Data` mediante la persistencia
  - **Lombok:** nos ayuda a disminuir el codigo de los entitys de nuestras tablas `getters` & `setters`
  - **H2 DataBase:** es una bd que esta integrada en nuestra aplicacion

<image src="https://github.com/monnsmonsh/API-REST-OneToMany-Spring/blob/main/assets/config.png" alt="Config spring">

> No es necesario utilizar `IntelliJ IDEA` puedes utilizar cualquier otro IDE que soporte java.



## Configuracion de BD
Para comenzar tenemos que crear la configuracion de nuestra bd para esto creamos un archivo en la ruta resources con el nombre `application.yml` y configuramos nuestra conexion de spring.

Lo que hace `hibernate` es que actulizara el esquema de nuestra bd para que coincida con la entidad `JPA`, habilitamos nuestra consola con `true`  para poder visualizar los errores de nuestra bd.

```yml
spring:
    datasource:
        url: jdbc:h2:mem:management
        username: sa
        password:
    jpa:
        hibernate:
            ddl-auto: update
    output: #me muestra la info que estemos ejecutando
        ansi:
            enable: always
    h2:
        console:
            enabled: true
```


## Creacion de nuestros modelos
Creamos un `package` dentro del paquete principal con el nombre `model` en donde almacenaremos nuestras entidades para que JPA ayude a crear directamente todos los campos y todo lo relacionado con la bd.

Para crear un modelo lo primero que tenemos que hacer en colocar `@Entity` ya que le dice a la percistencia de java que es una entidad, posteriormente colocamos `@Data` que nos define nuestra clase como un flujo de informacion y ademas nos ayuda a crear los campos de una manera mas sencilla.

Ya creado  ahora nos reta crear nuestras propiedades, ya que posteriormente `spring boot` con `JPA` creara toda la informacion relacionadad con la bd.

```java
@Entity
@Data
@NoArgsConstructor//contructor que no tiene argumentos
@AllArgsConstructor//contructor que va ha tiene argumentos
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmployee;

    private String name;
    private String lastName;
    private String birthDate;
    private String phone;

    @OneToOne
    private Management management;
}
```
Para definir las relacionacion primero tenemos que tener en claro que tipo de relacion tienen nuestra entidad en este caso es `@OneToOne` y  le indicamos que es una `cascade = CascadeType.ALL` para que con JPA y persistence se encargen de la relacion de la bd, es decir que si nosotros eliminamos un huespet todas sus resevaciones se iran con el y para relacionar esto tenemos que crear un *ARRAY* donde almacenaremos la inforamcion de todas la reservas y lo definimos que sea un tipo lista.
```java
    //generamos nuestra relacion
    @OneToOne
    private Management management;

```
> **NOTA**
>> Al utilizar *Lombok* nos evitamos crear nuestros getters y setters en nuestras entidades, y de los constructores.


