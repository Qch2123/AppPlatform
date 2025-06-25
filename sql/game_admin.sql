/*
 Navicat Premium Dump SQL

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50719 (5.7.19)
 Source Host           : localhost:3306
 Source Schema         : game_admin

 Target Server Type    : MySQL
 Target Server Version : 50719 (5.7.19)
 File Encoding         : 65001

 Date: 25/06/2025 17:15:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_category
-- ----------------------------
DROP TABLE IF EXISTS `app_category`;
CREATE TABLE `app_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `categoryCode` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '分类编码',
  `categoryName` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '分类名称',
  `parentId` bigint(20) NULL DEFAULT NULL COMMENT '父级节点id',
  `createdBy` bigint(20) NULL DEFAULT NULL COMMENT '创建者（来源于backend_user用户表的用户id）',
  `creationTime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 128 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '手游类别' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of app_category
-- ----------------------------
INSERT INTO `app_category` VALUES (1, 'ALL_GAME', '全部游戏', NULL, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (2, 'GAME_001', '休闲游戏', 1, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (3, 'GAME_002', '益智游戏', 1, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (4, 'GAME_003', '体育游戏', 1, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (5, 'GAME_004', '角色扮演', 1, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (115, 'GAME_004_01_02', '局域网', 28, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (57, 'GAME_002_03_01', '车内逃脱', 24, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (21, 'GAME_001_03', '消除类', 2, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (24, 'GAME_002_03', '密室逃脱类', 3, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (25, 'GAME_003_01', '球类', 4, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (26, 'GAME_003_02', '赛车类', 4, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (28, 'GAME_004_01', '射击类', 5, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (120, 'GAME_004_03_02', '多阵营', 42, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (119, 'GAME_004_03_01', '双阵营', 42, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (118, 'GAME_004_02_02', '3D', 41, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (117, 'GAME_004_02_01', '拳皇', 41, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (116, 'GAME_004_01_03', '广域网', 28, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (112, 'GAME_003_02_01', '汽车', 26, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (111, 'GAME_003_01_03', '排球', 25, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (110, 'GAME_003_01_02', '篮球', 25, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (109, 'GAME_003_01_01', '足球', 25, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (58, 'GAME_002_03_02', '房内逃脱', 24, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (41, 'GAME_004_02', '格斗类', 5, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (42, 'GAME_004_03', '策略对战', 5, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (43, 'GAME_004_04', '冒险升级', 5, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (49, 'GAME_001_03_01', '同色消除', 21, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (50, 'GAME_001_03_02', '连线消除', 21, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (114, 'GAME_004_01_01', '单机', 28, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (113, 'GAME_003_02_02', '摩托车', 26, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (121, 'GAME_004_03_03', '5V5', 42, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (122, 'GAME_004_04_01', '单机', 43, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (123, 'GAME_004_04_01', '广域网', 43, 11, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (59, 'GAME_002_03_03', '其他场景', 24, 1, '2016-08-12 18:11:47');
INSERT INTO `app_category` VALUES (40, 'GAME_001_04', '模拟类', 2, 1, '2016-08-12 18:11:55');
INSERT INTO `app_category` VALUES (80, 'GAME_001_04_01', '沙盒类', 40, 1, '2016-08-12 18:11:58');
INSERT INTO `app_category` VALUES (81, 'GAME_002_04', '解谜类', 3, 1, '2016-08-12 18:11:48');
INSERT INTO `app_category` VALUES (82, 'GAME_002_04_01', '物理解谜类', 81, 1, '2016-08-12 18:11:49');
INSERT INTO `app_category` VALUES (6, 'GAME_005', '生存类', 1, 1, '2016-08-12 18:11:50');
INSERT INTO `app_category` VALUES (83, 'GAME_005_01', '动作类', 6, 1, '2016-08-12 18:11:51');
INSERT INTO `app_category` VALUES (84, 'GAME_005_01_01', '冒险类', 83, 1, '2016-08-12 18:11:52');
INSERT INTO `app_category` VALUES (85, 'GAME_002_04_02', '冒险类', 81, 1, '2016-08-12 18:11:53');
INSERT INTO `app_category` VALUES (86, 'GAME_001_05', '竞速类', 2, 1, '2016-08-12 18:11:54');
INSERT INTO `app_category` VALUES (87, 'GAME_001_05_01', '赛车', 86, 1, '2016-08-12 18:11:55');
INSERT INTO `app_category` VALUES (88, 'GAME_002_04_02', '消除类', 81, 1, '2016-08-12 18:11:55');
INSERT INTO `app_category` VALUES (91, 'GAME_002_05', '策略推理类', 3, 1, '2016-08-12 18:11:55');
INSERT INTO `app_category` VALUES (92, 'GAME_002_05_01', '社交类', 91, 1, '2016-08-12 18:11:55');
INSERT INTO `app_category` VALUES (93, 'GAME_001_06', '无尽跑酷类', 2, 1, '2016-08-12 18:11:55');
INSERT INTO `app_category` VALUES (94, 'GAME_001_06_01', '3D', 93, 1, '2016-08-12 18:11:55');
INSERT INTO `app_category` VALUES (95, 'GAME_004_02_03', '动作竞技', 41, 1, '2016-08-12 18:11:55');
INSERT INTO `app_category` VALUES (96, 'GAME_001_05_02', '跑酷', 86, 1, '2016-08-12 18:11:55');
INSERT INTO `app_category` VALUES (97, 'GAME_002_05_02', '竞技类', 91, 1, '2016-08-12 18:11:55');
INSERT INTO `app_category` VALUES (98, 'GAME_004_03_04', '非对称竞技', 42, 1, '2016-08-12 18:11:55');
INSERT INTO `app_category` VALUES (99, 'GAME_002_05_03', '策略自走棋', 91, 1, '2016-08-12 18:11:55');

-- ----------------------------
-- Table structure for app_info
-- ----------------------------
DROP TABLE IF EXISTS `app_info`;
CREATE TABLE `app_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `softwareName` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '软件名称',
  `apkName` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT 'APK名称（唯一）',
  `softwareSize` decimal(20, 2) NULL DEFAULT NULL COMMENT '软件大小（单位：M）',
  `devId` bigint(20) NULL DEFAULT NULL COMMENT '开发者id（来源于：dev_user表的开发者id）',
  `appInfo` varchar(5000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '应用简介',
  `status` bigint(20) NULL DEFAULT NULL COMMENT '状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）',
  `flatformId` bigint(20) NULL DEFAULT NULL COMMENT '所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）',
  `categoryLevel3` bigint(20) NULL DEFAULT NULL COMMENT '所属三级分类（来源于：data_dictionary）',
  `downloads` bigint(20) NULL DEFAULT NULL COMMENT '下载量（单位：次）',
  `createdBy` bigint(20) NULL DEFAULT NULL COMMENT '创建者（来源于dev_user开发者信息表的用户id）',
  `creationDate` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modifyDate` datetime NULL DEFAULT NULL COMMENT '最新更新时间',
  `categoryLevel1` bigint(20) NULL DEFAULT NULL COMMENT '所属一级分类（来源于：data_dictionary）',
  `categoryLevel2` bigint(20) NULL DEFAULT NULL COMMENT '所属二级分类（来源于：data_dictionary）',
  `logoPicPath` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT 'LOGO图片url路径',
  `versionId` bigint(20) NULL DEFAULT NULL COMMENT '最新的版本id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of app_info
-- ----------------------------
INSERT INTO `app_info` VALUES (1, '金铲铲之战', 'com.momocorp.o2jamu', 56.00, 1, '《金铲铲之战》是一款 8人同局、策略至上的自走棋手游。玩家通过经济运营购买棋子，组合强力羁绊，合成装备并调整站位，构建独特阵容。战斗自动进行，胜负取决于阵容强度、羁绊搭配、装备分配和站位策略。核心乐趣在于深度策略规划、阵容构筑的多样性与临场决策，以及随机性带来的每局不同体验。', 1, 3, 99, 1000, 1, '2016-08-22 11:43:02', '2025-06-22 23:42:51', 3, 91, 'ab6c5f767865405a85756932dc18b5ea.jpg', 91);
INSERT INTO `app_info` VALUES (2, '我的世界移动版', 'com.lbe.security', 9.00, 2, '《我的世界移动版》是一款 开放世界沙盒建造手游。玩家在一个由方块构成的、几乎无限大的随机生成世界中，通过 自由采集资源、合成制作工具与物品、建造任意结构，同时可选择在 生存模式 中抵御怪物、管理饥饿与生命值以存活探索，或在 创造模式 中无限制地飞行建造，实现无限创意。其核心魅力在于 极高的自由度、无拘束的创造与探索体验。', 1, 1, 80, 2000, 2, '2016-08-22 11:47:11', '2025-06-25 00:33:14', 2, 40, 'b0b2b4b5bf184116986546962d1fde7a.jpg', 25);
INSERT INTO `app_info` VALUES (3, '和平精英', 'com.sp.protector.free', 3.00, 2, '《和平精英》是一款 以生存为最终目标，将最多100名玩家投放到大型地图上，通过搜刮装备武装自己，在信号圈不断缩小的压迫下进行移动、探索、资源管理，并与遭遇的敌人展开紧张射击对抗，强调战术策略、环境适应、射击技巧和生存决策的战术竞技射击游戏。', 1, 1, 116, 5000, 2, '2016-08-22 11:49:12', '2025-06-22 23:53:20', 5, 28, 'e1e157c3b5ef4065a207a8b85622c67a.jpg', 101);
INSERT INTO `app_info` VALUES (4, '英雄联盟手游', 'com.google.android.inputmethod.pinyin', 16.00, 1, '《英雄联盟手游》是一款 5v5硬核MOBA竞技手游，玩家通过 英雄技能连招、精准走位、视野布控与资源争夺，在快节奏（15-25分钟）的对局中，参与 分路对抗或 野区团战，追求策略协作与操作上限，同时养成/精通英雄、掌控战场节奏，兼具深度竞技性与团队博弈。  ', 1, 3, 121, 8000, 1, '2016-08-22 11:53:23', '2025-06-22 23:41:30', 5, 42, '953cbbc1cd5b4c8c8372a349182e6d5c.jpg', 89);
INSERT INTO `app_info` VALUES (5, 'QQ飞车手游', 'com.speedsoftware.rootexplorer', 3.00, 2, '《QQ飞车手游》是一款 多人在线实时竞速手游，玩家通过 漂移集气、氮气加速、赛道捷径突破等操作技巧，在短平快（2-4分钟）的对局中，参与 纯竞速对抗或 道具互殴的娱乐赛，追求极致速度与操控爽感，同时收集/改装赛车、挑战多样赛道，兼具强竞技性与社交性。  ', 1, 1, 87, 2340, 2, '2016-08-22 11:55:14', '2025-06-22 23:54:17', 2, 86, 'd3a15688718b4c8f8fc481233616d40a.jpg', 102);
INSERT INTO `app_info` VALUES (6, '三角洲行动', 'com.katecca.screenofflockdonate', 1.00, 2, '《三角洲行动》是一款 近未来战术射击手游，玩家通过 战术道具协同、兵种技能配合、真实弹道操控与场景破坏，在多元动态战场中，参与 小队突袭渗透或 大型夺控对抗，追求拟真作战与策略执行，同时定制战术装备、适应多变的战场目标，兼具写实战场氛围与深度团队协作。  ', 1, 1, 116, 20, 2, '2016-08-22 13:07:11', '2025-06-22 23:50:33', 5, 28, '613cbb3007ce4028937de291900ab44c.jpg', 98);
INSERT INTO `app_info` VALUES (7, '第五人格', 'com.plexnor.gravityscreenoffpro', 1.00, 1, '《第五人格》是一款 非对称竞技对抗手游，玩家通过 扮演求生者团队协作破译密码机或 担任监管者追捕拦截，在哥特式悬疑场景中，展开 惊悚追逐与策略周旋，追求逃脱升天或全员淘汰的对抗目标，同时利用角色专属技能、环境互动与心跳感应机制，兼具沉浸式恐怖氛围与刺激的心理博弈。', 1, 1, 98, 23, 1, '2016-08-22 13:08:24', '2025-06-22 23:38:38', 5, 42, '2ac6aa759741403c98445f1f12d66979.jpg', 86);
INSERT INTO `app_info` VALUES (8, '球球大作战', 'air.net.machinarium.Machinarium.GP', 11.00, 1, '《球球大作战》是一款 休闲竞技吞噬手游，玩家通过 操控球体移动、分裂合体、吞噬小型球体或资源，在开放式圆形战场中，实现 即时体积成长与生存对抗，追求成为场中巨无霸或巧妙以小博大，同时躲避更大球体的吞噬，兼具简单易上手的操作与瞬息万变的策略乐趣。', 1, 1, 97, 277, 1, '2016-08-22 13:09:44', '2025-06-22 23:34:54', 3, 91, 'f4faea59732243df90530636031b8c5b.jpg', 84);
INSERT INTO `app_info` VALUES (9, '滑雪大冒险', 'com.kleientertainment.doNotStarvePocket', 4.00, 1, '这是一款 横版跑酷逃生手游，玩家通过 单键操控角色跳跃、翻滚、滑行，在雪崩追袭的极速滑坡中， 躲避障碍物（岩石/冰凌/断崖）、完成特技动作、救援动物伙伴充当临时载具（企鹅/雪人/老鹰），追求最远逃生距离与高分挑战，体验快节奏的物理翻滚乐趣与多变地形带来的刺激冒险。', 5, 2, 96, 390, 1, '2016-08-22 13:11:51', '2025-06-22 23:32:34', 2, 86, 'e0802b7f7d3442b2960168851977f477.jpg', 83);
INSERT INTO `app_info` VALUES (10, '永劫无间', 'com.bithack.apparatus', 11.00, 2, '《永劫无间》是一款 武侠风多人动作竞技手游，玩家通过 操控角色施展近战连招、远程武器射击与独特“飞索”立体机动，在动态缩小的战场中，进行 高自由度冷热兵器交锋、利用“振刀”机制弹反制敌、争夺强化符文（魂玉）与神兵，追求成为最终存活的单人/小队，体验写意武侠美学下的硬核动作博弈与快节奏生存对抗。  ', 3, 1, 95, 255, 2, '2016-08-22 13:13:27', '2025-06-22 23:47:48', 5, 41, '84702d78c3934ca0bc786231db2c5727.jpg', 96);
INSERT INTO `app_info` VALUES (11, '地铁跑酷', 'com.doodleapps.powdertoy', 1.00, 2, '《地铁跑酷》是一款 竖版3D跑酷手游，玩家通过 手指滑动控制角色左右移动、上滑跳跃、下滑翻滚，在疾驰的地铁轨道与城市屋顶间， 躲避列车障碍、收集金币道具、拾取喷射背包等增益装备，追求无限奔跑距离与高分挑战，体验快节奏的躲避乐趣与全球城市主题场景的视觉变换。', 5, 3, 94, 2000, 2, '2016-08-22 13:14:56', '2025-06-22 23:45:18', 2, 93, '229bd305f58b4a8aa720e9b83c1a2d6f.jpg', 93);
INSERT INTO `app_info` VALUES (12, '王者荣耀', 'com.timi-wangzherongyao', 2666.00, 1, '《王者荣耀》是一款 以摧毁敌方基地为最终目标，在对称的5v5多路线地图上，通过操控拥有独特技能和定位的英雄，进行对线发育、推塔推进、资源争夺和团队战斗，强调实时操作、战术策略和团队配合的MOBA竞技游戏。', 5, 3, 121, 1000, 1, '2020-03-11 18:05:50', '2025-06-22 23:31:01', 5, 42, 'dba12ef5bbe2476d8444faeb96a09e17.jpg', 81);
INSERT INTO `app_info` VALUES (13, '狼人杀', 'com.timi-langrensha', 21.00, 1, '《狼人杀》是一款 语音社交推理竞技手游，玩家通过 身份扮演（狼人/神职/平民）、夜间行动博弈、日间发言辩论与集体投票放逐，在封闭的虚拟村落中，展开 语言欺骗、逻辑推理与心理攻防，追求所属阵营（狼人阵营屠城或好人阵营驱逐所有狼人）的胜利，体验高强度的口才对抗与人性的多面演绎。  ', 2, 3, 92, 1000, 1, '2021-03-11 18:05:50', '2025-06-22 23:24:16', 3, 91, '17fa4c59d5e34e1db7419e9555931c90.jpg', 75);

-- ----------------------------
-- Table structure for app_version
-- ----------------------------
DROP TABLE IF EXISTS `app_version`;
CREATE TABLE `app_version`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `appId` bigint(20) NULL DEFAULT NULL COMMENT 'appId（来源于：app_info表的主键id）',
  `versionNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '版本号',
  `versionInfo` varchar(2000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '版本介绍',
  `publishStatus` bigint(20) NULL DEFAULT NULL COMMENT '发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）',
  `downloadLink` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '下载链接',
  `versionSize` decimal(20, 2) NULL DEFAULT NULL COMMENT '版本大小（单位：M）',
  `createdBy` bigint(20) NULL DEFAULT NULL COMMENT '创建者（来源于dev_user开发者信息表的用户id）',
  `creationDate` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of app_version
-- ----------------------------
INSERT INTO `app_version` VALUES (1, 13, 'V1.1.1', 'V1.1.1版本简介', 3, '/apk/c3694ec99e664aa9b98b43d82e9fb2a3.apk', 23.00, 1, '2025-06-22 23:23:26');
INSERT INTO `app_version` VALUES (2, 13, 'V1.1.2', 'V1.1.2版本简介', 3, '/apk/6b923bd462f84649945738fee2f8a969.apk', 26.00, 1, '2025-06-22 23:24:16');
INSERT INTO `app_version` VALUES (3, 12, 'V4.0.1', 'V4.0.1版本简介', 3, '/apk/a7e2e8c053bc4a1e840daa3624c82aa8.apk', 39.00, 1, '2025-06-22 23:30:28');
INSERT INTO `app_version` VALUES (4, 12, 'V4.2.1', 'V4.2.1版本简介', 3, '/apk/d4ef275c02c2424bbabec48ebd28dc64.apk', 42.00, 1, '2025-06-22 23:31:01');
INSERT INTO `app_version` VALUES (5, 9, 'V1.1.1', 'V1.1.1版本简介', 3, '/apk/fcc1b60cd5304e978ef5ebc251c0ffa3.apk', 19.00, 1, '2025-06-22 23:32:17');
INSERT INTO `app_version` VALUES (6, 9, 'V1.2.1', 'V1.2.1版本简介', 3, '/apk/9c1cf3426c6b4f32a0d2cef04703e426.apk', 22.00, 1, '2025-06-22 23:32:34');
INSERT INTO `app_version` VALUES (7, 8, 'V1.1.1', 'V1.1.1版本简介', 3, '/apk/e2ce8b699f2b4bbd8a0530ced7d36c9e.apk', 17.00, 1, '2025-06-22 23:34:54');
INSERT INTO `app_version` VALUES (8, 7, 'V3.2.1', 'V3.2.1版本简介', 3, '/apk/94895ce1c1d9449085aa64b94ad7d3c0.apk', 24.00, 1, '2025-06-22 23:35:45');
INSERT INTO `app_version` VALUES (9, 4, 'V4.1.2', 'V4.1.2版本简介', 3, '/apk/14b0285f3c664bca8f619ff1c78df1d2.apk', 28.00, 1, '2025-06-22 23:38:38');
INSERT INTO `app_version` VALUES (10, 4, 'V4.1.1', 'V4.1.1版本简介', 3, '/apk/2436e3df79ee47e486ca084db964b9f8.apk', 25.00, 1, '2025-06-22 23:40:09');
INSERT INTO `app_version` VALUES (11, 4, 'V4.3.2', 'V4.3.2版本简介', 3, '/apk/7a01d53cbd8a43dfaca7fab224b0b972.apk', 30.00, 1, '2025-06-22 23:40:41');
INSERT INTO `app_version` VALUES (12, 4, 'V5.0.1', 'V5.0.1版本简介', 3, '/apk/c1b3731c04d04ca8935fe04b2f12bd4a.apk', 32.00, 1, '2025-06-22 23:41:30');
INSERT INTO `app_version` VALUES (13, 11, 'V1.2.1', 'V1.2.1版本简介', 3, '/apk/8bc532eaa6c44b93895d17e5b56d696a.apk', 20.00, 2, '2025-06-22 23:42:28');
INSERT INTO `app_version` VALUES (14, 11, 'V2.3.6', 'V2.3.6版本简介', 3, '/apk/c337b9ca4e324da489fdfe69aec8e911.apk', 22.00, 2, '2025-06-22 23:42:51');
INSERT INTO `app_version` VALUES (15, 10, 'V1.2.4', 'V1.2.4版本简介', 3, '/apk/df05e029dbf34c7fb30210303a1bac17.apk', 12.00, 2, '2025-06-22 23:44:37');
INSERT INTO `app_version` VALUES (16, 10, 'V2.2.4', 'V2.2.4版本简介', 3, '/apk/81aca52f2cd24bca83c1fec8b5a6fd0d.apk', 24.00, 2, '2025-06-22 23:46:26');
INSERT INTO `app_version` VALUES (17, 10, 'V3.1.5', 'V3.1.5版本简介', 3, '/apk/db9b315c4d274d3d87b0e2746a7d0150.apk', 26.00, 2, '2025-06-22 23:47:03');
INSERT INTO `app_version` VALUES (18, 10, 'V3.4.7', 'V3.4.7版本简介', 3, '/apk/c249acf7e908462aab2a99dba5e08fc7.apk', 28.00, 2, '2025-06-22 23:47:48');
INSERT INTO `app_version` VALUES (19, 6, 'V1.3.2', 'V1.3.2版本简介', 3, '/apk/d90c6e6d39d349c4a9b7abe6cd26c534.apk', 13.00, 2, '2025-06-22 23:49:52');
INSERT INTO `app_version` VALUES (20, 6, 'V2.6.1', 'V2.6.1版本简介', 3, '/apk/d70c527619e147a794f52db49170e3e0.apk', 16.00, 2, '2025-06-22 23:50:33');
INSERT INTO `app_version` VALUES (21, 5, 'V1.5.6', 'V1.5.6版本简介', 3, '/apk/731abaab91a34e9c803d1ecdda5f3322.apk', 19.00, 2, '2025-06-22 23:52:17');
INSERT INTO `app_version` VALUES (22, 5, 'V2.4.6', 'V2.4.6版本简介', 3, '/apk/1404791b01714e36aeef84c0a176fb5f.apk', 22.00, 2, '2025-06-22 23:53:20');
INSERT INTO `app_version` VALUES (23, 3, 'V1.2.1', 'V1.2.1版本简介', 3, '/apk/a4178ed9467546fba24e5fe601f3d8a2.apk', 13.00, 2, '2025-06-22 23:54:17');
INSERT INTO `app_version` VALUES (24, 3, 'V1.7.2', 'V1.7.2版本简介', 3, '/apk/a3ae3e6cc7914368843cbaf72f499112.apk', 15.00, 2, '2025-06-22 23:56:22');
INSERT INTO `app_version` VALUES (25, 2, 'V1.4.2', 'V1.4.2版本简介', 3, '/apk/ac140cf8bc714f508ec68c426a5e48f1.apk', 14.00, 2, '2025-06-25 00:33:14');

-- ----------------------------
-- Table structure for backend_user
-- ----------------------------
DROP TABLE IF EXISTS `backend_user`;
CREATE TABLE `backend_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userCode` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户编码',
  `userName` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户名称',
  `creationDate` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `userPassword` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of backend_user
-- ----------------------------
INSERT INTO `backend_user` VALUES (1, 'admin', '系统管理员', '2016-08-20 00:13:41', '123456');

-- ----------------------------
-- Table structure for dev_user
-- ----------------------------
DROP TABLE IF EXISTS `dev_user`;
CREATE TABLE `dev_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `devCode` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '开发者帐号',
  `devName` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '开发者名称',
  `devPassword` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '开发者密码',
  `creationDate` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dev_user
-- ----------------------------
INSERT INTO `dev_user` VALUES (1, 'ZhangSan', '张三', '123456', '2024-08-18 00:13:41');
INSERT INTO `dev_user` VALUES (2, 'LiSi', '李四', '123456', '2024-11-22 20:49:49');

SET FOREIGN_KEY_CHECKS = 1;
