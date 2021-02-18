package com.training.crud;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer {

    @Id
    private String customerId;
    private String name;
    private Boolean active;
    private DeliveryAddress deliveryAddress;

    public Customer() {

    }

    public Customer(String customerId, String name, Boolean active, DeliveryAddress deliveryAddress) {
        this.customerId = customerId;
        this.name = name;
        this.active = active;
        this.deliveryAddress = deliveryAddress;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
