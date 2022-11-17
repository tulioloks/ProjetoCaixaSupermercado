package Entidades;

import java.math.BigDecimal;

public class Transportador {

    private PessoaJuridica pessoajuridica;
    private String tipoFrete;
    private String placaVeiculo;
    private BigDecimal pesoBruto;

    public Transportador(PessoaJuridica pessoajuridica, String tipoFrete, String placaVeiculo, BigDecimal pesoBruto) {
        this.pessoajuridica = pessoajuridica;
        this.tipoFrete = tipoFrete;
        this.placaVeiculo = placaVeiculo;
        this.pesoBruto = pesoBruto;
    }

    public PessoaJuridica getPessoajuridica() {
        return pessoajuridica;
    }

    public void setPessoajuridica(PessoaJuridica pessoajuridica) {
        this.pessoajuridica = pessoajuridica;
    }

    public String getTipoFrete() {
        return tipoFrete;
    }

    public void setTipoFrete(String tipoFrete) {
        this.tipoFrete = tipoFrete;
    }


    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }


    public BigDecimal getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(BigDecimal pesoBruto) {
        this.pesoBruto = pesoBruto;
    }
}
