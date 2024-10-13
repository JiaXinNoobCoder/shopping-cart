package com.jiaxin.carts.controller;

import com.jiaxin.carts.common.base.AppResponse;

public interface ListShoppingCartController {
    AppResponse getShoppingCartByUserID(int userID);

}
