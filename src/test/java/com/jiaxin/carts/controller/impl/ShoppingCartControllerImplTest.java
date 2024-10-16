package com.jiaxin.carts.controller.impl;

import com.jiaxin.carts.common.param.AddProductsRequest;
import com.jiaxin.carts.exception.IllegalRequestException;
import com.jiaxin.carts.exception.enums.ErrorCode;
import com.jiaxin.carts.results.CartItemsListResult;
import com.jiaxin.carts.results.ProductsOperationResult;
import com.jiaxin.carts.service.CartService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ShoppingCartControllerImplTest {

    @Resource
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartService cartService;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    void should_success_when_get_cart_items_by_user_id() throws Exception {
        when(cartService.getCartItemsListByUserID(anyInt())).thenReturn(new CartItemsListResult());
        mockMvc.perform(MockMvcRequestBuilders.get("/cart/list/1")).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    void should_throw_exception_when_get_cart_items_by_wrong_user_id() throws Exception {
        when(cartService.getCartItemsListByUserID(anyInt())).thenThrow(new IllegalRequestException(ErrorCode.ILLEGAL_REQUEST,
                ErrorCode.ILLEGAL_REQUEST.getMessage()));
        mockMvc.perform(MockMvcRequestBuilders.get("/cart/list/-1")).andExpect(MockMvcResultMatchers.status().is(400))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    void should_success_when_add_products_to_cart() throws Exception {
        when(cartService.doAddProducts(any(AddProductsRequest.class))).thenReturn(new ProductsOperationResult());
        String body = "{\"user_id\":1, \"cart_id\":1, \"product_id\":1, \"quantity\":1}";
        mockMvc.perform(MockMvcRequestBuilders.post("/cart/products/add").
                        contentType(MediaType.APPLICATION_JSON).
                        content(body)).
                andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    void should_throw_exception_when_add_products_to_cart_by_wrong_params() throws Exception {
        String invalidBody = "{\"user_id\":1, \"cart_id\":1, \"product_id\":1, \"quantity\":-1}";
        mockMvc.perform(MockMvcRequestBuilders.post("/cart/products/add").
                        contentType(MediaType.APPLICATION_JSON).
                        content(invalidBody)).
                andExpect(MockMvcResultMatchers.status().is(400))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}