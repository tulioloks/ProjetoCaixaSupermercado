package Entidades;


import Enums.Pago;
import Enums.StatusVenda;
import Enums.TipoPagamento;
import Repository.ProdutoDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Venda {

    private List<ItemVenda> item = new ArrayList<>();

    private ItemVenda itemVenda;
    private Cliente cliente;
    private Pago pago;
    private StatusVenda status;
    private TipoPagamento tipoPagamento;
    private Date now = new Date();
    private Integer Numero;
    private Integer Parcelas;
    private List<String> datas = new ArrayList<>();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Venda(){

    }

    public Venda(Integer numero){
        Numero = numero;
    }


    public Double Total(){
        Double soma = 0.0;
        for (ItemVenda list: item){
            soma = soma + list.subTotal();
        }
        return soma;
    }


    public void validacao(){

    }

    public void validacaoTempo(){
        Calendar  cal = Calendar.getInstance();
        cal.setTime(now);
        for(int i=1; i<Parcelas; i++){
            cal.add(Calendar.MONTH, i);
            Date data = cal.getTime();
            String dataFormatada = sdf.format(data);
            datas.add(dataFormatada);
        }
    }

    //public void adicionarItem(ItemVenda itens){
    //    item.add(itens);
    //}

    public void validaItem(Integer codigo){
            List<ItemVenda> itens = ProdutoDAO.buscarPorCodigo(codigo);
            for(ItemVenda itemVenda : itens)    {
            item.add(itemVenda);
        }
    }

    public void removerItem(ItemVenda itens){
        item.remove(itens);
    }

    public Double descontos(){
        if(cliente!= null && Total()> 130){
            return Total() - 20;
        }else{
            return Total();
        }
    }

    public String cupomFiscal(){
        StringBuilder bd = new StringBuilder();
        setStatus(StatusVenda.INICIANDO);
        setStatus(StatusVenda.PROCESSANDO);
        bd.append("====================================================\n");
        bd.append("                   CUPOM FISCAL \n");
        bd.append("====================================================\n");
        if(cliente!=null){
            bd.append("Cliente: " + cliente + "\n");
        }else {
            bd.append("Cliente: não cadastrado \n");
        }
        bd.append("Número do pedido:                         "+ Numero+ "\n");
        bd.append("Data da Compra:                           " + sdf.format(now) + "\n");
        setStatus(StatusVenda.IMPRIMINDO);
        bd.append("Status:                                   " + getStatus() + "\n");
        bd.append("Forma de Pagamento:                       " + getTipoPagamento() + "\n");
        bd.append("\n");
        bd.append("====================================================\n");
        bd.append("                  ITENS DA VENDA " + "\n");
        bd.append("\n");
        int contador = 1;

        for (ItemVenda list : item){
            list.setNumero(contador);
            bd.append(list + "\n");
            contador++;
        }
        bd.append("Situação: " + getPago() + "\n");
        setStatus((StatusVenda.FINALIZANDO));
        bd.append("Total da Venda:                            R$" + Total());
        return bd.toString();
    }

    public List<ItemVenda> getItem() {
        return item;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public StatusVenda getStatus() {
        return status;
    }

    public void setStatus(StatusVenda status) {
        this.status = status;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Date getNow() {
        return now;
    }

    public Integer getNumber() {
        return Numero;
    }

    public void setNumber(Integer number) {
        this.Numero = number;
    }

    public Integer getParcelas() {
        return Parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.Parcelas = parcelas;
    }
}