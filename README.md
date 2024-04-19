Gym Management System
This is a Spring Boot application integrated with Thymeleaf and PostgreSQL for managing gym members. It allows you to insert basic details of a gym member, including their membership plan (1 month, 3 months, or 1 year), and the start date of their membership. The application will also calculate if the membership is active or not based on the current date.

Prerequisites
Java 11 or later
Maven
PostgreSQL
Setup
Clone the repository:

Copy code
git clone <repo-name>
Navigate to the project directory:

Copy code
cd gym-management-system
Configure the PostgreSQL database connection in src/main/resources/application.properties:
properties


Copy code
spring.datasource.url=jdbc:postgresql://localhost:5432/gym_db
spring.datasource.username=postgres
spring.datasource.password=your_password
Replace your_password with your PostgreSQL password.

Build the project:

Copy code
mvn clean install
Running the Application
Start the application:

Copy code
mvn spring-boot:run
Open your web browser and navigate to http://localhost:8080.
Usage
On the home page, you can add a new gym member by filling out the form with their name, membership plan, and membership start date.
After submitting the form, you will be redirected to the "Gym Members" page, which displays a list of all registered members along with their membership details and status (active or inactive).
Contributing
Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.

License
No License
