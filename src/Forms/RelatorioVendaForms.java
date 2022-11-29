package Forms;

import Entidades.Main;
import Entidades.Venda;
import Exceptions.SaidaException;
import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;
public class RelatorioVendaForms extends JPanel{

    private static final long serialVersionUID = 1L;

    public static final String[] nomeColunas =
            {"Núemero da venda", "Status", "Nome Cliente", "Valor Venda","Forma Pagamento",""};

    protected JTable table;
    protected JScrollPane scroller;
    protected TableVenda tabela;

    public RelatorioVendaForms(Vector<Venda> vetorDados) {
        iniciarComponentes(vetorDados);
    }

    public void iniciarComponentes(Vector<Venda> vetorDados) {
        tabela = new TableVenda(nomeColunas, vetorDados);
        table = new JTable();
        table.setModel(tabela);
        table.setSurrendersFocusOnKeystroke(true);
        scroller = new javax.swing.JScrollPane(table);
        table.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 300));

        TableColumn colunaEscondida = table.getColumnModel().getColumn(TableVenda.INDEX_ESCONDIDO);
        colunaEscondida.setMinWidth(2);
        colunaEscondida.setPreferredWidth(2);
        colunaEscondida.setMaxWidth(2);
        setLayout(new BorderLayout());
        add(scroller, BorderLayout.CENTER);
    }

    public static void emitirRelatorio(List<Venda> venda) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame frame = new JFrame("Relatorio");

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    frame.setVisible(false);
                    try {
                        Main.menuDeRelatorios();
                    } catch (SaidaException e) {
                        throw new RuntimeException(e);
                    }
                    ;
                }
            });
            Vector<Venda> vetorDados = new Vector<Venda>();
            for (Venda vendasRealizadas : venda) {
                vetorDados.add(vendasRealizadas);
            }

            frame.getContentPane().add(new RelatorioVendaForms(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
