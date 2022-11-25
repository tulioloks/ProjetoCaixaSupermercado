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
        System.out.println(venda);
        return venda;
    }

        public static Object[] findVendaInArray() {
            List<Venda> produtos = Repository.VendaDAO.buscarTodos();
            List<String> produtosDescricao = new ArrayList<>();

            for (Venda venda : produtos) {
                //produtosDescricao.add(venda.());
            }

            return produtosDescricao.toArray();
        }


    public static Object[] findPessoaInArray() {
        List<Venda> produtos = Repository.VendaDAO.buscarTodos();
        List<String> produtosDescricao = new ArrayList<>();

        for (Venda venda : produtos) {
            //produtosDescricao.add(venda.());
        }

        return produtosDescricao.toArray();
    }
}
