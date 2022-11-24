package Entidades;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NotaFiscal {

    private Integer inscricaoEstadual;
    private Integer chaveAcesso;
    private LocalDate dataAutorizacao;
    private LocalDate emissao;
    private LocalDate entrada;
    private LocalDate saida;
    private String dadosAdicionais;
    private Integer serie;


    private BigDecimal pesoBruto;

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }


    public Integer getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(Integer inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public Integer getChaveAcesso() {
        return chaveAcesso;
    }

    public void setChaveAcesso(Integer chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }

    public LocalDate getDataAutorizacao() {
        return dataAutorizacao;
    }

    public void setDataAutorizacao(LocalDate dataAutorizacao) {
        this.dataAutorizacao = dataAutorizacao;
    }

    public LocalDate getEmissao() {
        return emissao;
    }

    public void setEmissao(LocalDate emissao) {
        this.emissao = emissao;
    }

    public LocalDate getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDate entrada) {
        this.entrada = entrada;
    }

    public LocalDate getSaida() {
        return saida;
    }

    public void setSaida(LocalDate saida) {
        this.saida = saida;
    }

    public String getDadosAdicionais() {
        return dadosAdicionais;
    }

    public void setDadosAdicionais(String dadosAdicionais) {
        this.dadosAdicionais = dadosAdicionais;
    }

}



