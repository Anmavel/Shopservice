package com.example.shopservice.model;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@ToString
public class Car implements Product {
	private int id;
	private String name;
	private BigDecimal priceInCents;
}
