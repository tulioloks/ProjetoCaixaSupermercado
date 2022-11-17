package Entidades;

public class Usuario {

    private String login;
    private String senha;

    private Funcionario funcionario;

    public Usuario() {

    }

    public Usuario(String login, String senha, Funcionario funcionario) {
        this.login = login;
        this.senha = senha;
        this.funcionario = funcionario;

    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;

    }

    public String getUsuario() {
        return login;
    }

    public void setUsuario(String logn) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
