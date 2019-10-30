
/**
 *  Clase para probar el resto de clases
 *  
 */
public class TestPedido
{
    private Pedido pedido1; 
    private Pedido pedido2; 

    /**
     * Constructor  
     */
    public TestPedido()    {

        pedido1 = new Pedido(new Fecha(04, 9, 2019),new Cliente("Juan Soto", "Avda. Pio XII", "Pamplona", "Navarra"), new LineaPedido(new Producto("Rotulador fosforescente", 6.70), 20), new LineaPedido(new Producto("Memoria USB 64GB", 14.80), 10));

        pedido2 = new Pedido(new Fecha(8, 10, 2019),new Cliente("Elisa Nuin", "C/ Rio Alzania 7", "Pamplona", "Navarra"), new LineaPedido(new Producto("Sacapuntas manual", 16.64), 8), new LineaPedido(new Producto("Corrector tippex", 5.99), 20)); 

    }

    /**
     * Muestra la información de los dos pedidos (ver enunciado)
     */
    public void mostrarPedidos() {
        System.out.println();
        System.out.println("FECHA PEDIDO: " + pedido1.getFecha() +" \nDATOS DEL CLIENTE" +
            pedido1.getCliente() + "\n**** Articulos en el pedido****\n" + pedido1.getPedidoActual() +
            "\n");
        if(pedido1.masAntiguoQue(pedido2)==true){
            System.out.println("El pedido 1 se ha realizado antes que el pedido 2");
        } else {
            System.out.println("El pedido 2 se ha realizado antes que el pedido1");

        }
        System.out.println(pedido2);
    }
}
