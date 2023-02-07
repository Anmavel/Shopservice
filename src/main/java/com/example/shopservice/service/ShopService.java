package com.example.shopservice.service;

import com.example.shopservice.model.Order;
import com.example.shopservice.model.Product;
import com.example.shopservice.repositories.OrderRepo;
import com.example.shopservice.repositories.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@AllArgsConstructor
@Service
public class ShopService {
	private final ProductRepo availableProducts;
	private OrderRepo currentOrders =new OrderRepo();
//	private OrderRepo archivedOrders;

	public Optional<Product> getProductById(int id) {
		Optional<Product> result = availableProducts.getProductById(id);
		System.out.println(result.isPresent() ? result.get().toString() : "Product does not exist!");
		return result;
	}

	public List<Product> listProducts() {
		return listProducts(false);
	}

	public List<Product> listProducts(boolean silent) {
		List<Product> productList = availableProducts.listProducts();
		if (!silent) {
			System.out.println("These are the products in the repository:");
			for (Product p : productList) {
				System.out.println("- " + p);
			}
		}
		return productList;
	}
	public void addOrder(Order order) {
		order.getOrderedProducts().stream()
						.forEach(p -> {
							if (!listProducts(true).contains(p)) {
								throw new NoSuchElementException("Product " + p + " does not exist in this shop! Where did you find it?");
							}
						});
		currentOrders.addSingleOrder(order);
	}

	public Optional<Order> getOrderById(int id) {
		Optional<Order> result = currentOrders.getById(id);
		System.out.println(result.isPresent() ? result.get().toString() : "Order does not exist!");
		return result;
	}

	public List<Order> listOrders() {
		List<Order> orderList = currentOrders.listOrders();
		System.out.println("These are the current orders:");
		for (Order o : orderList) {
			System.out.println("- " + o);
		}
		return orderList;
	}

}