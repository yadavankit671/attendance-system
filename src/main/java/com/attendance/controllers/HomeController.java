package com.attendance.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // This will look for src/main/resources/templates/index.html
    }

    @GetMapping("/teacher-login")
    public String teacherLogin() {
        return "teacher-login"; // This will look for src/main/resources/templates/teacher-login.html
    }

    @GetMapping("/student-page")
    public String studentPage() {
        return "student-page"; // This will look for src/main/resources/templates/student-page.html
    }

    @GetMapping("/teacher-dashboard")
    public String teacherDashboard() {
        return "teacher-dashboard"; // This will look for src/main/resources/templates/teacher-dashboard.html
    }
}