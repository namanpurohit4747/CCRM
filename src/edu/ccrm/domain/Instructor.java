package edu.ccrm.domain;

public class Instructor extends Person {
    private String department;
    @Override
    public void printProfile() {
        System.out.println("Instructor: " + getFullName());
    }
    // ...getters/setters...
}
