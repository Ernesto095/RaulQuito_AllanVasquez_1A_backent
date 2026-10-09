package SystemITR.JosueGuinea1A.Vehiculo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "VEHICULOS")
@Getter
@Setter
@NoArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_VEHICULOS"
    )
    @SequenceGenerator(
            name = "SEQ_VEHICULOS",
            sequenceName = "SEQ_VEHICULOS",
            allocationSize = 1
    )
    @Column(name = "ID_VEHICULO", columnDefinition = "NUMBER")
    private Long idVehiculo;

    @Column(name = "MARCA", nullable = false, length = 100)
    private String marca;

    @Column(name = "MODELO", nullable = false, length = 100)
    private String modelo;

    @Column(name = "CAPACIDAD", columnDefinition = "NUMBER", nullable = false)
    private Integer capacidad;

    @Column(name = "PRECIO_DIA", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioDia;

    @Column(name = "PLACA", nullable = false, unique = true, length = 20)
    private String placa;
}
