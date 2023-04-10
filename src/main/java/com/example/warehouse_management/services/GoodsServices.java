package com.example.warehouse_management.services;

import com.example.warehouse_management.models.goods.Goods;
import com.example.warehouse_management.payload.request.GoodsAddRequest;
import com.example.warehouse_management.payload.request.GoodsRequest;
import com.example.warehouse_management.payload.response.GoodsResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GoodsServices {
    public GoodsResponse addGoods(GoodsAddRequest goodsRequest);
    public Goods createGoods(GoodsRequest goodsRequest);
    public Page<GoodsResponse> getAll(Integer page, Integer size);
    public GoodsResponse getByCode(String code);
    public List<GoodsResponse> searchByCodeOrName(String keyword);
    public Goods findGoodByCode(String code);
    public Goods findGoodByName(String name);
    public GoodsResponse mapperGoods(Goods goods);
    public List<GoodsResponse> getAllByCategoryCode(String categoryCode);
}
