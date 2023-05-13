import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class PacmanCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // You need to cast the value to integer because it's actually an Integer object.
        int cellValue = (int) value;

        // Color cells based on their value.
        if (cellValue == 1) {
            this.setBackground(Color.YELLOW);
        } else if (cellValue == 0) {
            this.setBackground(Color.DARK_GRAY);
        }

        // Set the text color to be the same as the background so the numbers aren't visible.
        this.setForeground(this.getBackground());

        return this;
    }
}

