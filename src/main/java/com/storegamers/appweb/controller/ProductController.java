package com.storegamers.appweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import com.storegamers.appweb.model.Product;
import com.storegamers.appweb.model.Usuario;
import com.storegamers.appweb.repository.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

@Controller
public class ProductController {

  private static final String INDEX = "producto/index";
  private static final String INDEX_CREATE = "producto/create";
  private static final String INDEX_EDIT = "producto/edit";
  private static String MODEL_MESSAGE = "mensaje";
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
    producto.setImage_url("https://i.linio.com/p/fe4b7f2cd0a664d8fe425ebb44de914a-product.webp");
    producto.setStatus(1);
    model.addAttribute("product", producto);

    Usuario user = (Usuario) session.getAttribute("user");

    model.addAttribute("user", user);

    if (user != null) {
      model.addAttribute("perfil", user.getPerfil());
    } else {
      model.addAttribute("perfil", null);
    }
    return INDEX_CREATE;
  }

  @PostMapping("/producto/create")
  public String createSubmitForm(Model model, @Valid Product objProduct, HttpSession session,
      RedirectAttributes redirect) {

    productosData.save(objProduct);

    Usuario user = (Usuario) session.getAttribute("user");

    model.addAttribute("user", user);

    if (user != null) {
      model.addAttribute("perfil", user.getPerfil());
    } else {
      model.addAttribute("perfil", null);
    }

    redirect.addFlashAttribute(MODEL_MESSAGE, "Producto grabado exitosamente");

    return "redirect:/" + INDEX;

  }

  @PostMapping("/producto/update")
  public String editProduct(Model model, @Valid Product objProduct, HttpSession session, RedirectAttributes redirect) {
    Product _product = new Product();
    // model.addAttribute("producto", producto);
    Usuario user = (Usuario) session.getAttribute("user");

    model.addAttribute("user", user);
    if (user != null) {
      model.addAttribute("perfil", user.getPerfil());
    } else {
      model.addAttribute("perfil", null);
    }

    productosData.save(objProduct);
    redirect.addFlashAttribute(MODEL_MESSAGE, "Producto actualizado exitosamente");
    return "redirect:/" + INDEX_EDIT + "/" + objProduct.getId();
  }

  @GetMapping("/producto/edit/{id}")
  public String edit(@PathVariable("id") Integer id, Model model, HttpSession session) {
    // Product producto = new Product();
    // model.addAttribute("nuevo_producto", producto);
    Product product = this.productosData.getOneProduct(id);
    // model.addAttribute(MODEL_PRODUCT, product);
    Usuario user = (Usuario) session.getAttribute("user");
    model.addAttribute("user", user);
    if (user != null) {
      model.addAttribute("product", product);
    } else {
      model.addAttribute("product", null);
    }
    return INDEX_EDIT;
  }

  @GetMapping("/producto/delete/{id}")
  public String delete(@PathVariable("id") Integer id, Model model, HttpSession session, RedirectAttributes redirect) {
    // this.productosData.deleteOnProduct(id);
    Product product = this.productosData.getOne(id);
    product.setStatus(0);
    this.productosData.save(product);
    redirect.addFlashAttribute(MODEL_MESSAGE, "Producto eliminado exitosamente");
    return "redirect:/" + INDEX;
  }

}
