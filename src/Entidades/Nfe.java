package Entidades;

import Exceptions.SaidaException;
import Interface.ValidaNFE;
import Enums.StatusVenda;
import Repository.ClienteDAO;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Nfe implements ValidaNFE {

    private Venda venda;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private List<String> datas = new ArrayList<>();
    private Date now = new Date();

    @Override
    public Venda validarCliente(Venda venda) throws SaidaException {

        if(venda.getCliente().getPessoa().getNome().equals("Cliente diversos")){
            JOptionPane.showMessageDialog(null, "Cliente diversos! Insira o cliente na venda\"!!", "Erro Nota Fiscal", JOptionPane.INFORMATION_MESSAGE);
            Object[] selectionValues = Main.getClienteDAO().findClientesInArray();
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o cliente para inserir na nota",
                    "Clientes", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
            List<Cliente> clientes = Main.getClienteDAO().buscarPorNome((String) selection);

            venda.setCliente(clientes.get(0));
            venda.setStatus(StatusVenda.NOTA_IMPRESSA);
        }
        return venda;
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
