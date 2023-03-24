package aruiz.menu;

import aruiz.*;
import aruiz.clasesRestaurante2.ColaPedidosPendientes;
import aruiz.exceptions.NoEncontradoException;
import aruiz.tiposProducto.TipoMenu;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import static aruiz.Restaurante.scanner;

public class CrearNuevoPedido extends Opcion{

    private ListadoProductos listadoProductos;
    private ColaPedidosPendientes colaPedidosPendientes;
    public CrearNuevoPedido(String titulo, ColaPedidosPendientes colaPedidosPendientes, ListadoProductos listadoProductos){
        super(titulo);
        this.colaPedidosPendientes = colaPedidosPendientes;
        this.listadoProductos = listadoProductos;
    }

    @Override
    public void ejecutar() {
        crearPedido(listadoProductos, colaPedidosPendientes);
    }

    public void crearPedido(ListadoProductos listadoProductos, ColaPedidosPendientes colaPedidosPendientes) {

        String setIdentificador = "o" + (colaPedidosPendientes.getPedidosPendientes().size()+1);
        System.out.println("Introduzca su nombre");
        String setNombreCliente = scanner.next();
        Pedido pedido = new Pedido(setIdentificador, setNombreCliente,fecha());
        repetirTipoProducto(TipoMenu.BEBIDA,"Deseas tomar alguna bebida?",pedido,listadoProductos);
        new MostrarProductos(listadoProductos.filtrarProductos(TipoMenu.BEBIDA)).mostrarProductos();
        repetirTipoProducto(TipoMenu.ENTRANTES,"Deseas tomar algun entrante?",pedido,listadoProductos);
        new MostrarProductos(listadoProductos.filtrarProductos(TipoMenu.ENTRANTES)).mostrarProductos();
        repetirTipoProducto(TipoMenu.MONTADITOS,"Deseas tomar algun montadito?",pedido,listadoProductos);
        new MostrarProductos(listadoProductos.filtrarProductos(TipoMenu.MONTADITOS)).mostrarProductos();
        repetirTipoProducto(TipoMenu.POSTRE,"Postre quieres?",pedido,listadoProductos);
        new MostrarProductos(listadoProductos.filtrarProductos(TipoMenu.POSTRE)).mostrarProductos();

        colaPedidosPendientes.anyadir(pedido);
    }
    private void repetirTipoProducto(TipoMenu tipoMenu, String mensaje,Pedido pedido, ListadoProductos listadoProductos){
        System.out.println(mensaje);
        ArrayList<Producto> productos = listadoProductos.filtrarProductos2(tipoMenu);
        MostrarProductos mostrarProductos = new MostrarProductos(productos);
        mostrarProductos.mostrarProductos();
        anyadirProductosAPedido(listadoProductos, pedido);
    }
    private void anyadirProductosAPedido(ListadoProductos listadoProductos, Pedido pedido) {
        do {
            try {
            System.out.println("Introduzca el código del producto que desea añadir (0 - Finalizar)");
            String codigo = Restaurante.scanner.next();
            if (codigo.equals("0")){
                break;
            }
                pedido.anyadirProducto(listadoProductos.anyadirProducto(codigo));
                System.out.println(listadoProductos.anyadirProducto(codigo).getCode() + " - " + listadoProductos.anyadirProducto(codigo).getNombre() + " [Añadido]");
            } catch (NoEncontradoException e){
                System.out.println(e);
            }
        } while (true) ;
    }

    public LocalDateTime fecha(){
        System.out.println("¿Quieres añadir la fecha automáticamente? S/N");
        String opcion = scanner.next().toUpperCase();
        switch (opcion){
            case "S":
                return LocalDateTime.now();
            case "N":
                try {
                    System.out.println("Introduce fecha [dd/MM/yyyy]: ");
                    String dateAsString = scanner.next();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    return LocalDateTime.parse(dateAsString + " 08:00", formatter);
                } catch(DateTimeParseException e) {
                    System.out.println("La data introduïda no és vàlida.\nFecha introducida automáticamente.");
                    return LocalDateTime.now();
                }
            default: return null;
        }
    }

}
