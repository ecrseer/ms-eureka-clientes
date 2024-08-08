package com.example.microserviceusuariosgabrieltp1.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }

    public Cliente salvarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    public Cliente buscarClientePorId(Long id){
        Optional<Cliente> encontrado = clienteRepository.findById(id);
        if(encontrado.isEmpty()){
            throw new RuntimeException("Nao encontrado");
        }
        return encontrado.get();
    }
    public Cliente editarCliente(Cliente cliente){
        buscarClientePorId(cliente.getId());
        return clienteRepository.save(cliente);
    }

    public Cliente excluirCliente(Long cliente){
        Cliente removido = buscarClientePorId(cliente);
        clienteRepository.deleteById(cliente);
        return removido;
    }

}
