
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.event.KeyListener;
import javax.swing.*;

public class PanDisp extends JPanel {

    JLabel lblOutput;
//    JLabel lblGuess;
    JButton btnUpdateLabel;
    Image imgPkmn;
    FraImg fraImg;
    String sSecret = "*******";
    int nCorrect, nIncorrect;
    String sInput;
    String sWord = "pikachu";
    char chInput;
    JTextField txtInput;

    public PanDisp() {//Constructor

//        KeyInput keyInput = new KeyInput();
//        KeyInput.LabelChangeListener labelChange = keyInput.new LabelChangeListener();
        KeyInput keyInput = new KeyInput();
        KeyInput.LabelChangeListener lblchangelistener = keyInput.new LabelChangeListener();

        txtInput = new JTextField(1);
        txtInput.addActionListener(lblchangelistener);
        lblOutput = new JLabel(sSecret);
        btnUpdateLabel = new JButton("Enter");
        nCorrect = 0;
        nIncorrect = 0;
        btnUpdateLabel.addActionListener(lblchangelistener);
        add(lblOutput);
        add(txtInput);
        add(btnUpdateLabel);
        //addKeyListener(new KeyInput());
        setFocusable(true);
        //btnUpdateLabel.addActionListener(labelChange);
        fraImg = new FraImg(imgPkmn);
        //fraImg.main();

    }

    public void GameOver() {
    }

    public void game() {
        KeyInput keyInput = new KeyInput();
        KeyInput.LabelChangeListener labelChange = keyInput.new LabelChangeListener();
    }

    class KeyInput implements KeyListener {
//        String sInput;
//        String sWord = "pikachu";
//        String sSecret = "*******";
//        char chInput;

        @Override
        public void keyTyped(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            chInput = (char) e.getKeyChar();
            sInput = String.valueOf(chInput); // convert the char to a String
            txtInput.setText(sInput);
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

        class LabelChangeListener implements ActionListener {

            int i;
            String sNewWord = "";
//            PanDisp panDisp = new PanDisp();

            public LabelChangeListener() {
            }

            @Override
            public void actionPerformed(ActionEvent event) {
                sInput = txtInput.getText();
                // sInput = String.valueOf(chInput); // convert the char to a String
                //  txtInput.setText(sInput);
                Character ch = sInput.charAt(0);

                for (int i = 0; i < sWord.length(); i++) {
                    if (sWord.charAt(i) == ch) {
                        if (sNewWord.length() >= 7) {
                            sNewWord.replace(sNewWord.charAt(i), ch);
                        } else {
                            sNewWord += ch;
                        }
                    } else {
                        if (sNewWord.length() >= 7) {
                            sNewWord += "";
                        } else {
                            sNewWord += "*";
                        }
                    }
                }
                lblOutput.setText(sNewWord);
            }
            PanDisp panDisp = new PanDisp();
            panDisp.game();
        }
    }
}