# 🚀 SkillWise Backend: Smart Talent Matching & Upskilling Platform

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)](https://github.com/Tejas-Amzare/skillwise-backend)
[![License](https://img.shields.io/badge/license-MIT-blue)](LICENSE)
[![Java Version](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0-blueviolet)](https://spring.io/projects/spring-boot)

---

## 📖 Overview
**SkillWise** is a backend application designed to **connect job seekers with relevant opportunities based on their skills** and provide **personalized learning recommendations** to improve career growth.  

It features **secure authentication, role-based access, dashboards, and admin analytics**, making it suitable for modern HR and recruitment systems.

---

## 📌 Table of Contents
- [Tech Stack](#-tech-stack)
- [Features](#-features)
- [Project Structure](#-project-structure)
- [Installation](#-installation)
- [Usage](#-usage)
- [API Endpoints](#-api-endpoints)
- [Visuals](#-visuals)
- [Contributing](#-contributing)
- [License](#-license)
- [Contact](#-contact)

---

## 🛠 Tech Stack
- **Language:** Java 17  
- **Framework:** Spring Boot 3  
- **Database:** MySQL / PostgreSQL (AWS RDS)  
- **Authentication:** Spring Security with JWT  
- **Documentation:** Swagger / OpenAPI  
- **Deployment:** AWS EC2, S3, SES  

---

## ✨ Features
- 🔐 User Authentication (Register/Login with JWT)  
- 👤 Role-based access (User & Admin)  
- 📝 User profile management (update, delete)  
- 📌 Skill-based job matching system  
- 📚 Personalized learning recommendations  
- 📊 Dashboard for users and admins  
- 👨‍💼 Admin panel for managing users and analytics  

---

## 📂 Project Structure
skillwise-backend/
┣ src/main/java/com/skillwise/
┃ ┣ config/ # Security & JWT configuration
┃ ┣ controller/ # REST APIs
┃ ┣ entity/ # Database models
┃ ┣ repository/ # JPA Repositories
┃ ┣ service/ # Business logic
┃ ┗ SkillwiseApplication.java
┣ src/main/resources/
┃ ┗ application.properties
┣ pom.xml
┗ README.md



---

## ⚙️ Installation
### Prerequisites
- Java 17
- Maven 3+
- MySQL or PostgreSQL installed
- Postman (optional, for API testing)

### Steps
1. Clone the repository:

git clone https://github.com/Tejas-Amzare/skillwise-backend.git
cd skillwise-backend
Configure application.properties:


spring.datasource.url=jdbc:mysql://localhost:3306/skillwise
spring.datasource.username=root
spring.datasource.password=yourpassword
jwt.secret=yourSecretKey
Run the application with Maven:


mvn spring-boot:run
Access Swagger UI:



http://localhost:8080/swagger-ui/index.html
💻 Usage
Once running, you can test API endpoints using Swagger or Postman. Example requests:

Register a User

POST /api/auth/register
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "Password123"
}


Login


POST /api/auth/login
Content-Type: application/json

{
  "email": "john@example.com",
  "password": "Password123"
}
Get User Profile (Authorized)


GET /api/user/profile
Authorization: Bearer <JWT_TOKEN>
🔑 API Endpoints (Sample)
Auth
Method	Endpoint	Description
POST	/api/auth/register	Register new user
POST	/api/auth/login	Login & get JWT

User
Method	Endpoint	Description
GET	/api/user/profile	Get user profile
PUT	/api/user/update	Update profile
DELETE	/api/user/delete	Delete account

Admin
Method	Endpoint	Description
GET	/api/admin/users	List all users
GET	/api/admin/user/{id}	Get user by ID
DELETE	/api/admin/user/{id}	Delete user
PUT	/api/admin/user/{id}/role	Update user role

Posts
Method	Endpoint	Description
POST	/api/posts/createPost	Create new post
GET	/api/posts/{id}	Get post by ID
PUT	/api/posts/{id}	Update post by ID
DELETE	/api/posts/{id}	Delete post by ID
GET	/api/posts/search	Search posts by keyword
GET	/api/posts/my-posts	Get user's posts

📸 Visuals
Swagger UI

<img width="1716" height="755" alt="Postman 1" src="https://github.com/user-attachments/assets/d8e1c36a-39da-43e9-a9e7-19d32ea00288" />

Browse all endpoints and test APIs easily.

Sample Postman Requests

<img width="1681" height="744" alt="Postman 2" src="https://github.com/user-attachments/assets/cbd7e227-d682-40d4-8627-87e0f06f04c7" />

<img width="1639" height="376" alt="Postman 3" src="https://github.com/user-attachments/assets/04f7de33-ec4b-4e7b-aeb3-ba897b395f62" />

<img width="1696" height="863" alt="Postman 4" src="https://github.com/user-attachments/assets/e1afbeb3-3981-49d6-9acf-cefd65349e68" />


🤝 Contributing
Contributions are welcome! Please follow these steps:

Fork the repository

Create a feature branch (git checkout -b feature-name)

Commit your changes (git commit -m "Add feature")

Push to the branch (git push origin feature-name)

Open a Pull Request

📝 License
This project is licensed under the MIT License - see the LICENSE file for details.

📫 Contact
Tejas Gajanan Amzare
📧 Email: tejasamzare@gmail.com
🔗 LinkedIn: https://www.linkedin.com/in/tejas-amzare
