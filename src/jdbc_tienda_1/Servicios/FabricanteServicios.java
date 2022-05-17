
package jdbc_tienda_1.Servicios;

import java.util.Collection;
import java.util.Scanner;
import jdbc_tienda_1.Entidades.Fabricante;
import jdbc_tienda_1.Persistencia.FabricanteDAO;

public class FabricanteServicios {
    private FabricanteDAO dao;
    private Scanner leer;
    public FabricanteServicios(){
        this.dao = new FabricanteDAO();
        this.leer = new Scanner(System.in);
    }
//------------------------------------------------------------------------------
    public void nuevoFabricante() throws Exception {
        try {
            Fabricante nuevo = new Fabricante();
            System.out.println("Introduzca el nombre del fabricante:");
            nuevo.setNombreF(leer.next());
            dao.guardarFabricante(nuevo);
            listaFabricante();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listaFabricante() throws Exception {
        try {
            Collection <Fabricante> lista = dao.listarFabricante();
            for (Fabricante fabricante : lista) {
                System.out.println("- "+fabricante);
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
