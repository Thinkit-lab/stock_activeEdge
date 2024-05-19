package com.exercise.active_edge.exercise3.service;

import com.exercise.active_edge.exercise3.constants.ResponseCodes;
import com.exercise.active_edge.exercise3.entity.Stock;
import com.exercise.active_edge.exercise3.model.BaseResponse;
import com.exercise.active_edge.exercise3.model.StockRequest;
import com.exercise.active_edge.exercise3.repository.StockRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockServiceImpl implements StockService{

    private final StockRepository stockRepository;

    @PostConstruct
    public void init() {
        stockRepository.save(new Stock(null, "Apple", new BigDecimal("145.30"), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
        stockRepository.save(new Stock(null, "Google", new BigDecimal("2731.45"), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
    }

    @Override
    public BaseResponse<?> getAllStocks() {
        List<Stock> stocks = stockRepository.findAll();
        log.info("List of stock found with size -> {}", stocks.size());
        return BaseResponse.getSuccessResponse(stocks);
    }

    @Override
    public BaseResponse<?> getStockById(Long id) {
        Stock savedStock = stockRepository.findById(id).orElse(null);
        if(savedStock == null) {
            log.info("No stock found with id -> {}", id);
            return BaseResponse.getFailedResponse(ResponseCodes.FAILED.getCode(), "No stock found for provided id", null);
        }

        log.info("savedStock -> {}", savedStock);
        return BaseResponse.getSuccessResponse(savedStock);
    }

    @Override
    public BaseResponse<?> createStock(StockRequest stockRequest) {
        log.info("In createStock with request -> {}", stockRequest);
        Stock existingStock = stockRepository.findByName(stockRequest.getName()).orElse(null);

        if(existingStock != null) {
            log.info("A stock already exist with name {}", stockRequest.getName());
            return BaseResponse.getFailedResponse(ResponseCodes.FAILED.getCode(), "Stock already exists", null);
        }

        Stock newStock = new Stock();
        BeanUtils.copyProperties(stockRequest, newStock);
        newStock.setCreateDate(new Timestamp(System.currentTimeMillis()));
        newStock.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        Stock savedStock = stockRepository.save(newStock);
        BaseResponse<?> response = BaseResponse.getSuccessResponse(savedStock);
        log.info("Stock created with response -> {}", response);
        return response;
    }

    @Override
    public BaseResponse<?> updateStockPrice(Long id, BigDecimal newPrice) {
        Stock stock = stockRepository.findById(id).orElse(null);
        if(stock == null) {
            log.info("No stock with the provided id {} found for update", id);
            return BaseResponse.getFailedResponse(ResponseCodes.FAILED.getCode(), "No stock found to update", null);
        }

        log.info("Updating stock -> {}", stock);
        stock.setCurrentPrice(newPrice);
        stock.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        Stock updatedStock = stockRepository.save(stock);
        log.info("Stock after update -> {}", updatedStock);
        return BaseResponse.getSuccessResponse(updatedStock);
    }
}
