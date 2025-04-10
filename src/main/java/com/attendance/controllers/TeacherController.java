package com.attendance.controllers;

import com.attendance.models.Teacher;
import com.attendance.services.AuthenticationService;
//import com.attendance.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
//import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    // private AttendanceService attendanceService;

    @GetMapping("/teacher/login")
    public String showLoginPage() {
        return "teacher-login"; // Renders the teacher-login.html page
    }

    @PostMapping("/teacher/login")
    @ResponseBody
    public Map<String, Object> login(@RequestBody Map<String, String> loginRequest, HttpSession session) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        Teacher teacher = authenticationService.authenticate(username, password);
        Map<String, Object> response = new HashMap<>();
        if (teacher != null) {
            session.setAttribute("teacher", teacher);
            response.put("success", true);
            response.put("message", "Login successful");
        } else {
            response.put("success", false);
            response.put("message", "Invalid username or password");
        }
        return response;
    }

    @GetMapping("/teacher/dashboard")
    public String showDashboard(HttpSession session, Model model) {
        // Check if the teacher is logged in
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        if (teacher == null) {
            return "redirect:/teacher/login"; // Redirect to login if not authenticated
        }

        // Add teacher details to the model for the dashboard
        model.addAttribute("teacher", teacher);
        return "teacher-dashboard"; // Renders the teacher-dashboard.html page
    }

    @GetMapping("/teacher/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/teacher/login";
    }
}