package com.jiaxin.carts.results;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jiaxin.carts.results.enums.ProductsOperationType;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductsOperationResult {

    @JsonProperty("operation_type")
    private ProductsOperationType operationType;

    @JsonProperty("operator_id")
    private int operator;
    @JsonProperty("product_id")
    private int productID;

    @JsonProperty("success")
    private boolean isSuccess;


    public ProductsOperationResult(ProductsOperationType operationType, int operator, int productID, boolean isSuccess) {
        this.operationType = operationType;
        this.operator = operator;
        this.productID = productID;
        this.isSuccess = isSuccess;
    }

    public ProductsOperationResult() {

    }

}
