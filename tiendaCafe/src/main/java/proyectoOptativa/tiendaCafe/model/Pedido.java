package proyectoOptativa.tiendaCafe.model;

import javax.sound.sampled.Line;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Integer id;
    private String codigo;
    private Usuario usuario;
    private LocalDate fecha;
    private EstadoPedido estadoPedido;
    private String direccionEnvio;
    private BigDecimal subtotal;
    private BigDecimal gastosEnvios;
    private BigDecimal total;
    private List<LineaPedido> lineaPedido = new ArrayList<>();

    public Pedido() {}

    public Pedido(Integer id, String codigo, Usuario usuario, LocalDate fecha, EstadoPedido estadoPedido, String direccionEnvio, BigDecimal subtotal, BigDecimal gastosEnvios, BigDecimal total, List<LineaPedido> lineaPedido) {
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

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getGastosEnvios() {
        return gastosEnvios;
    }

    public void setGastosEnvios(BigDecimal gastosEnvios) {
        this.gastosEnvios = gastosEnvios;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<LineaPedido> getLineaPedido() {
        return lineaPedido;
    }

    public void setLineaPedido(List<LineaPedido> lineaPedido) {
        this.lineaPedido = lineaPedido;
    }
}



