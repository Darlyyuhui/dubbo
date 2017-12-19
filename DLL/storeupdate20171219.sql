/*
Navicat MySQL Data Transfer

Source Server         : darly
Source Server Version : 50717
Source Host           : 10.10.15.110:3306
Source Database       : darlybase

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-19 15:35:13
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
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42610', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh ', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '2');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42611', 'Teclado Inalambrico Bluetooth Con Air Mouse', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '3');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42612', 'Funda Para Ebook 7\" 128GB full HD', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '4');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42613', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '5');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42614', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '1');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42615', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '2');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42616', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '3');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42617', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '4');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42618', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '5');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42619', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '5');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42620', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '4');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42621', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '3');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42622', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '3');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42623', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '2');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42624', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '1');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42625', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '5');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42626', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '2');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42627', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '5');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42628', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '3');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42629', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '5');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc42630', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '3');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc426a5', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '5');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc426a8', 'Reloj Inteligente Smart Watch M26 Touch Bluetooh', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '3');
INSERT INTO `store_product` VALUES ('1254260822434698b146dca4ffc426a9', 'Funda Para Ebook 7\" 128GB full HD', '200.00', '350.00', '蓝牙耳机', null, '1000000000', '5');
INSERT INTO `store_product` VALUES ('1254260822434698b246dca4ffc426a5', 'Mp3 Sumergible Deportivo Slim Con 8GB', '200.00', '350.00', 'MP3音响', null, '1000000000', '2');
INSERT INTO `store_product` VALUES ('1254260822434698b246dca4ffc486a5', 'IPhone X', '10.00', '20000.00', '最新版iPhone X手机，高配', null, '1000000000', '5');
/*
Navicat MySQL Data Transfer

Source Server         : darly
Source Server Version : 50717
Source Host           : 10.10.15.110:3306
Source Database       : darlybase

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-19 15:35:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for store_image
-- ----------------------------
DROP TABLE IF EXISTS `store_image`;
CREATE TABLE `store_image` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `PRODUCT_TYPE_ID` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品或活动对照ID',
  `IMAGE_URL` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '图片的URL',
  `IMAGE_DESC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '图片描述',
  `IMAGE_UPLOADTIME` datetime DEFAULT NULL COMMENT '图片上传时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of store_image
-- ----------------------------
INSERT INTO `store_image` VALUES ('1712191456050671abd663f1b1254e5f', '1254260822434698b146dca4ffc42610', 'store/images/item-img-1-10.jpg', '商品图片展示', '2017-12-19 14:56:08');
INSERT INTO `store_image` VALUES ('17121914561273538bf030980c7aff16', '1254260822434698b146dca4ffc42611', 'store/images/item-img-1-11.jpg', '商品图片展示', '2017-12-19 14:56:13');
INSERT INTO `store_image` VALUES ('17121914570853219be0e95bbe41650b', '1254260822434698b146dca4ffc42612', 'store/images/item-img-1-12.jpg', '商品图片展示', '2017-12-19 14:57:08');
INSERT INTO `store_image` VALUES ('1712191457085324a63acf0b068ae33b', '1254260822434698b146dca4ffc42613', 'store/images/item-img-1-7.jpg', '商品图片展示', '2017-12-19 14:57:08');
INSERT INTO `store_image` VALUES ('17121914571241489e2cd29021c429cd', '1254260822434698b146dca4ffc42614', 'store/images/item-img-1-7.jpg', '商品图片展示', '2017-12-19 14:57:12');
INSERT INTO `store_image` VALUES ('171219145712414f90a303e9b5d83fd1', '1254260822434698b146dca4ffc42615', 'store/images/item-img-1-7.jpg', '商品图片展示', '2017-12-19 14:57:12');
INSERT INTO `store_image` VALUES ('171219145713075296566f8c34f39ae4', '1254260822434698b146dca4ffc42616', 'store/images/item-img-1-7.jpg', '商品图片展示', '2017-12-19 14:57:13');
INSERT INTO `store_image` VALUES ('171219145713075e9334770fe12a1651', '1254260822434698b146dca4ffc42617', 'store/images/item-img-1-7.jpg', '商品图片展示', '2017-12-19 14:57:13');
INSERT INTO `store_image` VALUES ('171219145713509887ba119d81463bfe', '1254260822434698b146dca4ffc42618', 'store/images/item-img-1-7.jpg', '商品图片展示', '2017-12-19 14:57:13');
INSERT INTO `store_image` VALUES ('171219145713509ba632e2efacae020f', '1254260822434698b146dca4ffc42619', 'store/images/item-img-1-7.jpg', '商品图片展示', '2017-12-19 14:57:13');
INSERT INTO `store_image` VALUES ('17121914571391599c40efde09aaab61', '1254260822434698b146dca4ffc42620', 'store/images/item-img-1-7.jpg', '商品图片展示', '2017-12-19 14:57:13');
INSERT INTO `store_image` VALUES ('171219145713915a9a3027dd1cf2ec01', '1254260822434698b146dca4ffc42621', 'store/images/item-img-1-7.jpg', '商品图片展示', '2017-12-19 14:57:13');
INSERT INTO `store_image` VALUES ('1712191457142494b0b668eae59e05d9', '1254260822434698b146dca4ffc42622', 'store/images/item-img-1-7.jpg', '商品图片展示', '2017-12-19 14:57:14');
INSERT INTO `store_image` VALUES ('1712191457142497b4b26da0c9862c5c', '1254260822434698b146dca4ffc42623', 'store/images/item-img-1-7.jpg', '商品图片展示', '2017-12-19 14:57:14');
INSERT INTO `store_image` VALUES ('1712191457146860816b2b56e197fab9', '1254260822434698b146dca4ffc42624', 'store/images/item-img-1-7.jpg', '商品图片展示', '2017-12-19 14:57:14');
INSERT INTO `store_image` VALUES ('1712191457146862a01ef04673be7e10', '1254260822434698b146dca4ffc42625', 'store/images/item-img-1-7.jpg', '商品图片展示', '2017-12-19 14:57:14');
INSERT INTO `store_image` VALUES ('171219145715046086dfd00818948d48', '1254260822434698b146dca4ffc42626', 'store/images/item-img-1-7.jpg', '商品图片展示', '2017-12-19 14:57:15');
INSERT INTO `store_image` VALUES ('1712191457150467bfbc066a941c363d', '1254260822434698b146dca4ffc42627', 'store/images/item-img-1-7.jpg', '商品图片展示', '2017-12-19 14:57:15');
INSERT INTO `store_image` VALUES ('1712191457153266bb1720439198ced5', '1254260822434698b146dca4ffc42628', 'store/images/item-img-1-7.jpg', '商品图片展示', '2017-12-19 14:57:15');
INSERT INTO `store_image` VALUES ('1712191457153279a1cf5d06043149c2', '1254260822434698b146dca4ffc42629', 'store/images/item-img-1-7.jpg', '商品图片展示', '2017-12-19 14:57:15');
INSERT INTO `store_image` VALUES ('171219145715711882ee8967ceb585d0', '1254260822434698b146dca4ffc42630', 'store/images/item-img-1-7.jpg', '商品图片展示', '2017-12-19 14:57:15');
INSERT INTO `store_image` VALUES ('1712191457157119878290cb1616a72b', '1254260822434698b146dca4ffc426a5', 'store/images/item-img-1-7.jpg', '商品图片展示', '2017-12-19 14:57:15');
INSERT INTO `store_image` VALUES ('1712191457160774aa07db9e9383b2d7', '1254260822434698b146dca4ffc426a8', 'store/images/item-img-1-8.jpg', '商品图片展示', '2017-12-19 14:57:16');
INSERT INTO `store_image` VALUES ('1712191457160779b7678ed0d746cd49', '1254260822434698b146dca4ffc426a9', 'store/images/item-img-1-9.jpg', '商品图片展示', '2017-12-19 14:57:16');
INSERT INTO `store_image` VALUES ('1712191457164427a365f6220ca0987b', '1254260822434698b246dca4ffc426a5', 'store/images/item-img-1-6.jpg', '商品图片展示', '2017-12-19 14:57:16');
INSERT INTO `store_image` VALUES ('17121914571644289a645f510a2633bd', '1254260822434698b246dca4ffc486a5', 'store/images/item-img-1-3.jpg', '商品图片展示', '2017-12-19 14:57:16');
INSERT INTO `store_image` VALUES ('171219145716842087012a36ce01938a', null, 'static/images/48190bb5da2f400c8179917e17d1d0e0.png', '新增图片', '2017-12-19 14:57:16');
INSERT INTO `store_image` VALUES ('1712191457168424ad390e897282f497', null, 'static/images/238782bbdef84da5a0d2a62e26e531b4.png', '新增图片', '2017-12-19 14:57:16');
INSERT INTO `store_image` VALUES ('17121914571722509a87e19109666e88', null, 'static/images/f96821b60fbc40c78ad424841a09204c.png', '新增图片', '2017-12-19 14:57:17');
INSERT INTO `store_image` VALUES ('1712191457172256b380d4cc30fe3fca', null, 'static/images/040cf9889136447fb1da5b5dcef5438c.png', '新增图片', '2017-12-19 14:57:17');
INSERT INTO `store_image` VALUES ('1712191457179400994dcb3496c74389', null, 'static/images/988a8f991ddb49a1a3cb04b78e2478f9.png', '新增图片', '2017-12-19 14:57:17');
INSERT INTO `store_image` VALUES ('17121914571794038a272950f021005a', null, 'static/images/f419a89844914f8b9115a8ecd0a0386b.png', '新增图片', '2017-12-19 14:57:17');
