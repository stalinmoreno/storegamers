package com.storegamers.appweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class OrdenController {

  private static final String INDEX = "orden/index";

  @GetMapping("/orden/index")
  public String index(Model model) {
    return INDEX;
  }

}
