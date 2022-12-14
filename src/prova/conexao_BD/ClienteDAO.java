
package prova.conexao_BD;
import prova.entidade.Cliente;
import java.sql.*;
import java.util.ArrayList;
public class ClienteDAO {
    private MySqlFactory conn;
    
    public void inserir(Cliente cli) throws SQLException {
        String sql = "INSERT INTO CLIENTE"
                + " (ID_CLIENTE, "
                + "NOME)"
                + "VALUES (?, ?)";
        Connection conCliente = conn.getConnection();
        try {
            PreparedStatement stmt = conCliente.prepareStatement(sql);
            stmt.setInt(1, cli.getIdCliente());
            stmt.setString(2, cli.getNome());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList listar() {
        String sql = "SELECT "
                + "ID_CLIENTE, "
                + "NOME "
                + "FROM CLIENTE";

        Connection conCliente = conn.getConnection();
        ArrayList<Cliente> clientes = new ArrayList<>();
        Cliente cliente;
        try {
            Statement stmt = conCliente.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                cliente = new Cliente(rs.getInt(1), rs.getString(2));
                clientes.add(cliente);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientes;
    }

    public void atualizar(Cliente cliente) {
        String sql = "UPDATE CLIENTE\n"
                + "SET NOME = ?\n"
                + "WHERE ID_CLIENTE = ?;";
        System.out.println(cliente.getNome() + cliente.getIdCliente());

        Connection conCliente = conn.getConnection();
        try {
            PreparedStatement stmt = conCliente.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getIdCliente());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    public void excluir() {

    }   */ 
        
    
}
