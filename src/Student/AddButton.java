package Student;

import java.awt.Button;

public class AddButton extends Button {

    private Students students;

    public AddButton(String text, Students students) {
        super(text);
        this.students = students;
    }

    public void addStudent(Table table, String id, String forename, String surname, String age) {
        // If details are correct, adds a student.

        Student student = new Student(Integer.parseInt(id), forename, surname, Integer.parseInt(age));

        int index = this.students.getStudents().size();
        for (int i=this.students.getStudents().size() - 1; i>=0; i--) {
            if (Integer.parseInt(id) > students.getStudents().get(i).getId()) {
                break;
            }
            index--;
        }
        table.insertRow(index, id, forename, surname, age);
        this.students.addStudent(index, student);
    }
}