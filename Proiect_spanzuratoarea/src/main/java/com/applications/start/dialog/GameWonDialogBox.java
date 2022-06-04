package com.applications.start.dialog;

import com.applications.open.MainFrame;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class GameWonDialogBox extends DialogBox {

    @Override
    public void initMessage(MainFrame frame) throws SQLException, IOException {
        int x = JOptionPane.showConfirmDialog(frame,"CONGRATULATIONS! \n \nYou want to restart the game?","\uD83E\uDD73" + "YOU WON THE GAME!",JOptionPane.YES_NO_OPTION);
        printDialogBox(frame,x);
    }

}
