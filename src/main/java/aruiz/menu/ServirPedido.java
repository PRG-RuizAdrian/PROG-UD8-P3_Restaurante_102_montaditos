package aruiz.menu;

import aruiz.ListadoPedidos;
import aruiz.MostrarPedidos;
import aruiz.Restaurante;
import aruiz.clasesRestaurante2.ColaPedidosPendientes;


import static aruiz.Restaurante.scanner;

public class ServirPedido extends Opcion{


    private ListadoPedidos listadoPedidos;
    private ColaPedidosPendientes colaPedidosPendientes;

    public ServirPedido(String titulo, ListadoPedidos listadoPedidos, ColaPedidosPendientes colaPedidosPendientes) {
        super(titulo);
        this.listadoPedidos=listadoPedidos;
        this.colaPedidosPendientes=colaPedidosPendientes;
    }

    @Override
    public void ejecutar() {servirPedido(listadoPedidos,colaPedidosPendientes);}
    public void servirPedido(ListadoPedidos listadoPedidos, ColaPedidosPendientes colaPedidosPendientes){

        do {
            new MostrarPedidos(colaPedidosPendientes.getPedidosPendientes()).mostrarPedidosConcreto();
            System.out.println("Esta seguro de que quiere servir el siguiente pedido? S/N");
            String opcion = scanner.next().toUpperCase();
            switch (opcion){
                case "S":
                    colaPedidosPendientes.getPedidosPendientes().get(0).setServidoTrue();
                    listadoPedidos.anyadirPedido(colaPedidosPendientes.obtenerSiguiente());
                    System.out.println("Pedido servido");
                    break;
                case "N":
                    System.out.println("Pedido no servido");
                default: continue;
            }
            new MostrarPedidos(colaPedidosPendientes.getPedidosPendientes()).mostrarPedidos();
                }while (true);


    }

}

