package com.example.warehouse_management.payload.request.shelf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ShelveStorageRequestSave {
    private String code;
    private String name;
    private double width;
    private double length;
    private double height;
    private String warehouseCode;
}
