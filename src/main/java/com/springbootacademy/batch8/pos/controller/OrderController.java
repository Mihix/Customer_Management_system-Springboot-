package com.springbootacademy.batch8.pos.controller;

import com.springbootacademy.batch8.pos.dto.paginated.PaginatedResponseItemDTO;
import com.springbootacademy.batch8.pos.dto.paginated.PaginatedResponseOrderDetails;
import com.springbootacademy.batch8.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch8.pos.dto.request.RequestOrderSaveDTO;
import com.springbootacademy.batch8.pos.service.OrderItemService;
import com.springbootacademy.batch8.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping(path = {"/save"})
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO) {
       String id = orderItemService.addOrderItem(requestOrderSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, 2 +"Successfull", 2),
                HttpStatus.CREATED
        );
    }
    @GetMapping(
            path = {"/get-order-details"},
            params = {"stateType","page","size"}

    )
    public ResponseEntity<StandardResponse> getAllOrderDetails(
            @RequestParam(value = "stateType") String stateType,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50)int size
    ){
       PaginatedResponseOrderDetails p = null;
        if(stateType.equalsIgnoreCase("active") | stateType.equalsIgnoreCase("inactive")){
            boolean status = stateType.equalsIgnoreCase("active") ? true:false;
          p = orderItemService.getAllOrderDetails(status,page,size);
        }
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"SUCCESSFULL",p),
                HttpStatus.OK);
    }
}
