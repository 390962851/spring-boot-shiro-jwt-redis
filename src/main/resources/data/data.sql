/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : mybatis-plus

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2020-08-24 16:05:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for consumables
-- ----------------------------
DROP TABLE IF EXISTS `consumables`;
CREATE TABLE `consumables` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `assets_name` varchar(25) DEFAULT NULL COMMENT '资产名称',
  `type` varchar(25) DEFAULT NULL COMMENT '型号',
  `unit` varchar(25) DEFAULT NULL COMMENT '单位',
  `quantity` int(10) DEFAULT NULL COMMENT '数量',
  `prices` int(10) unsigned zerofill DEFAULT NULL COMMENT '价格',
  `storage_date` date DEFAULT NULL COMMENT '入库日期',
  `recipients` varchar(25) DEFAULT NULL COMMENT '领取人',
  `remarks` varchar(30) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of consumables
-- ----------------------------
INSERT INTO `consumables` VALUES ('1', '笔记本second', 'A101是的', '长城', '5', '0000001205', '2020-07-10', '张三', '没有描述');
INSERT INTO `consumables` VALUES ('2', 'Mac笔记水水', 'Apple', 'hongsa', '5', '0000000054', '2020-07-10', '张三', '没有描述');
INSERT INTO `consumables` VALUES ('3', 'Mac笔记本3', 'Apple', '学习', '5', '0000000057', '2020-07-10', '张三', '没有描述');
INSERT INTO `consumables` VALUES ('4', 'Mac笔记本5', 'Apple', '政府', '5', '0000009854', '2020-07-10', '张三', '没有描述');
INSERT INTO `consumables` VALUES ('5', 'Mac笔记本29', 'Apple', '日本', '5', '0000000875', '2020-07-10', '张三', '没有描述');
INSERT INTO `consumables` VALUES ('6', 'Mac笔记本30', 'Apple', '搜索', '5', '0000000965', '2020-07-10', '张三', '没有描述');
INSERT INTO `consumables` VALUES ('7', '你来了', '搜索', 'hongsa', '60', '0000000895', '2020-07-30', '搜索', '');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `c_name` varchar(20) NOT NULL COMMENT '课程名',
  `t_id` int(11) NOT NULL COMMENT '教师',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '语文', '2');
INSERT INTO `course` VALUES ('2', '数学', '1');
INSERT INTO `course` VALUES ('3', '英语', '3');

