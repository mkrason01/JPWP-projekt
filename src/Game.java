import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public int level;
    Sentences sent = new Sentences();
    JFrame frame;
    JPanel p;

    public Game(int level) {
        CommonFunctions functions = new CommonFunctions();
        frame = functions.createFrame("game frame", 1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p = functions.createPanel(1024, 768);
        this.level = level;
    }

    JLabel[] letter = new JLabel[3];
    List<JLabel> spaces = new ArrayList<JLabel>();
    List<JLabel> lettersDisp = new ArrayList<JLabel>();
    char[] text;
    int i = 2;
    int x = 1024;
    int y = 768;
    Timer timer;
    int time = 0;
    JLabel timerLabel = new JLabel("-");

    Game game = this;

    public Game() {
        CommonFunctions functions = new CommonFunctions();
        frame = functions.createFrame("game frame", 1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p = functions.createPanel(1024, 768);
    }


    public void startGame() {
        frame.add(p);
        frame.setVisible(true);
        String sentence = sent.sentence(level);
        this.text = this.sentence2char(sentence);
        this.displaySpaces();
        this.displayLetters();
        p.setFocusable(true);
        p.requestFocusInWindow();
        this.showCurrentLetter(sentence);
        p.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e.getKeyChar());
                if (e.getKeyChar() == text[0]) {
                    timer.start();
                }
                if (e.getKeyChar() == text[i - 2] & i < text.length) {
                    System.out.println("good letter");
                    displaySpaces();
                    letter[0].setText(String.valueOf(text[i - 1]));
                    letter[1].setText(String.valueOf(text[i]));
                    letter[2].setText(String.valueOf(text[i + 1]));
                    if (i == text.length - 2) {
                        if (sent.sentTime() >= time) {
                            letter[1].setText("PASSED");
                            System.out.println("PASSED");
                        }
                        if (sent.sentTime() < time) {
                            letter[1].setText("TOO LONG, TRY AGAIN");
                            System.out.println("TOO LONG, TRY AGAIN");
                        }
                        timer.stop();
                        i--;
                        letter[0].setText(" ");
                        letter[1].setLocation(x / 2 - 200, y / 2);
                        letter[2].setText(" ");
                    }
                    i++;
                }

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getExtendedKeyCode() == KeyEvent.VK_ESCAPE) {
                    GameMenu menu = new GameMenu(time, false, level, game);
                    System.out.println("esc pressed");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.showTimer();

        System.out.println(time);


    }

    private char[] sentence2char(String sentence) {
        char[] ch = new char[sentence.length()];
        for (int i = 0; i < sentence.length(); i++) {
            ch[i] = sentence.charAt(i);
        }
        return ch;
    }

    private void showCurrentLetter(String sentence) {
        letter[0] = new JLabel(Character.toString(text[i - 2]));
        letter[1] = new JLabel(Character.toString(text[i - 1]));
        letter[2] = new JLabel(Character.toString(text[i]));
        letter[0].setFont(new Font("Arial", Font.PLAIN, 34));
        letter[1].setFont(new Font("Arial", Font.PLAIN, 34));
        letter[2].setFont(new Font("Arial", Font.PLAIN, 34));
        letter[0].setSize(100, 200);
        letter[1].setSize(1000, 200);
        letter[2].setSize(100, 200);
        letter[0].setLocation(x / 2 - 100, y / 2);
        letter[1].setLocation(x / 2, y / 2);
        letter[2].setLocation(x / 2 + 100, y / 2);
        letter[0].setVisible(true);
        letter[1].setVisible(true);
        letter[2].setVisible(true);
        p.add(letter[0]);
        p.add(letter[1]);
        p.add(letter[2]);
    }

    private void showTimer() {
        timerLabel.setLocation(x / 2, 100);
        timerLabel.setVisible(true);
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 34));
        timerLabel.setSize(100, 200);
        p.add(timerLabel);
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerLabel.setText(String.valueOf(time));
                time++;
            }
        });
    }

    private void displaySpaces() {
        int amount = text.length - 2;
        ImageIcon papaj = new ImageIcon("resources/Gwiazdka.JPG");
        Image imgpapaj = papaj.getImage();
        Image imgScaledPapaj = imgpapaj.getScaledInstance(24, 50, Image.SCALE_SMOOTH);
        ImageIcon picDispPapaj = new ImageIcon(imgScaledPapaj);
        for (int j = 0; j < amount - 1; j++) {
            ImageIcon pic = new ImageIcon("resources/space.JPG");
            Image img = pic.getImage();
            Image imgScaled = img.getScaledInstance(24, 14, Image.SCALE_SMOOTH);
            ImageIcon picDisp = new ImageIcon(imgScaled);
            spaces.add(new JLabel(picDisp));
            spaces.get(j).setIcon(picDisp);
            spaces.get(j).setLocation(100 + j * (1024 - 200) / (amount + 5), 650);
            spaces.get(j).setVisible(true);
            spaces.get(j).setSize((1024 - 200) / (amount + 5) - 3, 10);
            p.add(spaces.get(j));
        }
        spaces.get(i - 2).setIcon(picDispPapaj);
        p.setFocusable(true);
        p.requestFocusInWindow();
    }

    private void displayLetters() {
        int amount = text.length - 2;
        for (int k = 0; k < amount; k++) {
            lettersDisp.add(new JLabel(Character.toString(text[k])));
            lettersDisp.get(k).setFont(new Font("Arial", Font.PLAIN, (1024 - 200) / (amount + 5)));
            lettersDisp.get(k).setLocation(100 + k * (1024 - 200) / (amount + 5), 680);
            lettersDisp.get(k).setVisible(true);
            lettersDisp.get(k).setSize((1024 - 200) / (amount + 5) - 3, 30);
            p.add(lettersDisp.get(k));
        }
    }
}
