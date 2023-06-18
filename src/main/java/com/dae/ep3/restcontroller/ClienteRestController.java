package com.dae.ep3.restcontroller;

import com.dae.ep3.entity.Cliente;
import com.dae.ep3.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ClienteRestController {
    @Autowired
    private final ClienteService clienteService;

    @GetMapping("/info")
    public List<Cliente> Listar(Model model){
        return clienteService.Listar();
    }

    @GetMapping("/detalle/{id}")
    public Cliente Consultar(@PathVariable Integer id) {
        return clienteService.Consultar(id);
    }

    @PostMapping("/save")
    public Cliente Guardar(@RequestBody Cliente cliente) {
        return clienteService.Guardar(cliente);
    }

    @PutMapping("/actualizar")
    public Cliente Actualizar(@RequestBody Cliente cliente) {
        return clienteService.Guardar(cliente);
    }

    @DeleteMapping("/eliminar/{id}")
    public void Eliminar(@PathVariable Integer id){
        clienteService.Eliminar(id);
    }
}