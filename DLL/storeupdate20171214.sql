/*
Navicat MySQL Data Transfer

Source Server         : darly
Source Server Version : 50717
Source Host           : 10.10.15.110:3306
Source Database       : darlybase

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-14 17:16:13
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

/*
Navicat MySQL Data Transfer

Source Server         : darly
Source Server Version : 50717
Source Host           : 10.10.15.110:3306
Source Database       : darlybase

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-14 17:15:48
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
  `STORE_START_TIME` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '活动开启时间',
  `STORE_END_TIME` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '活动结束时间',
  `STORE_TYPE_OP` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动策划负责人',
  `STORE_CREATETIME` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '活动创建时间',
  `STORE_UPDATETIME` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '活动修改时间',
  `STORE_UPDATEREASON` varchar(800) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动修改说明',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of store_activiy_type
-- ----------------------------
INSERT INTO `store_activiy_type` VALUES ('17103014085708108cbb4de6c7bda7d1', 'Sheep', '周年纪念特卖', '2017-12-14 11:21:09', '2017-12-14 11:21:09', '宇辉', '2017-12-14 11:21:09', '2017-12-14 11:21:09', '');
INSERT INTO `store_activiy_type` VALUES ('17103014085708108cbb4de6c7bda7dw', 'Week', '周活动', '2017-12-14 11:21:09', '2017-12-14 11:21:09', '宇辉', '2017-12-14 11:21:09', '2017-12-14 11:21:09', '');


/*
Navicat MySQL Data Transfer

Source Server         : darly
Source Server Version : 50717
Source Host           : 10.10.15.110:3306
Source Database       : darlybase

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-14 17:16:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for store_blog
-- ----------------------------
DROP TABLE IF EXISTS `store_blog`;
CREATE TABLE `store_blog` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `PRODUCT_ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '商品信息',
  `AUTHER_ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '作者信息',
  `BLOG_TITLE` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '标题',
  `BLOG_ARTICLE` varchar(1000) COLLATE utf8_unicode_ci NOT NULL COMMENT '文章内容',
  `BLOG_IMAGE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '图片引用',
  `BLOG_UPDATETIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `BLOG_CREATTIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of store_blog
-- ----------------------------
INSERT INTO `store_blog` VALUES ('1865465165165198b246dca4ffc123a5', '1254260822434698b246dca4ffc486a5', '171114090328679d8b4d4ebecdb099e6', 'iPhone手机测评', '测评中。。。', 'store/images/blog-img-3.jpg', '2017-12-14 09:40:57', '2017-12-14 09:40:57');
INSERT INTO `store_blog` VALUES ('1865465165165198b246dca4ffc4811', '1254260822434698b246dca4ffc486a5', '171114090328679d8b4d4ebecdb099e6', 'iPhone手机测评', '测评中。。。', 'store/images/blog-img-2.jpg', '2017-12-14 09:40:55', '2017-12-14 09:40:55');
INSERT INTO `store_blog` VALUES ('1865465165165198b246dca4ffc486a5', '1254260822434698b246dca4ffc486a5', '171114090328679d8b4d4ebecdb099e6', 'iPhone手机测评', '测评中。。。', 'store/images/blog-img-1.jpg', '2017-12-13 17:02:45', '2017-12-13 17:02:45');
INSERT INTO `store_blog` VALUES ('1865465165165198b246dqa4ffc486a5', '1254260822434698b246dca4ffc486a5', '171114090328679d8b4d4ebecdb099e6', 'iPhone手机测评', '测评中。。。', 'store/images/blog-img-1.jpg', '2017-12-13 17:02:45', '2017-12-13 17:02:45');
INSERT INTO `store_blog` VALUES ('1865465165165298b246dca4ffc486a5', '1254260822434698b246dca4ffc486a5', '171114090328679d8b4d4ebecdb099e6', 'iPhone手机测评', '测评中。。。', 'store/images/blog-img-2.jpg', '2017-12-14 09:41:01', '2017-12-14 09:41:01');

/*
Navicat MySQL Data Transfer

Source Server         : darly
Source Server Version : 50717
Source Host           : 10.10.15.110:3306
Source Database       : darlybase

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-14 17:16:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for store_product
-- ----------------------------
DROP TABLE IF EXISTS `store_product`;
CREATE TABLE `store_product` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `PRODUCT_NAME` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `PRODUCT_PRICE` decimal(20,2) DEFAULT NULL,
  `PRODUCT_ORPRICE` decimal(20,2) DEFAULT NULL,
  `PRODUCT_DESC` varchar(800) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PRODUCT_IMAGE` varchar(400) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PRODUCT_NUM` int(5) NOT NULL,
  `PRODUCT_STARS` int(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of store_product
-- ----------------------------
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42610', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh ', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-10.jpg', '1000000000', '2');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42611', 'Teclado Inalambrico Bluetooth Con Air Mouse', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-11.jpg', '1000000000', '3');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42612', 'Funda Para Ebook 7\" 128GB full HD', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-12.jpg', '1000000000', '4');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42613', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-7.jpg', '1000000000', '5');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42614', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-7.jpg', '1000000000', '1');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42615', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-7.jpg', '1000000000', '2');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42616', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-7.jpg', '1000000000', '3');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42617', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-7.jpg', '1000000000', '4');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42618', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-7.jpg', '1000000000', '5');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42619', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-7.jpg', '1000000000', '5');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42620', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-7.jpg', '1000000000', '4');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42621', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-7.jpg', '1000000000', '3');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42622', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-7.jpg', '1000000000', '3');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42623', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-7.jpg', '1000000000', '2');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42624', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-7.jpg', '1000000000', '1');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42625', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-7.jpg', '1000000000', '5');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42626', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-7.jpg', '1000000000', '2');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42627', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-7.jpg', '1000000000', '5');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42628', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-7.jpg', '1000000000', '3');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42629', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-7.jpg', '1000000000', '5');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42630', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-7.jpg', '1000000000', '3');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc426a5', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-7.jpg', '1000000000', '5');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc426a8', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-8.jpg', '1000000000', '3');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc426a9', 'Funda Para Ebook 7\" 128GB full HD', '200.00', '350.00', '蓝牙耳机', '/store/images/item-img-1-9.jpg', '1000000000', '5');
INSERT INTO `store_product` VALUES ('1254260822434698b246dca4ffc426a5', 'Mp3 Sumergible Deportivo Slim Con 8GB', '200.00', '350.00', 'MP3音响', '/store/images/item-img-1-6.jpg', '1000000000', '2');
INSERT INTO `store_product` VALUES ('1254260822434698b246dca4ffc486a5', 'IPhone X', '10.00', '20000.00', '最新版iPhone X手机，高配', '/store/images/item-img-1-3.jpg', '1000000000', '5');






