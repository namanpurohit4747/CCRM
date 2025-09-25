# Campus Course & Records Manager (CCRM)
# Project Statement
Campus Course & Records Manager (CCRM) is a console-based Java SE application for academic institutes to manage students, courses, enrollments, grades, transcripts, and file operations. The project demonstrates OOP principles, robust exception handling, modern Java APIs, and design patterns.

## Features
- **Student Management:** Add, list, update, deactivate students; print profiles and transcripts.
- **Course Management:** Add, list, update, deactivate courses; assign instructors; search/filter courses.
- **Enrollment & Grading:** Enroll/unenroll students; record marks; compute grades and GPA; generate transcripts.
- **File Operations:** Import/export CSV files; backup data; recursive utilities for file management.
- **CLI Workflow:** Menu-driven console for all operations.

## Package Structure
```
src/edu/ccrm/
├─ cli/        # Menu, input loop
├─ domain/     # Person, Student, Instructor, Course, Enrollment, Grade, Semester
├─ service/    # StudentService, CourseService, EnrollmentService
├─ io/         # ImportExportService, BackupService
├─ util/       # Comparators, recursion, exceptions
├─ config/     # AppConfig (Singleton), builders
```

## Design & Implementation Highlights
- **OOP Pillars:** Encapsulation (private fields, getters/setters), Inheritance (Person → Student/Instructor), Abstraction (abstract Person), Polymorphism (base-class references, overridden methods).
- **Exception Handling:** Custom exceptions (DuplicateEnrollmentException, MaxCreditLimitExceededException), try/catch/finally, assertions.
- **Java APIs:** NIO.2 for file operations, Streams for filtering/aggregation, Date/Time API for timestamps.
- **Interfaces & Enums:** Persistable, Searchable<T>, Semester, Grade.
- **Design Patterns:** Singleton (AppConfig), Builder (CourseBuilder).
- **Functional Programming:** Lambdas for sorting/filtering, anonymous inner classes.
- **Recursion:** Utility for recursive file size computation.

## Sample Usage
```
> Add Student
Enter details: ...
> Enroll Student in Course
Select student, select course, confirm enrollment
> Print Transcript
Student: John Doe
Courses: ...
GPA: ...
> Export Data
Data exported to /backup/YYYYMMDD_HHMM/
```
Sample CSV format:
students.csv: `id,regNo,fullName,email,status,enrolledCourses,date`
courses.csv: `code,title,credits,instructor,semester,department`


## Project Overview
A console-based Java SE application for managing students, courses, enrollments, grades, transcripts, and file operations for an academic institute.

## How to Run
- Requires JDK 17+ (or as per syllabus)
- Compile: `javac -d bin src/edu/ccrm/CCRMApp.java`
- Run: `java -cp bin edu.ccrm.CCRMApp`

## Evolution of Java (Timeline)
- 1995: Java 1.0 released
- 1998: Java 2 (J2SE, J2EE, J2ME)
- 2004: Java 5 (Generics, Enums)
- 2014: Java 8 (Lambdas, Streams)
- 2017: Java 9+ (Modules)
- 2021: Java 17 (LTS)

## Java ME vs SE vs EE
| Feature      | Java ME         | Java SE         | Java EE         |
|--------------|-----------------|-----------------|-----------------|
| Target       | Embedded/Mobile | Desktop/Server  | Enterprise/Web  |
| APIs         | Limited         | Full Core       | Web/Enterprise  |
| Use Case     | IoT, Mobile     | Apps, Tools     | Web, Services   |

## Java Architecture
- **JDK**: Java Development Kit (tools + JRE)
- **JRE**: Java Runtime Environment (JVM + libraries)
- **JVM**: Java Virtual Machine (executes bytecode)

## Install Java on Windows
1. Download JDK from [Oracle](https://www.oracle.com/java/technologies/downloads/)
2. Run installer, set JAVA_HOME
3. Add to PATH
4. Verify: `java -version`

## Eclipse IDE Setup
1. Install Eclipse IDE
2. Create new Java project
3. Add source folders/packages
4. Run `CCRMApp.java`

## Syllabus Mapping Table
| Topic                | File/Class/Method                |
|----------------------|----------------------------------|
| Encapsulation        | domain/Person, Student           |
| Inheritance          | domain/Person → Student/Instructor|
| Abstraction          | domain/Person (abstract)         |
| Polymorphism         | TranscriptService, printProfile  |
| Exception Handling   | util/DuplicateEnrollmentException, util/MaxCreditLimitExceededException |
| Streams              | util/Comparators, service/*      |
| Date/Time API        | domain/Student, io/BackupService |
| Singleton            | config/AppConfig                 |
| Builder              | domain/CourseBuilder             |
| Enums                | domain/Semester, Grade           |
| Lambdas              | util/Comparators                 |
| Recursion            | util/RecursionUtils              |

## Enabling Assertions
- Add `-ea` to JVM args: `java -ea -cp bin edu.ccrm.CCRMApp`

## Sample Commands & Data Files
- See `test-data/` for sample CSVs (students.csv, courses.csv)
- Menu options in CLI for all operations

## Screenshots
Below are some screenshots of the CCRM application in action:
![Screenshot 601](src/screenshots/Screenshot%20(601).png)
![Screenshot 602](src/screenshots/Screenshot%20(602).png)
![Screenshot 603](src/screenshots/Screenshot%20(603).png)
![Screenshot 604](src/screenshots/Screenshot%20(604).png)
![Screenshot 605](src/screenshots/Screenshot%20(605).png)
![Screenshot 606](src/screenshots/Screenshot%20(606).png)
![Screenshot 607](src/screenshots/Screenshot%20(607).png)
![Screenshot 608](src/screenshots/Screenshot%20(608).png)
![Screenshot 609](src/screenshots/Screenshot%20(609).png)
![Screenshot 610](src/screenshots/Screenshot%20(610).png)
![Screenshot 611](src/screenshots/Screenshot%20(611).png)
![Screenshot 612](src/screenshots/Screenshot%20(612).png)
## Testing & Validation
- Manual testing of all CLI menu options
- Import/export tested with sample CSVs
- Exception handling validated with edge cases
- Backup and recursive utilities verified

## References
- Oracle Java Documentation: https://docs.oracle.com/en/java/
- VIT Bhopal syllabus and course materials
- Any additional references cited in code comments or acknowledgements



## Acknowledgements
- All code is original. References cited as needed.

**Author:** Naman Purohit  
Reg. No.: 24BCE10971  
Course: (CSE2006) Programming in Java  
Institution: Vellore Institute of Technology, Bhopal
