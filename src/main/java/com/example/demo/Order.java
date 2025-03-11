package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @EmbeddedId
    private OrderId id;

    @Embedded
    private CustomerId customerId;
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany
    private List<LineItem> lineItems;

    enum Status {
        CREATED,
        IN_PROGRESS,
    }

    @Entity
    public record LineItem(@Id UUID lineItemId,String description,int quantity) {}
    @Embeddable
    public record  OrderId (UUID orderId) implements Serializable {}

    public record CustomerId(String customerId,String firstName,String lastName) {}
}
