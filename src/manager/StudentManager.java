package manager;

import object.Clazz;
import object.Student;
import saveData.ReadAnhWriteData;

import java.util.ArrayList;

public class StudentManager implements IManager <Student, Clazz> {
    private ArrayList<Student> studentList;
    private ReadAnhWriteData dataFile ;
    public StudentManager() {
        this.dataFile = new ReadAnhWriteData();
        studentList = dataFile.readDataStudent();
    }

    @Override
    public void addStudent(Student student) {
        this.studentList.add(student);
        dataFile.writeDataStudent(studentList);
    }

    @Override
    public void removeStudent(int id) {
        this.studentList.remove(id - 1);
        dataFile.writeDataStudent(studentList);
    }

    @Override
    public void updateStudent(int id, Student student) {
        this.studentList.set(id - 1 ,student) ;
        dataFile.writeDataStudent(studentList);
    }

    @Override
    public ArrayList<Student> getStudents() {
        return studentList;
    }


    @Override
    public ArrayList<Student> searchByPointRange(double minPoint, double maxPoint) {
        ArrayList<Student> searchPoint = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getScore() >= minPoint && student.getScore() <= maxPoint) {
                searchPoint.add(student);
            }
        }
        return searchPoint;
    }

    @Override
    public ArrayList<Student> searchByConduct(String conduct) {
        ArrayList<Student> searchConduct = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getConduct().equals(conduct)) {
                searchConduct.add(student);
            }
        }
        return searchConduct;
    }

    @Override
    public ArrayList<Student> searchByClass(int idClass) {
        ArrayList<Student> searchClass = new ArrayList<>();

        for (Student student : studentList) {
            if (student.getIdClazz() == idClass) {
                searchClass.add(student);
            }
        }
        return searchClass;
    }

    @Override
    public Student getStudentMaxPoint() {
        double maxPoint = studentList.get(0).getScore();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getScore() > maxPoint) {
                maxPoint = studentList.get(i).getScore();
            }
        }
        for (Student student : studentList) {
            if (student.getScore() == maxPoint) {
                return student;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Student> sortByAscending() {
        ArrayList<Student> sortByAscending = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            int min_index = i;
            for (int j = i + 1; j < studentList.size(); j++) {
                if (studentList.get(j).getScore() < studentList.get(min_index).getScore()) {
                    min_index = j;
                }
            }
            if (min_index != i) {
                Student temp = studentList.get(i);
                studentList.set(i, studentList.get(min_index));
                studentList.set(min_index, temp);
            }
            sortByAscending.add(studentList.get(i));
        }
        return sortByAscending;
    }

    @Override
    public ArrayList<Student> sortByDescending() {
        ArrayList<Student> sortByDescending = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            int min_index = i;
            for (int j = i + 1; j < studentList.size(); j++) {
                if (studentList.get(j).getScore() > studentList.get(min_index).getScore()) {
                    min_index = j;
                }
            }
            if (min_index != i) {
                Student temp = studentList.get(i);
                studentList.set(i, studentList.get(min_index));
                studentList.set(min_index, temp);
            }
            sortByDescending.add(studentList.get(i));
        }
        return sortByDescending;
    }

    @Override
    public void showAllStudents() {
        for (Student student : studentList) {
            System.out.println(student);
        }

    }

    @Override
    public void displayAllClass() {
        ArrayList<Clazz> classList = dataFile.readDataClass();
        for (Clazz clazz : classList) {
            System.out.println("Name : " + clazz.getName() + ", ID : " + clazz.getId()); ;
        }
    }

    @Override
    public String getConduct(int choice) {

        switch (choice) {
            case 1:
                return "Good" ;
            case 2:
                return "Medium" ;
            case 3:
                return "Bad" ;
        }
        return null;
    }

    @Override
    public Clazz getClass(int id) {
        for (Clazz clazz : dataFile.readDataClass()) {
            if (clazz.getId() == id) {
                return clazz;
            }
        }
        return null;
    }

}
