package com.exercise.active_edge.exercise3.service;

import com.exercise.active_edge.exercise3.entity.Stock;
import com.exercise.active_edge.exercise3.model.BaseResponse;
import com.exercise.active_edge.exercise3.model.StockRequest;

import java.math.BigDecimal;
import java.util.List;

public interface StockService {
    BaseResponse<?> getAllStocks();
    BaseResponse<?> getStockById(Long id);
    BaseResponse<?> createStock(StockRequest stock);
    BaseResponse<?> updateStockPrice(Long id, BigDecimal newPrice);
}
