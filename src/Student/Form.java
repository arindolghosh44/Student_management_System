package Student;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JPanel implements ActionListener {

    private int width;
    private int height;
    private int containerHeight;
    private Students students;
    private Table table;
    private JPanel container;
    private JLabel id;
    private JTextField idText;
    private JLabel forename;
    private JTextField forenameText;
    private JLabel surname;
    private JTextField surnameText;
    private JLabel age;
    private JTextField ageText;
    private AddButton addButton;
    private EditButton editButton;
    private SaveButton saveButton;
    private DeleteButton deleteButton;

    public Form(int width, int height, Students students, Table table) {
        this.width = width / 3;
        this.height = height;
        this.containerHeight = 120;
        this.setPreferredSize(new Dimension(this.width, this.height));

        this.students = students;
        this.table = table;

        this.container = new JPanel();
        this.container.setLayout(new GridLayout(4, 2, 0, 10));
        this.container.setPreferredSize(new Dimension(this.width - 10, this.containerHeight));

        this.id = new JLabel("ID");
        this.idText = new JTextField();
        this.setUpIdTextField();

        this.forename = new JLabel("Forename");
        this.forenameText = new JTextField();

        this.surname = new JLabel("Surname");
        this.surnameText = new JTextField();

        this.age = new JLabel("Age");
        this.ageText = new JTextField();

        this.addButton = new AddButton("ADD", this.students);
        this.addButton.addActionListener(this);

        this.editButton = new EditButton("EDIT");
        this.editButton.addActionListener(this);

        this.saveButton = new SaveButton("SAVE");
        this.saveButton.addActionListener(this);

        this.deleteButton = new DeleteButton("DELETE");
        this.deleteButton.addActionListener(this);

        this.container.add(this.id);
        this.container.add(this.idText);
        this.container.add(this.forename);
        this.container.add(this.forenameText);
        this.container.add(this.surname);
        this.container.add(this.surnameText);
        this.container.add(this.age);
        this.container.add(this.ageText);
        this.add(this.container);
        this.add(this.addButton);
        this.add(this.editButton);
        this.add(this.saveButton);
        this.add(this.deleteButton);
    }

    private void setUpIdTextField() {
        // Suggests an ID number based on the ID of the last added student

        if (this.students.getStudents().size() > 0) {
            this.idText.setText(Integer.toString(this.students.getStudents().get(this.students.getStudents().size() - 1).getId() + 1));
        }
        else {
            this.idText.setText("1");
        }
        this.idText.setCaretPosition(this.idText.getText().length());
    }

    private boolean validateForm(String id, String forename, String surname, String age) {
        // Checks if the form has all the correct information to avoid errors

        boolean isValid = true;

        if (id.trim().equals("") || id.trim().equals(" ") || !this.isNumber(id)) {
            isValid = false;
        }
        if (forename.trim().equals("") || forename.trim().equals(" ")) {
            isValid = false;
        }
        if (surname.trim().equals("") || surname.trim().equals(" ")) {
            isValid = false;
        }
        if (age.trim().equals("") || age.trim().equals(" ") || !this.isNumber(age)) {
            isValid = false;
        }

        return isValid;
    }

    private boolean isNumber(String input) {
        // Checks if the passed input is a number to validate id and age

        try {
            Integer.parseInt(input);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    private boolean checkIdExists(int id) {
        // Checks if another student already has the given id number to maintain unique id numbers for each student

        for (Student student : this.students.getStudents()) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private void emptyForm() {
        // Empties the form to make form more user-friendly

        this.idText.setText("");
        this.forenameText.setText("");
        this.surnameText.setText("");
        this.ageText.setText("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.addButton) {
            String id = this.idText.getText();
            String forename = this.forenameText.getText();
            String surname = this.surnameText.getText();
            String age = this.ageText.getText();

            boolean formIsValid = this.validateForm(id, forename, surname, age);

            if (formIsValid) {
                boolean idExists = this.checkIdExists(Integer.parseInt(id));

                if (!idExists) {
                    this.addButton.addStudent(this.table, id, forename, surname, age);
                    this.emptyForm();
                    this.setUpIdTextField();
                    JOptionPane.showMessageDialog(null, "Student added successfully", "Success", JOptionPane.PLAIN_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "ID Already Exists", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Form Invalid!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == this.saveButton) {
            this.saveButton.saveData(this.students);
        }
        if (e.getSource() == this.editButton) {
            this.editButton.edit(this.table.getTable(), this.students, this.idText, this.forenameText, this.surnameText, this.ageText);
        }
        if (e.getSource() == this.deleteButton) {
            this.deleteButton.delete(this.table.getTable(), this.students);
            this.setUpIdTextField();
        }
    }
}