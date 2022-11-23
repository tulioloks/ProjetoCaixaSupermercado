package Forms;

import Entidades.ItemVenda;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableItemVenda extends AbstractTableModel {
    private static final long serialVersionUID = 1L;

    public static final int INDEX_NOME = 0;
    public static final int INDEX_TIPO = 1;
    public static final int INDEX_DOCUMENTO = 2;
    public static final int INDEX_ESCONDIDO = 3;

    protected String[] nomeColunas;
    protected Vector<ItemVenda> vetorDados;

    public TableItemVenda(String[] columnNames, Vector<ItemVenda> vetorDados) {
        this.nomeColunas = columnNames;
        this.vetorDados = vetorDados;
    }

    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        if (coluna == INDEX_ESCONDIDO) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        ItemVenda registroItem = (ItemVenda) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_NOME:
                return registroItem.getNomeProduto();
            case INDEX_TIPO:
                return registroItem.getValorUnitario();
            case INDEX_DOCUMENTO:
                return registroItem.getQuantidade();
            default:
                return new Object();
        }
    }

    @Override
    public int getRowCount() {
        return vetorDados.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }
}
