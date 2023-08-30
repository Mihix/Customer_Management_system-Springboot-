package com.springbootacademy.batch8.pos.util.mappers;

import com.springbootacademy.batch8.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch8.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch8.pos.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDTO> entityToDotoList(List<Item> items);//this method use for - entity convert to DTO type

    ItemGetResponseDTO entityToDto(Item item);//It's one the dto , it's not have DTO list

     Item dotoEntity(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> LisDTOtoPage(Page<Item> items);

    //Page<Item> items (this is have something) --->   List<ItemGetResponseDTO> list;
}
