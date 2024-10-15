package com.jiaxin.carts.common.param;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


/**
 * 加入商品到购物车
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AddProductsRequest {

    @JsonProperty("user_id")
    @NotNull
    @Min(value = 1, message = "illegal value for a userID")
    private int userID;

    @JsonProperty("product_id")
    @NotNull
    @Min(value = 1, message = "illegal value for a productID")
    private int productID;

    @NotNull
    @Min(value = 1, message = "illegal value for a quantity")
    private int quantity;
}
