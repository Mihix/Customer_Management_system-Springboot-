package com.springbootacademy.batch8.pos.controller;


import com.springbootacademy.batch8.pos.dto.paginated.PaginatedResponseItemDTO;
import com.springbootacademy.batch8.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch8.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch8.pos.service.ItemService;
import com.springbootacademy.batch8.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    //    @PostMapping(path = {"/save"})
//    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
//        String  message = itemService.saveItem(itemSaveRequestDTO);
//        return "saved";
//    }
    @PostMapping(path = {"/save"})
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String message = itemService.saveItem(itemSaveRequestDTO);

//        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
//                new StandardResponse(201,"Successfull", message ), HttpStatus.CREATED// Response entity =T type and HTTP status
//        );
//        return response;
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Successfull", message),
                HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public List<ItemGetResponseDTO> getItemByNameAndStatus(@RequestParam("name") String itemName) {
        List<ItemGetResponseDTO> itemDTOs = itemService.getItemByNameAndStatus(itemName);
        return itemDTOs;

    }

    @GetMapping(
            path = "/get-by-name-with-mapstruct",
            params = "name"
    )
    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(@RequestParam("name") String itemName) {
        List<ItemGetResponseDTO> itemDTOs = itemService.getItemByNameAndStatusByMapstruct(itemName);
        return itemDTOs;

    }

    @GetMapping(
            path = "/get-all-item-by-active-state",
            params = "status"
    )
    public ResponseEntity<StandardResponse> getItemsByActiveStatus(
            @RequestParam("status") boolean activeState
    ) {

        List<ItemGetResponseDTO> itemDTOs = itemService.getItemsByActiveStatus(activeState);//go itemService

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "succesfull", itemDTOs), HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/get-all-item-by-active-state",
            params = {"status","page","size"}
    )
    public ResponseEntity<StandardResponse> getItemsByActiveStatus(
            @RequestParam("status") boolean activeState,
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {

        //size = 10;
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getItemByActiveStatusWithPaginated(activeState,page,size);//go itemService
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "succesfull", paginatedResponseItemDTO), HttpStatus.OK
        );
    }
}