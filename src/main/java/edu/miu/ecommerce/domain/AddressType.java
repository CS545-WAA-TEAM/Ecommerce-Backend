package edu.miu.ecommerce.domain;

public enum AddressType {

    BILLING("Billing"), SHIPPING("SHIPPING");

    private String type;

    AddressType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
}
