CREATE DATABASE IF NOT EXISTS `market_sys` default charset utf8 COLLATE utf8_general_ci;

USE `market_sys`;
drop TABLE if EXISTS `admin_msg`;
CREATE TABLE IF NOT EXISTS `admin_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `login_name` varchar(255) DEFAULT NULL COMMENT '登录名',
 `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='管理员';


drop TABLE if EXISTS `user_msg`;
CREATE TABLE IF NOT EXISTS `user_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `login_name` varchar(255) DEFAULT NULL COMMENT '登录名',
 `password` varchar(255) DEFAULT NULL COMMENT '密码',
 `real_name` varchar(255) DEFAULT NULL COMMENT '姓名',
 `cel_phone` varchar(255) DEFAULT NULL COMMENT '联系电话',
 `birthday` varchar(30) DEFAULT NULL COMMENT '生日',
 `sex` int(11) DEFAULT NULL COMMENT '性别',
 `address` varchar(255) DEFAULT NULL COMMENT '地址',
 `user_score` int(11) DEFAULT NULL COMMENT '用户积分',
 `create_time` varchar(30) DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='会员';


drop TABLE if EXISTS `pro_type`;
CREATE TABLE IF NOT EXISTS `pro_type` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `type_name` varchar(255) DEFAULT NULL COMMENT '类型名',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品类型';


drop TABLE if EXISTS `pro_msg`;
CREATE TABLE IF NOT EXISTS `pro_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `pro_title` varchar(255) DEFAULT NULL COMMENT '商品标题',
 `pro_img` varchar(200) DEFAULT NULL COMMENT '商品大图',
 `pid` int(11) DEFAULT NULL COMMENT '商品类型',
 `pro_price` double(10,2) DEFAULT NULL COMMENT '价格',
 `pro_stock_num` int(11) DEFAULT NULL COMMENT '库存数量',
 `pro_intro` varchar(1000) DEFAULT NULL COMMENT '商品简介',
 `pro_detail` varchar(600) DEFAULT NULL COMMENT '商品详情图',
 `sale_num` int(11) DEFAULT NULL COMMENT '销量',
 `is_up` int(11) DEFAULT NULL COMMENT '是否上架',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品';


