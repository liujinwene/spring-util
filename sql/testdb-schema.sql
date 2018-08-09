-- 创建数据库
CREATE DATABASE IF NOT EXISTS testdb DEFAULT CHARSET utf8 COLLATE utf8_bin;

-- 创建表结构
SET FOREIGN_KEY_CHECKS=0;
CREATE TABLE `trigger_event` (
  `id` varchar(32) NOT NULL COMMENT 'uuid',
  `status` tinyint(4) NOT NULL COMMENT '状态,0-未触发,1-已触发,2-已失效,3-已撤销',
  `event_id` varchar(32) NOT NULL COMMENT '事件标识',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='触发事件表';