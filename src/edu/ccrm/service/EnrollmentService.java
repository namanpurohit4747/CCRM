package edu.ccrm.service;

import edu.ccrm.domain.Student;
import edu.ccrm.domain.Course;
import edu.ccrm.domain.Grade;
import java.util.*;

public class EnrollmentService {
    private final Map<String, Map<String, Grade>> enrollments = new HashMap<>(); // regNo -> (courseCode -> Grade)

    public void enrollStudent(Student student, Course course) {
        enrollments.computeIfAbsent(student.getRegNo(), k -> new HashMap<>()).put(course.getCode(), null);
    }

    public void unenrollStudent(Student student, Course course) {
        Map<String, Grade> studentCourses = enrollments.get(student.getRegNo());
        if (studentCourses != null) {
            studentCourses.remove(course.getCode());
        }
    }

    public void recordGrade(Student student, Course course, Grade grade) {
        Map<String, Grade> studentCourses = enrollments.get(student.getRegNo());
        if (studentCourses != null && studentCourses.containsKey(course.getCode())) {
            studentCourses.put(course.getCode(), grade);
        }
    }

    public double computeGPA(Student student) {
        Map<String, Grade> studentCourses = enrollments.get(student.getRegNo());
        if (studentCourses == null || studentCourses.isEmpty()) return 0.0;
        int totalPoints = 0;
        int totalCredits = 0;
        for (Map.Entry<String, Grade> entry : studentCourses.entrySet()) {
            Grade grade = entry.getValue();
            if (grade != null) {
                totalPoints += grade.getPoints();
                totalCredits++;
            }
        }
        return totalCredits == 0 ? 0.0 : (double) totalPoints / totalCredits;
    }

    public Map<String, Grade> getTranscript(Student student) {
        return enrollments.getOrDefault(student.getRegNo(), Collections.emptyMap());
    }
}
