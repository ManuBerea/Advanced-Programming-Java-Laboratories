package com.applications.start.dialog;

import com.applications.open.MainFrame;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class GameLostDialogBox extends DialogBox {

    @Override
    public void initMessage(MainFrame frame) throws SQLException, IOException {
        int x = JOptionPane.showConfirmDialog(frame,"You want to restart the game?","\uD83D\uDE25" + " YOU LOST THE GAME",JOptionPane.YES_NO_OPTION);
        printDialogBox(frame,x);
    }
}
