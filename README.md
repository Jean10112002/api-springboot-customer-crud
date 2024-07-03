<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>
  <h1>Customer CRUD API Básica Como Práctica</h1>

  <h2>Tecnologías Utilizadas</h2>
  <ul>
    <li>Java</li>
    <li>Spring Boot</li>
    <li>Spring Data JPA</li>
    <li>Lombok</li>
    <li>Maven (como gestor de dependencias)</li>
  </ul>

  <h2>Estructura del Proyecto</h2>
  <pre>
├── src
│   ├── main
│   │   ├── java/com/example/api_rest_practica
│   │   │   ├── controller        # Controladores REST
│   │   │   ├── model             # Modelos de datos
│   │   │   ├── dto               # DTOs (Data Transfer Objects)
│   │   │   ├── repository        # Repositorios JPA
│   │   │   └── service           # Servicios de negocio
│   │   └── resources
│   │       └── application.properties  # Archivo de configuración
│   └── test                    # Pruebas unitarias y de integración
│       └── java/com/example/api_rest_practica
  </pre>

  <h2>Modelos de Datos</h2>
  <h3>Customer</h3>
  <p>El modelo <code>Customer</code> representa a un cliente con los siguientes atributos:</p>
  <ul>
    <li><code>id</code>: Identificador único del cliente.</li>
    <li><code>documentType</code>: Tipo de documento del cliente.</li>
    <li><code>documentNumber</code>: Número de documento del cliente.</li>
    <li><code>name</code>: Nombre del cliente.</li>
    <li><code>phone</code>: Número de teléfono del cliente.</li>
  </ul>

  <h2>DTOs (Data Transfer Objects)</h2>
  <h3>CustomerDto</h3>
  <p>DTO utilizado para crear y actualizar clientes. Contiene los siguientes campos:</p>
  <ul>
    <li><code>documentType</code></li>
    <li><code>documentNumber</code></li>
    <li><code>name</code></li>
    <li><code>phone</code></li>
  </ul>

  <h3>CustomerUpdateDto</h3>
  <p>DTO utilizado para actualizar clientes existentes. Contiene los mismos campos que <code>CustomerDto</code>, más <code>id</code>.</p>

  <h2>Repositorio</h2>
  <h3>CustomerRepository</h3>
  <p>Repositorio JPA que gestiona la entidad <code>Customer</code>. Proporciona métodos para interactuar con la base de datos, como guardar, actualizar, eliminar y consultar clientes.</p>

  <h2>Servicios</h2>
  <h3>CustomerService</h3>
  <p>Contiene la lógica de negocio para gestionar clientes. Implementa métodos para crear, leer, actualizar y eliminar clientes.</p>

  <h2>Controladores REST</h2>
  <h3>CustomerController</h3>
  <p>Controlador REST que maneja las peticiones HTTP para la gestión de clientes. Incluye endpoints para crear, actualizar, obtener y eliminar clientes. Utiliza validaciones de entrada básicas para garantizar la calidad de los datos.</p>

  <h2>Validaciones</h2>
  <p>Se utilizan anotaciones de validación básicas como practica de los datos en los DTOs y los modelos de datos.</p>

  <h2>Configuración</h2>
  <p>El archivo <code>application.properties</code> se utiliza para configurar la aplicación, incluyendo la configuración de la base de datos, si corresponde.</p>


  <h2>Ejecución</h2>
  <p>Para ejecutar la aplicación, asegúrate de tener configurado Java y Maven en tu sistema. Ejecuta el siguiente comando desde el directorio raíz del proyecto:</p>
  <pre><code>mvn spring-boot:run</code></pre>
  <p>Esto iniciará la aplicación Spring Boot y la API estará disponible en <code>http://localhost:8080</code>.</p>
</body>
</html>
