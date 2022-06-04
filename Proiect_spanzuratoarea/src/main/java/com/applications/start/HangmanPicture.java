package com.applications.start;

import com.applications.open.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HangmanPicture {
   private final MainFrame frame;
   private final int numberWrongLetters;
   private JLabel picLabel;

    public HangmanPicture(MainFrame frame, int numberWrongLetters) throws IOException {
        this.numberWrongLetters=numberWrongLetters;
        this.frame=frame;
        init();
    }

    private void init() throws IOException {

        BufferedImage hangmanPicture = ImageIO.read(new File("C:\\Users\\manub\\IdeaProjects\\Proiect_spanzuratoarea\\src\\main\\resources\\hangman"+numberWrongLetters+".png"));
        picLabel = new JLabel(new ImageIcon(hangmanPicture));
        picLabel.setBounds(10,20,300,500);
        setPicLabel(picLabel);
        frame.add(picLabel);
    }

    public void setPicLabel(JLabel picLabel) {
        this.picLabel = picLabel;
    }

    public JLabel getPicLabel() {
        return picLabel;
    }
}
