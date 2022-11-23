package Entidades;

import java.time.LocalDate;

public class Funcionario{

    private Integer idFuncionario;

    private PessoaFisica pessoaFisica;

    private LocalDate dataAdmissao;
    private String numeroNis;

    public Funcionario(Integer idFuncionario ,PessoaFisica pessoaFisica , LocalDate dataAdmissao, String numeroNis) {
        this.pessoaFisica = pessoaFisica;
        this.idFuncionario = idFuncionario;
        this.dataAdmissao = dataAdmissao;
        this.numeroNis = numeroNis;
    }

    public Funcionario() {

    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }


    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getNumeroNis() {
        return numeroNis;
    }

    public void setNumeroNis(String numeroNis) {
        this.numeroNis = numeroNis;
    }
}
