package proyectoOptativa.tiendaCafe.dto;

import proyectoOptativa.tiendaCafe.model.EstadoPedido;
import proyectoOptativa.tiendaCafe.model.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoDTO {
    private Integer id;
    private String sku;
    private String nombre;
    private Usuario usuario;
    private String direccion;
    private Integer cantidad;
    private BigDecimal precioTotal;
    private BigDecimal gastosEnvio;
    private BigDecimal subtotal;
    private LocalDate fecha;
    private String codigo;

    public PedidoDTO() {}

    public PedidoDTO(Integer id, String sku, String nombre, Usuario usuario, String direccion, Integer cantidad, BigDecimal precioTotal, BigDecimal gastosEnvio, BigDecimal subtotal, LocalDate fecha, String codigo) {
        this.id = id;
        this.sku = sku;
        this.nombre = nombre;
        this.usuario = usuario;
        this.direccion = direccion;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
        this.gastosEnvio = gastosEnvio;
        this.subtotal = subtotal;
        this.fecha = fecha;
        this.codigo = codigo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public BigDecimal getGastosEnvio() {
        return gastosEnvio;
    }

    public void setGastosEnvio(BigDecimal gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
