package com.isa.pharmacy.domain;

import com.isa.pharmacy.domain.enums.OrderOfferType;
import com.isa.pharmacy.users.domain.Supplier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class SupplierOffer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Order order;
    @OneToMany
    private List<OrderOffer> orderOffer;
    @Column
    private OrderOfferType type;
    @ManyToOne
    private Supplier supplier;

    public  SupplierOffer(){}

    public SupplierOffer(Long id, Order order, List<OrderOffer> orderOffer, OrderOfferType type, Supplier supplier) {
        this.id = id;
        this.order = order;
        this.orderOffer = orderOffer;
        this.type = type;
        this.supplier = supplier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderOffer> getOrderOffer() {
        return orderOffer;
    }

    public void setOrderOffer(List<OrderOffer> orderOffer) {
        this.orderOffer = orderOffer;
    }

    public OrderOfferType getType() {
        return type;
    }

    public void setType(OrderOfferType type) {
        this.type = type;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
