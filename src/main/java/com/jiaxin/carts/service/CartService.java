package com.jiaxin.carts.service;

import com.jiaxin.carts.common.param.AddProductsRequest;
import com.jiaxin.carts.view.AddProductsResult;
import com.jiaxin.carts.view.CartItemsListResult;
public interface CartService {
    CartItemsListResult getCartItemsListByUserID(int userID);

    AddProductsResult doAddProducts(AddProductsRequest addProductsRequest);

}
