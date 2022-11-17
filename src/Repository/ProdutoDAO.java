package Repository;

import Entidades.ItemVenda;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    static List<ItemVenda> produtos = new ArrayList<>();

    public static void salvar(ItemVenda produto) {
        produtos.add(produto);
    }

    public static List<ItemVenda> buscarTodos() {
        System.out.println(produtos);
        return produtos;
    }

    public static List<ItemVenda> buscarPorNome(String descricao) {
        List<ItemVenda> produtosFiltrados = new ArrayList<>();
        for (ItemVenda produto : produtos) {
            if (produto.getNomeProduto().contains(descricao)) {
                produtosFiltrados.add(produto);
            }
        }
        return produtosFiltrados;
    }

    public static Object[] findProdutosInArray() {
        List<ItemVenda> produtos = ProdutoDAO.buscarTodos();
        List<String> produtosDescricao = new ArrayList<>();

        for (ItemVenda produto : produtos) {
            produtosDescricao.add(produto.getNomeProduto());
        }

        return produtosDescricao.toArray();
    }
}
