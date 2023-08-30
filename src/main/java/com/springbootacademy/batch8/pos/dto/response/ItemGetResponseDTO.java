package com.springbootacademy.batch8.pos.dto.response;

import com.springbootacademy.batch8.pos.entity.enums.MeausringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemGetResponseDTO {
    private int itemId;
    private String itemName;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean active;
}
