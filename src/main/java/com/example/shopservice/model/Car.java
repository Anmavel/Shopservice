package com.example.shopservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@ToString
public class Car implements Product {
	private int id;
	private String name;
	private BigDecimal priceInCents;
}
