# Attendance System

This project is a simple attendance management system designed for a college environment. It allows teachers to manage student attendance and enables students to mark their attendance using their devices.

## Project Structure

The project is structured as follows:

```
attendance-system
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   └── attendance
│   │   │   │       ├── controllers
│   │   │   │       │   ├── StudentController.java
│   │   │   │       │   └── TeacherController.java
│   │   │   │       ├── models
│   │   │   │       │   ├── Student.java
│   │   │   │       │   └── Teacher.java
│   │   │   │       ├── services
│   │   │   │       │   ├── AttendanceService.java
│   │   │   │       │   └── AuthenticationService.java
│   │   │   │       └── utils
│   │   │   │           └── DatabaseConnection.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── templates
│   │           ├── index.html
│   │           ├── teacher-login.html
│   │           ├── teacher-dashboard.html
│   │           └── student-page.html
├── pom.xml
├── README.md
└── webapp
    ├── WEB-INF
    │   ├── web.xml
    └── static
        ├── css
        │   └── styles.css
        └── js
            └── scripts.js
```

## Features

- **Teacher Login**: Teachers can log in using their username and password to access the attendance dashboard.
- **Real-Time Attendance**: Teachers can view a real-time list of students who have marked themselves present.
- **Student Attendance**: Students can enter their roll number to mark their attendance, which is verified against their device's MAC address.

## Database

The application uses MySQL 8 as the database. The database name is `attendance_system`. The following tables are used:

- **teacher**: Stores teacher credentials (username and password).
- **attendance_list**: Stores attendance records of students.
- **mac_verification**: Stores roll numbers and corresponding MAC addresses for device verification.

## Setup Instructions

1. **Clone the Repository**: 
   ```
   Clone the repository to your local machine.
   ```

2. **Configure Database**: 
   Update the `application.properties` file with your MySQL database connection details.

3. **Build the Project**: 
   Use Maven to build the project:
   ```
   mvn clean install
   ```

4. **Deploy on Apache Tomcat**: 
   Deploy the generated WAR file in the `webapp` directory to your Apache Tomcat server.

5. **Run the Application**: 
   Start the Tomcat server and access the application at `http://localhost:8080/attendance-system`.

## Usage

- Navigate to the main page and choose either the Teacher or Student option.
- Teachers can log in to view attendance.
- Students can enter their roll number to mark their attendance.

## License

This project is for educational purposes only and is not intended for production use.