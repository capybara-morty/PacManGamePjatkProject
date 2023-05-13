import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
public class PacmanMap extends JPanel{
    private boolean moveState = true;
    int x,  y;
    int pacmanX = 1;
    int pacmanY = 1;
    private int directionX = 0;
    private int directionY = 0;
    private boolean keepMoving = true;

     ImageIcon [][] mtxMap;
     JTable gameField;
     JTable TimerAndHPBar;

    public PacmanMap(int x, int y){
        this.x = x;
        this.y = y;
        mtxMap = newMatrix(x, y);
        gameField = new JTable(new GameField(mtxMap));
        setVisible(true);
        setBackground(Color.BLACK);
        add(gameField);
        gameField.setTableHeader(null);
        gameField.setBackground(Color.blue);

        int iconWidth = mtxMap[0][0].getIconWidth();
        int iconHeight = mtxMap[0][0].getIconHeight();

        // set the preferred size of the table according to the total size of the icons
        gameField.setPreferredSize(new Dimension(iconWidth * x, iconHeight * y));
        gameField.setRowHeight(iconHeight);
        for (int i = 0; i < gameField.getColumnCount(); i++) {
            gameField.getColumnModel().getColumn(i).setPreferredWidth(iconWidth);
        }

        gameField.setFocusable(true);
        gameField.requestFocusInWindow();
        new Thread(() -> {
            while (keepMoving) {
                movePacman();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        gameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                // Update the direction based on the key pressed
                if (key == KeyEvent.VK_UP) {
                    directionX = 0;
                    directionY = -1;
                } else if (key == KeyEvent.VK_DOWN) {
                    directionX = 0;
                    directionY = 1;
                } else if (key == KeyEvent.VK_LEFT) {
                    directionX = -1;
                    directionY = 0;
                } else if (key == KeyEvent.VK_RIGHT) {
                    directionX = 1;
                    directionY = 0;
                }
            }
        });
    }

    private void movePacman() {
        // Temporary variables for new position
        int newX = pacmanX + directionX;
        int newY = pacmanY + directionY;

        // Check if the new position is not a wall
        if (!mtxMap[newX][newY].getDescription().equals("PNGs/newWall.png")) {
            // Update the old position to a black cell
            mtxMap[pacmanX][pacmanY] = new ImageIcon("PNGs/BlackCell.png");

            // Update the new position to the Pacman
            String pacmanImage;
            if (directionX > 0) { // Moving right
                pacmanImage = moveState ? "PNGs/Screenshot 2023-02-04 180901.png" : "PNGs/PacmanRightMove.png";
            } else if (directionX < 0) { // Moving left
                pacmanImage = moveState ? "PNGs/PacmanLeftDefoult.png" : "PNGs/PacmanLeftMove.png";
            } else if (directionY > 0) { // Moving down
                pacmanImage = moveState ? "PNGs/PacmanDownDefoult.png" : "PNGs/PacmanDownMove.png";
            } else { // Moving up
                pacmanImage = moveState ? "PNGs/PacmanUpDefoult.png" : "PNGs/PacmanUpMove.png";
            }
            mtxMap[newX][newY] = new ImageIcon(pacmanImage);
            pacmanX = newX;
            pacmanY = newY;

            // Switch the move state for next move
            moveState = !moveState;

            // Update the table
            gameField.repaint();
        }
    }





    public ImageIcon[][] newMatrix(int x, int y){
        Random rand = new Random();
        ImageIcon walls = new ImageIcon("PNGs/newWall.png");
        ImageIcon points = new ImageIcon("PNGs/PointCell.png");
        ImageIcon pacman = new ImageIcon("PNGs/Screenshot 2023-02-04 180901.png");


        ImageIcon[][] mtxToReturn1 = new ImageIcon[x][y];


        for (int ix = 0; ix < x; ix++) {
            for (int iy = 0; iy < y; iy++) {
                if (ix == 0 || ix == x - 1 || iy == 0 || iy == y - 1) {
                    mtxToReturn1[ix][iy] = walls;
                } else {
                    mtxToReturn1[ix][iy] = points;
                }
            }
        }


        for (int ix = 2; ix < x - 2; ix += 2) {
            for (int iy = 2; iy < y - 2; iy += 2) {
                if(rand.nextInt(2) == 1){
                    mtxToReturn1[ix][iy] = walls;


                    int dx = rand.nextInt(3) - 1;  // -1, 0, or 1
                    int dy = rand.nextInt(3) - 1;  // -1, 0, or 1
                    mtxToReturn1[ix + dx][iy + dy] = points;
                }
            }
        }

        mtxToReturn1[1][1] = pacman;



        return mtxToReturn1;
    }

    public static void createAndShowGameWindow(int x, int y) {
        SwingUtilities.invokeLater(() -> {


            // Create and set up the window.
            JFrame frame = new JFrame("Pacman Game");
            frame.setLayout(new BorderLayout()); // Set layout manager to BorderLayout
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setIconImage(new ImageIcon("PNGs/purpleGhost.png").getImage());
            frame.setBackground(Color.BLACK);

            // Create game map
            PacmanMap pacmanMap = new PacmanMap(x, y);

            // Create a panel with GridBagLayout.
            JPanel panel = new JPanel(new GridBagLayout()); // GridBagLayout centers components by default
            JPanel HPpanel = new JPanel();
            HPpanel.setBackground(Color.BLACK);


            panel.add(pacmanMap.gameField); // Add to the center of the BorderLayout

            // It's not necessary to set the size of the panel. Let the layout manager handle the size.


            frame.add(panel, BorderLayout.CENTER); // Add the panel to the center of the frame's BorderLayout

            // Display the window.
            frame.pack();
            frame.setMinimumSize(frame.getSize()); // Set the minimum size to the packed size
            frame.setVisible(true);
        });
    }
    public void moveGhost(Ghost type){


    }





}
