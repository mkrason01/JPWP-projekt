import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToSumUp {
    private String s;
    CommonFunctions f = new CommonFunctions();
    private int time;
    private int level = 1;
    boolean passedOrNot;
    String passed = "passed";
    JFrame frame = f.createFrame(passed, 400, 500);
    JPanel p = f.createPanel(400, 500);
    JButton nextLevel = f.createButton("Next level", 350, 100);
    JButton backToMenu = f.createButton("Back to menu", 350, 100);
    JButton tryAgain = f.createButton("Try Again", 350, 100);
    Game game;

    public ToSumUp(int time, String s, int level, boolean passed, Game game) {
        this.time = time;
        this.level = level;
        this.s = s;
        this.passedOrNot = passed;
        this.game = game;
    }

    public void summingUp() {

        frame.add(p);
        if (passedOrNot) {
            String TimeText = "Your time was " + time + " seconds";
            String levelText = "Your level was " + (level) + " out of 3 levels";
            if (level < 3) {
                this.passed = "CONGRATULATIONS!!!";
                p.add(nextLevel);
                nextLevel.setLocation(25, 300);
                nextLevel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nextLevelBut();
                    }
                });


                JLabel urTime = new JLabel(TimeText);
                urTime.setLocation(25, 50);
                urTime.setFont(new Font("Arial", Font.PLAIN, 20));
                urTime.setVisible(true);
                urTime.setSize(350, 100);
                p.add(urTime);

                JLabel urLevel = new JLabel(levelText);
                urLevel.setLocation(25, 100);
                urLevel.setFont(new Font("Arial", Font.PLAIN, 20));
                urLevel.setVisible(true);
                urLevel.setSize(350, 100);
                p.add(urLevel);
            } else if (level == 3) {
                p.add(backToMenu);
                backToMenu.setLocation(25, 300);
                backToMenu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainMenuBut();
                    }
                });
                JLabel urTime = new JLabel(TimeText);
                urTime.setLocation(25, 50);
                urTime.setFont(new Font("Arial", Font.PLAIN, 20));
                urTime.setVisible(true);
                urTime.setSize(350, 100);
                p.add(urTime);

                JLabel urLevel = new JLabel(levelText);
                urLevel.setLocation(25, 100);
                urLevel.setFont(new Font("Arial", Font.PLAIN, 20));
                urLevel.setVisible(true);
                urLevel.setSize(350, 100);
                p.add(urLevel);
            }
            frame.setVisible(true);
        } else {
            tryAgain.setLocation(25, 200);
            p.add(tryAgain);
            this.passed = "Unfortunately, try again :/";
            String failedText = "You Failed ://";
            JLabel failed = new JLabel(failedText);
            failed.setLocation(150, 100);
            failed.setFont(new Font("Arial", Font.PLAIN, 20));
            failed.setVisible(true);
            failed.setSize(350, 100);
            p.add(failed);
            frame.setVisible(true);
            tryAgain.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playAgainBut();
                }
            });
        }


    }

    private void nextLevelBut() {
        if (level < 3) {
            level++;
            game.frame.dispose();
            game = new Game(level);
            game.startGame();
            this.frame.dispose();
        } else {
            System.out.println("U have passed the game!!!");
        }
    }

    private void playAgainBut() {
        game.frame.dispose();
        game = new Game(level);
        game.startGame();
        this.frame.dispose();
    }

    private void mainMenuBut() {
        game.frame.dispose();
        MainScreen main = new MainScreen();
        main.showScreen();
        frame.dispose();
    }
}
