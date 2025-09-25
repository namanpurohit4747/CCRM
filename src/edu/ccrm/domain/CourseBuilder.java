package edu.ccrm.domain;

public class CourseBuilder {
    private String code;
    private String title;
    private int credits;
    private String instructor;
    private String semester;
    private String department;
    private boolean active = true;

    public CourseBuilder setCode(String code) {
        this.code = code;
        return this;
    }
    public CourseBuilder setTitle(String title) {
        this.title = title;
        return this;
    }
    public CourseBuilder setCredits(int credits) {
        this.credits = credits;
        return this;
    }
    public CourseBuilder setInstructor(String instructor) {
        this.instructor = instructor;
        return this;
    }
    public CourseBuilder setSemester(String semester) {
        this.semester = semester;
        return this;
    }
    public CourseBuilder setDepartment(String department) {
        this.department = department;
        return this;
    }
    public CourseBuilder setActive(boolean active) {
        this.active = active;
        return this;
    }
    public Course build() {
        Course c = new Course();
        c.setCode(code);
        c.setTitle(title);
        c.setCredits(credits);
        c.setInstructor(instructor);
        c.setSemester(semester);
        c.setDepartment(department);
        c.setActive(active);
        return c;
    }
}
