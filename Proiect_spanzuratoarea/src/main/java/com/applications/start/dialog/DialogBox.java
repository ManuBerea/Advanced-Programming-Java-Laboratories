package com.applications.start.dialog;

import com.applications.open.MainFrame;
import com.applications.open.StartButton;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public abstract class DialogBox {

    public abstract void initMessage(MainFrame frame) throws SQLException, IOException;

    public void printDialogBox(MainFrame frame,int x) throws IOException, SQLException {
        if (x == JOptionPane.YES_OPTION) {
            frame.getContentPane().removeAll();
            new StartButton(frame);
            frame.repaint();
        }
        if(x ==JOptionPane.NO_OPTION) {
            frame.dispose();
            frame = new MainFrame();
            frame.setVisible(true);
            frame.setSize(900, 600);
        }
    }
}
