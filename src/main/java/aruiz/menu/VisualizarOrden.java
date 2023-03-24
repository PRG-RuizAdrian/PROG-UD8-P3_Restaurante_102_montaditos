package aruiz.menu;

import aruiz.ListadoPedidos;
import aruiz.ListadoProductos;
import aruiz.MostrarPedidos;
import aruiz.Pedido;
import aruiz.clasesRestaurante2.ColaPedidosPendientes;

import java.util.ArrayList;

import static aruiz.Restaurante.scanner;

public class VisualizarOrden extends Opcion{

    private ColaPedidosPendientes colaPedidosPendientes;
    public VisualizarOrden(String titulo, ColaPedidosPendientes colaPedidosPendientes) {
        super(titulo);
        this.colaPedidosPendientes = colaPedidosPendientes;
    }

    @Override
    public void ejecutar() {
        visualizarOrden(colaPedidosPendientes);
    }

    public void visualizarOrden(ColaPedidosPendientes colaPedidosPendientes) {
        int aux = 0;
        do {
            new MostrarPedidos(colaPedidosPendientes.getPedidosPendientes()).mostrarPedidos();
            System.out.println("Introduzca el código de la orden que desear Visualizar");
            String codigo = scanner.next();
            if (colaPedidosPendientes.filtrarPedidosPendientes(codigo) != null) {
                ArrayList<Pedido> pedido = new ArrayList<>();
                pedido.add(colaPedidosPendientes.filtrarPedidosPendientes(codigo));
                new MostrarPedidos(pedido).mostrarPedidosConcreto();
                aux++;
            } else {
                System.out.println("Código de pedido incorrecto.");
            }
        }while (aux==0);
    }
}
