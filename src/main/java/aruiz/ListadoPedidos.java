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
        for (int i = 0; i < pedidos.size() ; i++) {
            if (pedidos.get(i).getId().equals(codigo)){
                return pedidos.get(i);
            }
        }
        return null;
    }

    public ArrayList<Pedido> getPedidos(){
        return pedidos;
    }


}
