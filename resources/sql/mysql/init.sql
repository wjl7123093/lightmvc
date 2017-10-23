drop table if exists sys_user_role;
drop table if exists sys_role_resource;
drop table if exists sys_user;
drop table if exists sys_role;
drop table if exists sys_resource;
drop table if exists sys_organization;

drop table if exists demo;

--
-- 表的结构[演示表]
--

create table DEMO (
	id int(11) auto_increment,
	name varchar(64) not null,
	description varchar(255),
	primary key (id)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='DEMO' ;

--
-- 表的结构[用户表]
--

create table sys_user (
	id smallint(5) auto_increment,
	loginname varchar(64) not null unique,
	name varchar(64) not null,
	password varchar(64) not null,
	customer_id int ,
	sex tinyint(1) not null default 0,
	age tinyint(1) not null default 0,
	usertype tinyint(1) not null default 0,
	isdefault tinyint(1) not null default 0,
	state tinyint(1) not null default 0,
	organization_id int not null default 0,
	createdatetime timestamp not null default 0,
	phone varchar(20),
	primary key (id)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='用户' ;

--
-- 表的结构[用户角色表]
--

create table sys_user_role (
    user_id smallint(5) not null,
    role_id smallint(5) not null,
    primary key (user_id, role_id)
)  ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='用户角色';


--
-- 表的结构[角色资源表]
--

create table sys_role_resource (
    role_id smallint(5) not null,
    resource_id smallint(5) not null,
    primary key (role_id, resource_id)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='角色资源';

--
-- 表的结构[角色表]
--

create table sys_role(
	id smallint(5) auto_increment,
	name varchar(64) not null,
	seq tinyint(1) not null default 0,
	description varchar(255),
	isdefault tinyint(1) not null default 0,
 	primary key (id)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='角色';

--
-- 表的结构[资源表]
--

create table sys_resource (
	id smallint(5) auto_increment,
	name varchar(64) not null,
	url varchar(100),
	description varchar(255),
	icon varchar(32),
	pid int,
	seq tinyint(1) not null default 0,
	state tinyint(1) not null default 0,
	resourcetype tinyint(1) not null default 0,
	createdatetime timestamp not null default 0,
    primary key (id)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='资源';

--
-- 表的结构[机构表]
--

create table sys_organization (
	id int auto_increment,
	name varchar(64) not null,
	address varchar(100),
	code varchar(64) not null,
	icon varchar(32),
	pid int,
	seq tinyint(1) not null default 0,
	createdatetime timestamp not null default 0,
    primary key (id)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='组织机构';


--
-- [角色权限]
--
insert into sys_role_resource(role_id,resource_id) values(1,1);
insert into sys_role_resource(role_id,resource_id) values(1,11);
insert into sys_role_resource(role_id,resource_id) values(1,111);
insert into sys_role_resource(role_id,resource_id) values(1,112);
insert into sys_role_resource(role_id,resource_id) values(1,113);
insert into sys_role_resource(role_id,resource_id) values(1,114);
insert into sys_role_resource(role_id,resource_id) values(1,12);
insert into sys_role_resource(role_id,resource_id) values(1,121);
insert into sys_role_resource(role_id,resource_id) values(1,122);
insert into sys_role_resource(role_id,resource_id) values(1,123);
insert into sys_role_resource(role_id,resource_id) values(1,124);
insert into sys_role_resource(role_id,resource_id) values(1,125);
insert into sys_role_resource(role_id,resource_id) values(1,13);
insert into sys_role_resource(role_id,resource_id) values(1,131);
insert into sys_role_resource(role_id,resource_id) values(1,132);
insert into sys_role_resource(role_id,resource_id) values(1,133);
insert into sys_role_resource(role_id,resource_id) values(1,134);
insert into sys_role_resource(role_id,resource_id) values(1,135);
insert into sys_role_resource(role_id,resource_id) values(1,14);
insert into sys_role_resource(role_id,resource_id) values(1,141);
insert into sys_role_resource(role_id,resource_id) values(1,142);
insert into sys_role_resource(role_id,resource_id) values(1,143);
insert into sys_role_resource(role_id,resource_id) values(1,144);
insert into sys_role_resource(role_id,resource_id) values(1,145);
insert into sys_role_resource(role_id,resource_id) values(1,2);
insert into sys_role_resource(role_id,resource_id) values(1,21);
insert into sys_role_resource(role_id,resource_id) values(1,211);
insert into sys_role_resource(role_id,resource_id) values(1,212);
insert into sys_role_resource(role_id,resource_id) values(1,213);
insert into sys_role_resource(role_id,resource_id) values(1,214);
insert into sys_role_resource(role_id,resource_id) values(1,215);
insert into sys_role_resource(role_id,resource_id) values(1,22);

--
-- [资源菜单]
--
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(1,'系统管理','','系统管理','icon-company',null,7,0,0,'2014-02-19 01:00:00');

insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(11,'资源管理','/resource/manager','资源管理','icon-folder',1,1,0,0,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(111,'列表','/resource/treeGrid','资源列表','icon-btn',11,0,0,1,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(112,'添加','/resource/add','资源添加','icon-btn',11,0,0,1,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(113,'编辑','/resource/edit','资源编辑','icon-btn',11,0,0,1,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(114,'删除','/resource/delete','资源删除','icon-btn',11,0,0,1,'2014-02-19 01:00:00');

insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(12,'角色管理','/role/manager','角色管理','icon-folder',1,2,0,0,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(121,'列表','/role/dataGrid','角色列表','icon-btn',12,0,0,1,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(122,'添加','/role/add','角色添加','icon-btn',12,0,0,1,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(123,'编辑','/role/edit','角色编辑','icon-btn',12,0,0,1,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(124,'删除','/role/delete','角色删除','icon-btn',12,0,0,1,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(125,'授权','/role/grant','角色授权','icon-btn',12,0,0,1,'2014-02-19 01:00:00');

insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(13,'用户管理','/user/manager','用户管理','icon-folder',1,3,0,0,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(131,'列表','/user/dataGrid','用户列表','icon-btn',13,0,0,1,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(132,'添加','/user/add','用户添加','icon-btn',13,0,0,1,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(133,'编辑','/user/edit','用户编辑','icon-btn',13,0,0,1,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(134,'删除','/user/delete','用户删除','icon-btn',13,0,0,1,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(135,'查看','/user/view','用户查看','icon-btn',13,0,0,1,'2014-02-19 01:00:00');

insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(14,'部门管理','/organization/manager','部门管理','icon-folder',1,4,0,0,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(141,'列表','/organization/treeGrid','用户列表','icon-btn',14,0,0,1,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(142,'添加','/organization/add','部门添加','icon-btn',14,0,0,1,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(143,'编辑','/organization/edit','部门编辑','icon-btn',14,0,0,1,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(144,'删除','/organization/delete','部门删除','icon-btn',14,0,0,1,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(145,'查看','/organization/view','部门查看','icon-btn',14,0,0,1,'2014-02-19 01:00:00');

insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(2,'代码演示','','代码演示','icon-company',null,6,0,0,'2014-02-19 01:00:00');

insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(21,'DEMO管理','/demo/manager','DEMO管理','icon-folder',2,1,0,0,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(211,'列表','/demo/dataGrid','列表','icon-btn',21,0,0,1,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(212,'添加','/demo/add','添加','icon-btn',21,0,0,1,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(213,'编辑','/demo/edit','编辑','icon-btn',21,0,0,1,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(214,'删除','/demo/delete','删除','icon-btn',21,0,0,1,'2014-02-19 01:00:00');
insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(215,'查看','/demo/view','查看','icon-btn',21,0,0,1,'2014-02-19 01:00:00');

insert into sys_resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(22,'EASYUI','http://www.jeasyui.com','EASYUI','icon-folder',2,1,0,0,'2014-02-19 01:00:00');


--
-- [角色]
--
insert into sys_role(id,name,seq,isdefault,description) values(1,'超级管理员',0,0,'超级管理员，拥有全部权限');

--
-- [用户角色]
--
insert into sys_user_role(user_id,role_id) values(1,1);

--
-- [用户]
--
insert into sys_user (id, loginname, name, password, sex, age, usertype,isdefault,state,createdatetime,organization_id) values(1,'admin','超级管理员','21232f297a57a5a743894a0e4a801fc3',0,18,0,0,0,'2012-06-04 01:00:00',1);


--
-- [机构]
--
insert into sys_organization(id,name,address,code,icon,pid,seq,createdatetime) values(1,'JAVA快速开发框架','地址','01','icon-company',null,0,'2014-02-19 01:00:00');


