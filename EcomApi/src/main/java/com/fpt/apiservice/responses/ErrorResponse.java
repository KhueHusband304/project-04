package com.fpt.apiservice.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ErrorResponse<T> {

    public String message;
    public T errors;
    public int code;
}
