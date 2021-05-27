package com.storegamers.appweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import com.storegamers.appweb.model.Orden;

@Controller
public class AdminController {

  private static final String INDEX = "admin/index";
  private static final String INDEX_MANT = "admin/mantenimiento";

  @GetMapping("/admin/index")
  public String index(Model model) {
    return INDEX;
  }

  @GetMapping("/admin/mantenimiento")
  public String mantenimiento(Model model) {
    return INDEX_MANT;
  }

}
