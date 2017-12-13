/*
Navicat MySQL Data Transfer

Source Server         : darly
Source Server Version : 50717
Source Host           : 10.10.15.110:3306
Source Database       : darlybase

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-13 17:30:43
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
INSERT INTO `store_blog` VALUES ('1865465165165198b246dca4ffc123a5', '1254260822434698b246dca4ffc486a5', '171114090328679d8b4d4ebecdb099e6', 'iPhone手机测评', '测评中。。。', 'store/images/blog-img-1.jpg', '2017-12-13 17:02:45', '2017-12-13 17:02:45');
INSERT INTO `store_blog` VALUES ('1865465165165198b246dca4ffc4811', '1254260822434698b246dca4ffc486a5', '171114090328679d8b4d4ebecdb099e6', 'iPhone手机测评', '测评中。。。', 'store/images/blog-img-1.jpg', '2017-12-13 17:02:45', '2017-12-13 17:02:45');
INSERT INTO `store_blog` VALUES ('1865465165165198b246dca4ffc486a5', '1254260822434698b246dca4ffc486a5', '171114090328679d8b4d4ebecdb099e6', 'iPhone手机测评', '测评中。。。', 'store/images/blog-img-1.jpg', '2017-12-13 17:02:45', '2017-12-13 17:02:45');
INSERT INTO `store_blog` VALUES ('1865465165165198b246dqa4ffc486a5', '1254260822434698b246dca4ffc486a5', '171114090328679d8b4d4ebecdb099e6', 'iPhone手机测评', '测评中。。。', 'store/images/blog-img-1.jpg', '2017-12-13 17:02:45', '2017-12-13 17:02:45');
INSERT INTO `store_blog` VALUES ('1865465165165298b246dca4ffc486a5', '1254260822434698b246dca4ffc486a5', '171114090328679d8b4d4ebecdb099e6', 'iPhone手机测评', '测评中。。。', 'store/images/blog-img-1.jpg', '2017-12-13 17:02:45', '2017-12-13 17:02:45');
/*
Navicat MySQL Data Transfer

Source Server         : darly
Source Server Version : 50717
Source Host           : 10.10.15.110:3306
Source Database       : darlybase

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-13 17:30:53
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
  `PRODUCT_STARS` decimal(5,1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of store_product
-- ----------------------------
INSERT INTO `store_product` VALUES ('1254260822434698b246dca4ffc486a5', 'IPhone X', '10.00', '20000.00', '最新版iPhone X手机，高配', 'store/images/item-img-1-3.jpg', '1000000000', '5.0');
