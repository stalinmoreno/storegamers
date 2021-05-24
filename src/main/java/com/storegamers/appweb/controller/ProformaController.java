package com.storegamers.appweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import com.storegamers.appweb.model.Orden;

@Controller
public class ProformaController {

  private static final String INDEX = "proforma/index";

  @GetMapping("/proforma/index")
  public String index(Model model) {
    return INDEX;
  }

}
