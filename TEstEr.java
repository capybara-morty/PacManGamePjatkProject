import javax.swing.*;

public class TEstEr {
    public static void main(String[] args) {
        JFrame test = new JFrame();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setSize(400, 300);
        test.setLocationRelativeTo(null);  // Center the frame
        test.setVisible(true);
        ImageIcon wall = new ImageIcon("PNGs/Brick.png");
        ImageIcon point = new ImageIcon("PNGs/PointCell.png");
        ImageIcon[][] icons = { {wall, point, wall},
                                {point, wall, point},
                                {wall, point, wall} };
        String[] columnNames = {"Column 1", "Column 2", "Column 3"};
        JPanel panel = new JPanel();

        JTable table = new JTable(icons, columnNames);
        panel.setVisible(true);
        table.setVisible(true);
        panel.add(table);
        test.add(panel);
    }
}
