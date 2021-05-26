package com.storegamers.appweb.model;

import java.math.BigDecimal;
//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.websocket.Decoder.Text;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import lombok.*;

//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_product")

public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Integer id;
  private String name;

  private String description;

  private BigDecimal price;
  private String image_url;
  private Integer stock;
  private Integer status;

  public String MonedaPrice() {
    return "S/. " + price;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getImage_url() {
    return image_url;
  }

  public void setImage_url(String image_url) {
    this.image_url = image_url;
  }

  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
