/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova.controle;

import java.sql.SQLException;
import prova.entidade.ItemPedido;
import prova.conexao_BD.ItemPedidoDAO;

/**
 *
 * @author Win 7
 */
public class ControleItemPedido {
    public void inserirItem(int id,int quantidade,float valor) throws SQLException{//Insere o produto no banco de dados utilzando a classe DAO 
            ItemPedido item=new ItemPedido(id,quantidade,valor);
            ItemPedidoDAO dao=new ItemPedidoDAO();
            dao.inserir(item);
            
        }
}
