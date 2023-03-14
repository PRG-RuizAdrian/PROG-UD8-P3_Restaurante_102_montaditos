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
        for (Producto producto : productos) {
            AT_Row fila = nuevaTabla.addRow(null, null, producto.getCode(), producto.getNombre(), producto.getPrecioBase()+"€");
            fila.setTextAlignment(TextAlignment.CENTER);
        }
        nuevaTabla.addRule();
        nuevaTabla.addRow("*","*","*","*","*");

        System.out.println(nuevaTabla.render(100));
    }
}
