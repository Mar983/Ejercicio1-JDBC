
package jdbc_tienda_1.Entidades;

public class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private int codigo_Fabricante;
//------------------------------------------------------------------------------
    public Producto() {
    }
    public Producto(int codigo, String nombre, double precio, int codigo_Fabricante) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.codigo_Fabricante = codigo_Fabricante;
    }
//------------------------------------------------------------------------------
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getCodigo_Fabricante() {
        return codigo_Fabricante;
    }
    public void setCodigo_Fabricante(int codigo_Fabricante) {
        this.codigo_Fabricante = codigo_Fabricante;
    }
//------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Producto: {codigo: " + codigo + ", nombre: " + nombre + ", precio: " + precio + ", codigo fabricante: " + codigo_Fabricante + '}';
    }
}
