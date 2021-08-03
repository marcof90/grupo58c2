package model;

/**
 * Producto
 */
public class Producto {

    public final static String CIUDAD_BASE = "Barranquilla";
    public static final double PRECIO_BASE = 1200000;

    private String ciudad;
    private float valor;

    public Producto() {
        super();
        ciudad = CIUDAD_BASE;
        valor = (float) PRECIO_BASE;
    }

    public Producto(String ciudad) {
        super();
        this.ciudad = ciudad;
        valor = (float) PRECIO_BASE;
    }

    public String getCiudad() {
        return ciudad;
    }

    public float getValor() {
        return valor;
    }

    public void name() {
        Producto p1 = new Producto();
        System.out.println(p1.getCiudad());
        System.out.println(p1.getValor());

        Producto p2 = new Producto("Ibagué");

    }

}