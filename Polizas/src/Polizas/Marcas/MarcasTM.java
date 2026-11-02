package Polizas.Marcas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MarcasTM extends AbstractTableModel {
    private List<Marca> marcasLista = new ArrayList<>();
    private final String[] encabezados = {"id", "nombre"};
    
    public void setLista(List<Marca> lista) {
        this.marcasLista = lista;
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() { return marcasLista.size(); }
    
    @Override
    public int getColumnCount() { return encabezados.length; }
    
    @Override
    public String getColumnName(int col) { return encabezados[col]; }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Marca m = marcasLista.get(rowIndex);
        return columnIndex == 0 ? m.getId() : m.getNombre();
    }
}