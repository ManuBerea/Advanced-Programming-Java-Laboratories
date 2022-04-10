package lab6.compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    boolean createGame=false;

    Stack<BufferedImage> stackOfImages;

    public MainFrame() {
        super("My Game");
        stackOfImages = new Stack<>();
        init();
        stackOfImages.push(canvas.image);
    }

    private void init() {
        setLocationRelativeTo(null);//pozitioneaza fereastra in centrul ecranului
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        configPanel= new ConfigPanel(this);
        add(configPanel, BorderLayout.NORTH);
        controlPanel= new ControlPanel(this);
        add(controlPanel,BorderLayout.SOUTH);
        canvas=new DrawingPanel(this);
        add(canvas,BorderLayout.CENTER);
        configPanel.getCreate().addActionListener(this::createGame);

        pack();
    }

    private void createGame(ActionEvent event) {

        configPanel.init();
        controlPanel.init();
        createGame=false;
        canvas.init(configPanel.getRows(),configPanel.getCols());
        canvas=new DrawingPanel(this);
        add(canvas,BorderLayout.CENTER);
        repaint();

    }

    public void addImage(BufferedImage img) {
        stackOfImages.push(img);
        System.out.println("added img");
    }

    public void setConfigPanel(ConfigPanel configPanel) {
        this.configPanel = configPanel;
    }

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    public void setCanvas(DrawingPanel canvas) {
        this.canvas = canvas;
    }

    public void setCreateGame(boolean createGame) {
        this.createGame = createGame;
    }

    public void setStackOfImages(Stack<BufferedImage> stackOfImages) {
        this.stackOfImages = stackOfImages;
    }

    public Stack<BufferedImage> getStackOfImages() {
        return stackOfImages;
    }

    public ConfigPanel getConfigPanel() {
        return configPanel;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public DrawingPanel getCanvas() {
        return canvas;
    }

    public boolean isCreateGame() {
        return createGame;
    }
}
