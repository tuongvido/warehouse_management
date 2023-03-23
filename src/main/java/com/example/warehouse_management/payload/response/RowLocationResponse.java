package com.example.warehouse_management.payload.response;

import com.example.warehouse_management.models.type.EStatusStorage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RowLocationResponse {
    private Long id;
    private String code;
    private String name;
    private double length;
    private double width;
    private double height;
    private EStatusStorage status;
    private String columnLocationCode;
    private String columnLocationName;
}
