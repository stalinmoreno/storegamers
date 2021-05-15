package com.storegamers.appweb.controller;

import com.storegamers.appweb.model.*;
import com.storegamers.appweb.repository.ClienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import javax.validation.Valid;

@Controller
public class ClienteController {

    private static final String INDEX = "Cliente/create";
    private static String MODEL_CLIENTE = "Cliente";
    private final ClienteRepository ClientesData;

    public ClienteController(ClienteRepository ClientesData) {
        this.ClientesData = ClientesData;
    }

    @GetMapping("/Cliente/create")
    public String index(Model model) {
        model.addAttribute(MODEL_CLIENTE, new Cliente());
        return INDEX;
    }

    @PostMapping("/Cliente/create")
    public String createSubmitForm(Model model, @Valid Cliente objCliente, BindingResult result) {
        if (result.hasFieldErrors()) {
            model.addAttribute("Usuario no registrado");
        } else {
            this.ClientesData.save(objCliente);
            model.addAttribute(MODEL_CLIENTE, objCliente);
            model.addAttribute("Usuario registrado");
        }
        return INDEX;
    }
}
