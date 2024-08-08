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
        return ResponseEntity.status(HttpStatus.CREATED).body(clientes);
    }

    @PostMapping("/criar")
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        Cliente salvo=clienteService.salvarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Cliente> atualizaCliente(@RequestBody Cliente dto) {
        Cliente editado=clienteService.editarCliente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(editado);
    }

    @DeleteMapping("/remover")
    public ResponseEntity<Cliente> removerCliente(@RequestParam Long idCliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.excluirCliente(idCliente));
    }


}
