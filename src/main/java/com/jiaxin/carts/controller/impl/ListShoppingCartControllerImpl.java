package com.jiaxin.carts.controller.impl;

import com.jiaxin.carts.common.base.ApiStatusCode;
import com.jiaxin.carts.common.base.AppResponse;
import com.jiaxin.carts.controller.ListShoppingCartController;
import com.jiaxin.carts.model.Cart;
import com.jiaxin.carts.model.CartItem;
import com.jiaxin.carts.model.User;
import com.jiaxin.carts.service.CartItemService;
import com.jiaxin.carts.service.CartService;
import com.jiaxin.carts.service.PriceCalculateService;
import com.jiaxin.carts.service.UserService;
import com.jiaxin.carts.view.CartItemsListResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class ListShoppingCartControllerImpl implements ListShoppingCartController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private PriceCalculateService priceCalculateService;

    @GetMapping("list/{userID}")
    @Override
    public AppResponse getShoppingCartByUserID(@PathVariable int userID) {
        User user = userService.findUserByUserID(userID);
        Cart cart = cartService.getCartByUserID(user.getUserID());
        List<CartItem> cartItems = cartItemService.getCartItemByCartID(cart.getCartID());
        double totalPrice = priceCalculateService.calculateTotalPrice(cartItems);
        CartItemsListResult cartItemsListResult = new CartItemsListResult();
        cartItemsListResult.setCartItems(cartItems);
        cartItemsListResult.setTotalPrice(totalPrice);
        cartItemsListResult.setBelongTo(user.getUserName());
        return new AppResponse(ApiStatusCode.SUCCESS_200.getCode(),
                ApiStatusCode.SUCCESS_200.getDescription(), cartItemsListResult);
    }
}
