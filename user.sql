/*
 Navicat Premium Data Transfer

 Source Server         : jdbc
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : bcos

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 12/11/2023 23:48:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id（账号）',
  `uname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `idcard` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '开户时间',
  `role` int(0) NULL DEFAULT NULL COMMENT '类型：0-管理员，1-普通用户',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `activation` int(0) NULL DEFAULT NULL COMMENT '用户激活状态',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1018 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1000, 'Admin', '123456', '18133334444', '', '2021-07-20 10:00:00', 0, '', '', 0);
INSERT INTO `user` VALUES (1001, 'Alice', '123456', '18255551386', '', '2021-07-20 10:00:00', 1, '', '', 0);
INSERT INTO `user` VALUES (1002, 'Bob', '123456', '18934568981', '', '2021-07-20 10:00:00', 1, NULL, NULL, 0);
INSERT INTO `user` VALUES (1003, 'Clover', '123456', '18066668899', '', '2021-07-21 10:00:00', 1, '', '', 0);
INSERT INTO `user` VALUES (1004, 'Divid', '123456', '19938204321', '', '2021-07-21 10:00:00', 0, '', '', 0);
INSERT INTO `user` VALUES (1005, 'Lisa', '123456', '18685441692', '', '2021-10-08 09:12:55', 1, NULL, NULL, 0);
INSERT INTO `user` VALUES (1006, 'Flower', '123456', '15569435215', '', '2021-11-03 11:03:33', 1, NULL, NULL, 0);
INSERT INTO `user` VALUES (1007, 'Patton', '123456', '13654432963', '', '2021-11-03 15:25:14', 1, NULL, NULL, 0);
INSERT INTO `user` VALUES (1008, 'Nicole', '123456', '15532865941', '', '2021-11-04 09:32:58', 1, NULL, NULL, 0);
INSERT INTO `user` VALUES (1009, 'Anthony', '123456', '15432688140', '', '2021-11-04 12:22:35', 1, NULL, NULL, 0);
INSERT INTO `user` VALUES (1010, 'Zane', '123456', '15564823650', '', '2021-11-05 10:23:37', 1, '', NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
