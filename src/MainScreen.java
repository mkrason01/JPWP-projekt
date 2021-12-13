import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen{
    private int x = 1024;
    private int y = 768;
    Game game = new Game();
    public MainScreen(){    }
    CommonFunctions functions = new CommonFunctions();

    public void showScreen() {
    JFrame Frame = functions.createFrame("Main menu", x, y);
    JPanel Panel = functions.createPanel(x, y);
    Frame.add(Panel);

    JButton startGame = functions.createButton("Start the game", 300, 100);
    Panel.add(startGame);
    JLabel background = functions.addingBackgroundPhoto("resources/background_menu.gif", 1024, 768);
    Panel.add(background);
    startGame.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.startGame();
            Frame.dispose();
        }
    });
        Frame.setVisible(true);
    }


}

