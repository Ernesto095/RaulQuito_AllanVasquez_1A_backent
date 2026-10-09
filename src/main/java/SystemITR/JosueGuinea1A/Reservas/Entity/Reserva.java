package SystemITR.JosueGuinea1A.Reservas.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "RESERVAS", schema = "FinalBoss")
@Data
@NoArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long id_reserva;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Cliente", nullable = false)
    private String Cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Vehiculo", nullable = false)
    private String Vehiculo;

    @Column(name = "nombre_reserva", nullable = false, length = 100)
    private String nombre_reserva;

    @Column(name = "fecha_reserva", nullable = false)
    private LocalDate fecha_reserva;

    @Column(name = "cantidad_pasajeros", nullable = false)
    private Integer cantidad_pasajeros;

    @Column(name = "cantidad_dias", nullable = false)
    private Integer cantidad_dias;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "total_pago", nullable = false)
    private BigDecimal total_pago;

}