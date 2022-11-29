package Entidades;

import Entidades.Pessoa;
import Enums.TipoPessoa;

import java.time.LocalDate;


public class PessoaFisica extends Pessoa {

    private String cpf;
    private LocalDate dataNascimento;


    public PessoaFisica() {}

    public PessoaFisica(String nome, String telefone, String email, Endereco endereco, String cpf,
                        LocalDate dataNascimento) {

        super(nome, telefone, email, endereco);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;

    }

    public PessoaFisica(String cliente_diversos, String aNull, String aNull1, Endereco endereco, String aNull2, LocalDate now, TipoPessoa fisica) {

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String getDocumentoPrincipal() {
        return cpf;
    }


    @Override
    public String toString() {
        return "PessoaFisica{" +
                super.toString() +
                "cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
