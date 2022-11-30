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
        ItemVenda item1 = new ItemVenda();
        ItemVenda item2 = new ItemVenda();
        ItemVenda item3 = new ItemVenda();

        item.setNumero(10);
        item.setNomeProduto("Batata");
        item.setValorUnitario(4.99);
        item.setQuantidade(10);

        item1.setNumero(20);
        item1.setNomeProduto("Arroz");
        item1.setValorUnitario(5.35);
        item1.setQuantidade(20);

        item2.setNumero(30);
        item2.setNomeProduto("Feijão");
        item2.setValorUnitario(12.50);
        item2.setQuantidade(30);

        item3.setNumero(40);
        item3.setNomeProduto("Chocolate");
        item3.setValorUnitario(10.50);
        item3.setQuantidade(40);

        produtos.add(item);
        produtos.add(item1);
        produtos.add(item2);
        produtos.add(item3);
    }

    public static void salvar(ItemVenda produto) {
        produtos.add(produto);

    }

    public static List<ItemVenda> buscarTodos() {
        return produtos;
    }

    public static void excluirItens(ItemVenda itemVenda){
        produtos.remove(itemVenda);
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
