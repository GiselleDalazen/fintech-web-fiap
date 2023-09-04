package br.com.fintech.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private final String ORACLE = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
     public Connection conectar()  {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(ORACLE, "RMXXXXXX", "XXXXXXXX");
        } catch (SQLException e) {
           System.out.println("ERRO CONECTAR: "+ e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO CLASS NOT FOUND: "+ e.getMessage());
        } finally {
            return connection;
        }
    }

}
