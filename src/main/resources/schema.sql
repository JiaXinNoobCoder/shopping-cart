CREATE TABLE `shopping_cart`.`user`
(
    `user_id`   int          NOT NULL AUTO_INCREMENT COMMENT '用户唯一标识',
    `user_name` varchar(255) NOT NULL COMMENT '用户名称',
    `email`    varchar(255) NULL COMMENT '用户邮箱',
    PRIMARY KEY (`user_id`)
);

CREATE TABLE `shopping_cart`.`cart`
(
    `cart_id` int NOT NULL AUTO_INCREMENT COMMENT '购物车唯一标识',
    `user_id` int NOT NULL COMMENT '归属的用户ID',
    PRIMARY KEY (`cart_id`),
    UNIQUE (user_id),
    CONSTRAINT `用户ID` FOREIGN KEY (`user_id`) REFERENCES `shopping_cart`.`user` (`user_id`)
);


CREATE TABLE `shopping_cart`.`product`
(
    `product_id` int          NOT NULL AUTO_INCREMENT COMMENT '商品唯一标识',
    `name`      varchar(255) NOT NULL COMMENT '商品名称',
    `price`     bigint       NOT NULL COMMENT '商品价格, 单位为分',
    PRIMARY KEY (`product_id`)
);

CREATE TABLE `shopping_cart`.`cart_item`
(
    `cart_item_id` int NOT NULL AUTO_INCREMENT COMMENT '购物车和商品关联记录ID',
    `cart_id`     int NOT NULL COMMENT '关联的购物车ID',
    `product_id`  int NOT NULL COMMENT '关联的商品ID',
    `product_name` varchar(255) NOT NULL COMMENT '关联的商品名称',
    `price` bigint NOT NULL COMMENT '关联的商品价格, 单位为分',
    `quantity`   int NOT NULL COMMENT '商品数量',
    PRIMARY KEY (`cart_item_id`),
    CONSTRAINT `购物车ID` FOREIGN KEY (`cart_id`) REFERENCES `shopping_cart`.`cart` (`cart_id`),
    CONSTRAINT `商品ID` FOREIGN KEY (`product_id`) REFERENCES `shopping_cart`.`product` (`product_id`)
);

