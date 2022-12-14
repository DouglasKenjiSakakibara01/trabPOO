
package prova.entidade;


public class ItemPedido {
    private int idItem;
    private int quantidade;
    private float valor;
    
    public ItemPedido(){
        
    }
    public ItemPedido(int id,int quantidade,float valor){
        this.setIdItem(id);
        this.setQuantidade(quantidade);
        this.setValor(valor);
    }
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
}
