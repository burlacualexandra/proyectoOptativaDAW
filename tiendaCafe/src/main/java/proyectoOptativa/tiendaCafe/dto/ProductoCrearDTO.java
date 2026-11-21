package proyectoOptativa.tiendaCafe.dto;

import java.math.BigDecimal;

public class ProductoCrearDTO {
    private String sku;
    private String nombre;
    private BigDecimal precio;
    private Integer stock;
    private Integer categoriaId;
    private String descripcion;
    private String imagenUrl;
    private boolean destacado;
    private Integer gramos;
    private String tipo;

    public ProductoCrearDTO(){}

    public ProductoCrearDTO(String sku, String nombre, BigDecimal precio, Integer stock, Integer categoriaId, String descripcion, String imagenUrl, boolean destacado, Integer gramos, String tipo) {
        this.sku = sku;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoriaId = categoriaId;
        this.descripcion = descripcion;
        this.imagenUrl = imagenUrl;
        this.destacado = destacado;
        this.gramos = gramos;
        this.tipo = tipo;
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

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public boolean isDestacado() {
        return destacado;
    }

    public void setDestacado(boolean destacado) {
        this.destacado = destacado;
    }

    public Integer getGramos() {
        return gramos;
    }

    public void setGramos(Integer gramos) {
        this.gramos= gramos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
