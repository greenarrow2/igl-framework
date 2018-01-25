/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : igl

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2018-01-25 11:03:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dict_code` int(8) NOT NULL COMMENT '字典编码',
  `dict_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '字典名称',
  `dict_no` int(4) DEFAULT NULL COMMENT '字段编号',
  `dict_desc` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '字典描述',
  `remarks` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` datetime DEFAULT NULL,
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------
INSERT INTO `sys_dictionary` VALUES ('1', '1', '启用', '0', '状态', null, null, null, null, null, null);
INSERT INTO `sys_dictionary` VALUES ('2', '0', '停用', '0', '状态', null, null, null, null, null, null);
INSERT INTO `sys_dictionary` VALUES ('3', '-1', '删除', '0', '状态', null, null, null, null, null, null);
INSERT INTO `sys_dictionary` VALUES ('4', '10000000', '目录', '1000', '角色类型', null, null, null, null, null, null);
INSERT INTO `sys_dictionary` VALUES ('5', '10000005', '角色', '1000', '角色类型', null, null, null, null, null, null);
INSERT INTO `sys_dictionary` VALUES ('6', '10010000', '政府', '1001', '组织类型', null, null, null, null, null, null);
INSERT INTO `sys_dictionary` VALUES ('7', '10010005', '企业', '1001', '组织类型', null, null, null, null, null, null);
INSERT INTO `sys_dictionary` VALUES ('8', '10010010', '学校', '1001', '组织类型', null, null, null, null, null, null);
INSERT INTO `sys_dictionary` VALUES ('9', '10001015', '医院', '1001', '组织类型', null, null, null, null, null, null);
INSERT INTO `sys_dictionary` VALUES ('31', '10020000', '小学', '1002', null, null, '2018-01-18 16:44:28', null, '2018-01-18 16:45:17', null, '1');
INSERT INTO `sys_dictionary` VALUES ('32', '10020000', '小学', '1002', null, null, '2018-01-18 16:50:37', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('33', '10020000', '小学', '1002', null, null, '2018-01-18 16:50:42', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('34', '10020000', '小学', '1002', null, null, '2018-01-18 16:54:28', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('35', '10020000', '小学', '1002', null, null, '2018-01-18 16:54:31', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('36', '10020000', '小学', '1002', null, null, '2018-01-18 16:55:31', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('37', '10020000', '小学', '1002', null, null, '2018-01-18 16:55:32', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('38', '10020000', '小学', '1002', null, null, '2018-01-18 16:56:58', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('39', '10020000', '小学', '1002', null, null, '2018-01-18 16:57:00', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('40', '10020000', '小学', '1002', null, null, '2018-01-18 16:57:02', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('41', '10020000', '小学', '1002', null, null, '2018-01-18 16:57:05', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('42', '10020000', '小学', '1002', null, null, '2018-01-18 16:57:05', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('43', '10020000', '小学', '1002', null, null, '2018-01-18 16:57:05', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('44', '10020000', '小学', '1002', null, null, '2018-01-18 16:57:05', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('45', '10020000', '小学', '1002', null, null, '2018-01-18 16:58:16', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('46', '10020000', '小学', '1002', null, null, '2018-01-18 16:58:18', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('47', '10020000', '小学', '1002', null, null, '2018-01-18 16:58:19', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('48', '10020000', '小学', '1002', null, null, '2018-01-18 16:58:19', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('49', '10020000', '小学', '1002', null, null, '2018-01-18 17:01:47', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('50', '10020000', '小学', '1002', null, null, '2018-01-18 17:02:24', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('51', '10020000', '小学', '1002', null, null, '2018-01-18 17:02:26', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('52', '10020000', '小学', '1002', null, null, '2018-01-18 17:02:51', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('53', '10020000', '小学', '1002', null, null, '2018-01-18 17:03:23', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('54', '10020000', '小学', '1002', null, null, '2018-01-18 17:03:53', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('55', '10020000', '小学', '1002', null, null, '2018-01-18 17:03:55', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('56', '10020000', '小学', '1002', null, null, '2018-01-18 17:11:37', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('57', '10020000', '小学', '1002', null, null, '2018-01-18 17:11:40', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('58', '10020000', '小学', '1002', null, null, '2018-01-18 18:20:01', null, '2018-01-18 18:20:48', null, '1');
INSERT INTO `sys_dictionary` VALUES ('59', '10020000', '小学', '1002', null, null, '2018-01-19 10:04:27', null, null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('60', '10020000', '小学', '1002', null, null, '2018-01-19 10:25:35', null, null, null, '0');

-- ----------------------------
-- Table structure for sys_module
-- ----------------------------
DROP TABLE IF EXISTS `sys_module`;
CREATE TABLE `sys_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '请求路径',
  `module_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '模块名称',
  `module_desc` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '模块描述',
  `module_type` int(8) DEFAULT NULL COMMENT '模块类型',
  `state` int(8) DEFAULT NULL COMMENT '状态',
  `module_code` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '模块编号',
  `create_time` datetime DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_module
-- ----------------------------

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization` (
  `id` int(11) NOT NULL,
  `org_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '组织名称',
  `org_type` int(8) DEFAULT NULL COMMENT '组织类型',
  `state` int(8) DEFAULT NULL COMMENT '状态',
  `org_code` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '组织编号',
  `create_time` datetime DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_organization
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL,
  `role_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称',
  `role_type` int(8) DEFAULT NULL COMMENT '角色类型',
  `state` int(8) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_module
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_module`;
CREATE TABLE `sys_role_module` (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `module_id` int(11) DEFAULT NULL COMMENT '模块id',
  `create_time` datetime DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_role_module
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_organization`;
CREATE TABLE `sys_role_organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_role_organization
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名',
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '姓名',
  `mobile` varchar(13) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号',
  `password` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('9', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('10', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('11', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('12', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('13', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('14', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('15', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('16', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('17', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('18', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('19', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('20', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('21', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('22', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('23', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('24', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('25', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('26', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('27', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('28', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('29', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('30', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('31', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('32', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('33', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('34', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('35', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('36', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('37', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('38', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('39', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('40', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('41', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('42', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('43', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('44', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('45', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('46', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('47', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('48', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('49', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('50', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('51', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('52', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('53', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('54', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('55', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('56', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('57', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('58', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('59', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('60', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('61', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('62', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('63', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('64', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('65', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('66', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('67', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('68', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('69', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('70', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('71', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('72', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('73', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('74', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('75', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('76', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('77', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('78', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('79', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('80', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('81', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('82', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('83', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('84', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('85', null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_user_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE `sys_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `gender` int(8) DEFAULT NULL COMMENT '性别字典编码',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `create_time` datetime DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_user_info
-- ----------------------------
INSERT INTO `sys_user_info` VALUES ('1', '2000000000', null, null, null, null, null, null, null);
