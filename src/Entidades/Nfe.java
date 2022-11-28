package Entidades;

import Interface.ValidaNFE;
import Enums.StatusVenda;

import java.text.SimpleDateFormat;
import java.util.*;

public class Nfe implements ValidaNFE {

    private Venda venda;
    private Cliente cliente;
    private Endereco endereco;
    private Integer numeroNf;
    private Integer chaveDeAcesso;
    private Integer Parcelas;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private List<String> datas = new ArrayList<>();
    private Date now = new Date();


    public void validacaoTempo(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        for(int i=1; i<Parcelas; i++){
            cal.add(Calendar.MONTH, i);
            Date data = cal.getTime();
            String dataFormatada = sdf.format(data);
            datas.add(dataFormatada);
        }
    }

    @Override
    public Venda validarCliente(Venda venda) {
        if (venda.getStatus().equals(StatusVenda.FINALIZANDO) && !venda.getCliente().getPessoa().getNome().equals("Cliente diversos")) {
            return venda;
        }else {
            System.out.println("\n \n \n \nVenda com status inválido, confira na lista de vendas!!!");
            return null;
        }
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public String notaFiscal(){
        StringBuilder bd = new StringBuilder();

        bd.append("\n" + "\n" +"\n" );
        bd.append("Número da nota fiscal: " + venda.getNumber()+ "\n");
        bd.append("Natureza da operacao: Venda de mercadoria" + "\n");
        bd.append("Chave de acesso: " + chaveDeAcesso+ "\n");
        bd.append("Nome/Razão Social: " + venda.getCliente().getPessoa().getNome() + "\n");
        bd.append("Data Emissao" +  "\n");
        bd.append("Endereco" + venda.getCliente().getPessoa().getEndereco() + "\n");
        bd.append("CPF/CNPJ" + venda.getCliente().getPessoa().getDocumentoPrincipal() + "\n");
        bd.append("Valor: " + venda.Total());
        bd.append("Transportadora" + "\n");
        bd.append("Complemento");

        return bd.toString();
    }

    public String notaFiscalDevolucao(){
        StringBuilder bd = new StringBuilder();

        bd.append("\n" + "\n" +"\n" );
        bd.append("Número da nota fiscal: " + venda.getNumber()+ "\n");
        bd.append("Natureza da operacao: Devolução de mercadoria" + "\n");
        bd.append("Chave de acesso: " + chaveDeAcesso+ "\n");
        bd.append("Nome/Razão Social: " + venda.getCliente().getPessoa().getNome() + "\n");
        bd.append("Data Emissao" +  "\n");
        bd.append("Endereco" + venda.getCliente().getPessoa().getEndereco() + "\n");
        bd.append("CPF/CNPJ" + venda.getCliente().getPessoa().getDocumentoPrincipal() + "\n");
        bd.append("Valor: " + venda.Total());
        bd.append("Transportadora" + "\n");
        bd.append("Complemento");

        return bd.toString();
    }
}
