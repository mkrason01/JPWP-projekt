import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen{
    private int x = 1024;
    private int y = 768;
    Game game = new Game(1);

    public MainScreen(){    }
    CommonFunctions functions = new CommonFunctions();

    public void showScreen() {
    JFrame Frame = functions.createFrame("Main menu", x, y);
    JPanel Panel = functions.createPanel(x, y);
    Panel.setLayout(new FlowLayout());

    JButton startGame = functions.createButton("Start the game", 300, 100);
    JButton aboutMe = functions.createButton("About me", 300, 100);
    JButton exit = functions.createButton("Exit", 300, 100);
    JLabel background = functions.addingBackgroundPhoto("resources/background_menu.gif", 1024, 768);
    startGame.setLocation((Frame.getWidth()/2) - 170, 100);
    aboutMe.setLocation((Frame.getWidth()/2) - 170, 240);
    exit.setLocation((Frame.getWidth()/2) - 170, 380);
    Frame.add(startGame);
    Frame.add(aboutMe);
    Frame.add(exit);

    Frame.add(background);

    Frame.add(Panel);

    background.setVisible(true);
    Frame.setVisible(true);

    startGame.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.startGame();
            Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Frame.dispose();
        }
    });
    exit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
    aboutMe.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            aboutMe aboutM = new aboutMe();
            Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Frame.dispose();
        }
    });
    }
}

