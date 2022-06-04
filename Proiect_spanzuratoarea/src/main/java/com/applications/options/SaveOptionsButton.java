package com.applications.options;

import com.applications.open.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SaveOptionsButton {

    private MainFrame frame;

    public void init(MainFrame frame){
        this.frame=frame;
        JButton saveButton=new JButton("Save");
        saveButton.setBounds(640,490,100,30);
        saveButton.setBackground(Color.CYAN);
        saveButton.addActionListener(actionEvent1 -> {
            try {
                saveAction();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        frame.add(saveButton);
    }

    private void saveAction() throws IOException {
        frame.dispose();
        frame = new MainFrame();
        frame.setVisible(true);
        frame.setSize(900,600);
    }
}
