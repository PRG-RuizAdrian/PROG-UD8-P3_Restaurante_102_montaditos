package aruiz;

import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;


import java.util.ArrayList;

public class MostrarPedidos {

    private ArrayList<Pedido> pedidos;

    public MostrarPedidos(ArrayList<Pedido> pedidos){
        this.pedidos = pedidos;
    }

    public void mostrarPedidos(){

        AsciiTable nuevaTabla = new AsciiTable();
        nuevaTabla.addRule();
        AT_Row fila2 = nuevaTabla.addRow( "Código", "Cliente", "Fecha", "Servido");
        fila2.setTextAlignment(TextAlignment.CENTER);
        nuevaTabla.addRule();
        for (Pedido pedido : pedidos) {
            AT_Row fila = nuevaTabla.addRow(pedido.getId(), pedido.getNombreCliente(), pedido.getFecha(), pedido.getServido());
            fila.setTextAlignment(TextAlignment.CENTER);
            nuevaTabla.addRule();
        }
        nuevaTabla.addRow("","","","");
        System.out.println(nuevaTabla.render(100));
    }

    public void mostrarPedidosConcreto(){

        AsciiTable nuevaTabla = new AsciiTable();
        nuevaTabla.addRule();
        AT_Row fila1 = nuevaTabla.addRow(null,null,null,null,"== Restaurante 20 Montaditos ==");
        nuevaTabla.addRule();
        fila1.setTextAlignment(TextAlignment.CENTER);
        AT_Row fila2 = nuevaTabla.addRow("Pedido: "+ pedidos.get(0).getId(),null, "Cliente: "+ pedidos.get(0).getNombreCliente(),null, "Fecha: "+ pedidos.get(0).getFecha() );
        nuevaTabla.addRule();
        AT_Row fila3 = nuevaTabla.addRow(null,null,null,null,"Listado productos solicitados" );
        nuevaTabla.addRule();
        AT_Row fila4 = nuevaTabla.addRow( "", "Nombre", "Precio", "Descuenta(%)", "PvP");
        fila4.setTextAlignment(TextAlignment.CENTER);
        nuevaTabla.addRule();
            for (int i = 0; i < pedidos.get(0).getProductos().size(); i++) {
                AT_Row fila = nuevaTabla.addRow(pedidos.get(0).getProductos().get(i).getCode(), pedidos.get(0).getProductos().get(i).getNombre(), pedidos.get(0).getProductos().get(i).getPrecioBase()+"€", pedidos.get(0).getProductos().get(i).getDescuento(), pedidos.get(0).getProductos().get(i).getPvp()+"€");
                fila.setTextAlignment(TextAlignment.CENTER);
                nuevaTabla.addRule();
            }

        nuevaTabla.addRow(null,null,"","Total",pedidos.get(0).getTotalPecioProductos()+"€");
        nuevaTabla.addRule();
        nuevaTabla.addRow("*","*","*","*","*");
            System.out.println(nuevaTabla.render(100));

        }
    }

