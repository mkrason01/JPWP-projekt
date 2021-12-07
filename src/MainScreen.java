import javax.swing.*;
import java.awt.*;

public class MainScreen{
    private int x = 1024;
    private int y = 768;
    public MainScreen(){    }
    public void showScreen() {
    this.createFrame("Main menu", x, y);



    }
    private JButton createButton(String text, int x, int y){
        JButton b = new JButton(text);
        b.setSize( x, y );
        b.setPreferredSize(new Dimension(x,y));
        return b;
    }
    public JFrame createFrame(String name, int x, int y){
        JFrame frame = new JFrame(name);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(x, y);
        return frame;
    }

}

