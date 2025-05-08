# Mule Migration Service


Mule Migration Service is a Spring Boot application designed to demonstrate XML and JSON data handling, REST API development, and scheduled tasks. The application provides endpoints to produce and consume product data in both XML and JSON formats.

## Features

- **REST API Endpoints:**
  - `/products/produce/product`: Produces a product in XML format.
  - `/products/product`: Consumes a product in XML format and returns it as JSON.
  - `/greet`: Returns a simple greeting message in JSON format.

- **XML Parsing:**
  - Uses `XmlMapper` from Jackson to parse XML responses into Java objects.

- **Scheduled Tasks:**
  - Logs a migration check every 10 seconds and consumes product data.

- **Logging:**
  - Logs application events and data processing using SLF4J.

## Project Structure

Proof of Concept (POC) drive link:
https://drive.google.com/drive/folders/1V9J9ApyMeJmoAMlvc_OV0KXqzBzeRHak?usp=sharing

```
src/
└── main/
    ├── java/
    │   └── com.example.mule_migration/
    │       ├── controller/
    │       │   ├── GreetController.java
    │       │   └── ProductController.java
    │       ├── entity/
    │       │   └── Product.java
    │       ├── services/
    │       │   ├── SchedulerService.java
    │       │   └── XmlConsumerService.java
    │       ├── util/
    │       │   └── ShutdownLogger.java
    │       └── MuleMigrationApplication.java
    └── resources/
        └── application.properties
```

## Endpoints

1. **/products/produce/product**  
   - Method: GET  
   - Produces: `application/xml`  
   - Description: Produces a product in XML format.

2. **/products/product**  
   - Method: GET  
   - Produces: `application/json`  
   - Description: Consumes the XML product from `/products/produce/product` and returns it as JSON.

3. **/greet**  
   - Method: GET  
   - Produces: `application/json`  
   - Description: Returns a simple greeting message.

## How It Works

- **ProductController**  
  Handles REST API requests for producing and consuming product data. Uses `XmlConsumerService` to parse XML responses.

- **XmlConsumerService**  
  Fetches XML data from `/products/produce/product` and parses the XML into a `Product` object using `XmlMapper`.

- **SchedulerService**  
  Executes a scheduled task every 10 seconds to log a migration check and consume product data.

- **Logging**  
  Logs application events and data processing using SLF4J.

## Prerequisites

- Java 17 or higher  
- Maven 3.9.9 or higher

## Running the Application

1. Clone the repository:  
   ```bash
   git clone https://github.com/sandipkalsait/Mulesoft-Migration-Assignment.git
   cd Mulesoft-Migration-Assignment
   ```

2. Build the project:  
   ```bash
   mvn clean install
   ```

3. Run the application:  
   ```bash
   mvn spring-boot:run
   ```

4. Access the endpoints:  
   - `http://localhost:8080/products/produce/product`  
   - `http://localhost:8080/products/product`  
   - `http://localhost:8080/greet`

## Configuration

The application properties can be configured in `src/main/resources/application.properties`.

## Dependencies

- Spring Boot Starter Web  
- Spring Boot Starter Test  
- Jackson Dataformat XML  
- SLF4J  
- Lombok

## License

This project is licensed under the Apache License 2.0. See the [LICENCE](https://www.apache.org/licenses/LICENSE-2.0) file for details.
