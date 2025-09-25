package edu.ccrm.service;

import edu.ccrm.domain.Course;
import java.util.*;
import java.util.stream.Collectors;

public class CourseService {
    private final Map<String, Course> courses = new HashMap<>();

    public void addCourse(Course course) {
        if (courses.containsKey(course.getCode())) {
            throw new IllegalArgumentException("Course already exists.");
        }
        courses.put(course.getCode(), course);
    }

    public List<Course> listCourses() {
        return new ArrayList<>(courses.values());
    }

    public Course getCourse(String code) {
        return courses.get(code);
    }

    public void updateCourse(String code, Course updated) {
        if (!courses.containsKey(code)) {
            throw new IllegalArgumentException("Course not found.");
        }
        courses.put(code, updated);
    }

    public void deactivateCourse(String code) {
        Course c = courses.get(code);
        if (c != null) {
            c.setActive(false);
        }
    }

    public List<Course> searchByInstructor(String instructor) {
        return courses.values().stream()
            .filter(c -> c.getInstructor().equalsIgnoreCase(instructor))
            .collect(Collectors.toList());
    }

    public List<Course> searchByDepartment(String department) {
        return courses.values().stream()
            .filter(c -> c.getDepartment().equalsIgnoreCase(department))
            .collect(Collectors.toList());
    }

    public List<Course> searchBySemester(String semester) {
        return courses.values().stream()
            .filter(c -> c.getSemester().equalsIgnoreCase(semester))
            .collect(Collectors.toList());
    }
}
