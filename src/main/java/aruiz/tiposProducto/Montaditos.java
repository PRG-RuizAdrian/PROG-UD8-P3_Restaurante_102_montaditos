package aruiz.tiposProducto;

import aruiz.Producto;

import java.util.ArrayList;

public class Montaditos extends Producto {

    public Montaditos(String code, String nombre, String descripcion, double precioBase, int descuento, double iva) {
        super(code, nombre, descripcion, precioBase,  iva, descuento,TipoMenu.MONTADITOS);
    }
}
