package proyectoOptativa.tiendaCafe.model;

public class LineaCarrito {
    private Producto producto;
    private Integer cantidad;

    public LineaCarrito() {
    }

    public LineaCarrito(Integer cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
