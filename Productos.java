

public class Productos {

    private int id;
    private String nombre;
    private double precio;
    private double abMonedero;

     

 
    public void setProducto(int id, String nombre, double precio, double abMonedero) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.abMonedero = abMonedero;

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public Double abMonedero() {
        return abMonedero;
    }

}
