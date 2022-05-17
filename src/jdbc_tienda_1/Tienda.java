
package jdbc_tienda_1;

import java.util.Scanner;
import jdbc_tienda_1.Servicios.FabricanteServicios;
import jdbc_tienda_1.Servicios.ProductoServicios;

public class Tienda {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int menu = 0;
        int codigo = -1;
        ProductoServicios consultarP = new ProductoServicios();
        FabricanteServicios consultarF = new FabricanteServicios();
        
        do {            
            System.out.println("MENU:");
            System.out.println("1: listar los nombres de la tabla producto");
            System.out.println("2: listar los nombres y los precios de todos los productos");
            System.out.println("3: listar productos con el precio enetre 120 y 202");
            System.out.println("4: listar los Portatiles de la tabla producto");
            System.out.println("5: listar el nombre y el precio del producto mas barato");
            System.out.println("6: agregar un producto a la base de datos");
            System.out.println("7: agregar un fabricante a la base de datos");
            System.out.println("8: editar un producto con datos a eleccion");
            System.out.println("9: salir del menu");
            menu = leer.nextInt();
            switch (menu) {
                case 1:
                    try {
                        consultarP.listarProductos();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    try {
                        consultarP.listarNombrePrecios();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    try {
                        consultarP.listarPrecioEntre();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    try {
                        consultarP.listarPorPalabra();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 5:
                    try {
                        consultarP.BuscarMenor();
                    } catch (Exception e) {
                        System.out.println(e);
                    }                   
                    break;
                case 6:
                    try {
                        consultarP.nuevoProducto();
                    } catch (Exception e) {
                        System.out.println(e);
                    }                   
                    break;
                case 7:
                    try {
                        consultarF.nuevoFabricante();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 8:
                    try {
                        consultarP.listarProductos();
                        System.out.println("Cual producto desea modificar? ingresar codigo");
                        codigo = leer.nextInt();
                        if (codigo > 0) {
                            consultarP.modificarProducto(codigo);  
                        } else {
                            System.out.println("No es valido el codigo");
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 9:
                    System.out.println("------------ Que tenga buen día! ------------");
                    break;
                default:
                    System.out.println("No es una opcion");
                    break;
            }
        } while (!(menu == 9));
    }   
}
