import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private int rollNumber;
    private String grade;
    private int contact;

    public Student(String name, int rollNumber, String grade, int contact) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }
    public int getContact() {
        return contact;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade + "Contact:" + contact;}
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNumber() == rollNumber) {
                students.remove(i);
                System.out.println("Student with roll number " + rollNumber + " removed.");
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found in the system.");
            return;
        }

        System.out.println("List of all students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class SMS {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();

        sms.addStudent(new Student("Akshay Singh", 101, "A ", 7845985));
        sms.addStudent(new Student("Aryan Gupta", 102, "B ", 858540));
        sms.addStudent(new Student("Yash Pandey", 103, "A+ ", 986520));

        sms.displayAllStudents();

        int rollNumberToSearch = 102;
        Student searchedStudent = sms.searchStudent(rollNumberToSearch);
        if (searchedStudent != null) {
            System.out.println("Student with roll number " + rollNumberToSearch + " found: " + searchedStudent);
        } else {
            System.out.println("Student with roll number " + rollNumberToSearch + " not found.");
        }

        int rollNumberToRemove = 101;
        sms.removeStudent(rollNumberToRemove);

        sms.displayAllStudents();
    }
}