-- ----------------------------
-- Table structure for invisiable_assets
-- ----------------------------
DROP TABLE IF EXISTS `invisiable_assets`;
CREATE TABLE `invisiable_assets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `assets_name` varchar(25) DEFAULT NULL COMMENT '资产名称',
  `assets_type` varchar(25) DEFAULT NULL COMMENT '资产类别',
  `storage_date` date DEFAULT NULL COMMENT '入库日期',
  `assets_value` float(25,2) DEFAULT NULL COMMENT '资产原值',
  `depreciation_rate` float(5,2) DEFAULT NULL COMMENT '摊销率',
  `depreciation_period` int(10) DEFAULT NULL COMMENT '摊销年限',
  `depreciated_date` int(15) DEFAULT NULL COMMENT '已摊销日期',
  `depreciation_month` float(10,2) DEFAULT NULL COMMENT '本月摊销',
  `depreciation_acc` float(20,2) DEFAULT NULL COMMENT '累计摊销',
  `asset_net_value` float(25,2) DEFAULT NULL COMMENT '资产净值',
  `storage_loca` varchar(25) DEFAULT NULL COMMENT '存放地点',
  `status` int(10) DEFAULT NULL COMMENT '状态',
  `status_date` date DEFAULT NULL COMMENT '转卖时间',
  `remarks` varchar(30) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `status` (`status`) USING BTREE,
  CONSTRAINT `invisiable_assets_ibfk_1` FOREIGN KEY (`status`) REFERENCES `regular_status` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of invisiable_assets
-- ----------------------------
INSERT INTO `invisiable_assets` VALUES ('1', '笔记本second', '电子产品', '2020-07-10', '9999.00', '2.00', '5', '6', '199.98', '1199.88', '8799.12', '仓库', '3', '2020-07-30', '没有描述');
INSERT INTO `invisiable_assets` VALUES ('2', 'Mac笔记水水', '电子产品', '2020-07-10', '9999.00', '20.00', '12', '6', '199.98', '1199.88', '8799.12', '仓库', '2', null, '没有描述');
INSERT INTO `invisiable_assets` VALUES ('3', 'Mac笔记本3', '电子产品', '2020-07-10', '9999.00', '20.00', '5', '6', '199.98', '1199.88', '8799.12', '仓库', '3', '2020-07-09', '没有描述');
INSERT INTO `invisiable_assets` VALUES ('4', 'Mac笔记本5', '电子产品', '2020-07-10', '9999.00', '20.00', '54', '6', '199.98', '1199.88', '8799.12', '仓库', '1', null, '没有描述');
INSERT INTO `invisiable_assets` VALUES ('5', 'Mac笔记本29', '电子产品', '2020-07-10', '9999.00', '20.00', '5', '6', '199.98', '1199.88', '8799.12', '仓库', '2', null, '没有描述');
INSERT INTO `invisiable_assets` VALUES ('6', 'Mac笔记本30', '电子产品', '2020-07-10', '9999.00', '20.00', '5', '6', '199.98', '1199.88', '8799.12', '仓库', '4', '2020-07-13', '没有描述');
INSERT INTO `invisiable_assets` VALUES ('7', 'Mac笔记本杀杀杀', '电子产品', '2020-07-10', '9999.00', '20.00', '5', '6', '199.98', '1199.88', '8799.12', '仓库', '2', null, '没有描述');
INSERT INTO `invisiable_assets` VALUES ('8', 'Mac笔记', '电子产品', '2020-07-10', '9999.00', '20.00', '12', '6', '199.98', '1199.88', '8799.12', '仓库', '4', '2020-07-31', '没有描述');
INSERT INTO `invisiable_assets` VALUES ('9', '电竞椅', '固定', '2020-07-31', '1000.00', '1.00', '1', '3', '10.00', '30.00', '1000.00', '公司', '1', null, '不好用');

-- ----------------------------
-- Table structure for regular_assets
-- ----------------------------
DROP TABLE IF EXISTS `regular_assets`;
CREATE TABLE `regular_assets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `assets_name` varchar(25) DEFAULT NULL COMMENT '资产名称',
  `assets_type` varchar(25) DEFAULT NULL COMMENT '资产类别',
  `type` varchar(25) DEFAULT NULL COMMENT '型号',
  `unit` varchar(25) DEFAULT NULL COMMENT '单位',
  `quantity` int(10) DEFAULT NULL COMMENT '数量',
  `storage_date` date DEFAULT NULL COMMENT '入库日期',
  `recipients` varchar(25) DEFAULT NULL COMMENT '领取人',
  `assets_value` float(25,2) DEFAULT NULL COMMENT '资产原值',
  `depreciation_rate` float(5,2) DEFAULT NULL COMMENT '折旧率',
  `depreciation_period` int(10) DEFAULT NULL COMMENT '折旧年限',
  `depreciated_date` int(15) DEFAULT NULL COMMENT '已折旧日期',
  `depreciation_month` float(10,2) DEFAULT NULL COMMENT '本月折旧',
  `depreciation_acc` float(20,2) DEFAULT NULL COMMENT '累计折旧',
  `asset_net_value` float(25,2) DEFAULT NULL COMMENT '资产净值',
  `storage_loca` varchar(25) DEFAULT NULL COMMENT '存放地点',
  `status` int(10) DEFAULT NULL COMMENT '状态',
  `remarks` varchar(30) DEFAULT NULL COMMENT '备注',
  `status_date` date DEFAULT NULL COMMENT '报废、转卖时间',
  PRIMARY KEY (`id`),
  KEY `status` (`status`),
  CONSTRAINT `regular_assets_ibfk_1` FOREIGN KEY (`status`) REFERENCES `regular_status` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of regular_assets
