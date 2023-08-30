package com.springbootacademy.batch8.pos.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orderitem")
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
public class OrderItem {
    @Id
    @Column(name = "orderitem_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderitemid;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customers;//Many to One

    @Column(name = "orderitem_date",columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "total",nullable = false)
    private double total;

    @Column(name = "active_state",columnDefinition = "TINYINT default 0 ")
    private boolean active;

    @OneToMany(mappedBy="orderItems")
    private Set<OrderItemsDetails> orderItemsDetails;


    public OrderItem(Customer customers, Date date, double total) {
        this.customers = customers;
        this.date = date;
        this.total = total;

    }
//    @OneToMany(mappedBy="orderitems")
//    private Set<OrderItemsDetails> orderItemsDetails;

//
//    public OrderItem(Customer customers, Date date, double total) {
//        this.customers = customers;
//        this.date = date;
//        this.total = total;
//    }
}
