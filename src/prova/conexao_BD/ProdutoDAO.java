
package prova.conexao_BD;

import prova.entidade.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProdutoDAO {
    private MySqlFactory conn;
    
    public void inserir(Produto prod) throws SQLException {
        String sql = "INSERT INTO PRODUTO"
                + " (ID_PRODUTO, "
                + "NOME)"
                + "VALUES (?, ?)";
        Connection conProduto = conn.getConnection();
        try {
            PreparedStatement stmt = conProduto.prepareStatement(sql);
            stmt.setInt(1, prod.getIdProduto());
            stmt.setString(2, prod.getNome());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList listar() {
        String sql = "SELECT "
                + "ID_PRODUTO, "
                + "NOME "
                + "FROM PRODUTO";

        Connection conProduto = conn.getConnection();
        ArrayList<Produto> produtos = new ArrayList<>();
        Produto produto;
        try {
            Statement stmt = conProduto.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                produto = new Produto(rs.getInt(1), rs.getString(2));
                produtos.add(produto);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produtos;
    }

    
    public boolean verificarProduto(int idProduto) throws SQLException{
        String sql = "SELECT ID_PRODUTO FROM PEDIDO WHERE ID_PRODUTO="+idProduto;
        Connection conPedido = conn.getConnection();
        Statement stmt = conPedido.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs!=null){
              return true;

        }
        return false;
    }
}
