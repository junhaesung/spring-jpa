package com.nhn.edu.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NamedEntityGraphs({
        @NamedEntityGraph(name = "orderWithCustomer", attributeNodes = {
                @NamedAttributeNode("customer")
        }),
        @NamedEntityGraph(name = "orderWithOrderItems", attributeNodes = {
                @NamedAttributeNode("orderItems")
        }),
        @NamedEntityGraph(name = "orderWithCustomerAndOrderItems", attributeNodes = {
                @NamedAttributeNode("customer"),
                @NamedAttributeNode("orderItems")
        }),
        @NamedEntityGraph(name = "orderWithCustomerAndOrderItemsAndItem", attributeNodes = {
                @NamedAttributeNode("customer"),
                @NamedAttributeNode(value = "orderItems", subgraph = "orderItems")
        }, subgraphs = @NamedSubgraph(name = "orderItems", attributeNodes = {
                @NamedAttributeNode("item")
        }))
})
@Getter
@Setter
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "order_dt")
    private LocalDateTime orderDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItems;

}
