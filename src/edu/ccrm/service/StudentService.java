package edu.ccrm.service;

import edu.ccrm.domain.Student;
import java.util.*;

public class StudentService {
    private final Map<String, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        if (students.containsKey(student.getRegNo())) {
            throw new IllegalArgumentException("Student already exists.");
        }
        students.put(student.getRegNo(), student);
    }

    public List<Student> listStudents() {
        return new ArrayList<>(students.values());
    }

    public Student getStudent(String regNo) {
        return students.get(regNo);
    }

    public void updateStudent(String regNo, Student updated) {
        if (!students.containsKey(regNo)) {
            throw new IllegalArgumentException("Student not found.");
        }
        students.put(regNo, updated);
    }

    public void deactivateStudent(String regNo) {
        Student s = students.get(regNo);
        if (s != null) {
            s.setActive(false);
        }
    }
}
