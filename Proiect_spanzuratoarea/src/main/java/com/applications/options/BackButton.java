package com.applications.options;

import com.applications.open.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BackButton {
    private MainFrame frame;

    public BackButton(MainFrame frame){
        this.frame=frame;
        init();
    }

    private void init() {
        JButton backButton=new JButton("Back");
        backButton.setBounds(740,490,100,30);
        backButton.setBackground(Color.CYAN);
        backButton.addActionListener(actionEvent -> {
            try {
                backAction();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        frame.add(backButton);
    }

    private void backAction() throws IOException {
        frame.dispose();
        frame = new MainFrame();
        frame.setVisible(true);
        frame.setSize(900,600);
    }

}
