package com.springbootacademy.batch8.pos.service.impl;

import com.springbootacademy.batch8.pos.dto.CustomerDTO;
import com.springbootacademy.batch8.pos.dto.request.CustomerUpdateDTO;
import com.springbootacademy.batch8.pos.entity.Customer;
import com.springbootacademy.batch8.pos.exception.NotFoundException;
import com.springbootacademy.batch8.pos.repo.CustomerRepo;
import com.springbootacademy.batch8.pos.service.CustomerService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {

        Customer customer = new Customer(
                customerDTO.getCustomerid(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getContactNumber(),
                customerDTO.getNic(),
                customerDTO.isActive()
        );
        customerRepo.save(customer);
        return customerDTO.getCustomerName();


//
//        Customer customer = new Customer();
//        customer.setCustomerId(customerDTO.getcustomerId) , this is another right path to access customer data
//
//        customerRepo.save(customer);
//      return customerDTO.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerid())) {

            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerid());//get the all the data ex -customername ,
            //custmerAddress etc
            customer.setCustomerName(customerUpdateDTO.getCustomerName());//update the Name
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());//update the address
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());//update the salary

            customerRepo.save(customer);
            return
                    customerUpdateDTO.getCustomerName() + " updated Successfull";

        } else {
            throw new RuntimeException("no data found");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)) { // check the Id in database
            Customer customer = customerRepo.getReferenceById(customerId); //Retrieve the all data
            CustomerDTO customerDTO = new CustomerDTO( //customer data convert to CustomerDTO
                    customer.getCustomerid(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );
            return customerDTO; //return the data

        } else {
            throw new RuntimeException("No Customer");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {

        List<Customer> getAllCustomers = customerRepo.findAll();

        if (getAllCustomers.size() > 0) {//it has 10 data
            List<CustomerDTO> customerDTOList = new ArrayList<>();

            for (Customer customer : getAllCustomers) {
                CustomerDTO customerDTO = new CustomerDTO(
                        customer.getCustomerid(),
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getCustomerSalary(),
                        customer.getContactNumber(),
                        customer.getNic(),
                        customer.isActive()
                );
                customerDTOList.add(customerDTO);
            }
            return customerDTOList;
        } else {
            throw new NotFoundException("No data found");
        }
    }

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return "deleted successfull" + customerId;
        } else {
            throw new RuntimeException("No customer Found in that Id");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomersByActivestate(boolean activeState) {
        List<Customer> getAllCustomers = customerRepo.findAllByActiveEquals(activeState);//it has 10 data

        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : getAllCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerid(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

}
