package br.com.fintech.dao;

import br.com.fintech.model.Conta;
import br.com.fintech.connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {

    private Connection connection;

    public ContaDAO() {
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.conectar();
    }
    public int insert(Conta conta) {
        String sql = "insert into T_FIN_CONTA (id_conta, nr_agencia, nr_conta, T_FIN_BANCO_NR_BANCO, T_FIN_USUARIO_DS_EMAIL)" +
                "values (SQ_CONTA.NEXTVAL, ?, ?, ?, ?)" ;

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);

            stmt.setInt(1, conta.getAgencia());
            stmt.setInt(2, conta.getNrConta());
            stmt.setInt(3, conta.getNrBanco());
            stmt.setString(4, conta.getEmail());

            int row = stmt.executeUpdate();
            System.out.println("Conta inserida com sucesso!");
            return row;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return 0;
        } finally {
            try {
                if(stmt != null){
                    stmt.close();
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public List<Conta> getAll() {

        List<Conta> contas = new ArrayList<Conta>();
        String sql = "select * from T_FIN_CONTA order by ID_CONTA ASC";
        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Conta conta = new Conta();
                conta.setIdConta(rs.getInt("id_conta"));
                conta.setAgencia(rs.getInt("nr_agencia"));
                conta.setNrConta(rs.getInt("nr_conta"));
                conta.setNrBanco(rs.getInt("t_fin_banco_nr_banco"));
                conta.setEmail(rs.getString("t_fin_usuario_ds_email"));

                contas.add(conta);
            }
            rs.close();
            stmt.close();
            return contas;

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public Conta selectById(int id) {
        Conta conta = null;
        String sql = "select * from T_FIN_CONTA where id_conta=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                conta = new Conta();
                conta.setIdConta(rs.getInt("id_conta"));
                conta.setAgencia(rs.getInt("nr_agencia"));
                conta.setNrConta(rs.getInt("nr_conta"));
                conta.setNrBanco(rs.getInt("t_fin_banco_nr_banco"));
                conta.setEmail(rs.getString("t_fin_usuario_ds_email"));
            }

            rs.close();
            stmt.close();
            return conta;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public void delete(int id) {
        String sql = "delete from T_FIN_CONTA where id_conta=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            System.out.println("Deletado com sucesso!");
        }catch (SQLException e){
            System.err.println("Erro " + e.getMessage());
        }

    }
    public void update(Conta conta) {
        String sql = "update T_FIN_CONTA set nr_agencia=?, nr_conta=?, T_FIN_BANCO_NR_BANCO=?, T_FIN_USUARIO_DS_EMAIL=? where id_conta=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, conta.getAgencia());
            stmt.setInt(2, conta.getNrConta());
            stmt.setInt(3, conta.getNrBanco());
            stmt.setString(4, conta.getEmail());
            stmt.setInt(5, conta.getIdConta());

            stmt.execute();
            stmt.close();
            System.out.println("Atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro " + e.getMessage());
        }


    }
}


