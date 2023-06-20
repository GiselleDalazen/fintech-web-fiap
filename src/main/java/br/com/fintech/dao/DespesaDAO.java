package br.com.fintech.dao;

import br.com.fintech.model.Despesa;
import br.com.fintech.connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DespesaDAO {

    private Connection connection;

    public DespesaDAO() {
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.conectar();
    }

    public int insert(Despesa despesa)  {
        String sql = "insert into T_FIN_DESPESAS (cd_despesa, vl_despesa, nm_despesa, t_fin_usuario_ds_email)" +
                "values (SQ_DESPESAS.nextval, ?, ?, ?)" ;
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);

            stmt.setFloat(1, despesa.getValor());
            stmt.setString(2, despesa.getNome());
            stmt.setString(3, despesa.getEmail());

            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
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

    public List<Despesa> getAllById(String email) {
        List<Despesa> despesas = new ArrayList<Despesa>();
        String sql = "select * from T_FIN_DESPESAS where T_FIN_USUARIO_DS_EMAIL = '"+ email + "'";
        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Despesa despesa = new Despesa();
                despesa.setCodigo(rs.getInt("cd_despesa"));
                despesa.setValor(rs.getFloat("vl_despesa"));
                despesa.setNome(rs.getString("nm_despesa"));
                despesa.setEmail(rs.getString("t_fin_usuario_ds_email"));
                
                despesas.add(despesa);
            }
            rs.close();
            stmt.close();
            return despesas;

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public List<Despesa> getAllById() {
        List<Despesa> despesas = new ArrayList<Despesa>();
        String sql = "select * from T_FIN_DESPESAS where T_FIN_USUARIO_DS_EMAIL=?";
        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Despesa despesa = new Despesa();
                despesa.setCodigo(rs.getInt("cd_despesa"));
                despesa.setValor(rs.getFloat("vl_despesa"));
                despesa.setNome(rs.getString("nm_despesa"));
                despesa.setEmail(rs.getString("t_fin_usuario_ds_email"));

                despesas.add(despesa);
            }
            rs.close();
            stmt.close();
            return despesas;

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public Despesa selectById(int codigo) {
        Despesa despesa = null;
        String sql = "select * from T_FIN_DESPESAS where cd_despesa=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigo);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                despesa = new Despesa();
                despesa.setCodigo(rs.getInt("cd_despesa"));
                despesa.setValor(rs.getInt("vl_despesa"));
                despesa.setNome(rs.getString("nm_despesa"));
            }

            rs.close();
            stmt.close();
            return despesa;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public void delete(int codigo)  {
        String sql = "delete from T_FIN_DESPESAS where cd_despesa=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.execute();
            stmt.close();
            System.out.println("Deletado com sucesso!");
        }catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }

    }
    public void update(Despesa despesa) {
        String sql = "update T_FIN_DESPESAS set vl_despesa=?, nm_despesa=? where cd_despesa=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setFloat(1, despesa.getValor());
            stmt.setString(2, despesa.getNome());
            stmt.setInt(3, despesa.getCodigo());

            stmt.execute();
            stmt.close();
            System.out.println("Atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }


    }
 }

