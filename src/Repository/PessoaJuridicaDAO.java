package Repository;

import Entidades.Endereco;
import Entidades.PessoaFisica;
import Entidades.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAO {

    static List<PessoaJuridica> pessoasJ = new ArrayList<>();

    public static void carregarDados() {

        PessoaJuridica pj = new PessoaJuridica("betha sistemas",
                                  "4834324040",
                                  "betha@betha.com.br",
                                  new Endereco("88811-235", "..", "Pio Corrêa","Criciuma", "Criciuma", "SC", 320),
                                  "Betha Sistemas",
                                  "12.456.789/0001-12",
                                    "101112405");
        salvar(pj);

        PessoaJuridica pj1 = new PessoaJuridica("Mecanica do Tio joão",
                                    "48996724089",
                                    "mecanicatiojoao@gmail.com",
                                    new Endereco("88803-240", "..", "Ana maria", "Criciuma", "Criciuma", "SC", 405),
                                    "Mecanica do tio joão Ltda.",
                                    "40.324.455/0001-02",
                                    "123457890");

        salvar(pj1);
    }

    public static void salvar(PessoaJuridica pessoa) {
        pessoasJ.add(pessoa);
    }


    public static void excluir(Integer id) {
        pessoasJ.remove(id);
    }

    public static List<PessoaJuridica> buscarTodos() {
        System.out.println(pessoasJ);
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
