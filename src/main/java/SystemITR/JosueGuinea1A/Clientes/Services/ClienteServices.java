package SystemITR.JosueGuinea1A.Clientes.Services;

import SystemITR.JosueGuinea1A.Clientes.DTO.ClienteDTO;
import SystemITR.JosueGuinea1A.Clientes.Entity.Cliente;
import SystemITR.JosueGuinea1A.Clientes.Repository.ClienteRepository;
import SystemITR.JosueGuinea1A.Reservas.Repository.ReservaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
@Transactional
public class ClienteServices {
    private final ClienteRepository;
    private final ReservaRepository reservaRepository;

    public List<ClienteDTO> obtenerTodos() {
        return ClienteRepository.findAll(Sort.by("ID_CLIENTE"))
                .stream()
                .map(this::convertirDTO)
                .toList();
    }

    public ClienteDTO obtenerporID(Long id) {
        return convertirDTO(buscarPorId(id));
    }

    @Transactional
    public ClienteDTO crear(ClienteDTO dto) {
        String email = dto.getEmail().trim().toLowerCase(Locale.ROOT);

        if (ClienteRepository.existsByEmailIgnoreCase(email)) {
            throw new ExecutionException("El email ya está registrado.");
        }

        Cliente cliente = new Cliente();
        asignarDatos(cliente, dto, email);

        return convertirDTO(ClienteRepository.saveAndFlush(cliente));
    }

    @Transactional
    public ClienteDTO actualizar(Long id, ClienteDTO dto) {
        Cliente cliente = buscarPorId(id);
        String email = dto.getEmail().trim().toLowerCase(Locale.ROOT);

        if (ClienteRepository.existsByEmailIgnoreCaseAndIdClienteNot(email, id)) {
            throw new BusinessException("El email ya pertenece a otro cliente.");
        }

        asignarDatos(cliente, dto, email);

        return convertirDTO(ClienteRepository.saveAndFlush(cliente));
    }

    @Transactional
    public void eliminar(Long id) {
        Cliente cliente = buscarPorId(id);

        if (reservaRepository.existsByCliente_IdCliente(id)) {
            throw new BusinessException(
                    "No se puede eliminar el cliente porque tiene reservas relacionadas."
            );
        }

        ClienteRepository.delete(cliente);
        ClienteRepository.flush();
    }

    private Cliente buscarPorId(Long id) {
        return ClienteRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException("Cliente no encontrado."));
    }

    private void asignarDatos(Cliente cliente, ClienteDTO dto, String email) {
        cliente.setNombre(dto.getNombre().trim());
        cliente.setApellido(dto.getApellido().trim());
        cliente.setTelefono(dto.getTelefono().trim());
        cliente.setEmail(email);
        cliente.setDireccion(
                dto.getDireccion() == null ? null : dto.getDireccion().trim()
        );
    }

    private ClienteDTO convertirDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getTelefono(),
                cliente.getEmail(),
                cliente.getDireccion()
        );
    }
}
