package aruiz;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Pedido {

    private String id;
    private String nombreCliente;
    private LocalDateTime fecha;
    private boolean servido;
    private ArrayList<Producto> productos;




    public Pedido(String id, String nombreCliente, LocalDateTime fecha){
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.productos = new ArrayList<>();
        this.id = id;
    }

    public void anyadirProducto(Producto producto){
        productos.add(producto);
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public String getNombreCliente(){
        return nombreCliente;
    }

    public String getFecha(){
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public void setServidoTrue(){
        this.servido = true;
    }

    public String getServido(){
        if (servido){
            return "Si";
        } else return "No";
    }

    public ArrayList<Producto> getProductos(){
        return productos;
    }

    public double getTotalPecioProductos(){
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPvp();
        }
        return total;
    }

}
