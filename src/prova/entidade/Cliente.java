
package prova.entidade;


public class Cliente {
    private int idCliente;
    private String nome;
    
    public Cliente(int idCliente,String nome){
        setIdCliente(idCliente);
        setNome(nome);
        
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
