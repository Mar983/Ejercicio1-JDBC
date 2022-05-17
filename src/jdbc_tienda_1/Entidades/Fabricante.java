
package jdbc_tienda_1.Entidades;

public class Fabricante {
    private int codigoF;
    private String nombreF;
//------------------------------------------------------------------------------
    public Fabricante() {
    }
    public Fabricante(int codigoF, String nombreF) {
        this.codigoF = codigoF;
        this.nombreF = nombreF;
    }
//------------------------------------------------------------------------------
    public int getCodigoF() {
        return codigoF;
    }
    public void setCodigoF(int codigoF) {
        this.codigoF = codigoF;
    }
    public String getNombreF() {
        return nombreF;
    }
    public void setNombreF(String nombreF) {
        this.nombreF = nombreF;
    }
//------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Fabricante: {codigoF: " + codigoF + ", nombreF: " + nombreF + '}';
    }
}
