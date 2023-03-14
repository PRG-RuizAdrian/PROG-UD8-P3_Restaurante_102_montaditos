package aruiz;

import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.ArrayList;

public class MostrarProductos {

    private ArrayList<Producto> productos;

    public MostrarProductos(ArrayList<Producto> productos){
        this.productos = productos;
    }

    public void mostrarProductos(){

        AsciiTable nuevaTabla = new AsciiTable();
        nuevaTabla.addRule();
       AT_Row fila1 = nuevaTabla.addRow(null,null,null,null,productos.get(0).getTipoMenu().toString().toLowerCase());
       fila1.setTextAlignment(TextAlignment.CENTER);
        nuevaTabla.addRule();
        AT_Row fila2 = nuevaTabla.addRow(null,null,"Código", "Nombre", "Precio Base");
        fila2.setTextAlignment(TextAlignment.CENTER);
        nuevaTabla.addRule();
        for (int i = 0; i <productos.size() ; i++) {
                AT_Row fila = nuevaTabla.addRow(null,null,productos.get(i).getCode(),productos.get(i).getNombre(),productos.get(i).getPrecioBase());
                fila.setTextAlignment(TextAlignment.CENTER);
        }
        nuevaTabla.addRule();
        nuevaTabla.addRow("*","*","*","*","*");

        System.out.println(nuevaTabla.render(100));
    }
}
