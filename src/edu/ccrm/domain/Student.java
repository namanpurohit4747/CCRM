package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.List;

public class Student extends Person {
    private String regNo;
    private boolean active;
    private List<String> enrolledCourses;
    private LocalDate enrollmentDate;
    @Override
    public void printProfile() {
        System.out.println("Student: " + getFullName());
    }
    public String getRegNo() {
        return regNo;
    }
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}
