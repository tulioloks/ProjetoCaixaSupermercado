package Entidades;

import Entidades.Pessoa;
import Enums.TipoPessoa;

import java.time.LocalDate;

public class PessoaJuridica extends Pessoa {

    private String razaoSocial;
    private String cnpj;

    private String inscricaoEstadual;




    public PessoaJuridica() {}

    public PessoaJuridica(String nome, String telefone, String email, Endereco endereco, String razaoSocial,
                            String cnpj, String inscricaoEstadual) {

        super(nome, telefone, email, endereco);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;

    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    @Override
    public String getDocumentoPrincipal() {
        return cnpj;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                super.toString() +
                "razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", inscricaoEstadual='" + inscricaoEstadual + '\'' +
                '}';
    }
}
