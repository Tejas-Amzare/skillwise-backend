# 🚀 SkillWise Backend

SkillWise is a **smart talent matching & upskilling platform** built with **Java Spring Boot**.  
It provides secure authentication, user management, and a full **Post (CRUD + pagination + search)** module with JWT-based access control.

This project showcases my **backend development skills** in designing scalable APIs, applying best practices, and integrating security with real-world patterns.

---

## ✨ Features
- 🔐 **JWT Authentication & Role-based Access**
  - User & Admin roles
  - Secure login & registration
- 👤 **User Management**
  - Register, login, update, delete
  - Admin-only user operations
- 📝 **Post Management (CRUD)**
  - Create, read, update, delete posts
  - Only authors can edit/delete their posts
- 🔎 **Advanced Post Features**
  - Pagination & sorting
  - Search posts by title/content
  - Fetch "My Posts" (logged-in user)
- 📖 **Swagger API Documentation**
  - All APIs documented and testable at `/swagger-ui.html`

---

## 🛠️ Tech Stack
- **Backend**: Java 17, Spring Boot 3  
- **Security**: Spring Security + JWT  
- **Database**: MySQL (JPA/Hibernate)  
- **Docs**: Swagger / OpenAPI  
- **Build Tool**: Maven  
- **Other**: Lombok, Validation  

---

## ⚙️ Setup & Run

### 1️⃣ Clone Repo
```bash
git clone https://github.com/your-username/skillwise-backend.git
cd skillwise-backend
2️⃣ Configure Database

Create a MySQL database:

CREATE DATABASE skillwise_db;


Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/skillwise_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

3️⃣ Run App
mvn spring-boot:run


App runs at: http://localhost:8080

Swagger Docs: http://localhost:8080/swagger-ui.html

📸 Swagger Preview

(Add screenshot here)
<img width="1716" height="755" alt="Postman 1" src="https://github.com/user-attachments/assets/2d84206f-8eb2-4875-bf6b-b2bf832348c3" />
<img width="1681" height="744" alt="Postman 2" src="https://github.com/user-attachments/assets/e25da717-2e90-4486-9767-d000aa3fcdf0" />
<img width="1639" height="376" alt="Postman 3" src="https://github.com/user-attachments/assets/18cfb159-8ecb-4a95-a114-9b4bf1b59d73" />
<img width="1696" height="863" alt="Postman 4" src="https://github.com/user-attachments/assets/956e0ca5-48fd-4869-93b1-9b813125a571" />



Open Swagger UI:
👉 http://localhost:8080/swagger-ui.html

📌 API Endpoints
🔐 Authentication

POST /api/auth/register → Register new user

POST /api/auth/login → Login & get JWT

👤 User APIs

PUT /api/user/update → Update profile

DELETE /api/user/delete → Delete account

GET /api/admin/users → Admin: Get all users

GET /api/admin/user/{id} → Admin: Get user by ID

📝 Post APIs

POST /api/posts/createPost → Create post (auth required)

GET /api/posts/getAll → Get all posts (with pagination/sorting)

GET /api/posts/{id} → Get post by ID

PUT /api/posts/{id} → Update post (author only)

DELETE /api/posts/{id} → Delete post (author only)

GET /api/posts/search?query=java → Search posts

GET /api/posts/myPosts → Get logged-in user’s posts
👨‍💻 Author

Tejas Amzare
🔗 LinkedIn | GitHub
