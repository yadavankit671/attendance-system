package com.attendance.controllers;

//import com.attendance.models.Student;
import com.attendance.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
//import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/mark-attendance")
    public String markAttendance(@RequestParam String rollNumber, HttpServletRequest request) {
        String macAddress = request.getRemoteAddr(); // Simplified for demonstration
        boolean isMarked = attendanceService.markAttendance(rollNumber, macAddress);
        return isMarked ? "Attendance marked successfully." : "Failed to mark attendance.";
    }

    // @GetMapping("/attendance-list")
    // public List<Student> getAttendanceList() {
    //     return attendanceService.getAttendanceList();
    // }
}