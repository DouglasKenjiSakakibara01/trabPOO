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

import java.awt.event.ActionEvent;
import java.sql.*;
import prova.controle.ControleProduto;

public class TelaGUI extends JFrame {
   //atributos da classe que são campos texto da tela.
    private JTextField edtId = new JTextField(30);
    private JTextField edtNome = new JTextField(30);
    private int idProduto;
    private String nome;

    

    public TelaGUI(){
        this.setTitle("Cadastro de Produto"); // título da tela
       
        this.getContentPane().setLayout(new BorderLayout()); // definição de layout do painel
        this.getContentPane().add(getCampos(),BorderLayout.CENTER); // layout para os campos
        this.getContentPane().add(getBotoes(),BorderLayout.PAGE_END); // layout de botão
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // operação destroi a janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // encerra a aplicacao
        //this.setSize(300,300); // tamanho do frame
        this.pack(); // organiza o tamanho a tela
        this.setLocationRelativeTo(null); // centraliza a tela
        this.setVisible(true); // torna o frame visível
    }

 


    private JPanel getCampos() { // retorna montado o painel de campos
       
        JPanel pnPrincipal = new JPanel(new GridLayout(7,2)); // define um leiaute com 7 linhas e duas colunas

        pnPrincipal.add(new JLabel("Id do produto:")); // cria um label para o campo
        pnPrincipal.add(this.edtId); // cria o campo texto na tela
        pnPrincipal.add(new JLabel("Nome:")); // cria um label para o campo
        pnPrincipal.add(this.edtNome); // cria o campo texto na tela

        

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
        this.setIdProduto(Integer.parseInt(edtId.getText())); //seta o id do produto
        
        this.setNome(edtNome.getText()); //seta o nome do produto
        System.out.println(this.getIdProduto()); //imprime o nome do produto
        System.out.println(this.getNome()); //imprime o nome do produto
        ControleProduto cp = new ControleProduto(); //cria um objeto do tipo controle produto
        try {
            cp.inserirProduto(getIdProduto(), getNome());
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
                edtNome.setText("");//esvazia o nome preenchido 
        }        
 
    }
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}