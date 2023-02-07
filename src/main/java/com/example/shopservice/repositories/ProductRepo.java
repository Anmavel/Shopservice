package com.example.shopservice.repositories;

import com.example.shopservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Data
public class ProductRepo {
	private List<Product> products;

	public List<Product> listProducts() {
		return products;
	}

	public Optional<Product> getProductById(int id) {
		return products.stream()
				.filter(p -> p.getId() == id)
				.findFirst();
	}

}
