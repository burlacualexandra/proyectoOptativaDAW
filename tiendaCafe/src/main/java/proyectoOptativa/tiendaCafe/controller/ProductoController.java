package proyectoOptativa.tiendaCafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyectoOptativa.tiendaCafe.dto.ProductoCrearDTO;
import proyectoOptativa.tiendaCafe.dto.ProductoFiltroDTO;
import proyectoOptativa.tiendaCafe.model.Producto;
import proyectoOptativa.tiendaCafe.service.ProductoService;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    //con filtros
    @GetMapping("/api/productos")
    public ResponseEntity<List<Producto>> verProductos(@RequestParam(required = false) Integer categoriaId, @RequestParam(required = false) String q,
                                                       @RequestParam(required = false) BigDecimal precioMin, @RequestParam(required = false) BigDecimal precioMax,
                                                       @RequestParam(required = false) Boolean soloDisponibles, @RequestParam(required = false) String formato,
                                                       @RequestParam(required = false) String orden, @RequestParam(required = false ) String direccion) {

        ProductoFiltroDTO productoFiltroDTO = new ProductoFiltroDTO();
        productoFiltroDTO.setCategoriaId(categoriaId);
        productoFiltroDTO.setQ(q);
        productoFiltroDTO.setPrecioMin(precioMin);
        productoFiltroDTO.setPrecioMax(precioMax);
        productoFiltroDTO.setSoloDisponibles(soloDisponibles);
        productoFiltroDTO.setFormato(formato);
        productoFiltroDTO.setOrden(orden);
        productoFiltroDTO.setDireccion(direccion);

        List<Producto>productosFiltrados = productoService.filtrarProductos(productoFiltroDTO);
        return ResponseEntity.ok(productosFiltrados);
    }

    // ver detalles de un producto activo
    @GetMapping("/api/productos/{id}")
    public ResponseEntity<Object> verDetallesProductos(@PathVariable Integer id){
        Producto producto = productoService.verDetallesProducto(id);
        if(producto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }

    //ver productos activos destacados
    @GetMapping("/api/productos/destacados")
    public ResponseEntity<Object> verDestacadosActivos(){
        List<Producto> productos = productoService.verDestacados();
        return ResponseEntity.ok(productos);
    }

    //listar todos los  productos
    @GetMapping("/api/admin/productos")
    public ResponseEntity<Object> listarTodosProductos(){
        List<Producto> productos = productoService.listarTodosProductos();
        return ResponseEntity.ok(productos);
    }

    //crear un producto
    @PostMapping("/api/admin/productos")
    public ResponseEntity<Object> crearProducto(@RequestBody ProductoCrearDTO producto){
        Producto productoNuevo = productoService.crearProducto(producto);
        if(productoNuevo == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    }

    //modificar un producto
    @PutMapping("/api/admin/productos/{id}")
    public ResponseEntity<Object> modificarProducto(@PathVariable int id,
                                                    @RequestBody ProductoCrearDTO producto){

        Producto existe =  productoService.verDetallesProducto(id);
        if(existe == null){ //kitar cuando tengamos excepciones
            return ResponseEntity.notFound().build();
        }
        Producto productoActualizado = productoService.actualizarProducto(producto, id);

        if(productoActualizado == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(productoActualizado);
    }

    //borrar un producto
    @DeleteMapping("/api/admin/productos/{id}")
    public ResponseEntity<Object> eliminarProducto(@PathVariable int id){
        Boolean productoRetirado = productoService.retirarProducto(id);
        if(!productoRetirado){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    //sumar o restar un stock
    @PutMapping("/api/admin/productos/{id}/stock")
    public ResponseEntity<Object> actualizarStockProducto(@PathVariable int id, @RequestBody Integer cantidad){
        Producto producto = productoService.buscarProductoPorId(id);
        if(producto == null){
            return ResponseEntity.notFound().build();
        }

        Integer stockActualizado = productoService.modificarStock(id, cantidad);
        if(stockActualizado == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(stockActualizado);
    }

    // reactivar un producto
    @PutMapping("/api/admin/productos/{id}/reactivar")
    public ResponseEntity<Object> reactivarProducto(@PathVariable int id){
        Boolean reactivarProducto = productoService.reactivarProducto(id);
        if(!reactivarProducto){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reactivarProducto);
    }
}