-- ----------------------------
INSERT INTO `regular_assets` VALUES ('1', '笔记顶', '电子产品', 'A101是的', '长城', '5', '2020-07-10', '张三', '9999.00', '2.00', '5', '6', '199.98', '1199.88', '8799.12', '仓库', '1', '没有描述', null);
INSERT INTO `regular_assets` VALUES ('2', 'Mac笔记水水', '电子产品', 'Apple', '长城', '5', '2020-07-10', '张三', '9999.00', '20.00', '5', '6', '199.98', '1199.88', '8799.12', '仓库', '2', '没有描述', null);
INSERT INTO `regular_assets` VALUES ('3', 'Mac笔记本3', '电子产品', 'Apple', '长城', '5', '2020-07-10', '张三', '9999.00', '20.00', '5', '6', '199.98', '1199.88', '8799.12', '仓库', '3', '没有描述', '2020-07-09');
INSERT INTO `regular_assets` VALUES ('4', 'Mac笔记本5', '电子产品', 'Apple', '长城', '5', '2020-07-10', '张三', '9999.00', '20.00', '5', '6', '199.98', '1199.88', '8799.12', '仓库', '1', '没有描述', null);
INSERT INTO `regular_assets` VALUES ('5', 'Mac笔记本29', '电子产品', 'Apple', '长城', '5', '2020-07-10', '张三', '9999.00', '20.00', '5', '6', '199.98', '1199.88', '8799.12', '仓库', '2', '没有描述', null);
INSERT INTO `regular_assets` VALUES ('6', 'Mac笔记本30', '电子产品', 'Apple', '长城', '5', '2020-07-10', '张三', '9999.00', '20.00', '5', '6', '199.98', '1199.88', '8799.12', '仓库', '4', '没有描述', '2020-07-13');
INSERT INTO `regular_assets` VALUES ('7', '搜索', 'Mac', '搜索', 'hongsa', '60', '2020-07-30', '搜索', '10000.00', '10.00', null, '6', '1000.00', '6000.00', '0.00', '', '4', '', '2020-07-30');
INSERT INTO `regular_assets` VALUES ('8', 'swssdf', 'error', 'A10110', 'hs', '100', '2020-07-31', '李斯', '10000.00', '0.50', null, '10', '50.00', '500.00', '10000.00', '', '3', '', '2020-07-31');
INSERT INTO `regular_assets` VALUES ('9', 'swssdf', 'error', 'A10110', 'hs', '100', '2020-07-31', '李斯', '10000.00', '0.50', null, '10', '50.00', '500.00', '10000.00', '', '3', '', '2020-07-31');
INSERT INTO `regular_assets` VALUES ('10', 'swssdf', 'error', 'A10110', 'hs', '100', '2020-07-31', '李斯', '10000.00', '0.50', null, '10', '50.00', '500.00', '10000.00', '', '3', '', '2020-07-31');
INSERT INTO `regular_assets` VALUES ('11', 'swssdf', 'error', 'A10110', 'hs', '100', '2020-07-31', '李斯', '10000.00', '0.50', null, '10', '50.00', '500.00', '10000.00', '', '3', '', '2020-07-31');
INSERT INTO `regular_assets` VALUES ('12', 'swssdf', 'error', 'A10110', 'hs', '100', '2020-07-31', '李斯', '10000.00', '0.50', null, '10', '50.00', '500.00', '10000.00', '', '3', '', '2020-07-31');
INSERT INTO `regular_assets` VALUES ('13', 'swssdf', 'error', 'A10110', 'hs', '100', '2020-07-31', '李斯', '10000.00', '0.50', null, '10', '50.00', '500.00', '10000.00', '', '3', '', '2020-07-31');
INSERT INTO `regular_assets` VALUES ('14', 'swssdf', 'error', 'A10110', 'hs', '100', '2020-07-31', '李斯', '10000.00', '0.50', null, '10', '50.00', '500.00', '10000.00', '', '3', '', '2020-07-31');
INSERT INTO `regular_assets` VALUES ('15', 'swssdf', 'error', 'A10110', 'hs', '100', '2020-07-31', '李斯', '10000.00', '0.50', null, '10', '50.00', '500.00', '10000.00', '', '3', '', '2020-07-31');
INSERT INTO `regular_assets` VALUES ('44', '后悔', '是', '是', '是', '4', '2020-08-01', '水水水水水水', '222220.00', '10.00', '5', '5', '22222.00', '111111.00', '111109.00', '发', '3', '', '2020-08-01');
INSERT INTO `regular_assets` VALUES ('45', 'Mac笔记本', '电子产品', 'Apple', '长城', '5', '2020-07-10', '张三', '9999.00', '20.00', '5', '6', '199.98', '1199.88', '8799.12', '仓库', '2', '没有描述', null);

