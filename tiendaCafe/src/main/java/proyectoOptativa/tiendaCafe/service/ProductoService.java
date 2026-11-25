package proyectoOptativa.tiendaCafe.service;

import org.springframework.stereotype.Service;
import proyectoOptativa.tiendaCafe.dto.ProductoCrearDTO;
import proyectoOptativa.tiendaCafe.dto.ProductoFiltroDTO;
import proyectoOptativa.tiendaCafe.model.Producto;
import proyectoOptativa.tiendaCafe.model.TipoProducto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductoService {
    private final List<Producto> productos = new ArrayList<>();
    private final CategoriaService categoriaService;
    private int siguienteId = 1; //para que sea incremental

    public ProductoService(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
        anadirCafe("Brasil", "molido", "8.90", 50, true);
        anadirCafe("Brasil", "grano", "13.50", 40, true);
        anadirCafe("Brasil", "capsulas", "5.50", 90, false);

        anadirCafe("Sumatra", "molido", "9.90", 10, true);
        anadirCafe("Sumatra", "grano", "17.50", 90, false);
        anadirCafe("Sumatra", "capsulas", "5.50", 15, false);

        anadirCafe("Rwanda", "molido", "10.90", 30, true);
        anadirCafe("Rwanda", "grano", "12.50", 34, true);
        anadirCafe("Rwanda", "capsulas", "4.50", 20, false);

        anadirCafe("Colombia", "molido", "10.90", 30, true);
        anadirCafe("Colombia", "grano", "12.50", 34, true);
        anadirCafe("Colombia", "capsulas", "4.50", 20, false);
    }
    private void anadirCafe(String origen, String formato, String precio, Integer stock, Boolean destacado){
        Integer categoriaId;
        Integer gramos;
        String formatoText;

        switch (formato) {
            case "molido":
                categoriaId = 1;
                gramos = 250;
                formatoText = "molido";
                break;
            case "grano":
                categoriaId = 2;
                gramos = 500;
                formatoText = "grano";
                break;
            default:
                categoriaId = 3;
                gramos = 55;
                formatoText = "cápsula";
                break;
        }
        ProductoCrearDTO productoCrearDTO = new ProductoCrearDTO();
        productoCrearDTO.setNombre("Café " + origen + " " + formato);
        productoCrearDTO.setDescripcion("Café de origen " + origen + " " + formatoText);
        productoCrearDTO.setPrecio(new BigDecimal(precio));
        productoCrearDTO.setStock(stock);
        productoCrearDTO.setCategoriaId(categoriaId);
        productoCrearDTO.setImagenUrl("/img/cafe-" + origen.toLowerCase() +  "-" + formato + ".png");
        productoCrearDTO.setDestacado(destacado);
        productoCrearDTO.setGramos(gramos);
        productoCrearDTO.setTipoProducto(TipoProducto.CAFE);
        productoCrearDTO.setFormato(formato);
        crearProducto(productoCrearDTO);
    }


    //generamos un SKU unico - las tres primeras letras en mayúsculas, con lso gramos que tiene, si no tiene que ponga 0, y el id
    private String generarSku(ProductoCrearDTO dto, int id) {
        return String.format("%s-%d-%03d", dto.getTipoProducto().name().substring(0, 3).toUpperCase(),
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
            return new ArrayList<>(productos);
    }

    //Crear producto
    public Producto crearProducto(ProductoCrearDTO producto) {

        if(producto.getNombre() == null || producto.getNombre().isBlank()){
            return null;
        }

        if(producto.getTipoProducto() == null){
            return null;
        }
        if(producto.getCategoriaId() == null || !categoriaService.existeCategoria(producto.getCategoriaId())) {
            return null;
        }


        if(producto.getPrecio() == null || producto.getPrecio().compareTo(BigDecimal.ZERO) <= 0){
            return null;
        }
        if(producto.getStock() == null || producto.getStock() < 0){
            return null;
        }
        if(producto.getGramos() != null && producto.getGramos() <= 0){
            return null;
        }

        String skuNuevo = generarSku(producto, siguienteId);
        Producto productoNuevo = new Producto();

        productoNuevo.setSku(skuNuevo);
        productoNuevo.setNombre(producto.getNombre());
        productoNuevo.setPrecio(producto.getPrecio());
        productoNuevo.setStock(producto.getStock());
        productoNuevo.setCategoriaId(producto.getCategoriaId());
        productoNuevo.setDescripcion(producto.getDescripcion());
        productoNuevo.setImagenUrl(producto.getImagenUrl());
        productoNuevo.setGramos(producto.getGramos());
        productoNuevo.setTipoProducto(producto.getTipoProducto());
        productoNuevo.setFormato(producto.getFormato());
        productoNuevo.setId(siguienteId++);
        productoNuevo.setActivo(true);
        productoNuevo.setDestacado(producto.isDestacado());
        productoNuevo.setFechaCreacion(LocalDate.now());

        productos.add(productoNuevo);
        return productoNuevo;
    }

    //buscar producto por ID
    public Producto buscarProductoPorId(Integer id) {
        if(id == null){
            return null;
        }
        for (Producto producto : productos) {
            if(producto.getId().equals(id)){
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
    public Producto actualizarProducto(ProductoCrearDTO producto, Integer id) {
        Producto existe = verDetallesProducto(id);
        if (existe == null) {
            return null;
        }
        if(producto.getNombre() == null || producto.getNombre().isBlank()){
            return null;
        }
        if(producto.getTipoProducto() == null){
            return null;
        }
        if(producto.getCategoriaId() == null || !categoriaService.existeCategoria(producto.getCategoriaId())) {
            return null;
        }
        if(producto.getPrecio() == null || producto.getPrecio().compareTo(BigDecimal.ZERO) <= 0){
            return null;
        }
        if(producto.getStock() == null || producto.getStock() < 0){
            return null;
        }
        if(producto.getGramos() != null && producto.getGramos() <= 0){
            return null;
        }
        existe.setNombre(producto.getNombre());
        existe.setDescripcion(producto.getDescripcion());
        existe.setCategoriaId(producto.getCategoriaId());
        existe.setDestacado(producto.isDestacado());
        existe.setPrecio(producto.getPrecio());
        existe.setStock(producto.getStock());
        existe.setImagenUrl(producto.getImagenUrl());
        existe.setGramos(producto.getGramos());
        existe.setTipoProducto(producto.getTipoProducto());
        return existe;
    }

    //retirar producto
    public boolean retirarProducto(Integer id) {
        Producto existe = buscarProductoPorId(id);
        if (existe == null || !existe.isActivo()) {
            return false;
        }
        existe.setActivo(false);
        return true;
    }

    // modificar stock
    public Integer modificarStock(Integer id, Integer cantidad) {
        Producto encontrado = buscarProductoPorId(id);
        if (encontrado == null || cantidad == null || cantidad == 0 || !encontrado.isActivo()) {
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
        if(encontrado == null || encontrado.isActivo()){
                return false;
            }
        encontrado.setActivo(true);
        return true;
    }

    public boolean hayProductoEnCategoria(Integer categoriaId) {
        for (Producto producto : productos) {
            if(producto.getCategoriaId().equals(categoriaId)){
                return true;
            }
        }
        return false;
    }

    //filtros de busqueda
    public List<Producto> filtrarProductos(ProductoFiltroDTO productoFiltroDTO) {
            Comparator<Producto> comparador;
            switch(productoFiltroDTO.getOrden() == null ? "NOMBRE" : productoFiltroDTO.getOrden()){

            case "NOMBRE":
                comparador = Comparator.comparing(Producto::getNombre);
                break;
            case "PRECIO":
                comparador = Comparator.comparing(Producto::getPrecio);
                break;
            case "NOVEDAD":
                comparador = Comparator.comparing(Producto::getFechaCreacion);
                break;
            default:
                comparador = Comparator.comparing(Producto::getNombre);
            }

             if("DESC".equals(productoFiltroDTO.getDireccion())){

                comparador = comparador.reversed();
            }

            List<Producto> resultado = productos.stream()
                    .filter(producto -> productoFiltroDTO.getCategoriaId() == null || producto.getCategoriaId().equals(productoFiltroDTO.getCategoriaId()))
                    .filter(producto -> productoFiltroDTO.getQ() == null || producto.getNombre().toLowerCase().contains(productoFiltroDTO.getQ().toLowerCase()) || producto.getDescripcion().toLowerCase().contains(productoFiltroDTO.getQ().toLowerCase()))
                    .filter(producto -> productoFiltroDTO.getPrecioMin() == null || producto.getPrecio().compareTo(productoFiltroDTO.getPrecioMin()) >= 0)
                    .filter(producto -> productoFiltroDTO.getPrecioMax() == null || producto.getPrecio().compareTo(productoFiltroDTO.getPrecioMax()) <= 0)
                    .filter(producto -> productoFiltroDTO.getSoloDisponibles() == null || !productoFiltroDTO.getSoloDisponibles() || producto.getStock() > 0)
                    .filter(producto -> productoFiltroDTO.getFormato() == null || producto.getFormato().equalsIgnoreCase(productoFiltroDTO.getFormato()))

                    .sorted(comparador)
                    .toList();

        return resultado;


    }
}

