package Repository;

import Entidades.Endereco;
import Entidades.PessoaFisica;
import Entidades.PessoaJuridica;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAO {

    static List<PessoaJuridica> pessoasJ = new ArrayList<>();

    public static void carregarDados() {

        PessoaJuridica pj = new PessoaJuridica("betha sistemas",
                                  "4834324040",
                                  "betha@betha.com.br",
                                  new Endereco("Centro", "Joinville", "Av. santos dummont", 10),
                                  "Betha Sistemas",
                                  "12.345.678/0001-90",
                                    "101112405");
        salvar(pj);

        PessoaJuridica pj1 = new PessoaJuridica("Mecanica do Tio joão",
                                    "48996724089",
                                    "mecanicatiojoao@gmail.com",
                                    new Endereco("Ana maria", "Criciuma", "123deOliveira4", 5),
                                    "Mecanica do tio joão Ltda.",
                                    "01.234.567/0001-89",
                                    "123457890");

        salvar(pj1);
    }

    public static void salvar(PessoaJuridica pessoa) {
        pessoasJ.add(pessoa);
    }


    public static void excluir(PessoaJuridica pj) {
        pessoasJ.remove(pj);
    }

    public static void editar(PessoaJuridica pj) {

        pj.setNome(JOptionPane.showInputDialog(null, "Digite o nome: ", pj.getNome()));
        pj.setRazaoSocial(JOptionPane.showInputDialog(null, "Digite a razão social: ", pj.getRazaoSocial()));
        pj.setInscricaoEstadual(JOptionPane.showInputDialog(null, "Digite a inscrição estadual: ", pj.getInscricaoEstadual()));
        pj.setTelefone(JOptionPane.showInputDialog(null, "Digite o telefone: ", pj.getTelefone()));

        String cnpjAntigo = pj.getCnpj();
        String cnpjNovo;
        while (true) {
            cnpjNovo = JOptionPane.showInputDialog(null, "Digite o cnpj", cnpjAntigo);

            if (cnpjNovo.length() > 0 && buscarPorCnpj(cnpjNovo) != null && !cnpjNovo.equals(cnpjAntigo)) {
                JOptionPane.showMessageDialog(null, "Já existe um cadastro com este cnpj", "", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            else if (cnpjNovo.length() == 0) {
                JOptionPane.showMessageDialog(null, "Erro! cnpj é um dado obrigatório");
                continue;
            }

            break;
        }
        pj.setCnpj(cnpjNovo);

        pj.setEmail(JOptionPane.showInputDialog(null, "Digite o e-mail: ", pj.getEmail()));



        Endereco endereco = pj.getEndereco();
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

        pj.setEndereco(endereco);
    }

    public static List<PessoaJuridica> buscarTodos() {
        return pessoasJ;
    }

    public static List<PessoaJuridica> buscarPorNome(String nome) {
        List<PessoaJuridica> pjFiltradas = new ArrayList<>();
        for (PessoaJuridica pj : pessoasJ) {
            if (pj.getNome().contains(nome)) {
                pjFiltradas.add(pj);
            }
        }
        return pjFiltradas;
    }

    public static Object[] findPessoasJInArray() {
        List<PessoaJuridica> pessoasFisicas = PessoaJuridicaDAO.buscarTodos();
        List<String> pjNomes = new ArrayList<>();

        for (PessoaJuridica pj : pessoasJ) {
            pjNomes.add(pj.getNome());

        }

        return pjNomes.toArray();
    }

    public static PessoaJuridica buscarPorCnpj (String cnpj) {

        for (PessoaJuridica pf: pessoasJ) {
            if (pf.getCnpj().equals(cnpj)) {
                return pf;
            }
        }

        return null;
    }
}
