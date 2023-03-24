package aruiz.exceptions;

public class NoEncontradoException extends Exception{

    public NoEncontradoException(){
        super();
    }

    public String toString(){
        return "El código del producto introducido no existe";
    }

}
