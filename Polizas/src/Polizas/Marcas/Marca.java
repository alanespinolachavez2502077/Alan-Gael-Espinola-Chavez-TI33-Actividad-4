package Polizas.Marcas;

public class Marca {
    private int id;
    private String nombre;
    
    public Marca(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    
    @Override
    public String toString() {
        return this.nombre; 
    }
}