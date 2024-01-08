package Student;
import javax.swing.*;

abstract class Button extends JButton {

    private String buttonText;

    public Button(String text) {
        this.buttonText = text;
        this.setText(this.buttonText);
        this.setFocusable(false);
    }
}