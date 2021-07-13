package com.storegamers.appweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.storegamers.appweb.model.Cliente;
import com.storegamers.appweb.model.Perfil;
import com.storegamers.appweb.model.Usuario;
import com.storegamers.appweb.repository.ClienteRepository;
import com.storegamers.appweb.repository.UsuarioRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
// @RequiredArgsConstructor
public class ClienteController {

    private static final String INDEX = "cliente/create";
    private static final String INDEX_LOGIN = "usuario/login";
    private static String MODEL_CONTACT = "client";
    private static String INDEX_CONTACTO = "contacto/create";
    // @Autowired
    private final ClienteRepository repoCliente;

    private final UsuarioRepository repoUsuario;

    public ClienteController(ClienteRepository clienteRepository, UsuarioRepository usuarioRepository) {
        this.repoCliente = clienteRepository;
        this.repoUsuario = usuarioRepository;
    }

    @GetMapping("/cliente/create")
    public String index(Model model) {
        model.addAttribute(MODEL_CONTACT, new Cliente());
        return INDEX;
    }

    @PostMapping("/cliente/create")
    public String createSubmitForm(Model model, @Valid Cliente cliente, BindingResult result) {

        String page = INDEX;
        if (result.hasFieldErrors()) {
            model.addAttribute("mensaje", "No se registro un cliente");
        } else {

            Usuario user = cliente.getUser();
            Perfil perfiluser = new Perfil();
            perfiluser.setId(1);
            perfiluser.setDescription("CLIENTE");
            perfiluser.setStatus(1);
            user.setPerfil(perfiluser);
            repoUsuario.save(user);
            repoUsuario.flush();
            repoCliente.save(cliente);
            model.addAttribute(MODEL_CONTACT, cliente);
            model.addAttribute("mensaje", "Se registro un cliente");
            page = "redirect:/" + INDEX_LOGIN;
        }
        return page;
    }

    @GetMapping("/contacto/create")
    public String create(Model model) {
        model.addAttribute(MODEL_CONTACT, new Cliente());
        return INDEX_CONTACTO;
    }

    @GetMapping("/cliente/list")
    public String list(Model model, HttpSession session) {

        List<Cliente> listCustomer = this.repoCliente.getCustomerFull();
        model.addAttribute("customers", listCustomer);

        Usuario user = (Usuario) session.getAttribute("user");
        model.addAttribute("user", user);
        if (user != null) {
            model.addAttribute("perfil", user.getPerfil());
        } else {
            model.addAttribute("perfil", null);
        }
        return "cliente/list";
    }

}
