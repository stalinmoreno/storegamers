package com.storegamers.appweb.controller;

import javax.websocket.server.PathParam;
import com.storegamers.appweb.repository.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import com.storegamers.appweb.model.Product;

@Controller
public class CatalogueController {

  // private static final String INDEX = "catalogo/viewProduct";
  // private final ProductRepository productsData;

  private static final String VIEW_PRODUCT = "catalogo/viewProduct";
  private final ProductRepository productsData;
  private static String MODEL_PRODUCT = "product";

  // private static String MODEL_PRODUCT = "product";

  public CatalogueController(ProductRepository productsData) {
    this.productsData = productsData;
  }

  @GetMapping("/catalogo/viewProduct/{id}")
  public String viewProduct(@PathVariable("id") Integer id, Model model) {
    Product product = this.productsData.getOneProduct(id);
    model.addAttribute(MODEL_PRODUCT, product);
    return VIEW_PRODUCT;
  }

}