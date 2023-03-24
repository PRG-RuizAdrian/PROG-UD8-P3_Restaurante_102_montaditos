package aruiz;

import aruiz.exceptions.NoEncontradoException;

import java.util.ArrayList;

public class ListadoPedidos {

    private ArrayList<Pedido> pedidos;

    public ListadoPedidos(){
        this.pedidos = new ArrayList<>();
    }

    public void anyadirPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    public Pedido filtrarPedido(String codigo) throws NoEncontradoException {
        for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(codigo)) {
                return pedido;
            }
        } throw new NoEncontradoException();
    }
    public boolean listaVacia(){
       return getNumeroPedidos() == 0;
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
