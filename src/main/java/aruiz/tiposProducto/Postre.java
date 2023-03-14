package aruiz.tiposProducto;

import aruiz.Producto;

public class Postre extends Producto {

    private TipoPostre tipoPostre;

    public Postre(String code, String nombre, String descripcion, double precioBase, TipoPostre tipoPostre ,int descuento, double iva) {
        super(code, nombre, descripcion, precioBase, iva, descuento, TipoMenu.POSTRE);
        this.tipoPostre = tipoPostre;

    }
    public void getTipoPostre(){
        if (tipoPostre != TipoPostre.NINGUNO){
            System.out.println("APTO_" + tipoPostre);
        } else System.out.println("-");
    }



}
