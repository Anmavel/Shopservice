package com.example.shopservice.controller;

import com.example.shopservice.model.Car;
import com.example.shopservice.model.Motorcycle;
import com.example.shopservice.model.Order;
import com.example.shopservice.model.Product;
import com.example.shopservice.repositories.OrderRepo;
import com.example.shopservice.repositories.ProductRepo;
import com.example.shopservice.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.lang.Math;

@RestController
@RequestMapping("/api")
public class ShopServiceController {

    ProductRepo productRepo = new ProductRepo();
    ShopService shopService = new ShopService(productRepo, new OrderRepo());

    @GetMapping ("products/{id}")
    public Product lookForProductById(@PathVariable String id){
        return shopService.getProductById(Integer.parseInt(id)).get();
    }

    @GetMapping("products")
    public List<Product> listAllProducts(){
        return shopService.listProducts();
    }

    @PostMapping("post-car")
    public List<Product>postCar(@RequestBody Car newCar){
        shopService.addProduct(newCar);
        return shopService.listProducts();
    }

    @PostMapping("post-motorcycle")
    public List<Product>postMotorcycle(@RequestBody Motorcycle newMotorcycle){
        shopService.addProduct(newMotorcycle);
        return shopService.listProducts();
    }

    @DeleteMapping("delete")
    public List<Product>deleteProduct(@PathVariable int id){
        shopService.deleteProduct(id);
        return shopService.listProducts();
    }

    @GetMapping ("order/{id}")
    public Order getOrderById(@PathVariable String id){
        return shopService.getOrderById(Integer.parseInt(id)).get();
    }

    @GetMapping("order")
    public List<Order> listAllOrders(){
        return shopService.listOrders();
    }


    @PostMapping("post-order")
    public List<Order>postOrder(@RequestBody int[] productIds) {

        Random rand = new Random();
        int randomId = rand.nextInt(10);
        // int randomId = 123 ;
        List<Product> orderedProducts = new ArrayList<>() {};
        Product productToOrder;

        for (int productId : productIds) {
            Optional<Product> productToOrderOptional =  shopService.listProducts(true).stream().filter(p -> p.getId() == productId).findFirst();
            try {
                productToOrder = productToOrderOptional.get();
                orderedProducts.add(productToOrder);
            } catch (Exception e) {
                throw e;
            }
            finally {
                continue;
            }
        }

        Order result = new Order(randomId, orderedProducts);
        shopService.addOrder(result);
        return shopService.listOrders();
    }

}
