package com.example.warehouse_management.controllers;

import com.example.warehouse_management.payload.request.sale.SaleReceiptRequest;
import com.example.warehouse_management.payload.response.SaleReceiptResponse;
import com.example.warehouse_management.services.SaleReceiptServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/sale-receipt")
public class SaleReceiptController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    SaleReceiptServices saleReceiptServices;
    @PostMapping("/create")
    public ResponseEntity<SaleReceiptResponse>createPurchaseReceipt(@Valid @RequestBody SaleReceiptRequest saleReceiptRequest, Principal principal){
        logger.info("/create");
        saleReceiptRequest.setEmail(principal.getName());
        return new ResponseEntity<>(saleReceiptServices.createSaleReceipt(saleReceiptRequest), HttpStatus.OK);
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<SaleReceiptResponse>>getAll(){
        logger.info("/get-all");
        return new ResponseEntity<>(saleReceiptServices.getAll(),HttpStatus.OK);
    }
    @GetMapping("/get-by/{saleReceiptCode}")
    public ResponseEntity<SaleReceiptResponse>getSaleReceiptByCode(String saleReceiptCode){
        logger.info("/get-by/"+saleReceiptCode);
        return new ResponseEntity<>(saleReceiptServices.getSaleReceiptByCode(saleReceiptCode),HttpStatus.OK);
    }
}
