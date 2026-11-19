package proyectoOptativa.tiendaCafe.model;

import java.time.LocalDate;

public class Pedido {
    private Integer id;
    private String codigo;
    private Usuario usuario;
    private LocalDate fecha;
    private EstadoPedido estadoPedido;
    private String direccionEnvio;
    private Double subtotal;
    private Double gastosEnvios;
    private Double total;
    private LineaPedido lineaPedido;

    public Pedido() {}

    public Pedido(Integer id, String codigo, Usuario usuario, LocalDate fecha, EstadoPedido estadoPedido, String direccionEnvio, Double subtotal, Double gastosEnvios, Double total, LineaPedido lineaPedido) {
        this.id = id;
        this.codigo = codigo;
        this.usuario = usuario;
        this.fecha = fecha;
        this.estadoPedido = estadoPedido;
        this.direccionEnvio = direccionEnvio;
        this.subtotal = subtotal;
        this.gastosEnvios = gastosEnvios;
        this.total = total;
        this.lineaPedido = lineaPedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getGastosEnvios() {
        return gastosEnvios;
    }

    public void setGastosEnvios(Double gastosEnvios) {
        this.gastosEnvios = gastosEnvios;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LineaPedido getLineaPedido() {
        return lineaPedido;
    }

    public void setLineaPedido(LineaPedido lineaPedido) {
        this.lineaPedido = lineaPedido;
    }
}



