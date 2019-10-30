
/**
 * Modela un pedido realizado por un cliente en una determinada fecha
 * El pedido incluye dos líneas de pedido que describen a cada uno de los dos
 * productos comprados en el pedido
 */
public class Pedido
{
    private final double IVA = 0.21;  // iva a aplicar
    private Fecha fecha;
    private Cliente cliente;
    private LineaPedido linea1;
    private LineaPedido linea2;

    /**
     * Constructor  
     */
    public Pedido(Fecha queFecha, Cliente queCliente, LineaPedido queLinea1, LineaPedido queLinea2)    {
        fecha = queFecha;
        cliente = queCliente;
        linea1 = queLinea1;
        linea2 = queLinea2;
    }

    /**
     * accesor para la fecha del pedido
     */
    public Fecha getFecha() {
        return fecha;
    }

    /**
     * accesor para el cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * calcular y devolver el importe total del pedido sin Iva
     */
    public double getImporteAntesIva() {
        double importeAntesIvaLinea1 = linea1.getCantidad() * linea1.getProducto().getPrecio();
        double importeAntesIvaLinea2 = linea2.getCantidad() * linea2.getProducto().getPrecio() ;
        return importeAntesIvaLinea1 + importeAntesIvaLinea2;

    }

    /**
     * calcular y devolver el iva a aplicar
     */
    public double getIva() {
        double iva = getImporteTotal() * IVA;
        return iva;
    }

    /**
     * calcular y devolver el importe total del pedido con Iva
     */
    public double getImporteTotal() {
        double iva = getImporteAntesIva() * IVA;
        double total = (getImporteAntesIva() + iva) + getImporteAntesIva();
        return total;
    }

    /**
     * Representación textual del pedido
     * (ver enunciado)
     */
    public String toString() {
        String importeFormateado = String.format("%20s %8.2s %20s %8.2s %20s %8.2s", "IMPORTE CON IVA" , getImporteAntesIva(), "\nIVA" , getIva(), "\nIMPORTE TOTAL", getImporteTotal());
        return importeFormateado;
    }

    /**
     * devuelve true si el pedido actual es más antiguo que el recibido 
     * como parámetro
     */
    public boolean masAntiguoQue(Pedido otro) {
        Pedido segundoPedido = otro;
        if(fecha.antesQue(segundoPedido.fecha)){
            return true;
        } else {
            return false;
        }

    }

    /**
     * devuelve una referencia al pedido actual
     */
    public Pedido getPedidoActual() {
        Pedido valorPedidoActual = new Pedido(fecha,cliente,linea1,linea2);
        return valorPedidoActual;
    }

}
