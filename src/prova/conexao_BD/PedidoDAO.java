
package prova.conexao_BD;

import prova.entidade.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class PedidoDAO {
    private MySqlFactory conn;
    
    public void inserir(Pedido ped) throws SQLException {
        String sql = "INSERT INTO PEDIDO"
                + " (ID_PEDIDO, "
                + "  ID_CLIENTE, "
                + "VALOR_TOTAL)"
                + "VALUES (?, ?)";
        Connection conProduto = conn.getConnection();
        try {
            PreparedStatement stmt = conProduto.prepareStatement(sql);
            stmt.setInt(1, ped.getIdPedido());
            stmt.setInt(2, ped.getIdCliente());
            stmt.setFloat(3, ped.getValorTotal());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList listar() {
        String sql = "SELECT "
                + "ID_PEDIDO, "
                + "ID_CLIENTE, "
                + "VALOR_TOTAL"
                + "FROM PEDIDO";

        Connection conPedido = conn.getConnection();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Pedido pedido;
        try {
            Statement stmt = conPedido.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                pedido = new Pedido(rs.getInt(1), rs.getInt(2),rs.getFloat(3));
                pedidos.add(pedido);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pedidos;
    }
    

    
}
