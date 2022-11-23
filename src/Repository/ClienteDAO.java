package Repository;

import java.util.ArrayList;
import java.util.List;
import Entidades.Cliente;
import Entidades.Pessoa;
import Entidades.PessoaFisica;
import Entidades.PessoaJuridica;
import Enums.TipoPessoa;


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

    public static void excluir(Integer id) {
        clientes.remove(id);
    }

    public static void editar() {

    }


    public static List<Cliente> buscarTodos() {
        System.out.println(clientes);
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

    public static Cliente findClientesbyDocumentoPrincipal(String numDocumento) {
        List<Cliente> clientes = ClienteDAO.buscarTodos();
        Cliente cliente1 = new Cliente();
        for (Cliente cliente: clientes) {
            if (cliente.getPessoa().getDocumentoPrincipal().equals(numDocumento)) {
                cliente1 = cliente;
            }
        }

        return cliente1;
    }



}

