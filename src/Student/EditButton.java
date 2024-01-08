package Student;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EditButton extends Button {

    public EditButton(String text) {
        super(text);
    }

    public void edit(JTable table, Students students, JTextField id, JTextField forename, JTextField surname, JTextField age) {
        int row = table.getSelectedRow();
        if (row > -1) {
            Object[] data = students.getData()[row];
            students.getStudents().remove(row);
            ((DefaultTableModel)table.getModel()).removeRow(row);

            id.setText("");
            forename.setText("");
            surname.setText("");
            age.setText("");

            id.setText((String)data[0]);
            forename.setText((String)data[1]);
            surname.setText((String)data[2]);
            age.setText((String)data[3]);
        }
    }
}