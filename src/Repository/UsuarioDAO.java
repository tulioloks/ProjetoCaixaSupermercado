package Repository;

import Entidades.Funcionario;
import Entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {


    static List<Usuario> usuarios = new ArrayList<>();

    public static List<Usuario> findUsuariosSistema(List<Funcionario> funcionarios) {

        Usuario usuario = new Usuario();
        usuario.setLogin(funcionarios.get(0).getPessoaFisica().getNome());
        usuario.setSenha("admin");
        usuario.setFuncionario(funcionarios.get(0));

        Usuario usuario1 = new Usuario();
        usuario1.setSenha("normal");
        usuario1.setLogin(funcionarios.get(1).getPessoaFisica().getNome());
        usuario.setFuncionario(funcionarios.get(1));

        usuarios.add(usuario);
        usuarios.add(usuario1);

        return usuarios;
    }



    public static Object[] findUsuariosSistemaInArray() {
        List<String> usuariosLogins = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            usuariosLogins.add(usuario.getLogin());
        }

        return usuariosLogins.toArray();
    }

    public static Usuario findUsuarioByLogin(String login) {

        for (Usuario usuario : usuarios) {
            if (login.equals(login)) {
                return usuario;
            }
        }
        return null;
    }
}
