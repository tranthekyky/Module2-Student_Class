package object;

public class Student {
    private int id;
    private String name;
    private double score;
    private String gender;
    private String conduct ;
    private int idClazz;

    private static int count = 1;
    public Student(String name, double score, String gender, String conduct, int idClazz) {
        this.id = count++;
        this.name = name;
        this.score = score;
        this.gender = gender;
        this.conduct = conduct;
        this.idClazz = idClazz;
    }
    public Student(int id ,String name, double score, String gender, String conduct, int idClazz) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.gender = gender;
        this.conduct = conduct;
        this.idClazz = idClazz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getConduct() {
        return conduct;
    }

    public void setConduct(String conduct) {
        this.conduct = conduct;
    }

    public int getIdClazz() {
        return idClazz;
    }

    public void setIdClazz(int idClazz) {
        this.idClazz = idClazz;
    }

    @Override
    public String toString() {
        return "Student [ " +
                "ID=" + id +
                ", Name = '" + name + '\'' +
                ", Score = " + score +
                ", Gender = '" + gender + '\'' +
                ", Conduct = '" + conduct + '\'' +
                ", ID Clazz = " + idClazz +
                ']';
    }
}
