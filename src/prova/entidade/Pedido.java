
package prova.entidade;
public class Pedido {
    private int idPedido;

    
    private int idCliente;
    private float valorTotal;
    private ItemPedido itemPedido=new ItemPedido();
    
    public Pedido(int id,int idCliente,float valor){
        setIdPedido(id);
        setIdCliente(idCliente);
        setValorTotal(valor);
        
    }
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
