package SystemITR.JosueGuinea1A.Clientes.Controller;

import SystemITR.JosueGuinea1A.Clientes.Services.ClienteServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {
        private final ClienteServices service;
}

