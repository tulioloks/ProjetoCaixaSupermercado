package Forms;

import Entidades.ItemVenda;
import Entidades.Venda;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableVenda extends AbstractTableModel {


    private static final long serialVersionUID = 1L;

    public static final int INDEX_NUMERO = 0;
    public static final int INDEX_STATUS = 1;
    public static final int INDEX_CLIENTE = 2;
    public static final int INDEX_TOTAL = 3;
    public static final int INDEX_ESCONDIDO = 4;

    protected String[] nomeColunas;
    protected Vector<Venda> vetorDados;

    public TableVenda(String[] columnNames, Vector<Venda> vetorDados) {
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
        Venda registroItem = (Venda) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_NUMERO:
                return registroItem.getNumber();
            case INDEX_STATUS:
                return registroItem.getStatus();
            case INDEX_CLIENTE:
                return registroItem.getCliente().getPessoa().getNome();
            case INDEX_TOTAL:
                return registroItem.Total();
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
