package com.example.shopservice.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Motorcycle implements Product {
  private int id;
  private String name;
  private BigDecimal priceInCents;
}
