package Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Students {

    private ArrayList<Student> students;

    public Students() {
        this.students = new ArrayList<>();
        this.readData();
    }

    public void addStudent(Student student) {
        /*
        Adds a student object to the list of students
         */

        this.students.add(student);
    }

    public void addStudent(int index, Student student) {
        /*
        Adds a student object to the list of students at specified index
         */

        this.students.add(index, student);
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public Object[][] getData() {
        /*
        Creates a list of lists which hold the data of each student.
        Used for displaying data in the table.
         */

        Object[][] data = new Object[this.students.size()][];

        int index = 0;
        for (Student student : students) {
            String[] studentData = {Integer.toString(student.getId()), student.getForename(), student.getSurname(), Integer.toString(student.getAge())};
            data[index] = studentData;
            index++;
        }
        return data;
    }

    private void readData() {
        /*
        Reads the student data from the students.txt file.
        Creates a Student object for each student and adds that student
        to the students ArrayList to be displayable in the GUI table.
         */

        File file = new File("students.txt");

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String data = "";

            while ((data = br.readLine()) != null) {
                // Uses the tokenizer to split each line of the text file at a coma
                StringTokenizer st = new StringTokenizer(data, ",");
                Student student = new Student();

                while (st.hasMoreTokens()) {
                    int id = Integer.parseInt(st.nextToken().trim());
                    String forename = st.nextToken().trim();
                    String surname = st.nextToken().trim();
                    int age = Integer.parseInt(st.nextToken().trim());

                    student.setId(id);
                    student.setForename(forename);
                    student.setSurname(surname);
                    student.setAge(age);

                    this.students.add(student);
                }
            }
            br.close();
        }
        catch (Exception e) {
            // DO NOTHING
        }
    }
}