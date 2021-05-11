package edu.miu.ecommerce.domain;

public enum OrderStatus {

    SHIPPED("Shipped"), CANCELLED("Cancelled"), DELIVERED("Delivered");

    private String status;

    OrderStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }
}
