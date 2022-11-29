package Repository;

import Entidades.ItemVenda;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    static List<ItemVenda> produtos = new ArrayList<>();

    public ProdutoDAO() {

    }

    public static void produtoPreCarregado(){
        ItemVenda item = new ItemVenda();

        item.setNumero(10);
        item.setNomeProduto("Batata");
        item.setValorUnitario(10.50);
        item.setQuantidade(20);

        produtos.add(item);
    }

    public static void salvar(ItemVenda produto) {
        produtos.add(produto);

    }

    public static List<ItemVenda> buscarTodos() {
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

    public static List<ItemVenda> buscarPorCodigo(Object codigo) {
        List<ItemVenda> produtosFiltrados = new ArrayList<>();
        for (ItemVenda produto : produtos) {
            if (produto.getNumero().equals(codigo)) {
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
