package Entidades;
import Enums.TipoPagamento;
import Enums.TipoPessoa;
import Forms.RelatorioItensForms;
import Repository.*;

import javax.swing.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import Exceptions.*;

public class Main {
    public static void main(String[] args) throws SaidaException{
        List<Pessoa> pessoas = new ArrayList<>();

        PessoaFisicaDAO.carregarDados();
        PessoaJuridicaDAO.carregarDados();

        pessoas.addAll(PessoaFisicaDAO.buscarTodos());
        pessoas.addAll(PessoaJuridicaDAO.buscarTodos());

        ClienteDAO.carregarDados(pessoas);
        FuncionarioDAO.carregarDados();

        UsuarioDAO.findUsuariosSistema(FuncionarioDAO.buscarTodos());

        Object usuarioLogado = chamaSelecaoUsuario();
        checaSenhaUsuario(usuarioLogado);
    }

    private static void telaInicial() throws SaidaException{

        String[] opcoesMenuCadastro = {"Cadastrar Cliente", "Cadastrar Produto", "Venda","Relatorios"};
        int menuCadastro = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Cadastros",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuCadastro, opcoesMenuCadastro[0]);

        switch(menuCadastro){
            case 0:
                // botão esq: 0, dir: 1, x: -1
                String[] tipos = {"PESSOA FISICA", "PESSOA JURIDICA"};

                Integer idTipo = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                        "Tipo Pessoa",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tipos, tipos[0]);

                if (idTipo == -1) {
                    throw new SaidaException();
                }

                TipoPessoa tipoPessoa = TipoPessoa.getTipobyId(idTipo);
                Pessoa pessoa = cadastroCliente(tipoPessoa);
                if (tipoPessoa == TipoPessoa.FISICA) {
                    PessoaFisicaDAO.salvar((PessoaFisica) pessoa);

                }
                else {
                    PessoaJuridicaDAO.salvar((PessoaJuridica) pessoa);

                }
                telaInicial();
                break;

            case 1:
                ItemVenda produto = cadastroProduto();
                ProdutoDAO.salvar(produto);
                telaInicial();
                break;

            case 2:
                Venda venda = realizarVenda();
                VendaDAO.salvar(venda);
                telaInicial();
                break;

            case 3:
                String[] relatorios = {"Relatorio Produtos", "Relatorio Pessoas"};

                Integer relatorioOpcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                        "Relatorios",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, relatorios, relatorios[0]);

