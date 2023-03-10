package aruiz;

import java.util.ArrayList;

public class ListadoPedidos {

    private ArrayList<Pedido> pedidos;

    public ListadoPedidos(){
        this.pedidos = new ArrayList<>();
    }

    public void anyadirPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    public Pedido filtrarPedido(String codigo){
        for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(codigo)) {
                return pedido;
            }
        }
        return null;
    }

    public ArrayList<Pedido> getPedidos(){
        return pedidos;
    }

    public int getNumeroPedidos(){
        int aux = 0;
        for (Pedido pedido : pedidos) {
            if (pedido != null) {
                aux++;
            } else return 0;
        }
        return aux+1;
    }
}
