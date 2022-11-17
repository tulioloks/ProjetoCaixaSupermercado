package Entidades;

import Enums.TipoPessoa;

public class PessoaFisica extends Pessoa{

    private String cpf;

    public PessoaFisica() {
        setTipo(TipoPessoa.FISICA);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


}