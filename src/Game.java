import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {
    JFrame frame;
    JPanel p;
    char [] text;
    int i=0;
    public Game(){
        CommonFunctions functions = new CommonFunctions();
        frame = functions.createFrame("game frame", 1024, 768);
        p = functions.createPanel(1024, 768);


    }
    public void startGame(){
        frame.add(p);
        String sentence = "bardzo lubie placki";
        this.text = this.sentence2char(sentence);
        p.setFocusable(true);
        p.requestFocusInWindow();
        frame.setVisible(true);

        p.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e.getKeyChar());
                if(e.getKeyChar()==text[i]){
                    System.out.println("pajacu nic nie umiesz");
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
}
