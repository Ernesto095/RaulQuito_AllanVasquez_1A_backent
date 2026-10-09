package SystemITR.JosueGuinea1A.Clientes.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClienteDTO {

    @NotBlank(message = "Nombre obligatorio")
    private String nombre;

    @NotBlank(message = "Nombre obligatorio")
    private String apellido;

    @NotBlank(message = "Nombre obligatorio")
    private String telefono;

    @NotNull(message = "Nombre obligatorio")
    @Email(message = "Ingresa un email valido")
    private String email;

    private String direccion;

    public ClienteDTO(String nombre, String apellido, String telefono, String email, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    public @NotBlank(message = "Nombre obligatorio") String getNombre() {
        return nombre;
    }

    public @NotBlank(message = "Nombre obligatorio") String getApellido() {
        return apellido;
    }

    public @NotBlank(message = "Nombre obligatorio") String getTelefono() {
        return telefono;
    }

    public @NotNull(message = "Nombre obligatorio") @Email(message = "Ingresa un email valido") String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }


}