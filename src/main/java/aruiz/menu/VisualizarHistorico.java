package aruiz.menu;

import aruiz.ListadoPedidos;
import aruiz.MostrarPedidos;
import aruiz.Pedido;
import aruiz.clasesRestaurante2.ColaPedidosPendientes;

import java.util.ArrayList;

import static aruiz.Restaurante.scanner;

public class VisualizarHistorico extends Opcion{


    private ListadoPedidos listadoPedidos;
    public VisualizarHistorico(String titulo, ListadoPedidos listadoPedidos) {
        super(titulo);
        this.listadoPedidos = listadoPedidos;
    }

    @Override
    public void ejecutar() {
        visualizarOrden(listadoPedidos);
    }

    public void visualizarOrden(ListadoPedidos listadoPedidos) {
        int aux = 0;
        do {
            new MostrarPedidos(listadoPedidos.getPedidos()).mostrarPedidos();
            System.out.println("Introduzca el código de la orden que desear Visualizar");
            String codigo = scanner.next();
            if (listadoPedidos.filtrarPedido(codigo) != null) {
                ArrayList<Pedido> pedido = new ArrayList<>();
                pedido.add(listadoPedidos.filtrarPedido(codigo));
                new MostrarPedidos(pedido).mostrarPedidosConcreto();
                aux++;
            } else {
                System.out.println("Código de pedido incorrecto.");
            }
        }while (aux==0);
    }
}
