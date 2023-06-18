package com.dae.ep3.controller;

import com.dae.ep3.entity.Cliente;
import com.dae.ep3.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("")
public class ClienteController {

    @Autowired
    private final ClienteService clienteService;

    @GetMapping("/")
    public String Listar(Model model, @Param("id") Integer id){
        List<Cliente> clientes = clienteService.Listar(id);

        model.addAttribute("id", id);
        model.addAttribute("clientes", clientes);

        return "index";
    }

    @GetMapping("/detalle")
    public String Consultar(@RequestParam Integer id, Model model){
        model.addAttribute("cliente", clienteService.Consultar(id));

        return "index";
    }

    @PostMapping("")
    public String Guardar(@ModelAttribute("cliente") Cliente cliente) {
        try {
            clienteService.Guardar(cliente);
        } catch (Exception e) {

        }
        return "redirect:/";
    }


    @PutMapping("")
    public String Actualizar(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.Guardar(cliente);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String Eliminar(@PathVariable Integer id, Model model){
        clienteService.Eliminar(id);
        return "redirect:/";
    }
}