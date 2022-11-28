package Repository;
import java.util.ArrayList;
import java.util.List;
import Entidades.Cliente;
import Entidades.Pessoa;

public final class ClienteDAO {

    static List<Cliente> clientes = new ArrayList<>();

    public static void carregarDados(List<Pessoa> pessoas) {

        for(Pessoa pessoa: pessoas) {
            salvar(pessoa);
        }

    }

    public static void salvar(Pessoa pessoa) {
        clientes.add(new Cliente(clientes.size() + 1,pessoa));
    }

    public static void excluir(Pessoa pessoa) {
        clientes.remove(pessoa);
    }


    public static List<Cliente> buscarTodos() {
        return clientes;
    }

    public static List<Cliente> buscarPorNome(String nome) {
        List<Cliente> clientesFiltrados = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getPessoa().getNome().contains(nome)) {
                clientesFiltrados.add(cliente);
            }
        }
        return clientesFiltrados;
    }

    public static Object[] findClientesInArray() {
        List<Cliente> clientes = ClienteDAO.buscarTodos();
        List<String> nomesClientes = new ArrayList<>();

        for (Cliente cliente : clientes) {
            nomesClientes.add(cliente.getPessoa().getNome());
        }

        return nomesClientes.toArray();
    }


}

