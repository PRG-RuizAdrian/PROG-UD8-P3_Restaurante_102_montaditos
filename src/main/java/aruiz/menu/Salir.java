package aruiz.menu;

public class Salir extends Opcion{
    public Salir(String titulo) {
        super(titulo);
    }

    @Override
    protected void setFinalizar(boolean finalizar) {
        super.setFinalizar(finalizar);
    }

    @Override
    public void ejecutar() {
        System.out.println("Hasta la próxima");
       setFinalizar(true);
    }
}
