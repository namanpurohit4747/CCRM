package edu.ccrm.io;

import edu.ccrm.domain.Student;
import edu.ccrm.domain.Course;
import java.nio.file.*;
import java.util.*;
import java.io.IOException;
import java.util.stream.Collectors;

public class ImportExportService {
    public List<Student> importStudents(Path filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        List<String> lines = Files.readAllLines(filePath);
        for (String line : lines) {
            String[] parts = line.split(",");
            Student s = new Student();
            s.setRegNo(parts[0]);
            s.setActive(Boolean.parseBoolean(parts[1]));
            // ...set other fields...
            students.add(s);
        }
        return students;
    }

    public void exportStudents(List<Student> students, Path filePath) throws IOException {
        List<String> lines = students.stream()
            .map(s -> s.getRegNo() + "," + s.isActive())
            .collect(Collectors.toList());
        Files.write(filePath, lines);
    }

    public List<Course> importCourses(Path filePath) throws IOException {
        List<Course> courses = new ArrayList<>();
        List<String> lines = Files.readAllLines(filePath);
        for (String line : lines) {
            String[] parts = line.split(",");
            Course c = new Course();
            c.setCode(parts[0]);
            c.setActive(Boolean.parseBoolean(parts[1]));
            // ...set other fields...
            courses.add(c);
        }
        return courses;
    }

    public void exportCourses(List<Course> courses, Path filePath) throws IOException {
        List<String> lines = courses.stream()
            .map(c -> c.getCode() + "," + c.isActive())
            .collect(Collectors.toList());
        Files.write(filePath, lines);
    }
}
