package Student;

import javax.swing.*;

public class MyFrame extends JFrame {

    private int width;
    private int height;
    private String title;

    public MyFrame() {
        this.width = 600;
        this.height = 400;
        this.title = "Student Management System";

        this.setSize(this.width, this.height);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle(this.title);
    }

	
}