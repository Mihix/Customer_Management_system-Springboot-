package com.springbootacademy.batch8.pos.dto.request;

public class CustomerUpdateDTO {
    private int customerid;
    private String customerName;
    private String customerAddress;
    private double customerSalary;

    public CustomerUpdateDTO() {
    }

    public CustomerUpdateDTO(int customerid, String customerName, String customerAddress, double customerSalary) {
        this.customerid = customerid;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    @Override
    public String toString() {
        return "CustomerUpdateDTO{" +
                "customerid=" + customerid +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalary=" + customerSalary +
                '}';
    }
}
