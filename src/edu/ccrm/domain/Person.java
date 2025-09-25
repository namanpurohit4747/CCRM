package edu.ccrm.domain;

public abstract class Person {
    private String id;
    protected String fullName;
    private String email;

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    // ...other fields...
    public abstract void printProfile();
}
