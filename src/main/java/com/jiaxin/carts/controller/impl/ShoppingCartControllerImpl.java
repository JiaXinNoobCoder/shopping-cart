package com.jiaxin.carts.controller.impl;

import com.jiaxin.carts.common.base.enums.ApiStatusCode;
import com.jiaxin.carts.common.base.AppResponse;
import com.jiaxin.carts.common.param.AddProductsRequest;
import com.jiaxin.carts.common.param.ClearAllProductsRequest;
import com.jiaxin.carts.common.param.RemoveProductsRequest;
import com.jiaxin.carts.common.param.UpdateQuantityOfProductsRequest;
import com.jiaxin.carts.controller.ShoppingCartController;
import com.jiaxin.carts.service.CartService;
import com.jiaxin.carts.results.CartItemsListResult;
import com.jiaxin.carts.results.ProductsOperationResult;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

    @PostMapping("products/add")
    @Override
    public AppResponse addProductsToCart(@Valid @RequestBody AddProductsRequest addProductsRequest) {
        ProductsOperationResult productsOperationResult = cartService.doAddProducts(addProductsRequest);
        return AppResponse.buildSuccess(productsOperationResult, ApiStatusCode.SUCCESS_200);
    }

    @PostMapping("products/delete")
    @Override
    public AppResponse removeProductsFromCart(@Valid @RequestBody RemoveProductsRequest removeProductsRequest) {
        ProductsOperationResult productsOperationResult = cartService.doRemoveProducts(removeProductsRequest);
        return AppResponse.buildSuccess(productsOperationResult, ApiStatusCode.SUCCESS_200);
    }
    @PatchMapping("products/update")
    @Override
    public AppResponse UpdateQuantityOfProducts(@Valid @RequestBody UpdateQuantityOfProductsRequest updateQuantityOfProductsRequest) {
        ProductsOperationResult productsOperationResult = cartService.doUpdateQuantityOfProducts(updateQuantityOfProductsRequest);
        return AppResponse.buildSuccess(productsOperationResult, ApiStatusCode.SUCCESS_200);
    }
    @PostMapping("clear")
    @Override
    public AppResponse ClearAllProducts(@Valid @RequestBody ClearAllProductsRequest clearAllProductsRequest) {
        cartService.doClearAllProducts(clearAllProductsRequest);
        return AppResponse.buildSuccess(ApiStatusCode.SUCCESS_200);
    }


}
