package menu;

import exception.HandleException;
import exception.Regexx;
import manager.StudentManager;
import object.Student;

import java.util.ArrayList;

public class MainMenu {
    StudentManager studentManager = new StudentManager();
    HandleException handleException = new HandleException();
    Regexx handleRegex = new Regexx();
    public void handleFunction() {
         int choice ;
        do {
            showFunction();
            choice = handleException.inputNumberInt();
            if (choice > 10 || choice < 0) {
                System.out.println("Please enter a number between 0 and 10");
            }else {
                switch (choice) {
                    case 1:
                        functionAddStudent();
                        break;
                    case 2:
                        functionRemoveStudent();
                        break;
                    case 3:
                        functionEditStudent();
                        break;
                    case 4:
                        functionFindRangeScore();
                        break;
                    case 5:
                        functionFindConduct();
                        break;
                    case 6:
                        functionFindHighestScore();
                        break;
                    case 7:
                        functionFindClass();
                        break;
                    case 8:
                        functionSortAscending();
                        break;
                    case 9:
                        functionSortDescending();
                        break;
                    case 10:
                        functionShowAllStudents();
                        break;
                }
            }
        }while (choice != 0);
    }
    public void showFunction() {
        System.out.println("====== MENU ======");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Students");
        System.out.println("3. Edit Student");
        System.out.println("4. Find Students By PointRange ");
        System.out.println("5. Find Students By Conduct ");
        System.out.println("6. Find Students Highest Score ");
        System.out.println("7. Find Students By Class");
        System.out.println("8. Show Sort Ascending By Score");
        System.out.println("9. Show Sort Descending By Score");
        System.out.println("10. Show All Students");
        System.out.println("0. Exit");
        System.out.println();
        System.out.println("--- Enter your choice : ");

    }
    public void functionAddStudent () {
        System.out.println("----- Add New Student -----");
        System.out.println("Enter student name : ");
        String name = handleRegex.formatStringName();
        System.out.println("Enter Score : ");
        double score = handleException.inputNUmberDouble();
        System.out.println("Enter Gender :");
        String gender = handleException.inputString();
        System.out.println("Enter Academic Conduct :");
        System.out.println("1. Conduct Good");
        System.out.println("2. Conduct Medium");
        System.out.println("3. Conduct Bad");
        System.out.println("Enter Conduct Choice :");
        int choice = handleException.inputNumberInt();
        String academicConduct = studentManager.getConduct(choice);
        studentManager.displayAllClass();
        System.out.println("Choice ID Class : ");
        int classID = handleException.inputNumberInt();
        Student student = new Student(name, score, gender, academicConduct, classID);
        studentManager.addStudent(student);
        System.out.println("Added student successfully !!");

    }
    public void functionRemoveStudent () {
        System.out.println("----- Remove Student -----");
        System.out.println("Enter ID student : ");
        int studentID = handleException.inputNumberInt();
        studentManager.removeStudent(studentID);
        System.out.println("Removed student successfully !!");
    }
    public void functionEditStudent () {
        System.out.println("----- Edit Student -----");
        System.out.println("Enter ID student : ");
        int studentID = handleException.inputNumberInt();
        System.out.println("Enter New Name : ");
        String newName = handleException.inputString();
        System.out.println("Enter New Score : ");
        double newScore = handleException.inputNUmberDouble();
        System.out.println("Enter New Gender : ");
        String newGender = handleException.inputString();
        System.out.println("Choice New Academic Conduct : ");
        System.out.println("1. Conduct Good");
        System.out.println("2. Conduct Medium");
        System.out.println("3. Conduct Bad");
        System.out.println("Enter Conduct Choice :");
        int choice = handleException.inputNumberInt();
        String newAcademicConduct = studentManager.getConduct(choice);
        studentManager.displayAllClass();
        System.out.println("Choice ID Class : ");
        int classID = handleException.inputNumberInt();
        Student newStudent = new Student(studentID, newName, newScore, newGender, newAcademicConduct, classID);
        studentManager.updateStudent(studentID, newStudent);
        System.out.println("Updated student successfully !!");
    }
    public void functionFindRangeScore () {
        System.out.println("----- Find Range Score -----");
        System.out.println("Enter From Score : ");
        double scoreMin = handleException.inputNUmberDouble();
        System.out.println("Enter To Score : ");
        double scoreMax = handleException.inputNUmberDouble();
        System.out.println("From : " + scoreMin + " - To : " + scoreMax);
       ArrayList <Student> students =  studentManager.searchByPointRange(scoreMin, scoreMax);
       for (Student student : students) {
           System.out.println(student);
       }
    }
    public void functionFindConduct () {
        System.out.println("----- Find Conduct -----");
        System.out.println("1. Conduct Good");
        System.out.println("2. Conduct Medium");
        System.out.println("3. Conduct Bad");
        System.out.println("Enter Conduct choice :");
        int choice = handleException.inputNumberInt();
        String conduct = studentManager.getConduct(choice);
        ArrayList<Student> students = studentManager.searchByConduct(conduct);
        for (Student student : students) {
            System.out.println(student);
        }
    }
    public void functionFindHighestScore () {
        System.out.println("Student Highest Score : ");
        System.out.println(studentManager.getStudentMaxPoint());;
    }
    public void functionFindClass () {
        System.out.println("----- Find Class -----");
        studentManager.displayAllClass();
        System.out.println("Enter Class ID : ");
        int classID = handleException.inputNumberInt();
        System.out.println(studentManager.getClass(classID));
        System.out.println("Studennt --->");
        ArrayList<Student> students = studentManager.searchByClass(classID);
        for (Student student : students) {
            System.out.println(student);
        }
    }
    public void functionSortAscending () {
        System.out.println("----- Sort Ascending -----");
        ArrayList<Student> students = studentManager.sortByAscending();
        for (Student student : students) {
            System.out.println(student);
        }
    }
    public void functionSortDescending () {
        System.out.println("----- Sort Descending -----");
        ArrayList<Student> students = studentManager.sortByDescending();
        for (Student student : students) {
            System.out.println(student);
        }
    }
    public void functionShowAllStudents () {
        System.out.println("----- Show All Students -----");
        studentManager.showAllStudents();
    }



}
