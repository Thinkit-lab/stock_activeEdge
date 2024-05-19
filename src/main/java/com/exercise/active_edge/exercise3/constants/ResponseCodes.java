package com.exercise.active_edge.exercise3.constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public enum ResponseCodes {

    SUCCESSFUL("00","Successful"),
    FAILED("-1", "Failed");

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


    private String code;
    private String message;

}
