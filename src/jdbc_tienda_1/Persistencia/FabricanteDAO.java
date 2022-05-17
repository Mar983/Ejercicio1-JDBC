
package jdbc_tienda_1.Persistencia;

import java.util.ArrayList;
import java.util.Collection;
import jdbc_tienda_1.Entidades.Fabricante;

public final class FabricanteDAO extends DAO{
    
    public void guardarFabricante(Fabricante nuevo) throws Exception {
        try {
            String sql = "INSERT INTO fabricante (nombre)"
                    + "VALUES ('" + nuevo.getNombreF() + "');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public Collection <Fabricante> listarFabricante() throws Exception {
        try {
            String sql = "SELECT * FROM fabricante;";
            consultarBase(sql);
            Fabricante fabricante = null;
            Collection <Fabricante> listaFabricante = new ArrayList();
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigoF(resultado.getInt(1));
                fabricante.setNombreF(resultado.getString(2));
                listaFabricante.add(fabricante);
            }
            desconectarBase();
            return listaFabricante;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception ("ERROR del sistema");
        }
    } 
}
