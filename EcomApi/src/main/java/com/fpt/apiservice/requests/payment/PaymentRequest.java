package com.fpt.apiservice.requests.payment;

import java.math.BigDecimal;

public record PaymentRequest (
        String name,
        String type,
        BigDecimal balance
) {

}

