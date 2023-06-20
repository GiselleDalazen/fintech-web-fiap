package br.com.fintech.dao;

import br.com.fintech.filter.LoginFilter;
import br.com.fintech.model.Objetivo;
import br.com.fintech.connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ObjetivoDAO {
	
	private Connection connection;

    public ObjetivoDAO() {
    
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.conectar();
    }
    
    public int insert (Objetivo objetivo) {
        String sql = "insert into T_FIN_OBJETIVOS (cd_objetivo, ds_objetivo, vl_meta, dt_objetivo, T_FIN_USUARIO_DS_EMAIL)" +
                "values (SQ_OBJETIVOS.nextval, ?, ?, ?, ?)";

        PreparedStatement stmt = null;
        try {
            Date dataObjetivo = new Date(new java.util.Date().getTime());
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, objetivo.getDescricao());
            stmt.setDouble(2, objetivo.getValor());
            stmt.setDate(3, dataObjetivo);
            stmt.setString(4, objetivo.getEmail());


            int row = stmt.executeUpdate();
            System.out.print("Objetivo cadastrado com sucesso");
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
    
    public List<Objetivo> getAllById(String email){
    	
    	List<Objetivo> objetivos = new ArrayList<Objetivo>();
    	
    	 String sql = "select * from T_FIN_OBJETIVOS where T_FIN_USUARIO_DS_EMAIL='"+ email + "' order by CD_OBJETIVO";
         try {

             Statement stmt = connection.createStatement();

             ResultSet rs = stmt.executeQuery(sql);

             while(rs.next()) {
                 Objetivo objetivo = new Objetivo();
                 objetivo.setCodigo(rs.getInt("cd_objetivo"));
                 objetivo.setDescricao(rs.getString("nm_objetivo"));
                 objetivo.setValor(rs.getDouble("vl_meta"));
                 objetivo.setData(rs.getDate("dt_objetivo"));
                 objetivo.setEmail(rs.getString("t_fin_usuario_ds_email"));

                 objetivos.add(objetivo);
             }
             rs.close();
             stmt.close();
             return objetivos;

         } catch (SQLException e) {
             System.out.println("Erro: " + e.getMessage());
             return null;
         }
	
}
    
    public Objetivo selectById(int codigo) {
    	
    	Objetivo objetivo = null;
        String sql = "select * from T_FIN_OBJETIVOS where cd_objetivo=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigo);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	objetivo = new Objetivo();
                objetivo.setCodigo(rs.getInt("cd_objetivo"));
                objetivo.setDescricao(rs.getString("nm_objetivo"));
                objetivo.setValor(rs.getDouble("vl_meta"));
                objetivo.setData(rs.getDate("dt_objetivo"));
            }

            rs.close();
            stmt.close();
            return objetivo;
            
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    	
    
    public void delete(int codigo) throws SQLException {
        String sql = "delete from T_FIN_OBJETIVOS where cd_objetivo=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, codigo);
        stmt.execute();
        stmt.close(); 
    	
    }
    
    public void update(Objetivo objetivo) throws SQLException {
            String sql = "update T_FIN_OBJETIVOS set nm_objetivo=?, vl_meta=?, dt_objetivo=? where cd_objetivo=?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, objetivo.getDescricao());
            stmt.setDouble(2, objetivo.getValor());
            Date dataObjetivo = new Date(new java.util.Date().getTime());
            stmt.setDate(3, dataObjetivo);
            stmt.setInt(4, objetivo.getCodigo());

            stmt.execute();
            stmt.close();

    }
}
