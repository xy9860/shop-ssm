/*删除商城数据库,如果存在*/
drop database if exists shop;
/*创建数据库,并设置编码*/
create database shop default character set utf8;

use shop;
/*删除管理员表*/
drop table if exists account;
/*删除商品类别表*/
drop table if exists category;
/*删除商品信息表*/
drop table if exists product;
drop table if exists user;
drop table if exists status;
drop table if exists forder;
drop table if exists sorder;

/*============================*/
/* Table: 管理员表结构 		  */
/*============================*/
create table account
(
   /* 管理员编号,自动增长 */
   aid                  int not null auto_increment,
   /* 管理员登录名  */
   alogin               varchar(20),
   /* 管理员姓名  */
   aname                varchar(20),
   /* 管理员密码 */
   apass                varchar(20),
   /* 设置编号为主键 */
   primary key (aid)
);

/*=============================*/
/* Table: 商品类别表结构 		   */
/*=============================*/
create table category
(
   /* 类别编号,自动增长 */
   cid                  int not null auto_increment,
   /* 类别名称 */
   ctype                varchar(20),
   /* 类别是否为热点类别,热点类别才有可能显示在首页 */
   chot                 bool default false,
   /* 外键,此类别由哪位管理员管理 */
   aid                  int,
   /* 设置类别编号为主键 */
   primary key (cid)
);

/*=============================*/
/* Table: 商品表结构	 		   */
/*=============================*/
create table product
(
   /* 商品编号,自动增长 */
   pid                  int not null auto_increment,
   /* 商品名称 */
   pname                varchar(20),
   /* 商品价格 */
   price               decimal(8,2),
   /* 商品图片 */
   pic                 varchar(200),
   /* 商品简单介绍 */
   premark              longtext,
   /* 商品详细介绍 */
   pxremark             longtext,
   /* 商品生产日期 */
   pdate                timestamp default CURRENT_TIMESTAMP,
   /* 是否为推荐商品,推荐商品才有可能显示在商城首页 */
   pcommend             bool,
   /* 是否为有效商品,有效商品才有可能显示在商城首页 */
   popen                bool,
   /* 商品所在的类别编号*/
   cid                  int,
   /* 设置商品编号为主键 */
   primary key (pid)
);

/*============================*/
/* Table: 用户表结构 		  */
/*============================*/
create table user
(
   /* 用户编号,自动增长 */
   uid                  int not null auto_increment,
   /* 用户登录名 */
   ulogin               varchar(20),
   /* 用户真实姓名 */
   uname                varchar(20),
   /* 用户登录密码 */
   upass                varchar(20),
   /* 用户性别 */
   usex                 varchar(20),
   /* 用户电话 */
   uphone               varchar(20),
   /* 用户Email */
   uemail               varchar(20),
   /* 设置用户编号为主键 */
   primary key (uid)
);

/*=============================*/
/* Table: 订单状态表结构 		   */
/*=============================*/
create table status
(
   /* 状态编号,自动增长 */
   tid                  int not null auto_increment,
   /* 订单状态 */
   tstatus               varchar(10),
   /* 设置订单编号为主键 */
   primary key (tid)
);
/*=============================*/
/* Table: 订单表结构	 		   */
/*=============================*/
create table forder
(
   /* 订单编号,自动增长 */
   fid                  int not null auto_increment,
   /* 收件人名字 */
   fname                varchar(20),
   /* 收件人电话 */
   fphone               varchar(20),
   /* 配送信息 */
   fremark              varchar(20),
   /* 下单日期 */
   fdate                timestamp default CURRENT_TIMESTAMP,
   /* 订单总金额 */
   ftotal               double(8,2),
   /* 收件人邮编 */
   fpost                varchar(20),
    /* 收件人邮编 */
   faddress             varchar(200),
   /* 订单状态 */
   tid                 int default 1,
   /* 会员编号 */
   uid                 int,
   /* 设置订单编号为主键 */
   primary key (fid)
);
/* 修改自动增长的初始值 */
ALTER TABLE forder AUTO_INCREMENT = 324375735;

/*=============================*/
/* Table: 购物项表结构 		   */
/*=============================*/

create table sorder
(
   /* 购物项编号,自动增长 */
   sid                  int not null auto_increment,
   /* 被购买商品的名称 */
   sname                varchar(20),
   /* 购买时商品的价格 */
   sprice               double(8,2),
   /* 购买的数量 */
   snumber              int not null,
   /* 所属商品编号 */
   pid                  int,
   /* 此订单项,所属的订单编号 */
   fid                  int,
   /* 设置购物项编号为主键 */
   primary key (sid)
);


