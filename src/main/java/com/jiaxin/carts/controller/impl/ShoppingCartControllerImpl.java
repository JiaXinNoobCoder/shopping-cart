package com.jiaxin.carts.controller.impl;

import com.jiaxin.carts.common.base.ApiStatusCode;
import com.jiaxin.carts.common.base.AppResponse;
import com.jiaxin.carts.common.param.AddProductsRequest;
import com.jiaxin.carts.controller.ShoppingCartController;
import com.jiaxin.carts.service.CartService;
import com.jiaxin.carts.view.AddProductsResult;
import com.jiaxin.carts.view.CartItemsListResult;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class ShoppingCartControllerImpl implements ShoppingCartController {
    @Autowired
    private CartService cartService;
    @GetMapping("list/{userID}")
    @Override
    public AppResponse getShoppingCartByUserID(@PathVariable int userID) {
        CartItemsListResult cartItemsListResult = cartService.getCartItemsListByUserID(userID);
        return AppResponse.buildSuccess(cartItemsListResult, ApiStatusCode.SUCCESS_200);
    }

    @PostMapping("add")
    @Override
    public AppResponse addProductsToCart(@Valid @RequestBody AddProductsRequest addProductsRequest) {
        AddProductsResult addProductsResult = cartService.doAddProducts(addProductsRequest);
        return AppResponse.buildSuccess(addProductsResult, ApiStatusCode.SUCCESS_200);
    }




}
