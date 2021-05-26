package com.storegamers.appweb.controller;

import com.storegamers.appweb.model.Product;
import com.storegamers.appweb.model.Proforma;
import com.storegamers.appweb.model.Usuario;
import com.storegamers.appweb.repository.ProductRepository;
import com.storegamers.appweb.repository.ProformaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
public class HomeController {

  @Autowired
  private static final String INDEX = "home";

  private final ProductRepository productsData;
  private final ProformaRepository proformaData;

  public HomeController(ProductRepository productsData, ProformaRepository proformaData) {
    this.productsData = productsData;
    this.proformaData = proformaData;
  }

  @GetMapping("/")
  public String index(Model model) {
    List<Product> listProduct = this.productsData.getAllProducts();

    model.addAttribute("products", listProduct);
    Integer total = countItemsCarrito();
    model.addAttribute("proforma", total);
    return INDEX;
  }

  public Integer countItemsCarrito() {
    List<Proforma> listProforma = this.proformaData.findAll();
    return listProforma.size();
  }

}
