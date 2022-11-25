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

    public String notaFiscal(){
        StringBuilder bd = new StringBuilder();

        bd.append("Número da nota fiscal: " + numeroNf /*utilizar a da venda*/ );
        bd.append("Natureza da operacao: Venda de mercadoria" );
        bd.append("Chave de acesso: " + chaveDeAcesso);
        bd.append("Nome/Razão Social: " /*utilizar a da venda*/ );
        bd.append("Data Emissao" /*utilizar a da venda*/ );
        bd.append("Endereco");
        bd.append("CPF/CNPJ");
        bd.append("Valor" /*utilizar a da venda*/ );
        bd.append("Transportadora");
        bd.append("Complemento");

        return bd.toString();
    }
}
