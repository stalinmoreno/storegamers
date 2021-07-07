package com.storegamers.appweb.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.math.BigDecimal;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

@Table(name = "t_order")

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date orderDate; 
    private Integer clienteId;
    private BigDecimal montoTotal;
}