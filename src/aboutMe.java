import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class aboutMe {
    CommonFunctions f = new CommonFunctions();
    public aboutMe(){
        this.screenMe();
    }
    private void screenMe(){
        JFrame frame = f.createFrame("About me", 600, 400);
        JPanel panel = f.createPanel(600, 400);
        frame.add(panel);
        JLabel background = f.addingBackgroundPhoto("resources/gameBackground.jpg", 1024, 768);
        panel.setOpaque(false);
        panel.setVisible(true);
        frame.add(background);
        frame.setVisible(true);
        JLabel aboutMyself= new JLabel("Twórcą gry jest Mateusz Krasoń 180450");
        JLabel greeting= new JLabel("Pozdrawiam serdecznie");
        aboutMyself.setFont(new Font("Arial", Font.PLAIN, 24));
        aboutMyself.setForeground(Color.WHITE);
        aboutMyself.setLocation(10, 30);
        aboutMyself.setVisible(true);
        aboutMyself.setSize(500, 30);
        panel.add(aboutMyself);
        greeting.setFont(new Font("Arial", Font.PLAIN, 24));
        greeting.setForeground(Color.WHITE);
        greeting.setLocation(10, 130);
        greeting.setVisible(true);
        greeting.setSize(5000, 30);
        panel.add(greeting);
        JButton mainMenu = f.createButton("Back to Main Menu",300, 50);
        mainMenu.setLocation(150, 300);
        mainMenu.setVisible(true);
        panel.add(mainMenu);
        mainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MainScreen main = new MainScreen();
                main.showScreen();
                frame.dispose();
            }
        });
    }

}
