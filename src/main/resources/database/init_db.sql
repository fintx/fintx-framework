
-- ----------------------------
-- 业务数据校验控制表 t_business_control
-- ----------------------------
DROP TABLE IF EXISTS `t_business_control`;
CREATE TABLE `t_business_control` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '本表主键',
  `app_id` varchar(32) NOT NULL COMMENT '接入应用ID(按appId申请密钥进行签名)',
  `biz_code` varchar(32) NOT NULL COMMENT '业务码：签约-Signature，代扣-Charging，签约查询-SignatureQuery，代扣查询-ChargingQuery',
  `biz_date` varchar(8) NOT NULL COMMENT '业务发生日期，yyyyMMdd',
  `biz_id` varchar(256) NOT NULL COMMENT '业务ID，由银行支付系统自动生成：系统根据前端做不同业务时传入的参数自动计算而成。',
  `shard_type` char(2) NOT NULL DEFAULT '' COMMENT '',
  `shard_columns` varchar(64) NOT NULL DEFAULT '',
  `c_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `m_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_biz` (`app_id`,`biz_code`,`biz_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- ----------------------------
-- Table structure for t_request_control
-- ----------------------------
DROP TABLE IF EXISTS `t_request_control`;
CREATE TABLE `t_request_control` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '本表主键',
  `app_id` varchar(32) NOT NULL COMMENT '接入应用ID(按appId申请密钥进行签名)',
  `app_date` varchar(8) NOT NULL COMMENT '调用方应用程序时间',
  `req_id` varchar(32) NOT NULL COMMENT '请求流水ID',
  `shard_type` char(2) NOT NULL DEFAULT '',
  `shard_columns` varchar(64) NOT NULL DEFAULT '',
  `c_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `m_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_req` (`app_id`,`app_date`,`req_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


