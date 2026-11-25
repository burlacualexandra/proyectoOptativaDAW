package proyectoOptativa.tiendaCafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyectoOptativa.tiendaCafe.dto.CategoriaCrearDTO;
import proyectoOptativa.tiendaCafe.dto.CategoriaDTO;
import proyectoOptativa.tiendaCafe.service.CategoriaService;
import proyectoOptativa.tiendaCafe.service.ProductoService;

import java.util.List;
@RequestMapping("/api")
@RestController
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    private ProductoService productoService;

    public  CategoriaController(CategoriaService categoriaService, ProductoService productoService) {
        this.categoriaService = categoriaService;
        this.productoService = productoService;
    }
    // para listar las categorías
    @GetMapping("/categorias")
    public ResponseEntity<Object> listarCategorias() {
        List<CategoriaDTO> categorias = categoriaService.listar();
        return ResponseEntity.ok(categorias);
    }

    // para consultar una categoría
    @GetMapping("/categorias/{id}")
    public ResponseEntity<Object> getCategoria(@PathVariable Integer id) {
        CategoriaDTO categoria = categoriaService.verCategoria(id);
        if(categoria == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoria);
    }

    // para listar categorias (administración)
    @GetMapping("/admin/categorias")
    public ResponseEntity<Object> listarAdminCategorias() {
        return ResponseEntity.ok(categoriaService.listar());
    }

    // para crear una categoria
    @PostMapping("/admin/categorias")
    public ResponseEntity<Object> addCategoria(@RequestBody CategoriaCrearDTO categoria) {
        if (categoriaService.nombreExiste(categoria.getNombre(), null)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        CategoriaDTO categoriaNueva = categoriaService.crearCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaNueva);
    }

    // para modificar una categoria
    @PutMapping("/admin/categorias/{id}")
    public ResponseEntity<Object> modificarCategoria(@PathVariable Integer id,
                                                  @RequestBody CategoriaCrearDTO categoria) {
        if (categoriaService.verCategoria(id) == null) {
            return ResponseEntity.notFound().build();
        }
        if (categoriaService.nombreExiste(categoria.getNombre(), id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(categoriaService.actualizarCategoria(id, categoria));
    }

    // para eliminar una categoria sin productis
    @DeleteMapping("/admin/categorias/{id}")
    public ResponseEntity<Object> eliminarCategoria(@PathVariable Integer id) {
        if (categoriaService.verCategoria(id) == null) {
            return ResponseEntity.notFound().build();
        }
        if (productoService.hayProductoEnCategoria(id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        categoriaService.eliminarCategoria(id);
        return ResponseEntity.noContent().build();
    }


}
