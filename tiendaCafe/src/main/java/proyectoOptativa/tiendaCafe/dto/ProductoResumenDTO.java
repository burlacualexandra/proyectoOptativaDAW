package proyectoOptativa.tiendaCafe.dto;

import java.math.BigDecimal;

public class ProductoResumenDTO {
    private Integer id;
    private String  sku;
    private String nombre;
    private BigDecimal precio;
    private String imagenUrl;
    private boolean destacado;
    private  Integer categoriaId;

    public ProductoResumenDTO() {}

    public ProductoResumenDTO(Integer id, String sku, String nombre, BigDecimal precio, String imagenUrl, boolean destacado, Integer categoriaId) {
        this.id = id;
        this.sku = sku;
        this.nombre = nombre;
        this.precio = precio;
        this.imagenUrl = imagenUrl;
        this.destacado = destacado;
        this.categoriaId = categoriaId;
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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
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

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }
}
