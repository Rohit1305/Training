package com.aurionpro.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDto {
    private int id;
    private int customerId;
    private int bankId;
    private int typeId;
    private String status;

}
