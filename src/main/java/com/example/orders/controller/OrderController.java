package com.example.orders.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class OrderController {

    // Model đơn giản (Class nội bộ cho gọn)
    class Order {
        public String id;
        public String product;
        public double price;
        public String status;

        public Order(String product, double price) {
            this.id = UUID.randomUUID().toString();
            this.product = product;
            this.price = price;
            this.status = "PENDING";
        }
    }

    @GetMapping("/api/orders")
    public List<Order> getOrders() {
        // Giả lập việc lấy dữ liệu (tạo object tốn RAM và một chút CPU để serialize JSON)
        List<Order> orders = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            orders.add(new Order("Product " + i, 100.0 + i));
        }
        // Spring Boot sẽ tự động chuyển List này thành JSON
        return orders;
    }
}