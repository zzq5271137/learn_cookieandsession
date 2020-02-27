/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : user

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-06-30 14:17:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `image` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '梵希蔓短袖衬衣女2018新款夏季气质韩版通勤', '159.00', 'goods_001.png',"",1,1);
INSERT INTO `goods` VALUES ('2', '姿忆秀五分袖宽松衬衫女2018夏装新款竖条纹\r\n', '88.00', 'goods_002.png',"",1,2);
INSERT INTO `goods` VALUES ('3', '梵希蔓短袖雪纺衬衫短款2018夏季新款女装韩\r\n', '176.00', 'goods_003.png',"",1,3);
INSERT INTO `goods` VALUES ('4', '2018夏季新款雪纺衬衫女上衣职业OL短袖衬衣韩版修身休闲', '159.00', 'goods_004.png',"",1,1);
INSERT INTO `goods` VALUES ('5', '电脑椅家用电竞椅 人体工学椅子座椅网布转椅可躺老板椅办公椅', '269.00', 'goods_005.png',"",1,2);
INSERT INTO `goods` VALUES ('6', '电脑椅家用座椅办公椅主播椅子游戏椅网吧电竞椅可躺午休', '699.00', 'goods_006.png',"",1,3);
INSERT INTO `goods` VALUES ('7', '百图 立领条纹衬衫女套头短袖百搭雪纺衫上\r\n', '179.00', 'goods_007.png',"","","");
INSERT INTO `goods` VALUES ('8', '不锈钢卫浴室柜组合小户型挂墙式洗手洗脸盆池卫生间厕所洗漱台盆', '305.00', 'goods_008.png',"",1,2);
INSERT INTO `goods` VALUES ('9', '北欧双盆浴室柜组合简约卫浴柜镜柜卫生间洗手盆洗脸盆洗漱台盆柜', '900.00', 'goods_009.png',"",1,1);
INSERT INTO `goods` VALUES ('10', '简约现代浴室柜洗手盆柜组合洗脸卫生间小户型厕所洗漱台卫浴吊柜', '948.00', 'goods_10.png',"",0,1);
INSERT INTO `goods` VALUES ('11', '三只鸟旅行箱拉杆箱女铝框20寸行李箱万向轮24寸学生密码箱登机箱', '268.00', 'goods_11.png',"",0,3);
INSERT INTO `goods` VALUES ('12', '全铝镁铝合金拉杆箱金属旅行箱子男女万向轮行李箱商务学生登机箱', '375.00', 'goods_12.png',"",0,4);
INSERT INTO `goods` VALUES ('13', '床上双人电脑桌 台式电脑桌家用笔记本电脑桌 ', '89.00', 'goods_13.png',"",0,"");
INSERT INTO `goods` VALUES ('14', '男童鞋儿童运动鞋2018春秋新款夏季网面休闲透气小白网鞋女童鞋子', '79.00', 'goods_14.png',"",0,4);
INSERT INTO `goods` VALUES ('15', '大码宽松休闲立领短袖纯棉衬衫格子上衣衬衣\r\n', '149.00', 'goods_15.png',"",0,3);
