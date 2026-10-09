package SystemITR.JosueGuinea1A.Vehiculo.Repository;

import SystemITR.JosueGuinea1A.Vehiculo.Entity.Vehiculo;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Optional;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

        @Lock(LockModeType.PESSIMISTIC_WRITE)
        @Query("select v from Vehiculo v where v.idVehiculo = :id")
        Optional<Vehiculo> buscarParaActualizar(@Param("id") Long id);

}
