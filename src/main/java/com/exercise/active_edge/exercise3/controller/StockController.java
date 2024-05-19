package com.exercise.active_edge.exercise3.controller;

import com.exercise.active_edge.exercise3.model.BaseResponse;
import com.exercise.active_edge.exercise3.model.StockRequest;
import com.exercise.active_edge.exercise3.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

import static com.exercise.active_edge.exercise3.constants.ResponseStatuses.FAILED;

@RestController
@RequestMapping("/api/v1/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping
    public ResponseEntity<BaseResponse<?>> getAllStocks() {
        BaseResponse<?> baseResponse = stockService.getAllStocks();
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<?>> getStockById(@PathVariable Long id) {
        BaseResponse<?> baseResponse = stockService.getStockById(id);

        if (baseResponse.getStatus().equals(FAILED)) {
            return new ResponseEntity<>(baseResponse, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BaseResponse<?>> createStock(@RequestBody StockRequest stock) {
        BaseResponse<?> baseResponse = stockService.createStock(stock);

        if (baseResponse.getStatus().equals(FAILED)) {
            return new ResponseEntity<>(baseResponse, HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<?>> updateStockPrice(@PathVariable Long id, @RequestParam(name = "newPrice") BigDecimal newPrice) {
        BaseResponse<?> updatedStock = stockService.updateStockPrice(id, newPrice);

        if (updatedStock.getStatus().equals(FAILED)) {
            return new ResponseEntity<>(updatedStock, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(updatedStock, HttpStatus.OK);
    }
}
