package prova.entidade;


public class Produto {
    private int idProduto;
    private String nome;
    
    public Produto(int idProduto,String nome){
        setIdProduto(idProduto);
        setNome(nome);
        
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
