package com.storegamers.appweb.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.storegamers.appweb.model.UsuarioAdmin;
import com.storegamers.appweb.repository.UsuarioAdminRepository;

@Controller
public class UserAdminController {

    private static final String INDEX ="administrador/loginAdmin"; 
    private static String MODEL_CONTACT="user";
    private static String MODEL_MESSAGE="mensaje";    
    private final UsuarioAdminRepository usuariosAdminData;

    public UserAdminController(UsuarioAdminRepository usuariosAdminData){
        this.usuariosAdminData = usuariosAdminData;
    }

    @GetMapping("/administrador/login")
    public String loginAdmin(Model model){
        model.addAttribute(MODEL_CONTACT,new UsuarioAdmin());
        return INDEX;
    }

    @PostMapping("/administrador/login")
    public String loginSubmitFormAdmin(Model model, @Valid UsuarioAdmin objUserAdmin,BindingResult result){
        String page = INDEX;
        model.addAttribute(MODEL_CONTACT, new UsuarioAdmin());        
        if(result.hasFieldErrors()) {
            model.addAttribute(MODEL_MESSAGE, "No se ha podido loguear");
        }else{
            Optional<UsuarioAdmin> userDB = this.usuariosAdminData.findById(objUserAdmin.getEmail());
            if(userDB.isPresent()){
                if(userDB.get().getPassword().equals(objUserAdmin.getPassword())){
                    model.addAttribute(MODEL_CONTACT,userDB.get());
                    model.addAttribute(MODEL_MESSAGE, "Usuario existe");
                    page="administrador/administracionUsuario";  
                }else{
                    model.addAttribute(MODEL_MESSAGE, "Password no coincide");  
                }
            }else{
                model.addAttribute(MODEL_MESSAGE, "Usuario no existe");
            }
        }
        return page;
    }
}
