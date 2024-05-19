package com.exercise.active_edge.exercise3.model;

import com.exercise.active_edge.exercise3.constants.ResponseCodes;
import com.exercise.active_edge.exercise3.constants.ResponseStatuses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseResponse<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1078346052270789910L;
    private ResponseStatuses status;
    private String code;
    private String message;
    private T data;

    public static BaseResponse<?> getSuccessResponse(Object data) {
        return new BaseResponse<>(ResponseStatuses.SUCCESS, ResponseCodes.SUCCESSFUL.getCode(), ResponseCodes.SUCCESSFUL.getMessage(), data);
    }

    public static BaseResponse<?> getFailedResponse(String code, String message, Object data) {
        return new BaseResponse<>(ResponseStatuses.FAILED, code, message, data);
    }
}
