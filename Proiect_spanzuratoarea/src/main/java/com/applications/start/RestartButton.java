package com.applications.start;

import com.applications.open.MainFrame;
import com.applications.open.StartButton;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class RestartButton {

    private MainFrame frame;

    public void init(MainFrame frame) {
        this.frame=frame;
        JButton restartButton = new JButton("Restart");
        restartButton.setBounds(640, 490, 100, 30);
        restartButton.addActionListener(actionEvent -> {
            try {
                restartAction();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        });
        restartButton.setBackground(Color.CYAN);
        frame.add(restartButton);
    }

    private void restartAction() throws IOException, SQLException {
        frame.getContentPane().removeAll();
        frame.repaint();
        new StartButton(frame);
    }

}
