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
        //frame.setVisible(true);
        frame.setSize(x, y);
        frame.setResizable(false);


        return frame;
    }

    public JPanel createPanel(int x, int y){
        JPanel Panel = new JPanel();
        Panel.setVisible(true);
        Panel.setLayout(new FlowLayout());
        return Panel;
    }

    public void createFrameWithPanel(JFrame frame, JPanel p, String name, int x, int y){
        frame = this.createFrame(name, x, y);
        p = this.createPanel(x, y);
        frame.add(p);
        p.requestFocusInWindow();
    }

    public JLabel addingBackgroundPhoto(String fileLocation, int x, int y){
        ImageIcon pic = new ImageIcon(fileLocation);
        JLabel l = new JLabel(pic);
        l.setSize(x, y);
        return l;
    }
}