package com.springbootacademy.batch8.pos.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "customer")
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
public class Customer {
    @Id
    @Column(name = "customer_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerid;

    @Column(name = "customer_name",length = 100,nullable = false)
    private String customerName;

    @Column(name = "customer_address",length = 255)
    private String customerAddress;

    @Column(name = "customer_salary")
    private double customerSalary;

    @Type(type = "json")
    @Column(name = "contact_numbers",columnDefinition = "json")
    private ArrayList contactNumber;

    @Column(name = "nic")
    private String nic;

    @Column(name = "active_state",columnDefinition = "TINYINT default 0 ")
    private boolean active;

    public Customer() {
    }

    public Customer(int customerid, String customerName, String customerAddress, double customerSalary, ArrayList contactNumber, String nic, boolean active) {
        this.customerid = customerid;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.contactNumber = contactNumber;
        this.nic = nic;
        this.active = active;
    }

    public Customer(int customerid, String customerName) {
        this.customerid = customerid;
        this.customerName = customerName;
    }

    public int getCustomerid() {
        return customerid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public ArrayList getContactNumber() {
        return contactNumber;
    }

    public String getNic() {
        return nic;
    }

    public boolean isActive() {
        return active;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public void setContactNumber(ArrayList contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerid=" + customerid +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalary=" + customerSalary +
                ", contactNumber=" + contactNumber +
                ", nic='" + nic + '\'' +
                ", active=" + active +
                '}';
    }
}
