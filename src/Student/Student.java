package Student;

public class Student {

    private int id;
    private String forename;
    private String surname;
    private int age;

    public Student() {
    }

    public Student(int id, String forename, String surname, int age) {
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.id + "," + this.forename + "," + this.surname + "," + this.age;
    }
}