use bear;
##用户表
create table user (
  id bigint(10) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  account_name varchar(20) NOT NULL default '' COMMENT '账号名',
  password varchar(100) NOT NULL default '' COMMENT '密码',
  real_name  varchar(20) NOT NULL default '' COMMENT '真实名',
  mobile varchar(11) NOT NULL default '' COMMENT '手机号',
  email varchar(20) NOT NULL default '' COMMENT '邮箱地址',
  gender tinyint(1) DEFAULT 0 COMMENT '状态  0：女   1：男',
  province_id bigint(10)  DEFAULT NULL COMMENT '省id',
  province_name varchar(20) NOT NULL default '' COMMENT '省名字',
  city_id bigint(10)  DEFAULT NULL COMMENT '市id',
  city_name varchar(20) NOT NULL default '' COMMENT '市名字',
  district_id bigint(10)  DEFAULT NULL COMMENT '区id',
  district_name varchar(20) NOT NULL default '' COMMENT '区名字',
  is_delete tinyint(1) DEFAULT 0 COMMENT '状态  0：正常   1：禁用',
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '系统用户表';