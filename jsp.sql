/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : jsp

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 27/04/2022 12:32:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '扇名',
  `price` decimal(10, 2) NOT NULL COMMENT '价格',
  `pro_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '促销价',
  `inventory` int NOT NULL COMMENT '库存',
  `sales` int NOT NULL COMMENT '销售数量',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片',
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '类别',
  `fan_material` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '扇面材质',
  `fan_bone_material` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '扇骨材质',
  `fan_bone_num` int NOT NULL COMMENT '扇骨数量',
  `fan_bone_length` int NOT NULL COMMENT '扇骨长度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '油漆边双色龙骨扇_粉色', 40.00, 18.00, 14, 86, '1.jpg', '日式女扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (2, '油漆边双色龙骨扇_红色', 50.00, 18.00, 95, 5, '2.jpg', '日式女扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (3, '油漆边双色龙骨扇_蓝色', 40.00, 17.00, 91, 9, '3.jpg', '仿古男扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (4, '油漆边双色龙骨扇_紫色', 40.00, 16.00, 81, 19, '4.jpg', '仿古男扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (5, '短梢手绘折扇_梅花', 60.00, 18.00, 71, 29, '5.jpg', '仿古男扇', '绢', '头青加厚', 12, 22);
INSERT INTO `product` VALUES (6, '短梢手绘折扇_桃花', 80.00, 20.00, 50, 50, '6.jpg', '日式女扇', '绢', '头青加厚', 12, 22);
INSERT INTO `product` VALUES (7, '7', 40.00, 18.00, 14, 86, '7.jpg', '日式女扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (8, '8', 40.00, 18.00, 14, 86, '8.jpg', '日式女扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (9, '9', 50.00, 18.00, 95, 5, '9.jpg', '日式女扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (10, '10', 40.00, 17.00, 91, 9, '10.jpg', '仿古男扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (11, '11', 40.00, 16.00, 81, 19, '11.jpg', '仿古男扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (12, '12', 60.00, 18.00, 71, 29, '12.jpg', '仿古男扇', '绢', '头青加厚', 12, 22);
INSERT INTO `product` VALUES (13, '13', 80.00, 20.00, 50, 50, '13.jpg', '日式女扇', '绢', '头青加厚', 12, 22);
INSERT INTO `product` VALUES (14, '14', 40.00, 18.00, 14, 86, '14.jpg', '日式女扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (15, '15', 40.00, 18.00, 14, 86, '15.jpg', '韩国扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (16, '16', 50.00, 18.00, 95, 5, '16.jpg', '韩国扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (17, '17', 40.00, 17.00, 91, 9, '17.jpg', '仿古男扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (18, '18', 40.00, 16.00, 81, 19, '18.jpg', '仿古男扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (19, '19', 60.00, 18.00, 71, 29, '19.jpg', '仿古男扇', '绢', '头青加厚', 12, 22);
INSERT INTO `product` VALUES (20, '20', 80.00, 20.00, 50, 50, '20.jpg', '仿古男扇', '绢', '头青加厚', 12, 22);
INSERT INTO `product` VALUES (21, '21', 40.00, 18.00, 14, 86, '21.jpg', '韩国扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (22, '22', 40.00, 18.00, 14, 86, '22.jpg', '韩国扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (23, '23', 50.00, 18.00, 95, 5, '23.jpg', '韩国扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (24, '24', 40.00, 17.00, 91, 9, '24.jpg', '韩国扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (25, '25', 40.00, 16.00, 81, 19, '25.jpg', '韩国扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (26, '26', 60.00, 18.00, 71, 29, '26.jpg', '檀香扇', '绢', '头青加厚', 12, 22);
INSERT INTO `product` VALUES (27, '27', 80.00, 20.00, 50, 50, '27.jpg', '韩国扇', '绢', '头青加厚', 12, 22);
INSERT INTO `product` VALUES (28, '28', 40.00, 18.00, 14, 86, '28.jpg', '韩国扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (29, '29', 40.00, 18.00, 14, 86, '29.jpg', '檀香扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (30, '30', 50.00, 18.00, 95, 5, '30.jpg', '檀香扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (31, '31', 40.00, 17.00, 91, 9, '31.jpg', '檀香扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (32, '32', 40.00, 16.00, 81, 19, '32.jpg', '檀香扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (33, '33', 60.00, 18.00, 71, 29, '33.jpg', '檀香扇', '绢', '头青加厚', 12, 22);
INSERT INTO `product` VALUES (34, '34', 80.00, 20.00, 50, 50, '34.jpg', '礼品广告扇', '绢', '头青加厚', 12, 22);
INSERT INTO `product` VALUES (35, '35', 50.00, 18.00, 95, 5, '35.jpg', '礼品广告扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (36, '36', 40.00, 17.00, 91, 9, '36.jpg', '礼品广告扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (37, '37', 40.00, 16.00, 81, 19, '37.jpg', '礼品广告扇', '绢', '头青加厚', 8, 20);
INSERT INTO `product` VALUES (38, '38', 60.00, 18.00, 71, 29, '38.jpg', '礼品广告扇', '绢', '头青加厚', 12, 22);
INSERT INTO `product` VALUES (39, '39', 80.00, 20.00, 50, 50, '39.jpg', '礼品广告扇', '绢', '头青加厚', 12, 22);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `passwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '性别',
  `hobby` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '爱好',
  `online` int NOT NULL DEFAULT 0 COMMENT '0下线 1在线',
  `shopping_cart` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '购物车中商品ID',
  `balance` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '余额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', '男', '爬山,钓鱼', 1, '2,2,2,5,2,2,2,2,2,6,6,6,6,6,6,6,6,6,6,1,34', 10000.00);
INSERT INTO `user` VALUES (2, 'wk', '654321', '男', '爬山,钓鱼', 1, '2,3', 10000.00);
INSERT INTO `user` VALUES (13, '12', '12', '男', '爬山,钓鱼', 1, '2', 10000.00);
INSERT INTO `user` VALUES (15, '1212', '121212', '男', '爬山,钓鱼', 1, '1,1,1,1,1,2', 10000.00);
INSERT INTO `user` VALUES (16, '123123', '123456', '男', '爬山', 0, NULL, 10000.00);
INSERT INTO `user` VALUES (17, '1231231', '123123', '女', '爬山,钓鱼', 0, NULL, 10000.00);
INSERT INTO `user` VALUES (18, '11111', '123123', '男', '钓鱼', 0, NULL, 10000.00);
INSERT INTO `user` VALUES (19, '121212', '121212', '男', '爬山', 0, '', 1230.00);

SET FOREIGN_KEY_CHECKS = 1;
