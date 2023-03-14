package aruiz;

import aruiz.tiposProducto.TipoMenu;

public class Producto {

    private String code;
    private String nombre;
    private String descripcion;
    private double precioBase;
    private int descuento;
    private double iva;
    private TipoMenu tipoMenu;

    public Producto(String code, String nombre, String descripcion, double precioBase, double iva, int descuento,  TipoMenu tipoMenu){
        this.code = code;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.descuento = descuento;
        this.iva = iva;
        this.tipoMenu = tipoMenu;
    }


    public TipoMenu getTipoMenu(){
        return this.tipoMenu;
    }

    public String getCode(){
        return this.code;
    }

    public String getNombre(){
        return this.nombre;
    }

    public Double getPrecioBase(){
        return this.precioBase;
    }

    public int getDescuento(){
        return this.descuento;
    }

}
