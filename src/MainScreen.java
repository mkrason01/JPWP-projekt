import javax.swing.*;
import java.awt.*;

public class MainScreen{
    private int x = 1024;
    private int y = 768;
    public MainScreen(){    }
    public void showScreen() {

        JFrame screen = new JFrame();
        JPanel panel = new JPanel();
        JButton startButton = new JButton();
        panel.setLayout(new BorderLayout());
        screen.add(panel);
        panel.add(startButton);
        screen.setSize(x, y);
        panel.setSize(x, y);
        screen.setTitle("No elo");
        screen.pack();
        screen.setVisible(true);


    }
}

