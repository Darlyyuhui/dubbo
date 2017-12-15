/*
Navicat MySQL Data Transfer

Source Server         : darly
Source Server Version : 50717
Source Host           : 10.10.15.110:3306
Source Database       : darlybase

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-15 14:44:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for store_activiy_type
-- ----------------------------
DROP TABLE IF EXISTS `store_activiy_type`;
CREATE TABLE `store_activiy_type` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `STORE_TYPE` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '活动类型',
  `STORE_DESC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动说明',
  `STORE_START_TIME` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '活动开启时间',
  `STORE_END_TIME` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '活动结束时间',
  `STORE_TYPE_OP` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动策划负责人',
  `STORE_CREATETIME` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '活动创建时间',
  `STORE_UPDATETIME` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '活动修改时间',
  `STORE_UPDATEREASON` varchar(800) COLLATE utf8_unicode_ci NOT NULL COMMENT '活动修改说明',
  `STORE_TYPE_ICON` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动图标',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of store_activiy_type
-- ----------------------------
INSERT INTO `store_activiy_type` VALUES ('17103014085708108cbb4de6c7bda7d1', 'Sheep', '周年纪念特卖', '2017-12-15 09:36:56', '2017-12-31 09:36:27', '宇辉', '2017-12-15 09:36:56', '2017-12-15 09:36:56', '', null);
INSERT INTO `store_activiy_type` VALUES ('17103014085708108cbb4de6c7bda7de', 'Summer Sale', '夏季展会', '2017-08-01 09:36:51', '2017-09-30 09:34:54', '宇辉', '2017-07-29 09:36:51', '2017-07-29 09:36:51', '', null);
INSERT INTO `store_activiy_type` VALUES ('17103014085708108cbb4de6c7bda7dw', 'Week', '周活动', '2017-12-15 09:36:51', '2017-12-17 09:34:54', '宇辉', '2017-12-15 09:36:51', '2017-12-15 09:36:51', '', null);
/*
Navicat MySQL Data Transfer

Source Server         : darly
Source Server Version : 50717
Source Host           : 10.10.15.110:3306
Source Database       : darlybase

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-15 14:45:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for store_sale
-- ----------------------------
DROP TABLE IF EXISTS `store_sale`;
CREATE TABLE `store_sale` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `PRODUCT_ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '商品ID',
  `STORE_TYPE` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '活动注解',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of store_sale
-- ----------------------------
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de63713a73', '1254260822434698b146dca4ffc42622', '17103014085708108cbb4de6c7bda7de');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6c713a71', '1254260822434698b146dca4ffc42617', '17103014085708108cbb4de6c7bda7de');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6c713a72', '1254260822434698b146dca4ffc42618', '17103014085708108cbb4de6c7bda7de');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6c713a73', '1254260822434698b146dca4ffc42619', '17103014085708108cbb4de6c7bda7de');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6c713a74', '1254260822434698b146dca4ffc42620', '17103014085708108cbb4de6c7bda7de');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6c713a7a', '1254260822434698b146dca4ffc42621', '17103014085708108cbb4de6c7bda7de');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6c7b3a71', '1254260822434698b146dca4ffc42612', '17103014085708108cbb4de6c7bda7de');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6c7b3a72', '1254260822434698b146dca4ffc42613', '17103014085708108cbb4de6c7bda7de');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6c7b3a73', '1254260822434698b146dca4ffc42614', '17103014085708108cbb4de6c7bda7de');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6c7b3a74', '1254260822434698b146dca4ffc42615', '17103014085708108cbb4de6c7bda7de');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6c7b3a75', '1254260822434698b146dca4ffc42616', '17103014085708108cbb4de6c7bda7de');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6c7bda61', '1254260822434698b246dca4ffc486a5', '17103014085708108cbb4de6c7bda7d1');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6c7bda62', '1254260822434698b246dca4ffc426a5', '17103014085708108cbb4de6c7bda7d1');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6c7bda63', '1254260822434698b146dca4ffc426a5', '17103014085708108cbb4de6c7bda7d1');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6c7bda64', '1254260822434698b146dca4ffc426a8', '17103014085708108cbb4de6c7bda7d1');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6c7bda65', '1254260822434698b146dca4ffc426a9', '17103014085708108cbb4de6c7bda7d1');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6c7bda71', '1254260822434698b246dca4ffc486a5', '17103014085708108cbb4de6c7bda7dw');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6c7bda72', '1254260822434698b246dca4ffc426a5', '17103014085708108cbb4de6c7bda7dw');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6c7bda73', '1254260822434698b146dca4ffc426a5', '17103014085708108cbb4de6c7bda7dw');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6c7bda74', '1254260822434698b146dca4ffc426a8', '17103014085708108cbb4de6c7bda7dw');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6c7bda75', '1254260822434698b146dca4ffc426a9', '17103014085708108cbb4de6c7bda7dw');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6s713a74', '1254260822434698b146dca4ffc42623', '17103014085708108cbb4de6c7bda7de');
INSERT INTO `store_sale` VALUES ('17103014085708108cbb4de6t713a7a', '1254260822434698b146dca4ffc42624', '17103014085708108cbb4de6c7bda7de');
