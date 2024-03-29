package com.example.warehouse_management.controllers;

import com.example.warehouse_management.payload.request.bin.BinLocationMoveToRequest;
import com.example.warehouse_management.payload.request.bin.BinLocationRequest;
import com.example.warehouse_management.payload.request.goods.GoodsCheckedRequest;
import com.example.warehouse_management.payload.request.goods.GoodsCreatedReceiptVoucherRequest;
import com.example.warehouse_management.payload.request.bin.StatusRequest;
import com.example.warehouse_management.payload.response.BinPositionResponse;
import com.example.warehouse_management.services.BinLocationServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/bin-location")
public class BinPositionController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private BinLocationServices binLocationServices;
    @PostMapping("/add")
    public ResponseEntity<BinPositionResponse> addRowLocation(@RequestBody BinLocationRequest request){
        logger.info("/add");
        return new ResponseEntity(binLocationServices.addRowLocations(request), HttpStatus.OK);
    }
    @GetMapping("/get-page")
    public ResponseEntity<Page<BinPositionResponse>>getAll(@RequestParam Integer page, @RequestParam Integer size){
        logger.info("/get-page");
        return new ResponseEntity(binLocationServices.getPage(page,size), HttpStatus.OK);
    }
    @GetMapping("/get-by/{code}")
    public ResponseEntity<BinPositionResponse>getByCode(@PathVariable String code){
        logger.info("/get-by"+code);
        return new ResponseEntity(binLocationServices.getByCode(code), HttpStatus.OK);
    }
    @PostMapping("/filter-status-by/{codeWarehouse}")
    public ResponseEntity<BinPositionResponse>filterByStatus(@PathVariable String codeWarehouse, @RequestBody StatusRequest statusRequest){
        logger.info("/filter-status-by/"+codeWarehouse);
        return new ResponseEntity(binLocationServices.filterStatusByCodeWarehouse(codeWarehouse,statusRequest),HttpStatus.OK);
    }
    @GetMapping("/get-page-by/{codeWarehouse}")
    public ResponseEntity<Page<BinPositionResponse>>getPageByCodeWarehouse(@PathVariable String codeWarehouse, Integer page, Integer size){
        logger.info("/get-page-by/"+codeWarehouse);
        return new ResponseEntity(binLocationServices.getPageRowLocationByWarehouseCode(codeWarehouse,page,size),HttpStatus.OK);
    }
    @GetMapping("/report-stock-position/{codeWarehouse}")
    public ResponseEntity<?>reportStockPosition(@PathVariable String codeWarehouse){
        logger.info("/report-stock-position"+codeWarehouse);
        return new ResponseEntity<>(binLocationServices.reportStockPosition(codeWarehouse),HttpStatus.OK);
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<BinPositionResponse>>getAll(){
        logger.info("/get-all");
        return new ResponseEntity(binLocationServices.getAll(), HttpStatus.OK);
    }
    @GetMapping("/get-all-by/{codeWarehouse}")
    public ResponseEntity<BinPositionResponse>getAllByCodeWarehouse(@PathVariable String codeWarehouse){
        logger.info("/get-all-by/"+codeWarehouse);
        return new ResponseEntity(binLocationServices.getAllRowLocationByWarehouseCode(codeWarehouse),HttpStatus.OK);
    }
    @PostMapping("/usable-position-by-goods/{codeWarehouse}")
    public ResponseEntity<List<BinPositionResponse>> getAllUsablePositionForGoods(@PathVariable String codeWarehouse, @Valid  @RequestBody GoodsCreatedReceiptVoucherRequest request){
        logger.info("/usable-position-by-goods/"+codeWarehouse);
        return new ResponseEntity<>(binLocationServices.getAllUsablePositionForGoods(codeWarehouse,request),HttpStatus.OK);
    }
    @PostMapping("/move/{fromBinLocationCode}")
    public ResponseEntity<String> moveBin(@PathVariable String fromBinLocationCode,@RequestBody BinLocationMoveToRequest binLocationMoveToRequest){
        logger.info("/move/"+fromBinLocationCode);
        return new ResponseEntity<>(binLocationServices.moveBin(fromBinLocationCode,binLocationMoveToRequest),HttpStatus.OK);
    }
    @GetMapping("/search/{keyword}")
    public ResponseEntity<Page<BinPositionResponse>> searchByCodeOrName(@PathVariable String keyword, @RequestParam("codeWarehouse") String codeWarehouse,@RequestParam Integer page, @RequestParam Integer size){
        logger.info("/search/"+keyword);
        return new ResponseEntity<>(binLocationServices.search(keyword,codeWarehouse,page, size),HttpStatus.OK);
    }
    @GetMapping("filter-by/{columnLocationCode}")
    public ResponseEntity<List<BinPositionResponse>> filterByColumnCode(@PathVariable String columnLocationCode, @RequestParam("codeWarehouse") String codeWarehouse){
        return new ResponseEntity<>(binLocationServices.filterByColumnLocationCode(columnLocationCode,codeWarehouse),HttpStatus.OK);
    }
    @PostMapping("/check-remaining-volume/{binCode}")
    public ResponseEntity<Boolean>checkRemainingVolume(@PathVariable String binCode ,@RequestBody GoodsCheckedRequest goodsCheckedRequest){
        return new ResponseEntity<>(binLocationServices.checkRemainingVolumeForGoodsByBinCode(binCode,goodsCheckedRequest),HttpStatus.OK);
    }
    @GetMapping("/find-all-by/{goodsCode}")
    public ResponseEntity<List<BinPositionResponse>> findAllByGoodsCode(@PathVariable String goodsCode){
        return new ResponseEntity<>(binLocationServices.findAllByGoodsCode(goodsCode),HttpStatus.OK);
    }
}
