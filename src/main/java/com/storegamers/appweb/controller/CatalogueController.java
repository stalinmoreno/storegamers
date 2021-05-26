package com.storegamers.appweb.controller;

import javax.websocket.server.PathParam;
import com.storegamers.appweb.repository.ProductRepository;
import com.storegamers.appweb.repository.ProformaRepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import com.storegamers.appweb.model.Product;
import com.storegamers.appweb.model.Proforma;
import com.storegamers.appweb.model.Usuario;

import javax.servlet.http.HttpSession;

@Controller
public class CatalogueController {

  // private static final String INDEX = "catalogo/viewProduct";
  // private final ProductRepository productsData;

  private static final String VIEW_PRODUCT = "catalogo/viewProduct";
  private static final String INDEX_HOME = "/";
  private static final String INDEX_LOGIN = "/usuario/login";
  private final ProductRepository productsData;
  private final ProformaRepository proformasData;
  private static String MODEL_PRODUCT = "product";

  // private static String MODEL_PRODUCT = "product";

  public CatalogueController(ProductRepository productsData, ProformaRepository proformasData) {
    this.productsData = productsData;
    this.proformasData = proformasData;
  }

  @GetMapping("/catalogo/viewProduct/{id}")
  public String viewProduct(@PathVariable("id") Integer id, Model model) {
    Product product = this.productsData.getOneProduct(id);
    model.addAttribute(MODEL_PRODUCT, product);
    return VIEW_PRODUCT;
  }

  @GetMapping("/catalogo/add/{id}")
  public String add(@PathVariable("id") int id, HttpSession session, Model model) {

    Usuario user = (Usuario) session.getAttribute("user");
    String page = INDEX_HOME;

    // if (user == null) {
    // //debe loguearse
    // page = "redirect:/" + INDEX_LOGIN;
    // } else {
    // }
    Product productSelected = productsData.getOne(id);
    Proforma itemCarrito = new Proforma();
    itemCarrito.setCantidad(1);
    itemCarrito.setUser(user);
    itemCarrito.setPrecio(productSelected.getPrice());
    itemCarrito.setProduct(productSelected);
    proformasData.save(itemCarrito);
    page = "redirect:" + INDEX_HOME;

    return page;
  }

}
