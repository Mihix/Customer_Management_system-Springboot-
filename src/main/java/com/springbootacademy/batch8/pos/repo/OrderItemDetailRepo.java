package com.springbootacademy.batch8.pos.repo;

import com.springbootacademy.batch8.pos.entity.OrderItem;
import com.springbootacademy.batch8.pos.entity.OrderItemsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OrderItemDetailRepo extends JpaRepository<OrderItemsDetails,Integer> {
}
