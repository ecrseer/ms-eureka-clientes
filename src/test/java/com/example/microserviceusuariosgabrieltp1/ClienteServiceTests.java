package com.example.microserviceusuariosgabrieltp1;

import com.example.microserviceusuariosgabrieltp1.cliente.Cliente;
import com.example.microserviceusuariosgabrieltp1.cliente.ClienteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ClienteServiceTests {
    @Autowired
    ClienteService clienteService;



    @Test
    @DisplayName("Cliente sao resgatados")
    public void testaEncontraClientePorEmail() {
        String MOCK_EMAIL = "email@falso.com";
        Cliente salvo = this.clienteService.salvarCliente(new Cliente("Claudia"));
        assertNotNull(salvo);



        Cliente encontrado = this.clienteService.buscarClientePorId(salvo.getId());
        assertEquals("Claudia", encontrado.getNome());

    }

    @Test
    @DisplayName("Clientes sao atualizados")
    public void testaAtualizarCliente() {

        List<Cliente> todosan = this.clienteService.getClientes();
        Cliente atualizado = this.clienteService.editarCliente(new Cliente(1L,"Claudia"));

        List<Cliente> todos = this.clienteService.getClientes();
        assertNotNull(atualizado);
    }
}
