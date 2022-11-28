package Repository;

import Entidades.Endereco;
import Entidades.PessoaFisica;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDAO {

    static List<PessoaFisica> pessoasF = new ArrayList<>();

    public static void carregarDados() {
        PessoaFisica pf = new PessoaFisica("Weber",
                "40028922",
                "weberM@gmail.com",
                new Endereco("Centro", "Criciuma", "Av.centenario", 10),
                "525.759.228-18",
                LocalDate.now());

        salvar(pf);

        PessoaFisica pf1 = new PessoaFisica("Tulio",
                "12345678",
                "tulioGabrielDm@gmail.com",
                new Endereco("São luis", "Criciuma", "Washington Luis", 15),
                "123.456.789-10",
                LocalDate.now());

        salvar(pf1);
    }


    public static void salvar(PessoaFisica pessoa) {
        pessoasF.add(pessoa);
    }

    public static void excluir(PessoaFisica pf) {
        pessoasF.remove(pf);
    }

    public static void editar(PessoaFisica pf) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        pf.setNome(JOptionPane.showInputDialog(null, "Digite o nome: ", pf.getNome()));
        pf.setTelefone(JOptionPane.showInputDialog(null, "Digite o telefone: ", pf.getTelefone()));

        String cpfAntigo = pf.getCpf();
        String cpfNovo;
        while (true) {
           cpfNovo = JOptionPane.showInputDialog(null, "Digite o cpf", cpfAntigo);

           if (cpfNovo.length() > 0 && buscarPorCpf(cpfNovo) != null && !cpfNovo.equals(cpfAntigo)) {
                JOptionPane.showMessageDialog(null, "Já existe um cadastro com este Cpf", "", JOptionPane.ERROR_MESSAGE);
                continue;
            }
           else if (cpfNovo.length() == 0) {
             JOptionPane.showMessageDialog(null, "Erro! Cpf é um dado obrigatório");
             continue;
           }

            break;
        }
        pf.setCpf(cpfNovo);

        pf.setEmail(JOptionPane.showInputDialog(null, "Digite o e-mail: ", pf.getEmail()));

        while (true) {
            try {
                pf.setDataNascimento(LocalDate.parse(JOptionPane.showInputDialog(null, "Digite a data de nascimento no formato (dd/MM/yyyy)", pf.getDataNascimento().format(formatter).toString()), formatter));
                break;
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Erro! A data informada não esta no formato correto, tente novamente", "Erro de formato de data", JOptionPane.ERROR_MESSAGE);
            }
        }

        Endereco endereco = pf.getEndereco();
        endereco.setRua(JOptionPane.showInputDialog(null, "Digite o nome da Rua", endereco.getRua()));
        endereco.setBairro(JOptionPane.showInputDialog(null, "Digite o nome do Bairro", endereco.getBairro()));
        endereco.setCidade(JOptionPane.showInputDialog(null, "Digite o nome da Cidade", endereco.getCidade()));

        while (true) {
            try {
                endereco.setNumero(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número do endereço", endereco.getNumero())));
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro! informe apenas números", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        pf.setEndereco(endereco);
    }

    public static List<PessoaFisica> buscarTodos() {
        return pessoasF;
    }

    public static PessoaFisica buscarPorNome(String nome) {
        PessoaFisica pfFiltrada = null;
        for (PessoaFisica pf : pessoasF) {
            if (pf.getNome().equals(nome)) {
                pfFiltrada = pf;
            }
        }
        return pfFiltrada;
    }

    public static Object[] findPessoasInArray() {
        List<PessoaFisica> pessoasFisicas = PessoaFisicaDAO.buscarTodos();
        List<String> pfNomes = new ArrayList<>();

        for (PessoaFisica pessoa : pessoasF) {
            pfNomes.add(pessoa.getNome());

        }

        return pfNomes.toArray();
    }

    public static PessoaFisica buscarPorCpf(String cpf) {

        for (PessoaFisica pf: pessoasF) {
            if (pf.getCpf().equals(cpf)) {
                return pf;
            }
        }

        return null;
    }
}
