package edu.miu.ecommerce.domain;

import javax.persistence.AttributeConverter;
import java.util.stream.Stream;

public class OrderStatusConverter implements AttributeConverter<OrderStatus,String> {
    @Override
    public String convertToDatabaseColumn(OrderStatus orderStatus) {
        if (orderStatus == null){
            return null;
        }
        return orderStatus.getStatus();
    }

    @Override
    public OrderStatus convertToEntityAttribute(String orderStatus) {
        if (orderStatus == null){
            return null;
        }
        return Stream.of(OrderStatus.values())
                .filter(c -> c.getStatus().equals(orderStatus))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
