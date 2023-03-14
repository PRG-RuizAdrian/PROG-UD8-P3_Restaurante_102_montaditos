package aruiz.tiposProducto;

import aruiz.Producto;

public class Bebida extends Producto {

    private boolean rellenable;
    private TipoBebida tipoBebida;


    public Bebida(String code, String nombre, String descripcion,  TipoBebida tipoBebida, boolean rellenable, double precioBase, int descuento, double iva ) {
        super(code, nombre, descripcion, precioBase, iva, descuento,  TipoMenu.BEBIDA);
        this.rellenable = rellenable;

        this.tipoBebida = tipoBebida;
    }

    public String getRellenable(){
        if(rellenable){
            return "Si";
        }else return "No";
    }

    public String getTipo(){
        if (tipoBebida == TipoBebida.PEQUE){
            return "pequeño";
        } else return tipoBebida.toString().toLowerCase();
    }



}
