package aruiz;

import aruiz.clasesRestaurante2.ColaPedidosPendientes;
import aruiz.menu.*;
import java.util.Scanner;

public class Restaurante {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Restaurante().menu();
    }

    public void menu() {
        ListadoProductos listadoProductos = new ListadoProductos();
        ListadoPedidos listadoPedidos = new ListadoPedidos();
        ColaPedidosPendientes colaPedidosPendientes = new ColaPedidosPendientes();
        Menu menu = new Menu("20 montaditos");
        menu.anyadir(new CrearNuevoPedido("Crear nuevo pedido", colaPedidosPendientes, listadoProductos));
        menu.anyadir(new ListarPedidos("Listar todos los pedidos", colaPedidosPendientes));
        menu.anyadir(new VisualizarOrden("Visualizar orden", colaPedidosPendientes));
        menu.anyadir(new VisualizarHistorico("Visualizar histórico", listadoPedidos));
        menu.anyadir(new ServirPedido("Preparar pedido",listadoPedidos,colaPedidosPendientes));
        menu.anyadir(new Salir("Salir"));
        menu.ejecutar();
    }

}
