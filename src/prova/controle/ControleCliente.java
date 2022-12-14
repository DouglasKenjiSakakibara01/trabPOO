
package prova.controle;
import prova.entidade.Cliente;
import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.*;
import prova.conexao_BD.ClienteDAO;
public class ControleCliente {
    private File f;
    private FileWriter fw;
    private BufferedWriter bw;
    private FileReader fr;
    private BufferedReader br;
    private ClienteDAO dao;
    
    public ControleCliente(String nome,String path) throws IOException,SQLException{
        lerArquivo(nome,path);
        
    }
        
    private void abrirArquivo(String nome, String path) throws IOException {
           String pathCompleto = path + nome;
           f = new File(pathCompleto);
           if (!f.exists()) {
             f.createNewFile();
        }
        }

        
    public ArrayList lerArquivo(String nomeArq, String path) throws IOException,SQLException{
           String linha = "";
           abrirArquivo(nomeArq, path);
           fr = new FileReader(f);
           br = new BufferedReader(fr);
           ArrayList<Cliente> cli = new ArrayList<>();
           dao=new ClienteDAO();
           while ((linha = br.readLine()) != null) {
            String[] dados = linha.split(",");
            Cliente cliente = new Cliente(Integer.parseInt(dados[0]), dados[1]);
            cli.add(cliente);
            dao.inserir(cliente);
        }

           br.close();
           fr.close();
           return cli;
    }
    }
        
    
    

