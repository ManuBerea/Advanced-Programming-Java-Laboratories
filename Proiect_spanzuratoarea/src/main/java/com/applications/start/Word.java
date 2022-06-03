package com.applications.start;
import com.database.DatabaseConnection;
import com.applications.open.MainFrame;
import com.applications.options.Difficulty;
import com.applications.options.Language;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Word {
    private final MainFrame frame;
    private JLabel wordDisplayed;
    private final StringBuilder uncompletedWord = new StringBuilder();
    private final StringBuilder wordWithSpaces = new StringBuilder();
    private char firstLetter;
    private String randomWord;

    public Word(MainFrame frame) throws SQLException {
        this.frame = frame;
        initWord();
    }

    private void initWord() throws SQLException {
        randomWord = getRandomWord(Language.language, Difficulty.difficulty);
        firstLetter = randomWord.charAt(0);

        putSpaces(randomWord);
        System.out.println(wordWithSpaces);
        for(int i = 0; i < randomWord.length(); i++) {
            if (randomWord.charAt(i) == firstLetter && !Difficulty.difficulty.equals("hard")) {
                uncompletedWord.append(firstLetter).append(" ");
            }
            else {
                uncompletedWord.append("_ ");
            }
        }

        wordDisplayed = new JLabel(String.valueOf(uncompletedWord));
        wordDisplayed.setFont(new Font("Serif", Font.BOLD, 30));
        wordDisplayed.setForeground(Color.BLACK);
        wordDisplayed.setBounds(400, 100, 400, 100);
        frame.add(wordDisplayed);
    }

    public void putSpaces(String randomWord) {
        for(int i = 0; i < randomWord.length(); i++){
            wordWithSpaces.append(randomWord.charAt(i));
            wordWithSpaces.append(" ");
        }
    }
    public String getWord(){
        return randomWord;
    }

    public String getRandomWord(String language, String difficulty) throws SQLException {
        String randomEngEasyWord = null, randomEngMediumWord = null, randomEngHardWord = null, randomRoEasyWord = null, randomRoMediumWord = null, randomRoHardWord = null;
        Connection conn = DatabaseConnection.getInstance().getConnection();
        try (Statement stmt = conn.createStatement();

             ResultSet result1 = stmt.executeQuery(
                     "SELECT word_name FROM" +
                             "( SELECT word_name FROM words where word_language = 'romanian' and word_difficulty = 'easy'" +
                             "ORDER BY dbms_random.value )" +
                             "WHERE rownum = 1")
        ) {
            result1.next();
            randomRoEasyWord = result1.getString(1);

            ResultSet result2 = stmt.executeQuery(
                    "SELECT word_name FROM" +
                            "( SELECT word_name FROM words where word_language = 'romanian' and word_difficulty = 'medium'" +
                            "ORDER BY dbms_random.value )" +
                            "WHERE rownum = 1");
            result2.next();
            randomRoMediumWord = result2.getString(1);

            ResultSet result3 = stmt.executeQuery(
                    "SELECT word_name FROM" +
                            "( SELECT word_name FROM words where word_language = 'romanian' and word_difficulty = 'hard'" +
                            "ORDER BY dbms_random.value )" +
                            "WHERE rownum = 1");
            result3.next();
            randomRoHardWord = result3.getString(1);

            ResultSet result4 = stmt.executeQuery(
                    "SELECT word_name FROM" +
                            "( SELECT word_name FROM words where word_language = 'english' and word_difficulty = 'easy'" +
                            "ORDER BY dbms_random.value )" +
                            "WHERE rownum = 1");
            result4.next();
            randomEngEasyWord = result4.getString(1);

            ResultSet result5 = stmt.executeQuery(
                    "SELECT word_name FROM" +
                            "( SELECT word_name FROM words where word_language = 'english' and word_difficulty = 'medium'" +
                            "ORDER BY dbms_random.value )" +
                            "WHERE rownum = 1");
            result5.next();
            randomEngMediumWord = result5.getString(1);

            ResultSet result6 = stmt.executeQuery(
                    "SELECT word_name FROM" +
                            "( SELECT word_name FROM words where word_language = 'english' and word_difficulty = 'hard'" +
                            "ORDER BY dbms_random.value )" +
                            "WHERE rownum = 1");
            result6.next();
            randomEngHardWord = result6.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (language.equals("romanian") && difficulty.equals("easy")) {
            return randomRoEasyWord;
        } else if (language.equals("romanian") && difficulty.equals("medium")) {
            return randomRoMediumWord;
        } else if (language.equals("romanian") && difficulty.equals("hard")) {
            return randomRoHardWord;
        } else if (language.equals("english") && difficulty.equals("easy")) {
            return randomEngEasyWord;
        } else if (language.equals("english") && difficulty.equals("medium")) {
            return randomEngMediumWord;
        } else if (language.equals("english") && difficulty.equals("hard")) {
            return randomEngHardWord;
        } else {
            return null;
        }
    }

    public JLabel getWordDisplayed() {
        return wordDisplayed;
    }

    public StringBuilder getUncompletedWord() {
        return uncompletedWord;
    }

    public StringBuilder getWordWithSpaces() {
        return wordWithSpaces;
    }

    public char getFirstLetter() {
        return firstLetter;
    }
}
