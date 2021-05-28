package com.storegamers.appweb.controller;

import javax.servlet.http.HttpSession;
import com.storegamers.appweb.model.Product;
import com.storegamers.appweb.model.Usuario;
import com.storegamers.appweb.repository.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ProductController {

  private static final String INDEX = "producto/index";
  private static final String INDEX_CREATE = "producto/create";
  private final ProductRepository productosData;

  public ProductController(ProductRepository productosData) {
    this.productosData = productosData;
  }

  @GetMapping("/producto/index")
  public String index(Model model, HttpSession session) {

    List<Product> listProduct = this.productosData.getAllProducts();
    model.addAttribute("productos", listProduct);

    Usuario user = (Usuario) session.getAttribute("user");
    model.addAttribute("user", user);
    if (user != null) {
      model.addAttribute("perfil", user.getPerfil());
    } else {
      model.addAttribute("perfil", null);
    }

    return INDEX;
  }

  @GetMapping("/producto/create")
  public String create(Model model, HttpSession session) {
    Product producto = new Product();
    model.addAttribute("nuevo_producto", producto);
    Usuario user = (Usuario) session.getAttribute("user");
    model.addAttribute("user", user);
    if (user != null) {
      model.addAttribute("perfil", user.getPerfil());
    } else {
      model.addAttribute("perfil", null);
    }
    return INDEX_CREATE;
  }

}
