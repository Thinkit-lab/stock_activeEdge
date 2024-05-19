package com.exercise.active_edge.exercise3.model;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockRequest {
    private String name;
    @Min(value = 1, message = "Current price must be greater than 0")
    private BigDecimal currentPrice;
}
