package proyectoOptativa.tiendaCafe.dto;

public class StockDTO {
    private String nombre;
    private Integer id;
    private Integer stock;

    public StockDTO() {
    }

    public StockDTO(Integer stock, Integer id, String nombre) {
        this.stock = stock;
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer Stock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
