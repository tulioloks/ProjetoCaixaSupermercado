package Entidades;

import Interface.ValidaNFE;
import Enums.StatusVenda;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Nfe implements ValidaNFE {

    private Venda venda;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private List<String> datas = new ArrayList<>();
    private Date now = new Date();

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
        Random gerador = new Random();
        String complemento = JOptionPane.showInputDialog(null, "Digite o complemento da nota");

        bd.append("\n" + "\n" +"\n" );
        bd.append("                                  NOTA FISCAL ELETRONICA                                   \n");
        bd.append("-------------------------------------------------------------------------------------------" +  "\n");
        bd.append("Número da nota fiscal: " + venda.getNumber()+ "\n");
        bd.append("Natureza da operacao:                                               Venda de mercadoria" + "\n");


        bd.append("Chave de acesso:                  " + gerador.nextInt(9999) + " " + gerador.nextInt(9999)+ " " + gerador.nextInt(9999) + " " + gerador.nextInt(9999)+ " "
                + gerador.nextInt(9999 )+ " " + gerador.nextInt(9999)+ " " + gerador.nextInt(9999)+ " " + gerador.nextInt(9999)+ " "
                + gerador.nextInt(9999)+ " " + gerador.nextInt(9999 )+ " " + gerador.nextInt(9999 )+ "\n");

        bd.append("Nome/Razão Social:                                                  " + venda.getCliente().getPessoa().getNome() + "\n");
        bd.append("Data Emissao" +  "\n");

        bd.append("-------------------------------------------------------------------------------------------" +  "\n");

        for(ItemVenda vendaItens : venda.getItemDasVendas()){
            bd.append(vendaItens + "\n");
        }
        bd.append("-------------------------------------------------------------------------------------------" +  "\n");

        bd.append("Total da nota                                                                        " + venda.Total() + "\n");

        bd.append("-------------------------------------------------------------------------------------------" +  "\n");
        bd.append("ENDEREÇO                                \n");
        bd.append(venda.getCliente().getPessoa().getEndereco() + "\n");
        bd.append("CPF/CNPJ" + venda.getCliente().getPessoa().getDocumentoPrincipal() + "\n");
        bd.append("-------------------------------------------------------------------------------------------" +  "\n");
        bd.append("TRANSPORTADORA                                \n");
        bd.append("Transportes Valdivia        Frete por conta: Emitente      Placa: HTS564         UF: SC     \nCPF/CNPJ 00000000000" + "\n");
        bd.append("Complemento: " + complemento + "\n");
        bd.append("-------------------------------------------------------------------------------------------" +  "\n");

        return bd.toString();
    }

    public String notaFiscalDevolucao(){
        StringBuilder bd = new StringBuilder();
        Random gerador = new Random();
        String complemento = JOptionPane.showInputDialog(null, "Digite o complemento da nota");

        bd.append("\n" + "\n" +"\n" );
        bd.append("                                  NOTA FISCAL DEVOLUÇÃO                                  \n");
        bd.append("-------------------------------------------------------------------------------------------" +  "\n");
        bd.append("Número da nota fiscal: " + venda.getNumber()+ "\n");
        bd.append("Natureza da operacao:                                               Devolução de mercadoria" + "\n");


        bd.append("Chave de acesso:                  " + gerador.nextInt(9999) + " " + gerador.nextInt(9999)+ " " + gerador.nextInt(9999) + " " + gerador.nextInt(9999)+ " "
                + gerador.nextInt(9999 )+ " " + gerador.nextInt(9999)+ " " + gerador.nextInt(9999)+ " " + gerador.nextInt(9999)+ " "
                + gerador.nextInt(9999)+ " " + gerador.nextInt(9999 )+ " " + gerador.nextInt(9999 )+ "\n");

        bd.append("Nome/Razão Social:                                                  " + venda.getCliente().getPessoa().getNome() + "\n");
        bd.append("Data Emissao" +  "\n");

        bd.append("-------------------------------------------------------------------------------------------" +  "\n");

        for(ItemVenda vendaItens : venda.getItemDasVendas()){
            bd.append(vendaItens + "\n");
        }
        bd.append("-------------------------------------------------------------------------------------------" +  "\n");

        bd.append("Total da nota                                                                        " + venda.Total() + "\n");

        bd.append("-------------------------------------------------------------------------------------------" +  "\n");
        bd.append("ENDEREÇO                                \n");
        bd.append(venda.getCliente().getPessoa().getEndereco() + "\n");
        bd.append("CPF/CNPJ" + venda.getCliente().getPessoa().getDocumentoPrincipal() + "\n");
        bd.append("-------------------------------------------------------------------------------------------" +  "\n");
        bd.append("TRANSPORTADORA                                \n");
        bd.append("Transportes Valdivia        Frete por conta: Emitente      Placa: HTS564         UF: SC     \nCPF/CNPJ 00000000000" + "\n");
        bd.append("Complemento: " + complemento + "\n");
        bd.append("-------------------------------------------------------------------------------------------" +  "\n");

        return bd.toString();
    }
}
