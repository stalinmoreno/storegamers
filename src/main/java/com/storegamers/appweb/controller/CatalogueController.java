package com.storegamers.appweb.controller;

import java.util.List;

import com.storegamers.appweb.model.Product;
import com.storegamers.appweb.repository.ProductRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
public class CatalogueController {

  // private static final String INDEX = "/";
  // private final ProductRepository productsData;

  // public CatalogueController(ProductRepository productsData) {
  // this.productsData = productsData;
  // }

  // @GetMapping("/")
  // public String index(Model model) {
  // // List<Product> listProduct = this.productsData.getAllProducts();
  // // model.addAttribute("products", listProduct);
  // // return INDEX;
  // }

}
