package com.jiaxin.carts.service;

import com.jiaxin.carts.common.param.AddProductsRequest;
import com.jiaxin.carts.common.param.ClearAllProductsRequest;
import com.jiaxin.carts.common.param.RemoveProductsRequest;
import com.jiaxin.carts.common.param.UpdateQuantityOfProductsRequest;
import com.jiaxin.carts.results.CartItemsListResult;
import com.jiaxin.carts.results.ProductsOperationResult;

public interface CartService {
    CartItemsListResult getCartItemsListByUserID(int userID);

    ProductsOperationResult doAddProducts(AddProductsRequest addProductsRequest);

    ProductsOperationResult doRemoveProducts(RemoveProductsRequest removeProductsRequest);

    ProductsOperationResult doUpdateQuantityOfProducts(UpdateQuantityOfProductsRequest updateQuantityOfProductsRequest);

    void doClearAllProducts(ClearAllProductsRequest clearAllProductsRequest);

}
