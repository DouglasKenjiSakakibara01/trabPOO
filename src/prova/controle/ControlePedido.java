
package prova.controle;
import prova.entidade.Pedido;
import java.sql.*;
import prova.conexao_BD.MySqlFactory;
import prova.conexao_BD.PedidoDAO;
import java.util.ArrayList;
public class ControlePedido {
    private int idPedido;
    private int idCliente;
    private float valorTotal;
    private MySqlFactory conn;
    public void inserirPedido(int id,int idCliente,float valor) throws SQLException{
         Pedido pedido=new Pedido(id,idCliente,valor);
         PedidoDAO dao=new PedidoDAO();
         dao.inserir(pedido);
            
        }
    public ArrayList<Pedido> listarPedidos(){
        PedidoDAO dao=new PedidoDAO();
        return dao.listar();
    }
    

}