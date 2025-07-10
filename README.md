# 🎓 Internship Application Tracker – JDBC Mini Project

This is a Java-based console application that allows **students** to register and apply for internships, while **admins** can post new internships and manage applications.

Built using:
- Java (Core + JDBC)
- MySQL
- Console-based User Interface

---

## 📁 Project Structure

```markdowm
src/
├── model/
│ ├── Student.java
│ ├── Internship.java
│ └── Application.java
│
├── dao/
│ ├── StudentDAO.java
│ ├── InternshipDAO.java
│ ├── ApplicationDAO.java
│ └── DBConnection.java
│
├── Main.java
└── schema.sql
```

---

## ⚙️ Features

### 👨‍🎓 Student
- Register with name, email, phone, resume link
- View available internships
- Apply to internships
- View application status

### 🛠 Admin
- Add new internships
- View applications by student ID
- Update application status (Accepted/Rejected)

---

## 🏁 Getting Started

### ✅ 1. Setup MySQL

Run the `schema.sql` file in your MySQL terminal or Workbench:

```sql
SOURCE path/to/schema.sql;
```
### ✅ 2. **Clone the repository:**

   ```bash
   git clone https://github.com/SriHarsha1405/Internship-Application-Tracker.git
   cd Internship-Application-Tracker
```

### ✅ 3. **Update DBConnection.java**

   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/internship_db?user=root";
   private static final String USER = "root";
   private static final String PASSWORD = ""; // your MySQL password
```

### ✅ 4. **Add JDBC Driver**
```
Download the MySQL JDBC driver:
🔗 https://dev.mysql.com/downloads/connector/j/
```
Then add the .jar to your project:

IntelliJ: File > Project Structure > Libraries

Eclipse: Build Path > Add External JARs

CLI: use -cp with the jar file


### ▶️ 5. **Run the Application**
```bash
javac -cp ".:mysql-connector-java-8.x.x.jar" model/*.java dao/*.java Main.java
java -cp ".:mysql-connector-java-8.x.x.jar" Main
```

### 🛡 **Sample Login Flow**
```text
👋 Welcome to Internship Application Tracker
Select Role:
1. Student
2. Admin
3. Exit
```

### 📌 **Future Improvements (Optional)**
Add login system with username/password

Build GUI using JavaFX or Swing

Convert to web app using JSP/Servlets or Spring Boot

### 👨‍💻 **Author**
Developed by: https://github.com/SriHarsha1405
📧 Email: madem.harsha2004@gmail.com

