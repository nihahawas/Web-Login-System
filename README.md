# 🔐 Web Login & Registration System

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
   
  ## 📸 Screenshots
   
### 🔐 Login Page
<img width="1210" height="620" alt="image" src="https://github.com/user-attachments/assets/dc6b8b16-4d1a-4cbb-b976-27abe162eeb1" />


### 📝 Signup Page
<img width="1250" height="740" alt="image" src="https://github.com/user-attachments/assets/a23631b1-3454-4e1a-b56f-d6fef4428ce4" />


### 🔑 Reset Password
<img width="1271" height="570" alt="image" src="https://github.com/user-attachments/assets/a1c271b3-2454-42f2-b1a5-97c6ba9888de" />


### 📊 Database View (PostgreSQL)
<img width="1464" height="584" alt="image" src="https://github.com/user-attachments/assets/09fcd253-f99e-4e2b-95bf-c967defbfc81" />


### 📌 Future Improvements

Security: Adding BCrypt password encryption for enhanced data protection.

API: Implementing a RESTful API version for cross-platform support.

UX: Adding real-time toast notifications for user actions (Success/Error messages).


# 👨‍💻 Author

Niha Hawas GitHub: https://github.com/nihahawas
