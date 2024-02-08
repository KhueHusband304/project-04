package com.fpt.apiservice.requests.Orders;


import com.fpt.apiservice.models.Orders.OrderProductItem;

import java.util.List;

public record OrderRequest (
        String status,

        List<OrderProductItem> products
) {

}
