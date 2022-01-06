import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameMenu {

    CommonFunctions functions = new CommonFunctions();
    private int level;
    private boolean Passed;
    private int time;
    private JButton resume = functions.createButton("Back to game", 350, 100);
    private JButton nextLevel = functions.createButton("Change level to higher", 350, 100);
    private JButton mainMenu = functions.createButton("Back to Main Menu", 350, 100);
    private JButton aboutAuthor = functions.createButton("About me ;)", 350, 100);
    private JButton playAgain = functions.createButton("Play again ;)", 350, 100);
    private Game game;
    JFrame menuF = functions.createFrame("Menu", 400, 600);
    JPanel menuP = functions.createPanel(400, 600);

    public GameMenu(int time, boolean Passed, int level, Game game) {
        this.level = level;
        this.Passed = Passed;
        this.time = time;
        this.game = game;
        this.showMenu();
        System.out.println(level);

    }

    public void showMenu() {

        menuF.add(menuP);
        menuP.add(resume);
        menuP.add(nextLevel);
        menuP.add(mainMenu);
        menuP.add(playAgain);
        resume.setLocation(25, 40);
        nextLevel.setLocation(25, 180);
        playAgain.setLocation(25, 320);
        mainMenu.setLocation(25, 460);
        menuF.setVisible(true);
        this.buttons(resume, nextLevel, mainMenu, aboutAuthor, playAgain);
        menuP.setFocusable(true);
        menuP.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getExtendedKeyCode() == KeyEvent.VK_ESCAPE) {
                    menuF.dispose();
                    System.out.println("esc pressed");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
    }

    private void buttons(JButton resume, JButton nextLevel, JButton mainMenu, JButton aboutAuthor, JButton playAgain) {
        resume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resumeBut();
            }
        });
        nextLevel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextLevelBut();
            }
        });
        mainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuBut();
            }
        });
        playAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playAgainBut();
            }
        });
    }

    private void resumeBut() {
        menuF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuF.dispose();
    }

    private void nextLevelBut() {
        if (level < 3) {
            level++;
            game.frame.dispose();
            game = new Game(level);
            game.startGame();
            menuF.dispose();
        } else {
            System.out.println("cant increase lvl");
        }
    }

    private void mainMenuBut() {
        game.frame.dispose();
        MainScreen main = new MainScreen();
        main.showScreen();
        menuF.dispose();
    }

    private void playAgainBut() {
        game.frame.dispose();
        game = new Game(level);
        game.startGame();
        menuF.dispose();
    }
}
