package edu.ccrm.cli;

public class Menu {
    private final edu.ccrm.io.ImportExportService importExportService = new edu.ccrm.io.ImportExportService();
    private final edu.ccrm.io.BackupService backupService = new edu.ccrm.io.BackupService();
    private final edu.ccrm.service.EnrollmentService enrollmentService = new edu.ccrm.service.EnrollmentService();
    private final edu.ccrm.service.StudentService studentService = new edu.ccrm.service.StudentService();
    private final edu.ccrm.service.CourseService courseService = new edu.ccrm.service.CourseService();

    public void start() {
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            while (true) {
                System.out.println("\n--- CCRM Main Menu ---");
                System.out.println("1. Manage Students");
                System.out.println("2. Manage Courses");
                System.out.println("3. Enrollment & Grades");
                System.out.println("4. Import/Export Data");
                System.out.println("5. Backup & Reports");
                System.out.println("6. Platform Note");
                System.out.println("7. Reports");
                System.out.println("0. Exit");
                System.out.print("Select an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1: manageStudents(scanner); break;
                    case 2: manageCourses(scanner); break;
                    case 3: manageEnrollment(scanner); break;
                    case 4: manageFileOperations(scanner); break;
                    case 5: manageBackupAndReports(scanner); break;
                    case 6: System.out.println("Java SE vs ME vs EE: See README.md for details."); break;
                    case 7: manageReports(scanner); break;
                    case 0: System.out.println("Exiting CCRM. Goodbye!"); return;
                    default: System.out.println("Invalid option. Try again."); break;
                }
            }
        }
    }

    private void manageCourses(java.util.Scanner scanner) {
        while (true) {
            System.out.println("\n--- Course Management ---");
            System.out.println("1. Add Course");
            System.out.println("2. List Courses");
            System.out.println("3. Update Course");
            System.out.println("4. Deactivate Course");
            System.out.println("0. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter course code: ");
                    String code = scanner.nextLine();
                    System.out.print("Enter course title: ");
                    String title = scanner.nextLine();
                    edu.ccrm.domain.Course course = new edu.ccrm.domain.Course();
                    course.setCode(code);
                    course.setTitle(title);
                    course.setActive(true);
                    courseService.addCourse(course);
                    System.out.println("Course added.");
                    break;
                case 2:
                    System.out.println("List of courses:");
                    for (edu.ccrm.domain.Course c : courseService.listCourses()) {
                        System.out.println("Code: " + c.getCode() + ", Title: " + c.getTitle() + ", Active: " + c.isActive());
                    }
                    break;
                case 3:
                    System.out.print("Enter course code to update: ");
                    String updateCode = scanner.nextLine();
                    edu.ccrm.domain.Course existing = courseService.getCourse(updateCode);
                    if (existing == null) {
                        System.out.println("Course not found.");
                        break;
                    }
                    System.out.print("Enter new course title: ");
                    String newTitle = scanner.nextLine();
                    existing.setTitle(newTitle);
                    courseService.updateCourse(updateCode, existing);
                    System.out.println("Course updated.");
                    break;
                case 4:
                    System.out.print("Enter course code to deactivate: ");
                    String deactivateCode = scanner.nextLine();
                    courseService.deactivateCourse(deactivateCode);
                    System.out.println("Course deactivated.");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
    // Removed duplicate field and method definitions

    // All manage* methods are placed below, inside the Menu class
    // ...existing code for manageStudents, manageCourses, manageEnrollment, manageFileOperations, manageBackupAndReports, manageReports...
    private void manageEnrollment(java.util.Scanner scanner) {
        while (true) {
            System.out.println("\n--- Enrollment & Grading ---");
            System.out.println("1. Enroll Student in Course");
            System.out.println("2. Unenroll Student from Course");
            System.out.println("3. Record Grade");
            System.out.println("4. Compute GPA");
            System.out.println("5. Print Transcript");
            System.out.println("0. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter student regNo: ");
                    String regNo = scanner.nextLine();
                    System.out.print("Enter course code: ");
                    String code = scanner.nextLine();
                    edu.ccrm.domain.Student student = studentService.getStudent(regNo);
                    edu.ccrm.domain.Course course = courseService.getCourse(code);
                    if (student == null || course == null) {
                        System.out.println("Student or course not found.");
                        break;
                    }
                    enrollmentService.enrollStudent(student, course);
                    System.out.println("Student enrolled in course.");
                    break;
                case 2:
                    System.out.print("Enter student regNo: ");
                    String regNoUnenroll = scanner.nextLine();
                    System.out.print("Enter course code: ");
                    String codeUnenroll = scanner.nextLine();
                    edu.ccrm.domain.Student studentUnenroll = studentService.getStudent(regNoUnenroll);
                    edu.ccrm.domain.Course courseUnenroll = courseService.getCourse(codeUnenroll);
                    if (studentUnenroll == null || courseUnenroll == null) {
                        System.out.println("Student or course not found.");
                        break;
                    }
                    enrollmentService.unenrollStudent(studentUnenroll, courseUnenroll);
                    System.out.println("Student unenrolled from course.");
                    break;
                case 3:
                    System.out.print("Enter student regNo: ");
                    String regNoGrade = scanner.nextLine();
                    System.out.print("Enter course code: ");
                    String codeGrade = scanner.nextLine();
                    System.out.print("Enter grade (S/A/B/C/D/E/F): ");
                    String gradeStr = scanner.nextLine();
                    edu.ccrm.domain.Student studentGrade = studentService.getStudent(regNoGrade);
                    edu.ccrm.domain.Course courseGrade = courseService.getCourse(codeGrade);
                    if (studentGrade == null || courseGrade == null) {
                        System.out.println("Student or course not found.");
                        break;
                    }
                    edu.ccrm.domain.Grade grade;
                    try {
                        grade = edu.ccrm.domain.Grade.valueOf(gradeStr);
                    } catch (Exception e) {
                        System.out.println("Invalid grade.");
                        break;
                    }
                    enrollmentService.recordGrade(studentGrade, courseGrade, grade);
                    System.out.println("Grade recorded.");
                    break;
                case 4:
                    System.out.print("Enter student regNo: ");
                    String regNoGPA = scanner.nextLine();
                    edu.ccrm.domain.Student studentGPA = studentService.getStudent(regNoGPA);
                    if (studentGPA == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    double gpa = enrollmentService.computeGPA(studentGPA);
                    System.out.println("GPA: " + gpa);
                    break;
                case 5:
                    System.out.print("Enter student regNo: ");
                    String regNoTranscript = scanner.nextLine();
                    edu.ccrm.domain.Student studentTranscript = studentService.getStudent(regNoTranscript);
                    if (studentTranscript == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    System.out.println("Transcript for " + studentTranscript.getFullName() + ":");
                    java.util.Map<String, edu.ccrm.domain.Grade> transcript = enrollmentService.getTranscript(studentTranscript);
                    for (java.util.Map.Entry<String, edu.ccrm.domain.Grade> entry : transcript.entrySet()) {
                        System.out.println("Course: " + entry.getKey() + ", Grade: " + (entry.getValue() != null ? entry.getValue().name() : "N/A"));
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
    // Removed misplaced case statements
    private void manageReports(java.util.Scanner scanner) {
        while (true) {
            System.out.println("\n--- Reports ---");
            System.out.println("1. Top Students by GPA");
            System.out.println("2. GPA Distribution");
            System.out.println("0. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    java.util.List<edu.ccrm.domain.Student> students = studentService.listStudents();
                    students.stream()
                        .filter(edu.ccrm.domain.Student::isActive)
                        .sorted((s1, s2) -> Double.compare(enrollmentService.computeGPA(s2), enrollmentService.computeGPA(s1)))
                        .limit(5)
                        .forEach(s -> System.out.println("RegNo: " + s.getRegNo() + ", Name: " + s.getFullName() + ", GPA: " + enrollmentService.computeGPA(s)));
                    break;
                case 2:
                    java.util.Map<Double, Long> gpaDist = studentService.listStudents().stream()
                        .filter(edu.ccrm.domain.Student::isActive)
                        .collect(java.util.stream.Collectors.groupingBy(enrollmentService::computeGPA, java.util.stream.Collectors.counting()));
                    System.out.println("GPA Distribution:");
                    gpaDist.forEach((gpa, count) -> System.out.println("GPA: " + gpa + " - Students: " + count));
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
    private void manageFileOperations(java.util.Scanner scanner) {
        while (true) {
            System.out.println("\n--- Import/Export Data ---");
            System.out.println("1. Import Students from CSV");
            System.out.println("2. Export Students to CSV");
            System.out.println("3. Import Courses from CSV");
            System.out.println("4. Export Courses to CSV");
            System.out.println("0. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter file path to import students: ");
                        String importPath = scanner.nextLine();
                        java.util.List<edu.ccrm.domain.Student> importedStudents = importExportService.importStudents(java.nio.file.Paths.get(importPath));
                        for (edu.ccrm.domain.Student s : importedStudents) {
                            studentService.addStudent(s);
                        }
                        System.out.println("Students imported.");
                        break;
                    case 2:
                        System.out.print("Enter file path to export students: ");
                        String exportPath = scanner.nextLine();
                        importExportService.exportStudents(studentService.listStudents(), java.nio.file.Paths.get(exportPath));
                        System.out.println("Students exported.");
                        break;
                    case 3:
                        System.out.print("Enter file path to import courses: ");
                        String importCoursePath = scanner.nextLine();
                        java.util.List<edu.ccrm.domain.Course> importedCourses = importExportService.importCourses(java.nio.file.Paths.get(importCoursePath));
                        for (edu.ccrm.domain.Course c : importedCourses) {
                            courseService.addCourse(c);
                        }
                        System.out.println("Courses imported.");
                        break;
                    case 4:
                        System.out.print("Enter file path to export courses: ");
                        String exportCoursePath = scanner.nextLine();
                        importExportService.exportCourses(courseService.listCourses(), java.nio.file.Paths.get(exportCoursePath));
                        System.out.println("Courses exported.");
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void manageBackupAndReports(java.util.Scanner scanner) {
        while (true) {
            System.out.println("\n--- Backup & Reports ---");
            System.out.println("1. Backup Data");
            System.out.println("2. Show Backup Size");
            System.out.println("0. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter source directory to backup: ");
                        String sourceDir = scanner.nextLine();
                        System.out.print("Enter backup root directory: ");
                        String backupRoot = scanner.nextLine();
                        java.nio.file.Path backupDir = backupService.backupData(java.nio.file.Paths.get(sourceDir), java.nio.file.Paths.get(backupRoot));
                        System.out.println("Backup completed to: " + backupDir);
                        break;
                    case 2:
                        System.out.print("Enter backup directory to compute size: ");
                        String backupSizeDir = scanner.nextLine();
                        long size = backupService.computeBackupSize(java.nio.file.Paths.get(backupSizeDir));
                        System.out.println("Total backup size: " + size + " bytes");
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    // Removed misplaced case statements

    private void manageStudents(java.util.Scanner scanner) {
        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Update Student");
            System.out.println("4. Deactivate Student");
            System.out.println("0. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter regNo: ");
                    String regNo = scanner.nextLine();
                    System.out.print("Enter full name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    edu.ccrm.domain.Student student = new edu.ccrm.domain.Student();
                    student.setRegNo(regNo);
                    student.setFullName(fullName);
                    // Assume email setter exists or set directly
                    // student.setEmail(email);
                    student.setActive(true);
                    studentService.addStudent(student);
                    System.out.println("Student added.");
                    break;
                case 2:
                    System.out.println("List of students:");
                    for (edu.ccrm.domain.Student s : studentService.listStudents()) {
                        System.out.println("RegNo: " + s.getRegNo() + ", Name: " + s.getFullName() + ", Active: " + s.isActive());
                    }
                    break;
                case 3:
                    System.out.print("Enter regNo to update: ");
                    String updateRegNo = scanner.nextLine();
                    edu.ccrm.domain.Student existing = studentService.getStudent(updateRegNo);
                    if (existing == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    System.out.print("Enter new full name: ");
                    String newName = scanner.nextLine();
                    existing.setFullName(newName);
                    studentService.updateStudent(updateRegNo, existing);
                    System.out.println("Student updated.");
                    break;
                case 4:
                    System.out.print("Enter regNo to deactivate: ");
                    String deactivateRegNo = scanner.nextLine();
                    studentService.deactivateStudent(deactivateRegNo);
                    System.out.println("Student deactivated.");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
}
