# Flower Management Application

Welcome to the **Flower Management Application**! This project showcases my knowledge and skills in Java, using technologies such as MySQL, Thymeleaf, Spring Boot, HTML, and CRUD operations.

## Technologies Used
- **Java**: The core programming language used for developing the application.
- **Spring Boot**: Used for building the backend REST API and managing dependencies.
- **Thymeleaf**: Integrated for server-side rendering of HTML and providing a seamless user experience.
- **HTML**: Utilized for structuring and presenting the content of the web pages.
- **CSS & Bootstrap**: For styling the application and making it responsive.
- **JPA/Hibernate**: To handle the persistence layer and interact with the database using ORM (Object-Relational Mapping).
- **MySQL**: The relational database used for storing flower data.

## Features
- **CRUD Operations**:
  - **Create**: Add new flower entries to the database.
  - **Read**: View a list of all flowers and their details.
  - **Update**: Modify existing flower details.
  - **Delete**: Remove flower entries from the database.
- **Scheduler**: Automatically insert a new flower into the database every 10 seconds using a scheduler.
- **Responsive Design**: The application is responsive and can be used on various devices, from desktops to mobile phones.
- **User-Friendly Interface**: Easy navigation and interaction using well-structured HTML and styled with Bootstrap.

## How to Run the Application
1. **Clone the Repository**:
    ```bash
    git clone https://github.com/bogdanene06/flower-management-application.git
    ```
2. **Configure the Database**:
    Set up a MySQL database and update the `application.properties` file with your database credentials.
3. **Build and Run the Application**:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```
4. **Access the Application**:
    Open your browser and navigate to [http://localhost:8080/index](http://localhost:8080/index).

## Contributing
If you want to contribute to this project, feel free to fork the repository and submit a pull request. All contributions are welcome!

## License
This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