/*插入测试用例*/
INSERT INTO account(alogin,aname,apass) values ('admin','管理员','admin');
INSERT INTO account(alogin,aname,apass) values ('user','客服A','user');

INSERT INTO category (ctype,chot,aid) VALUES ('男士休闲',true,1);
INSERT INTO category (ctype,chot,aid) VALUES ('女士休闲',true,1);
INSERT INTO category (ctype,chot,aid) VALUES ('儿童休闲',true,2);
INSERT INTO category (ctype,chot,aid) VALUES ('老人休闲',false,2);


/* 商品测试用例 */
INSERT INTO product (pname,price,pic,premark,pxremark,pcommend,popen,cid) VALUES 
('圣得西服',0.01,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,1);

INSERT INTO product (pname,price,pic,premark,pxremark,pcommend,popen,cid) VALUES 
('罗蒙西服',399,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,1);

INSERT INTO product (pname,price,pic,premark,pxremark,pcommend,popen,cid) VALUES 
('衫衫西服',0.01,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,1);

INSERT INTO product (pname,price,pic,premark,pxremark,pcommend,popen,cid) VALUES 
('金利来西服',0.01,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,1);

INSERT INTO product (pname,price,pic,premark,pxremark,pcommend,popen,cid) VALUES 
('韩版女装',199,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,2);

INSERT INTO product (pname,price,pic,premark,pxremark,pcommend,popen,cid) VALUES 
('雪地靴',299,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,2);

INSERT INTO product (pname,price,pic,premark,pxremark,pcommend,popen,cid) VALUES 
('欧版女装',0.01,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,2);

INSERT INTO product (pname,price,pic,premark,pxremark,pcommend,popen,cid) VALUES 
('女款手套',0.01,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,2);

INSERT INTO product (pname,price,pic,premark,pxremark,pcommend,popen,cid) VALUES 
('佳能单反机',599,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,3);

INSERT INTO product (pname,price,pic,premark,pxremark,pcommend,popen,cid) VALUES 
('金士顿优盘',0.01,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,3);

INSERT INTO product (pname,price,pic,premark,pxremark,pcommend,popen,cid) VALUES 
('日立硬盘',0.01,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,3);

INSERT INTO product (pname,price,pic,premark,pxremark,pcommend,popen,cid) VALUES 
('大水牛机箱',499,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,3);

INSERT INTO product (pname,price,pic,premark,pxremark,pcommend,popen,cid) VALUES 
('电脑桌',0.01,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,4);

INSERT INTO product (pname,price,pic,premark,pxremark,pcommend,popen,cid) VALUES 
('老板椅',0.01,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,4);

INSERT INTO product (pname,price,pic,premark,pxremark,pcommend,popen,cid) VALUES 
('空调',0.01,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,4);

INSERT INTO product (pname,price,pic,premark,pxremark,pcommend,popen,cid) VALUES 
('电视',0.01,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,4);

/* 用户测试用例 */
INSERT INTO user (ulogin,uname,upass,usex,uphone,uemail)
VALUES ('user','小刚','user','男','17713547583','xy9860@qq.com');

INSERT INTO user (ulogin,uname,upass,usex,uphone,uemail)
VALUES ('user2','小琴','user2','女','17713547582','935342871@qq.com');

/*插入状态测试用例*/
INSERT INTO status (tstatus) VALUES ('未支付');
INSERT INTO status (tstatus) VALUES ('已支付');
INSERT INTO status (tstatus) VALUES ('配送中');
INSERT INTO status (tstatus) VALUES ('订单完成');

/*插入购物车测试用例*/
INSERT INTO forder (fname,fphone,fremark,fdate,ftotal,faddress,fpost,uid) VALUES ('bb','123','备注',default,200.3,'广州天河区','1000',1);

/*插入购物车项测试用例*/
INSERT INTO sorder (sname,sprice,snumber,pid,fid) VALUES ('空调',200,1,15,2013021801);
INSERT INTO sorder (sname,sprice,snumber,pid,fid) VALUES ('电视',0.3,1,16,2013021801);


SELECT * FROM account;
SELECT * FROM category;
SELECT * FROM product;
SELECT * FROM user;
SELECT * FROM status;
SELECT * FROM forder;
SELECT * FROM sorder;
