/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : oms

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-03-09 23:33:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tuser
-- ----------------------------
DROP TABLE IF EXISTS `tuser`;
CREATE TABLE `tuser` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `staffName` varchar(255) DEFAULT NULL COMMENT '用户名称',
  `staffNum` varchar(100) DEFAULT NULL COMMENT '员工号',
  `password` varchar(1000) DEFAULT NULL COMMENT '用户密码',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `deleteflag` int(2) NOT NULL COMMENT '0:删除 ， 1:整除 ，2:其他',
  `isAdmin` int(2) DEFAULT '0' COMMENT '管理人标准',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tuser
-- ----------------------------
INSERT INTO `tuser` VALUES ('1', '1231', '312', '31', '2018-10-10 15:46:25', '1', '0');
