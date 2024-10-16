package com.jiaxin.carts.service.impl;

import com.jiaxin.carts.entity.Cart;
import com.jiaxin.carts.entity.User;
import com.jiaxin.carts.exception.IllegalRequestException;
import com.jiaxin.carts.repository.CartItemRepository;
import com.jiaxin.carts.repository.CartRepository;
import com.jiaxin.carts.repository.ProductRepository;
import com.jiaxin.carts.repository.UserRepository;
import com.jiaxin.carts.service.PriceCalculateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class CartServiceImplTest {
    @Mock
    private CartRepository cartRepository;

    @Mock
    private CartItemRepository cartItemRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PriceCalculateService priceCalculateService;

    @InjectMocks
    private CartServiceImpl cartServiceImpl;



    @Test
    void should_success_call_getCartItemsListByUserID_when_data_combined() {
        when(userRepository.findUserByUserID(anyInt())).thenReturn(new User());
        when(cartRepository.getCartByUserID(anyInt())).thenReturn(new Cart());
        when(cartItemRepository.findCartItemsByCartID(anyInt())).thenReturn(new ArrayList<>());
        assertNotNull(cartServiceImpl.getCartItemsListByUserID(1));
    }

    @Test
    void should_throw_exception_call_getCartItemsListByUserID_when_user_id_wrong() {
        assertThrows(IllegalRequestException.class, () -> cartServiceImpl.getCartItemsListByUserID(-1));
    }

}