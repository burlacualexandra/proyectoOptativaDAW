package proyectoOptativa.tiendaCafe.model;

import java.math.BigDecimal;

public class LineaPedido {
    private Producto producto;
    private String nombreProducto;
    private BigDecimal precioUnitario;
    private Integer cantidad;
    private BigDecimal subtotal;

    public LineaPedido() {}

    public LineaPedido(Producto producto, String nombreProducto, BigDecimal precioUnitario, Integer cantidad, BigDecimal subtotal) {
        this.producto = producto;
        this.nombreProducto = producto.getNombre();
        this.precioUnitario = producto.getPrecio();
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return precioUnitario.multiply(BigDecimal.valueOf(cantidad));
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
