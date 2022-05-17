
package jdbc_tienda_1.Persistencia;

import java.util.ArrayList;
import java.util.Collection;
import jdbc_tienda_1.Entidades.Producto;

public final class ProductoDAO extends DAO {
    
    public ProductoDAO() {
        
    }
//------------------------------------------------------------------------------
//LISTAR:
    public Collection <Producto> listarNombreProducto() throws Exception {
        try {
            String sql = "SELECT * FROM producto;";
            consultarBase(sql);
            Producto nombre = null;
            ArrayList <Producto> listaNombre = new ArrayList();
            while (resultado.next()) {
                nombre = new Producto();
                nombre.setCodigo(resultado.getInt(1));
                nombre.setNombre(resultado.getString(2));
                nombre.setPrecio(resultado.getDouble(3));
                nombre.setCodigo_Fabricante(resultado.getInt(4));
                listaNombre.add(nombre);
            }
            desconectarBase();
            return listaNombre;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception(e);
        }
    }
    
    public Collection <Producto> listarPrecioProducto() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto ORDER BY precio;"; 
            consultarBase(sql);
            Producto precio = null;
            Collection <Producto> listaPrecio = new ArrayList();
            while (resultado.next()) {
                precio = new Producto();
                precio.setNombre(resultado.getString(1));
                precio.setPrecio(resultado.getDouble(2));
                listaPrecio.add(precio);
            }
            desconectarBase();
            return listaPrecio;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("ERROR del sistema");
        }
    }
    
    public Collection <Producto> listarPrecioEspecifico() throws Exception{
        try {
            String sql = "SELECT * FROM producto WHERE precio BETWEEN 120 AND 202;";
            consultarBase(sql);
            Producto precio = null;
            Collection <Producto> precios = new ArrayList();
            while (resultado.next()) {
                precio = new Producto();
                precio.setCodigo(resultado.getInt(1));
                precio.setNombre(resultado.getString(2));
                precio.setPrecio(resultado.getDouble(3));
                precio.setCodigo_Fabricante(resultado.getInt(4));              
                precios.add(precio);
            }
            desconectarBase();
            return precios;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("ERROR del sistema");
        }
    }
    
    public Collection <Producto> listarPorPalabra() throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE nombre LIKE 'Portátil%';"; 
            consultarBase(sql);
            Producto palabra = null;
            Collection <Producto> palabras = new ArrayList();
            while (resultado.next()) {
                palabra = new Producto();
                palabra.setCodigo(resultado.getInt(1));
                palabra.setNombre(resultado.getString(2));
                palabra.setPrecio(resultado.getDouble(3));
                palabra.setCodigo_Fabricante(resultado.getInt(4));
                palabras.add(palabra);
            }
            desconectarBase();
            return palabras;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("ERROR del sistema");
        }
    }
    
    public Producto listarPrecioMasBarato() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto ORDER BY precio LIMIT 1;";
            consultarBase(sql);
            Producto minimo = null;
            while (resultado.next()) {
                minimo = new Producto();
                minimo.setNombre(resultado.getString(1));
                minimo.setPrecio(resultado.getDouble(2));
            }
            desconectarBase();
            return minimo;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }    
//------------------------------------------------------------------------------
// INGRESAR, EDITAR, ELIMINAR:
    public void guardarProducto(Producto nuevo) throws Exception {
        try {
            String sql = "INSERT INTO producto (nombre, precio, codigo_fabricante) "
                   + "VALUES ( '" + nuevo.getNombre() + "' , '" + nuevo.getPrecio() + "' , '" + nuevo.getCodigo_Fabricante() + "');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public void modificarProducto(Producto modificar) throws Exception {
        try {
            String sql = "UPDATE producto SET "
                    + "nombre = '" + modificar.getNombre() + "' , precio = '" + modificar.getPrecio() + "' , codigo_fabricante = '" + modificar.getCodigo_Fabricante()
                    + "' WHERE codigo = '" + modificar.getCodigo() + "';";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
}
