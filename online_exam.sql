/*
 Navicat Premium Data Transfer

 Source Server         : Mac_Mysql
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : online_exam

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 28/12/2020 19:03:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class_course
-- ----------------------------
DROP TABLE IF EXISTS `class_course`;
CREATE TABLE `class_course` (
  `classes_Id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级Id(不是班号是classes表的Id)',
  `user_Id` varchar(11) NOT NULL COMMENT '教师工号',
  `cou_Id` varchar(32) NOT NULL COMMENT '课程Id',
  PRIMARY KEY (`classes_Id`,`user_Id`,`cou_Id`) USING BTREE,
  KEY `cou_Id` (`cou_Id`),
  KEY `user_Id` (`user_Id`),
  CONSTRAINT `class_course_ibfk_1` FOREIGN KEY (`classes_Id`) REFERENCES `classes` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `class_course_ibfk_2` FOREIGN KEY (`cou_Id`) REFERENCES `course` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `class_course_ibfk_3` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级和课程的关系';

-- ----------------------------
-- Records of class_course
-- ----------------------------
BEGIN;
INSERT INTO `class_course` VALUES ('271d08cd9f064b758d161d1ce4271abc', '11', 'LT96785089');
INSERT INTO `class_course` VALUES ('0d465103dba84396a16a3e873b0d9c90', '12', 'JF01786131');
INSERT INTO `class_course` VALUES ('0d465103dba84396a16a3e873b0d9c90', '12', 'LF46137944');
INSERT INTO `class_course` VALUES ('271d08cd9f064b758d161d1ce4271abc', '12', 'DO69754940');
COMMIT;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `Id` varchar(32) NOT NULL,
  `class_Id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班号',
  `people_Num` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班级人数',
  `class_Col_Id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班级所属学院',
  `class_Spe_Id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班级所属专业',
  PRIMARY KEY (`Id`),
  KEY `fk_classes_college_1` (`class_Col_Id`),
  KEY `fk_classes_specialty_1` (`class_Spe_Id`),
  CONSTRAINT `fk_classes_college_1` FOREIGN KEY (`class_Col_Id`) REFERENCES `college` (`Id`),
  CONSTRAINT `fk_classes_specialty_1` FOREIGN KEY (`class_Spe_Id`) REFERENCES `specialty` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级信息';

-- ----------------------------
-- Records of classes
-- ----------------------------
BEGIN;
INSERT INTO `classes` VALUES ('0d465103dba84396a16a3e873b0d9c90', '1801701', '0', '75d2a68ba28146e08414f1a6f9c3afef', 'f02f730c6fb642ed894f75b8c8d63c20');
INSERT INTO `classes` VALUES ('271d08cd9f064b758d161d1ce4271abc', '1801301', '0', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `classes` VALUES ('31842a950a2442d58615182e27f1bef6', '1801712', '0', '75d2a68ba28146e08414f1a6f9c3afef', 'f02f730c6fb642ed894f75b8c8d63c20');
INSERT INTO `classes` VALUES ('4c4caa248b4d4ae5aa95c7a0d96b7cdf', '1801712', '0', '75d2a68ba28146e08414f1a6f9c3afef', 'f02f730c6fb642ed894f75b8c8d63c20');
INSERT INTO `classes` VALUES ('6df21aa7afe148dab2c21fa2e738ea3c', '1801702', '0', '75d2a68ba28146e08414f1a6f9c3afef', 'f02f730c6fb642ed894f75b8c8d63c20');
INSERT INTO `classes` VALUES ('aa3eed642c1b49cfa3667b61ecec4564', '1801312', '0', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `classes` VALUES ('dd1820f6ec924ecdb5fda0addf337219', '1801311', '0', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `classes` VALUES ('f3e03d56cdb34d8c8a033b242a464e7b', '1801711', '0', '75d2a68ba28146e08414f1a6f9c3afef', 'f02f730c6fb642ed894f75b8c8d63c20');
COMMIT;

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `Id` varchar(32) NOT NULL,
  `col_Name` varchar(255) DEFAULT NULL COMMENT '学院名称',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学院信息';

-- ----------------------------
-- Records of college
-- ----------------------------
BEGIN;
INSERT INTO `college` VALUES ('033d5e75b2ba46628ad1472111d385cb', '艺术与传媒学院');
INSERT INTO `college` VALUES ('03c722d5bcb84931913e00413ec8c284', '服装学院');
INSERT INTO `college` VALUES ('2f25dc4bff3848129d5f4544f283bac3', '经济管理学院');
INSERT INTO `college` VALUES ('3cb8d052e08f43cda361595bee5bee77', '机器人工程学院');
INSERT INTO `college` VALUES ('657b1f31c1c844e88e7c45ddd9ae9590', '电子信息工程学院');
INSERT INTO `college` VALUES ('75d2a68ba28146e08414f1a6f9c3afef', '数据科学与人工智能学院');
INSERT INTO `college` VALUES ('919d2ccfb6c24fa28ff3156e67a84ff4', '智能汽车与航空学院');
INSERT INTO `college` VALUES ('c34afcf78f214465ac039e99bb343cd9', '外语学院');
INSERT INTO `college` VALUES ('cfa0cb4f01a045c89a048bb4c7d191a3', '机电与材料工程学院');
INSERT INTO `college` VALUES ('db8e18fc61d943f6a8029d79f63dffef', '建筑与土木工程学院');
COMMIT;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `Id` varchar(32) NOT NULL,
  `cou_Name` varchar(255) DEFAULT NULL COMMENT '科目名称',
  `spe_Id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `spe_Id` (`spe_Id`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`spe_Id`) REFERENCES `specialty` (`Id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='科目';

-- ----------------------------
-- Records of course
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES ('CY10049087', 'Windows程序设计', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `course` VALUES ('DO69754940', 'Linux系统应用B', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `course` VALUES ('DY85361912', 'C语言程序进阶', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `course` VALUES ('FD37618215', '软件工程', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `course` VALUES ('JF01786131', 'Oracle数据库管理', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `course` VALUES ('LF46137944', 'Python语言程序设计', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `course` VALUES ('LT96785089', 'Java语言程序设计', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `course` VALUES ('NL87749954', '计算机组成原理B', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `course` VALUES ('NQ27555432', '软件建模与UML', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `course` VALUES ('NQ37724444', '数据库系统原理及应用A', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `course` VALUES ('SV55354634', '计算机网络B', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `course` VALUES ('TT001', 'Spring Boot开发实战', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `course` VALUES ('TT30258254', '软件界面交互设计', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `course` VALUES ('UN60337724', '机器学习导论', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `course` VALUES ('XS38840530', 'C语言程序设计', '7b7519c5b88a4f6dbf717f56f9275196');
COMMIT;

-- ----------------------------
-- Table structure for error_question
-- ----------------------------
DROP TABLE IF EXISTS `error_question`;
CREATE TABLE `error_question` (
  `Id` varchar(32) NOT NULL,
  `user_Id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `question_Id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_error_question_user_1` (`user_Id`),
  KEY `fk_error_question_question_1` (`question_Id`),
  CONSTRAINT `fk_error_question_question_1` FOREIGN KEY (`question_Id`) REFERENCES `question` (`Id`),
  CONSTRAINT `fk_error_question_user_1` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='错题表';

-- ----------------------------
-- Records of error_question
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for knowledge
-- ----------------------------
DROP TABLE IF EXISTS `knowledge`;
CREATE TABLE `knowledge` (
  `Id` varchar(32) NOT NULL,
  `cou_Id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学科Id',
  `kwl_Level` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '知识点等级',
  `chapter_Num` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '章数',
  `section_Num` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '节数',
  `kwl_Name` varchar(255) DEFAULT NULL COMMENT '知识点名称',
  `parent_Id` varchar(32) DEFAULT NULL COMMENT '若为二级知识点，标注一级知识点Id',
  PRIMARY KEY (`Id`),
  KEY `fk_knowledge_course_1` (`cou_Id`),
  CONSTRAINT `fk_knowledge_course_1` FOREIGN KEY (`cou_Id`) REFERENCES `course` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='知识点';

-- ----------------------------
-- Records of knowledge
-- ----------------------------
BEGIN;
INSERT INTO `knowledge` VALUES ('02998b1d9ed24b6997bf34489f0ce93a', 'TT001', '1', '6', '0', 'Spring Boot的Web服务开发', '');
INSERT INTO `knowledge` VALUES ('03fbe94762f24dc993febe997fe73740', 'TT001', '2', '8', '6', '实现邮件发送', '6bcc6f43a01d4a3d90cfd25d6df5da27');
INSERT INTO `knowledge` VALUES ('110798df369d4040af822ae67edc179f', 'TT001', '2', '7', '3', '使用Druid', 'f4c1c0b7b8d4403281a384beaf86aa2e');
INSERT INTO `knowledge` VALUES ('1476d68e9f5845a98504c21bc86f3474', 'TT001', '2', '5', '6', '访问Neo4j数据库', 'b09a699abadb4daf8db965f98f8a6184');
INSERT INTO `knowledge` VALUES ('1676633b1bd44e6699d808eff6136cb8', 'TT001', '2', '8', '7', '用REST Docs创建API文档', '6bcc6f43a01d4a3d90cfd25d6df5da27');
INSERT INTO `knowledge` VALUES ('19aa6822940545deac87579b3149e99d', 'TT001', '2', '5', '2', '使用Spring Data JPA访问H2数据库', 'b09a699abadb4daf8db965f98f8a6184');
INSERT INTO `knowledge` VALUES ('1da6ab6b6fb841aabba5474f2cb4c3a4', 'TT001', '2', '3', '3', 'Spring Boot的注解', '3761a938e68d440fb96cd8d1200af46d');
INSERT INTO `knowledge` VALUES ('240d3ff4d9764ef79308c71e095a827d', 'TT001', '2', '9', '3', '实现基于WebFlux的RESTflu服务', '5b8f45ed33ee409493f8aaa4b3e16096');
INSERT INTO `knowledge` VALUES ('2734441f1cff4993a89854b1492a401e', 'TT001', '2', '6', '6', '实现超媒体驱动的RESTful风格Web服务', '02998b1d9ed24b6997bf34489f0ce93a');
INSERT INTO `knowledge` VALUES ('27acfa3982f54ece9edf13c68de68a2d', 'TT001', '1', '10', '0', 'Spring Boot开发案例', '');
INSERT INTO `knowledge` VALUES ('2a45efe480a346589c54353ea1e2b900', 'TT001', '2', '8', '4', '访问HDFS', '6bcc6f43a01d4a3d90cfd25d6df5da27');
INSERT INTO `knowledge` VALUES ('2fc3239065a94f2bae6167675c872bc0', 'TT001', '2', '5', '5', '访问MongoDB数据库', 'b09a699abadb4daf8db965f98f8a6184');
INSERT INTO `knowledge` VALUES ('3079e99f20fe4a46913e184941306f8f', 'TT001', '1', '12', '0', '附录B 简易签到系统的开发', '');
INSERT INTO `knowledge` VALUES ('31b0a756c3ee4ff989ec140e23c28b54', 'TT001', '2', '9', '7', '基于WebFlux使用WebSocket', '5b8f45ed33ee409493f8aaa4b3e16096');
INSERT INTO `knowledge` VALUES ('3440e75384ab4f5c8810fcdfaa3c6197', 'TT001', '2', '2', '2', '创建项目', '89b20e23e565482186e684dcf9347c41');
INSERT INTO `knowledge` VALUES ('3761a938e68d440fb96cd8d1200af46d', 'TT001', '1', '3', '0', 'Spring Boot 的相关注解', '');
INSERT INTO `knowledge` VALUES ('3dc1d5329a8e4d79a3ff39c204bfcde4', 'TT001', '1', '14', '0', '附录D Spring Boot和Vue.js的整合开发', '');
INSERT INTO `knowledge` VALUES ('41fd63384d2949f59e5e63b9d2f53d9b', 'TT001', '2', '5', '1', '使用JDBC访问H2数据库', 'b09a699abadb4daf8db965f98f8a6184');
INSERT INTO `knowledge` VALUES ('43b67e82c81545c5b322809ebb6785fa', 'TT001', '2', '4', '5', 'Spring Boot对Ajax的应用', 'ddfc439e98b14f5694a3fb94ced681f4');
INSERT INTO `knowledge` VALUES ('43ecea2f81284378bf4530ea6e448731', 'TT001', '2', '2', '3', '实现Hello World的Web应用', '89b20e23e565482186e684dcf9347c41');
INSERT INTO `knowledge` VALUES ('4c979c7ccf9c4859b6cad38a7eb4bc21', 'TT001', '1', '1', '0', 'Spring Boot 简介', '');
INSERT INTO `knowledge` VALUES ('4d754037bc614b119b0793e95fa68ffb', 'TT001', '2', '8', '1', '文件上传', '6bcc6f43a01d4a3d90cfd25d6df5da27');
INSERT INTO `knowledge` VALUES ('4dfd046539e849ab8f12a650f3f88e6e', 'TT001', '2', '2', '4', '以Hello World的应用为例说明项目属性配置', '89b20e23e565482186e684dcf9347c41');
INSERT INTO `knowledge` VALUES ('4e8abe4880f34e3893be9d65490e6d82', 'TT001', '2', '5', '4', '使用Spring Data JPA访问MySQL数据库', 'b09a699abadb4daf8db965f98f8a6184');
INSERT INTO `knowledge` VALUES ('52fb9e08739a4f1ea93225f94547eebe', 'TT001', '2', '2', '5', 'Spring Boot 开发的一般步骤', '89b20e23e565482186e684dcf9347c41');
INSERT INTO `knowledge` VALUES ('563ed0866f9045a8b84a2ca84786bf28', 'TT001', '2', '9', '2', 'WebFlux入门应用', '5b8f45ed33ee409493f8aaa4b3e16096');
INSERT INTO `knowledge` VALUES ('5b8f45ed33ee409493f8aaa4b3e16096', 'TT001', '1', '9', '0', 'Spring Boot的WebFlux开发', '');
INSERT INTO `knowledge` VALUES ('6bcc6f43a01d4a3d90cfd25d6df5da27', 'TT001', '1', '8', '0', 'Spring Boot的文件应用', '');
INSERT INTO `knowledge` VALUES ('6f5ebac70ab74d3ba4f651c732e36585', 'TT001', '2', '7', '1', '声明式事务', 'f4c1c0b7b8d4403281a384beaf86aa2e');
INSERT INTO `knowledge` VALUES ('7c1fe72c51f94e79a4992ee609a1a7ac', 'TT001', '2', '4', '7', '带Bootstrap的jQuery的Web应用', 'ddfc439e98b14f5694a3fb94ced681f4');
INSERT INTO `knowledge` VALUES ('7cefc2dd8cc94b1a89e032645348b7fc', 'TT001', '2', '7', '2', '数据缓存', 'f4c1c0b7b8d4403281a384beaf86aa2e');
INSERT INTO `knowledge` VALUES ('80ee737fae59453990301f49d0a99073', 'TT001', '2', '9', '1', 'WebFlux及其编程模型', '5b8f45ed33ee409493f8aaa4b3e16096');
INSERT INTO `knowledge` VALUES ('845dc955299a43fa8287078ac79f8140', 'TT001', '2', '7', '4', '使用表单验证', 'f4c1c0b7b8d4403281a384beaf86aa2e');
INSERT INTO `knowledge` VALUES ('89b20e23e565482186e684dcf9347c41', 'TT001', '1', '2', '0', 'Spring Boot 开发起步', '');
INSERT INTO `knowledge` VALUES ('8c1609b7bc594389a19593722f76a7de', 'TT001', '2', '6', '2', '使用RESTful风格Web服务', '02998b1d9ed24b6997bf34489f0ce93a');
INSERT INTO `knowledge` VALUES ('8cda106844974a9d8be322b086e0f3e1', 'TT001', '2', '10', '2', '案例实现', '27acfa3982f54ece9edf13c68de68a2d');
INSERT INTO `knowledge` VALUES ('97ee59c4b984402e9f38c3a3ece31dc3', 'TT001', '2', '1', '2', 'Spring Boot 的特征', '4c979c7ccf9c4859b6cad38a7eb4bc21');
INSERT INTO `knowledge` VALUES ('9e6bae7ff2d642c0ab45db2a5c859a98', 'TT001', '2', '5', '3', '使用Spring Data JPA和RESTful访问H2数据库', 'b09a699abadb4daf8db965f98f8a6184');
INSERT INTO `knowledge` VALUES ('a7fc49be9eae46a4b8831fba92d258d0', 'TT001', '1', '13', '0', '附录C 作为微信小程序后台的简单开发', '');
INSERT INTO `knowledge` VALUES ('b09a699abadb4daf8db965f98f8a6184', 'TT001', '1', '5', '0', 'Spring Boot的数据库访问', '');
INSERT INTO `knowledge` VALUES ('b3149d32e9a4423094a752fe5adc8ed1', 'TT001', '2', '6', '7', '整合CXF的Web服务开发', '02998b1d9ed24b6997bf34489f0ce93a');
INSERT INTO `knowledge` VALUES ('b64c9d80ac024a339a25a81731cb60bd', 'TT001', '2', '5', '7', '访问数据库完整示例', 'b09a699abadb4daf8db965f98f8a6184');
INSERT INTO `knowledge` VALUES ('b7aec7e1206e4f02aac6bdc954db15de', 'TT001', '2', '6', '1', '基于Jersey实现RESTful风格Web服务', '02998b1d9ed24b6997bf34489f0ce93a');
INSERT INTO `knowledge` VALUES ('bb0eaec8643e44ba9cee948af3ceb4b5', 'TT001', '2', '9', '4', '基于WebFlux访问MongoDB数据库', '5b8f45ed33ee409493f8aaa4b3e16096');
INSERT INTO `knowledge` VALUES ('bb557e9ac98f495cacc4d17a1e8d5a16', 'TT001', '2', '10', '1', '案例分析', '27acfa3982f54ece9edf13c68de68a2d');
INSERT INTO `knowledge` VALUES ('bce7378a8d434a4fad90da9114dcb825', 'TT001', '2', '7', '5', '整合MyBatis访问数据库', 'f4c1c0b7b8d4403281a384beaf86aa2e');
INSERT INTO `knowledge` VALUES ('bff49856c6384bd78cae2bda5cad5fdc', 'TT001', '2', '7', '6', '整合Spring Batch和Quartz', 'f4c1c0b7b8d4403281a384beaf86aa2e');
INSERT INTO `knowledge` VALUES ('c111994721bc4451b18449663964d772', 'TT001', '2', '9', '6', '基于WebFlux访问Redis数据库', '5b8f45ed33ee409493f8aaa4b3e16096');
INSERT INTO `knowledge` VALUES ('c23d0c7d7806495f892386a55cb6c004', 'TT001', '2', '3', '1', 'Java 注解', '3761a938e68d440fb96cd8d1200af46d');
INSERT INTO `knowledge` VALUES ('c65cc7fe4afa44a6848831e42bd3b2c3', 'TT001', '2', '8', '2', '文件下载', '6bcc6f43a01d4a3d90cfd25d6df5da27');
INSERT INTO `knowledge` VALUES ('d0e1dec1e7174eef97ffc3a8dec889f2', 'TT001', '2', '9', '5', '基于WebFlux使用ThyMeleaf和MongoDB', '5b8f45ed33ee409493f8aaa4b3e16096');
INSERT INTO `knowledge` VALUES ('d5f339cea3d94002bc76ddfe22302ad4', 'TT001', '2', '1', '1', 'Spring Boot 的发展背景', '4c979c7ccf9c4859b6cad38a7eb4bc21');
INSERT INTO `knowledge` VALUES ('d8a921c56e9d4a2da414030ee46c0899', 'TT001', '2', '4', '2', '实现基于Thymeleaf的Web应用', 'ddfc439e98b14f5694a3fb94ced681f4');
INSERT INTO `knowledge` VALUES ('da25ff901c9d4d989011ff043ad137b1', 'TT001', '2', '4', '3', 'Thymeleaf的语法与使用', 'ddfc439e98b14f5694a3fb94ced681f4');
INSERT INTO `knowledge` VALUES ('ddfc439e98b14f5694a3fb94ced681f4', 'TT001', '1', '4', '0', 'Spring Boot的Web应用开发', '');
INSERT INTO `knowledge` VALUES ('de97dfc5b2d14f23a9d19f1de3009dea', 'TT001', '2', '3', '2', 'Spring 注解及注解注入', '3761a938e68d440fb96cd8d1200af46d');
INSERT INTO `knowledge` VALUES ('df45b964f1904c768cb21452300a512f', 'TT001', '2', '6', '3', '使用带AngularJS的RESTful风格Web服务', '02998b1d9ed24b6997bf34489f0ce93a');
INSERT INTO `knowledge` VALUES ('e086505a683b4927a7ccddfd7437a745', 'TT001', '2', '8', '3', '图片文件上传和显示', '6bcc6f43a01d4a3d90cfd25d6df5da27');
INSERT INTO `knowledge` VALUES ('e1eaf9e740734e09aac2894e11fc52ba', 'TT001', '1', '11', '0', '附录A 简易天气预报系统的开发', '');
INSERT INTO `knowledge` VALUES ('e5046277608d4faaaed5a0d32c3320ad', 'TT001', '2', '6', '4', '基于Actuator实现RESTful风格Web服务', '02998b1d9ed24b6997bf34489f0ce93a');
INSERT INTO `knowledge` VALUES ('ea087e2102c7482f937ed1104df773a4', 'TT001', '2', '4', '8', '使用Servlet、过滤器、监听器和拦截器', 'ddfc439e98b14f5694a3fb94ced681f4');
INSERT INTO `knowledge` VALUES ('ea389969044b4cd993a892d0aa9da151', 'TT001', '2', '4', '1', '实现静态Web页面', 'ddfc439e98b14f5694a3fb94ced681f4');
INSERT INTO `knowledge` VALUES ('ea8187edefe840a8b755f0349079a6e7', 'TT001', '2', '8', '5', '用Elasticsearch实现全文搜索', '6bcc6f43a01d4a3d90cfd25d6df5da27');
INSERT INTO `knowledge` VALUES ('ee7e61e078624598a911532f96a94cf8', 'TT001', '2', '4', '4', '实现基于Freemarker的Web应用', 'ddfc439e98b14f5694a3fb94ced681f4');
INSERT INTO `knowledge` VALUES ('f4c1c0b7b8d4403281a384beaf86aa2e', 'TT001', '1', '7', '0', 'Spring Boot的数据处理', '');
INSERT INTO `knowledge` VALUES ('f6a7eba88fb04586a01da4d584d51daa', 'TT001', '2', '1', '3', 'Spring Boot 的工作机制', '4c979c7ccf9c4859b6cad38a7eb4bc21');
INSERT INTO `knowledge` VALUES ('f90409304b8340c2ba1aed0d55ae5b70', 'TT001', '2', '6', '5', '实现跨域资源共享的RESTful风格Web服务', '02998b1d9ed24b6997bf34489f0ce93a');
INSERT INTO `knowledge` VALUES ('fb730e2863874155a5a76dd73468cd64', 'TT001', '2', '4', '6', 'Spring Boot是爱你RESTful风格Web应用', 'ddfc439e98b14f5694a3fb94ced681f4');
INSERT INTO `knowledge` VALUES ('ffeb05571fc440699c1f1f38f4d13d80', 'TT001', '2', '2', '1', '配置开发环境', '89b20e23e565482186e684dcf9347c41');
COMMIT;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `Id` varchar(32) NOT NULL,
  `cou_Id` varchar(32) DEFAULT NULL COMMENT '科目',
  `type_Id` varchar(32) DEFAULT NULL COMMENT '题目类型',
  `subject` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '题目',
  `choice_A` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `choice_B` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `choice_C` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `choice_D` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `answer` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `degree` varchar(255) DEFAULT NULL COMMENT '难度系数0.85，0.65，0.45，0.25',
  `kwl_Id` varchar(32) DEFAULT NULL COMMENT '所属知识点',
  `analysis` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '解析',
  PRIMARY KEY (`Id`),
  KEY `fk_question_course_1` (`cou_Id`),
  KEY `fk_question_question_type_1` (`type_Id`),
  KEY `fk_question_knowledge_1` (`kwl_Id`),
  CONSTRAINT `fk_question_course_1` FOREIGN KEY (`cou_Id`) REFERENCES `course` (`Id`),
  CONSTRAINT `fk_question_knowledge_1` FOREIGN KEY (`kwl_Id`) REFERENCES `knowledge` (`Id`),
  CONSTRAINT `fk_question_question_type_1` FOREIGN KEY (`type_Id`) REFERENCES `question_type` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题库';

-- ----------------------------
-- Records of question
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for question_type
-- ----------------------------
DROP TABLE IF EXISTS `question_type`;
CREATE TABLE `question_type` (
  `Id` varchar(32) NOT NULL,
  `type_Name` varchar(255) DEFAULT NULL COMMENT ' 题目类型名称',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题目类型';

-- ----------------------------
-- Records of question_type
-- ----------------------------
BEGIN;
INSERT INTO `question_type` VALUES ('1f45bd0005c541b998731546b3b8909a', '单选题');
INSERT INTO `question_type` VALUES ('9d1ec85c8fdd40ba8b4cc733d4d72581', '填空题');
INSERT INTO `question_type` VALUES ('a3514b0394a940cea19d5e1ef74b041f', '简答题');
INSERT INTO `question_type` VALUES ('b5046eea8c484ec8ab011da3a650a1e5', '判断题');
INSERT INTO `question_type` VALUES ('c1998c2fa8ba4c02b47d17d2838b3a1a', '多选题');
COMMIT;

-- ----------------------------
-- Table structure for specialty
-- ----------------------------
DROP TABLE IF EXISTS `specialty`;
CREATE TABLE `specialty` (
  `Id` varchar(32) NOT NULL,
  `spe_Name` varchar(255) DEFAULT NULL COMMENT '专业名称',
  `col_Id` varchar(32) DEFAULT NULL COMMENT '学院Id',
  PRIMARY KEY (`Id`),
  KEY `fk_specialty_college_1` (`col_Id`),
  CONSTRAINT `fk_specialty_college_1` FOREIGN KEY (`col_Id`) REFERENCES `college` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专业';

-- ----------------------------
-- Records of specialty
-- ----------------------------
BEGIN;
INSERT INTO `specialty` VALUES ('03f39602d3734ec5b3013186090bad95', '国际经济与贸易', '2f25dc4bff3848129d5f4544f283bac3');
INSERT INTO `specialty` VALUES ('09b9ea4b517e4b359b0f77461d32a543', '土木工程', 'db8e18fc61d943f6a8029d79f63dffef');
INSERT INTO `specialty` VALUES ('0fd82b0f96f748eba7500c93c94a9d47', '机器人工程', '3cb8d052e08f43cda361595bee5bee77');
INSERT INTO `specialty` VALUES ('13ac3cb6785543f9a22690a33ffa2806', '环境设计', '033d5e75b2ba46628ad1472111d385cb');
INSERT INTO `specialty` VALUES ('19b5da2e6c2340f6aa61a7a2aae95539', '材料成型与控制工程', 'cfa0cb4f01a045c89a048bb4c7d191a3');
INSERT INTO `specialty` VALUES ('2169e356cbc74af78207815ef5a0f1a8', '财务管理', '2f25dc4bff3848129d5f4544f283bac3');
INSERT INTO `specialty` VALUES ('27667d513ea44288ad9d5bfb70bca22a', '工程管理', 'db8e18fc61d943f6a8029d79f63dffef');
INSERT INTO `specialty` VALUES ('3a94a30d0c2b44aaa62f6b0514f921ca', '车辆工程', '919d2ccfb6c24fa28ff3156e67a84ff4');
INSERT INTO `specialty` VALUES ('3cf197e385704e65ab7bf55e5918e8fc', '人力资源管理', '2f25dc4bff3848129d5f4544f283bac3');
INSERT INTO `specialty` VALUES ('3d388d1aed544d319a1488677651c276', '智能制造工程', '3cb8d052e08f43cda361595bee5bee77');
INSERT INTO `specialty` VALUES ('4534e357736b4836b214e88101d14250', '市场营销', '2f25dc4bff3848129d5f4544f283bac3');
INSERT INTO `specialty` VALUES ('518c6e0c4fdb419d882c7c7a91da1027', '英语', 'c34afcf78f214465ac039e99bb343cd9');
INSERT INTO `specialty` VALUES ('5225f30b772f43a7b6c563b935b7d936', '交通运输', '919d2ccfb6c24fa28ff3156e67a84ff4');
INSERT INTO `specialty` VALUES ('6122800037604242be3dc38af7edd886', '工商管理', '2f25dc4bff3848129d5f4544f283bac3');
INSERT INTO `specialty` VALUES ('64d5b831e62d4b26abf3bd7eeb8e0083', '机械电子工程', '3cb8d052e08f43cda361595bee5bee77');
INSERT INTO `specialty` VALUES ('699be5f8e1184ff69e8e3699456973af', '工业设计', 'cfa0cb4f01a045c89a048bb4c7d191a3');
INSERT INTO `specialty` VALUES ('6c250a73c72d45ad811bc7cd250e93e9', '自动化', '3cb8d052e08f43cda361595bee5bee77');
INSERT INTO `specialty` VALUES ('6c6c150715414f1abbe5b649a88e02c8', '机械设计制造及其自动化', 'cfa0cb4f01a045c89a048bb4c7d191a3');
INSERT INTO `specialty` VALUES ('7219d6469da2483c8e45593c6f6dce80', '建筑学', 'db8e18fc61d943f6a8029d79f63dffef');
INSERT INTO `specialty` VALUES ('7b7519c5b88a4f6dbf717f56f9275196', '软件工程', '75d2a68ba28146e08414f1a6f9c3afef');
INSERT INTO `specialty` VALUES ('7d918a6ef934497aba2489be2f2ad58a', '工程造价', 'db8e18fc61d943f6a8029d79f63dffef');
INSERT INTO `specialty` VALUES ('8f757c7f6f714cf79083f1d78d47ed18', '信息工程', '657b1f31c1c844e88e7c45ddd9ae9590');
INSERT INTO `specialty` VALUES ('9c6f95cd7e714389b762751d26e26824', '俄语', 'c34afcf78f214465ac039e99bb343cd9');
INSERT INTO `specialty` VALUES ('9eb4116974154261a1b0cbb63ac9f58e', '视觉传达设计', '033d5e75b2ba46628ad1472111d385cb');
INSERT INTO `specialty` VALUES ('9f398d36c98146baa9a6200b64b35aaf', '广播电视编导', '033d5e75b2ba46628ad1472111d385cb');
INSERT INTO `specialty` VALUES ('9f7a39fd7ecf4bc6a9b88d5bb2b542bb', '焊接技术与工程', 'cfa0cb4f01a045c89a048bb4c7d191a3');
INSERT INTO `specialty` VALUES ('aacc98e96d1a4118b59ea87d2f870428', '数字媒体艺术', '033d5e75b2ba46628ad1472111d385cb');
INSERT INTO `specialty` VALUES ('b9d8b5e294a1464ea51b9793c944aa54', '动画', '033d5e75b2ba46628ad1472111d385cb');
INSERT INTO `specialty` VALUES ('c139109142b94af4bdbe1ee5cecf5de7', '汽车服务工程', '919d2ccfb6c24fa28ff3156e67a84ff4');
INSERT INTO `specialty` VALUES ('c3149e70342f41cf81971daecf630ab3', '电子信息工程', '657b1f31c1c844e88e7c45ddd9ae9590');
INSERT INTO `specialty` VALUES ('c9ab76be552a4fb38179a8f39f28094a', '信息管理与信息系统', '75d2a68ba28146e08414f1a6f9c3afef');
INSERT INTO `specialty` VALUES ('cd4d595ffc4645c9bc0170704f698dc1', '计算机科学与技术', '75d2a68ba28146e08414f1a6f9c3afef');
INSERT INTO `specialty` VALUES ('d3e4d49690d6406c89569618cbe7925d', '物联网科学与大数据技术', '75d2a68ba28146e08414f1a6f9c3afef');
INSERT INTO `specialty` VALUES ('db8eb08297ba44bb8c19cf0d9227403e', '服装设计与工程', '03c722d5bcb84931913e00413ec8c284');
INSERT INTO `specialty` VALUES ('ec0d778bf76b4c038ec6f629464e0c89', '通信工程', '657b1f31c1c844e88e7c45ddd9ae9590');
INSERT INTO `specialty` VALUES ('f02f730c6fb642ed894f75b8c8d63c20', '大数据', '75d2a68ba28146e08414f1a6f9c3afef');
INSERT INTO `specialty` VALUES ('f822ccd2f2c64bed9b1342ef281d1709', '服装与服装设计', '03c722d5bcb84931913e00413ec8c284');
INSERT INTO `specialty` VALUES ('fa869406e4ca414ead05726fea7a9f9d', '电器工程及其自动化', '3cb8d052e08f43cda361595bee5bee77');
COMMIT;

-- ----------------------------
-- Table structure for student_basic
-- ----------------------------
DROP TABLE IF EXISTS `student_basic`;
CREATE TABLE `student_basic` (
  `user_Id` varchar(20) NOT NULL,
  `stu_ClassId` varchar(32) DEFAULT NULL COMMENT '所属班级',
  `stu_College` varchar(32) DEFAULT NULL COMMENT '所属学院',
  `stu_Specialty` varchar(32) DEFAULT NULL COMMENT '所属专业',
  PRIMARY KEY (`user_Id`),
  KEY `fk_student_basic_classes_1` (`stu_ClassId`),
  KEY `fk_student_basic_college_1` (`stu_College`),
  KEY `fk_student_basic_specialty_1` (`stu_Specialty`),
  CONSTRAINT `fk_student_basic_classes_1` FOREIGN KEY (`stu_ClassId`) REFERENCES `classes` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_student_basic_college_1` FOREIGN KEY (`stu_College`) REFERENCES `college` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_student_basic_specialty_1` FOREIGN KEY (`stu_Specialty`) REFERENCES `specialty` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_student_basic_user_1` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生基础信息';

-- ----------------------------
-- Records of student_basic
-- ----------------------------
BEGIN;
INSERT INTO `student_basic` VALUES ('1180130101', '271d08cd9f064b758d161d1ce4271abc', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `student_basic` VALUES ('1180130116', '271d08cd9f064b758d161d1ce4271abc', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `student_basic` VALUES ('1180131101', 'dd1820f6ec924ecdb5fda0addf337219', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `student_basic` VALUES ('1180131201', 'aa3eed642c1b49cfa3667b61ecec4564', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
COMMIT;

-- ----------------------------
-- Table structure for teacher_basic
-- ----------------------------
DROP TABLE IF EXISTS `teacher_basic`;
CREATE TABLE `teacher_basic` (
  `user_Id` varchar(20) NOT NULL,
  `college_Id` varchar(32) DEFAULT NULL COMMENT '所属学院',
  `specialty_Id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属专业',
  PRIMARY KEY (`user_Id`),
  KEY `fk_teacher_basic_college_1` (`college_Id`),
  KEY `fk_teacher_basic_specialty_1` (`specialty_Id`),
  CONSTRAINT `fk_teacher_basic_college_1` FOREIGN KEY (`college_Id`) REFERENCES `college` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_teacher_basic_specialty_1` FOREIGN KEY (`specialty_Id`) REFERENCES `specialty` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_teacher_basic_user_1` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师基础信息';

-- ----------------------------
-- Records of teacher_basic
-- ----------------------------
BEGIN;
INSERT INTO `teacher_basic` VALUES ('11', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `teacher_basic` VALUES ('12', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
COMMIT;

-- ----------------------------
-- Table structure for test_ueditor
-- ----------------------------
DROP TABLE IF EXISTS `test_ueditor`;
CREATE TABLE `test_ueditor` (
  `Id` varchar(32) NOT NULL,
  `text` longtext,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_ueditor
-- ----------------------------
BEGIN;
INSERT INTO `test_ueditor` VALUES ('15aa0bd91e81405a8c0174e62775326d', '<p>123</p>');
INSERT INTO `test_ueditor` VALUES ('2e111ff8078e4934a8c2940b507ab143', '<p>Question:123</p><p><img src=\"/images/61f7adbcbb8c453ea6665ddc1982cdae.png\" title=\"坑1\" alt=\"坑1\"/></p><p>Answer:123</p><p><img src=\"/images/d3541fc2a496470d88e28fb520a02c5c.png\" title=\"集成5\" alt=\"集成5\"/></p>');
INSERT INTO `test_ueditor` VALUES ('80985e818afc4afd8a9becc59e288c6e', '<p>Question:123</p><p>Answer:123</p>');
INSERT INTO `test_ueditor` VALUES ('c83711d75f6b4fbf8f02ee7740834b6a', '<h2 style=\"box-sizing: border-box; font-family: &quot;open sans&quot;, sans-serif; font-weight: 500; line-height: 32px; color: rgb(51, 51, 51); margin-top: 20px; margin-bottom: 10px; font-size: 30px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"box-sizing: border-box;\">SSM接入UEditor编辑器及会遇到的坑</span></h2><p>&nbsp;</p><blockquote style=\"box-sizing: border-box; padding: 10px 20px; margin: 0px 0px 20px; font-size: 17.5px; border-left: 5px solid rgb(238, 238, 238);\"><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 0px;\">背景：项目要用到富文本编辑器。<br/>ueditor下载地址：<a href=\"https://ueditor.baidu.com/website/download.html\" target=\"_blank\" style=\"box-sizing: border-box; background: 0px 0px; color: rgb(66, 139, 202); text-decoration-line: none;\">https://ueditor.baidu.com/website/download.html</a><br/>官方配置文档：<a href=\"https://fex.baidu.com/ueditor/#server-jsp\" target=\"_blank\" style=\"box-sizing: border-box; background: 0px 0px; color: rgb(66, 139, 202); text-decoration-line: none;\">https://fex.baidu.com/ueditor/#server-jsp</a></p></blockquote><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\">记录仓促，后续持续更新……</p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\">视频效果：<br/><img src=\"images/6d9222bc05cc4c5e8578a0b8f5b06696.png\" title=\"\" alt=\"视频效果\"/></p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\">富文本效果：<br/><img src=\"images/101c05d83df548a0b57b71d7a616e216.png\" title=\"\" alt=\"富文本效果\"/>目前进展：无法配置tomcat虚拟目录，无法导入重编译的jar，只能将文件放在tomcat目录。大家可以研究下。</p><hr/><p>Web集成UEditor步骤：<br/>1.环境： jdk 7，tomcat7，jsp，windows<br/>2.建立web项目 3.将官网下载的rar解压</p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\"><img src=\"images/40290471419d455292490c61bbe3b700.png\" title=\"\" alt=\"集成1\"/>4.文件夹重命名为ueditor，其他命名也可以。<br/><br/>5.整体导入项目<br/><img src=\"images/a01506bff9a6414d9061c338f6363628.png\" title=\"\" alt=\"集成2\"/></p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\">如图所示，这里放在了webContent目录，红叉是json文件有注释。</p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\"><img src=\"images/5eec7c02ab18430e987e90a0942a8aa9.png\" title=\"\" alt=\"集成3\"/></p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\">6.将ueditor-》jsp-》lib下的5个jar包，同时复制到web-info-》lib下。</p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\">至此，图文上传可以实现。下面讲到上传后回显，及页面可以读到上传的文件。</p><hr/><p>7.编辑框要实现回显，同时页面能读取，需要：1.json配置参数 2. tomcat配置虚拟路径</p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\">8.json配置</p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\"><img src=\"images/1caf344e9fce4a53b880dc44fb707f2b.png\" title=\"\" alt=\"集成4\"/></p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\">官方下载下来，红框这里是“”，需要手动配置，才能实现回显和读取。<br/>9.tomcat虚拟路径<br/><img src=\"images/5daab79c94d84b5abc74d306ce9a184c.png\" title=\"\" alt=\"集成5\"/>两个参数：docBase：磁盘物理路径，path：虚拟路径，对应第8步的“/upload”</p><hr/><p>至此，上传、回显、读取实现。缺点，无法实现tomcat目录外虚拟路径，也是目前研究的问题。</p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\"><span style=\"color:red\">下面说些坑：</span><br/>1.官网下载的rar解压后，5个jar包不能做任何改动，包括移动、复制等操作。否则，就会报错：大意为，目标jar包jdk版本与当前项目不匹配。<br/>2.解决方案，参考步骤1-5，不要动jar文件夹，只重命名，然后整体拷贝进项目。<br/><img src=\"images/bcd262d9682c4fa99a385e2bd5ceff73.png\" title=\"\" alt=\"坑1\"/></p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\">如果配置不正确，这里的图片上传等多个上传相关的插件无法使用，提示异常。同时控制台会报错。</p><hr/><p>修改了ueditor-1.2.1.jar，重新打成jar，导入项目会报错，导致无法解决部署tomcat外的虚拟目录。目前正在寻求解决方案，正在研究中，欢迎大家提供经验。</p><blockquote style=\"box-sizing: border-box; padding: 10px 20px; margin: 0px 0px 20px; font-size: 17.5px; border-left: 5px solid rgb(238, 238, 238);\"><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 0px;\">文章仓促，仅作笔记，后续修改，欢迎探讨。</p></blockquote><p><br/></p>');
INSERT INTO `test_ueditor` VALUES ('cf5ee57914f84ca1bddc70fc332190f2', '<p>Question_Subject<br/></p><p>Question_Answer<br/></p>');
INSERT INTO `test_ueditor` VALUES ('d7f12fcd46594566b6f2418a1ab7c75f', '<p>Java</p><pre class=\"brush:java;toolbar:false\">public&nbsp;static&nbsp;void&nbsp;main(String&nbsp;[]&nbsp;args){\r\n&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(&quot;Hello&nbsp;World!&quot;);\r\n}</pre><p><img src=\"images/435a9f1c37f84dfe971361f0272d0510.png\" title=\"\" alt=\"富文本效果\" width=\"819\" height=\"531\"/><br/></p><p><br/></p><p><br/></p>');
INSERT INTO `test_ueditor` VALUES ('e7a039fc233247b981e7da21203d18d2', '<p>123</p>');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_Id` varchar(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_Name` varchar(255) DEFAULT NULL,
  `user_Type` varchar(32) DEFAULT NULL COMMENT '用户类型',
  `user_Sex` varchar(4) DEFAULT NULL,
  `user_Mobile` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`user_Id`),
  KEY `fk_user_user_type_1` (`user_Type`),
  CONSTRAINT `fk_user_user_type_1` FOREIGN KEY (`user_Type`) REFERENCES `user_type` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('11', 'e10adc3949ba59abbe56e057f20f883e', '测试教师11', 'c97b09ac65ba4684839a905646b3eff3', '男', '12345678901');
INSERT INTO `user` VALUES ('1180130101', 'e10adc3949ba59abbe56e057f20f883e', '李双权', '629fa6a84a254a9996518829910154d0', '男', '12345678901');
INSERT INTO `user` VALUES ('1180130116', 'e10adc3949ba59abbe56e057f20f883e', '姚远', '629fa6a84a254a9996518829910154d0', '男', '12345678901');
INSERT INTO `user` VALUES ('1180131101', 'e10adc3949ba59abbe56e057f20f883e', '311测试用户', '629fa6a84a254a9996518829910154d0', '男', '12345678901');
INSERT INTO `user` VALUES ('1180131201', 'e10adc3949ba59abbe56e057f20f883e', '312测试用户', '629fa6a84a254a9996518829910154d0', '男', '12345678901');
INSERT INTO `user` VALUES ('12', 'e10adc3949ba59abbe56e057f20f883e', '测试教师12', 'c97b09ac65ba4684839a905646b3eff3', '男', '12345678901');
INSERT INTO `user` VALUES ('admin', 'e10adc3949ba59abbe56e057f20f883e', 'Admin', 'c8d4c17743b14deebda71170c43f12b4', '女', '12345678901');
COMMIT;

-- ----------------------------
-- Table structure for user_type
-- ----------------------------
DROP TABLE IF EXISTS `user_type`;
CREATE TABLE `user_type` (
  `Id` varchar(32) NOT NULL,
  `user_Type` varchar(255) DEFAULT NULL COMMENT '用户类型',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户类型';

-- ----------------------------
-- Records of user_type
-- ----------------------------
BEGIN;
INSERT INTO `user_type` VALUES ('629fa6a84a254a9996518829910154d0', '学生');
INSERT INTO `user_type` VALUES ('c8d4c17743b14deebda71170c43f12b4', '教学秘书');
INSERT INTO `user_type` VALUES ('c97b09ac65ba4684839a905646b3eff3', '教师');
COMMIT;

-- ----------------------------
-- View structure for view_class_info
-- ----------------------------
DROP VIEW IF EXISTS `view_class_info`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_class_info` AS select `classes`.`Id` AS `Id`,`classes`.`class_Id` AS `class_Id`,`classes`.`people_Num` AS `people_Num`,`college`.`col_Name` AS `col_Name`,`specialty`.`spe_Name` AS `spe_Name` from ((`classes` join `college`) join `specialty`) where ((`college`.`Id` = `classes`.`class_Col_Id`) and (`specialty`.`Id` = `classes`.`class_Spe_Id`));

-- ----------------------------
-- View structure for view_course_info
-- ----------------------------
DROP VIEW IF EXISTS `view_course_info`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_course_info` AS select `course`.`Id` AS `Id`,`course`.`cou_Name` AS `cou_Name`,`specialty`.`spe_Name` AS `spe_Name` from (`course` join `specialty` on((`course`.`spe_Id` = `specialty`.`Id`)));

-- ----------------------------
-- View structure for view_knowledge
-- ----------------------------
DROP VIEW IF EXISTS `view_knowledge`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_knowledge` AS select `knowledge`.`Id` AS `Id`,`knowledge`.`cou_Id` AS `cou_Id`,`course`.`cou_Name` AS `cou_Name`,`knowledge`.`kwl_Level` AS `kwl_Level`,`knowledge`.`chapter_Num` AS `chapter_Num`,`knowledge`.`section_Num` AS `section_Num`,`knowledge`.`kwl_Name` AS `kwl_Name`,`knowledge`.`parent_Id` AS `parent_Id` from (`knowledge` join `course` on((`knowledge`.`cou_Id` = `course`.`Id`)));

-- ----------------------------
-- View structure for view_question_info
-- ----------------------------
DROP VIEW IF EXISTS `view_question_info`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_question_info` AS select distinct `question`.`Id` AS `Id`,`course`.`cou_Name` AS `cou_Name`,`question_type`.`type_Name` AS `type_Name`,`question`.`subject` AS `subject`,`question`.`choice_A` AS `choice_A`,`question`.`choice_B` AS `choice_B`,`question`.`choice_C` AS `choice_C`,`question`.`choice_D` AS `choice_D`,`question`.`answer` AS `answer`,`question`.`degree` AS `degree`,`knowledge`.`kwl_Name` AS `kwl_Name`,`question`.`analysis` AS `analysis` from (((`question` join `course` on((`question`.`cou_Id` = `course`.`Id`))) join `knowledge` on(((`question`.`kwl_Id` = `knowledge`.`Id`) and (`course`.`Id` = `knowledge`.`cou_Id`)))) join `question_type` on((`question`.`type_Id` = `question_type`.`Id`)));

-- ----------------------------
-- View structure for view_studentbasic_info
-- ----------------------------
DROP VIEW IF EXISTS `view_studentbasic_info`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_studentbasic_info` AS select `user`.`user_Id` AS `user_Id`,`user`.`user_Name` AS `user_Name`,`classes`.`class_Id` AS `class_Id`,`college`.`col_Name` AS `col_Name`,`specialty`.`spe_Name` AS `spe_Name` from ((((`user` join `student_basic` on((`user`.`user_Id` = `student_basic`.`user_Id`))) join `classes` on((`student_basic`.`stu_ClassId` = `classes`.`Id`))) join `college` on(((`classes`.`class_Col_Id` = `college`.`Id`) and (`student_basic`.`stu_College` = `college`.`Id`)))) join `specialty` on(((`classes`.`class_Spe_Id` = `specialty`.`Id`) and (`student_basic`.`stu_Specialty` = `specialty`.`Id`) and (`college`.`Id` = `specialty`.`col_Id`))));

-- ----------------------------
-- View structure for view_teacher_class_info
-- ----------------------------
DROP VIEW IF EXISTS `view_teacher_class_info`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_teacher_class_info` AS select `class_course`.`user_Id` AS `user_Id`,`user`.`user_Name` AS `user_Name`,`class_course`.`classes_Id` AS `classes_Id`,`classes`.`class_Id` AS `class_Id`,`class_course`.`cou_Id` AS `cou_Id`,`course`.`cou_Name` AS `cou_Name` from (((`class_course` join `user` on((`class_course`.`user_Id` = `user`.`user_Id`))) join `classes` on((`class_course`.`classes_Id` = `classes`.`Id`))) join `course` on((`class_course`.`cou_Id` = `course`.`Id`)));

SET FOREIGN_KEY_CHECKS = 1;
