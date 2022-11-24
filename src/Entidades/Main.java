package Entidades;
import Enums.TipoPagamento;
import Enums.TipoPessoa;
import Forms.RelatorioClienteForms;
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

    public static void telaInicial() throws SaidaException {

        String[] opcoesMenuCadastro = {"Cadastrar Cliente", "Cadastrar Produto", "Venda","Relatorios", "Sair"};
        int menuCadastro = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Tela Inicial",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuCadastro, opcoesMenuCadastro[0]);

        switch(menuCadastro){
            case 0:
                menuDeCadastroCliente();
                telaInicial();
                break;

            case 1:
                ItemVenda produto = null;
                produto = cadastroProduto();
                ProdutoDAO.salvar(produto);
                telaInicial();
                break;

            case 2:
                realizarVenda();
                telaInicial();
                break;

            case 3:
                menuDeRelatorios();
                break;

            case 4:
                System.exit(0);
                break;
        }
    }

    private static void menuDeCadastroCliente() throws SaidaException {
        // botão esq: 0, dir: 1, x: -1
        String[] tipos = {"Pessoa Juridica", "Pessoa Fisica", "Voltar"};

        Integer idTipo = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Tipo Pessoa",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tipos, tipos[0]);

        if (idTipo == -1) {
            throw new SaidaException();
        }else if (idTipo == 2){
            telaInicial();
        }

        TipoPessoa tipoPessoa = TipoPessoa.getTipobyId(idTipo);
        Pessoa pessoa = cadastroCliente(tipoPessoa);

        if (tipoPessoa == TipoPessoa.FISICA) {
            PessoaFisicaDAO.salvar((PessoaFisica) pessoa);

        }
        else {
            PessoaJuridicaDAO.salvar((PessoaJuridica) pessoa);
        }
    }

    public static void menuDeRelatorios() throws SaidaException {
        String[] relatorios = {"Relatorio Produtos", "Relatorio Pessoas", "Voltar"};

        Integer relatorioOpcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Relatorios",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, relatorios, relatorios[0]);

        if(relatorioOpcao == 0){
            chamarRelatorioItens();

        }else if (relatorioOpcao == 1){
            chamarRelatorioClientes();

        } else {
            telaInicial();
        }
    }

    private static Object chamaSelecaoUsuario() throws SaidaException{
        Object[] selectionValues = UsuarioDAO.findUsuariosSistemaInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o usuario?",
                "CaixaAPP", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

        if (selection == null) {
            throw new SaidaException();
        }
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
        endereco.setRua(JOptionPane.showInputDialog(null, "Rua: "));
        endereco.setCidade(JOptionPane.showInputDialog(null, "Digite o nome da cidade: "));
        endereco.setNumero(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número do endereço: ")));

        return endereco;
    }

    private static ItemVenda cadastroProduto() throws SaidaException{

        try{
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

        }catch (NullPointerException e){


        }return null;
    }

    private static void realizarVenda() throws SaidaException {

        System.out.println("Venda Iniciada!!");
        Venda venda = new Venda();
        venda.validaItem();

        String[] opcoesMenuFormasPagamento = {"Dinheiro", "Credito", "Debito"};
        int menuPagamento = JOptionPane.showOptionDialog(null, "Forma de Pagamento:",
                "Menu Forma de Pagamento",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuFormasPagamento, opcoesMenuFormasPagamento[0]);

        if (menuPagamento == 0){

            Double valorDinheiro = Double.valueOf(JOptionPane.showInputDialog(null, "Digite o valor em dinheiro",
                    "Balcão", JOptionPane.QUESTION_MESSAGE));

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
        VendaDAO.salvar(venda);
    }

    public static ProdutoDAO getProdutoDAO() {
        ProdutoDAO itensVenda = new ProdutoDAO();
        return itensVenda;
    }

    public static ClienteDAO getClienteDAO() {
        ClienteDAO cliente = new ClienteDAO();
        return cliente;
    }

    private static void chamarRelatorioItens(){
        List<ItemVenda> itens = getProdutoDAO().buscarTodos();
        RelatorioItensForms.emitirRelatorio(itens);
    }

    private static void chamarRelatorioClientes(){
        List<Cliente> cliente = getClienteDAO().buscarTodos();
        RelatorioClienteForms.emitirRelatorio(cliente);
    }
}