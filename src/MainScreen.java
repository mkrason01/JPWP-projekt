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
    JPanel Panel = functions.createPanel("Main", x, y);
    Frame.add(Panel);
    JButton startGame = functions.createButton("Start the game", 300, 100);
    Panel.add(startGame);
    startGame.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.startGame();
            Frame.dispose();
        }
    });
    }


}

