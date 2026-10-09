package SystemITR.JosueGuinea1A.Vehiculo.Services;

import SystemITR.JosueGuinea1A.Vehiculo.DTO.VehiculoDTO;
import SystemITR.JosueGuinea1A.Vehiculo.Entity.Vehiculo;
import SystemITR.JosueGuinea1A.Vehiculo.Repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


    @Service
    @RequiredArgsConstructor
    @Transactional(readOnly = true)
    public class VehiculoServices {

        private final VehiculoRepository vehiculoRepository;

        public List<VehiculoDTO> obtenerTodos() {
            return vehiculoRepository.findAll(Sort.by("idVehiculo"))
                    .stream()
                    .map(this::convertirDTO)
                    .toList();
        }

        public VehiculoDTO obtenerPorId(Long id) throws ChangeSetPersister.NotFoundException {
            Vehiculo vehiculo = vehiculoRepository.findById(id)
                    .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

            return convertirDTO(vehiculo);
        }

        private VehiculoDTO convertirDTO(Vehiculo vehiculo) {
            return new VehiculoDTO(
                    vehiculo.getIdVehiculo(),
                    vehiculo.getMarca(),
                    vehiculo.getModelo(),
                    vehiculo.getCapacidad(),
                    vehiculo.getPrecioDia(),
                    vehiculo.getPlaca()
            );
        }
    }