package com.jiaxin.carts.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddProductsResult {

    @JsonProperty("product_id")
    private int productID;

    @JsonProperty("product_name")
    private String productName;

    private int quantity;

    private long price;


    public AddProductsResult(int productID, String productName, int quantity, long price) {
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public AddProductsResult() {

    }
}
