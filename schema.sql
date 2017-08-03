# 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
  `id` INT(10) AUTO_INCREMENT NOT NULL COMMENT '主键',
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
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`(
  `id` INT(10) AUTO_INCREMENT NOT NULL COMMENT '主键',
  `name` CHAR(32) NOT NULL DEFAULT '' COMMENT '标签名称',
  `status` TINYINT DEFAULT 1 COMMENT '标签状态@0:禁用@1:启用',

  `delete_flag` TINYINT DEFAULT 0 COMMENT '当前记录是否有效@0:有效@1:无效',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录最后更新时间',
  `last_modified_by` CHAR(36) NOT NULL DEFAULT '' COMMENT '最后一次修改者id',
  PRIMARY KEY (`id`),
  UNIQUE (`name`)
)COMMENT='标签表' DEFAULT CHARSET = 'utf8' COLLATE='utf8_general_ci' ENGINE=InnoDB;

# 标签与用户的关联关系表
DROP TABLE IF EXISTS `user_tag_relation`;
CREATE TABLE `user_tag_relation`(
  `id` INT(10) AUTO_INCREMENT NOT NULL COMMENT '主键',
  `tag_id` INT(10) NOT NULL DEFAULT 0 COMMENT '标签id',
  `user_id` INT(10) NOT NULL DEFAULT 0 COMMENT '用户id',

  `delete_flag` TINYINT DEFAULT 0 COMMENT '当前记录是否有效@0:有效@1:无效',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录最后更新时间',
  `last_modified_by` CHAR(36) NOT NULL DEFAULT '' COMMENT '最后一次修改者id',
  PRIMARY KEY (`id`),
  UNIQUE (`tag_id`,`user_id`)
)COMMENT='标签与用户的关联关系表' DEFAULT CHARSET = 'utf8' COLLATE='utf8_general_ci' ENGINE=InnoDB;

# 文章表
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`(
  `id` INT(10) AUTO_INCREMENT NOT NULL COMMENT '主键',
  `user_id` INT(10) NOT NULL DEFAULT 0 COMMENT '用户id',
  `title` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '文章标题',
  `brief` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '文章简介',
  `content_id` CHAR(36) NOT NULL DEFAULT '' COMMENT '文章内容id，具体内容保存在mongo中',
  `status` TINYINT NOT NULL DEFAULT 0 COMMENT '文章状态，@0：草稿，@1：发布',
  `view_number` INT(10) NOT NULL DEFAULT 0 COMMENT '文章浏览总数',
  `comments_number` INT(10)NOT NULL DEFAULT 0 COMMENT '文章评论数',

  `delete_flag` TINYINT DEFAULT 0 COMMENT '当前记录是否有效@0:有效@1:无效',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录最后更新时间',
  `last_modified_by` CHAR(36) NOT NULL DEFAULT '' COMMENT '最后一次修改者id',
  PRIMARY KEY (`id`),
  INDEX (`user_id`),
  INDEX (`content_id`),
  INDEX (`create_time`)
)COMMENT='文章表' DEFAULT CHARSET = 'utf8' COLLATE='utf8_general_ci' ENGINE=InnoDB;

# 标签、文章关联关系表
DROP TABLE IF EXISTS `article_tag_relation`;
CREATE TABLE `article_tag_relation`(
  `id` INT(10) AUTO_INCREMENT NOT NULL COMMENT '主键',
  `article_id` INT(10) NOT NULL DEFAULT 0 COMMENT '文章id',
  `tag_id` INT(10) NOT NULL DEFAULT 0 COMMENT '文章标题',

  `delete_flag` TINYINT DEFAULT 0 COMMENT '当前记录是否有效@0:有效@1:无效',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录最后更新时间',
  `last_modified_by` CHAR(36) NOT NULL DEFAULT '' COMMENT '最后一次修改者id',
  PRIMARY KEY (`id`),
  INDEX (`article_id`),
  INDEX (`tag_id`)
)COMMENT='标签、文章关联关系表' DEFAULT CHARSET = 'utf8' COLLATE='utf8_general_ci' ENGINE=InnoDB;
