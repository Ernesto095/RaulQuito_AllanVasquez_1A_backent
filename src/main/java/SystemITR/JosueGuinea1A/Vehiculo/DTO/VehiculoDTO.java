package SystemITR.JosueGuinea1A.Vehiculo.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class VehiculoDTO {

    Long idVehiculo;
    String marca;
    String modelo;
    Integer capacidad;
    BigDecimal precioDia;
    String placa;

    public VehiculoDTO(Long idVehiculo, String marca, String modelo, Integer capacidad, BigDecimal precioDia, String placa) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.precioDia = precioDia;
        this.placa = placa;
    }

    public Long getIdVehiculo() {
        return idVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public BigDecimal getPrecioDia() {
        return precioDia;
    }

    public String getPlaca() {
        return placa;
    }

    public void setIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setPrecioDia(BigDecimal precioDia) {
        this.precioDia = precioDia;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}

