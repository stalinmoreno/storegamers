package com.storegamers.appweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

import com.storegamers.appweb.model.Orden;
import com.storegamers.appweb.model.Usuario;

@Controller
public class AdminController {

  private static final String INDEX = "admin/index";
  private static final String INDEX_MANT = "admin/mantenimiento";

  @GetMapping("/admin/index")
  public String index(Model model, HttpSession session) {

    Usuario user = (Usuario) session.getAttribute("user");
    model.addAttribute("user", user);
    if (user != null) {
      model.addAttribute("perfil", user.getPerfil());
    } else {
      model.addAttribute("perfil", null);
    }

    return INDEX;
  }

  @GetMapping("/admin/mantenimiento")
  public String mantenimiento(Model model, HttpSession session) {

    Usuario user = (Usuario) session.getAttribute("user");
    model.addAttribute("user", user);
    if (user != null) {
      model.addAttribute("perfil", user.getPerfil());
    } else {
      model.addAttribute("perfil", null);
    }

    return INDEX_MANT;
  }

}
