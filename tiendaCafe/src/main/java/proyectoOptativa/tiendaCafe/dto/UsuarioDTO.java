package proyectoOptativa.tiendaCafe.dto;

import org.springframework.cglib.core.Local;
import proyectoOptativa.tiendaCafe.model.Rol;

import java.time.LocalDate;

public class UsuarioDTO {
    private Integer id;
    private String uid;
    private String nombre;
    private Rol rol;
    private LocalDate fechaAlta;

    public UsuarioDTO() {}

    public UsuarioDTO(Integer id, String uid, String nombre, Rol rol, LocalDate fechaAlta) {
        this.id = id;
        this.uid = uid;
        this.nombre = nombre;
        this.rol = rol;
        this.fechaAlta = fechaAlta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
