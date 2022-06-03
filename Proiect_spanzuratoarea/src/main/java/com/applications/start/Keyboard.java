package com.applications.start;

import com.applications.open.MainFrame;
import com.applications.start.dialog.GameLostDialogBox;
import com.applications.start.dialog.GameWonDialogBox;
import com.applications.options.Difficulty;
import com.applications.options.Language;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;


public class Keyboard implements ActionListener {

    private final MainFrame frame;
    private JButton butA, butĂ, butÂ, butB, butC, butD, butE, butF, butG, butH, butI, butÎ, butJ, butK, butL,
            butM, butN, butO, butP, butQ, butR, butS, butȘ, butT, butȚ, butU, butV, butW, butX, butY, butZ, hintButton;

    private final JLabel wordDisplayed;
    private final StringBuilder uncompletedWord;
    private final StringBuilder wordWithSpaces;
    private final char firstLetter;
    private char randomLetter;
    private int numberOfWrongPicks = 0;
    private JLabel hangmanPic;
    private String randomWord;

    public Keyboard(MainFrame frame, JLabel hangmanPic) throws SQLException {
        this.frame = frame;
        this.hangmanPic = hangmanPic;

        Word myWord = new Word(frame);
        wordDisplayed = myWord.getWordDisplayed();
        uncompletedWord = myWord.getUncompletedWord();
        wordWithSpaces = myWord.getWordWithSpaces();
        firstLetter = myWord.getFirstLetter();
        randomWord = myWord.getWord();

        initLetters();
    }

    public void verifyLetter(char letter) throws IOException, SQLException {

        boolean letterFound = false;
        for (int i = 0; i < wordWithSpaces.length(); i += 2) {
            if (wordWithSpaces.charAt(i) == letter) {
                uncompletedWord.setCharAt(i, letter);
                letterFound = true;
            }
        }

        wordDisplayed.setText(String.valueOf(uncompletedWord));
        frame.add(wordDisplayed);
        frame.setLayout(null);

        if (!letterFound) {
            numberOfWrongPicks++;
            frame.remove(hangmanPic);
            HangmanPicture hangmanPicture=new HangmanPicture(frame,numberOfWrongPicks);
            this.hangmanPic=hangmanPicture.getPicLabel();
            frame.repaint(10,20,300,500);
        }
        else {
            randomWord = randomWord.replace(String.valueOf(letter), "");
        }

        if(numberOfWrongPicks == 6){
            GameLostDialogBox gameLost=new GameLostDialogBox();
            gameLost.initMessage(frame);
        }
        if(uncompletedWord.compareTo(wordWithSpaces) == 0){
            GameWonDialogBox gameWon=new GameWonDialogBox();
            gameWon.initMessage(frame);
        }
    }

    private char getHintLetter() {
        if(!Difficulty.difficulty.equals("hard")) {
            randomWord = randomWord.replace(String.valueOf(firstLetter), "");
        }
        Random random = new Random();
        int randomInt = random.nextInt(randomWord.length());
        randomLetter = randomWord.charAt(randomInt); // hint
        return randomLetter;
    }

