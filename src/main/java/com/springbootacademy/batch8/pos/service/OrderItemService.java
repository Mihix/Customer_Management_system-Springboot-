package com.springbootacademy.batch8.pos.service;

import com.springbootacademy.batch8.pos.dto.paginated.PaginatedResponseItemDTO;
import com.springbootacademy.batch8.pos.dto.paginated.PaginatedResponseOrderDetails;
import com.springbootacademy.batch8.pos.dto.request.RequestOrderSaveDTO;

public interface OrderItemService {
    String addOrderItem(RequestOrderSaveDTO requestOrderSaveDTO);


    PaginatedResponseOrderDetails getAllOrderDetails(boolean status, int page, int size);
}
