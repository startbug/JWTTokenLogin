/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 25/07/2020 14:58:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins`  (
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `series` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `token` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `last_used` timestamp(0) NOT NULL,
  PRIMARY KEY (`series`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `age` int(0) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 18, '张三');
INSERT INTO `student` VALUES (2, 20, '里斯');
INSERT INTO `student` VALUES (3, 22, '萝莉');

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bname` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `cid` int(0) NULL DEFAULT NULL,
  `pnum` int(0) NULL DEFAULT NULL,
  `imgurl` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sales` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('04fa26d12add4a06a5b86d19b15ca0ae', 'pkpkpkpkaaa', 2222, 1, 500, NULL, NULL, 'cgh', 1200);
INSERT INTO `t_book` VALUES ('06091db5477d46fd8df1727262d3090a', '了不起的盖茨比', 19.9, 8, 111, '5bb07235N3da9b7ed.jpg', ' 小职员尼克初来纽约，租住的房子恰巧在大富翁盖茨比的豪宅旁边，因此结识了盖茨比，并无意间得知盖茨比内心深处的牵绊——纽约上层社会的旧情人——黛西。', ' F.S.菲茨杰拉德', 888);
INSERT INTO `t_book` VALUES ('0b916606d6d44277af2546dd46c448f3', '深渊游戏', 100, 1, 997, 'book (36).jpg', '这是一款真身体验游戏。玩家在游戏中有且仅有一次生命,游戏里唯—的升级方式，就是吞噬同等级的玩家，同时获得积分奖励。只有成为“尊”等级的玩家，才有资格回到现实世界。', '劳资', 142);
INSERT INTO `t_book` VALUES ('13886eb6d22b4e4ba6e55458ff8eab83', '笑死人江湖', 80, 1, 70, 'book (4).jpg', '俄裔美籍作家，被读者誉为“神一样的人”；美国政府授予他“国家的资源与自然的奇迹”这个无与伦比的称号，以表彰他在“拓展人类想象力”上作出的杰出贡献。', '霍金', 453);
INSERT INTO `t_book` VALUES ('158d6f02eed04f888102fc7482ebed53', ' 杀死一只知更鸟', 36, 3, 0, '5b3b2d54N81779a3c.jpg', '父母必读，影响全球5000万家庭的殿堂级儿童教养之书，家庭教育的完美范本，美国中小学必读书目', '哈珀·李', 351);
INSERT INTO `t_book` VALUES ('1ae2a40032ac45aaafb2819f4f6d0bf7', '镇魂', 71, 2, 517, '5a69722cN9ebf604f.jpg', '高人气畅销书作家Priest震撼人心的口碑巨作！随书赠送巍澜印章藏书票+黑胶概念长书签+口红烫金贴纸。镇生者之魂，安死者之心', 'Priest ', 1554);
INSERT INTO `t_book` VALUES ('28eec4ad8a26435aa31e017d273a7c46', '废青小彭宇', 100, 2, 999, 'book (35).jpg', '《从你的全世界路过：让所有人心动的故事》是新媒体时代的写故事高手张嘉佳的短篇小说集。读过睡前故事的人会知道，这是一本精彩纷呈的书。', '刘慈欣', 1000000);
INSERT INTO `t_book` VALUES ('2f8d54c7115540ac92e0a47090127ee8', '战时灯火', 100, 1, 1000, 'book (3).png', '诺贝尔奖得主石黑一雄熟读到可以背出来的书！“金布克奖”得主翁达杰！）（读客外国小说文库）', '鲁迅', 453);
INSERT INTO `t_book` VALUES ('30a50cddc7824060989ce09b1bf34787', '方舟:生存进化', 150, 1, 1000, NULL, NULL, 'Studio Wildcard', 15000);
INSERT INTO `t_book` VALUES ('3340e0876c484770b197a095102df7e7', '哈哈哈哈', 15, 1, 1515, NULL, NULL, '1111111', 250);
INSERT INTO `t_book` VALUES ('33ee8ac6bc274c559d9fc2695c899ca6', '基督山伯爵', 139.4, 7, 669, '5ce26f70N83fa8a5c.jpg', '余华不吃不喝不睡，疯了般读完《基督山伯爵》！人类全部的智慧尽在其中！全三册一字未删完整版', '大仲马', 684);
INSERT INTO `t_book` VALUES ('34f91c61d49f4670b29386b7bd2a98e8', 'SQL数据库', 60, 7, 66, 'book (2).jpg', '直至整个银河被统一，一个统治超过2500万个住人行星、疆域横跨十万光年、总计数兆亿人口的庞大帝国崛起——银河帝国。\r\n\r\n　　一个微妙的转折发生在银河帝国建国后的12020年。哈里·谢顿，这个刚满32岁的年轻数学家，开创了“心理史学”', '张三', 215);
INSERT INTO `t_book` VALUES ('431472a82ccd4e199572c98cd7e8f3f0', 'Python人工智能', 90, 7, 99, 'book (3).jpg', '　谢顿的预言是：虽然毫无征兆，但已存在一万两千年之久的银河帝国即将灭亡。\r\n\r\n一时间，银河震动，帝国飘摇；皇帝、宰相、夺权者、反叛星球，各方势力立刻剑拔弩张，人类银河时代伟大的传奇就此开启……', '行三', 1140);
INSERT INTO `t_book` VALUES ('4c6511c5cd0e42248e0ab109222f8c76', '局外人', 37.4, 3, 987, 'book (46).jpg', '《平凡的世界》作者路遥成名作，影响千万青年的励志名篇\r\n路遥 著 ', '[法] 加缪', 120);
INSERT INTO `t_book` VALUES ('531624adb5bd426faaf1b0959cc60268', '三次觉醒', 150, 1, 5555, NULL, NULL, '毛子', 18888);
INSERT INTO `t_book` VALUES ('547ffd29408040f9af0446976c4e85b0', '睡美人', 59.9, 5, 430, '59db20a6Na14d5434.jpg', '一部照进现实的暗黑童话，让你汗毛倒立的两性寓言。金在作品中首次集中将两性关系中的恐惧、对立放大描写，故事是虚构的', '斯蒂芬·金', 885);
INSERT INTO `t_book` VALUES ('56de2f78339540a3800b8a0ff596d643', '\r\n起风了 ', 17.2, 7, 169, '59803acdNcc5463ca.jpg', '唯美典藏翻译+超值精装定价+知名设计制作 不一样的《起风了》 献给一直相信爱情的你； 日本动漫大师宫崎骏执导、获第86届奥斯卡金像奖提名的《起风了》原著', '堀辰雄 ', 898);
INSERT INTO `t_book` VALUES ('5a607fcc8fab44c2a5a2e6a7e6d5beef', '曹操操', 123, 1, 1233, NULL, NULL, '曹植', 1500);
INSERT INTO `t_book` VALUES ('635a6f23c0be4134a37ace5a1520e9d8', '\r\n无声告白', 29.1, 6, 335, 'book (43).jpg', '征服欧美文坛的华裔作家！击败村上春树等99位大牌作家，凭借处女作夺得2014年美国年度图书桂冠！我们终此一生，就是要摆脱他人的期待，找到真正的自己。', '伍绮诗', 725);
INSERT INTO `t_book` VALUES ('6680fc9c60504fdea63c6c35bdbca9a3', 'hibernate框架2', 88, 5, 1217, 'book (34).jpg', '人类在这个小小的行星（他们称之为“地球”）上，建立了两百多个不同的行政区域（他们称之为“国家”），直到地球上诞生了一个会思考的机器人。', '王五', 8455);
INSERT INTO `t_book` VALUES ('6f22d1181280452aade77fcde2751f26', ' 怦然心动', 46.4, 6, 673, '5acdddbfN46d60ef9.jpg', '始于心动，终于白首，遇上方知情深。晋江口碑作者玖月晞暖心力作。精心修订，全新版本，新增番外，精美赠品，超值典藏。', '玖月晞', 1457);
INSERT INTO `t_book` VALUES ('797e8edc41d7466986f61828d888cabb', '啊', 2, 1, 3, NULL, NULL, '啊', 2);
INSERT INTO `t_book` VALUES ('7b5a3b43947c4443b010a8738be77caa', '\r\n村上春树：挪威的森林', 12, 3, 123, 'book (33).jpg', '张嘉佳，毕业于南京大学，曾出版小说《几乎成了英雄》《情人书》。曾任电影《刀见笑》编剧，获2011年金马奖改编剧本提名。', '[法] 加缪', 1255);
INSERT INTO `t_book` VALUES ('81387741595142df8c43d4334ae6e056', '人生', 100, 1, 1000, 'book (5).jpg', '书中讲述了发生在我们身边的爱情故事，故事里的人物嘴贱心善，真实得就像身边的哥儿们和闺密，在深夜和你掏心掏肺地讲述，讲述他走过的千山万水，经历过的爱恨情仇。', '劳资', 150);
INSERT INTO `t_book` VALUES ('a7dbfdf5302d4c53b57b59e88dcaffb1', '局外人', 37.4, 3, 1000, 'book (46).jpg', '此生必读！这一次终于读懂《局外人》：留法加缪研究专家原创万字导读，韩国插画师原创彩插还原经典场景，新锐译者全新译本！精装彩插典藏版！读客熊猫君出品', '[法] 加缪 ', 225);
INSERT INTO `t_book` VALUES ('a8eb8a7db9d946ecb6eca8be83b60e18', '小鲜肉', 250, 1, 1000, NULL, NULL, '肖站割割', 8888);
INSERT INTO `t_book` VALUES ('afafcb375a6f4c899aa16978d2bd91a5', 'I belonged to you', 56, 7, 1000, 'book (9).jpg', '他提出的“机器人学三大法则”是当代机器人学的基本法则，他预言了今天的生物科技，预言了互联网时代的数字图书馆，预言了人类将进行太空殖民。', '劳资', 1004);
INSERT INTO `t_book` VALUES ('b8e3b895e07f41adbc1b9443f7368b63', '竹鼠养生', 78, 8, 188, 'book (40).jpg', '飞洒地方士大夫撒旦肺癌微软发射点发射点', '小红', 1502);
INSERT INTO `t_book` VALUES ('bcb66d7966d7408e9515e6fb30118d7a', '你在哪?', 111, 1, 999, 'book (34).jpg', '《挪威的森林》是日本作家村上春树所著的一部长篇爱情小说，影响了几代读者的青春名作。故事讲述主角渡边纠缠在情绪不稳定且患有精神疾病的直子和开朗活泼的小林绿子之间，', '[法] 加缪', 1111);
INSERT INTO `t_book` VALUES ('bfe5e1d7ca3942d4a248ea7f311649ad', '礼乐', 200, 1, 100, 'string', '流批', '劳资', 300);
INSERT INTO `t_book` VALUES ('c5402cb6d7e447a6b032ff1b6b9bd3e0', '卖女孩的小火柴', 123, 6, 998, 'book (37).jpg', 'afdsafsadfasfastar', '广财大', 2000);
INSERT INTO `t_book` VALUES ('cf9eca8623c74a13a71f0ebc85aff4dc', '人间喜剧', 100, 1, 999, 'book (12).jpg', '（新版典藏全集！法语翻译界泰斗傅雷历时25年传世译本，经典篇目全收录！一部人性百科全书，写尽了你一生可能遇到的所有人！）', '劳资', 1000);
INSERT INTO `t_book` VALUES ('d3c770a4dd114d899924f7263de6c943', '俏鼠记者', 175, 1, 238, 'book (11).jpg', '一天早晨，他收到一封信，来自二十年未见的老友奎妮。她患了癌症，写信告别。哈罗德写了回信，在寄出的路上，他由奎妮想到自己，越走越远', '劳资', 887);
INSERT INTO `t_book` VALUES ('d45a19bb7f8f4d09bfd74ce2ae83c8b5', '最初之前', 28.8, 7, 247, 'f77e85f9e22f6b1f.png', '从《你是zuihao的自己》开始，经历《我与世界只差一个你》《谢谢自己够勇敢》，直到《后来时间都与你有关》，这些年，张皓宸以累积超5,000,000册的销量，成为了90后作家排行榜冠军', '张皓宸', 502);
INSERT INTO `t_book` VALUES ('d5e19ef4f83a421da39cecfa770e0166', 'ANDRIOD安卓', 80, 7, 87, 'book (2).png', '一个微妙的转折发生在银河帝国建国后的12020年。哈里·谢顿，这个刚满32岁的年轻数学家，开创了“心理史学”，这门学科能用数学公式准确推演全人类的未来——“预言”从此成为一门可以信任的科学，人类由此可以看见未来。', '鲁迅', 775);
INSERT INTO `t_book` VALUES ('e04fd99261094bb48537bc99ea9d1b3d', '射雕英雄传', 100, 1, 1000, 'book (10).jpg', '京东定制：限量纪念礼盒装（内含：（朗声旧版）射雕英雄传+限量Q版手办+有声书兑换卡+明信片套装（15张）+纸胶带套装（3款）+礼品袋', '劳资', 1020);
INSERT INTO `t_book` VALUES ('e7cc736adfe843a094d43fac310e0481', '黑洞表面', 100.2, 1, 3333, '/zz/xxzz/jjj', '不好看不好看不好看不好看不好看不好看不好看不好看', '星星虫', 3000);
INSERT INTO `t_book` VALUES ('ecc38919935b4d3ab0e2ea6a3d975438', '老王养成记', 666, 1, 1000, NULL, NULL, 'ertert', 10000);
INSERT INTO `t_book` VALUES ('ed4f4f5085c844f39e7baf567461491a', '肥猪的养成', 120, 8, 95, 'book (27).jpg', '一级棒一级棒一级棒一级棒', '刘冬梅', 1211);
INSERT INTO `t_book` VALUES ('ee728f2f4c484024977c04072edf3d72', ' 小孩', 19.5, 4, 652, '5ad15ffbf7fbd158.jpg', '大冰2019年新书。走过的路越多，越喜欢宅着；见过的人越多，越喜欢孩子。《小孩》是一本可以用来下酒的奇书。随书附赠数十首有钱也买不到的原创民谣', '大冰 ', 100);
INSERT INTO `t_book` VALUES ('f1035fd50b3e406e968075b29d12c234', '东野圭吾：毕业 ', 54.3, 5, 555, '5bb07235N3da9b7ed.jpg', '东野圭吾《恶意》系列开篇之作，改变东野圭吾职业生涯的一本书。写给每个曾在毕业前期待又迷茫的人。如果成长需要交换，你一定不愿舍弃什么', '东野圭吾', 685);
INSERT INTO `t_book` VALUES ('f5584c48c3854dda909ddc9b5de4fb6b', '老王养成记', 8888, 1, 1000, NULL, NULL, 'ertert', 10000);
INSERT INTO `t_book` VALUES ('fff2d40038d34ec59c7e3d3761af5790', '人间失格', 48.8, 7, 150, '150af83d8e648b0a.jpg', '京东上的所有商品信息、客户评价、商品咨询、网友讨论等内容，是京东重要的经营资源，未经许可，禁止非法转载使用。 ', '堀辰雄 ', 745);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, 'ROLE_USER', '普通用户');
INSERT INTO `t_role` VALUES (2, 'ROLE_ADMIN', '管理员');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` int(0) NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_name`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('063f6bfc88a8465f8ad821a7aaeafc6d', 'tom', '$2a$10$eaG1.ZKsir1pNn519oYAL.d9f/0lZsvBceJvLQfcvDdszHlBQwKs6', '2020-07-02 17:51:59', '123@qq.com', 4, 'starbug', '2020-07-02 17:51:59');
INSERT INTO `t_user` VALUES ('8557b19e35ca4ada92efaeda7739759f', 'lucy', '$2a$10$eaG1.ZKsir1pNn519oYAL.d9f/0lZsvBceJvLQfcvDdszHlBQwKs6', '2020-07-02 17:51:59', '123@qq.com', 3, 'starbug', '2020-07-02 17:51:59');
INSERT INTO `t_user` VALUES ('8636a34a48124e2892eb340cd9614c6b', 'daisy', '$2a$10$eaG1.ZKsir1pNn519oYAL.d9f/0lZsvBceJvLQfcvDdszHlBQwKs6', '2020-07-02 17:51:59', '11321324@qq.com', 1, 'starbug', '2020-07-02 17:51:59');
INSERT INTO `t_user` VALUES ('a1d8266484df4dd486f89dfdc9fc782a', 'jay', '$2a$10$q3l22AByKWQbsVdkjFk9jupPZBEDmn04Cwujm7.CDxxePWwl.Y.GK', '2020-07-25 14:52:57', '1231321@qq.com', 1, '周董', '2020-07-25 14:52:57');
INSERT INTO `t_user` VALUES ('a54b26140f3e4448906ad35db80ace8d', 'starbug', '$2a$10$eaG1.ZKsir1pNn519oYAL.d9f/0lZsvBceJvLQfcvDdszHlBQwKs6', '2020-07-02 17:51:59', '1234@qq.com', 2, 'starbug', '2020-07-02 17:51:59');
INSERT INTO `t_user` VALUES ('e89b13aa66e84b10b1eeaa1d36ccaa7b', 'lisa', '$2a$10$eaG1.ZKsir1pNn519oYAL.d9f/0lZsvBceJvLQfcvDdszHlBQwKs6', '2020-07-03 13:50:15', '1285226024@qq.com', 1, '12412', '2020-07-03 13:50:15');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `uid` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户编号',
  `rid` int(0) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`uid`, `rid`) USING BTREE,
  INDEX `FK_Reference_r`(`rid`) USING BTREE,
  CONSTRAINT `FK_Reference_r` FOREIGN KEY (`rid`) REFERENCES `t_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_u` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('063f6bfc88a8465f8ad821a7aaeafc6d', 1);
INSERT INTO `t_user_role` VALUES ('8557b19e35ca4ada92efaeda7739759f', 1);
INSERT INTO `t_user_role` VALUES ('8636a34a48124e2892eb340cd9614c6b', 1);
INSERT INTO `t_user_role` VALUES ('a1d8266484df4dd486f89dfdc9fc782a', 1);
INSERT INTO `t_user_role` VALUES ('e89b13aa66e84b10b1eeaa1d36ccaa7b', 1);
INSERT INTO `t_user_role` VALUES ('a1d8266484df4dd486f89dfdc9fc782a', 2);
INSERT INTO `t_user_role` VALUES ('a54b26140f3e4448906ad35db80ace8d', 2);
INSERT INTO `t_user_role` VALUES ('e89b13aa66e84b10b1eeaa1d36ccaa7b', 2);

SET FOREIGN_KEY_CHECKS = 1;
