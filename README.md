# **E-Commerce Platform API**

This is a Spring Boot-based REST API for managing products on an e-commerce platform. The API supports CRUD operations for products and includes additional features like applying discounts or taxes to products.

## *Features:-*

- Create Product: Add a new product to the catalog.
- Read Product: Retrieve product details by ID.
- Update Product: Update product details.
- Delete Product: Remove a product from the catalog.
- Apply Discount or Tax: Modify the price of a product based on discount percentage or tax rate.

## *Installation:-*
To run the project locally, follow these steps:

- Clone the repository to your local machine:
  >>git clone <repository_url>
- Open the project in your preferred IDE (e.g., Spring Tool Suite).
  >>Build the project using Maven: mvn clean install
- Run the application:
  >>mvn spring-boot:run

## *Usage*
- Create Product: Send a POST request to /products with the product details in the request body.
- Read Product: Send a GET request to /products/{productId} to retrieve product details by ID.
- Update Product: Send a PUT request to /products/{productId} with the updated product details in the request body.
- Delete Product: Send a DELETE request to /products/{productId} to delete a product by ID.
- Apply Discount or Tax: Send a POST request to /products/{productId}/apply-discount or /products/{productId}/apply-tax with the discount percentage or tax rate in the request body.

## *Technology and Tools Used:-*
- Java: The primary programming language used for developing the backend logic of the application.
- Spring Boot: A popular Java framework used for building standalone, production-grade Spring-based applications.
- Maven: A build automation tool used for managing project dependencies and building the project.
- Spring Data JPA: Part of the Spring Data project, used to simplify data access layer development by providing a JPA-based repository abstraction.
- H2 Database: An in-memory database used for storing data during development and testing.
- JUnit: A unit testing framework used for writing and running unit tests for the application.
- Postman: A popular API development tool used for testing APIs and exploring endpoints.
- Spring Tool Suite (STS): An integrated development environment (IDE) based on Eclipse, used for developing Spring Boot applications.

## *Endpoints:-*
- URL: POST http://localhost:8080/products
 - Request Body:
>>{
    "name": "Product Name",
    "description": "Product Description",
    "price": 25.99,
    "quantityAvailable": 100
}

- GET http://localhost:8080/products/{productId}
- PUT http://localhost:8080/products/{productId}
- DELETE http://localhost:8080/products/{productId}
- POST http://localhost:8080/products/{productId}/apply?discountOrTax=10&isDiscount=true

<br />
<br />

##### Author:- Sushma Ramappa


  
