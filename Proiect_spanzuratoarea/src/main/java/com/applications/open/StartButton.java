package com.applications.open;

import com.applications.options.BackButton;
import com.applications.start.HangmanPicture;
import com.applications.start.Keyboard;
import com.applications.start.RestartButton;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class StartButton extends JPanel {

    public StartButton(MainFrame frame) throws IOException, SQLException {

        HangmanPicture hangmanPicture = new HangmanPicture(frame,0);
        JLabel hangmanPic=hangmanPicture.getPicLabel();
        Keyboard keyboard=new Keyboard(frame);
        keyboard.setHangmanPic(hangmanPic);
        RestartButton restartButton=new RestartButton();
        restartButton.init(frame);
        BackButton backButton=new BackButton();
        backButton.init(frame);

        frame.repaint();
    }
}
