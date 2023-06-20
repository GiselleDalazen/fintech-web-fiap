package br.com.fintech.dao;

import br.com.fintech.model.Investimento;
import br.com.fintech.connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoDAO {

    private Connection connection;

    public InvestimentoDAO() {
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.conectar();
    }

    public int insert(Investimento investimento) {
        String sql = "insert into T_FIN_INVESTIMENTO (cd_investimento, nm_investimento, vl_investimento, dt_inicial, dt_resgate, T_FIN_USUARIO_DS_EMAIL)" +
                "values (SQ_INVESTIMENTO.NEXTVAL, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, investimento.getNome());
            stmt.setFloat(2, investimento.getVlInvestimento());
            stmt.setString(3, investimento.getDtInicial());
            stmt.setDate(4, investimento.getDtResgate());
            stmt.setString(5, investimento.getEmail());

            int row = stmt.executeUpdate();
            System.out.println("Investimento inserido com sucesso!");
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
    public List<Investimento> getAllById(String email) {

        List<Investimento> investimentos = new ArrayList<Investimento>();
        String sql = "select * from T_FIN_INVESTIMENTO where T_FIN_USUARIO_DS_EMAIL='"+ email + "'";
        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Investimento investimento = new Investimento();
                investimento.setCdInvestimento(rs.getInt("cd_investimento"));
                investimento.setNome(rs.getString("nm_investimento"));
                investimento.setVlInvestimento(rs.getFloat("vl_investimento"));
                investimento.setDtInicial(rs.getString("dt_inicial"));
                investimento.setDtResgate(rs.getDate("dt_resgate"));
                investimento.setEmail(rs.getString("t_fin_usuario_ds_email"));

                investimentos.add(investimento);
            }
            rs.close();
            stmt.close();
            return investimentos;

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public Investimento selectById(int id) {
        Investimento investimento = null;
        String sql = "select * from T_FIN_INVESTIMENTO where cd_investimento=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                investimento = new Investimento();
                investimento.setCdInvestimento(rs.getInt("cd_investimento"));
                investimento.setNome(rs.getString("nm_investimento"));
                investimento.setVlInvestimento(rs.getFloat("vl_investimento"));
                investimento.setDtInicial(rs.getString("dt_inicial"));
                investimento.setDtResgate(rs.getDate("dt_resgate"));
                investimento.setEmail(rs.getString("t_fin_usuario_ds_email"));

            }

            rs.close();
            stmt.close();
            return investimento;
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public void delete(int id) {
        String sql = "delete from T_FIN_INVESTIMENTO where cd_investimento=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            System.out.println("Deletado com sucesso!");
        }catch (SQLException e){
            System.err.println("Erro: " + e.getMessage());
        }

    }
    public void update(Investimento investimento) {
        String sql = "update T_FIN_INVESTIMENTO set nm_investimento=?, vl_investimento=?, dt_inicial=?, dt_resgate=?, T_FIN_USUARIO_DS_EMAIL=? where cd_investimento=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, investimento.getNome());
            stmt.setFloat(2, investimento.getVlInvestimento());
            stmt.setString(3, investimento.getDtInicial());
            stmt.setDate(4, investimento.getDtResgate());
            stmt.setString(5, investimento.getEmail());
            stmt.setInt(6, investimento.getCdInvestimento());

            stmt.execute();
            stmt.close();
            System.out.println("Atualizado com sucesso!");
        }catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }



    }

}