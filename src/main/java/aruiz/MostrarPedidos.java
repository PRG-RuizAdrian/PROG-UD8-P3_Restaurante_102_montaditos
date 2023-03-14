package aruiz;

import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.time.format.DateTimeFormatter;
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
        for (int i = 0; i < pedidos.size(); i++) {
                AT_Row fila = nuevaTabla.addRow(pedidos.get(i).getId(),pedidos.get(i).getNombreCliente(),pedidos.get(i).getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),pedidos.get(i).getServido());
                fila.setTextAlignment(TextAlignment.CENTER);
                nuevaTabla.addRule();
        }
        nuevaTabla.addRow("","","","");
        System.out.println(nuevaTabla.render(100));
    }

    public void mostrarPedidosConcreto(){

        AsciiTable nuevaTabla = new AsciiTable();
        nuevaTabla.addRule();
       // AT_Row fila1 = nuevaTabla.addRow(null,"== Restaurante 20 Montaditos ==",null,null);
        //fila1.setTextAlignment(TextAlignment.CENTER);
       // nuevaTabla.addRule();
        AT_Row fila2 = nuevaTabla.addRow( "", "Nombre", "Precio", "Descuenta(%)", "PvP");
        fila2.setTextAlignment(TextAlignment.CENTER);
        nuevaTabla.addRule();
        for (int i = 0; i <pedidos.size() ; i++) {
            for (int j = 0; j < pedidos.get(i).getProductos().size(); j++) {
                AT_Row fila = nuevaTabla.addRow(pedidos.get(i).getProductos().get(j).getCode(), pedidos.get(i).getProductos().get(j).getNombre(), pedidos.get(i).getProductos().get(j).getPrecioBase(), pedidos.get(i).getProductos().get(j).getDescuento(), pedidos.get(i).getProductos().get(i).getPvp());
                fila.setTextAlignment(TextAlignment.CENTER);
                nuevaTabla.addRule();
            }
        }
            System.out.println(nuevaTabla.render(100));

        }
    }

