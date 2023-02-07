package com.example.shopservice.model;

import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor
@Getter
@ToString
public class Order {
	private final int id;
	private final List<Product> orderedProducts;
	private OrderStatus status = OrderStatus.NEW;
	private final ZonedDateTime creationTime = ZonedDateTime.now();

	public int getId() {
		return id;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
}
