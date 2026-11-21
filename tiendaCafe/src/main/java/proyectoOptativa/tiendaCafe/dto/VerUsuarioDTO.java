package proyectoOptativa.tiendaCafe.dto;

import java.time.LocalDate;

public class VerUsuarioDTO {
    private String email;
    private String nombre;
    private String direccionEnvio;
    private LocalDate fechaAlta;

    public VerUsuarioDTO() {
    }

    public VerUsuarioDTO(String email, String nombre, String direccionEnvio, LocalDate fechaAlta) {
        this.email = email;
        this.nombre = nombre;
        this.direccionEnvio = direccionEnvio;
        this.fechaAlta = fechaAlta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
