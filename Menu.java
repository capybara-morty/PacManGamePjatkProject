import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {



    static void createAndShowGUI() {
        JFrame frame = new JFrame("Game Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));

        // Start Button
        JButton startButton = createMenuButton("Start");
        startButton.addActionListener(e -> {
            startGame();
            System.out.println("Game Started");
        });

        // High Score Button
        JButton highScoreButton = createMenuButton("High Score");
        highScoreButton.addActionListener(e -> {
            showHighScore();
            System.out.println("High Score");
        });

        // Exit Button
        JButton exitButton = createMenuButton("Exit");
        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        panel.add(startButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(highScoreButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(exitButton);

        frame.add(panel);
        frame.setVisible(true);
    }


    private static JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 24));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(200, 50));
        return button;
    }
}

