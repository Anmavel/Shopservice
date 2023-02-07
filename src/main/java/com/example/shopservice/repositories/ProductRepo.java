package com.example.shopservice.repositories;

import com.example.shopservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Repository
public class ProductRepo {
	private List<Product> products = new ArrayList<>();

	public List<Product> listProducts() {
		return products;
	}

	public Optional<Product> getProductById(int id) {
		return products.stream()
				.filter(p -> p.getId() == id)
				.findFirst();
	}

	public void addProduct(Product productToAdd) {
		products.add(productToAdd);
	}

}
