package Entidades;

import java.util.ArrayList;
import java.util.List;

public class ItemVenda {
    private Integer numero;
    private String nomeProduto;
    private Double valorUnitario;
    private Integer quantidade;
    private Double subTotal;
    private List<ItemVenda> item = new ArrayList<>();

    public ItemVenda(){

    }

    public ItemVenda(ItemVenda itemAdicionar) {
        item.add(itemAdicionar);
    }

    public ItemVenda(List<ItemVenda> buscarPorCodigo) {

    }

    public Double subTotal(){
        return quantidade * valorUnitario;
    }

    @Override
    public String toString(){
        return numero + " - " + nomeProduto +"       "+ quantidade + " UN X " + valorUnitario + "      Vl.Total. R$ " + subTotal();
    }

    public ItemVenda(Integer numero,String nomeProduto, Double valorUnitario, Integer quantidade) {
        this.numero = numero;
        this.nomeProduto = nomeProduto;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public void mostrarItens(){
        for(ItemVenda cadas : item){
            System.out.println(cadas);
        }
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
