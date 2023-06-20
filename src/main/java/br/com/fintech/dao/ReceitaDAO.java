package br.com.fintech.dao;

import br.com.fintech.model.Receita;
import br.com.fintech.connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceitaDAO {

    private Connection connection;

    public ReceitaDAO() {
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.conectar();
    }

    public int insert(Receita receita) {
        String sql = "insert into T_FIN_RECEITAS (cd_recebimento, ds_recebimento, st_recorrencia, vl_recebimento, T_FIN_USUARIO_DS_EMAIL)" +
                "values (SQ_RECEITAS.NEXTVAL, ?, ?, ?, ?)";

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, receita.getDescricao());
            stmt.setString(2, receita.getRecorrencia());
            stmt.setFloat(3, receita.getValor());
            stmt.setString(4, receita.getEmail());

            int row = stmt.executeUpdate();
            System.out.print("Receita cadastrada com sucesso");
            return row;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return 0;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public List<Receita> getAllById(String email) {
        List<Receita> receitas = new ArrayList<Receita>();
        String sql = "select * from T_FIN_RECEITAS where T_FIN_USUARIO_DS_EMAIL='"+ email + "'";
        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Receita receita = new Receita();
                receita.setCodigo(rs.getInt("cd_recebimento"));
                receita.setDescricao(rs.getString("ds_recebimento"));
                receita.setRecorrencia(rs.getString("st_recorrencia"));
                receita.setValor(rs.getFloat("vl_recebimento"));
                receita.setEmail(rs.getString("t_fin_usuario_ds_email"));

                receitas.add(receita);
            }
            rs.close();
            stmt.close();
            return receitas;

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public Receita selectById(int codigo) {
        Receita receita = null;
        String sql = "select * from T_FIN_RECEITAS where cd_recebimento=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigo);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                receita = new Receita();
                receita.setCodigo(rs.getInt("cd_recebimento"));
                receita.setDescricao(rs.getString("ds_recebimento"));
                receita.setRecorrencia(rs.getString("st_recorrencia"));
                receita.setValor(rs.getFloat("vl_recebimento"));
                receita.setEmail(rs.getString("t_fin_usuario_ds_email"));
            }

            rs.close();
            stmt.close();
            return receita;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public void delete(int codigo) throws SQLException {
        String sql = "delete from T_FIN_RECEITAS where cd_recebimento=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, codigo);
        stmt.execute();
        stmt.close();
    }
    public void update(Receita receita) throws SQLException {
        String sql = "update T_FIN_RECEITAS set ds_recebimento=?, st_recorrencia=?, vl_recebimento=? where cd_recebimento=?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, receita.getDescricao());
        stmt.setString(2, receita.getRecorrencia());
        stmt.setFloat(3, receita.getValor());
        stmt.setInt(4, receita.getCodigo());

        stmt.execute();
        stmt.close();

    }
 }

