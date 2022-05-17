
package jdbc_tienda_1.Servicios;

import java.util.Collection;
import java.util.Scanner;
import jdbc_tienda_1.Entidades.Producto;
import jdbc_tienda_1.Persistencia.ProductoDAO;

public class ProductoServicios {
    private ProductoDAO dao;
    private Scanner leer;
    public ProductoServicios() {
        this.dao = new ProductoDAO();
        this.leer = new Scanner(System.in);
    }
//------------------------------------------------------------------------------
    //a - TAREAS: colocar los IF y mandar STRING e INT por parametros
    public void listarProductos() throws Exception {
        try {
            Collection <Producto> productos = dao.listarNombreProducto();
            for (Producto producto : productos) {
                System.out.println("- "+producto);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    //b
    public void listarNombrePrecios() throws Exception {
        try {
            Collection <Producto> nombrePrecio = dao.listarPrecioProducto();
            for (Producto producto : nombrePrecio) {
                System.out.println("PRODUCTO: "+producto.getNombre() + " - PRECIO: $"+producto.getPrecio());
            }
        } catch (Exception e) {
            throw e;
        }
    }
    //c
    public void listarPrecioEntre() throws Exception {
        try {
            Collection <Producto> precioEntre = dao.listarPrecioEspecifico();
            for (Producto x : precioEntre) {
                System.out.println("CODIGO: "+x.getCodigo()+" - PRODUCTO: "+x.getNombre()+" - PRECIO: "+x.getPrecio()+" - C.FABRICANTE: "+x.getCodigo_Fabricante());
            }
        } catch (Exception e) {
            throw e;
        }
    }
    //d
    public void listarPorPalabra() throws Exception {
        try {
            Collection <Producto> porPalabra = dao.listarPorPalabra();
            for (Producto x : porPalabra) {
                System.out.println("CODIGO: "+x.getCodigo()+" - PRODUCTO: "+x.getNombre()+" - PRECIO: "+x.getPrecio()+" - C.FABRICANTE: "+x.getCodigo_Fabricante());
            }
        } catch (Exception e) {
            throw e;
        }
    }
    //e
    public void BuscarMenor() throws Exception {
        try {
            Producto menor = dao.listarPrecioMasBarato();
            System.out.print("El producto mas barato es: "+menor.getNombre()+" - PRECIO $: "+menor.getPrecio());
            System.out.println("");
        } catch (Exception e) {
            throw e;
        }
    }
    //f
    public void nuevoProducto() throws Exception {       
        try {
            Producto nuevo = new Producto();
            System.out.println("Introduzca el nombre del producto:");
            nuevo.setNombre(leer.next());
            System.out.println("Introduzca el precio del producto:");
            nuevo.setPrecio(leer.nextInt());
            System.out.println("Introduzca el codigo de fabricante del producto:");
            nuevo.setCodigo_Fabricante(leer.nextInt());
            dao.guardarProducto(nuevo);
            listarProductos();
        } catch (Exception e) {
            throw e;
        }
    }
    //h
    public void modificarProducto(int codigo) throws Exception {
        try {
            Producto modificar = new Producto();
            modificar.setCodigo(codigo);
            System.out.println("Introduzca el nuevo nombre del producto:");
            modificar.setNombre(leer.next());
            System.out.println("Introduzca su precio:");
            modificar.setPrecio(leer.nextInt());
            System.out.println("Introduzca el codigo de fabricante del nuevo producto:");
            modificar.setCodigo_Fabricante(leer.nextInt());
            dao.modificarProducto(modificar);
            listarProductos();
        } catch (Exception e) {
            throw e;
        }
    }
}
