# 用户表
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`(
  `id` CHAR(36) NOT NULL COMMENT '主键',
  `username` CHAR(32) NOT NULL DEFAULT '' COMMENT '姓名',
  `nick_name` CHAR(32) NOT NULL DEFAULT '' COMMENT '昵称',
  `phone` CHAR(11) NOT NULL DEFAULT '' COMMENT '手机号',
  `email` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '邮箱',
  `password` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '密码',
  `head_img` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '头像',
  `delete_flag` TINYINT DEFAULT 0 COMMENT '当前记录是否有效@0:有效@1:无效',

  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录最后更新时间',
  `last_modified_by` CHAR(36) NOT NULL DEFAULT '' COMMENT '最后一次修改者id',
  PRIMARY KEY (`id`)
)COMMENT='用户表' DEFAULT CHARSET = 'utf8' COLLATE='utf8_general_ci' ENGINE=InnoDB;


#标签表
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag`(
  `id` CHAR(36) NOT NULL COMMENT '主键',
  `name` CHAR(32) NOT NULL DEFAULT '' COMMENT '标签名称',
  `delete_flag` TINYINT DEFAULT 0 COMMENT '当前记录是否有效@0:有效@1:无效',

  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录最后更新时间',
  `last_modified_by` CHAR(36) NOT NULL DEFAULT '' COMMENT '最后一次修改者id',
  PRIMARY KEY (`id`),
  UNIQUE (`name`)
)COMMENT='标签表' DEFAULT CHARSET = 'utf8' COLLATE='utf8_general_ci' ENGINE=InnoDB;

# 标签与用户的关联关系表
DROP TABLE IF EXISTS `t_user_tag_relation`;
CREATE TABLE `t_user_tag_relation`(
  `id` CHAR(36) NOT NULL COMMENT '主键',
  `tag_id` CHAR(36) NOT NULL DEFAULT '' COMMENT '标签id',
  `user_id` CHAR(36) NOT NULL DEFAULT '' COMMENT '用户id',
  `delete_flag` TINYINT DEFAULT 0 COMMENT '当前记录是否有效@0:有效@1:无效',

  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录最后更新时间',
  `last_modified_by` CHAR(36) NOT NULL DEFAULT '' COMMENT '最后一次修改者id',
  PRIMARY KEY (`id`),
  UNIQUE (`tag_id`,`user_id`)
)COMMENT='标签与用户的关联关系表' DEFAULT CHARSET = 'utf8' COLLATE='utf8_general_ci' ENGINE=InnoDB;

# 文章表
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article`(
  `id` CHAR(36) NOT NULL COMMENT '主键',
  `user_id` CHAR(36) NOT NULL DEFAULT '' COMMENT '用户id',
  `info_id` CHAR(36) NOT NULL DEFAULT '' COMMENT '文章内容id，具体内容保存在mongo中',
  `delete_flag` TINYINT DEFAULT 0 COMMENT '当前记录是否有效@0:有效@1:无效',

  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录最后更新时间',
  `last_modified_by` CHAR(36) NOT NULL DEFAULT '' COMMENT '最后一次修改者id',
  PRIMARY KEY (`id`),
  INDEX (`user_id`),
  INDEX (`info_id`),
  INDEX (`create_time`)
)COMMENT='文章表' DEFAULT CHARSET = 'utf8' COLLATE='utf8_general_ci' ENGINE=InnoDB;

