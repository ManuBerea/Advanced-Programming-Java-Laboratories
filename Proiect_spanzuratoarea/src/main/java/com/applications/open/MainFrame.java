package com.applications.open;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

public class MainFrame extends JFrame implements Serializable {

    private final MainFrame frame;
    private final JButton start=new JButton  ("Start");
    private final JButton options=new JButton("Options");

    public MainFrame() throws IOException {
        super("Hangman");
        frame=this;
        init();
    }

    private void init() throws IOException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\manub\\IdeaProjects\\Proiect_spanzuratoarea\\src\\main\\resources\\hangman_start.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));

        start.addActionListener(e1 -> {
            try {
                startFunction();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        });
        options.addActionListener(e2 -> optionsFunction());
        start.setPreferredSize(new Dimension(210,600));
        options.setPreferredSize(new Dimension(210,600));

        this.add(picLabel,BorderLayout.CENTER);
        add(start, BorderLayout.WEST);
        add(options,BorderLayout.EAST);

    }

    private void optionsFunction() {
        frame.getContentPane().removeAll();
        new OptionsButton(frame);
    }

    private void startFunction() throws IOException, SQLException {
        frame.getContentPane().removeAll();
        new StartButton(frame);
    }

}
