--- 初始化测试数据
INSERT INTO shopping_cart.`user` (user_id, user_name, email) VALUES (1, 'zhangsan', '123@qq.com');
INSERT INTO shopping_cart.`user` (user_id, user_name, email) VALUES (2, 'lisi', '456@qq.com');
INSERT INTO shopping_cart.`user` (user_id, user_name, email) VALUES (3, 'xiaoming', '789@qq.com');

INSERT INTO shopping_cart.`cart` (cart_id, user_id) VALUES (1, 1);
INSERT INTO shopping_cart.`cart` (cart_id, user_id) VALUES (2, 2);
INSERT INTO shopping_cart.`cart` (cart_id, user_id) VALUES (3, 3);

INSERT INTO shopping_cart.`product` (product_id, name, price) VALUES (1, 'product1', 36555);
INSERT INTO shopping_cart.`product` (product_id, name, price) VALUES (2, 'product2', 48777);
INSERT INTO shopping_cart.`product` (product_id, name, price) VALUES (3, 'product3', 69555);