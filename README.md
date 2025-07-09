# ✅ Task Manager Backend

A RESTful backend API built with **Java** and **Spring Boot**, designed for managing tasks efficiently. This project demonstrates clean architecture using layered components, DTOs, soft deletion, and UUID-based identification — ideal for portfolios, freelance work, or real-world backend systems.

---

## 🚀 Features

- Create, read, update, and delete tasks
- Soft delete using an enum (`Deleted.TRUE / FALSE`)
- Retrieve tasks by unique `taskId`
- Clean DTO structure for API responses
- Built using standard Spring Boot architecture
- Easily extendable for user, project, or label modules

---

## 🛠 Tech Stack

| Technology        | Usage                     |
|-------------------|----------------------------|
| Java 17+          | Core language              |
| Spring Boot 3.x   | Application framework      |
| Spring Data JPA   | ORM layer (Hibernate)      |
| H2 / MySQL        | In-memory or relational DB |
| Lombok (optional) | Boilerplate reduction      |
| Postman           | API testing (optional)     |

---

## 📁 Project Structure

src/
├── controller/ # REST API endpoints
├── dto/ # TaskDto for clean API models
├── model/ # TaskManagement entity + enums
├── repository/ # Spring Data JPA interface
├── service/ # Business logic
└── TaskManagerApp.java # Main application


---

## 📦 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/your-username/task-manager-backend.git
cd task-manager-backend


2. Configure the database
The default config uses H2 in-memory database.

src/main/resources/application.properties
properties
Copy
Edit
spring.datasource.url=jdbc:h2:mem:taskdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
You can switch to MySQL or PostgreSQL by updating these values.

3. Run the application
Using Maven or your IDE:

bash
Copy
Edit
./mvnw spring-boot:run
Or run the main class:

Copy
Edit
TaskManagerApp.java
🔗 API Endpoints
Method	Endpoint	Description
GET	/tasks/{taskId}	Get task(s) by ID
POST	/tasks	Create a new task
PUT	/tasks/{taskId}	Update task details
DELETE	/tasks/{taskId}	Soft delete the task

All APIs exclude tasks marked as Deleted.TRUE.

📄 Sample DTO
java
Copy
Edit
public class TaskDto {
    private UUID taskId;
    private String taskName;
    private String taskDesc;
    private LocalDate taskCreationDate;
}
🧪 Testing
Use Postman or Swagger (if enabled) to test endpoints.

Example:

http
Copy
Edit
GET http://localhost:8080/tasks/d3b0c732-8f16-4d7e-92e6-b1fda3aaf407
🌱 Future Enhancements
Pagination and sorting

Search/filter by status, date, or assignee

Role-based authentication (Spring Security + JWT)

Swagger / OpenAPI documentation

Frontend integration with React or Angular

🤝 Contributing
Pull requests are welcome. Feel free to open issues to discuss bugs or feature enhancements.



👩‍💻 Author
Zeba Syed
Java Backend Developer | Spring Boot Enthusiast
GitHub