                if(relatorioOpcao == 0){
                    chamarRelatorioItens();
                }
                break;
        }
    }


    private static void menuDeRelatorios(){
        chamarRelatorioItens();
    }
    private static Object chamaSelecaoUsuario() {
        Object[] selectionValues = UsuarioDAO.findUsuariosSistemaInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o usuario?",
                "SeguradoraAPP", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        return selection;
    }

    private static void checaSenhaUsuario(Object usuarioLogado) throws SaidaException{
        String senhaDigitada = JOptionPane.showInputDialog(null, "Informe a senha do usuario (" + usuarioLogado + ")");
        Usuario usuarioByLogin = UsuarioDAO.findUsuarioByLogin((String) usuarioLogado);

        if (usuarioByLogin.getSenha().equals(senhaDigitada)) {
            telaInicial();
        } else {
            JOptionPane.showMessageDialog(null, "Senha incorreta!");
            checaSenhaUsuario(usuarioLogado);
        }
    }

    private static Pessoa cadastroCliente(TipoPessoa tipoPessoa){
        // Cadastro de Pessoa

        if (tipoPessoa == TipoPessoa.FISICA) {
            PessoaFisica pessoaFisica = new PessoaFisica();

            pessoaFisica.setNome(JOptionPane.showInputDialog(null, "Digite o nome: "));
            pessoaFisica.setTelefone(JOptionPane.showInputDialog(null, "Digite o telefone: "));
            pessoaFisica.setCpf(JOptionPane.showInputDialog(null, "Digite o cpf"));

            pessoaFisica.setEmail(JOptionPane.showInputDialog(null, "Digite o e-mail: "));
            pessoaFisica.setDataNascimento(LocalDate.now());
            pessoaFisica.setEndereco(cadastraEndereco());

            pessoaFisica.setTipoPessoa(TipoPessoa.FISICA);
            return pessoaFisica;

        } else {
            PessoaJuridica pessoaJuridica = new PessoaJuridica();

            pessoaJuridica.setNome(JOptionPane.showInputDialog(null, "Digite o nome: "));
            pessoaJuridica.setRazaoSocial(JOptionPane.showInputDialog(null, "Digite a razão social: "));
            pessoaJuridica.setCnpj(JOptionPane.showInputDialog(null, "Digite o cnpj"));
            pessoaJuridica.setInscricaoEstadual(JOptionPane.showInputDialog(null, "Digite a inscrição Estadual:"));
            pessoaJuridica.setTelefone(JOptionPane.showInputDialog(null, "Digite o telefone: "));
            pessoaJuridica.setEmail(JOptionPane.showInputDialog(null, "Digite o e-mail: "));

            pessoaJuridica.setEndereco(cadastraEndereco());

            pessoaJuridica.setTipoPessoa(TipoPessoa.JURIDICA);
            return pessoaJuridica;
        }

    }

    private static Endereco cadastraEndereco() {
        Endereco endereco = new Endereco();

        endereco.setBairro(JOptionPane.showInputDialog(null, "Digite o nome do bairro: "));
        endereco.setCep(JOptionPane.showInputDialog(null, "Digite o número do Cep: "));
        endereco.setCidade(JOptionPane.showInputDialog(null, "Digite o nome da cidade: "));
        endereco.setComplemento(JOptionPane.showInputDialog(null, "Digite o complemento: "));
        endereco.setMunicipio(JOptionPane.showInputDialog(null, "Digite o nome do Munícipio"));
        endereco.setNumero(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da residência: ")));
        endereco.setUf(JOptionPane.showInputDialog(null, "Digite a Uf"));

        return endereco;
    }

    private static ItemVenda cadastroProduto() throws SaidaException{

        String nome = JOptionPane.showInputDialog(null, "Digite o nome do produto:");
        Double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Valor"));
        Integer quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade"));
        Integer numero = Integer.valueOf(JOptionPane.showInputDialog(null, "Número"));

        ItemVenda cadastroItem = new ItemVenda();

        cadastroItem.setNumero(numero);
        cadastroItem.setNomeProduto(nome);
        cadastroItem.setValorUnitario(valor);
        cadastroItem.setQuantidade(quantidade);

        return cadastroItem;
    }

    private static Venda realizarVenda(){

        System.out.println("Venda Iniciada!!");
        Venda venda = new Venda();
        venda.validaItem();

        String[] opcoesMenuFormasPagamento = {"Dinheiro", "Credito", "Debito"};
        int menuPagamento = JOptionPane.showOptionDialog(null, "Forma de Pagamento:",
                "Menu Forma de Pagamento",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuFormasPagamento, opcoesMenuFormasPagamento[0]);

        if (menuPagamento == 0){

            Double valorDinheiro = Double.valueOf(JOptionPane.showInputDialog(null, "Digite o valor em dinheiro", "Balcão", JOptionPane.QUESTION_MESSAGE));
            Double troco = venda.Total() - valorDinheiro;

            if (troco > 0){
                int menuPagamentoTroco = JOptionPane.showOptionDialog(null, "Forma de Pagamento:",
                        "Menu Forma de Pagamento",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuFormasPagamento, opcoesMenuFormasPagamento[1]);
                troco -= troco;
            }else if (troco < 0){
                System.out.println("Troco para devolver: " + troco);
            }

            venda.setTipoPagamento(TipoPagamento.DINHEIRO);
        }

        else if(menuPagamento == 1){
            venda.setTipoPagamento(TipoPagamento.CREDITO);
        }

        else{
            venda.setTipoPagamento(TipoPagamento.DEBITO);
        }

        System.out.println(venda.cupomFiscal());

        return venda;
    }

    public static ProdutoDAO getPessoaDAO() {
        ProdutoDAO itensVenda = new ProdutoDAO();
        return itensVenda;
    }

    private static void chamarRelatorioItens(){
        List<ItemVenda> itens = getPessoaDAO().buscarTodos();
        RelatorioItensForms.emitirRelatorio(itens);
    }
}