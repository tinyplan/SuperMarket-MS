/*
 Navicat Premium Data Transfer

 Source Server         : Mysql8
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : supermarket_ms

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 12/06/2021 15:54:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods_base_info
-- ----------------------------
DROP TABLE IF EXISTS `goods_base_info`;
CREATE TABLE `goods_base_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_base_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `goods_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_base_info
-- ----------------------------
INSERT INTO `goods_base_info` VALUES (8, '7312', '小熊饼干', '食品');

-- ----------------------------
-- Table structure for goods_info
-- ----------------------------
DROP TABLE IF EXISTS `goods_info`;
CREATE TABLE `goods_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'base_id拼接import_id',
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `goods_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `goods_cost` decimal(10, 2) NOT NULL,
  `goods_price` decimal(10, 2) NOT NULL,
  `stock` int(255) NOT NULL,
  `production_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '生产日期(精确到天)',
  `duration` int(255) NOT NULL COMMENT '保质期',
  `expiration_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '过期时间(精确到天)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_info
-- ----------------------------
INSERT INTO `goods_info` VALUES (8, '7312-20210608-0', '小熊饼干', '食品', 5.00, 100.00, 19, '2021-01-01', 30, '2021-01-31');
INSERT INTO `goods_info` VALUES (9, '7312-20210610-7', '小熊饼干', '食品', 5.00, 10.00, 100, '2021-01-01', 30, '2021-01-31');
INSERT INTO `goods_info` VALUES (10, '7312-20210610-8', '小熊饼干', '食品', 5.00, 100.00, 93, '2021-01-01', 365, '2022-01-01');
INSERT INTO `goods_info` VALUES (11, '7312-20210611-9', '小熊饼干', '食品', 5.00, 10.00, 100, '2021-01-01', 365, '2022-01-01');

-- ----------------------------
-- Table structure for import
-- ----------------------------
DROP TABLE IF EXISTS `import`;
CREATE TABLE `import`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `import_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '进货编号',
  `goods_base_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品基础编号',
  `goods_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品编号',
  `import_goods_sum` int(255) NOT NULL COMMENT '进货数量',
  `import_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '进货日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of import
-- ----------------------------
INSERT INTO `import` VALUES (6, '20210608-0', '7312', '7312-20210608-0', 100, '2021-06-08');
INSERT INTO `import` VALUES (7, '20210610-7', '7312', '7312-20210610-7', 100, '2021-06-10');
INSERT INTO `import` VALUES (8, '20210610-8', '7312', '7312-20210610-8', 100, '2021-06-10');
INSERT INTO `import` VALUES (9, '20210611-9', '7312', '7312-20210611-9', 100, '2021-06-11');

-- ----------------------------
-- Table structure for stock_record
-- ----------------------------
DROP TABLE IF EXISTS `stock_record`;
CREATE TABLE `stock_record`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `record_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `import_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `goods_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `effect_type` int(1) NOT NULL,
  `effect_num` int(255) NOT NULL,
  `effect_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stock_record
-- ----------------------------
INSERT INTO `stock_record` VALUES (1, '20210610-0', '20210610-7', '7312-20210610-7', 1, 100, '2021-06-10 15:43:42');
INSERT INTO `stock_record` VALUES (2, '20210610-2', '20210610-8', '7312-20210610-8', 1, 100, '2021-06-10 16:18:38');
INSERT INTO `stock_record` VALUES (3, '20210610-3', NULL, '7312-20210610-8', -1, 2, '2021-06-10 16:20:31');
INSERT INTO `stock_record` VALUES (4, '20210611-4', NULL, '7312-20210610-8', -1, 3, '2021-06-11 21:35:37');
INSERT INTO `stock_record` VALUES (5, '20210611-5', NULL, '7312-20210610-8', -1, 1, '2021-06-11 21:35:44');
INSERT INTO `stock_record` VALUES (6, '20210611-6', NULL, '7312-20210610-8', -1, 1, '2021-06-11 21:35:59');
INSERT INTO `stock_record` VALUES (7, '20210611-7', '20210611-9', '7312-20210611-9', 1, 100, '2021-06-11 22:25:45');

SET FOREIGN_KEY_CHECKS = 1;
