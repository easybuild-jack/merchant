-- ============================================================
-- MySQL 建表脚本
-- 生成时间: 2026-01-24
-- 说明: 商户模块相关表结构
-- ============================================================
-- 设置字符集，确保中文注释正常显示
SET NAMES utf8mb4;
SET CHARACTER SET utf8mb4;

-- 1. 商户信息表
DROP TABLE IF EXISTS `merchant_info`;
CREATE TABLE `merchant_info` (
    `merchant_id` VARCHAR(50) NOT NULL COMMENT '商户ID',
    `merchant_name` VARCHAR(200) DEFAULT NULL COMMENT '商户名称',
    `merchant_code` VARCHAR(50) DEFAULT NULL COMMENT '商户代码',
    `logo` VARCHAR(500) DEFAULT NULL COMMENT '商户 logo',
    `province` VARCHAR(50) DEFAULT NULL COMMENT '省份',
    `city` VARCHAR(50) DEFAULT NULL COMMENT '城市',
    `area` VARCHAR(50) DEFAULT NULL COMMENT '区域',
    `address` VARCHAR(200) DEFAULT NULL COMMENT '具体地址',
    `address_info` VARCHAR(500) DEFAULT NULL COMMENT '详细地址信息（省市区+具体地址）',
    `link_man` VARCHAR(50) DEFAULT NULL COMMENT '联系人',
    `link_phone` VARCHAR(20) DEFAULT NULL COMMENT '联系电话',
    `business_hours` VARCHAR(100) DEFAULT NULL COMMENT '营业时间',
    `longitude` VARCHAR(50) DEFAULT NULL COMMENT '经度',
    `latitude` VARCHAR(50) DEFAULT NULL COMMENT '纬度',
    `forbidden_flag` INT(2) NOT NULL DEFAULT 0 COMMENT '禁用状态 0可用，1禁用',
    `agent_id` VARCHAR(50) DEFAULT NULL COMMENT '代理商ID',
    `agent_name` VARCHAR(200) DEFAULT NULL COMMENT '代理商名称',
    `insert_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    `last_update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `deleted` INT(2) NOT NULL DEFAULT 0 COMMENT '删除标记，0否 1是',
    PRIMARY KEY (`merchant_id`),
    UNIQUE KEY `uk_merchant_code` (`merchant_code`),
    KEY `idx_agent_id` (`agent_id`),
    KEY `idx_deleted` (`deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商户信息';
