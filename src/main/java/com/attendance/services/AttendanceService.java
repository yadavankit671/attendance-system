package com.attendance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private DataSource dataSource;

    public boolean markAttendance(String rollNumber, String macAddress) {
        if (verifyMacAddress(rollNumber, macAddress)) {
            String name = null;
            String fetchNameQuery = "SELECT name FROM students WHERE rollnumber = ?";
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement fetchNameStatement = connection.prepareStatement(fetchNameQuery)) {
                fetchNameStatement.setString(1, rollNumber);
                ResultSet resultSet = fetchNameStatement.executeQuery();
                if (resultSet.next()) {
                    name = resultSet.getString("name");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            markAttendance2(rollNumber, name);
            return true;
        }
        return false;
    }

    public boolean verifyMacAddress(String rollNumber, String macAddress) {
        String query = "SELECT * FROM device_verification WHERE roll_number = ? AND mac_address = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, rollNumber);
            statement.setString(2, macAddress);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void markAttendance2(String rollNumber, String name) {
        String query = "INSERT INTO attendance_list (roll_number, name, timestamp) VALUES (?, ?, NOW())";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, rollNumber);
            statement.setString(2, name);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getPresentStudents() {
        List<String> presentStudents = new ArrayList<>();
        String query = "SELECT rollnumber FROM device_verification";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                presentStudents.add(resultSet.getString("rollnumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return presentStudents;
    }
}