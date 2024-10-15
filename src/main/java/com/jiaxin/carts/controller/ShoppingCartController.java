package com.jiaxin.carts.controller;

import com.jiaxin.carts.common.base.AppResponse;
import com.jiaxin.carts.common.param.AddProductsRequest;

public interface ShoppingCartController {
    AppResponse getShoppingCartByUserID(int userID);

    AppResponse addProductsToCart(AddProductsRequest addProductsRequest);

}
