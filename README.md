# 🚀 SkillWise: Smart Talent Matching & Upskilling Platform

## 📖 Overview
SkillWise is a backend application that connects job seekers with opportunities through **skill-based job matching** and provides **personalized learning recommendations**.  
It includes **secure authentication, role-based access, dashboards, and admin analytics**.  

## 🛠 Tech Stack
- **Language:** Java 17  
- **Framework:** Spring Boot 3  
- **Database:** MySQL / PostgreSQL (AWS RDS)  
- **Authentication:** Spring Security with JWT  
- **Documentation:** Swagger / OpenAPI  
- **Deployment:** AWS EC2, S3, SES  

## ✨ Features
- 🔐 User Authentication (Register/Login with JWT)  
- 👤 Role-based access (User & Admin)  
- 📝 User profile management (update, delete)  
- 📌 Skill-based job matching system  
- 📚 Personalized learning recommendations  
- 📊 Dashboard for users and admins  
- 👨‍💼 Admin panel for managing users and analytics  

## 📂 Project Structure
skillwise-backend/
┣ src/main/java/com/skillwise/
┃ ┣ config/ # Security & JWT config
┃ ┣ controller/ # REST APIs
┃ ┣ entity/ # Database models
┃ ┣ repository/ # JPA Repositories
┃ ┣ service/ # Business logic
┃ ┗ SkillwiseApplication.java
┣ src/main/resources/
┃ ┣ application.properties
┣ pom.xml
┗ README.md

## 🔑 API Endpoints (Sample)
### Auth
- `POST /api/auth/register` → Register new user  
- `POST /api/auth/login` → Login & get JWT token  

### User
- `GET /api/user/profile` → Get user profile  
- `PUT /api/user/update` → Update profile  
- `DELETE /api/user/delete` → Delete account  

### Admin
- `GET /api/admin/users` → List all users  
- `GET /api/admin/user/{id}` → Get user by ID  
- `DELETE /api/admin/user/{id}` → Delete user  

## ⚙️ Setup & Installation
1. Clone repo:  
   ```bash
   git clone https://github.com/Tejas-Amzare/skillwise-backend.git
   cd skillwise-backend

2.Configure application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/skillwise
spring.datasource.username=root
spring.datasource.password=yourpassword
jwt.secret=yourSecretKey

3.Run with Maven:
mvn spring-boot:run

4.Access APIs at:
http://localhost:8080/swagger-ui/index.html

📸 Screenshots
Swagger UI  :- 
<img width="1716" height="755" alt="Postman 1" src="https://github.com/user-attachments/assets/3deda88b-cf0a-4d96-b1e3-ebe432749b48" />
<img width="1681" height="744" alt="Postman 2" src="https://github.com/user-attachments/assets/a975e7bc-2a7c-452c-8a8a-5c3f91653457" />
<img width="1639" height="376" alt="Postman 3" src="https://github.com/user-attachments/assets/d35bae73-d872-42b6-b8fd-3b5f0b5dc13e" />
<img width="1696" height="863" alt="Postman 4" src="https://github.com/user-attachments/assets/7b6980e0-6af2-4520-8624-d83398229c60" />




🙋‍♂️ Author
Tejas Gajanan Amzare
📧 tejasamzare@gmail.com
🔗 LinkedIn -https://www.linkedin.com/in/tejas-amzare/

