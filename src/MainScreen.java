import javax.swing.*;
import java.awt.*;

public class MainScreen{
    private int x = 1024;
    private int y = 768;
    public MainScreen(){    }
    public void showScreen() {
    JFrame Frame = this.createFrame("Main menu", x, y);
    JPanel Panel = this.createPanel("Main", x, y);
    Frame.add(Panel);
    JButton startGame = this.createButton("Start the game", 300, 100);
    Panel.add(startGame);
    }
    private JButton createButton(String text, int x, int y){
        JButton b = new JButton(text);
        b.setSize( x, y );
        b.setPreferredSize(new Dimension(x,y));
        b.setVisible(true);
        return b;
    }
    public JFrame createFrame(String name, int x, int y){
        JFrame frame = new JFrame(name);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(x, y);
        frame.setResizable(false);
        return frame;
    }
    public JPanel createPanel(String name, int x, int y){
        JPanel Panel = new JPanel();
        Panel.setVisible(true);
        Panel.setLayout(new FlowLayout());
        return Panel;
    }

}

