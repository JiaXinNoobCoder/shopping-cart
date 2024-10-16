package com.jiaxin.carts.service.impl;

import com.jiaxin.carts.common.base.AppChecker;
import com.jiaxin.carts.common.param.AddProductsRequest;
import com.jiaxin.carts.common.param.ClearAllProductsRequest;
import com.jiaxin.carts.common.param.RemoveProductsRequest;
import com.jiaxin.carts.common.param.UpdateQuantityOfProductsRequest;
import com.jiaxin.carts.entity.CartItem;
import com.jiaxin.carts.entity.Product;
import com.jiaxin.carts.entity.User;
import com.jiaxin.carts.repository.CartItemRepository;
import com.jiaxin.carts.repository.CartRepository;
import com.jiaxin.carts.entity.Cart;
import com.jiaxin.carts.repository.ProductRepository;
import com.jiaxin.carts.repository.UserRepository;
import com.jiaxin.carts.service.CartService;
import com.jiaxin.carts.service.PriceCalculateService;
import com.jiaxin.carts.results.CartItemsListResult;
import com.jiaxin.carts.results.ProductsOperationResult;
import com.jiaxin.carts.results.enums.ProductsOperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PriceCalculateService priceCalculateService;

    @Override
    public CartItemsListResult getCartItemsListByUserID(int userID) {
        User user = userRepository.findUserByUserID(userID);
        AppChecker.assertNotNull(user);
        Cart cart = cartRepository.getCartByUserID(user.getUserID());
        AppChecker.assertNotNull(cart);
        List<CartItem> cartItems = cartItemRepository.findCartItemsByCartID(cart.getCartID());
        double totalPrice = priceCalculateService.calculateTotalPrice(cartItems);
        return new CartItemsListResult(user.getUserName(), totalPrice, cartItems);
    }

    @Override
    public ProductsOperationResult doAddProducts(AddProductsRequest addProductsRequest) {
        int productID = addProductsRequest.getProductID();
        Product product = productRepository.findProductByProductID(productID);
        AppChecker.assertNotNull(product);
        Cart cart = cartRepository.getCartByUserIDAndCartID(addProductsRequest.getUserID(), addProductsRequest.getCartID());
        AppChecker.assertNotNull(cart);
        CartItem cartItem = cartItemRepository.findCartItemByCartIDAndProductID(cart.getCartID(), productID);
        if (AppChecker.isNull(cartItem)) { // 做添加操作
            cartItem = new CartItem.Builder().setCartID(cart.getCartID()).setProductID(productID).
                            setProductName(product.getName()).setQuantity(addProductsRequest.getQuantity()).
                              setPrice(product.getPrice()).build();
            CartItem savedCartItem = cartItemRepository.save(cartItem);
            AppChecker.assertNotNull(savedCartItem);
            return new ProductsOperationResult(ProductsOperationType.ADD, addProductsRequest.getUserID(),
                    productID, true);
        }

        // 做更新操作

        int quantity = cartItem.getQuantity();
        cartItem.setQuantity(quantity + addProductsRequest.getQuantity());
        CartItem savedCartItem = cartItemRepository.save(cartItem);
        AppChecker.assertNotNull(savedCartItem);
        return new ProductsOperationResult(ProductsOperationType.ADD, addProductsRequest.getUserID(),
                productID, true);
    }

    @Override
    public ProductsOperationResult doRemoveProducts(RemoveProductsRequest removeProductsRequest) {
        Cart cart = cartRepository.getCartByUserIDAndCartID(removeProductsRequest.getUserID(),
                removeProductsRequest.getCartID());
        AppChecker.assertNotNull(cart);
        CartItem cartItem = cartItemRepository.findCartItemByCartIDAndProductID(cart.getCartID(),
                removeProductsRequest.getProductID());
        AppChecker.assertNotNull(cartItem);
        cartItemRepository.delete(cartItem);
        return new ProductsOperationResult(ProductsOperationType.DELETE, removeProductsRequest.getUserID(),
                removeProductsRequest.getProductID(), true);
    }

    @Override
    public ProductsOperationResult doUpdateQuantityOfProducts(UpdateQuantityOfProductsRequest updateQuantityOfProductsRequest) {
        Cart cart = cartRepository.getCartByUserIDAndCartID(updateQuantityOfProductsRequest.getUserID(),
                updateQuantityOfProductsRequest.getCartID());
        AppChecker.assertNotNull(cart);
        CartItem cartItem = cartItemRepository.findCartItemByCartIDAndProductID(updateQuantityOfProductsRequest.getCartID(),
                updateQuantityOfProductsRequest.getProductID());
        AppChecker.assertNotNull(cartItem);
        int quantity = cartItem.getQuantity();
        quantity += updateQuantityOfProductsRequest.getQuantity();
        AppChecker.assertPositive(quantity);
        cartItem.setQuantity(quantity);
        CartItem save = cartItemRepository.save(cartItem);
        AppChecker.assertNotNull(save);
        return new ProductsOperationResult(ProductsOperationType.UPDATE, updateQuantityOfProductsRequest.getUserID(),
                updateQuantityOfProductsRequest.getProductID(), true);
    }

    @Override
    public void doClearAllProducts(ClearAllProductsRequest clearAllProductsRequest) {
        Cart cart = cartRepository.getCartByUserIDAndCartID(clearAllProductsRequest.getUserID(),
                clearAllProductsRequest.getCartID());
        AppChecker.assertNotNull(cart);
        List<CartItem> cartItems = cartItemRepository.findCartItemsByCartID(cart.getCartID());
        AppChecker.assertNotNull(cartItems);
        cartItemRepository.deleteAll(cartItems);
    }


}
