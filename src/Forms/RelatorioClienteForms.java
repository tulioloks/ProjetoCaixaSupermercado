package Forms;
import Entidades.Cliente;
import Entidades.Main;
import Exceptions.SaidaException;
import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;

public class RelatorioClienteForms extends JPanel{

        private static final long serialVersionUID = 1L;

        public static final String[] nomeColunas =
                {"Nome", "Documento CPF/CNPJ", "Telefone", ""};

        protected JTable table;
        protected JScrollPane scroller;
        protected TabelaCliente tabela;

        public RelatorioClienteForms(Vector<Cliente> vetorDados) {
            iniciarComponentes(vetorDados);
        }

        public void iniciarComponentes(Vector<Cliente> vetorDados) {
            tabela = new TabelaCliente(nomeColunas, vetorDados);
            table = new JTable();
            table.setModel(tabela);
            table.setSurrendersFocusOnKeystroke(true);
            scroller = new javax.swing.JScrollPane(table);
            table.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 300));

            TableColumn colunaEscondida = table.getColumnModel().getColumn(TableItemVenda.INDEX_ESCONDIDO);
            colunaEscondida.setMinWidth(2);
            colunaEscondida.setPreferredWidth(2);
            colunaEscondida.setMaxWidth(2);
            setLayout(new BorderLayout());
            add(scroller, BorderLayout.CENTER);
        }

        public static void emitirRelatorio(List<Cliente> clientes) {
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
                    }
                });
                Vector<Cliente> vetorDados = new Vector();
                for (Cliente cliente : clientes) {
                    vetorDados.add(cliente);
                }

                frame.getContentPane().add(new Forms.RelatorioClienteForms(vetorDados));
                frame.pack();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
