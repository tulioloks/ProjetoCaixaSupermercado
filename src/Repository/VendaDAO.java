package Repository;

import Entidades.ItemVenda;
import Entidades.Venda;

import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

        static List<Venda> venda = new ArrayList<>();

        public static void salvar(Venda vendas) {
            venda.add(vendas);
        }


        public static Object[] findProdutosInArray() {
            List<ItemVenda> produtos = Repository.ProdutoDAO.buscarTodos();
            List<String> produtosDescricao = new ArrayList<>();

            for (ItemVenda produto : produtos) {
                produtosDescricao.add(produto.getNomeProduto());
            }

            return produtosDescricao.toArray();
        }
}
