package proyectoOptativa.tiendaCafe.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Producto {
    private Integer id;
    private String sku;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private String imagenUrl;
    private boolean activo;
    private boolean destacado;
    private LocalDate fechaCreacion;
    private Integer categoriaId;
    private TipoProducto tipoProducto;
    private Integer gramos;
    private String formato;

    public Producto() {}

    public Producto(Integer id, String sku, String nombre, String descripcion, BigDecimal precio, Integer stock, String imagenUrl, boolean activo, boolean destacado, LocalDate fechaCreacion, Integer categoriaId, TipoProducto tipoProducto, Integer gramos, String formato) {
        this.id = id;
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.imagenUrl = imagenUrl;
        this.activo = activo;
        this.destacado = destacado;
        this.fechaCreacion = fechaCreacion;
        this.categoriaId = categoriaId;
        this.tipoProducto = tipoProducto;
        this.gramos = gramos;
        this.formato = formato;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isDestacado() {
        return destacado;
    }

    public void setDestacado(boolean destacado) {
        this.destacado = destacado;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public Integer getGramos() {
        return gramos;
    }

    public void setGramos(Integer gramos) {
        this.gramos = gramos;
    }
    public String getFormato() {
        return formato;
    }
    public void setFormato(String formato) {
        this.formato = formato;
    }


}

