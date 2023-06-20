package br.com.fintech.dao;

import br.com.fintech.connection.ConnectionFactory;
import br.com.fintech.model.Banco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BancoDAO {

    private Connection connection;

    public BancoDAO() {
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.conectar();
    }

    public void insert(Banco banco) {
        String sql = "insert into T_FIN_BANCO (nr_banco, nm_banco)" +
                "values (SQ_BANCO.nextval, ?)" ;

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, banco.getNome());

            stmt.execute();
            stmt.close();
            System.out.println("Inserido com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }

    }

    public List<Banco> getAll() {

        List<Banco> bancos = new ArrayList<Banco>();
        String sql = "select * from T_FIN_BANCO order by nm_banco ASC";
        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Banco banco = new Banco();
                banco.setNumero(rs.getInt("nr_banco"));
                banco.setNome(rs.getString("nm_banco"));

                bancos.add(banco);
            }
            rs.close();
            stmt.close();
            return bancos;

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public Banco selectById(int numero) {
        Banco banco = null;
        String sql = "select * from T_FIN_BANCO where nr_banco=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, numero);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                banco = new Banco();
                banco.setNome(rs.getString("nm_banco"));
                banco.setNumero(rs.getInt("nr_banco"));

            }

            rs.close();
            stmt.close();
            return banco;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public void delete(int numero)  {
        String sql = "delete from T_FIN_BANCO where nr_banco=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, numero);
            stmt.execute();
            stmt.close();
            System.out.println("Deletado com sucesso!");
        }catch (SQLException e){
            System.err.println("Erro: " + e.getMessage());
        }

    }
    public void update(Banco banco) {
        String sql = "update T_FIN_BANCO set nm_banco=? where nr_banco=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, banco.getNome());
            stmt.setInt(2, banco.getNumero());

            stmt.execute();
            stmt.close();
            System.out.println("Atualizado com sucesso!");
        } catch (SQLException e){
            System.err.println("Erro: " + e.getMessage());
        }


    }
 }
