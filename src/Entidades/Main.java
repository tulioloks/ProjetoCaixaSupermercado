package Entidades;
import Enums.TipoPessoa;
import Repository.PessoaDAO;
import Repository.ProdutoDAO;
import Repository.UsuarioDAO;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Object usuarioLogado = chamaSelecaoUsuario();
        checaSenhaUsuario(usuarioLogado);
    }

    private static void telaInicial(){

        String[] opcoesMenuCadastro = {"Cadastrar Pessoa", "Cadastrar Produto", "Venda"};
        int menuCadastro = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Cadastros",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuCadastro, opcoesMenuCadastro[0]);

        switch(menuCadastro){
            case 0:
                Pessoa pessoa = cadastroPessoa();
                PessoaDAO.salvar(pessoa);
                telaInicial();
                break;

            case 1:
                ItemVenda produto = cadastroProduto();
                ProdutoDAO.salvar(produto);
                telaInicial();
                break;

            case 2:
                realizarVenda();
                telaInicial();
                break;
        }
    }

    private static Object chamaSelecaoUsuario() {
        Object[] selectionValues = UsuarioDAO.findUsuariosSistemaInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o usuario?",
                "SeguradoraAPP", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        return selection;
    }

    private static void checaSenhaUsuario(Object usuarioLogado) {
        String senhaDigitada = JOptionPane.showInputDialog(null, "Informe a senha do usuario (" + usuarioLogado + ")");
        Usuario usuarioByLogin = UsuarioDAO.findUsuarioByLogin((String) usuarioLogado);

        if (usuarioByLogin.getSenha().equals(senhaDigitada)) {
            telaInicial();
        } else {
            JOptionPane.showMessageDialog(null, "Senha incorreta!");
            checaSenhaUsuario(usuarioLogado);
        }
    }

    private static Pessoa cadastroPessoa(){
        // identificação do cliente
        String[] opcaoPessoas = {"Fisica", "Juridica"};
        String nome = JOptionPane.showInputDialog(null, "Digite o nome da pessoa: ");
        int tipoPessoa = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Tipo Pessoa",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcaoPessoas, opcaoPessoas[0]);
        String tipoDocumento = "CPF";
        if (tipoPessoa == 1) {
            tipoDocumento = "CNPJ";
        }
        String documento = JOptionPane.showInputDialog(null, "Digite o " + tipoDocumento + " da pessoa: ");

        if (tipoDocumento.equals("CPF")) {
            PessoaFisica pessoaFisica = new PessoaFisica();
            pessoaFisica.setTipo(TipoPessoa.FISICA);
            pessoaFisica.setNome(nome);
            pessoaFisica.setCpf(documento);
            return pessoaFisica;
        } else {
            PessoaJuridica pessoaJuridica = new PessoaJuridica();
            pessoaJuridica.setTipo(TipoPessoa.JURIDICA);
            pessoaJuridica.setNome(nome);
            pessoaJuridica.setCnpj(documento);
            return pessoaJuridica;
        }
    }

    private static ItemVenda cadastroProduto(){
        boolean cadastro = true;
        ItemVenda cadastroItem = new ItemVenda();
        while (cadastro == true) {

            String nome = JOptionPane.showInputDialog(null, "Digite o nome do produto:");
            Double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Valor"));
            Integer quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade"));
            cadastroItem.cadastrarProduto(nome, valor, quantidade);

            Integer cadastroPergunta = Integer.parseInt(JOptionPane.showInputDialog(null,"Deseja continuar cadastrando? \n 1 - Sim\n 2 - Não "));
            if (cadastroPergunta == 2){
                cadastro = false;
            }
        }
        cadastroItem.mostrarItens();
        telaInicial();
        return cadastroItem;
    }

    private static void realizarVenda(){
        Venda venda = new Venda();

        Integer adicionarProduto = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código do produto:", "Balcão", JOptionPane.QUESTION_MESSAGE));
        venda.adicionaItem(adicionarProduto);

        System.out.println(venda.cupomFiscal());
    }
}