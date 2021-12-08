import javax.swing.*;
import java.awt.*;

public class CommonFunctions {
    public CommonFunctions(){

    }
    public JButton createButton(String text, int x, int y){
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
    public void createFramewithPanel(String name, int x, int y){
        JFrame frame = this.createFrame(name, x, y);
        JPanel p = this.createPanel(name, x, y);
        frame.add(p);

    }
}
