package saveData;

import object.Clazz;
import object.Student;

import java.io.*;
import java.util.ArrayList;

public class ReadAnhWriteData {
    File fileStudent = new File("data_base/student.csv");
    File fileClazz = new File("data_base/clazz.csv");
    public ArrayList<Student> readDataStudent () {
        ArrayList<Student> students = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(this.fileStudent);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                double score = Double.parseDouble(data[1]);
                String gender = data[2];
                String conduct = data[3];
                int idClass = Integer.parseInt(data[4]);
                students.add(new Student( name, score, gender, conduct, idClass));
            }
        }catch (IOException e) {
            System.out.println(e);
        }
        return students;
    }
    public void writeDataStudent (ArrayList<Student> students) {
        try {
            String data = "" ;
            for (Student student : students) {
                data += student.getName() + "," +student.getScore()
                        + "," +student.getGender() + "," +student.getConduct() + "," + student.getIdClazz() + "\n";
            }
            FileWriter fileWriter = new FileWriter(this.fileStudent);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();

        }catch (IOException e) {
            System.out.println(e);
        }
    }
    public ArrayList<Clazz> readDataClass () {
        ArrayList<Clazz> clazzes = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(this.fileClazz);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ;
           while ((line = bufferedReader.readLine()) != null) {
               String[] data = line.split(",");
               int id = Integer.parseInt(data[0]);
               String name = data[1];
               String department = data[2];
               Clazz clazz = new Clazz(id, name, department);
               clazzes.add(clazz);
           }
        }catch (IOException e) {
            System.out.println(e);
        }
        return clazzes;
    }
    public void writeDataClass (ArrayList<Clazz> clazzes) {
        try {
            String data = "" ;
            for (Clazz clazz : clazzes) {
                data += clazz.getId() + "," +clazz.getName() + "," +clazz.getDepartment() + "\n";
            }
            FileWriter fileWriter = new FileWriter(this.fileClazz);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();

        }catch (IOException e) {
            System.out.println(e);
        }
    }

}
