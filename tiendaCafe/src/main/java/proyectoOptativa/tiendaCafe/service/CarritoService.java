package proyectoOptativa.tiendaCafe.service;

import org.springframework.stereotype.Service;
import proyectoOptativa.tiendaCafe.model.Carrito;
import proyectoOptativa.tiendaCafe.model.LineaPedido;
import proyectoOptativa.tiendaCafe.model.Producto;
import proyectoOptativa.tiendaCafe.model.Usuario;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/*
@Service
public class CarritoService {
    private final ProductoService productoService;

    public CarritoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    private final List<Carrito> carrito = new ArrayList<>();


    // ver el carrito
    public List<Carrito> verCarrito() {
        return carrito;
    }

    // añadir un producto al carrito
    public Carrito añadirProductoCarrito(Usuario usuario, Integer productoId, Integer cantidad) {

        if(cantidad == null || cantidad <= 0){
            return null;
        }

        Carrito carritoEncontrado = null;
        Producto producto = productoService.buscarProductoPorId(productoId);

        if(producto == null){
            return null;
        }
        if(!producto.isActivo()){
            return null;
        }

        for(Carrito carrito : carrito) {
            if(carrito.getUsuario().getId().equals(usuario.getId())) {
                carritoEncontrado = carrito;
            }
        }

        if(carritoEncontrado == null) {
            carritoEncontrado = new Carrito(usuario, new ArrayList<>());
            carrito.add(carritoEncontrado);
        }

        for(LineaPedido lineaPedido : carritoEncontrado.getLineaPedido()) {
            if (lineaPedido.getProducto().getId().equals(producto.getId())) {
                if(lineaPedido.getCantidad() + cantidad > producto.getStock()) {
                    return null;
                }
                lineaPedido.setCantidad(lineaPedido.getCantidad() + cantidad);

                return carritoEncontrado;
            }
        }

            if(producto.getStock() < cantidad) {
                return null;
            }
            LineaPedido nuevoPedido = new LineaPedido(producto, producto.getNombre(), producto.getPrecio(), cantidad, producto.getPrecio().multiply(BigDecimal.valueOf(cantidad)));

            carritoEncontrado.getLineaPedido().add(nuevoPedido);
            return carritoEncontrado;
    }

    //cambiar la cantidad de una línea
    public Carrito modificarCantidad(Integer productoId, Integer cantidad, Usuario usuario) {
        if(cantidad == null || cantidad <= 0){
            return null;
        }

        Carrito carritoEncontrado = null;
        Producto producto = productoService.buscarProductoPorId(productoId);

        if(producto == null){
            return null;
        }
        if(!producto.isActivo()){
            return null;
        }

        for(Carrito carrito : carrito) {
            if(carrito.getUsuario().getId().equals(usuario.getId())) {
                carritoEncontrado = carrito;
                for(LineaPedido lineaPedido : carrito.getLineaPedido()) {
                    if(lineaPedido.getProducto().getId().equals(productoId)) {
                        if (cantidad > producto.getStock()) {
                            return null;
                        }
                    lineaPedido.setCantidad(cantidad);

                    }
                }
            }
        }
        return carritoEncontrado;
    }
}
*/