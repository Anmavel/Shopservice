package com.example.shopservice.repositories;

import com.example.shopservice.model.Order;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class OrderRepo {
	private List<Order> orders = new ArrayList<>();

	public List<Order> listOrders() {
		return orders;
	}

	public Optional<Order> getById(int id) {
		for (Order order : orders) {
			if (order.getId() == id) {
				return Optional.of(order);
			}
		}
		return Optional.empty();
	}


	public void addSingleOrder(Order order) {
		orders.add(order);
	}

}
