package com.jiaxin.carts.controller;

import com.jiaxin.carts.common.base.AppResponse;
import com.jiaxin.carts.common.param.AddProductsRequest;
import com.jiaxin.carts.common.param.ClearAllProductsRequest;
import com.jiaxin.carts.common.param.RemoveProductsRequest;
import com.jiaxin.carts.common.param.UpdateQuantityOfProductsRequest;

public interface ShoppingCartController {
    AppResponse getShoppingCartByUserID(int userID);

    AppResponse addProductsToCart(AddProductsRequest addProductsRequest);

    AppResponse removeProductsFromCart(RemoveProductsRequest removeProductsRequest);

    AppResponse UpdateQuantityOfProducts(UpdateQuantityOfProductsRequest updateQuantityOfProductsRequest);

    AppResponse ClearAllProducts(ClearAllProductsRequest clearAllProductsRequest);

}
