package com.applications.options;

import com.applications.open.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Difficulty {
    public static String difficulty = "easy";

    public void init(MainFrame frame) {

        JLabel difficultyLabel = new JLabel("Difficulty:");
        difficultyLabel.setBounds(50, 50, 100, 50);
        difficultyLabel.setFont(new Font("Serif", Font.BOLD, 20));
        difficultyLabel.setForeground(Color.BLUE);

        JRadioButton easyChoice = new JRadioButton("Easy");
        JRadioButton mediumChoice = new JRadioButton("Medium");
        JRadioButton hardChoice = new JRadioButton("Hard");
        easyChoice.setBounds(150, 100, 100, 30);
        mediumChoice.setBounds(150, 150, 100, 30);
        hardChoice.setBounds(150, 200, 100, 30);

        ButtonGroup buttonGroupDifficulty = new ButtonGroup();
        buttonGroupDifficulty.add(easyChoice);
        buttonGroupDifficulty.add(mediumChoice);
        buttonGroupDifficulty.add(hardChoice);

        easyChoice.addActionListener(this::setEasyChoice);
        mediumChoice.addActionListener(this::setMediumChoice);
        hardChoice.addActionListener(this::setHardChoice);

        ButtonModel modelLanguage;
        if (difficulty.equals("hard")) {
            modelLanguage = hardChoice.getModel();
        } else if (difficulty.equals("medium")){
            modelLanguage = mediumChoice.getModel();
        }
        else {
            modelLanguage = easyChoice.getModel();
        }
        buttonGroupDifficulty.setSelected(modelLanguage, true);

        frame.add(difficultyLabel);
        frame.add(easyChoice);
        frame.add(mediumChoice);
        frame.add(hardChoice);
    }

    private void setEasyChoice(ActionEvent actionEvent1) {
        difficulty = "easy";
    }

    private void setMediumChoice(ActionEvent actionEvent1) {
        difficulty = "medium";
    }

    private void setHardChoice(ActionEvent actionEvent1) {
        difficulty = "hard";
    }

}
