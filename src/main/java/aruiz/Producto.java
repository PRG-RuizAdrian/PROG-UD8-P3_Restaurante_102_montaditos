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
    private double pvp;

    public Producto(String code, String nombre, String descripcion, double precioBase, double iva, int descuento,  TipoMenu tipoMenu){
        this.code = code;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.descuento = descuento / 100;
        this.iva = iva;
        this.tipoMenu = tipoMenu;
        this.pvp = precioBase + (precioBase*descuento);
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

    public double getPvp(){
        return pvp;
    }
}
