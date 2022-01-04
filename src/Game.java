import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game {
    JFrame frame;
    JPanel p;
    JLabel letter;
    char [] text;
    int i=1;
    int x = 1024;
    int y = 768;
    Timer timer;
    int time = 0;
    JLabel timerLabel = new JLabel("-");
    public Game(){
        CommonFunctions functions = new CommonFunctions();
        frame = functions.createFrame("game frame", 1024, 768);
        p = functions.createPanel(1024, 768);


    }
    public void startGame(){
        frame.add(p);
        frame.setVisible(true);
        String sentence = "bardzo lubie placki ";
        this.text = this.sentence2char(sentence);
        p.setFocusable(true);
        p.requestFocusInWindow();
        this.showCurrentLetter(sentence);
        p.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e.getKeyChar());
                if(e.getKeyChar()==text[0]){
                    timer.start();
                }
                if(e.getKeyChar()==text[i-1] & i<text.length){
                    System.out.println("good letter");
                    letter.setText(String.valueOf(text[i]));
                    if(i==text.length-1){
                        letter.setText("PASSED");
                        System.out.println("PASSED");
                        timer.stop();
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


    }

    private char[] sentence2char(String sentence)
    {
        char [] ch = new char [sentence.length()];
        for(int i = 0; i< sentence.length(); i++)
        {
            ch[i] = sentence.charAt(i);
        }
        return ch;
    }
    private void showCurrentLetter(String sentence){
        letter = new JLabel(Character.toString(text[i-1]));
        //letter.setName(Character.toString(text[i-1]));
        letter.setFont(new Font("Arial", Font.PLAIN, 34 ));
        letter.setLocation(x/2, y/2);
        letter.setVisible(true);
        p.add(letter);
    }
    private void showTimer(){
        timerLabel.setLocation(x/10, y/2);
        timerLabel.setVisible(true);
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 34 ));
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
