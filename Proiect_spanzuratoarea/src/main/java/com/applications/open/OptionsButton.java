package com.applications.open;

import com.applications.options.BackButton;
import com.applications.options.Difficulty;
import com.applications.options.Language;
import com.applications.options.SaveOptionsButton;


public class OptionsButton {

    public OptionsButton(MainFrame frame){

        new Difficulty(frame);
        new Language(frame);
        new SaveOptionsButton(frame);
        new BackButton(frame);

        frame.repaint();
    }
}
