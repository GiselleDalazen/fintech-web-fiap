package br.com.fintech.dao;

import br.com.fintech.model.Usuario;
import br.com.fintech.connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO() {
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.conectar();
    }

    public int insert(Usuario usuario) throws SQLException {
        String sql = "insert into T_FIN_USUARIO (nm_usuario, ds_email, ds_senha) values (?, ?, ?)" ;

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());

            return stmt.executeUpdate();
         } catch (SQLException e) {
            System.out.println("ERRO: "+ e.getMessage());
            return 0;
        } finally {
            if (stmt != null){
                stmt.close();
            }

        }

    }

    public List<Usuario> getAll() {

        List<Usuario> usuarios = new ArrayList<Usuario>();
        String sql = "select * from T_FIN_USUARIO order by NM_USUARIO ASC";
        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setSenha(rs.getString("ds_senha"));
                usuario.setNome(rs.getString("nm_usuario"));
                usuario.setEmail(rs.getString("ds_email"));

                usuarios.add(usuario);
            }
            rs.close();
            stmt.close();
            return usuarios;

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public Usuario selectById(String id) {
        Usuario usuario = null;
        String sql = "select * from T_FIN_USUARIO where ds_email=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setSenha(rs.getString("ds_senha"));
                usuario.setNome(rs.getString("nm_usuario"));
                usuario.setEmail(rs.getString("ds_email"));
            }

            rs.close();
            stmt.close();
            return usuario;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public void delete(String id) throws SQLException {
        String sql = "delete from T_FIN_USUARIO where ds_email=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, id);
        stmt.execute();
        stmt.close();
    }
    public void update(Usuario usuario) throws SQLException {
        String sql = "update T_FIN_USUARIO set ds_senha=?, nm_usuario=?, ds_email=?, nr_telefone=?, nm_pais=? where ds_email=?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, usuario.getSenha());
        stmt.setString(2, usuario.getNome());
        stmt.setString(3, usuario.getEmail());

        stmt.execute();
        stmt.close();

    }
 }

