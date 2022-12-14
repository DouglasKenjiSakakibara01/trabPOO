package prova.controle;
import prova.entidade.Produto;
import java.sql.*;
import prova.conexao_BD.PedidoDAO;
import prova.conexao_BD.ProdutoDAO;
public class ControleProduto {
        public void inserirProduto(int id,String nome) throws SQLException{//Insere o produto no banco de dados utilzando a classe DAO 
            Produto produto=new Produto(id,nome);
            ProdutoDAO dao=new ProdutoDAO();
            dao.inserir(produto);
            
        }
        public int verificarProduto(int id) throws SQLException{//Verifica se existe o produto selecionado no banco de dados utilizando a classe DAO
          ProdutoDAO dao=new ProdutoDAO();
          if(dao.verificarProduto(id)){//Caso exista o Produto
            return 1;
        }
          return 0;
    }
    
}
