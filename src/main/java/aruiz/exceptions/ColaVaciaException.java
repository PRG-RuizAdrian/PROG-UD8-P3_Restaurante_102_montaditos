package aruiz.exceptions;

public class ColaVaciaException extends RuntimeException {

    public ColaVaciaException(){
        super("Cola vacía");
    }
}
