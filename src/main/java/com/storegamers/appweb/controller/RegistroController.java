package com.storegamers.appweb.controller;

import com.storegamers.appweb.model.*;
import com.storegamers.appweb.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class RegistroController {

    private static final String INDEX ="registro/create"; 
    private static String MODEL_CONTACT="registro";
    private final ClienteRepository RegistroData;


    public RegistroController(ClienteRepository RegistroData){
        this.RegistroData = RegistroData;
    }    

    
    @GetMapping("/registro/create")
    public String index(Model model) {
        model.addAttribute(MODEL_REGISTRO, new Cliente());
        return INDEX;
    }  
    
    @PostMapping("/registro/create")
    public String createSubmitForm(Model model, 
        @Valid Contacto objRegistro, BindingResult result ){
        if(result.hasFieldErrors()) {
            model.addAttribute("Usuario no registrado");
        }else{
            this.contactsData.save(objRegistro);
            model.addAttribute(MODEL_REGISTRO, objRegistro);
            model.addAttribute("Usuario registrado");
        }
        return INDEX;
    }
}

