
package prova.conexao_BD;
import java.sql.*;



public class MySqlFactory implements ConnectionFactory{
    @Override
    public Connection getConnection() {
        String bd = "PROVA";
        String url = "jdbc:mysql://localhost:3306/" + bd;
        String user = "root";
        String password = "kenji1234";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
