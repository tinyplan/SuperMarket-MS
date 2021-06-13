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

 Date: 13/06/2021 13:40:36
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
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_base_info
-- ----------------------------
INSERT INTO `goods_base_info` VALUES (8, '7312', '小熊饼干', '食品');
INSERT INTO `goods_base_info` VALUES (11, '7090', '大熊饼干', '食品');
INSERT INTO `goods_base_info` VALUES (12, '6253', '中熊饼干', '食品');

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
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_info
-- ----------------------------
INSERT INTO `goods_info` VALUES (8, '7312-20210608-0', '小熊饼干', '食品', 5.00, 100.00, 19, '2021-01-01', 30, '2021-01-31');
INSERT INTO `goods_info` VALUES (9, '7312-20210610-7', '小熊饼干', '食品', 5.00, 10.00, 100, '2021-01-01', 30, '2021-01-31');
INSERT INTO `goods_info` VALUES (10, '7312-20210610-8', '小熊饼干', '食品', 5.00, 100.00, 93, '2021-01-01', 365, '2022-01-01');
INSERT INTO `goods_info` VALUES (11, '7312-20210611-9', '小熊饼干', '食品', 5.00, 10.00, 100, '2021-01-01', 365, '2022-01-01');
INSERT INTO `goods_info` VALUES (12, '7312-20210612-10', '小熊饼干', '食品', 5.00, 10.00, 100, '2021-01-01', 365, '2022-01-01');
INSERT INTO `goods_info` VALUES (13, '7312-20210612-12', '小熊饼干', '食品', 5.00, 10.00, 100, '2021-01-01', 365, '2022-01-01');
INSERT INTO `goods_info` VALUES (14, '7090-20210612-13', '大熊饼干', '食品', 5.00, 10.00, 100, '2021-01-01', 365, '2022-01-01');
INSERT INTO `goods_info` VALUES (15, '6253-20210613-14', '中熊饼干', '食品', 2.00, 10.00, 20, '2021-06-03', 60, '2021-08-02');

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
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of import
-- ----------------------------
INSERT INTO `import` VALUES (6, '20210608-0', '7312', '7312-20210608-0', 100, '2021-06-08');
INSERT INTO `import` VALUES (7, '20210610-7', '7312', '7312-20210610-7', 100, '2021-06-10');
INSERT INTO `import` VALUES (8, '20210610-8', '7312', '7312-20210610-8', 100, '2021-06-10');
INSERT INTO `import` VALUES (9, '20210611-9', '7312', '7312-20210611-9', 100, '2021-06-11');
INSERT INTO `import` VALUES (11, '20210612-10', '7312', '7312-20210612-10', 100, '2021-06-12');
INSERT INTO `import` VALUES (12, '20210612-12', '7312', '7312-20210612-12', 100, '2021-06-12');
INSERT INTO `import` VALUES (13, '20210612-13', '7090', '7090-20210612-13', 100, '2021-06-12');
INSERT INTO `import` VALUES (14, '20210613-14', '6253', '6253-20210613-14', 20, '2021-06-13');

-- ----------------------------
-- Table structure for stock_record
-- ----------------------------
DROP TABLE IF EXISTS `stock_record`;
CREATE TABLE `stock_record`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `record_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `import_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `goods_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `price` decimal(10, 2) NULL DEFAULT 0.00,
  `profits` decimal(10, 2) NULL DEFAULT 0.00,
  `effect_type` int(1) NOT NULL,
  `effect_num` int(255) NOT NULL,
  `effect_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stock_record
-- ----------------------------
INSERT INTO `stock_record` VALUES (1, '20210610-0', '20210610-7', '7312-20210610-7', 0.00, 0.00, 1, 100, '2021-06-10 15:43:42');
INSERT INTO `stock_record` VALUES (2, '20210610-2', '20210610-8', '7312-20210610-8', 0.00, 0.00, 1, 100, '2021-06-10 16:18:38');
INSERT INTO `stock_record` VALUES (3, '20210610-3', NULL, '7312-20210610-8', 0.00, 0.00, -1, 2, '2021-06-10 16:20:31');
INSERT INTO `stock_record` VALUES (4, '20210611-4', NULL, '7312-20210610-8', 0.00, 0.00, -1, 3, '2021-06-11 21:35:37');
INSERT INTO `stock_record` VALUES (5, '20210611-5', NULL, '7312-20210610-8', 0.00, 0.00, -1, 1, '2021-06-11 21:35:44');
INSERT INTO `stock_record` VALUES (6, '20210611-6', NULL, '7312-20210610-8', 0.00, 0.00, -1, 1, '2021-06-11 21:35:59');
INSERT INTO `stock_record` VALUES (7, '20210611-7', '20210611-9', '7312-20210611-9', 0.00, 0.00, 1, 100, '2021-06-11 22:25:45');
INSERT INTO `stock_record` VALUES (8, '20210612-8', '20210612-10', '7312-20210612-10', 0.00, 0.00, 1, 100, '2021-06-12 16:38:55');
INSERT INTO `stock_record` VALUES (9, '20210612-9', '20210612-12', '7312-20210612-12', NULL, NULL, 1, 100, '2021-06-12 18:38:56');
INSERT INTO `stock_record` VALUES (10, '20210612-10', '20210612-13', '7090-20210612-13', 0.00, 0.00, 1, 100, '2021-06-12 19:03:40');
INSERT INTO `stock_record` VALUES (11, '20210613-11', '20210613-14', '6253-20210613-14', 0.00, 0.00, 1, 20, '2021-06-13 13:37:20');

SET FOREIGN_KEY_CHECKS = 1;
