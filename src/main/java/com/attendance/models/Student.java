package com.attendance.models;

public class Student {
    private String rollNumber;
    private String macAddress;

    public Student() {
    }

    public Student(String rollNumber, String macAddress) {
        this.rollNumber = rollNumber;
        this.macAddress = macAddress;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
}