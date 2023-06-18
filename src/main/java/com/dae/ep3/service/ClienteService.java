package com.dae.ep3.service;

import com.dae.ep3.entity.Cliente;
import com.dae.ep3.exception.ClienteNotFoundException;
import com.dae.ep3.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;

    public List<Cliente> Listar(Integer id){
        if(id != null) {
            return clienteRepository.findAll(id);
        }
        return clienteRepository.findAll();
    }

    public List<Cliente> Listar(){
        return clienteRepository.findAll();
    }

    public Cliente Consultar(Integer id){
        return clienteRepository.findById(id).orElseThrow(() -> new ClienteNotFoundException(id));
    }

    public Cliente Guardar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void Eliminar(Integer id){
        clienteRepository.delete(clienteRepository.findById(id).orElseThrow(() -> new ClienteNotFoundException(id)));
    }
}
