package proyectoOptativa.tiendaCafe.dto;

import proyectoOptativa.tiendaCafe.model.EstadoPedido;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VerPedidoDTO {
    private String codigo;
    private LocalDate fecha;
    private String sku;
    private Integer cantidad;
    private String nombre;
    private String descripcion;
    private BigDecimal total;
    private BigDecimal subtotal;
    private BigDecimal gastosEnvio;
    private EstadoPedido estadoPedido;

    public VerPedidoDTO() {
    }

    public VerPedidoDTO(String codigo, LocalDate fecha, String sku, Integer cantidad, String nombre, String descripcion, BigDecimal total, BigDecimal subtotal, BigDecimal gastosEnvio, EstadoPedido estadoPedido) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.sku = sku;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.total = total;
        this.subtotal = subtotal;
        this.gastosEnvio = gastosEnvio;
        this.estadoPedido = estadoPedido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getGastosEnvio() {
        return gastosEnvio;
    }

    public void setGastosEnvio(BigDecimal gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
}