-- ----------------------------
-- Table structure for regular_status
-- ----------------------------
DROP TABLE IF EXISTS `regular_status`;
CREATE TABLE `regular_status` (
  `status_id` int(11) NOT NULL AUTO_INCREMENT,
  `status_name` varchar(25) DEFAULT NULL,
  `date_time` date DEFAULT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of regular_status
-- ----------------------------
INSERT INTO `regular_status` VALUES ('1', '在用', null);
INSERT INTO `regular_status` VALUES ('2', '库存', null);
INSERT INTO `regular_status` VALUES ('3', '报废', '2020-07-27');
INSERT INTO `regular_status` VALUES ('4', '转卖', '2020-07-15');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `s_id` int(11) NOT NULL COMMENT '编号',
  `c_id` int(11) NOT NULL COMMENT '课程编号',
  `s_score` float(4,2) DEFAULT NULL COMMENT '成绩',
  PRIMARY KEY (`s_id`,`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '1', '80.00');
INSERT INTO `score` VALUES ('1', '2', '90.00');
INSERT INTO `score` VALUES ('1', '3', '99.00');
INSERT INTO `score` VALUES ('2', '1', '70.00');
INSERT INTO `score` VALUES ('2', '2', '60.00');
INSERT INTO `score` VALUES ('2', '3', '80.00');
INSERT INTO `score` VALUES ('3', '1', '80.00');
INSERT INTO `score` VALUES ('3', '2', '80.00');
INSERT INTO `score` VALUES ('3', '3', '80.00');
INSERT INTO `score` VALUES ('4', '1', '50.00');
INSERT INTO `score` VALUES ('4', '2', '30.00');
INSERT INTO `score` VALUES ('4', '3', '20.00');
INSERT INTO `score` VALUES ('5', '1', '76.00');
INSERT INTO `score` VALUES ('5', '2', '87.00');
INSERT INTO `score` VALUES ('6', '1', '31.00');
INSERT INTO `score` VALUES ('6', '3', '34.00');
INSERT INTO `score` VALUES ('7', '2', '89.00');
INSERT INTO `score` VALUES ('7', '3', '98.00');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学号',
  `s_name` varchar(20) NOT NULL COMMENT '姓名',
  `s_birthday` datetime NOT NULL COMMENT '生日',
  `s_sex` varchar(20) NOT NULL COMMENT '性别',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '赵雷', '1990-01-01 00:00:00', '男');
INSERT INTO `student` VALUES ('2', '钱电', '1990-12-21 00:00:00', '男');
INSERT INTO `student` VALUES ('3', '孙风', '1990-05-20 00:00:00', '男');
INSERT INTO `student` VALUES ('4', '李云', '1990-08-06 00:00:00', '男');
INSERT INTO `student` VALUES ('5', '周梅', '1991-12-01 00:00:00', '女');
INSERT INTO `student` VALUES ('6', '吴兰', '1992-03-01 00:00:00', '女');
INSERT INTO `student` VALUES ('7', '郑竹', '1989-07-01 00:00:00', '女');
INSERT INTO `student` VALUES ('8', '王菊', '1990-01-20 00:00:00', '女');
INSERT INTO `student` VALUES ('9', '小梦', '1992-02-06 00:00:00', '女');
INSERT INTO `student` VALUES ('10', '梦', '2020-08-05 15:59:19', '女');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` varchar(32) NOT NULL COMMENT '主键id',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父id',
  `name` varchar(100) DEFAULT NULL COMMENT '菜单标题',
  `url` varchar(255) DEFAULT NULL COMMENT '路径',
  `component` varchar(255) DEFAULT NULL COMMENT '组件-路由',
  `component_name` varchar(100) DEFAULT NULL COMMENT '组件名称',
  `menu_type` int(11) DEFAULT NULL COMMENT '菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)',
  `perms` varchar(255) DEFAULT NULL COMMENT '菜单权限编码',
  `perms_type` varchar(10) DEFAULT '0' COMMENT '权限策略1显示2禁用',
  `icon` varchar(100) DEFAULT NULL COMMENT '菜单图标',
  `is_route` tinyint(1) DEFAULT '1' COMMENT '是否路由菜单: 0:不是  1:是（默认值1）',
  `sort_no` int(10) DEFAULT NULL COMMENT '菜单排序',
  `del_flag` int(1) DEFAULT '0' COMMENT '删除状态 0正常 1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `index_prem_pid` (`parent_id`) USING BTREE,
  KEY `index_prem_sort_no` (`sort_no`) USING BTREE,
  KEY `index_prem_del_flag` (`del_flag`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '0', '新增用户', '/user/add', null, null, '2', 'user:add', '0', null, '0', '1', '0');
INSERT INTO `sys_permission` VALUES ('10', '0', '员工管理', '/table', '', null, '0', null, '0', 'user', '1', '10', '0');
INSERT INTO `sys_permission` VALUES ('11', '10', '', '/table/tableList', 'table', '员工列表', '1', null, '0', null, '1', '11', '0');
INSERT INTO `sys_permission` VALUES ('12', '0', '业务管理', '/business', null, null, '0', null, '0', 'appstore', '1', '12', '0');
INSERT INTO `sys_permission` VALUES ('13', '12', '', '/business/work', 'work_order', '工单管理', '1', null, '0', null, '1', '13', '0');
INSERT INTO `sys_permission` VALUES ('14', '12', '', '/business/complaint', 'complaint', '投诉管理', '1', null, '0', null, '1', '14', '0');
INSERT INTO `sys_permission` VALUES ('15', '12', null, '/business/client', 'client', '客户列表', '1', null, '0', null, '1', '15', '0');
INSERT INTO `sys_permission` VALUES ('16', '0', '聊天', '/chats', null, null, '0', null, '0', 'wechat', '1', '16', '0');
INSERT INTO `sys_permission` VALUES ('17', '0', '用户管理', '/users', null, null, '0', null, '0', 'user', '1', '17', '0');
INSERT INTO `sys_permission` VALUES ('18', '17', null, '/users/userlist', 'users', '用户列表', '1', null, '0', null, '1', '18', '0');
INSERT INTO `sys_permission` VALUES ('19', '0', '角色管理', '/roles', null, null, '0', null, '0', 'trademark', '1', '19', '0');
INSERT INTO `sys_permission` VALUES ('2', '0', '删除用户', '/user/delete', null, null, '2', 'user:delete', '0', null, '0', '2', '0');
INSERT INTO `sys_permission` VALUES ('20', '19', '', '/roles/rolelist', 'roles', '角色列表', '1', null, '0', null, '1', '20', '0');
INSERT INTO `sys_permission` VALUES ('21', '0', '商品管理', '/goods', null, null, '0', null, '0', 'gift', '1', '21', '0');
INSERT INTO `sys_permission` VALUES ('22', '21', null, '/goods/list', 'goods_list', '商品列表', '1', null, '0', null, '1', '22', '0');
INSERT INTO `sys_permission` VALUES ('23', '21', null, '/goods/categories', 'goods_categories', '商品分类', '1', null, '0', null, '1', '23', '0');
INSERT INTO `sys_permission` VALUES ('24', '5', null, '/home', 'home', '数据展示', '1', null, '0', null, '1', null, '0');
INSERT INTO `sys_permission` VALUES ('25', '16', null, '/chats', 'chats', '悄悄话', '1', null, '0', null, '1', null, '0');
INSERT INTO `sys_permission` VALUES ('3', '0', '修改用户', '/user/update', null, null, '2', 'user:update', '0', null, '0', '3', '0');
INSERT INTO `sys_permission` VALUES ('4', '0', '查询用户', '/user/list', null, null, '2', 'user:list', '0', null, '0', '4', '0');
INSERT INTO `sys_permission` VALUES ('5', '0', '主页', '/home', '', null, '0', null, '0', 'radar-chart', '1', '5', '0');
INSERT INTO `sys_permission` VALUES ('6', '0', '资产管理', '/assets', null, null, '0', null, '0', 'money-collect', '1', '6', '0');
INSERT INTO `sys_permission` VALUES ('7', '6', '', '/assets/regular', 'regularAssets', '固定资产', '1', null, '0', null, '1', '7', '0');
INSERT INTO `sys_permission` VALUES ('8', '6', '', '/assets/invisiable', 'invisibleAssets', '无形资产', '1', null, '0', null, '1', '8', '0');
INSERT INTO `sys_permission` VALUES ('9', '6', '', '/assets/consumables', 'consumables', '易耗品', '1', null, '0', null, '1', '9', '0');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '管理角色');
INSERT INTO `sys_role` VALUES ('2', 'test', '测试角色');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `index_group_role_per_id` (`role_id`,`permission_id`) USING BTREE,
  KEY `index_group_role_id` (`role_id`) USING BTREE,
  KEY `index_group_per_id` (`permission_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色权限表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '1', '2');
INSERT INTO `sys_role_permission` VALUES ('3', '1', '3');
INSERT INTO `sys_role_permission` VALUES ('4', '1', '4');
INSERT INTO `sys_role_permission` VALUES ('6', '1', '5');
INSERT INTO `sys_role_permission` VALUES ('7', '1', '6');
INSERT INTO `sys_role_permission` VALUES ('8', '1', '10');
INSERT INTO `sys_role_permission` VALUES ('9', '1', '12');
INSERT INTO `sys_role_permission` VALUES ('10', '1', '16');
INSERT INTO `sys_role_permission` VALUES ('11', '1', '17');
INSERT INTO `sys_role_permission` VALUES ('12', '1', '19');
INSERT INTO `sys_role_permission` VALUES ('13', '1', '21');
INSERT INTO `sys_role_permission` VALUES ('21', '2', '1');
INSERT INTO `sys_role_permission` VALUES ('22', '2', '2');
INSERT INTO `sys_role_permission` VALUES ('23', '2', '3');
INSERT INTO `sys_role_permission` VALUES ('24', '2', '4');
INSERT INTO `sys_role_permission` VALUES ('25', '2', '5');
INSERT INTO `sys_role_permission` VALUES ('26', '2', '6');
INSERT INTO `sys_role_permission` VALUES ('27', '2', '10');
INSERT INTO `sys_role_permission` VALUES ('28', '2', '12');
INSERT INTO `sys_role_permission` VALUES ('29', '2', '12');
INSERT INTO `sys_role_permission` VALUES ('30', '2', '16');
INSERT INTO `sys_role_permission` VALUES ('31', '2', '21');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(100) DEFAULT NULL COMMENT '登录账号',
  `real_name` varchar(100) DEFAULT NULL COMMENT '真实姓名',
  `pass_word` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(100) DEFAULT NULL COMMENT 'md5密码盐',
  `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除状态(0-正常,1-已删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `index_user_name` (`user_name`) USING BTREE,
  KEY `index_user_del_flag` (`del_flag`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '超级管理员', 'cb362cfeefbf3d8d', 'RCGTeGiH', '0');
INSERT INTO `sys_user` VALUES ('2', 'test', '测试用户', '471439d316637955', '5FMD48RM', '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `index2_groupuu_user_id` (`user_id`) USING BTREE,
  KEY `index2_groupuu_ole_id` (`role_id`) USING BTREE,
  KEY `index2_groupuu_useridandroleid` (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户角色表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2', '2');
