package aruiz.exceptions;

public class DescuentoNoAplicableException extends RuntimeException{
    public DescuentoNoAplicableException(){
        super("Descuento no aplicable");
    };
}
