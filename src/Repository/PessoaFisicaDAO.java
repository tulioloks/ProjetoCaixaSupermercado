package Repository;

import Entidades.Endereco;
import Entidades.PessoaFisica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDAO {

    static List<PessoaFisica> pessoasF = new ArrayList<>();

    public static void carregarDados() {
        PessoaFisica pf = new PessoaFisica("Weber",
                "40028922",
                "weberM@gmail.com",
                new Endereco("88804020", "..", "Santa rita", "São Paulo", "Miracatu", "SP", 10),
                "525789123-32",
                LocalDate.now());

        salvar(pf);

        PessoaFisica pf1 = new PessoaFisica("Tulio",
                "12345678",
                "tulioGabrielDm@gmail.com",
                new Endereco("88804589", "..", "São luis", "Criciuma", "Criciuma", "SC", 11),
                "525759324-88",
                LocalDate.now());

        salvar(pf1);

    }


    public static void salvar(PessoaFisica pessoa) {
        pessoasF.add(pessoa);
    }

    public static void excluir(Integer id) {
        pessoasF.remove(id);
    }

    public static void editar() {

    }

    public static List<PessoaFisica> buscarTodos() {
        System.out.println(pessoasF);
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
