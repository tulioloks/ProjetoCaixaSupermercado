package Entidades;

import Enums.StatusVenda;
import Repository.ClienteDAO;

import java.text.SimpleDateFormat;
import java.util.*;

public class Nfe{

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

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public String notaFiscal(){
        StringBuilder bd = new StringBuilder();

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
}
