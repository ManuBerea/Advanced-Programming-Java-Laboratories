package com.applications.open;

import com.applications.options.BackButton;
import com.applications.options.Difficulty;
import com.applications.options.Language;
import com.applications.options.SaveOptionsButton;


public class OptionsButton {

    public OptionsButton(MainFrame frame){

        Difficulty difficultyOptions=new Difficulty();
        difficultyOptions.init(frame);
        Language language=new Language();
        language.init(frame);
        SaveOptionsButton saveOptionsButton=new SaveOptionsButton();
        saveOptionsButton.init(frame);
        BackButton backButton=new BackButton();
        backButton.init(frame);
        frame.repaint();
    }

}
