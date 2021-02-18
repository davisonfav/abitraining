package com.training.crud;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CustomerRequest {

    @NotEmpty
    private String name;

    @NotNull
    private Boolean active;

    @NotEmpty
    private String customerId;

    private DeliveryAddress deliveryAddress;

    public CustomerRequest(String CustomerId, String name, Boolean active, DeliveryAddress deliveryAddress) {
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
