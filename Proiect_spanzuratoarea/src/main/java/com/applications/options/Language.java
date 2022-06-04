package com.applications.options;

import com.applications.open.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Language {
    public static String language = "english";

    public void init(MainFrame frame) {
        JLabel languageLabel = new JLabel("Language:");
        languageLabel.setBounds(50, 250, 100, 50);
        languageLabel.setFont(new Font("Serif", Font.BOLD, 20));
        languageLabel.setForeground(Color.BLUE);

        JRadioButton englishChoice = new JRadioButton("English");
        JRadioButton romanianChoice = new JRadioButton("Romanian");
        englishChoice.setBounds(150, 300, 200, 50);
        romanianChoice.setBounds(150, 350, 300, 30);

        ButtonGroup buttonGroupLanguage = new ButtonGroup();
        buttonGroupLanguage.add(englishChoice);
        buttonGroupLanguage.add(romanianChoice);

        romanianChoice.addActionListener(this::setRomanianChoice);
        englishChoice.addActionListener(this::setEnglishChoice);

        ButtonModel modelLanguage;
        if (language.equals("romanian")) {
            modelLanguage = romanianChoice.getModel();
        } else {
            modelLanguage = englishChoice.getModel();
        }
        buttonGroupLanguage.setSelected(modelLanguage, true);

        frame.add(languageLabel);
        frame.add(englishChoice);
        frame.add(romanianChoice);
    }

    private void setRomanianChoice(ActionEvent actionEvent1) {
        language = "romanian";
    }

    private void setEnglishChoice(ActionEvent actionEvent1) {
        language = "english";
    }

}
