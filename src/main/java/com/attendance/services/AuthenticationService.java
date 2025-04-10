package com.attendance.services;

import com.attendance.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Service
public class AuthenticationService {

    @Autowired
    private DataSource dataSource;

    public Teacher authenticate(String username, String password) {
        String query = "SELECT username, name FROM teacher WHERE username = ? AND password = ?";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setUsername(resultSet.getString("username"));
                System.out.println("Authentication successful for user: " + username);
                return teacher;
            } else {
                System.out.println("Invalid username or password for user: " + username);
            }
        } catch (Exception e) {
            System.err.println("Error during authentication: " + e.getMessage());
            e.printStackTrace(); // Replace with proper logging in production
        }
        return null;
    }
}