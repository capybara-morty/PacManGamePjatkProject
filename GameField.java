import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class GameField extends AbstractTableModel {
    ImageIcon[][] fields;

    public GameField(ImageIcon[][] fields) {
        this.fields = fields;
    }

    public ImageIcon[][] getFields() {
        return fields;
    }
    public Class<?> getColumnClass(int columnIndex){
        return ImageIcon.class;
    }

    @Override
    public int getRowCount() {

        return fields[0].length;
    }

    @Override
    public int getColumnCount() {
        return fields.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return fields[columnIndex][rowIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        return false;
    }
}
