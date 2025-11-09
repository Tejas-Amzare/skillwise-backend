# 🚀 SkillWise Backend: Smart Talent Matching & Upskilling Platform

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)](https://github.com/Tejas-Amzare/skillwise-backend)
[![License](https://img.shields.io/badge/license-MIT-blue)](LICENSE)
[![Java Version](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0-blueviolet)](https://spring.io/projects/spring-boot)

---

📋 Overview

SkillWise is a backend system designed to intelligently connect job seekers with opportunities that best match their skills while providing personalized learning recommendations to help users upskill for career growth.

It features secure JWT authentication, role-based access control, post management, user dashboards, and an admin analytics system — built for scalable and data-driven recruitment or e-learning platforms.

🛠️ Technology Stack
Category	Technology
Backend Framework	Spring Boot 3
Language	Java 17
Database	MySQL / PostgreSQL (AWS RDS)
ORM	Spring Data JPA / Hibernate
Security	Spring Security + JWT
API Documentation	Swagger / OpenAPI
Cloud Deployment	AWS EC2, S3, SES
Build Tool	Maven
Validation	Jakarta Validation
🚀 Features
Core Functionality
🔐 Authentication & Authorization

User registration & login with JWT

Role-based access (USER, ADMIN)

Secure password encryption using BCrypt

👤 User Management

Update or delete user profiles

Fetch user details via JWT authorization

📝 Post Management

Create, read, update, and delete posts

View user-specific posts

Search posts by keywords

💡 Skill Matching & Learning

Skill-based job recommendations

Personalized upskilling course suggestions

📊 Analytics & Dashboard

Admin dashboards for monitoring user activity

Data-driven insights for system performance

🧠 Admin Functionalities

View all users

Manage user roles

Remove inactive or spam users

🧩 Technical Features

RESTful API architecture

Layered structure (Controller, Service, Repository)

Centralized exception handling

Input validation and clean response DTOs

📦 Project Structure
skillwise-backend/
├── config/
│   ├── SecurityConfig.java
│   ├── SwaggerConfig.java
│   └── jwt/
│       ├── JwtAuthFilter.java
│       └── JwtUtils.java
├── controller/
│   ├── AuthController.java
│   ├── UserController.java
│   ├── AdminController.java
│   └── PostController.java
├── entity/
│   ├── User.java
│   ├── Role.java
│   └── Post.java
├── repository/
│   ├── UserRepository.java
│   └── PostRepository.java
├── service/
│   ├── AuthService.java
│   ├── UserService.java
│   ├── PostService.java
│   └── CustomUserDetailsService.java
└── SkillWiseApplication.java

🔧 Setup & Installation
Prerequisites

Java 17 or higher

Maven 3.6+

MySQL or PostgreSQL

IDE (IntelliJ, Eclipse, VS Code)

Installation Steps

1️⃣ Clone the Repository

git clone https://github.com/Tejas-Amzare/skillwise-backend.git
cd skillwise-backend


2️⃣ Configure Database

spring.datasource.url=jdbc:mysql://localhost:3306/skillwise
spring.datasource.username=root
spring.datasource.password=yourpassword
jwt.secret=yourSecretKey


3️⃣ Build & Run

mvn clean install
mvn spring-boot:run


4️⃣ Access

Base URL: http://localhost:8080

Swagger UI: http://localhost:8080/swagger-ui/index.html

API Docs: http://localhost:8080/v3/api-docs

📚 API Endpoints
Authentication
Method	Endpoint	Description
POST	/api/auth/register	Register a new user
POST	/api/auth/login	Login & get JWT token
User
Method	Endpoint	Description
GET	/api/user/profile	Get logged-in user details
PUT	/api/user/update	Update profile
DELETE	/api/user/delete	Delete account
Admin
Method	Endpoint	Description
GET	/api/admin/users	Get all users
GET	/api/admin/user/{id}	Get user by ID
PUT	/api/admin/user/{id}/role	Update user role
DELETE	/api/admin/user/{id}	Delete user by ID
Posts
Method	Endpoint	Description
POST	/api/posts/createPost	Create a new post
GET	/api/posts/{id}	Get post by ID
PUT	/api/posts/{id}	Update post
DELETE	/api/posts/{id}	Delete post
GET	/api/posts/search	Search posts by keyword
GET	/api/posts/my-posts	Get logged-in user’s posts
🔐 Authentication

All secured endpoints require a JWT token in the header:

Authorization: Bearer <your_token>

📸 Visuals & Swagger UI
<img width="1716" height="755" alt="Postman 1" src="https://github.com/user-attachments/assets/2ead8e26-87c4-4c12-84f7-689ef69c1646" />
<img width="1681" height="744" alt="Postman 2" src="https://github.com/user-attachments/assets/2508a813-ad1b-44ae-9e24-d80403deb611" />
<img width="1639" height="376" alt="Postman 3" src="https://github.com/user-attachments/assets/28ae53a2-558b-4dca-91e5-d7fef8f87fc4" />
<img width="1696" height="863" alt="Postman 4" src="https://github.com/user-attachments/assets/cddedc1e-90ec-43a1-917c-f7e48275b979" />


🎯 Key Highlights for Resume

✅ RESTful API Development using Spring Boot

✅ JWT Authentication & Role-based Security

✅ MySQL/PostgreSQL Database Design

✅ AWS Deployment (EC2, S3, SES)

✅ Comprehensive Swagger Documentation

✅ Scalable Microservice Architecture

✅ Global Exception Handling & Input Validation

🔒 Security Features

JWT-based authentication

BCrypt password hashing

Role-based access control

CORS configuration

SQL injection prevention

Data validation & sanitization

📈 Future Enhancements

AI-based skill recommendation engine

Job posting approval workflow for admins

Email notifications via AWS SES

Integration with external job APIs

Analytics dashboards with charts

Resume parsing and profile scoring

📝 License

This project is licensed under the MIT License.

👤 Author

Tejas Gajanan Amzare

📧 Email: tejasamzare@gmail.com

🔗 LinkedIn: linkedin.com/in/tejas-amzare

💻 GitHub: github.com/Tejas-Amzare

Built with ❤️ using Spring Boot
