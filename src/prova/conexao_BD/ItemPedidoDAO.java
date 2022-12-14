/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova.conexao_BD;
import prova.entidade.ItemPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Win 7
 */
public class ItemPedidoDAO {
    private MySqlFactory conn;
    
    public void inserir(ItemPedido item) throws SQLException {
        String sql = "INSERT INTO_PEDIDO"
                + " (ID_ITEM, "
                + "  QUANTIDADE,  "
                + "  VALOR)"
                + "VALUES (?, ?)";
        Connection conProduto = conn.getConnection();
        try {
            PreparedStatement stmt = conProduto.prepareStatement(sql);
            stmt.setInt(1, item.getIdItem());
            stmt.setInt(2, item.getQuantidade());
            stmt.setFloat(3,item.getValor());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
