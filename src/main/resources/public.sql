/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : PostgreSQL
 Source Server Version : 180003 (180003)
 Source Host           : localhost:5432
 Source Catalog        : system_db
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 180003 (180003)
 File Encoding         : 65001

 Date: 08/03/2026 23:06:09
*/


-- ----------------------------
-- Table structure for a_goods
-- ----------------------------
DROP TABLE IF EXISTS "public"."a_goods";
CREATE TABLE "public"."a_goods" (
  "id" int4 NOT NULL,
  "name" varchar(100) COLLATE "pg_catalog"."default",
  "create_time" timestamp(0) NOT NULL,
  "is_deleted" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Records of a_goods
-- ----------------------------

-- ----------------------------
-- Table structure for a_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."a_menu";
CREATE TABLE "public"."a_menu" (
  "id" int4 NOT NULL,
  "name" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(0) NOT NULL,
  "code" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "is_deleted" int2 NOT NULL DEFAULT 0,
  "menu_type" int2 NOT NULL
)
;
COMMENT ON COLUMN "public"."a_menu"."name" IS '菜单名';
COMMENT ON COLUMN "public"."a_menu"."menu_type" IS '菜单类型';

-- ----------------------------
-- Records of a_menu
-- ----------------------------
INSERT INTO "public"."a_menu" VALUES (1, '采购管理', '2026-03-08 00:11:01', 'PUTCHASE_MANAGE', 0, 1);
INSERT INTO "public"."a_menu" VALUES (2, '库存管理', '2026-03-08 00:17:52', 'INVENTORY_MANAGE', 0, 1);
INSERT INTO "public"."a_menu" VALUES (3, '销售管理', '2026-03-08 00:19:34', 'SALE_MANAGE', 0, 1);
INSERT INTO "public"."a_menu" VALUES (4, '财务管理', '2026-03-08 00:21:36', 'FINANCE_MANAGE', 0, 1);

-- ----------------------------
-- Table structure for a_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."a_role";
CREATE TABLE "public"."a_role" (
  "id" int4 NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(0) NOT NULL,
  "is_deleted" int2 NOT NULL
)
;
COMMENT ON COLUMN "public"."a_role"."name" IS '权限名';

-- ----------------------------
-- Records of a_role
-- ----------------------------

-- ----------------------------
-- Table structure for a_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."a_user";
CREATE TABLE "public"."a_user" (
  "id" int4 NOT NULL,
  "username" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "password" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "realname" varchar(50) COLLATE "pg_catalog"."default",
  "create_time" timestamp(0) NOT NULL,
  "is_deleted" int2 NOT NULL DEFAULT 0
)
;
COMMENT ON COLUMN "public"."a_user"."username" IS '账号';
COMMENT ON COLUMN "public"."a_user"."password" IS '密码';
COMMENT ON COLUMN "public"."a_user"."realname" IS '真实姓名';

-- ----------------------------
-- Records of a_user
-- ----------------------------
INSERT INTO "public"."a_user" VALUES (1, 'administrators', '111111', '系统管理员', '2026-03-06 00:00:00', 0);

-- ----------------------------
-- Primary Key structure for table a_goods
-- ----------------------------
ALTER TABLE "public"."a_goods" ADD CONSTRAINT "goods_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table a_menu
-- ----------------------------
ALTER TABLE "public"."a_menu" ADD CONSTRAINT "menu_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table a_role
-- ----------------------------
ALTER TABLE "public"."a_role" ADD CONSTRAINT "role_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table a_user
-- ----------------------------
ALTER TABLE "public"."a_user" ADD CONSTRAINT "user_pkey" PRIMARY KEY ("id");
