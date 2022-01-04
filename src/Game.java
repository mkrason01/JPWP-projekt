import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game {
    Sentences sent = new Sentences();
    JFrame frame;
    JPanel p;
    JLabel[] letter = new JLabel[3];
    char[] text;
    int i = 2;
    int x = 1024;
    int y = 768;
    Timer timer;
    int time = 0;
    JLabel timerLabel = new JLabel("-");

    public Game() {
        CommonFunctions functions = new CommonFunctions();
        frame = functions.createFrame("game frame", 1024, 768);
        p = functions.createPanel(1024, 768);


    }

    public void startGame() {
        frame.add(p);
        frame.setVisible(true);
        String sentence = sent.sentence(1);
        this.text = this.sentence2char(sentence);
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

}
