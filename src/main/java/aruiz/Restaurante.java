package aruiz;

import aruiz.tiposProducto.TipoMenu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Restaurante().menu();
    }

    public void menu() {
        ListadoProductos listadoProductos = new ListadoProductos();
        ListadoPedidos listadoPedidos = new ListadoPedidos();

        int opcion;

        do {
            System.out.println("Bienvenido al bar de los 20 montaditos.");
            System.out.println("1. Crear nuevo pedido");
            System.out.println("2. Listar todos los pedidos");
            System.out.println("3. Visualizar orden");
            System.out.println("4. Servir pedido");
            System.out.println("5. Salir");
            System.out.println("Selecciona una opción :");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
            } else opcion = 0;

            switch (opcion) {
                case 1-> crearPedido(listadoProductos, listadoPedidos);
                case 2-> new MostrarPedidos(listadoPedidos.getPedidos()).mostrarPedidos();
                case 3-> visualizarOrden(listadoPedidos);
                case 4-> servirPedido(listadoPedidos);
                case 5-> System.out.println("Gracias por utilizar el sistema de gestión de pedidos.");
                default-> {
                    System.out.println("Opción no válida. Por favor, seleccione otra opción.");
                    scanner.next();
                }
            }
        } while (opcion != 5);
    }

    public void visualizarOrden(ListadoPedidos listadoPedidos){
        new MostrarPedidos(listadoPedidos.getPedidos()).mostrarPedidos();
        System.out.println("Introduzca el código de la orden que desear Visualizar");
        String codigo = scanner.next();
        ArrayList<Pedido> pedido = new ArrayList<>();
        pedido.add(listadoPedidos.filtrarPedido(codigo));
        new MostrarPedidos(pedido).mostrarPedidos();
    }

    public void servirPedido(ListadoPedidos listadoPedidos){
        new MostrarPedidos(listadoPedidos.getPedidos()).mostrarPedidos();
        System.out.println("Introduzca el código de la orden que desear servir");
        String codigo = scanner.next();
        listadoPedidos.filtrarPedido(codigo).setServidoTrue();
        new MostrarPedidos(listadoPedidos.getPedidos()).mostrarPedidos();
    }


    public void crearPedido(ListadoProductos listadoProductos, ListadoPedidos listadoPedidos) {

        String setIdentificador = "";
        System.out.println("Introduzca su nombre");
        String setNombreCliente = scanner.next();
        Pedido pedido = new Pedido(setIdentificador, setNombreCliente);
        repetirTipoProducto(TipoMenu.BEBIDA,"Deseas tomar alguna bebida?",listadoProductos);
        new MostrarProductos(listadoProductos.filtrarProductos(TipoMenu.BEBIDA)).mostrarProductos();
        repetirTipoProducto(TipoMenu.ENTRANTES,"Deseas tomar algun entrante?",listadoProductos);
        new MostrarProductos(listadoProductos.filtrarProductos(TipoMenu.ENTRANTES)).mostrarProductos();
        repetirTipoProducto(TipoMenu.MONTADITOS,"Deseas tomar algun montadito?",listadoProductos);
        new MostrarProductos(listadoProductos.filtrarProductos(TipoMenu.MONTADITOS)).mostrarProductos();
        repetirTipoProducto(TipoMenu.POSTRE,"Postre quieres?",listadoProductos);
        new MostrarProductos(listadoProductos.filtrarProductos(TipoMenu.POSTRE)).mostrarProductos();

        listadoPedidos.anyadirPedido(pedido);
    }

    private void repetirTipoProducto(TipoMenu tipoMenu, String mensaje,ListadoProductos listadoProductos){
        System.out.println(mensaje);
        ArrayList<Producto> productos = listadoProductos.filtrarProductos2(tipoMenu);
        MostrarProductos mostrarProductos = new MostrarProductos(productos);
        mostrarProductos.mostrarProductos();
        anyadirProductosAPedido(listadoProductos);
    }


    private void anyadirProductosAPedido(ListadoProductos listadoProductos) {
        do {
            System.out.println("Introduzca el código del producto que desea añadir (0 - Finalizar)");
            String codigo = scanner.next();
            if (codigo.equals("0")){
                break;
            }
            if (listadoProductos.anyadirProducto(codigo)!=null){
                listadoProductos.anyadirProducto(codigo);
                System.out.println(listadoProductos.anyadirProducto(codigo).getCode() + " - " + listadoProductos.anyadirProducto(codigo).getNombre() + " [Añadido]");
            } else {
                System.out.println("El código del producto introducido no existe");
            }
        } while (true) ;
    }
}
