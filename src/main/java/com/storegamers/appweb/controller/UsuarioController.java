package com.storegamers.appweb.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.storegamers.appweb.model.Cliente;
import com.storegamers.appweb.model.Usuario;

import com.storegamers.appweb.repository.UsuarioService;
import com.storegamers.appweb.repository.ClienteRepository;
import com.storegamers.appweb.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

@Controller
// @RestController
public class UsuarioController {

    private static final String INDEX = "usuario/login";
    private static String MODEL_CONTACT = "user";
    private static String MODEL_MESSAGE = "mensaje";
    private static final String INDEX_PERSONAL = "usuario/datospersonales";
    private final UsuarioRepository usuariosData;
    private final ClienteRepository repoCliente;

    public UsuarioController(UsuarioRepository usuariosData, ClienteRepository clienteRepository) {
        this.usuariosData = usuariosData;
        this.repoCliente = clienteRepository;
    }

    @GetMapping("/usuario/login")
    public String login(Model model) {
        model.addAttribute(MODEL_CONTACT, new Usuario());
        return INDEX;
    }

    @PostMapping("/usuario/login")
    public String loginSubmitForm(Model model, @Valid Usuario objUser, HttpServletRequest request,
            BindingResult result) {
        String page = INDEX;
        model.addAttribute(MODEL_CONTACT, new Usuario());

        if (objUser.getPassword().isEmpty() || objUser.getUserID().isEmpty()) {
            model.addAttribute(MODEL_MESSAGE, "Ingrese usuario y/o contraseña");
        } else {

            if (result.hasFieldErrors()) {
                model.addAttribute(MODEL_MESSAGE, "No se ha podido loguear");
            } else {
                Optional<Usuario> userDB = this.usuariosData.findById(objUser.getUserID());

                if (userDB.isPresent()) {
                    if (userDB.get().getPassword().equals(objUser.getPassword())) {
                        model.addAttribute(MODEL_CONTACT, userDB.get());
                        model.addAttribute(MODEL_MESSAGE, "Usuario existe");
                        request.getSession().setAttribute("user", userDB.get());
                        page = "redirect:/";
                    } else {
                        model.addAttribute(MODEL_MESSAGE, "Password no coincide");
                    }
                } else {
                    model.addAttribute(MODEL_MESSAGE, "Usuario no existe");
                }
            }
        }

        return page;
    }

    @GetMapping("/usuario/logout")
    public String logoutSession(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }

    @GetMapping("/usuario/cambiocontrasenia")
    public String cambiocontrasenia(Model model, HttpSession session) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        // request.getSession().invalidate();
        Usuario user = (Usuario) session.getAttribute("user");
        model.addAttribute("user", user);

        if (user != null) {
            model.addAttribute("perfil", user.getPerfil());
        } else {
            model.addAttribute("perfil", null);
        }

        return "usuario/cambiocontrasenia";
    }

    // @Autowired
    // UsuarioService service;

    @PostMapping("/usuario/cambiocontrasenia")
    public String newPassword(Model model, Usuario usuario, HttpSession session, RedirectAttributes redirect) {
        // service.changePassword(newP, usuario.getPassword());
        Usuario user = (Usuario) session.getAttribute("user");
        usuario.setUserID(user.getUserID());
        usuario.setPerfil(user.getPerfil());
        usuariosData.save(usuario);
        redirect.addFlashAttribute(MODEL_MESSAGE, "Contraseña actualizada");
        return "redirect:/usuario/cambiocontrasenia";
    }

    @GetMapping("/usuario/datospersonales")
    public String datospersonales(Model model, HttpSession session) {

        Usuario user = (Usuario) session.getAttribute("user");
        model.addAttribute("user", user);

        if (user != null) {
            model.addAttribute("perfil", user.getPerfil());
        } else {
            model.addAttribute("perfil", null);
        }

        Cliente client = repoCliente.getUserFull(user);
        model.addAttribute("usuario", client);

        return INDEX_PERSONAL;
    }

    // @PostMapping("/usuario/cambiocontrasenia")
    // public String createSubmitForm(Model model, @Valid Cliente cliente,
    // BindingResult result) {

    // String page = INDEX;
    // if (result.hasFieldErrors()) {
    // model.addAttribute("mensaje", "No se registro un cliente");
    // } else {

    // Usuario user = cliente.getUser();
    // repoUsuario.save(user);
    // repoUsuario.flush();
    // repoCliente.save(cliente);
    // model.addAttribute(MODEL_CONTACT, cliente);
    // model.addAttribute("mensaje", "Se registro un cliente");
    // page = "redirect:/" + INDEX_LOGIN;
    // }
    // return page;
    // }

}