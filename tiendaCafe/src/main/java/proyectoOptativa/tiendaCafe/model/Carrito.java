package proyectoOptativa.tiendaCafe.model;

public class Carrito {
    private Usuario usuario;
    private LineaPedido lineaPedido;

    public Carrito() {
    }

    public Carrito(Usuario usuario, LineaPedido lineaPedido) {
        this.usuario = usuario;
        this.lineaPedido = lineaPedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LineaPedido getLineas() {
        return lineaPedido;
    }

    public void setLineas(LineaPedido lineaPedido) {
        this.lineaPedido = lineaPedido;
    }
}
