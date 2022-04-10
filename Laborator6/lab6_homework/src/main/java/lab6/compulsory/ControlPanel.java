package lab6.compulsory;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton saveBtn = new JButton("Save");
    JButton loadBtn= new JButton("Load");

    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
        init();
    }
    public void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        add(loadBtn, BorderLayout.CENTER);
        add(saveBtn, BorderLayout.CENTER);
        add(exitBtn, BorderLayout.CENTER);
        //configure listeners for all buttons
        exitBtn.addActionListener(this::exit);
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
    }
    private void save(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();

        // Only choose files of this type
        fileChooser.setFileFilter(new FileNameExtensionFilter("*.png", "png"));

        // If the user selects to save the file
        int option = fileChooser.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                ImageIO.write(frame.canvas.image, "PNG", new File(fileToSave.getAbsolutePath()));
                System.out.println("Saved an image.");
            }
            catch (IOException exc) {
                System.out.println(exc.getMessage());
            }
        }
        else if (option == JFileChooser.CANCEL_OPTION) {
            System.out.println("Canceled the saving operation.");
        }
        else {
            System.out.println("An error occurred during saving.");
        }
    }

    private void load(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("*.png", "png"));

        // The user selected to load an image
        int option = fileChooser.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                Image image = ImageIO.read(new File(fileChooser.getSelectedFile().getAbsolutePath()));
                frame.getCanvas().graphics.drawImage(image, 0, 0, frame.getCanvas());
                frame.getCanvas().repaint();
                System.out.println("Loaded an image.");
            }
            catch (IOException exc) {
                System.out.println(exc.getMessage());
            }
        }
        else if (option == JFileChooser.CANCEL_OPTION) {
            System.out.println("Canceled the loading operation.");
        }
        else {
            System.out.println("An error occurred during loading.");
        }
    }

    private void reset(ActionEvent e) {

    }

    private void exit(ActionEvent e) {
        System.out.println("Exited with success!");
        System.exit(0);
    }

}

