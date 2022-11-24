package Repository;

import Entidades.Endereco;
import Entidades.Funcionario;
import Entidades.PessoaFisica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    static List<Funcionario> funcionarios = new ArrayList<>();

    public static void carregarDados() {


        PessoaFisica pf = new PessoaFisica("Weber",
                "40028922",
                "weberM@gmail.com",
                new Endereco("Centro", "Criciuma", "Av.centenario", 10),
                "525789123-32",
                LocalDate.now());


        funcionarios.add(new Funcionario(funcionarios.size() + 1,
                         pf,
                         LocalDate.now(),
                       "123456789"));


        PessoaFisica pf1 = new PessoaFisica("Tulio",
                "12345678",
                "tulioGabrielDm@gmail.com",
                new Endereco("São luis", "Criciuma", "Washington Luis", 15),
                "525759324-88",
                LocalDate.now());

        funcionarios.add(new Funcionario(funcionarios.size() + 1,
                            pf1,
                            LocalDate.now(),
                            "432156702"));
    }

    public static List<Funcionario> buscarTodos() {
        return funcionarios;
    }




}
