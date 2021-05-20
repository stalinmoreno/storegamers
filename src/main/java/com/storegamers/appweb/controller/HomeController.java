package com.storegamers.appweb.controller;

import com.storegamers.appweb.model.Product;
import com.storegamers.appweb.repository.ProductRepository;

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
  private static final String VIEW_PRODUCT = "catalogo/viewProduct";
  private final ProductRepository productsData;
  private static String MODEL_PRODUCT = "product";

  public HomeController(ProductRepository productsData) {
    this.productsData = productsData;
  }

  @GetMapping("/")
  public String index(Model model) {
    List<Product> listProduct = this.productsData.getAllProducts();
    model.addAttribute("products", listProduct);
    return INDEX;
  }

  @GetMapping("/catalogo/viewProduct/{id}")
  public String viewProduct(@PathVariable("id") Integer id, Model model) {
    Product product = this.productsData.getOne(id);
    model.addAttribute(MODEL_PRODUCT, product);
    return VIEW_PRODUCT;
  }

}
