package proyectoOptativa.tiendaCafe.model;

import javax.imageio.plugins.tiff.TIFFDirectory;

public class Categoria {
    private Integer id;
    private String nombre;
    private String descripcion;
    private TipoProducto tipoProducto;

    public Categoria() {
    }

    public Categoria(Integer id, String nombre, String descripcion, TipoProducto tipoProducto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoProducto = tipoProducto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
