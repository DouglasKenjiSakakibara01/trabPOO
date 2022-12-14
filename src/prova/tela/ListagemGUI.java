
package prova.tela;
import java.awt.BorderLayout; // do painel do frame
/*import java.awt.FlowLayout; // cria um painel para os botoes
import java.awt.GridLayout; //cria o gridlayout no panel*/

//import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JOptionPane;
/*import javax.swing.JPanel;
import javax.swing.JTextField;*/
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.io.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import prova.entidade.Pedido;
import prova.controle.ControlePedido;
import prova.controle.ControleProduto;
import java.util.ArrayList;
public class ListagemGUI extends JFrame{
    
    public ListagemGUI(){
        this.setTitle("Listagem"); // título da tela
       
        this.getContentPane().setLayout(new BorderLayout()); // definição de layout do painel
        this.getContentPane().add(this.listarVendas(),BorderLayout.CENTER); // layout para os campos
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // operação destroi a janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // encerra a aplicacao
        //this.setSize(300,300); // tamanho do frame
        this.pack(); // organiza o tamanho a tela
        this.setLocationRelativeTo(null); // centraliza a tela
        this.setVisible(true); // torna o frame visível
    }

    
    public JList listarVendas() {
        ArrayList<Pedido> pedidos = new ArrayList();
        ControlePedido cp= new ControlePedido();
        pedidos=cp.listarPedidos();
        DefaultListModel modelo = new DefaultListModel();
        JList list = new JList(modelo);

        for (int c=0;c<pedidos.size();c++) {
            modelo.add(c,pedidos.get(c));
        }
        return list;

    }
}
