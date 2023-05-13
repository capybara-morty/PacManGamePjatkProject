import javax.swing.*;

public class GameFrame {

    static void createAndShowGame(){
        JFrame gameFrame = new JFrame("PACMAN GAME");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(400, 300);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setResizable(false);
    }

}
