package manager;

import object.Student;

import java.util.ArrayList;

public interface IManager <S, C>{
    void addStudent(S student);
    void removeStudent(int id);
    void updateStudent(int id,S student);
    ArrayList<S> getStudents();
    ArrayList<S> searchByPointRange(double minPoint, double maxPoint);
    ArrayList<S> searchByConduct(String conduct);
    ArrayList<S> searchByClass(int classId);
    S getStudentMaxPoint() ;
    ArrayList<S> sortByAscending(); // Tang dan
    ArrayList<S> sortByDescending(); // Giam dan
    ArrayList<Student> sortByNameA_Z() ;
    void showAllStudents();
    void displayAllClass() ;
    String getConduct (int choice) ;
    C getClass (int id) ;



}
