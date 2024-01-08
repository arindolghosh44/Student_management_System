package Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Table extends JPanel {

    private int width;
    private int height;
    private String[] columns = {"ID", "Forename", "Surname", "Age"};
    private Students students;
    private JTable table;
    private DefaultTableModel tableModel;

    public Table(int width, int height, Students students) {
        this.width = (width / 3) * 2;
        this.height = height;
        this.students = students;

        this.setLayout(new FlowLayout());
        this.table = new JTable() {
            @Override // Overrides the method to make a cell selectable but not editable
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tableModel = (DefaultTableModel) table.getModel();
        this.tableModel.setColumnIdentifiers(this.columns);
        this.table.setPreferredScrollableViewportSize(new Dimension(this.width - 40, this.height));
        this.table.setFillsViewportHeight(true);

        this.loadData();

        JScrollPane scrollPane = new JScrollPane(this.table);
        this.add(scrollPane);
    }

    private void loadData() {
        // Loads in the student data and displays it in the table

        for (Object[] data : this.students.getData()) {
            this.tableModel.addRow(data);
        }
    }

    public void addRow(String id, String forename, String surname, String age) {
        // Adds a single row of student data to the table

        Object[] data = {id, forename, surname, age};
        this.tableModel.addRow(data);
    }

    public void insertRow(int index, String id, String forename, String surname, String age) {
        Object[] data = {id, forename, surname, age};
        this.tableModel.insertRow(index, data);
    }

    public JTable getTable() {
        return table;
    }
}