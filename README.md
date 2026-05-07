# 🔐 Login & Registration System

A full-stack user authentication and management system built using **Java Servlets**, **JSP**, **JPA/Hibernate**, and **PostgreSQL**. This project demonstrates a secure login and registration flow with complete user CRUD operations and a modern frontend interface.

## 🚀 Features

* **User Authentication:** Secure login validation against a persistent database.
* **Account Registration:** Dynamic signup flow with real-time backend validation.
* **CRUD Operations:** Complete management for creating, reading, updating, and deleting user records.
* **Session Management:** Utilizes Java Servlets to maintain user states and secure restricted pages.
* **MVC Architecture:** Clean separation of concerns using the Model-View-Controller pattern.
* **DAO Pattern:** Centralized data access logic using the Data Access Object pattern.
* **Responsive UI:** Modern, clean frontend with light/dark mode support and intuitive navigation.

## 🛠️ Tech Stack

* **Backend:** Java Servlets, JPA (Java Persistence API) / Hibernate
* **Frontend:** HTML5, CSS3, JavaScript (ES6), JSP
* **Database:** PostgreSQL (Managed via DBeaver/pgAdmin)
* **Server:** Apache Tomcat 10.x
* **Build Tool:** Maven

## 📂 Project Structure

* `dao/` → Database operations & persistence logic (`UserDao.java`)
* `model/` → Data models and Entity classes (`User.java`)
* `web/` → Servlets handling HTTP requests and routing (`UserServlet.java`, `LoginServlet.java`)
* `webapp/` → User Interface assets (JSP files, HTML, CSS, and JS)

## ⚙️ Setup Instructions

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/nihahawas/Web-Login-System.git]
   
   📸 Screenshots
   
🔐 Login Page
(<img width="1210" height="620" alt="image" src="https://github.com/user-attachments/assets/dc6b8b16-4d1a-4cbb-b976-27abe162eeb1" />
)

📝 Signup Page
()

🏠 User Dashboard
(Drag and drop your Dashboard/User List screenshot here)

📊 Database View (PostgreSQL)
(Drag and drop a screenshot of your PostgreSQL table here)

📌 Future Improvements
Security: Adding BCrypt password encryption for enhanced data protection.

API: Implementing a RESTful API version for cross-platform support.

UX: Adding real-time toast notifications for user actions (Success/Error messages).

👨‍💻 Author
Niha GitHub: https://github.com/nihahawas