    private void initLetters() {
            butA = new JButton("A");
            butA.addActionListener(this);
            butB = new JButton("B");
            butB.addActionListener(this);
            butC = new JButton("C");
            butC.addActionListener(this);
            butD = new JButton("D");
            butD.addActionListener(this);
            butE = new JButton("E");
            butE.addActionListener(this);
            butF = new JButton("F");
            butF.addActionListener(this);
            butG = new JButton("G");
            butG.addActionListener(this);
            butH = new JButton("H");
            butH.addActionListener(this);
            butI = new JButton("I");
            butI.addActionListener(this);
            butJ = new JButton("J");
            butJ.addActionListener(this);
            butK = new JButton("K");
            butK.addActionListener(this);
            butL = new JButton("L");
            butL.addActionListener(this);
            butM = new JButton("M");
            butM.addActionListener(this);
            butN = new JButton("N");
            butN.addActionListener(this);
            butO = new JButton("O");
            butO.addActionListener(this);
            butP = new JButton("P");
            butP.addActionListener(this);
            butQ = new JButton("Q");
            butQ.addActionListener(this);
            butR = new JButton("R");
            butR.addActionListener(this);
            butS = new JButton("S");
            butS.addActionListener(this);
            butT = new JButton("T");
            butT.addActionListener(this);
            butU = new JButton("U");
            butU.addActionListener(this);
            butV = new JButton("V");
            butV.addActionListener(this);
            butW = new JButton("W");
            butW.addActionListener(this);
            butX = new JButton("X");
            butX.addActionListener(this);
            butY = new JButton("Y");
            butY.addActionListener(this);
            butZ = new JButton("Z");
            butZ.addActionListener(this);

        if(Language.language.equals("romanian")) {
            butĂ = new JButton("Ă");
            butĂ.addActionListener(this);
            butÂ = new JButton("Â");
            butÂ.addActionListener(this);
            butÎ = new JButton("Î");
            butÎ.addActionListener(this);
            butȘ = new JButton("Ș");
            butȘ.addActionListener(this);
            butȚ = new JButton("Ț");
            butȚ.addActionListener(this);

            butA.setBounds(400, 250, 50, 30);
            butĂ.setBounds(450, 250, 50, 30);
            butÂ.setBounds(500, 250, 50, 30);
            butB.setBounds(550, 250, 50, 30);
            butC.setBounds(600, 250, 50, 30);
            butD.setBounds(650, 250, 50, 30);
            butE.setBounds(700, 250, 50, 30);
            butF.setBounds(750, 250, 50, 30);
            butG.setBounds(400, 300, 50, 30);
            butH.setBounds(450, 300, 50, 30);
            butI.setBounds(500, 300, 50, 30);
            butÎ.setBounds(550, 300, 50, 30);
            butJ.setBounds(600, 300, 50, 30);
            butK.setBounds(650, 300, 50, 30);
            butL.setBounds(700, 300, 50, 30);
            butM.setBounds(750, 300, 50, 30);
            butN.setBounds(400, 350, 50, 30);
            butO.setBounds(450, 350, 50, 30);
            butP.setBounds(500, 350, 50, 30);
            butQ.setBounds(550, 350, 50, 30);
            butR.setBounds(600, 350, 50, 30);
            butS.setBounds(650, 350, 50, 30);
            butȘ.setBounds(700, 350, 50, 30);
            butT.setBounds(750, 350, 50, 30);
            butȚ.setBounds(400, 400, 50, 30);
            butU.setBounds(450, 400, 50, 30);
            butV.setBounds(500, 400, 50, 30);
            butW.setBounds(550, 400, 50, 30);
            butX.setBounds(600, 400, 50, 30);
            butY.setBounds(650, 400, 50, 30);
            butZ.setBounds(700, 400, 50, 30);

            frame.add(butĂ); frame.add(butÂ); frame.add(butÎ); frame.add(butȚ); frame.add(butȘ);
        }
        else {
            butA.setBounds(400, 250, 50, 30);
            butB.setBounds(450, 250, 50, 30);
            butC.setBounds(500, 250, 50, 30);
            butD.setBounds(550, 250, 50, 30);
            butE.setBounds(600, 250, 50, 30);
            butF.setBounds(650, 250, 50, 30);
            butG.setBounds(700, 250, 50, 30);
            butH.setBounds(400, 300, 50, 30);
            butI.setBounds(450, 300, 50, 30);
            butJ.setBounds(500, 300, 50, 30);
            butK.setBounds(550, 300, 50, 30);
            butL.setBounds(600, 300, 50, 30);
            butM.setBounds(650, 300, 50, 30);
            butN.setBounds(700, 300, 50, 30);
            butO.setBounds(400, 350, 50, 30);
            butP.setBounds(450, 350, 50, 30);
            butQ.setBounds(500, 350, 50, 30);
            butR.setBounds(550, 350, 50, 30);
            butS.setBounds(600, 350, 50, 30);
            butT.setBounds(650, 350, 50, 30);
            butU.setBounds(700, 350, 50, 30);
            butV.setBounds(400, 400, 50, 30);
            butW.setBounds(450, 400, 50, 30);
            butX.setBounds(500, 400, 50, 30);
            butY.setBounds(550, 400, 50, 30);
            butZ.setBounds(600, 400, 50, 30);
        }

        hintButton = new JButton("Hint");
        hintButton.setBounds(400,490,70,30);
        hintButton.addActionListener(this);
        hintButton.setBackground(Color.lightGray);

        frame.add(butA); frame.add(butB); frame.add(butC); frame.add(butD); frame.add(butE); frame.add(butF); frame.add(butG); frame.add(butH); frame.add(butI);
        frame.add(butJ); frame.add(butK); frame.add(butL); frame.add(butM); frame.add(butN); frame.add(butO); frame.add(butP); frame.add(butQ); frame.add(butR);
        frame.add(butS); frame.add(butT); frame.add(butU); frame.add(butV); frame.add(butW);frame.add(butX); frame.add(butY); frame.add(butZ); frame.add(hintButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        char letter = ' ';
        boolean isHintClicked = false;
        if (butA.equals(e.getSource())) {
            butA.setEnabled(false);
            letter='a';
        } else if (butB.equals(e.getSource())) {
            butB.setEnabled(false);
            letter='b';
        } else if (butC.equals(e.getSource())) {
            butC.setEnabled(false);
            letter='c';
        } else if (butD.equals(e.getSource())) {
            butD.setEnabled(false);
            letter='d';
        } else if (butE.equals(e.getSource())) {
            butE.setEnabled(false);
            letter='e';
        } else if (butF.equals(e.getSource())) {
            butF.setEnabled(false);
            letter='f';
        } else if (butG.equals(e.getSource())) {
            butG.setEnabled(false);
            letter='g';
        } else if (butH.equals(e.getSource())) {
            butH.setEnabled(false);
            letter='h';
        } else if (butI.equals(e.getSource())) {
            butI.setEnabled(false);
            letter='i';
        } else if (butJ.equals(e.getSource())) {
            butJ.setEnabled(false);
            letter='j';
        } else if (butK.equals(e.getSource())) {
            butK.setEnabled(false);
            letter='k';
        } else if (butL.equals(e.getSource())) {
            butL.setEnabled(false);
            letter='l';
        } else if (butM.equals(e.getSource())) {
            butM.setEnabled(false);
            letter='m';
        } else if (butN.equals(e.getSource())) {
            butN.setEnabled(false);
            letter='n';
        } else if (butO.equals(e.getSource())) {
            butO.setEnabled(false);
            letter='o';
        } else if (butP.equals(e.getSource())) {
            butP.setEnabled(false);
            letter='p';
        } else if (butQ.equals(e.getSource())) {
            butQ.setEnabled(false);
            letter='q';
        } else if (butR.equals(e.getSource())) {
            butR.setEnabled(false);
            letter='r';
        } else if (butS.equals(e.getSource())) {
            butS.setEnabled(false);
            letter='s';
        } else if (butT.equals(e.getSource())) {
            butT.setEnabled(false);
            letter='t';
        } else if (butU.equals(e.getSource())) {
            butU.setEnabled(false);
            letter='u';
        } else if (butV.equals(e.getSource())) {
            butV.setEnabled(false);
            letter='v';
        } else if (butW.equals(e.getSource())) {
            butW.setEnabled(false);
            letter='w';
        } else if (butX.equals(e.getSource())) {
            butX.setEnabled(false);
            letter='x';
        } else if (butY.equals(e.getSource())) {
            butY.setEnabled(false);
            letter='y';
        } else if (butZ.equals(e.getSource())) {
            butZ.setEnabled(false);
            letter='z';
        }
        else if(Language.language.equals("romanian")) {
            if (butĂ.equals(e.getSource())) {
                butĂ.setEnabled(false);
                letter = 'ă';
            }
            else if (butÂ.equals(e.getSource())) {
                butÂ.setEnabled(false);
                letter = 'â';
            }
            else if (butÎ.equals(e.getSource())) {
                butÎ.setEnabled(false);
                letter = 'î';
            }
            else if (butȘ.equals(e.getSource())) {
                butȘ.setEnabled(false);
                letter = 'ș';
            }
            else if (butȚ.equals(e.getSource())) {
                butȚ.setEnabled(false);
                letter = 'ț';
            }
        }
        if(hintButton.equals(e.getSource())){
            letter = getHintLetter();
            isHintClicked = true;
        }

        try {
            verifyLetter(letter);
            if(isHintClicked){
                randomWord = randomWord.replace(String.valueOf(randomLetter), "");
            }
        } catch (IOException | SQLException ex) {
            ex.printStackTrace();
        }
    }

}