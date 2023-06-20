package br.com.fintech.teste;

import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.model.Usuario;

import java.sql.SQLException;

public class MainUsuario {

    public static void main(String[] args) {

        Usuario usuario = new Usuario();
        usuario.setNome("Jair Brava");
        usuario.setEmail("jair@mail.com");
        usuario.setSenha("1234");

        UsuarioDAO dao = new UsuarioDAO();

        try {
            int row = dao.insert(usuario);
            if(row > 0) {
                System.out.println("INSERIDO COM SUCESSO");
            }
            else {
                System.err.println("ERRO NO INSERT USUARIO");
            }
        } catch (SQLException e) {
            System.out.println("ERRO: "+ e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
