package Repository;

import Entidades.ItemVenda;
import Entidades.Venda;

import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    public static List<Venda> venda = new ArrayList<>();

        public static void salvar(Venda vendas) {
            venda.add(vendas);
        }

    public static List<Venda> buscarTodos() {
        //System.out.println(venda);
        return venda;
    }

        public static Object[] findVendaInArray() {
            List<Venda> produtos = Repository.VendaDAO.buscarTodos();
            List<Integer> produtosDescricao = new ArrayList<>();

            for (Venda venda : produtos) {
                produtosDescricao.add(venda.getNumber());
            }

            return produtosDescricao.toArray();
        }

    public List<Venda> buscarPorCodigo(Object selection) {
        List<Venda> vendasFiltradas = new ArrayList<>();
        for (Venda vendas : venda) {
            if (vendas.getNumber().equals(selection)) {
                vendasFiltradas.add(vendas);
            }
        }
        return vendasFiltradas;
    }
}
