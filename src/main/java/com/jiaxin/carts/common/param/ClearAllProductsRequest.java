package com.jiaxin.carts.common.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClearAllProductsRequest {
    @JsonProperty("user_id")
    @NotNull
    @Min(value = 1, message = "illegal value for a userID")
    private int userID;

    @JsonProperty("cart_id")
    @NotNull
    @Min(value = 1, message = "illegal value for a cartID")
    private int cartID;
}
