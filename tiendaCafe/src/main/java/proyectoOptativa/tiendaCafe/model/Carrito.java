package proyectoOptativa.tiendaCafe.model;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private Usuario usuario;
    private List<LineaPedido> lineaPedido = new ArrayList<>();

    public Carrito() {
    }

    public Carrito(Usuario usuario, List<LineaPedido> lineaPedido) {
        this.usuario = usuario;
        this.lineaPedido = lineaPedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<LineaPedido> getLineaPedido() {
        return lineaPedido;
    }

    public void setLineaPedido(List<LineaPedido> lineaPedido) {
        this.lineaPedido = lineaPedido;
    }
}
