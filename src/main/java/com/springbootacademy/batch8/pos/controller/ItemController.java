package com.springbootacademy.batch8.pos.controller;


import com.springbootacademy.batch8.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch8.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
        String  message = itemService.saveItem(itemSaveRequestDTO);
        return message;
    }
}