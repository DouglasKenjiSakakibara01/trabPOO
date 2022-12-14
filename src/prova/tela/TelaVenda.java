package prova.tela;

import java.awt.BorderLayout; // do painel do frame
import java.awt.FlowLayout; // cria um painel para os botoes
import java.awt.GridLayout; //cria o gridlayout no panel

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import prova.controle.ControlePedido;
import prova.controle.ControleProduto;

public class TelaVenda extends JFrame {
   //atributos da classe que são campos texto da tela.
    private JTextField edtId = new JTextField(30);
    private JTextField edtQuantidade = new JTextField(30);
    private JTextField edtValor = new JTextField(30);
    private JTextField edtIdProduto = new JTextField(30);
    private JTextField edtIdCliente = new JTextField(30);
    

    private int idPedido;
    private int idProduto;
    private float valor;
    private int quantidade;
    private int idCliente;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
    

    

    public TelaVenda(){
        this.setTitle("Venda de produtos"); // título da tela
       
        this.getContentPane().setLayout(new BorderLayout()); // definição de layout do painel
        this.getContentPane().add(getCampos(),BorderLayout.CENTER); // layout para os campos
        this.getContentPane().add(getBotoes(),BorderLayout.PAGE_END); // layout de botão
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // operação destroi a janela
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // encerra a aplicacao
        //this.setSize(300,300); // tamanho do frame
        this.pack(); // organiza o tamanho a tela
        this.setLocationRelativeTo(null); // centraliza a tela
        this.setVisible(true); // torna o frame visível
    }

 


    private JPanel getCampos() { // retorna montado o painel de campos
       
        JPanel pnPrincipal = new JPanel(new GridLayout(7,2)); // define um leiaute com 7 linhas e duas colunas

        pnPrincipal.add(new JLabel("Id do pedido:")); // cria um label para o campo
        pnPrincipal.add(this.edtId);// cria o campo texto na tela
        pnPrincipal.add(new JLabel("Id do produto:")); // cria um label para o campo
        pnPrincipal.add(this.edtIdProduto); // cria o campo texto na tela
        pnPrincipal.add(new JLabel("Id do cliente:")); // cria um label para o campo
        pnPrincipal.add(this.edtIdCliente); // cria o campo texto na tela
        pnPrincipal.add(new JLabel("Quantidade:")); // cria um label para o campo
        pnPrincipal.add(this.edtQuantidade); // cria o campo texto na tela
        pnPrincipal.add(new JLabel("Valor:")); // cria um label para o campo
        pnPrincipal.add(this.edtValor); // cria o campo texto na tela
        
        

        return pnPrincipal; // retorna o painel
    }
   
    private JPanel getBotoes() { // retorna montado o painel de botões
        JPanel pnBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER)); // define um leiaute para os botões
           
        JButton btnSair = new JButton("Sair"); // cria um botão
        JButton btnSalvar= new JButton("Salvar"); // cria um botão
        JButton btnCancelar = new JButton("Cancelar"); // cria um botão
 
        btnSair.addActionListener(this::btnSairClick); // adiciona o action listener nos botoes
        btnCancelar.addActionListener(this::btnCancelarClick); // adiciona o action listener nos botoes
        btnSalvar.addActionListener(this::btnSalvarClick);// adiciona o action listener nos botoes

        pnBotoes.add(btnSalvar); // adiciona um botão ao painel
        pnBotoes.add(btnCancelar);// adiciona um botão ao painel
        pnBotoes.add(btnSair);// adiciona um botão ao painel

        return pnBotoes; // retorna o painel de botão
    }

    public void btnSairClick (ActionEvent ev){

        switch (JOptionPane.showConfirmDialog(this, "Deseja sair?", "Sair", JOptionPane.OK_CANCEL_OPTION))
       
        {
            case JOptionPane.CANCEL_OPTION:
                break;
            case JOptionPane.OK_OPTION:
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                break;
        }
   
    }
    
    public void btnSalvarClick(ActionEvent ev){
        ControlePedido cp = new ControlePedido(); //cria um objeto do tipo controle pedido
        ControleProduto cprod=new ControleProduto();//cria um objeto do tipo controle pedido
        /*
        this.setIdProduto(Integer.parseInt(edtIdProduto.getText())); //seta o id de produto
        if((cprod.verificarPedido(this.getIdProduto()))==0){
            StringBuilder mensagem = new StringBuilder();

            mensagem.append("O produto não está cadastrado, digite outro ");
            JOptionPane.showMessageDialog(null, mensagem);
            
        }*/
        this.setIdPedido(Integer.parseInt(edtId.getText())); //seta o id de pedido
        this.setIdCliente(Integer.parseInt(edtIdCliente.getText()));//seta o id do cliente
        this.setQuantidade(Integer.parseInt(edtQuantidade.getText()));//seta a quantidade de produto
        this.setValor(Float.parseFloat(edtValor.getText()));//seta o valor do produto
        
        
        try {
            cp.inserirPedido(getIdPedido(),getIdCliente(),getQuantidade()* getValor());
        } catch (SQLException e) {
            e.printStackTrace();
        }           
 
    }
    public void btnCancelarClick(ActionEvent ev){
        switch (JOptionPane.showConfirmDialog(this, "Deseja cancelar?", "Sair", JOptionPane.OK_CANCEL_OPTION))
       
        {
            case JOptionPane.CANCEL_OPTION:
                break;
            case JOptionPane.OK_OPTION:
                edtId.setText("");//esvazia o idProduto preenchido        
                edtIdProduto.setText("");//esvazia o nome preenchido 
                edtQuantidade.setText("");//esvazia o nome preenchido 
                edtValor.setText("");//esvazia o nome preenchido 
                edtIdCliente.setText("");//esvazia o o id de cliente
        }        
 
    }
    
}
