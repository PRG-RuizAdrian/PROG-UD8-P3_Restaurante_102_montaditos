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
       // AT_Row fila1 = nuevaTabla.addRow(null,"== Restaurante 20 Montaditos ==",null,null);
        //fila1.setTextAlignment(TextAlignment.CENTER);
        nuevaTabla.addRule();
        AT_Row fila2 = nuevaTabla.addRow( "Código", "Cliente", "Fecha", "Servido");
        fila2.setTextAlignment(TextAlignment.CENTER);
        nuevaTabla.addRule();
        for (int i = 0; i < pedidos.size(); i++) {
                AT_Row fila = nuevaTabla.addRow(pedidos.get(i).getId(),pedidos.get(i).getNombreCliente(),pedidos.get(i).getFecha(),pedidos.get(i).getServido());
                fila.setTextAlignment(TextAlignment.CENTER);
                nuevaTabla.addRule();
        }
        System.out.println(nuevaTabla.render(100));
    }

    public void mostrarPedidos2(){

        AsciiTable nuevaTabla = new AsciiTable();
        nuevaTabla.addRule();
        AT_Row fila1 = nuevaTabla.addRow(null,"== Restaurante 20 Montaditos ==",null,null);
        fila1.setTextAlignment(TextAlignment.CENTER);
        nuevaTabla.addRule();
        AT_Row fila2 = nuevaTabla.addRow( "Código", "Cliente", "Fecha", "Servido");
        fila2.setTextAlignment(TextAlignment.CENTER);
        nuevaTabla.addRule();
        for (int i = 0; i <pedidos.size() ; i++) {
            {
                AT_Row fila = nuevaTabla.addRow(pedidos.get(i).getId(),pedidos.get(i).getNombreCliente(),pedidos.get(i).getFecha(),pedidos.get(i).getServido());
                fila.setTextAlignment(TextAlignment.CENTER);
                nuevaTabla.addRule();
            }
        }
    }
}
