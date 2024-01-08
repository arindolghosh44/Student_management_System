package Student;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class SaveButton extends Button {

    public SaveButton(String text) {
        super(text);
    }

    public void saveData(Students students) {
        // Saves data to the students.txt file to keep a record of students

        File file = new File("students.txt");

        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Student student : students.getStudents()) {
                bw.write(student.toString());
                bw.newLine();
            }
            bw.close();
            JOptionPane.showMessageDialog(null, "Data saved successfully", "Success", JOptionPane.PLAIN_MESSAGE);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error saving file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}