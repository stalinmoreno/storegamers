package com.storegamers.appweb.controller;

import org.springframework.data.mapping.model.IdPropertyIdentifierAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PathVariable;
import com.storegamers.appweb.model.Orden;

import com.storegamers.appweb.model.Product;
import com.storegamers.appweb.model.Proforma;
import com.storegamers.appweb.model.Usuario;
import com.storegamers.appweb.repository.CarritoRepository;
import com.storegamers.appweb.repository.ProformaRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@Controller
public class ProformaController {

  private static final String INDEX = "proforma/index";
  private static String MODEL_PRODUCTO = "proforma";
  private final ProformaRepository proformaData;
  private final HomeController globalHome;

  public ProformaController(ProformaRepository proformaData, HomeController globalHome) {
    this.proformaData = proformaData;
    this.globalHome = globalHome;
  }

  @GetMapping("/proforma/index")
  public String index(Model model, HttpSession session) {
    Usuario user = (Usuario) session.getAttribute("user");
    List<Proforma> listItems = this.proformaData.findAll();
    model.addAttribute("proformas", listItems);

    // List<Producto> productos =
    // carritos.stream().map(Carrito::getProducto).collect(Collectors.toList());
    BigDecimal sumPrecio = listItems.stream().map(Proforma::getPrecio).reduce(BigDecimal.ZERO, BigDecimal::add);

    model.addAttribute("user", user);
    if (user != null) {
      model.addAttribute("perfil", user.getPerfil());
    } else {
      model.addAttribute("perfil", null);
    }

    Integer total = globalHome.countItemsCarrito();
    model.addAttribute("proforma", total);
    model.addAttribute("subtotal", sumPrecio);
    return INDEX;
  }

  @PostMapping("/proforma/update")
  public String createSubmitForm(Model model, @Valid Product objProducto, BindingResult result) {

    return INDEX;
  }

  @GetMapping("/proforma/eliminar/{id}")

  public String carritoEliminar(@PathVariable int id, RedirectAttributes redirect) {
    proformaData.deleteById(id);
    // redirect.addFlashAttribute(MENSAJE, "EL producto se ha quitado del carrito de
    // compras.");

    return "redirect:/proforma/index";
  }

}