drop TABLE if EXISTS `cart`;
CREATE TABLE IF NOT EXISTS `cart` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `pid` int(11) DEFAULT NULL COMMENT '商品ID',
 `num` int(11) DEFAULT NULL COMMENT '数量',
 `uid` int(11) DEFAULT NULL COMMENT '会员ID',
 `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='购物车';


drop TABLE if EXISTS `order_msg`;
CREATE TABLE IF NOT EXISTS `order_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `order_no` varchar(255) DEFAULT NULL COMMENT '订单编号',
 `uid` int(11) DEFAULT NULL COMMENT '会员ID',
 `ureal_name` varchar(255) DEFAULT NULL COMMENT '会员姓名',
 `ucel_phone` varchar(255) DEFAULT NULL COMMENT '联系电话',
 `uaddress` varchar(255) DEFAULT NULL COMMENT '会员地址',
 `pid` int(11) DEFAULT NULL COMMENT '商品ID',
 `ppro_price` double(10,2) DEFAULT NULL COMMENT '商品价格',
 `order_num` int(11) DEFAULT NULL COMMENT '数量',
 `total_amount` varchar(255) DEFAULT NULL COMMENT '应付金额',
 `pay_amount` double(10,2) DEFAULT NULL COMMENT '实付金额',
 `order_status` int(11) DEFAULT NULL COMMENT '订单状态',
 `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单';



INSERT INTO `market_sys`.`admin_msg` (`id`,`login_name`,`password`)  VALUES('1','admin','123');
INSERT INTO `market_sys`.`admin_msg` (`id`,`login_name`,`password`)  VALUES('2','admin1','123');
INSERT INTO `market_sys`.`admin_msg` (`id`,`login_name`,`password`)  VALUES('3','admin2','123');
INSERT INTO `market_sys`.`admin_msg` (`id`,`login_name`,`password`)  VALUES('4','admin3','123');
INSERT INTO `market_sys`.`admin_msg` (`id`,`login_name`,`password`)  VALUES('5','admin4','123');
INSERT INTO `market_sys`.`user_msg` (`id`,`login_name`,`password`,`real_name`,`cel_phone`,`birthday`,`sex`,`address`,`user_score`,`create_time`)  VALUES('1','user','123','姓名0','13052653265','2023-03-10','1','地址0','0','2023-03-09 23:28:35');
INSERT INTO `market_sys`.`user_msg` (`id`,`login_name`,`password`,`real_name`,`cel_phone`,`birthday`,`sex`,`address`,`user_score`,`create_time`)  VALUES('2','user1','123','姓名1','13553613261','2023-03-10','1','地址1','0','2023-03-09 23:28:35');
INSERT INTO `market_sys`.`user_msg` (`id`,`login_name`,`password`,`real_name`,`cel_phone`,`birthday`,`sex`,`address`,`user_score`,`create_time`)  VALUES('3','user2','123','姓名2','13552623265','2023-03-09','1','地址2','0','2023-03-10 23:28:35');
INSERT INTO `market_sys`.`user_msg` (`id`,`login_name`,`password`,`real_name`,`cel_phone`,`birthday`,`sex`,`address`,`user_score`,`create_time`)  VALUES('4','user3','123','姓名3','13052623165','2023-03-09','1','地址3','0','2023-03-10 23:28:35');
INSERT INTO `market_sys`.`user_msg` (`id`,`login_name`,`password`,`real_name`,`cel_phone`,`birthday`,`sex`,`address`,`user_score`,`create_time`)  VALUES('5','user4','123','姓名4','13052633163','2023-03-09','2','地址4','0','2023-03-10 23:28:35');
INSERT INTO `market_sys`.`pro_type` (`id`,`type_name`)  VALUES('1','类型名0');
INSERT INTO `market_sys`.`pro_type` (`id`,`type_name`)  VALUES('2','类型名1');
INSERT INTO `market_sys`.`pro_type` (`id`,`type_name`)  VALUES('3','类型名2');
INSERT INTO `market_sys`.`pro_type` (`id`,`type_name`)  VALUES('4','类型名3');
INSERT INTO `market_sys`.`pro_type` (`id`,`type_name`)  VALUES('5','类型名4');
INSERT INTO `market_sys`.`pro_msg` (`id`,`pro_title`,`pro_img`,`pid`,`pro_price`,`pro_stock_num`,`pro_intro`,`pro_detail`,`sale_num`,`is_up`)  VALUES('1','商品标题0','/market_sys/static/images/2/1.png','5','99.6','63','商品简介0','/market_sys/static/images/2/1.png;/market_sys/static/images/2/1.png;/market_sys/static/images/2/1.png;/market_sys/static/images/2/1.png','0','2');
INSERT INTO `market_sys`.`pro_msg` (`id`,`pro_title`,`pro_img`,`pid`,`pro_price`,`pro_stock_num`,`pro_intro`,`pro_detail`,`sale_num`,`is_up`)  VALUES('2','商品标题1','/market_sys/static/images/2/2.png','3','44.9','22','商品简介1','/market_sys/static/images/2/2.png;/market_sys/static/images/2/2.png;/market_sys/static/images/2/2.png;/market_sys/static/images/2/2.png','0','1');
INSERT INTO `market_sys`.`pro_msg` (`id`,`pro_title`,`pro_img`,`pid`,`pro_price`,`pro_stock_num`,`pro_intro`,`pro_detail`,`sale_num`,`is_up`)  VALUES('3','商品标题2','/market_sys/static/images/2/3.png','2','21.5','50','商品简介2','/market_sys/static/images/2/3.png;/market_sys/static/images/2/3.png;/market_sys/static/images/2/3.png;/market_sys/static/images/2/3.png;/market_sys/static/images/2/3.png','0','2');
INSERT INTO `market_sys`.`pro_msg` (`id`,`pro_title`,`pro_img`,`pid`,`pro_price`,`pro_stock_num`,`pro_intro`,`pro_detail`,`sale_num`,`is_up`)  VALUES('4','商品标题3','/market_sys/static/images/2/4.png','5','94.8','25','商品简介3','/market_sys/static/images/2/4.png;/market_sys/static/images/2/4.png;/market_sys/static/images/2/4.png;/market_sys/static/images/2/4.png;/market_sys/static/images/2/4.png','0','2');
INSERT INTO `market_sys`.`pro_msg` (`id`,`pro_title`,`pro_img`,`pid`,`pro_price`,`pro_stock_num`,`pro_intro`,`pro_detail`,`sale_num`,`is_up`)  VALUES('5','商品标题4','/market_sys/static/images/2/5.png','2','89.9','47','商品简介4','/market_sys/static/images/2/5.png;/market_sys/static/images/2/5.png','0','1');
INSERT INTO `market_sys`.`cart` (`id`,`pid`,`num`,`uid`,`create_time`)  VALUES('1','2','88','1','2023-03-09 23:28:35');
INSERT INTO `market_sys`.`cart` (`id`,`pid`,`num`,`uid`,`create_time`)  VALUES('2','5','59','3','2023-03-09 23:28:35');
INSERT INTO `market_sys`.`cart` (`id`,`pid`,`num`,`uid`,`create_time`)  VALUES('3','2','36','1','2023-03-09 23:28:35');
INSERT INTO `market_sys`.`cart` (`id`,`pid`,`num`,`uid`,`create_time`)  VALUES('4','1','19','2','2023-03-09 23:28:35');
INSERT INTO `market_sys`.`cart` (`id`,`pid`,`num`,`uid`,`create_time`)  VALUES('5','5','19','5','2023-03-09 23:28:35');
INSERT INTO `market_sys`.`order_msg` (`id`,`order_no`,`uid`,`ureal_name`,`ucel_phone`,`uaddress`,`pid`,`ppro_price`,`order_num`,`total_amount`,`pay_amount`,`order_status`,`create_time`)  VALUES('1','20230310232836493917','5','姓名4','13052633163','地址4','3','21.5','60','应付金额0','31.1','3','2023-03-10 23:28:36');
INSERT INTO `market_sys`.`order_msg` (`id`,`order_no`,`uid`,`ureal_name`,`ucel_phone`,`uaddress`,`pid`,`ppro_price`,`order_num`,`total_amount`,`pay_amount`,`order_status`,`create_time`)  VALUES('2','20230310232836243946','1','姓名0','13052653265','地址0','2','44.9','11','应付金额1','35.9','4','2023-03-10 23:28:36');
INSERT INTO `market_sys`.`order_msg` (`id`,`order_no`,`uid`,`ureal_name`,`ucel_phone`,`uaddress`,`pid`,`ppro_price`,`order_num`,`total_amount`,`pay_amount`,`order_status`,`create_time`)  VALUES('3','20230310232836848192','1','姓名0','13052653265','地址0','3','21.5','46','应付金额2','99.0','1','2023-03-10 23:28:36');
INSERT INTO `market_sys`.`order_msg` (`id`,`order_no`,`uid`,`ureal_name`,`ucel_phone`,`uaddress`,`pid`,`ppro_price`,`order_num`,`total_amount`,`pay_amount`,`order_status`,`create_time`)  VALUES('4','20230310232836383412','5','姓名4','13052633163','地址4','2','44.9','0','应付金额3','70.9','1','2023-03-09 23:28:36');
INSERT INTO `market_sys`.`order_msg` (`id`,`order_no`,`uid`,`ureal_name`,`ucel_phone`,`uaddress`,`pid`,`ppro_price`,`order_num`,`total_amount`,`pay_amount`,`order_status`,`create_time`)  VALUES('5','20230310232836950140','5','姓名4','13052633163','地址4','5','89.9','59','应付金额4','64.4','4','2023-03-10 23:28:36');