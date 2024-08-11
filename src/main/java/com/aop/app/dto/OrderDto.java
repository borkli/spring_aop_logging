package com.aop.app.dto;

import com.aop.app.model.Order;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OrderDto {

    private Long id;
    private String details;
    private Long userId;

    public OrderDto(Order order, long userId) {
        this.id = order.getId();
        this.details = order.getDetails();
        this.userId = userId;
    }
}
