package proyectoOptativa.tiendaCafe.dto;

import proyectoOptativa.tiendaCafe.model.LineaPedido;
import proyectoOptativa.tiendaCafe.model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class CarritoDTO {
    private Usuario usuario;
    private List<LineaPedido> lineaPedido = new ArrayList<>();

    public CarritoDTO() {}

    public CarritoDTO(Usuario usuario, List<LineaPedido> lineaPedido) {
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
