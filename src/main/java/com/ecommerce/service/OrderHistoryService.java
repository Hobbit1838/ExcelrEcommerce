package com.ecommerce.service;

import com.ecommerce.model.OrderHistory;
import com.ecommerce.repository.OrderHistoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderHistoryService {
    private final OrderHistoryRepository orderHistoryRepository;

    public OrderHistoryService(OrderHistoryRepository orderHistoryRepository) {
        this.orderHistoryRepository = orderHistoryRepository;
    }

    public List<OrderHistory> getUserOrderHistory(Long userId) {
        return orderHistoryRepository.findByUserId(userId);
    }
}
