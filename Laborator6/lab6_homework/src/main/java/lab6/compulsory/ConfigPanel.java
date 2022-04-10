package lab6.compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinnerRow,spinnerCol;
    JButton create;
    int rows, cols;//atributele vor memora nr de randuri si coloane
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
   public void init() {
        //create the label and the spinner
        label = new JLabel("Grid size:");
       if(!frame.createGame) {
          // System.out.println("create game false");
           spinnerRow = new JSpinner(new SpinnerNumberModel(10, 2, 50, 2));
           spinnerCol = new JSpinner(new SpinnerNumberModel(10, 2, 50, 2));
           frame.createGame = true;
       }
        rows=(Integer) spinnerRow.getValue();
        cols=(Integer) spinnerCol.getValue();

        //the create button
        create = new JButton("Create");

        add(label); //JPanel uses FlowLayout by default
        add(spinnerRow);
        add(spinnerCol);
        add(create);
        create.addActionListener(this::createGame);

    }

    private void createGame(ActionEvent event) {
        rows=(Integer) spinnerRow.getValue();
        cols=(Integer) spinnerCol.getValue();
        frame.canvas.removeAll();
        frame.add(frame.canvas, BorderLayout.CENTER);
        frame.canvas.init(rows,cols);

        //System.out.println("ajunge aici");
    }
    /**
     * methodes of setter and getter
     */

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public JButton getCreate() {
        return create;
    }
}
