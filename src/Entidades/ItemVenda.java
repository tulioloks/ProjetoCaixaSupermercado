package Entidades;

import java.util.ArrayList;
import java.util.List;

public class ItemVenda {
    private Integer Numero;
    private String NomeProduto;
    private Double ValorUnitario;
    private Integer Quantidade;
    private Double SubTotal;
    private List<ItemVenda> item = new ArrayList<>();

    public ItemVenda(){

    }

    public ItemVenda(ItemVenda itemAdicionar) {
        item.add(itemAdicionar);
    }

    public ItemVenda(List<ItemVenda> buscarPorCodigo) {

    }


    public Double subTotal(){
        return Quantidade * ValorUnitario;
    }

    @Override
    public String toString(){
        return Numero + " - " + NomeProduto +"       "+ Quantidade + " UN X " + ValorUnitario + "      Vl.Total. R$ " + subTotal();
    }

    public ItemVenda(Integer numero,String nomeProduto, Double valorUnitario, Integer quantidade) {
        Numero = numero;
        NomeProduto = nomeProduto;
        ValorUnitario = valorUnitario;
        Quantidade = quantidade;
    }


    public void mostrarItens(){
        for(ItemVenda cadas : item){
            System.out.println(cadas);
        }
    }

    public Double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(Double subTotal) {
        SubTotal = subTotal;
    }

    public Integer getNumero() {
        return Numero;
    }

    public void setNumero(Integer numero) {
        Numero = numero;
    }

    public String getNomeProduto() {
        return NomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        NomeProduto = nomeProduto;
    }

    public Double getValorUnitario() {
        return ValorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        ValorUnitario = valorUnitario;
    }

    public Integer getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        Quantidade = quantidade;
    }
}
