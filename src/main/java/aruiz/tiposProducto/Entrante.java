package aruiz.tiposProducto;

import aruiz.Producto;

public class Entrante extends Producto {

    private int raciones;

    public Entrante(String code, String nombre, String descripcion, int raciones, double precioBase, int descuento, double iva ) {
        super(code, nombre, descripcion, precioBase, iva, descuento, TipoMenu.ENTRANTES);
        this.raciones = raciones;
    }

    public int getRaciones(){
        return raciones;
    }



}
