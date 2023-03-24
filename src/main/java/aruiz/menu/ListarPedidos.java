package aruiz.menu;


import aruiz.MostrarPedidos;
import aruiz.clasesRestaurante2.ColaPedidosPendientes;

public class ListarPedidos extends Opcion{


    private ColaPedidosPendientes colaPedidosPendientes;
    public ListarPedidos(String titulo, ColaPedidosPendientes colaPedidosPendientes) {
        super(titulo);
        this.colaPedidosPendientes = colaPedidosPendientes;
    }

    @Override
    public void ejecutar() {
        new MostrarPedidos(colaPedidosPendientes.getPedidosPendientes()).mostrarPedidos();
    }
}
