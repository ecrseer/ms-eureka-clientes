package com.example.microserviceusuariosgabrieltp1.cliente;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Cliente>> atualizaCliente() {
        List<Cliente> clientes=clienteService.getClientes();
        Cliente mock = new Cliente();
        mock.setNome("trem bala");
        List <Cliente> clientess = List.of(mock);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientes);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Cliente> atualizaCliente(@RequestBody Cliente usuario) {
//        Cliente atualizado = this.usuarioService.atualizar(usuario);
          Cliente atualizado = new Cliente();

        return ResponseEntity.status(HttpStatus.CREATED).body(atualizado);
    }


}
