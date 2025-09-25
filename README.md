# Campus Course & Records Manager (CCRM)

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
- See `screenshots/` folder for setup and demo images

## Acknowledgements
- All code is original. References cited as needed.

---
**Note:** This is a project scaffold. Source code, screenshots, and demo video to be added as development progresses.
