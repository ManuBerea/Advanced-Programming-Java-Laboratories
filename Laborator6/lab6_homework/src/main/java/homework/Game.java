package homework;
import lab6.compulsory.*;

public class Game {

    private int id;
    private Player player1,player2;

    /**
     * contructor
     * @param id
     * @param player1
     * @param player2
     */
    public Game(int id,Player player1, Player player2)
    {
        new MainFrame().setVisible(true);
        this.id=id;
        this.player1=player1;
        this.player2=player2;
    }

}
