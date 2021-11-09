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
        panel.add(createButton("START GRY", 400 , 50));
        panel.add(createButton("siema", 400, 50));
        screen.setSize(x, y);
        screen.setMinimumSize(new Dimension(1024, 768));
        screen.setMaximumSize(new Dimension(1024, 768));
        //panel.setSize(x, y);
        screen.setTitle("No elo");
        screen.pack();
        screen.setVisible(true);

    }
    private JButton createButton(String text, int x, int y){
        JButton b = new JButton(text);
        b.setSize( x, y );
        b.setPreferredSize(new Dimension(x,y));
        return b;
    }
}

