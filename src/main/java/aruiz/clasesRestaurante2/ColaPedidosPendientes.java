package aruiz.clasesRestaurante2;


import aruiz.Pedido;
import aruiz.exceptions.ColaLLenaException;
import aruiz.exceptions.ColaVaciaException;
import aruiz.exceptions.NoEncontradoException;

import java.util.ArrayList;

public class ColaPedidosPendientes {

    private ArrayList<Pedido> pedidosPendientes;
    private int pedidosMaximos;

    public ColaPedidosPendientes(){
        this.pedidosPendientes = new ArrayList<>();
        this.pedidosMaximos = 100;
    }

    public void anyadir(Pedido pedido){
        if (estaLlena()){
            throw new ColaLLenaException();
        } else pedidosPendientes.add(pedido);
    }

    public Pedido obtenerSiguiente(){
    if (existenPedidos()){
        Pedido pedido = pedidosPendientes.get(0);
        pedidosPendientes.remove(0);
        return pedido;
    } throw new ColaVaciaException();
    }

    public Pedido filtrarPedidosPendientes(String codigo) throws NoEncontradoException {
        for (Pedido pedido : pedidosPendientes) {
            if (pedido.getId().equals(codigo)) {
                return pedido;
            }
        }throw new NoEncontradoException();
    }

    public boolean estaLlena(){
        return pedidosPendientes.size() == pedidosMaximos;
    }

    public boolean existenPedidos(){
        return pedidosPendientes != null;
    }

    public void devolver(Pedido pedido){
        pedidosPendientes.add(0,pedido);
    }

    public ArrayList<Pedido> getPedidosPendientes(){
        return pedidosPendientes;
    }



}
