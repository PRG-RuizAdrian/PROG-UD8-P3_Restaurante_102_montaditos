package aruiz.tiposProducto;

import aruiz.Producto;
import aruiz.exceptions.DescuentoNoAplicableException;

public class Postre extends Producto {

    private TipoPostre tipoPostre;

    public Postre(String code, String nombre, String descripcion, double precioBase, TipoPostre tipoPostre ,int descuento, double iva) {
        super(code, nombre, descripcion, precioBase, iva, descuento, TipoMenu.POSTRE);
        if (descuento==0) {
            this.tipoPostre = tipoPostre;
        } else throw new DescuentoNoAplicableException();

    }
    public void getTipoPostre(){
        if (tipoPostre != TipoPostre.NINGUNO){
            System.out.println("APTO_" + tipoPostre);
        } else System.out.println("-");
    }


}
