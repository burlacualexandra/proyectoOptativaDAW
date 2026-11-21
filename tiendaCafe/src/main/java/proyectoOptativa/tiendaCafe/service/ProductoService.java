package proyectoOptativa.tiendaCafe.service;

import org.springframework.stereotype.Service;
import proyectoOptativa.tiendaCafe.dto.ProductoCrearDTO;
import proyectoOptativa.tiendaCafe.model.Producto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {
    private final List<Producto> productos = new ArrayList<>();
    private int siguienteId = 1; //para que sea incremental


    //generamos un SKU unico - las tres primeras letras en mayúsculas, con lso gramos que tiene, si no tiene que ponga 0, y el id
    private String generarSku(ProductoCrearDTO dto, int id) {
        return String.format("CAF-%s-%d-%03d", dto.getTipoProducto().substring(0, 3).toUpperCase(),
                dto.getGramos() != null ? dto.getGramos() : 0, id);
    }

    // ver los detalles de un producto activo
   public Producto verDetallesProducto(Integer id) {
        Producto encontrado = buscarProductoPorId(id);
        if (encontrado == null) {
            return null;
        }
        if(!encontrado.isActivo()){
            return null;
        }
        return encontrado;

    }

    // ver prouctos destacados
    public List<Producto> verDestacados() {
        List<Producto> destacados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.isDestacado() && producto.isActivo()) {
                destacados.add(producto);
            }
        }
        return destacados;
    }

    // listamos todos los productos incluidos los retirados
    public List<Producto> listarTodosProductos() {
            return productos;
    }

    //Crear producto
    public Producto crearProducto(ProductoCrearDTO producto) {
        Producto productoNuevo = new Producto();
        productoNuevo.setSku(generarSku(producto, siguienteId));
        productoNuevo.setNombre(producto.getNombre());
        productoNuevo.setPrecio(producto.getPrecio());
        productoNuevo.setStock(producto.getStock());
        productoNuevo.setCategoriaId(producto.getCategoriaId());
        productoNuevo.setDescripcion(producto.getDescripcion());
        productoNuevo.setImagenUrl(producto.getImagenUrl());
        productoNuevo.setGramos(producto.getGramos());
        productoNuevo.setTipoProducto(producto.getTipoProducto());
        productoNuevo.setId(siguienteId++);
        productoNuevo.setActivo(true);
        productoNuevo.setFechaCreacion(LocalDate.now());
        productos.add(productoNuevo);
        return productoNuevo;
    }

    //buscar producto por ID
    public Producto buscarProductoPorId(Integer id) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    //Listamos los productos activos
    public List<Producto> listarProductos() {
        List<Producto> productosActivos = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.isActivo()) {
                productosActivos.add(producto);
            }
        }
        return productosActivos;
    }

    //actualizar productos
    public Producto actualizarProducto(Producto producto, Integer id) {
        Producto existe = buscarProductoPorId(id);
        if (existe == null) {
            return null;
        }
        existe.setDescripcion(producto.getDescripcion());
        existe.setPrecio(producto.getPrecio());
        existe.setStock(producto.getStock());
        existe.setImagenUrl(producto.getImagenUrl());
        existe.setTipoProducto(producto.getTipoProducto());
        existe.setActivo(producto.isActivo());
        existe.setGramos(producto.getGramos());

        return existe;
    }

    //retirar producto
    public boolean retirarProducto(Integer id) {
        Producto existe = buscarProductoPorId(id);
        if (existe == null) {
            return false;
        }
        existe.setActivo(false);
        return true;
    }

    // modificar stock
    public Integer modificarStock(Integer id, Integer cantidad) {
        Producto encontrado = buscarProductoPorId(id);
        if (encontrado == null || cantidad == 0) {
            return null;
        }
        int nuevoStock = encontrado.getStock() + cantidad;
        if(nuevoStock < 0){
            return null;
        }
        encontrado.setStock(nuevoStock);
        return encontrado.getStock();
    }

    // activar un producto retirado
    public boolean reactivarProducto(Integer id) {
        Producto encontrado = buscarProductoPorId(id);
        if(encontrado == null){
                return false;
            }
        encontrado.setActivo(true);
        return true;
    }
}

