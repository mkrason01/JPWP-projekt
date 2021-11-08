import sun.font.TrueTypeFont;

import javax.swing.*;
import java.awt.*;

public class MainScreen{
    private int x = 1024;
    private int y = 768;
    public MainScreen(){    }
    public void showScreen() {

        JFrame screen = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        screen.add(panel);
        screen.setSize(x, y);
        panel.setSize(x, y);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setTitle("No elo");
        screen.pack();
        screen.setVisible(true);


    }
}

