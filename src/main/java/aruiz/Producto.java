package aruiz;

public class Producto {

    private String code;
    private String nombre;
    private String descripcion;
    private double precioBase;
    private double descuento;
    private double iva;

    public Producto(String code, String nombre, String descripcion, double precioBase, double descuento, double iva){
        this.code = code;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.descuento = descuento;
        this.iva = iva;
    }




}
