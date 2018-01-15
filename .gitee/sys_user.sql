/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : igl

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2018-01-15 21:04:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mobile` varchar(13) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', null, null, null);
INSERT INTO `sys_user` VALUES ('2', null, null, null);
INSERT INTO `sys_user` VALUES ('9', null, null, null);
INSERT INTO `sys_user` VALUES ('10', null, null, null);
INSERT INTO `sys_user` VALUES ('11', null, null, null);
INSERT INTO `sys_user` VALUES ('12', null, null, null);
INSERT INTO `sys_user` VALUES ('13', null, null, null);
INSERT INTO `sys_user` VALUES ('14', null, null, null);
INSERT INTO `sys_user` VALUES ('15', null, null, null);
INSERT INTO `sys_user` VALUES ('16', null, null, null);
