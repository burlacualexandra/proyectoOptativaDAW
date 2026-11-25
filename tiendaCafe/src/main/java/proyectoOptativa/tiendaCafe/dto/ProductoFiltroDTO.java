package proyectoOptativa.tiendaCafe.dto;

import java.math.BigDecimal;

public class ProductoFiltroDTO {
    private Integer categoriaId;
    private String q;
    private BigDecimal precioMin;
    private BigDecimal precioMax;
    private Boolean soloDisponibles;
    private String orden;
    private String direccion;
    private String formato;

    public ProductoFiltroDTO() {}

    public ProductoFiltroDTO(Integer categoriaId, String q, BigDecimal precioMin, BigDecimal precioMax, Boolean soloDisponibles, String orden, String direccion, String formato) {
        this.categoriaId = categoriaId;
        this.q = q;
        this.precioMin = precioMin;
        this.precioMax = precioMax;
        this.soloDisponibles = soloDisponibles;
        this.orden = orden;
        this.direccion = direccion;
        this.formato = formato;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public BigDecimal getPrecioMin() {
        return precioMin;
    }

    public void setPrecioMin(BigDecimal precioMin) {
        this.precioMin = precioMin;
    }

    public BigDecimal getPrecioMax() {
        return precioMax;
    }

    public void setPrecioMax(BigDecimal precioMax) {
        this.precioMax = precioMax;
    }

    public Boolean getSoloDisponibles() {
        return soloDisponibles;
    }

    public void setSoloDisponibles(Boolean soloDisponibles) {
        this.soloDisponibles = soloDisponibles;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}
